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
package com.pkware.truth.android.recyclerview.v7.widget;

import android.support.v7.widget.RecyclerView;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link RecyclerView.SmoothScroller} subjects.
 */
public class RecyclerViewSmoothScrollerSubject
    extends Subject<RecyclerViewSmoothScrollerSubject, RecyclerView.SmoothScroller> {

  protected RecyclerViewSmoothScrollerSubject(FailureStrategy failureStrategy, RecyclerView.SmoothScroller subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<RecyclerViewSmoothScrollerSubject, RecyclerView.SmoothScroller> type() {
    return new SubjectFactory<RecyclerViewSmoothScrollerSubject, RecyclerView.SmoothScroller>() {
      @Override
      public RecyclerViewSmoothScrollerSubject getSubject(FailureStrategy fs, RecyclerView.SmoothScroller that) {
        return new RecyclerViewSmoothScrollerSubject(fs, that);
      }
    };
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
