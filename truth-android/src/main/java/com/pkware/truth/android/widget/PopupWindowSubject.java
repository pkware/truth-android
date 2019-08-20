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
package com.pkware.truth.android.widget;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.PopupWindow;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static com.pkware.truth.android.internal.IntegerUtils.buildNamedValueString;

/**
 * Propositions for {@link PopupWindow} subjects.
 */
public class PopupWindowSubject extends Subject {

  @Nullable
  private final PopupWindow actual;

  public PopupWindowSubject(@Nonnull FailureMetadata failureMetadata, @Nullable PopupWindow actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  @Nonnull
  public static String inputMethodModeToString(@PopupWindowInputMethodMode int mode) {
    return buildNamedValueString(mode)
        .value(PopupWindow.INPUT_METHOD_FROM_FOCUSABLE, "fromFocusable")
        .value(PopupWindow.INPUT_METHOD_NEEDED, "needed")
        .value(PopupWindow.INPUT_METHOD_NOT_NEEDED, "notNeeded")
        .get();
  }

  public PopupWindowSubject hasAnimationStyle(int style) {
    check("getAnimationStyle()").that(actual.getAnimationStyle()).isEqualTo(style);
    return this;
  }

  public PopupWindowSubject hasBackground(@Nullable Drawable background) {
    check("getBackground()").that(actual.getBackground()).isSameInstanceAs(background);
    return this;
  }

  public PopupWindowSubject hasContentView(@Nullable View view) {
    check("getContentView()").that(actual.getContentView()).isSameInstanceAs(view);
    return this;
  }

  public PopupWindowSubject hasHeight(int height) {
    check("getHeight()").that(actual.getHeight()).isEqualTo(height);
    return this;
  }

  public PopupWindowSubject hasInputMethodMode(@PopupWindowInputMethodMode int mode) {
    int actualMode = actual.getInputMethodMode();
    //noinspection ResourceType
    check("getInputMethodMode()")
        .withMessage("Expected input method mode <%s> but was <%s>.",
            inputMethodModeToString(mode), inputMethodModeToString(actualMode))
        .that(actualMode)
        .isEqualTo(mode);
    return this;
  }

  public PopupWindowSubject hasSoftInputMode(int mode) {
    check("getSoftInputMode()").that(actual.getSoftInputMode()).isEqualTo(mode);
    return this;
  }

  public PopupWindowSubject hasWidth(int width) {
    check("getWidth()").that(actual.getWidth()).isEqualTo(width);
    return this;
  }

  public PopupWindowSubject isAboveAnchor() {
    check("isAboveAnchor()").that(actual.isAboveAnchor()).isTrue();
    return this;
  }

  public PopupWindowSubject isNotAboveAnchor() {
    check("isAboveAnchor()").that(actual.isAboveAnchor()).isFalse();
    return this;
  }

  public PopupWindowSubject isClippingEnabled() {
    check("isClippingEnabled()").that(actual.isClippingEnabled()).isTrue();
    return this;
  }

  public PopupWindowSubject isClippingDisabled() {
    check("isClippingEnabled()").that(actual.isClippingEnabled()).isFalse();
    return this;
  }

  public PopupWindowSubject isFocusable() {
    check("isFocusable()").that(actual.isFocusable()).isTrue();
    return this;
  }

  public PopupWindowSubject isNotFocusable() {
    check("isFocusable()").that(actual.isFocusable()).isFalse();
    return this;
  }

  public PopupWindowSubject isTouchableOutside() {
    check("isOutsideTouchable()").that(actual.isOutsideTouchable()).isTrue();
    return this;
  }

  public PopupWindowSubject isNotTouchableOutside() {
    check("isOutsideTouchable()").that(actual.isOutsideTouchable()).isFalse();
    return this;
  }

  public PopupWindowSubject isShowing() {
    check("isShowing()").that(actual.isShowing()).isTrue();
    return this;
  }

  public PopupWindowSubject isNotShowing() {
    check("isShowing()").that(actual.isShowing()).isFalse();
    return this;
  }

  public PopupWindowSubject isSplitTouchEnabled() {
    check("isSplitTouchEnabled()").that(actual.isSplitTouchEnabled()).isTrue();
    return this;
  }

  public PopupWindowSubject isSplitTouchDisabled() {
    check("isSplitTouchEnabled()")
        .withMessage("is split touch disabled")
        .that(actual.isSplitTouchEnabled()).isFalse();
    return this;
  }

  public PopupWindowSubject isTouchable() {
    check("isTouchable()").that(actual.isTouchable()).isTrue();
    return this;
  }

  public PopupWindowSubject isNotTouchable() {
    check("isTouchable()").that(actual.isTouchable()).isFalse();
    return this;
  }
}
