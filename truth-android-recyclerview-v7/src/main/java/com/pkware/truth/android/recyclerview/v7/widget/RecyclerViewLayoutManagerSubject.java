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
package com.pkware.truth.android.recyclerview.v7.widget;

import android.support.v7.widget.RecyclerView;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assert_;
import static com.pkware.truth.android.view.AbstractViewSubject.layoutDirectionToString;

/**
 * Propositions for {@link RecyclerView.LayoutManager} subjects.
 */
public class RecyclerViewLayoutManagerSubject
    extends Subject<RecyclerViewLayoutManagerSubject, RecyclerView.LayoutManager> {

  protected RecyclerViewLayoutManagerSubject(FailureStrategy failureStrategy, RecyclerView.LayoutManager subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<RecyclerViewLayoutManagerSubject, RecyclerView.LayoutManager> type() {
    return new SubjectFactory<RecyclerViewLayoutManagerSubject, RecyclerView.LayoutManager>() {
      @Override
      public RecyclerViewLayoutManagerSubject getSubject(FailureStrategy fs, RecyclerView.LayoutManager that) {
        return new RecyclerViewLayoutManagerSubject(fs, that);
      }
    };
  }

  public RecyclerViewLayoutManagerSubject supportsPredictiveItemAnimations() {
    assertThat(getSubject().supportsPredictiveItemAnimations())
        .named("supports predictive item animations")
        .isTrue();
    return this;
  }

  public RecyclerViewLayoutManagerSubject doesNotSupportPredictiveItemAnimations() {
    assertThat(getSubject().supportsPredictiveItemAnimations())
        .named("supports predictive item animations")
        .isFalse();
    return this;
  }

  public RecyclerViewLayoutManagerSubject canScrollHorizontally() {
    assertThat(getSubject().canScrollHorizontally())
        .named("can scroll horizontally")
        .isTrue();
    return this;
  }

  public RecyclerViewLayoutManagerSubject canNotScrollHorizontally() {
    assertThat(getSubject().canScrollHorizontally())
        .named("can scroll horizontally")
        .isFalse();
    return this;
  }

  public RecyclerViewLayoutManagerSubject canScrollVertically() {
    assertThat(getSubject().canScrollVertically())
        .named("can scroll vertically")
        .isTrue();
    return this;
  }

  public RecyclerViewLayoutManagerSubject canNotScrollVertically() {
    assertThat(getSubject().canScrollVertically())
        .named("can scroll vertically")
        .isFalse();
    return this;
  }

  public RecyclerViewLayoutManagerSubject isSmoothScrolling() {
    assertThat(getSubject().isSmoothScrolling())
        .named("is smooth scrolling")
        .isTrue();
    return this;
  }

  public RecyclerViewLayoutManagerSubject isNotSmoothScrolling() {
    assertThat(getSubject().isSmoothScrolling())
        .named("is smooth scrolling")
        .isFalse();
    return this;
  }

  public RecyclerViewLayoutManagerSubject hasLayoutDirection(int direction) {
    int actualDirection = getSubject().getLayoutDirection();
    //noinspection WrongConstant
    assert_()
        .withFailureMessage("Expected layout direction <%s> but was <%s>.",
            layoutDirectionToString(direction), layoutDirectionToString(actualDirection))
        .that(actualDirection)
        .isEqualTo(direction);
    return this;
  }

  public RecyclerViewLayoutManagerSubject hasChildCount(int count) {
    assertThat(getSubject().getChildCount())
        .named("child count")
        .isEqualTo(count);
    return this;
  }

  public RecyclerViewLayoutManagerSubject hasWidth(int width) {
    assertThat(getSubject().getWidth())
        .named("width")
        .isEqualTo(width);
    return this;
  }

  public RecyclerViewLayoutManagerSubject hasHeight(int height) {
    assertThat(getSubject().getHeight())
        .named("height")
        .isEqualTo(height);
    return this;
  }

  public RecyclerViewLayoutManagerSubject hasPaddingLeft(int padding) {
    assertThat(getSubject().getPaddingLeft())
        .named("left padding")
        .isEqualTo(padding);
    return this;
  }

  public RecyclerViewLayoutManagerSubject hasPaddingTop(int padding) {
    assertThat(getSubject().getPaddingTop())
        .named("top padding")
        .isEqualTo(padding);
    return this;
  }

  public RecyclerViewLayoutManagerSubject hasPaddingRight(int padding) {
    assertThat(getSubject().getPaddingRight())
        .named("right padding")
        .isEqualTo(padding);
    return this;
  }

  public RecyclerViewLayoutManagerSubject hasPaddingBottom(int padding) {
    int actualPadding = getSubject().getPaddingBottom();
    assertThat(getSubject().getPaddingBottom())
        .named("bottom padding")
        .isEqualTo(padding);
    return this;
  }

  public RecyclerViewLayoutManagerSubject hasPaddingStart(int padding) {
    assertThat(getSubject().getPaddingStart())
        .named("start padding")
        .isEqualTo(padding);
    return this;
  }

  public RecyclerViewLayoutManagerSubject hasPaddingEnd(int padding) {
    assertThat(getSubject().getPaddingEnd())
        .named("end padding")
        .isEqualTo(padding);
    return this;
  }

  public RecyclerViewLayoutManagerSubject isFocused() {
    assertThat(getSubject().isFocused())
        .named("is focused")
        .isTrue();
    return this;
  }

  public RecyclerViewLayoutManagerSubject isNotFocused() {
    assertThat(getSubject().isFocused())
        .named("is focused")
        .isFalse();
    return this;
  }

  public RecyclerViewLayoutManagerSubject hasFocus() {
    assertThat(getSubject().hasFocus())
        .named("has focus")
        .isTrue();
    return this;
  }

  public RecyclerViewLayoutManagerSubject doesNotHaveFocus() {
    assertThat(getSubject().hasFocus())
        .named("has focus")
        .isFalse();
    return this;
  }

  public RecyclerViewLayoutManagerSubject hasItemCount(int count) {
    assertThat(getSubject().getItemCount())
        .named("item count")
        .isEqualTo(count);
    return this;
  }

  public RecyclerViewLayoutManagerSubject hasMinimumWidth(int width) {
    assertThat(getSubject().getMinimumWidth())
        .named("minimum width")
        .isEqualTo(width);
    return this;
  }

  public RecyclerViewLayoutManagerSubject hasMinimumHeight(int height) {
    assertThat(getSubject().getMinimumHeight())
        .named("minimum height")
        .isEqualTo(height);
    return this;
  }
}
