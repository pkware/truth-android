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
package com.pkware.truth.android.widget;

import android.widget.ScrollView;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link ScrollView} subjects.
 */
public class ScrollViewSubject extends AbstractFrameLayoutSubject<ScrollViewSubject, ScrollView> {
  protected ScrollViewSubject(FailureStrategy failureStrategy, ScrollView subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<ScrollViewSubject, ScrollView> type() {
    return new SubjectFactory<ScrollViewSubject, ScrollView>() {
      @Override
      public ScrollViewSubject getSubject(FailureStrategy fs, ScrollView that) {
        return new ScrollViewSubject(fs, that);
      }
    };
  }

  public ScrollViewSubject hasMaxScrollAmount(int amount) {
    assertThat(getSubject().getMaxScrollAmount())
        .named("maximum scroll amount")
        .isEqualTo(amount);
    return this;
  }

  public ScrollViewSubject isFillingViewport() {
    assertThat(getSubject().isFillViewport())
        .named("is filling viewport")
        .isTrue();
    return this;
  }

  public ScrollViewSubject isNotFillingViewport() {
    assertThat(getSubject().isFillViewport())
        .named("is filling viewport")
        .isFalse();
    return this;
  }

  public ScrollViewSubject hasSmoothScrollEnabled() {
    assertThat(getSubject().isSmoothScrollingEnabled())
        .named("has smooth scrolling enabled")
        .isTrue();
    return this;
  }

  public ScrollViewSubject hasSmoothScrollDisabled() {
    assertThat(!getSubject().isSmoothScrollingEnabled())
        .named("has smooth scrolling disabled")
        .isTrue();
    return this;
  }
}
