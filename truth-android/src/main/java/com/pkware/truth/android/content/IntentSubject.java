/*
 * Copyright 2013 Square, Inc.
 * Copyright 2016 PKWARE, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.pkware.truth.android.content;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;
import com.pkware.truth.android.net.UriSubject;
import com.pkware.truth.android.os.BundleSubject;

import java.util.Locale;

import static android.content.Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT;
import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK;
import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;
import static android.content.Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET;
import static android.content.Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS;
import static android.content.Intent.FLAG_ACTIVITY_FORWARD_RESULT;
import static android.content.Intent.FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY;
import static android.content.Intent.FLAG_ACTIVITY_MULTIPLE_TASK;
import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;
import static android.content.Intent.FLAG_ACTIVITY_NO_ANIMATION;
import static android.content.Intent.FLAG_ACTIVITY_NO_HISTORY;
import static android.content.Intent.FLAG_ACTIVITY_NO_USER_ACTION;
import static android.content.Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP;
import static android.content.Intent.FLAG_ACTIVITY_REORDER_TO_FRONT;
import static android.content.Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED;
import static android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP;
import static android.content.Intent.FLAG_ACTIVITY_TASK_ON_HOME;
import static android.content.Intent.FLAG_DEBUG_LOG_RESOLUTION;
import static android.content.Intent.FLAG_FROM_BACKGROUND;
import static android.content.Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION;
import static android.content.Intent.FLAG_GRANT_READ_URI_PERMISSION;
import static android.content.Intent.FLAG_GRANT_WRITE_URI_PERMISSION;
import static android.content.Intent.FLAG_INCLUDE_STOPPED_PACKAGES;
import static android.content.Intent.FLAG_RECEIVER_NO_ABORT;
import static android.content.Intent.FLAG_RECEIVER_REGISTERED_ONLY;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assert_;
import static com.pkware.truth.android.internal.IntegerUtils.buildBitMaskString;

/**
 * Propositions for {@link Intent} subjects.
 */
public class IntentSubject extends Subject<IntentSubject, Intent> {
  protected IntentSubject(FailureStrategy failureStrategy, Intent subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<IntentSubject, Intent> type() {
    return new SubjectFactory<IntentSubject, Intent>() {
      @Override
      public IntentSubject getSubject(FailureStrategy fs, Intent that) {
        return new IntentSubject(fs, that);
      }
    };
  }

  public static String flagsToString(@IntentFlags int flags) {
    return buildBitMaskString(flags)
        .flag(FLAG_GRANT_PERSISTABLE_URI_PERMISSION, "grant_persistable_uri_permission")
        .flag(FLAG_GRANT_READ_URI_PERMISSION, "grant_read_uri_permission")
        .flag(FLAG_GRANT_WRITE_URI_PERMISSION, "grant_write_uri_permission")
        .flag(FLAG_DEBUG_LOG_RESOLUTION, "debug_log_resolution")
        .flag(FLAG_FROM_BACKGROUND, "from_background")
        .flag(FLAG_ACTIVITY_BROUGHT_TO_FRONT, "activity_brought_to_front")
        .flag(FLAG_ACTIVITY_CLEAR_TASK, "activity_clear_task")
        .flag(FLAG_ACTIVITY_CLEAR_TOP, "activity_clear_top")
        .flag(FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET, "activity_clear_when_task_reset")
        .flag(FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS, "activity_exclude_from_recents")
        .flag(FLAG_ACTIVITY_FORWARD_RESULT, "activity_forward_result")
        .flag(FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY, "activity_launched_from_history")
        .flag(FLAG_ACTIVITY_MULTIPLE_TASK, "activity_multiple_task")
        .flag(FLAG_ACTIVITY_NEW_TASK, "activity_new_task")
        .flag(FLAG_ACTIVITY_NO_ANIMATION, "activity_no_animation")
        .flag(FLAG_ACTIVITY_NO_HISTORY, "activity_no_history")
        .flag(FLAG_RECEIVER_NO_ABORT, "receiver_no_abort")
        .flag(FLAG_RECEIVER_REGISTERED_ONLY, "receiver_registered_only")
        .flag(FLAG_ACTIVITY_NO_USER_ACTION, "activity_no_user_action")
        .flag(FLAG_ACTIVITY_PREVIOUS_IS_TOP, "activity_previous_is_top")
        .flag(FLAG_ACTIVITY_RESET_TASK_IF_NEEDED, "activity_reset_task_if")
        .flag(FLAG_ACTIVITY_REORDER_TO_FRONT, "activity_reorder_to_front")
        .flag(FLAG_ACTIVITY_SINGLE_TOP, "activity_single_top")
        .flag(FLAG_ACTIVITY_TASK_ON_HOME, "activity_task_on_home")
        .flag(FLAG_INCLUDE_STOPPED_PACKAGES, "include_stopped_packages")
        .get();
  }

  public IntentSubject hasAction(String action) {
    assertThat(actual().getAction())
        .named("action")
        .isEqualTo(action);
    return this;
  }

  public IntentSubject hasType(String type) {
    assertThat(actual().getType())
        .named("type")
        .isEqualTo(type);
    return this;
  }

  public IntentSubject hasExtra(String name) {
    assertThat(actual().hasExtra(name))
        .named(String.format(Locale.ENGLISH, "has extra <%s>", name))
        .isTrue();
    return this;
  }

  public IntentSubject hasExtra(String name, Object expectedValue) {
    hasExtra(name);
    Bundle extras = actual().getExtras();
    assert_().about(BundleSubject.type()).that(extras)
        .hasValue(name, expectedValue);
    return this;
  }

  public IntentSubject hasFlags(@IntentFlags int flags) {
    int actualFlags = actual().getFlags();
    //noinspection ResourceType
    assert_()
        .withFailureMessage("Expected <%s> but was <%s>.", flagsToString(flags), flagsToString(actualFlags))
        .that(actualFlags)
        .isEqualTo(flags);
    return this;
  }

  public IntentSubject hasData(String uri) {
    return hasData(Uri.parse(uri));
  }

  public IntentSubject hasData(Uri uri) {
    assert_().about(UriSubject.type())
        .that(actual().getData())
        .named("data")
        .isEqualTo(uri);
    return this;
  }

  public IntentSubject hasComponent(ComponentName expected) {
    ComponentName componentName = actual().getComponent();
    assert_()
        .withFailureMessage("Expected component name <%s> but was <%s>.", expected.flattenToString(), componentName.flattenToString())
        .that(componentName)
        .isEqualTo(expected);
    return this;
  }

  public IntentSubject hasComponent(Context context, Class<?> cls) {
    return hasComponent(new ComponentName(context, cls.getName()));
  }

  public IntentSubject hasComponent(String appPkg, Class<?> cls) {
    return hasComponent(new ComponentName(appPkg, cls.getName()));
  }
}
