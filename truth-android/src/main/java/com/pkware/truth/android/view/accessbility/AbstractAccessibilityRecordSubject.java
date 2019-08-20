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

  public AbstractAccessibilityRecordSubject hasAddedCount(int count) {
    check("getAddedCount()").that(actual.getAddedCount()).isEqualTo(count);
    return this;
  }

  public AbstractAccessibilityRecordSubject hasBeforeText(@Nullable String text) {
    check("getBeforeText()")
        .that(actual.getBeforeText().toString())
        .isEqualTo(text);
    return this;
  }

  public AbstractAccessibilityRecordSubject hasClassName(@Nullable String name) {
    check("getClassName()")
        .that(actual.getClassName().toString())
        .isEqualTo(name);
    return this;
  }

  public AbstractAccessibilityRecordSubject hasContentDescription(@Nullable String description) {
    check("getContentDescription()")
        .that(actual.getContentDescription().toString())
        .isEqualTo(description);
    return this;
  }

  public AbstractAccessibilityRecordSubject hasCurrentItemIndex(int index) {
    check("getCurrentItemIndex()").that(actual.getCurrentItemIndex()).isEqualTo(index);
    return this;
  }

  public AbstractAccessibilityRecordSubject hasFromIndex(int index) {
    check("getFromIndex()").that(actual.getFromIndex()).isEqualTo(index);
    return this;
  }

  public AbstractAccessibilityRecordSubject hasItemCount(int count) {
    check("getItemCount()").that(actual.getItemCount()).isEqualTo(count);
    return this;
  }

  public AbstractAccessibilityRecordSubject hasMaximumScrollX(int scroll) {
    check("getMaxScrollX()").that(actual.getMaxScrollX()).isEqualTo(scroll);
    return this;
  }

  public AbstractAccessibilityRecordSubject hasMaximumScrollY(int scroll) {
    check("getMaxScrollY()").that(actual.getMaxScrollY()).isEqualTo(scroll);
    return this;
  }

  public AbstractAccessibilityRecordSubject hasRemovedCount(int count) {
    check("getRemovedCount()").that(actual.getRemovedCount()).isEqualTo(count);
    return this;
  }

  public AbstractAccessibilityRecordSubject hasScrollX(int scroll) {
    check("getScrollX()").that(actual.getScrollX()).isEqualTo(scroll);
    return this;
  }

  public AbstractAccessibilityRecordSubject hasScrollY(int scroll) {
    check("getScrollY()").that(actual.getScrollY()).isEqualTo(scroll);
    return this;
  }

  public AbstractAccessibilityRecordSubject hasSource(@Nullable AccessibilityNodeInfo info) {
    check("getSource()").that(actual.getSource()).isSameInstanceAs(info);
    return this;
  }

  public AbstractAccessibilityRecordSubject hasText(@Nonnull List<String> text) {
    FluentIterable<String> actualText = FluentIterable.from(actual.getText())
        .transform(CharSequence::toString);
    check("getText()")
        .withMessage("Text as Strings")
        .that(actualText)
        .containsExactlyElementsIn(text)
        .inOrder();
    return this;
  }

  public AbstractAccessibilityRecordSubject hasToIndex(int index) {
    check("getToIndex()").that(actual.getToIndex()).isEqualTo(index);
    return this;
  }

  public AbstractAccessibilityRecordSubject hasWindowId(int id) {
    int actualId = actual.getWindowId();
    check("getWindowId()").that(actual.getWindowId()).isEqualTo(id);
    return this;
  }

  public AbstractAccessibilityRecordSubject isChecked() {
    check("isChecked()").that(actual.isChecked()).isTrue();
    return this;
  }

  public AbstractAccessibilityRecordSubject isNotChecked() {
    check("isChecked()").that(actual.isChecked()).isFalse();
    return this;
  }

  public AbstractAccessibilityRecordSubject isEnabled() {
    check("isEnabled()").that(actual.isEnabled()).isTrue();
    return this;
  }

  public AbstractAccessibilityRecordSubject isNotEnabled() {
    check("isEnabled()").that(actual.isEnabled()).isFalse();
    return this;
  }

  public AbstractAccessibilityRecordSubject isFullScreen() {
    check("isFullScreen()").that(actual.isFullScreen()).isTrue();
    return this;
  }

  public AbstractAccessibilityRecordSubject isNotFullScreen() {
    check("isFullScreen()").that(actual.isFullScreen()).isFalse();
    return this;
  }

  public AbstractAccessibilityRecordSubject isPassword() {
    check("isPassword()").that(actual.isPassword()).isTrue();
    return this;
  }

  public AbstractAccessibilityRecordSubject isNotPassword() {
    check("isPassword()").that(actual.isPassword()).isFalse();
    return this;
  }

  public AbstractAccessibilityRecordSubject isScrollable() {
    check("isScrollable()").that(actual.isScrollable()).isTrue();
    return this;
  }

  public AbstractAccessibilityRecordSubject isNotScrollable() {
    check("isScrollable()").that(actual.isScrollable()).isFalse();
    return this;
  }
}
