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
package com.pkware.truth.android.view.accessbility;

import android.annotation.TargetApi;
import android.view.accessibility.AccessibilityNodeInfo;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.JELLY_BEAN;
import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR2;
import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link AccessibilityNodeInfo} subjects.
 */
public class AccessibilityNodeInfoSubject extends Subject<AccessibilityNodeInfoSubject, AccessibilityNodeInfo> {
  protected AccessibilityNodeInfoSubject(FailureStrategy failureStrategy, AccessibilityNodeInfo subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<AccessibilityNodeInfoSubject, AccessibilityNodeInfo> type() {
    return new SubjectFactory<AccessibilityNodeInfoSubject, AccessibilityNodeInfo>() {
      @Override
      public AccessibilityNodeInfoSubject getSubject(FailureStrategy fs, AccessibilityNodeInfo that) {
        return new AccessibilityNodeInfoSubject(fs, that);
      }
    };
  }

  public AccessibilityNodeInfoSubject hasActions(int actions) {
    assertThat(getSubject().getActions())
        .named("actions")
        .isEqualTo(actions);
    return this;
  }

  public AccessibilityNodeInfoSubject hasChildCount(int count) {
    assertThat(getSubject().getChildCount())
        .named("child count")
        .isEqualTo(count);
    return this;
  }

  public AccessibilityNodeInfoSubject hasClassName(String name) {
    assertThat(getSubject().getClassName().toString())
        .named("class name")
        .isEqualTo(name);
    return this;
  }

  public AccessibilityNodeInfoSubject hasContentDescription(String description) {
    assertThat(getSubject().getContentDescription().toString())
        .named("content description")
        .isEqualTo(description);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public AccessibilityNodeInfoSubject hasMovementGranularities(int granularities) {
    assertThat(getSubject().getMovementGranularities())
        .named("movement granularities")
        .isEqualTo(granularities);
    return this;
  }

  public AccessibilityNodeInfoSubject hasPackageName(String name) {
    assertThat(getSubject().getPackageName().toString())
        .named("package name")
        .isEqualTo(name);
    return this;
  }

  public AccessibilityNodeInfoSubject hasText(String text) {
    assertThat(getSubject().getText().toString())
        .named("text")
        .isEqualTo(text);
    return this;
  }

  @TargetApi(JELLY_BEAN_MR2)
  public AccessibilityNodeInfoSubject hasTextSelectionStart(int position) {
    assertThat(getSubject().getTextSelectionStart())
        .named("text selection start")
        .isEqualTo(position);
    return this;
  }

  @TargetApi(JELLY_BEAN_MR2)
  public AccessibilityNodeInfoSubject hasTextSelectionEnd(int position) {
    assertThat(getSubject().getTextSelectionEnd())
        .named("text selection end")
        .isEqualTo(position);
    return this;
  }

  @TargetApi(JELLY_BEAN_MR2)
  public AccessibilityNodeInfoSubject hasViewIdResourceName(String name) {
    assertThat(getSubject().getViewIdResourceName())
        .named("view ID resource name")
        .isEqualTo(name);
    return this;
  }

  public AccessibilityNodeInfoSubject hasWindowId(int id) {
    assertThat(getSubject().getWindowId())
        .named("window ID")
        .isEqualTo(id);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public AccessibilityNodeInfoSubject isAccessibilityFocused() {
    assertThat(getSubject().isAccessibilityFocused())
        .named("is accessibility focused")
        .isTrue();
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public AccessibilityNodeInfoSubject isNotAccessibilityFocused() {
    assertThat(getSubject().isAccessibilityFocused())
        .named("is accessibility focused")
        .isFalse();
    return this;
  }

  public AccessibilityNodeInfoSubject isCheckable() {
    assertThat(getSubject().isCheckable())
        .named("is checkable")
        .isTrue();
    return this;
  }

  public AccessibilityNodeInfoSubject isNotCheckable() {
    assertThat(getSubject().isCheckable())
        .named("is checkable")
        .isFalse();
    return this;
  }

  public AccessibilityNodeInfoSubject isChecked() {
    assertThat(getSubject().isChecked())
        .named("is checked")
        .isTrue();
    return this;
  }

  public AccessibilityNodeInfoSubject isNotChecked() {
    assertThat(getSubject().isChecked())
        .named("is checked")
        .isFalse();
    return this;
  }

  public AccessibilityNodeInfoSubject isClickable() {
    assertThat(getSubject().isClickable())
        .named("is clickable")
        .isTrue();
    return this;
  }

  public AccessibilityNodeInfoSubject isNotClickable() {
    assertThat(getSubject().isClickable())
        .named("is clickable")
        .isFalse();
    return this;
  }

  @TargetApi(JELLY_BEAN_MR2)
  public AccessibilityNodeInfoSubject isEditable() {
    assertThat(getSubject().isEditable())
        .named("is editable")
        .isTrue();
    return this;
  }

  @TargetApi(JELLY_BEAN_MR2)
  public AccessibilityNodeInfoSubject isNotEditable() {
    assertThat(getSubject().isEditable())
        .named("is editable")
        .isFalse();
    return this;
  }

  public AccessibilityNodeInfoSubject isEnabled() {
    assertThat(getSubject().isEnabled())
        .named("is enabled")
        .isTrue();
    return this;
  }

  public AccessibilityNodeInfoSubject isNotEnabled() {
    assertThat(getSubject().isEnabled())
        .named("is enabled")
        .isFalse();
    return this;
  }

  public AccessibilityNodeInfoSubject isFocusable() {
    assertThat(getSubject().isFocusable())
        .named("is focusable")
        .isTrue();
    return this;
  }

  public AccessibilityNodeInfoSubject isNotFocusable() {
    assertThat(getSubject().isFocusable())
        .named("is focusable")
        .isFalse();
    return this;
  }

  public AccessibilityNodeInfoSubject isFocused() {
    assertThat(getSubject().isFocused())
        .named("is focused")
        .isTrue();
    return this;
  }

  public AccessibilityNodeInfoSubject isNotFocused() {
    assertThat(getSubject().isFocused())
        .named("is focused")
        .isFalse();
    return this;
  }

  public AccessibilityNodeInfoSubject isLongClickable() {
    assertThat(getSubject().isLongClickable())
        .named("is long clickable")
        .isTrue();
    return this;
  }

  public AccessibilityNodeInfoSubject isNotLongClickable() {
    assertThat(getSubject().isLongClickable())
        .named("is long clickable")
        .isFalse();
    return this;
  }

  public AccessibilityNodeInfoSubject isPassword() {
    assertThat(getSubject().isPassword())
        .named("is password")
        .isTrue();
    return this;
  }

  public AccessibilityNodeInfoSubject isNotPassword() {
    assertThat(getSubject().isPassword())
        .named("is password")
        .isFalse();
    return this;
  }

  public AccessibilityNodeInfoSubject isScrollable() {
    assertThat(getSubject().isScrollable())
        .named("is scrollable")
        .isTrue();
    return this;
  }

  public AccessibilityNodeInfoSubject isNotScrollable() {
    assertThat(getSubject().isScrollable())
        .named("is scrollable")
        .isFalse();
    return this;
  }

  public AccessibilityNodeInfoSubject isSelected() {
    assertThat(getSubject().isSelected())
        .named("is selected")
        .isTrue();
    return this;
  }

  public AccessibilityNodeInfoSubject isNotSelected() {
    assertThat(getSubject().isSelected())
        .named("is selected")
        .isFalse();
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public AccessibilityNodeInfoSubject isVisibleToUser() {
    assertThat(getSubject().isVisibleToUser())
        .named("is visible to user")
        .isTrue();
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public AccessibilityNodeInfoSubject isNotVisibleToUser() {
    assertThat(getSubject().isVisibleToUser())
        .named("is visible to user")
        .isFalse();
    return this;
  }
}
