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

import android.view.animation.Interpolator;
import androidx.recyclerview.widget.RecyclerView;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link RecyclerView.SmoothScroller.Action} subjects.
 */
public class RecyclerViewSmoothScrollerActionSubject extends
    Subject<RecyclerViewSmoothScrollerActionSubject, RecyclerView.SmoothScroller.Action> {

  public RecyclerViewSmoothScrollerActionSubject(FailureMetadata failureMetadata, RecyclerView.SmoothScroller.Action subject) {
    super(failureMetadata, subject);
  }

  public RecyclerViewSmoothScrollerActionSubject hasDx(int dx) {
    assertThat(actual().getDx())
        .named("dx")
        .isEqualTo(dx);
    return this;
  }

  public RecyclerViewSmoothScrollerActionSubject hasDy(int dy) {
    assertThat(actual().getDy())
        .named("dy")
        .isEqualTo(dy);
    return this;
  }

  public RecyclerViewSmoothScrollerActionSubject hasDuration(int duration) {
    assertThat(actual().getDuration())
        .named("duration")
        .isEqualTo(duration);
    return this;
  }

  public RecyclerViewSmoothScrollerActionSubject hasInterpolator(Interpolator interpolator) {
    assertThat(actual().getInterpolator())
        .named("interpolator")
        .isEqualTo(interpolator);
    return this;
  }
}
