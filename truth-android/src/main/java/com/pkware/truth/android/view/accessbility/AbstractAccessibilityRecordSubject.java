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

import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityRecord;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;

public abstract class AbstractAccessibilityRecordSubject<S extends AbstractAccessibilityRecordSubject<S, T>, T extends AccessibilityRecord>
    extends Subject<S, T> {
  protected AbstractAccessibilityRecordSubject(FailureStrategy failureStrategy, T subject) {
    super(failureStrategy, subject);
  }

  private static Function<CharSequence, String> mapToString() {
    return new Function<CharSequence, String>() {
      @Override
      public String apply(CharSequence input) {
        return input.toString();
      }
    };
  }

  public AbstractAccessibilityRecordSubject hasAddedCount(int count) {
    assertThat(getSubject().getAddedCount())
        .named("added count")
        .isEqualTo(count);
    return this;
  }

  public AbstractAccessibilityRecordSubject hasBeforeText(String text) {
    assertThat(getSubject().getBeforeText().toString())
        .named("before text")
        .isEqualTo(text);
    return this;
  }

  public AbstractAccessibilityRecordSubject hasClassName(String name) {
    assertThat(getSubject().getClassName().toString())
        .named("class name")
        .isEqualTo(name);
    return this;
  }

  public AbstractAccessibilityRecordSubject hasContentDescription(String description) {
    assertThat(getSubject().getContentDescription().toString())
        .named("content description")
        .isEqualTo(description);
    return this;
  }

  public AbstractAccessibilityRecordSubject hasCurrentItemIndex(int index) {
    assertThat(getSubject().getCurrentItemIndex())
        .named("current item index")
        .isEqualTo(index);
    return this;
  }

  public AbstractAccessibilityRecordSubject hasFromIndex(int index) {
    assertThat(getSubject().getFromIndex())
        .named("from index")
        .isEqualTo(index);
    return this;
  }

  public AbstractAccessibilityRecordSubject hasItemCount(int count) {
    assertThat(getSubject().getItemCount())
        .named("item count")
        .isEqualTo(count);
    return this;
  }

  public AbstractAccessibilityRecordSubject hasMaximumScrollX(int scroll) {
    assertThat(getSubject().getMaxScrollX())
        .named("maximum X scroll")
        .isEqualTo(scroll);
    return this;
  }

  public AbstractAccessibilityRecordSubject hasMaximumScrollY(int scroll) {
    assertThat(getSubject().getMaxScrollY())
        .named("maximum Y scroll")
        .isEqualTo(scroll);
    return this;
  }

  public AbstractAccessibilityRecordSubject hasRemovedCount(int count) {
    assertThat(getSubject().getRemovedCount())
        .named("remove count")
        .isEqualTo(count);
    return this;
  }

  public AbstractAccessibilityRecordSubject hasScrollX(int scroll) {
    assertThat(getSubject().getScrollX())
        .named("X scroll")
        .isEqualTo(scroll);
    return this;
  }

  public AbstractAccessibilityRecordSubject hasScrollY(int scroll) {
    assertThat(getSubject().getScrollY())
        .named("Y scroll")
        .isEqualTo(scroll);
    return this;
  }

  public AbstractAccessibilityRecordSubject hasSource(AccessibilityNodeInfo info) {
    assertThat(getSubject().getSource())
        .named("source")
        .isSameAs(info);
    return this;
  }

  public AbstractAccessibilityRecordSubject hasText(List<String> text) {
    List<String> actualText = FluentIterable.from(getSubject().getText())
        .transform(mapToString())
        .toList();
    assertThat(actualText)
        .named("text")
        .isEqualTo(text);
    return this;
  }

  public AbstractAccessibilityRecordSubject hasToIndex(int index) {
    assertThat(getSubject().getToIndex())
        .named("to index")
        .isEqualTo(index);
    return this;
  }

  public AbstractAccessibilityRecordSubject hasWindowId(int id) {
    int actualId = getSubject().getWindowId();
    assertThat(getSubject().getWindowId())
        .named("window ID")
        .isEqualTo(id);
    return this;
  }

  public AbstractAccessibilityRecordSubject isChecked() {
    assertThat(getSubject().isChecked())
        .named("is checked")
        .isTrue();
    return this;
  }

  public AbstractAccessibilityRecordSubject isNotChecked() {
    assertThat(getSubject().isChecked())
        .named("is checked")
        .isFalse();
    return this;
  }

  public AbstractAccessibilityRecordSubject isEnabled() {
    assertThat(getSubject().isEnabled())
        .named("is enabled")
        .isTrue();
    return this;
  }

  public AbstractAccessibilityRecordSubject isNotEnabled() {
    assertThat(getSubject().isEnabled())
        .named("is enabled")
        .isFalse();
    return this;
  }

  public AbstractAccessibilityRecordSubject isFullScreen() {
    assertThat(getSubject().isFullScreen())
        .named("is full screen")
        .isTrue();
    return this;
  }

  public AbstractAccessibilityRecordSubject isNotFullScreen() {
    assertThat(getSubject().isFullScreen())
        .named("is full screen")
        .isFalse();
    return this;
  }

  public AbstractAccessibilityRecordSubject isPassword() {
    assertThat(getSubject().isPassword())
        .named("is password")
        .isTrue();
    return this;
  }

  public AbstractAccessibilityRecordSubject isNotPassword() {
    assertThat(getSubject().isPassword())
        .named("is password")
        .isFalse();
    return this;
  }

  public AbstractAccessibilityRecordSubject isScrollable() {
    assertThat(getSubject().isScrollable())
        .named("is scrollable")
        .isTrue();
    return this;
  }

  public AbstractAccessibilityRecordSubject isNotScrollable() {
    assertThat(getSubject().isScrollable())
        .named("is scrollable")
        .isFalse();
    return this;
  }
}
