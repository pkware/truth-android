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

  public void supportsPredictiveItemAnimations() {
    check("supportsPredictiveItemAnimations()").that(actual.supportsPredictiveItemAnimations()).isTrue();
  }

  public void doesNotSupportPredictiveItemAnimations() {
    check("supportsPredictiveItemAnimations()").that(actual.supportsPredictiveItemAnimations()).isFalse();
  }

  public void canScrollHorizontally() {
    check("canScrollHorizontally()").that(actual.canScrollHorizontally()).isTrue();
  }

  public void canNotScrollHorizontally() {
    check("canScrollHorizontally()").that(actual.canScrollHorizontally()).isFalse();
  }

  public void canScrollVertically() {
    check("canScrollVertically()").that(actual.canScrollVertically()).isTrue();
  }

  public void canNotScrollVertically() {
    check("canScrollVertically()").that(actual.canScrollVertically()).isFalse();
  }

  public void isSmoothScrolling() {
    check("isSmoothScrolling()").that(actual.isSmoothScrolling()).isTrue();
  }

  public void isNotSmoothScrolling() {
    check("isSmoothScrolling()").that(actual.isSmoothScrolling()).isFalse();
  }

  public void hasLayoutDirection(int direction) {
    int actualDirection = actual.getLayoutDirection();
    //noinspection WrongConstant
    check("getLayoutDirection()")
        .withMessage("Expected layout direction <%s> but was <%s>.",
            layoutDirectionToString(direction), layoutDirectionToString(actualDirection))
        .that(actualDirection)
        .isEqualTo(direction);
  }

  public void hasChildCount(int count) {
    check("getChildCount()").that(actual.getChildCount()).isEqualTo(count);
  }

  public void hasWidth(int width) {
    check("getWidth()").that(actual.getWidth()).isEqualTo(width);
  }

  public void hasHeight(int height) {
    check("getHeight()").that(actual.getHeight()).isEqualTo(height);
  }

  public void hasPaddingLeft(int padding) {
    check("getPaddingLeft()").that(actual.getPaddingLeft()).isEqualTo(padding);
  }

  public void hasPaddingTop(int padding) {
    check("getPaddingTop()").that(actual.getPaddingTop()).isEqualTo(padding);
  }

  public void hasPaddingRight(int padding) {
    check("getPaddingRight()").that(actual.getPaddingRight()).isEqualTo(padding);
  }

  public void hasPaddingBottom(int padding) {
    check("getPaddingBottom()").that(actual.getPaddingBottom()).isEqualTo(padding);
  }

  public void hasPaddingStart(int padding) {
    check("getPaddingStart()").that(actual.getPaddingStart()).isEqualTo(padding);
  }

  public void hasPaddingEnd(int padding) {
    check("getPaddingEnd()").that(actual.getPaddingEnd()).isEqualTo(padding);
  }

  public void isFocused() {
    check("isFocused()").that(actual.isFocused()).isTrue();
  }

  public void isNotFocused() {
    check("isFocused()").that(actual.isFocused()).isFalse();
  }

  public void hasFocus() {
    check("hasFocus()").that(actual.hasFocus()).isTrue();
  }

  public void doesNotHaveFocus() {
    check("hasFocus()").that(actual.hasFocus()).isFalse();
  }

  public void hasItemCount(int count) {
    check("getItemCount()").that(actual.getItemCount()).isEqualTo(count);
  }

  public void hasMinimumWidth(int width) {
    check("getMinimumWidth()").that(actual.getMinimumWidth()).isEqualTo(width);
  }

  public void hasMinimumHeight(int height) {
    check("getMinimumHeight()").that(actual.getMinimumHeight()).isEqualTo(height);
  }
}
