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
package com.pkware.truth.android.support.v4.widget;

import androidx.slidingpanelayout.widget.SlidingPaneLayout;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;
import com.pkware.truth.android.view.AbstractViewGroupSubject;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link SlidingPaneLayout} subjects.
 */
public class SlidingPaneLayoutSubject
    extends AbstractViewGroupSubject<SlidingPaneLayoutSubject, SlidingPaneLayout> {
  protected SlidingPaneLayoutSubject(FailureMetadata failureMetadata, SlidingPaneLayout subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<SlidingPaneLayoutSubject, SlidingPaneLayout> type() {
    return SlidingPaneLayoutSubject::new;
  }

  public SlidingPaneLayoutSubject hasCoveredFadeColor(int color) {
    assertThat(actual().getCoveredFadeColor())
        .named("covered fade color")
        .isEqualTo(color);
    return this;
  }

  public SlidingPaneLayoutSubject hasParallaxDistance(int distance) {
    assertThat(actual().getParallaxDistance())
        .named("parallax distance")
        .isEqualTo(distance);
    return this;
  }

  public SlidingPaneLayoutSubject hasSliderFadeColor(int color) {
    assertThat(actual().getSliderFadeColor())
        .named("slider fade color")
        .isEqualTo(color);
    return this;
  }

  public SlidingPaneLayoutSubject isOpen() {
    assertThat(actual().isOpen())
        .named("is open")
        .isTrue();
    return this;
  }

  public SlidingPaneLayoutSubject isNotOpen() {
    assertThat(actual().isOpen())
        .named("is open")
        .isFalse();
    return this;
  }

  public SlidingPaneLayoutSubject isSlideable() {
    assertThat(actual().isSlideable())
        .named("is slideable")
        .isTrue();
    return this;
  }

  public SlidingPaneLayoutSubject isNotSlideable() {
    assertThat(actual().isSlideable())
        .named("is slideable")
        .isFalse();
    return this;
  }
}
