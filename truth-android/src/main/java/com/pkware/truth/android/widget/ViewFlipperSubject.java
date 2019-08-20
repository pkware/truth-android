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
package com.pkware.truth.android.widget;

import android.widget.ViewFlipper;

import com.google.common.truth.FailureMetadata;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link ViewFlipper} subjects.
 */
public class ViewFlipperSubject extends AbstractViewAnimatorSubject<ViewFlipper> {

  @Nullable
  private final ViewFlipper actual;

  public ViewFlipperSubject(@Nonnull FailureMetadata failureMetadata, @Nullable ViewFlipper actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public ViewFlipperSubject isAutoStarting() {
    check("isAutoStart()").that(actual.isAutoStart()).isTrue();
    return this;
  }

  public ViewFlipperSubject isNotAutoStarting() {
    check("isAutoStart()").that(actual.isAutoStart()).isFalse();
    return this;
  }

  public ViewFlipperSubject isFlipping() {
    check("isFlipping()").that(actual.isFlipping()).isTrue();
    return this;
  }

  public ViewFlipperSubject isNotFlipping() {
    check("isFlipping()").that(actual.isFlipping()).isFalse();
    return this;
  }
}
