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
package com.pkware.truth.androidx.slidingpanelayout.widget;

import androidx.slidingpanelayout.widget.SlidingPaneLayout;

import com.google.common.truth.FailureMetadata;
import com.pkware.truth.android.view.AbstractViewGroupSubject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link SlidingPaneLayout} subjects.
 */
public class SlidingPaneLayoutSubject extends AbstractViewGroupSubject<SlidingPaneLayout> {

  @Nullable
  private final SlidingPaneLayout actual;

  public SlidingPaneLayoutSubject(@Nonnull FailureMetadata failureMetadata, @Nullable SlidingPaneLayout actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasCoveredFadeColor(int color) {
    check("getCoveredFadeColor()").that(actual.getCoveredFadeColor()).isEqualTo(color);
  }

  public void hasParallaxDistance(int distance) {
    check("getParallaxDistance()").that(actual.getParallaxDistance()).isEqualTo(distance);
  }

  public void hasSliderFadeColor(int color) {
    check("getSliderFadeColor()").that(actual.getSliderFadeColor()).isEqualTo(color);
  }

  public void isOpen() {
    check("isOpen()").that(actual.isOpen()).isTrue();
  }

  public void isNotOpen() {
    check("isOpen()").that(actual.isOpen()).isFalse();
  }

  public void isSlideable() {
    check("isSlideable()").that(actual.isSlideable()).isTrue();
  }

  public void isNotSlideable() {
    check("isSlideable()").that(actual.isSlideable()).isFalse();
  }
}
