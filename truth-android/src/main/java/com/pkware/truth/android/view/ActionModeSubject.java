/*
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
package com.pkware.truth.android.view;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.View;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.JELLY_BEAN;
import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link ActionMode} subjects.
 */
public class ActionModeSubject extends Subject<ActionModeSubject, ActionMode> {
  protected ActionModeSubject(FailureStrategy failureStrategy, ActionMode subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<ActionModeSubject, ActionMode> type() {
    return new SubjectFactory<ActionModeSubject, ActionMode>() {
      @Override
      public ActionModeSubject getSubject(FailureStrategy fs, ActionMode that) {
        return new ActionModeSubject(fs, that);
      }
    };
  }

  public ActionModeSubject hasCustomView() {
    assertThat(actual().getCustomView())
        .named("has custom view")
        .isNotNull();
    return this;
  }

  public ActionModeSubject hasCustomView(View view) {
    assertThat(actual().getCustomView())
        .named("custom view")
        .isEqualTo(view);
    return this;
  }

  public ActionModeSubject hasSubtitle(CharSequence subtitle) {
    assertThat(actual().getSubtitle())
        .named("subtitle")
        .isEqualTo(subtitle);
    return this;
  }

  public ActionModeSubject hasTag(Object tag) {
    assertThat(actual().getTag())
        .named("tag")
        .isEqualTo(tag);
    return this;
  }

  public ActionModeSubject hasTitle(CharSequence title) {
    assertThat(actual().getTitle())
        .named("title")
        .isEqualTo(title);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public ActionModeSubject hasOptionalTitleHint() {
    assertThat(actual().getTitleOptionalHint())
        .named("is title hint optional")
        .isTrue();
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public ActionModeSubject hasNonOptionalTitleHint() {
    assertThat(actual().getTitleOptionalHint())
        .named("is title hint optional")
        .isFalse();
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public ActionModeSubject hasOptionalTitle() {
    assertThat(actual().isTitleOptional())
        .named("is title optional")
        .isTrue();
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public ActionModeSubject hasNonOptionalTitle() {
    assertThat(actual().isTitleOptional())
        .named("is title optional")
        .isFalse();
    return this;
  }
}
