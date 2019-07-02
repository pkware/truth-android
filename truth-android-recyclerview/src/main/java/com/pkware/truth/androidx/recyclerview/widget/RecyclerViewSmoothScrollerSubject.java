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

import androidx.recyclerview.widget.RecyclerView;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link RecyclerView.SmoothScroller} subjects.
 */
public class RecyclerViewSmoothScrollerSubject
    extends Subject<RecyclerViewSmoothScrollerSubject, RecyclerView.SmoothScroller> {

  protected RecyclerViewSmoothScrollerSubject(FailureMetadata failureMetadata, RecyclerView.SmoothScroller subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<RecyclerViewSmoothScrollerSubject, RecyclerView.SmoothScroller> type() {
    return RecyclerViewSmoothScrollerSubject::new;
  }

  public RecyclerViewSmoothScrollerSubject isPendingInitialRun() {
    assertThat(actual().isPendingInitialRun())
        .named("is pending initial run")
        .isTrue();
    return this;
  }

  public RecyclerViewSmoothScrollerSubject isNotPendingInitialRun() {
    assertThat(actual().isPendingInitialRun())
        .named("is pending initial run")
        .isFalse();
    return this;
  }

  public RecyclerViewSmoothScrollerSubject isRunning() {
    assertThat(actual().isRunning())
        .named("is running")
        .isFalse();
    return this;
  }

  public RecyclerViewSmoothScrollerSubject isNotRunning() {
    assertThat(actual().isRunning())
        .named("is running")
        .isFalse();
    return this;
  }

  public RecyclerViewSmoothScrollerSubject hasTargetPosition(int position) {
    assertThat(actual().getTargetPosition())
        .named("target position")
        .isEqualTo(position);
    return this;
  }

  public RecyclerViewSmoothScrollerSubject hasChildCount(int count) {
    assertThat(actual().getChildCount())
        .named("child count")
        .isEqualTo(count);
    return this;
  }
}
