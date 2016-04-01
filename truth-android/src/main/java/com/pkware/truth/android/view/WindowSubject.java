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

import android.view.View;
import android.view.Window;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static android.view.Window.FEATURE_ACTION_BAR;
import static android.view.Window.FEATURE_ACTION_BAR_OVERLAY;
import static android.view.Window.FEATURE_ACTION_MODE_OVERLAY;
import static android.view.Window.FEATURE_CONTEXT_MENU;
import static android.view.Window.FEATURE_CUSTOM_TITLE;
import static android.view.Window.FEATURE_INDETERMINATE_PROGRESS;
import static android.view.Window.FEATURE_LEFT_ICON;
import static android.view.Window.FEATURE_NO_TITLE;
import static android.view.Window.FEATURE_OPTIONS_PANEL;
import static android.view.Window.FEATURE_PROGRESS;
import static android.view.Window.FEATURE_RIGHT_ICON;
import static android.view.Window.FEATURE_SWIPE_TO_DISMISS;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assert_;
import static com.pkware.truth.android.internal.IntegerUtils.buildNamedValueString;

/**
 * Propositions for {@link Window} subjects.
 */
public class WindowSubject extends Subject<WindowSubject, Window> {
  protected WindowSubject(FailureStrategy failureStrategy, Window subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<WindowSubject, Window> type() {
    return new SubjectFactory<WindowSubject, Window>() {
      @Override
      public WindowSubject getSubject(FailureStrategy fs, Window that) {
        return new WindowSubject(fs, that);
      }
    };
  }

  public static String featureToString(@WindowFeature int feature) {
    return buildNamedValueString(feature)
        .value(FEATURE_ACTION_BAR, "actionBar")
        .value(FEATURE_ACTION_BAR_OVERLAY, "actionBarOverlay")
        .value(FEATURE_ACTION_MODE_OVERLAY, "actionModeOverlay")
        .value(FEATURE_CONTEXT_MENU, "contextMenu")
        .value(FEATURE_CUSTOM_TITLE, "customTitle")
        .value(FEATURE_INDETERMINATE_PROGRESS, "indeterminateProgress")
        .value(FEATURE_LEFT_ICON, "leftIcon")
        .value(FEATURE_NO_TITLE, "noTitle")
        .value(FEATURE_OPTIONS_PANEL, "optionalPanel")
        .value(FEATURE_PROGRESS, "progress")
        .value(FEATURE_RIGHT_ICON, "rightIcon")
        .value(FEATURE_SWIPE_TO_DISMISS, "swipeToDismiss")
        .get();
  }

  public WindowSubject hasCurrentFocus(View view) {
    assertThat(getSubject().getCurrentFocus())
        .named("current focused view")
        .isSameAs(view);
    return this;
  }

  public WindowSubject hasChildren() {
    assertThat(getSubject().hasChildren())
        .named("has children")
        .isTrue();
    return this;
  }

  public WindowSubject hasNoChildren() {
    assertThat(getSubject().hasChildren())
        .named("has children")
        .isFalse();
    return this;
  }

  public WindowSubject hasFeature(@WindowFeature int feature) {
    //noinspection ResourceType
    assert_()
        .withFailureMessage("Expected feature <%s> but was not present.",
            featureToString(feature))
        .that(getSubject().hasFeature(feature))
        .isTrue();
    return this;
  }

  public WindowSubject isActive() {
    assertThat(getSubject().isActive())
        .named("is active")
        .isTrue();
    return this;
  }

  public WindowSubject isNotActive() {
    assertThat(getSubject().isActive())
        .named("is active")
        .isFalse();
    return this;
  }

  public WindowSubject isFloating() {
    assertThat(getSubject().isFloating())
        .named("is floating")
        .isTrue();
    return this;
  }

  public WindowSubject isNotFloating() {
    assertThat(getSubject().isFloating())
        .named("is floating")
        .isFalse();
    return this;
  }
}
