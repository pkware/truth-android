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
package com.pkware.truth.android.view;

import android.view.ViewConfiguration;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link ViewConfiguration} subjects.
 */
public class ViewConfigurationSubject extends Subject<ViewConfigurationSubject, ViewConfiguration> {
  protected ViewConfigurationSubject(FailureStrategy failureStrategy, ViewConfiguration subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<ViewConfigurationSubject, ViewConfiguration> type() {
    return new SubjectFactory<ViewConfigurationSubject, ViewConfiguration>() {
      @Override
      public ViewConfigurationSubject getSubject(FailureStrategy fs, ViewConfiguration that) {
        return new ViewConfigurationSubject(fs, that);
      }
    };
  }

  public ViewConfigurationSubject hasScaledDoubleTapSlop(int slop) {
    assertThat(getSubject().getScaledDoubleTapSlop())
        .named("scaled double-tap slop")
        .isEqualTo(slop);
    return this;
  }

  public ViewConfigurationSubject hasScaledEdgeSlop(int slop) {
    assertThat(getSubject().getScaledEdgeSlop())
        .named("scaled edge slop")
        .isEqualTo(slop);
    return this;
  }

  public ViewConfigurationSubject hasScaledFadingEdgeLength(int length) {
    assertThat(getSubject().getScaledFadingEdgeLength())
        .named("scaled fading edge length")
        .isEqualTo(length);
    return this;
  }

  public ViewConfigurationSubject hasScaledMaximumDrawingCacheSize(int size) {
    assertThat(getSubject().getScaledMaximumDrawingCacheSize())
        .named("scaled maximum drawing cache size")
        .isEqualTo(size);
    return this;
  }

  public ViewConfigurationSubject hasScaledMaximumFlingVelocity(int velocity) {
    assertThat(getSubject().getScaledMaximumFlingVelocity())
        .named("scaled maximum fling velocity")
        .isEqualTo(velocity);
    return this;
  }

  public ViewConfigurationSubject hasScaledMinimumFlingVelocity(int velocity) {
    assertThat(getSubject().getScaledMinimumFlingVelocity())
        .named("scaled minimum fling velocity")
        .isEqualTo(velocity);
    return this;
  }

  public ViewConfigurationSubject hasScaledOverflingDistance(int distance) {
    assertThat(getSubject().getScaledOverflingDistance())
        .named("scaled overfling distance")
        .isEqualTo(distance);
    return this;
  }

  public ViewConfigurationSubject hasScaledOverscrollDistance(int distance) {
    assertThat(getSubject().getScaledOverscrollDistance())
        .named("scaled overscroll distance")
        .isEqualTo(distance);
    return this;
  }

  public ViewConfigurationSubject hasScaledPagingTouchSlop(int slop) {
    assertThat(getSubject().getScaledPagingTouchSlop())
        .named("scaled paging touch slop")
        .isEqualTo(slop);
    return this;
  }

  public ViewConfigurationSubject hasScaledScrollBarSize(int size) {
    assertThat(getSubject().getScaledScrollBarSize())
        .named("scaled scroll bar size")
        .isEqualTo(size);
    return this;
  }

  public ViewConfigurationSubject hasScaledTouchSlop(int slop) {
    assertThat(getSubject().getScaledTouchSlop())
        .named("scaled touch slop")
        .isEqualTo(slop);
    return this;
  }

  public ViewConfigurationSubject hasScaledWindowTouchSlop(int slop) {
    assertThat(getSubject().getScaledWindowTouchSlop())
        .named("scaled window touch slop")
        .isEqualTo(slop);
    return this;
  }
}
