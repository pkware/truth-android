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

  public void hasAnimationStyle(int style) {
    check("getAnimationStyle()").that(actual.getAnimationStyle()).isEqualTo(style);
  }

  public void hasBackground(@Nullable Drawable background) {
    check("getBackground()").that(actual.getBackground()).isSameInstanceAs(background);
  }

  public void hasContentView(@Nullable View view) {
    check("getContentView()").that(actual.getContentView()).isSameInstanceAs(view);
  }

  public void hasHeight(int height) {
    check("getHeight()").that(actual.getHeight()).isEqualTo(height);
  }

  public void hasInputMethodMode(@PopupWindowInputMethodMode int mode) {
    int actualMode = actual.getInputMethodMode();
    //noinspection ResourceType
    check("getInputMethodMode()")
        .withMessage("Expected input method mode <%s> but was <%s>.",
            inputMethodModeToString(mode), inputMethodModeToString(actualMode))
        .that(actualMode)
        .isEqualTo(mode);
  }

  public void hasSoftInputMode(int mode) {
    check("getSoftInputMode()").that(actual.getSoftInputMode()).isEqualTo(mode);
  }

  public void hasWidth(int width) {
    check("getWidth()").that(actual.getWidth()).isEqualTo(width);
  }

  public void isAboveAnchor() {
    check("isAboveAnchor()").that(actual.isAboveAnchor()).isTrue();
  }

  public void isNotAboveAnchor() {
    check("isAboveAnchor()").that(actual.isAboveAnchor()).isFalse();
  }

  public void isClippingEnabled() {
    check("isClippingEnabled()").that(actual.isClippingEnabled()).isTrue();
  }

  public void isClippingDisabled() {
    check("isClippingEnabled()").that(actual.isClippingEnabled()).isFalse();
  }

  public void isFocusable() {
    check("isFocusable()").that(actual.isFocusable()).isTrue();
  }

  public void isNotFocusable() {
    check("isFocusable()").that(actual.isFocusable()).isFalse();
  }

  public void isTouchableOutside() {
    check("isOutsideTouchable()").that(actual.isOutsideTouchable()).isTrue();
  }

  public void isNotTouchableOutside() {
    check("isOutsideTouchable()").that(actual.isOutsideTouchable()).isFalse();
  }

  public void isShowing() {
    check("isShowing()").that(actual.isShowing()).isTrue();
  }

  public void isNotShowing() {
    check("isShowing()").that(actual.isShowing()).isFalse();
  }

  public void isSplitTouchEnabled() {
    check("isSplitTouchEnabled()").that(actual.isSplitTouchEnabled()).isTrue();
  }

  public void isSplitTouchDisabled() {
    check("isSplitTouchEnabled()")
        .withMessage("is split touch disabled")
        .that(actual.isSplitTouchEnabled()).isFalse();
  }

  public void isTouchable() {
    check("isTouchable()").that(actual.isTouchable()).isTrue();
  }

  public void isNotTouchable() {
    check("isTouchable()").that(actual.isTouchable()).isFalse();
  }
}
