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

import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityRecord;

import com.google.common.collect.FluentIterable;
import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class AbstractAccessibilityRecordSubject<T extends AccessibilityRecord> extends Subject {

  @Nullable
  private final T actual;

  protected AbstractAccessibilityRecordSubject(@Nonnull FailureMetadata failureMetadata, @Nullable T actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasAddedCount(int count) {
    check("getAddedCount()").that(actual.getAddedCount()).isEqualTo(count);
  }

  public void hasBeforeText(@Nullable String text) {
    check("getBeforeText()")
        .that(actual.getBeforeText().toString())
        .isEqualTo(text);
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

  public void hasCurrentItemIndex(int index) {
    check("getCurrentItemIndex()").that(actual.getCurrentItemIndex()).isEqualTo(index);
  }

  public void hasFromIndex(int index) {
    check("getFromIndex()").that(actual.getFromIndex()).isEqualTo(index);
  }

  public void hasItemCount(int count) {
    check("getItemCount()").that(actual.getItemCount()).isEqualTo(count);
  }

  public void hasMaximumScrollX(int scroll) {
    check("getMaxScrollX()").that(actual.getMaxScrollX()).isEqualTo(scroll);
  }

  public void hasMaximumScrollY(int scroll) {
    check("getMaxScrollY()").that(actual.getMaxScrollY()).isEqualTo(scroll);
  }

  public void hasRemovedCount(int count) {
    check("getRemovedCount()").that(actual.getRemovedCount()).isEqualTo(count);
  }

  public void hasScrollX(int scroll) {
    check("getScrollX()").that(actual.getScrollX()).isEqualTo(scroll);
  }

  public void hasScrollY(int scroll) {
    check("getScrollY()").that(actual.getScrollY()).isEqualTo(scroll);
  }

  public void hasSource(@Nullable AccessibilityNodeInfo info) {
    check("getSource()").that(actual.getSource()).isSameInstanceAs(info);
  }

  public void hasText(@Nonnull List<String> text) {
    FluentIterable<String> actualText = FluentIterable.from(actual.getText())
        .transform(CharSequence::toString);
    check("getText()")
        .withMessage("Text as Strings")
        .that(actualText)
        .containsExactlyElementsIn(text)
        .inOrder();
  }

  public void hasToIndex(int index) {
    check("getToIndex()").that(actual.getToIndex()).isEqualTo(index);
  }

  public void hasWindowId(int id) {
    int actualId = actual.getWindowId();
    check("getWindowId()").that(actual.getWindowId()).isEqualTo(id);
  }

  public void isChecked() {
    check("isChecked()").that(actual.isChecked()).isTrue();
  }

  public void isNotChecked() {
    check("isChecked()").that(actual.isChecked()).isFalse();
  }

  public void isEnabled() {
    check("isEnabled()").that(actual.isEnabled()).isTrue();
  }

  public void isNotEnabled() {
    check("isEnabled()").that(actual.isEnabled()).isFalse();
  }

  public void isFullScreen() {
    check("isFullScreen()").that(actual.isFullScreen()).isTrue();
  }

  public void isNotFullScreen() {
    check("isFullScreen()").that(actual.isFullScreen()).isFalse();
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
}
