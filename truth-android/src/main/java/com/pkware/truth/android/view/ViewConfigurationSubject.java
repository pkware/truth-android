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

  public ViewConfigurationSubject hasScaledDoubleTapSlop(int slop) {
    check("getScaledDoubleTapSlop()").that(actual.getScaledDoubleTapSlop()).isEqualTo(slop);
    return this;
  }

  public ViewConfigurationSubject hasScaledEdgeSlop(int slop) {
    check("getScaledEdgeSlop()").that(actual.getScaledEdgeSlop()).isEqualTo(slop);
    return this;
  }

  public ViewConfigurationSubject hasScaledFadingEdgeLength(int length) {
    check("getScaledFadingEdgeLength()").that(actual.getScaledFadingEdgeLength()).isEqualTo(length);
    return this;
  }

  public ViewConfigurationSubject hasScaledMaximumDrawingCacheSize(int size) {
    check("getScaledMaximumDrawingCacheSize()").that(actual.getScaledMaximumDrawingCacheSize()).isEqualTo(size);
    return this;
  }

  public ViewConfigurationSubject hasScaledMaximumFlingVelocity(int velocity) {
    check("getScaledMaximumFlingVelocity()").that(actual.getScaledMaximumFlingVelocity()).isEqualTo(velocity);
    return this;
  }

  public ViewConfigurationSubject hasScaledMinimumFlingVelocity(int velocity) {
    check("getScaledMinimumFlingVelocity()").that(actual.getScaledMinimumFlingVelocity()).isEqualTo(velocity);
    return this;
  }

  public ViewConfigurationSubject hasScaledOverflingDistance(int distance) {
    check("getScaledOverflingDistance()").that(actual.getScaledOverflingDistance()).isEqualTo(distance);
    return this;
  }

  public ViewConfigurationSubject hasScaledOverscrollDistance(int distance) {
    check("getScaledOverscrollDistance()").that(actual.getScaledOverscrollDistance()).isEqualTo(distance);
    return this;
  }

  public ViewConfigurationSubject hasScaledPagingTouchSlop(int slop) {
    check("getScaledPagingTouchSlop()").that(actual.getScaledPagingTouchSlop()).isEqualTo(slop);
    return this;
  }

  public ViewConfigurationSubject hasScaledScrollBarSize(int size) {
    check("getScaledScrollBarSize()").that(actual.getScaledScrollBarSize()).isEqualTo(size);
    return this;
  }

  public ViewConfigurationSubject hasScaledTouchSlop(int slop) {
    check("getScaledTouchSlop()").that(actual.getScaledTouchSlop()).isEqualTo(slop);
    return this;
  }

  public ViewConfigurationSubject hasScaledWindowTouchSlop(int slop) {
    check("getScaledWindowTouchSlop()").that(actual.getScaledWindowTouchSlop()).isEqualTo(slop);
    return this;
  }
}
