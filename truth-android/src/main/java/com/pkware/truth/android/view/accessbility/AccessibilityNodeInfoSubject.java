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

import static android.os.Build.VERSION_CODES.JELLY_BEAN;
import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR2;
import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link AccessibilityNodeInfo} subjects.
 */
public class AccessibilityNodeInfoSubject extends Subject<AccessibilityNodeInfoSubject, AccessibilityNodeInfo> {
  protected AccessibilityNodeInfoSubject(FailureMetadata failureMetadata, AccessibilityNodeInfo subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<AccessibilityNodeInfoSubject, AccessibilityNodeInfo> type() {
    return AccessibilityNodeInfoSubject::new;
  }

  public AccessibilityNodeInfoSubject hasActions(int actions) {
    assertThat(actual().getActions())
        .named("actions")
        .isEqualTo(actions);
    return this;
  }

  public AccessibilityNodeInfoSubject hasChildCount(int count) {
    assertThat(actual().getChildCount())
        .named("child count")
        .isEqualTo(count);
    return this;
  }

  public AccessibilityNodeInfoSubject hasClassName(String name) {
    assertThat(actual().getClassName().toString())
        .named("class name")
        .isEqualTo(name);
    return this;
  }

  public AccessibilityNodeInfoSubject hasContentDescription(String description) {
    assertThat(actual().getContentDescription().toString())
        .named("content description")
        .isEqualTo(description);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public AccessibilityNodeInfoSubject hasMovementGranularities(int granularities) {
    assertThat(actual().getMovementGranularities())
        .named("movement granularities")
        .isEqualTo(granularities);
    return this;
  }

  public AccessibilityNodeInfoSubject hasPackageName(String name) {
    assertThat(actual().getPackageName().toString())
        .named("package name")
        .isEqualTo(name);
    return this;
  }

  public AccessibilityNodeInfoSubject hasText(String text) {
    assertThat(actual().getText().toString())
        .named("text")
        .isEqualTo(text);
    return this;
  }

  @TargetApi(JELLY_BEAN_MR2)
  public AccessibilityNodeInfoSubject hasTextSelectionStart(int position) {
    assertThat(actual().getTextSelectionStart())
        .named("text selection start")
        .isEqualTo(position);
    return this;
  }

  @TargetApi(JELLY_BEAN_MR2)
  public AccessibilityNodeInfoSubject hasTextSelectionEnd(int position) {
    assertThat(actual().getTextSelectionEnd())
        .named("text selection end")
        .isEqualTo(position);
    return this;
  }

  @TargetApi(JELLY_BEAN_MR2)
  public AccessibilityNodeInfoSubject hasViewIdResourceName(String name) {
    assertThat(actual().getViewIdResourceName())
        .named("view ID resource name")
        .isEqualTo(name);
    return this;
  }

  public AccessibilityNodeInfoSubject hasWindowId(int id) {
    assertThat(actual().getWindowId())
        .named("window ID")
        .isEqualTo(id);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public AccessibilityNodeInfoSubject isAccessibilityFocused() {
    assertThat(actual().isAccessibilityFocused())
        .named("is accessibility focused")
        .isTrue();
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public AccessibilityNodeInfoSubject isNotAccessibilityFocused() {
    assertThat(actual().isAccessibilityFocused())
        .named("is accessibility focused")
        .isFalse();
    return this;
  }

  public AccessibilityNodeInfoSubject isCheckable() {
    assertThat(actual().isCheckable())
        .named("is checkable")
        .isTrue();
    return this;
  }

  public AccessibilityNodeInfoSubject isNotCheckable() {
    assertThat(actual().isCheckable())
        .named("is checkable")
        .isFalse();
    return this;
  }

  public AccessibilityNodeInfoSubject isChecked() {
    assertThat(actual().isChecked())
        .named("is checked")
        .isTrue();
    return this;
  }

  public AccessibilityNodeInfoSubject isNotChecked() {
    assertThat(actual().isChecked())
        .named("is checked")
        .isFalse();
    return this;
  }

  public AccessibilityNodeInfoSubject isClickable() {
    assertThat(actual().isClickable())
        .named("is clickable")
        .isTrue();
    return this;
  }

  public AccessibilityNodeInfoSubject isNotClickable() {
    assertThat(actual().isClickable())
        .named("is clickable")
        .isFalse();
    return this;
  }

  @TargetApi(JELLY_BEAN_MR2)
  public AccessibilityNodeInfoSubject isEditable() {
    assertThat(actual().isEditable())
        .named("is editable")
        .isTrue();
    return this;
  }

  @TargetApi(JELLY_BEAN_MR2)
  public AccessibilityNodeInfoSubject isNotEditable() {
    assertThat(actual().isEditable())
        .named("is editable")
        .isFalse();
    return this;
  }

  public AccessibilityNodeInfoSubject isEnabled() {
    assertThat(actual().isEnabled())
        .named("is enabled")
        .isTrue();
    return this;
  }

  public AccessibilityNodeInfoSubject isNotEnabled() {
    assertThat(actual().isEnabled())
        .named("is enabled")
        .isFalse();
    return this;
  }

  public AccessibilityNodeInfoSubject isFocusable() {
    assertThat(actual().isFocusable())
        .named("is focusable")
        .isTrue();
    return this;
  }

  public AccessibilityNodeInfoSubject isNotFocusable() {
    assertThat(actual().isFocusable())
        .named("is focusable")
        .isFalse();
    return this;
  }

  public AccessibilityNodeInfoSubject isFocused() {
    assertThat(actual().isFocused())
        .named("is focused")
        .isTrue();
    return this;
  }

  public AccessibilityNodeInfoSubject isNotFocused() {
    assertThat(actual().isFocused())
        .named("is focused")
        .isFalse();
    return this;
  }

  public AccessibilityNodeInfoSubject isLongClickable() {
    assertThat(actual().isLongClickable())
        .named("is long clickable")
        .isTrue();
    return this;
  }

  public AccessibilityNodeInfoSubject isNotLongClickable() {
    assertThat(actual().isLongClickable())
        .named("is long clickable")
        .isFalse();
    return this;
  }

  public AccessibilityNodeInfoSubject isPassword() {
    assertThat(actual().isPassword())
        .named("is password")
        .isTrue();
    return this;
  }

  public AccessibilityNodeInfoSubject isNotPassword() {
    assertThat(actual().isPassword())
        .named("is password")
        .isFalse();
    return this;
  }

  public AccessibilityNodeInfoSubject isScrollable() {
    assertThat(actual().isScrollable())
        .named("is scrollable")
        .isTrue();
    return this;
  }

  public AccessibilityNodeInfoSubject isNotScrollable() {
    assertThat(actual().isScrollable())
        .named("is scrollable")
        .isFalse();
    return this;
  }

  public AccessibilityNodeInfoSubject isSelected() {
    assertThat(actual().isSelected())
        .named("is selected")
        .isTrue();
    return this;
  }

  public AccessibilityNodeInfoSubject isNotSelected() {
    assertThat(actual().isSelected())
        .named("is selected")
        .isFalse();
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public AccessibilityNodeInfoSubject isVisibleToUser() {
    assertThat(actual().isVisibleToUser())
        .named("is visible to user")
        .isTrue();
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public AccessibilityNodeInfoSubject isNotVisibleToUser() {
    assertThat(actual().isVisibleToUser())
        .named("is visible to user")
        .isFalse();
    return this;
  }
}
