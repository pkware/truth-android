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
package com.pkware.truth.android.view.accessbility;

import android.annotation.TargetApi;
import android.view.accessibility.AccessibilityNodeInfo;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.os.Build.VERSION_CODES.JELLY_BEAN;
import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR2;

/**
 * Propositions for {@link AccessibilityNodeInfo} subjects.
 */
public class AccessibilityNodeInfoSubject extends Subject {

  @Nullable
  private final AccessibilityNodeInfo actual;

  public AccessibilityNodeInfoSubject(@Nonnull FailureMetadata failureMetadata, @Nullable AccessibilityNodeInfo actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasActions(int actions) {
    check("getActions()").that(actual.getActions()).isEqualTo(actions);
  }

  public void hasChildCount(int count) {
    check("getChildCount()").that(actual.getChildCount()).isEqualTo(count);
  }

  public void hasClassName(@Nullable String name) {
    check("getClassName()")
        .that(actual.getClassName().toString())
        .isEqualTo(name);
  }

  public void hasContentDescription(@Nullable String description) {
    check("getContentDescription()")
        .that(actual.getContentDescription().toString())
        .isEqualTo(description);
  }

  @TargetApi(JELLY_BEAN)
  public void hasMovementGranularities(int granularities) {
    check("getMovementGranularities()").that(actual.getMovementGranularities()).isEqualTo(granularities);
  }

  public void hasPackageName(@Nullable String name) {
    check("getPackageName()")
        .that(actual.getPackageName().toString())
        .isEqualTo(name);
  }

  public void hasText(@Nullable String text) {
    check("getText()")
        .that(actual.getText().toString())
        .isEqualTo(text);
  }

  @TargetApi(JELLY_BEAN_MR2)
  public void hasTextSelectionStart(int position) {
    check("getTextSelectionStart()").that(actual.getTextSelectionStart()).isEqualTo(position);
  }

  @TargetApi(JELLY_BEAN_MR2)
  public void hasTextSelectionEnd(int position) {
    check("getTextSelectionEnd()").that(actual.getTextSelectionEnd()).isEqualTo(position);
  }

  @TargetApi(JELLY_BEAN_MR2)
  public void hasViewIdResourceName(@Nullable String name) {
    check("getViewIdResourceName()").that(actual.getViewIdResourceName()).isEqualTo(name);
  }

  public void hasWindowId(int id) {
    check("getWindowId()").that(actual.getWindowId()).isEqualTo(id);
  }

  @TargetApi(JELLY_BEAN)
  public void isAccessibilityFocused() {
    check("isAccessibilityFocused()").that(actual.isAccessibilityFocused()).isTrue();
  }

  @TargetApi(JELLY_BEAN)
  public void isNotAccessibilityFocused() {
    check("isAccessibilityFocused()").that(actual.isAccessibilityFocused()).isFalse();
  }

  public void isCheckable() {
    check("isCheckable()").that(actual.isCheckable()).isTrue();
  }

  public void isNotCheckable() {
    check("isCheckable()").that(actual.isCheckable()).isFalse();
  }

  public void isChecked() {
    check("isChecked()").that(actual.isChecked()).isTrue();
  }

  public void isNotChecked() {
    check("isChecked()").that(actual.isChecked()).isFalse();
  }

  public void isClickable() {
    check("isClickable()").that(actual.isClickable()).isTrue();
  }

  public void isNotClickable() {
    check("isClickable()").that(actual.isClickable()).isFalse();
  }

  @TargetApi(JELLY_BEAN_MR2)
  public void isEditable() {
    check("isEditable()").that(actual.isEditable()).isTrue();
  }

  @TargetApi(JELLY_BEAN_MR2)
  public void isNotEditable() {
    check("isEditable()").that(actual.isEditable()).isFalse();
  }

  public void isEnabled() {
    check("isEnabled()").that(actual.isEnabled()).isTrue();
  }

  public void isNotEnabled() {
    check("isEnabled()").that(actual.isEnabled()).isFalse();
  }

  public void isFocusable() {
    check("isFocusable()").that(actual.isFocusable()).isTrue();
  }

  public void isNotFocusable() {
    check("isFocusable()").that(actual.isFocusable()).isFalse();
  }

  public void isFocused() {
    check("isFocused()").that(actual.isFocused()).isTrue();
  }

  public void isNotFocused() {
    check("isFocused()").that(actual.isFocused()).isFalse();
  }

  public void isLongClickable() {
    check("isLongClickable()").that(actual.isLongClickable()).isTrue();
  }

  public void isNotLongClickable() {
    check("isLongClickable()").that(actual.isLongClickable()).isFalse();
  }

  public void isPassword() {
    check("isPassword()").that(actual.isPassword()).isTrue();
  }

  public void isNotPassword() {
    check("isPassword()").that(actual.isPassword()).isFalse();
  }

  public void isScrollable() {
    check("isScrollable()").that(actual.isScrollable()).isTrue();
  }

  public void isNotScrollable() {
    check("isScrollable()").that(actual.isScrollable()).isFalse();
  }

  public void isSelected() {
    check("isSelected()").that(actual.isSelected()).isTrue();
  }

  public void isNotSelected() {
    check("isSelected()").that(actual.isSelected()).isFalse();
  }

  @TargetApi(JELLY_BEAN)
  public void isVisibleToUser() {
    check("isVisibleToUser()").that(actual.isVisibleToUser()).isTrue();
  }

  @TargetApi(JELLY_BEAN)
  public void isNotVisibleToUser() {
    check("isVisibleToUser()").that(actual.isVisibleToUser()).isFalse();
  }
}
