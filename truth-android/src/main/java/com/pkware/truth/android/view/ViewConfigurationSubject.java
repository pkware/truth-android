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
package com.pkware.truth.android.view;

import android.view.ViewConfiguration;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link ViewConfiguration} subjects.
 */
public class ViewConfigurationSubject extends Subject {

  @Nullable
  private final ViewConfiguration actual;

  public ViewConfigurationSubject(@Nonnull FailureMetadata failureMetadata, @Nullable ViewConfiguration actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasScaledDoubleTapSlop(int slop) {
    check("getScaledDoubleTapSlop()").that(actual.getScaledDoubleTapSlop()).isEqualTo(slop);
  }

  public void hasScaledEdgeSlop(int slop) {
    check("getScaledEdgeSlop()").that(actual.getScaledEdgeSlop()).isEqualTo(slop);
  }

  public void hasScaledFadingEdgeLength(int length) {
    check("getScaledFadingEdgeLength()").that(actual.getScaledFadingEdgeLength()).isEqualTo(length);
  }

  public void hasScaledMaximumDrawingCacheSize(int size) {
    check("getScaledMaximumDrawingCacheSize()").that(actual.getScaledMaximumDrawingCacheSize()).isEqualTo(size);
  }

  public void hasScaledMaximumFlingVelocity(int velocity) {
    check("getScaledMaximumFlingVelocity()").that(actual.getScaledMaximumFlingVelocity()).isEqualTo(velocity);
  }

  public void hasScaledMinimumFlingVelocity(int velocity) {
    check("getScaledMinimumFlingVelocity()").that(actual.getScaledMinimumFlingVelocity()).isEqualTo(velocity);
  }

  public void hasScaledOverflingDistance(int distance) {
    check("getScaledOverflingDistance()").that(actual.getScaledOverflingDistance()).isEqualTo(distance);
  }

  public void hasScaledOverscrollDistance(int distance) {
    check("getScaledOverscrollDistance()").that(actual.getScaledOverscrollDistance()).isEqualTo(distance);
  }

  public void hasScaledPagingTouchSlop(int slop) {
    check("getScaledPagingTouchSlop()").that(actual.getScaledPagingTouchSlop()).isEqualTo(slop);
  }

  public void hasScaledScrollBarSize(int size) {
    check("getScaledScrollBarSize()").that(actual.getScaledScrollBarSize()).isEqualTo(size);
  }

  public void hasScaledTouchSlop(int slop) {
    check("getScaledTouchSlop()").that(actual.getScaledTouchSlop()).isEqualTo(slop);
  }

  public void hasScaledWindowTouchSlop(int slop) {
    check("getScaledWindowTouchSlop()").that(actual.getScaledWindowTouchSlop()).isEqualTo(slop);
  }
}
