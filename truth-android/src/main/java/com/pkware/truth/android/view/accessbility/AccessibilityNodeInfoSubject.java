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

  public AccessibilityNodeInfoSubject hasActions(int actions) {
    check("getActions()").that(actual.getActions()).isEqualTo(actions);
    return this;
  }

  public AccessibilityNodeInfoSubject hasChildCount(int count) {
    check("getChildCount()").that(actual.getChildCount()).isEqualTo(count);
    return this;
  }

  public AccessibilityNodeInfoSubject hasClassName(@Nullable String name) {
    check("getClassName()")
        .that(actual.getClassName().toString())
        .isEqualTo(name);
    return this;
  }

  public AccessibilityNodeInfoSubject hasContentDescription(@Nullable String description) {
    check("getContentDescription()")
        .that(actual.getContentDescription().toString())
        .isEqualTo(description);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public AccessibilityNodeInfoSubject hasMovementGranularities(int granularities) {
    check("getMovementGranularities()").that(actual.getMovementGranularities()).isEqualTo(granularities);
    return this;
  }

  public AccessibilityNodeInfoSubject hasPackageName(@Nullable String name) {
    check("getPackageName()")
        .that(actual.getPackageName().toString())
        .isEqualTo(name);
    return this;
  }

  public AccessibilityNodeInfoSubject hasText(@Nullable String text) {
    check("getText()")
        .that(actual.getText().toString())
        .isEqualTo(text);
    return this;
  }

  @TargetApi(JELLY_BEAN_MR2)
  public AccessibilityNodeInfoSubject hasTextSelectionStart(int position) {
    check("getTextSelectionStart()").that(actual.getTextSelectionStart()).isEqualTo(position);
    return this;
  }

  @TargetApi(JELLY_BEAN_MR2)
  public AccessibilityNodeInfoSubject hasTextSelectionEnd(int position) {
    check("getTextSelectionEnd()").that(actual.getTextSelectionEnd()).isEqualTo(position);
    return this;
  }

  @TargetApi(JELLY_BEAN_MR2)
  public AccessibilityNodeInfoSubject hasViewIdResourceName(@Nullable String name) {
    check("getViewIdResourceName()").that(actual.getViewIdResourceName()).isEqualTo(name);
    return this;
  }

  public AccessibilityNodeInfoSubject hasWindowId(int id) {
    check("getWindowId()").that(actual.getWindowId()).isEqualTo(id);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public AccessibilityNodeInfoSubject isAccessibilityFocused() {
    check("isAccessibilityFocused()").that(actual.isAccessibilityFocused()).isTrue();
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public AccessibilityNodeInfoSubject isNotAccessibilityFocused() {
    check("isAccessibilityFocused()").that(actual.isAccessibilityFocused()).isFalse();
    return this;
  }

  public AccessibilityNodeInfoSubject isCheckable() {
    check("isCheckable()").that(actual.isCheckable()).isTrue();
    return this;
  }

  public AccessibilityNodeInfoSubject isNotCheckable() {
    check("isCheckable()").that(actual.isCheckable()).isFalse();
    return this;
  }

  public AccessibilityNodeInfoSubject isChecked() {
    check("isChecked()").that(actual.isChecked()).isTrue();
    return this;
  }

  public AccessibilityNodeInfoSubject isNotChecked() {
    check("isChecked()").that(actual.isChecked()).isFalse();
    return this;
  }

  public AccessibilityNodeInfoSubject isClickable() {
    check("isClickable()").that(actual.isClickable()).isTrue();
    return this;
  }

  public AccessibilityNodeInfoSubject isNotClickable() {
    check("isClickable()").that(actual.isClickable()).isFalse();
    return this;
  }

  @TargetApi(JELLY_BEAN_MR2)
  public AccessibilityNodeInfoSubject isEditable() {
    check("isEditable()").that(actual.isEditable()).isTrue();
    return this;
  }

  @TargetApi(JELLY_BEAN_MR2)
  public AccessibilityNodeInfoSubject isNotEditable() {
    check("isEditable()").that(actual.isEditable()).isFalse();
    return this;
  }

  public AccessibilityNodeInfoSubject isEnabled() {
    check("isEnabled()").that(actual.isEnabled()).isTrue();
    return this;
  }

  public AccessibilityNodeInfoSubject isNotEnabled() {
    check("isEnabled()").that(actual.isEnabled()).isFalse();
    return this;
  }

  public AccessibilityNodeInfoSubject isFocusable() {
    check("isFocusable()").that(actual.isFocusable()).isTrue();
    return this;
  }

  public AccessibilityNodeInfoSubject isNotFocusable() {
    check("isFocusable()").that(actual.isFocusable()).isFalse();
    return this;
  }

  public AccessibilityNodeInfoSubject isFocused() {
    check("isFocused()").that(actual.isFocused()).isTrue();
    return this;
  }

  public AccessibilityNodeInfoSubject isNotFocused() {
    check("isFocused()").that(actual.isFocused()).isFalse();
    return this;
  }

  public AccessibilityNodeInfoSubject isLongClickable() {
    check("isLongClickable()").that(actual.isLongClickable()).isTrue();
    return this;
  }

  public AccessibilityNodeInfoSubject isNotLongClickable() {
    check("isLongClickable()").that(actual.isLongClickable()).isFalse();
    return this;
  }

  public AccessibilityNodeInfoSubject isPassword() {
    check("isPassword()").that(actual.isPassword()).isTrue();
    return this;
  }

  public AccessibilityNodeInfoSubject isNotPassword() {
    check("isPassword()").that(actual.isPassword()).isFalse();
    return this;
  }

  public AccessibilityNodeInfoSubject isScrollable() {
    check("isScrollable()").that(actual.isScrollable()).isTrue();
    return this;
  }

  public AccessibilityNodeInfoSubject isNotScrollable() {
    check("isScrollable()").that(actual.isScrollable()).isFalse();
    return this;
  }

  public AccessibilityNodeInfoSubject isSelected() {
    check("isSelected()").that(actual.isSelected()).isTrue();
    return this;
  }

  public AccessibilityNodeInfoSubject isNotSelected() {
    check("isSelected()").that(actual.isSelected()).isFalse();
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public AccessibilityNodeInfoSubject isVisibleToUser() {
    check("isVisibleToUser()").that(actual.isVisibleToUser()).isTrue();
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public AccessibilityNodeInfoSubject isNotVisibleToUser() {
    check("isVisibleToUser()").that(actual.isVisibleToUser()).isFalse();
    return this;
  }
}
