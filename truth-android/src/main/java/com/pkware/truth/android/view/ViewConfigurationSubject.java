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

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link ViewConfiguration} subjects.
 */
public class ViewConfigurationSubject extends Subject<ViewConfigurationSubject, ViewConfiguration> {
  protected ViewConfigurationSubject(FailureMetadata failureMetadata, ViewConfiguration subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<ViewConfigurationSubject, ViewConfiguration> type() {
    return new Subject.Factory<ViewConfigurationSubject, ViewConfiguration>() {
      @Override
      public ViewConfigurationSubject createSubject(FailureMetadata fm, ViewConfiguration that) {
        return new ViewConfigurationSubject(fm, that);
      }
    };
  }

  public ViewConfigurationSubject hasScaledDoubleTapSlop(int slop) {
    assertThat(actual().getScaledDoubleTapSlop())
        .named("scaled double-tap slop")
        .isEqualTo(slop);
    return this;
  }

  public ViewConfigurationSubject hasScaledEdgeSlop(int slop) {
    assertThat(actual().getScaledEdgeSlop())
        .named("scaled edge slop")
        .isEqualTo(slop);
    return this;
  }

  public ViewConfigurationSubject hasScaledFadingEdgeLength(int length) {
    assertThat(actual().getScaledFadingEdgeLength())
        .named("scaled fading edge length")
        .isEqualTo(length);
    return this;
  }

  public ViewConfigurationSubject hasScaledMaximumDrawingCacheSize(int size) {
    assertThat(actual().getScaledMaximumDrawingCacheSize())
        .named("scaled maximum drawing cache size")
        .isEqualTo(size);
    return this;
  }

  public ViewConfigurationSubject hasScaledMaximumFlingVelocity(int velocity) {
    assertThat(actual().getScaledMaximumFlingVelocity())
        .named("scaled maximum fling velocity")
        .isEqualTo(velocity);
    return this;
  }

  public ViewConfigurationSubject hasScaledMinimumFlingVelocity(int velocity) {
    assertThat(actual().getScaledMinimumFlingVelocity())
        .named("scaled minimum fling velocity")
        .isEqualTo(velocity);
    return this;
  }

  public ViewConfigurationSubject hasScaledOverflingDistance(int distance) {
    assertThat(actual().getScaledOverflingDistance())
        .named("scaled overfling distance")
        .isEqualTo(distance);
    return this;
  }

  public ViewConfigurationSubject hasScaledOverscrollDistance(int distance) {
    assertThat(actual().getScaledOverscrollDistance())
        .named("scaled overscroll distance")
        .isEqualTo(distance);
    return this;
  }

  public ViewConfigurationSubject hasScaledPagingTouchSlop(int slop) {
    assertThat(actual().getScaledPagingTouchSlop())
        .named("scaled paging touch slop")
        .isEqualTo(slop);
    return this;
  }

  public ViewConfigurationSubject hasScaledScrollBarSize(int size) {
    assertThat(actual().getScaledScrollBarSize())
        .named("scaled scroll bar size")
        .isEqualTo(size);
    return this;
  }

  public ViewConfigurationSubject hasScaledTouchSlop(int slop) {
    assertThat(actual().getScaledTouchSlop())
        .named("scaled touch slop")
        .isEqualTo(slop);
    return this;
  }

  public ViewConfigurationSubject hasScaledWindowTouchSlop(int slop) {
    assertThat(actual().getScaledWindowTouchSlop())
        .named("scaled window touch slop")
        .isEqualTo(slop);
    return this;
  }
}
