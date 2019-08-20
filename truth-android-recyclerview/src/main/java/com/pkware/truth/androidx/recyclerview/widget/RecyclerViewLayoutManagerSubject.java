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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static com.pkware.truth.android.view.AbstractViewSubject.layoutDirectionToString;

/**
 * Propositions for {@link RecyclerView.LayoutManager} subjects.
 */
public class RecyclerViewLayoutManagerSubject extends Subject {

  @Nullable
  private final RecyclerView.LayoutManager actual;

  public RecyclerViewLayoutManagerSubject(@Nonnull FailureMetadata failureMetadata, @Nullable RecyclerView.LayoutManager actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public RecyclerViewLayoutManagerSubject supportsPredictiveItemAnimations() {
    check("supportsPredictiveItemAnimations()").that(actual.supportsPredictiveItemAnimations()).isTrue();
    return this;
  }

  public RecyclerViewLayoutManagerSubject doesNotSupportPredictiveItemAnimations() {
    check("supportsPredictiveItemAnimations()").that(actual.supportsPredictiveItemAnimations()).isFalse();
    return this;
  }

  public RecyclerViewLayoutManagerSubject canScrollHorizontally() {
    check("canScrollHorizontally()").that(actual.canScrollHorizontally()).isTrue();
    return this;
  }

  public RecyclerViewLayoutManagerSubject canNotScrollHorizontally() {
    check("canScrollHorizontally()").that(actual.canScrollHorizontally()).isFalse();
    return this;
  }

  public RecyclerViewLayoutManagerSubject canScrollVertically() {
    check("canScrollVertically()").that(actual.canScrollVertically()).isTrue();
    return this;
  }

  public RecyclerViewLayoutManagerSubject canNotScrollVertically() {
    check("canScrollVertically()").that(actual.canScrollVertically()).isFalse();
    return this;
  }

  public RecyclerViewLayoutManagerSubject isSmoothScrolling() {
    check("isSmoothScrolling()").that(actual.isSmoothScrolling()).isTrue();
    return this;
  }

  public RecyclerViewLayoutManagerSubject isNotSmoothScrolling() {
    check("isSmoothScrolling()").that(actual.isSmoothScrolling()).isFalse();
    return this;
  }

  public RecyclerViewLayoutManagerSubject hasLayoutDirection(int direction) {
    int actualDirection = actual.getLayoutDirection();
    //noinspection WrongConstant
    check("getLayoutDirection()")
        .withMessage("Expected layout direction <%s> but was <%s>.",
            layoutDirectionToString(direction), layoutDirectionToString(actualDirection))
        .that(actualDirection)
        .isEqualTo(direction);
    return this;
  }

  public RecyclerViewLayoutManagerSubject hasChildCount(int count) {
    check("getChildCount()").that(actual.getChildCount()).isEqualTo(count);
    return this;
  }

  public RecyclerViewLayoutManagerSubject hasWidth(int width) {
    check("getWidth()").that(actual.getWidth()).isEqualTo(width);
    return this;
  }

  public RecyclerViewLayoutManagerSubject hasHeight(int height) {
    check("getHeight()").that(actual.getHeight()).isEqualTo(height);
    return this;
  }

  public RecyclerViewLayoutManagerSubject hasPaddingLeft(int padding) {
    check("getPaddingLeft()").that(actual.getPaddingLeft()).isEqualTo(padding);
    return this;
  }

  public RecyclerViewLayoutManagerSubject hasPaddingTop(int padding) {
    check("getPaddingTop()").that(actual.getPaddingTop()).isEqualTo(padding);
    return this;
  }

  public RecyclerViewLayoutManagerSubject hasPaddingRight(int padding) {
    check("getPaddingRight()").that(actual.getPaddingRight()).isEqualTo(padding);
    return this;
  }

  public RecyclerViewLayoutManagerSubject hasPaddingBottom(int padding) {
    check("getPaddingBottom()").that(actual.getPaddingBottom()).isEqualTo(padding);
    return this;
  }

  public RecyclerViewLayoutManagerSubject hasPaddingStart(int padding) {
    check("getPaddingStart()").that(actual.getPaddingStart()).isEqualTo(padding);
    return this;
  }

  public RecyclerViewLayoutManagerSubject hasPaddingEnd(int padding) {
    check("getPaddingEnd()").that(actual.getPaddingEnd()).isEqualTo(padding);
    return this;
  }

  public RecyclerViewLayoutManagerSubject isFocused() {
    check("isFocused()").that(actual.isFocused()).isTrue();
    return this;
  }

  public RecyclerViewLayoutManagerSubject isNotFocused() {
    check("isFocused()").that(actual.isFocused()).isFalse();
    return this;
  }

  public RecyclerViewLayoutManagerSubject hasFocus() {
    check("hasFocus()").that(actual.hasFocus()).isTrue();
    return this;
  }

  public RecyclerViewLayoutManagerSubject doesNotHaveFocus() {
    check("hasFocus()").that(actual.hasFocus()).isFalse();
    return this;
  }

  public RecyclerViewLayoutManagerSubject hasItemCount(int count) {
    check("getItemCount()").that(actual.getItemCount()).isEqualTo(count);
    return this;
  }

  public RecyclerViewLayoutManagerSubject hasMinimumWidth(int width) {
    check("getMinimumWidth()").that(actual.getMinimumWidth()).isEqualTo(width);
    return this;
  }

  public RecyclerViewLayoutManagerSubject hasMinimumHeight(int height) {
    check("getMinimumHeight()").that(actual.getMinimumHeight()).isEqualTo(height);
    return this;
  }
}
