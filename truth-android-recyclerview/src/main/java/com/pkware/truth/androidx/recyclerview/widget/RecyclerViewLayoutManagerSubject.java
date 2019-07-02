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
package com.pkware.truth.androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assert_;
import static com.pkware.truth.android.view.AbstractViewSubject.layoutDirectionToString;

/**
 * Propositions for {@link RecyclerView.LayoutManager} subjects.
 */
public class RecyclerViewLayoutManagerSubject
    extends Subject<RecyclerViewLayoutManagerSubject, RecyclerView.LayoutManager> {

  protected RecyclerViewLayoutManagerSubject(FailureMetadata failureMetadata, RecyclerView.LayoutManager subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<RecyclerViewLayoutManagerSubject, RecyclerView.LayoutManager> type() {
    return RecyclerViewLayoutManagerSubject::new;
  }

  public RecyclerViewLayoutManagerSubject supportsPredictiveItemAnimations() {
    assertThat(actual().supportsPredictiveItemAnimations())
        .named("supports predictive item animations")
        .isTrue();
    return this;
  }

  public RecyclerViewLayoutManagerSubject doesNotSupportPredictiveItemAnimations() {
    assertThat(actual().supportsPredictiveItemAnimations())
        .named("supports predictive item animations")
        .isFalse();
    return this;
  }

  public RecyclerViewLayoutManagerSubject canScrollHorizontally() {
    assertThat(actual().canScrollHorizontally())
        .named("can scroll horizontally")
        .isTrue();
    return this;
  }

  public RecyclerViewLayoutManagerSubject canNotScrollHorizontally() {
    assertThat(actual().canScrollHorizontally())
        .named("can scroll horizontally")
        .isFalse();
    return this;
  }

  public RecyclerViewLayoutManagerSubject canScrollVertically() {
    assertThat(actual().canScrollVertically())
        .named("can scroll vertically")
        .isTrue();
    return this;
  }

  public RecyclerViewLayoutManagerSubject canNotScrollVertically() {
    assertThat(actual().canScrollVertically())
        .named("can scroll vertically")
        .isFalse();
    return this;
  }

  public RecyclerViewLayoutManagerSubject isSmoothScrolling() {
    assertThat(actual().isSmoothScrolling())
        .named("is smooth scrolling")
        .isTrue();
    return this;
  }

  public RecyclerViewLayoutManagerSubject isNotSmoothScrolling() {
    assertThat(actual().isSmoothScrolling())
        .named("is smooth scrolling")
        .isFalse();
    return this;
  }

  public RecyclerViewLayoutManagerSubject hasLayoutDirection(int direction) {
    int actualDirection = actual().getLayoutDirection();
    //noinspection WrongConstant
    assert_()
        .withMessage("Expected layout direction <%s> but was <%s>.",
            layoutDirectionToString(direction), layoutDirectionToString(actualDirection))
        .that(actualDirection)
        .isEqualTo(direction);
    return this;
  }

  public RecyclerViewLayoutManagerSubject hasChildCount(int count) {
    assertThat(actual().getChildCount())
        .named("child count")
        .isEqualTo(count);
    return this;
  }

  public RecyclerViewLayoutManagerSubject hasWidth(int width) {
    assertThat(actual().getWidth())
        .named("width")
        .isEqualTo(width);
    return this;
  }

  public RecyclerViewLayoutManagerSubject hasHeight(int height) {
    assertThat(actual().getHeight())
        .named("height")
        .isEqualTo(height);
    return this;
  }

  public RecyclerViewLayoutManagerSubject hasPaddingLeft(int padding) {
    assertThat(actual().getPaddingLeft())
        .named("left padding")
        .isEqualTo(padding);
    return this;
  }

  public RecyclerViewLayoutManagerSubject hasPaddingTop(int padding) {
    assertThat(actual().getPaddingTop())
        .named("top padding")
        .isEqualTo(padding);
    return this;
  }

  public RecyclerViewLayoutManagerSubject hasPaddingRight(int padding) {
    assertThat(actual().getPaddingRight())
        .named("right padding")
        .isEqualTo(padding);
    return this;
  }

  public RecyclerViewLayoutManagerSubject hasPaddingBottom(int padding) {
    int actualPadding = actual().getPaddingBottom();
    assertThat(actual().getPaddingBottom())
        .named("bottom padding")
        .isEqualTo(padding);
    return this;
  }

  public RecyclerViewLayoutManagerSubject hasPaddingStart(int padding) {
    assertThat(actual().getPaddingStart())
        .named("start padding")
        .isEqualTo(padding);
    return this;
  }

  public RecyclerViewLayoutManagerSubject hasPaddingEnd(int padding) {
    assertThat(actual().getPaddingEnd())
        .named("end padding")
        .isEqualTo(padding);
    return this;
  }

  public RecyclerViewLayoutManagerSubject isFocused() {
    assertThat(actual().isFocused())
        .named("is focused")
        .isTrue();
    return this;
  }

  public RecyclerViewLayoutManagerSubject isNotFocused() {
    assertThat(actual().isFocused())
        .named("is focused")
        .isFalse();
    return this;
  }

  public RecyclerViewLayoutManagerSubject hasFocus() {
    assertThat(actual().hasFocus())
        .named("has focus")
        .isTrue();
    return this;
  }

  public RecyclerViewLayoutManagerSubject doesNotHaveFocus() {
    assertThat(actual().hasFocus())
        .named("has focus")
        .isFalse();
    return this;
  }

  public RecyclerViewLayoutManagerSubject hasItemCount(int count) {
    assertThat(actual().getItemCount())
        .named("item count")
        .isEqualTo(count);
    return this;
  }

  public RecyclerViewLayoutManagerSubject hasMinimumWidth(int width) {
    assertThat(actual().getMinimumWidth())
        .named("minimum width")
        .isEqualTo(width);
    return this;
  }

  public RecyclerViewLayoutManagerSubject hasMinimumHeight(int height) {
    assertThat(actual().getMinimumHeight())
        .named("minimum height")
        .isEqualTo(height);
    return this;
  }
}
