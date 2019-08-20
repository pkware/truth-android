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
package com.pkware.truth.android.view;

import android.view.View;
import android.view.Window;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

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
import static com.pkware.truth.android.internal.IntegerUtils.buildNamedValueString;

/**
 * Propositions for {@link Window} subjects.
 */
public class WindowSubject extends Subject {

  @Nullable
  private final Window actual;

  public WindowSubject(@Nonnull FailureMetadata failureMetadata, @Nullable Window actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  @Nonnull
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

  public WindowSubject hasCurrentFocus(@Nullable View view) {
    check("getCurrentFocus()").that(actual.getCurrentFocus()).isSameInstanceAs(view);
    return this;
  }

  public WindowSubject hasChildren() {
    check("hasChildren()").that(actual.hasChildren()).isTrue();
    return this;
  }

  public WindowSubject hasNoChildren() {
    check("hasChildren()").that(actual.hasChildren()).isFalse();
    return this;
  }

  public WindowSubject hasFeature(@WindowFeature int feature) {
    //noinspection ResourceType
    check("hasFeature(feature)")
        .withMessage("Expected feature <%s> but was not present.",
            featureToString(feature))
        .that(actual.hasFeature(feature))
        .isTrue();
    return this;
  }

  public WindowSubject isActive() {
    check("isActive()").that(actual.isActive()).isTrue();
    return this;
  }

  public WindowSubject isNotActive() {
    check("isActive()").that(actual.isActive()).isFalse();
    return this;
  }

  public WindowSubject isFloating() {
    check("isFloating()").that(actual.isFloating()).isTrue();
    return this;
  }

  public WindowSubject isNotFloating() {
    check("isFloating()").that(actual.isFloating()).isFalse();
    return this;
  }
}
