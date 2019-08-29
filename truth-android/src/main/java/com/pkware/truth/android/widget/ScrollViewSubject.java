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

import android.widget.ScrollView;

import com.google.common.truth.FailureMetadata;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link ScrollView} subjects.
 */
public class ScrollViewSubject extends AbstractFrameLayoutSubject<ScrollView> {

  @Nullable
  private final ScrollView actual;

  public ScrollViewSubject(@Nonnull FailureMetadata failureMetadata, @Nullable ScrollView actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasMaxScrollAmount(int amount) {
    check("getMaxScrollAmount()").that(actual.getMaxScrollAmount()).isEqualTo(amount);
  }

  public void isFillingViewport() {
    check("isFillViewport()").that(actual.isFillViewport()).isTrue();
  }

  public void isNotFillingViewport() {
    check("isFillViewport()").that(actual.isFillViewport()).isFalse();
  }

  public void hasSmoothScrollEnabled() {
    check("isSmoothScrollingEnabled()").that(actual.isSmoothScrollingEnabled()).isTrue();
  }

  public void hasSmoothScrollDisabled() {
    check("isSmoothScrollingEnabled()").that(actual.isSmoothScrollingEnabled()).isFalse();
  }
}
