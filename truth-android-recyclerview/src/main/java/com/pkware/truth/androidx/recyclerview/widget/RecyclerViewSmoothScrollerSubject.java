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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link RecyclerView.SmoothScroller} subjects.
 */
public class RecyclerViewSmoothScrollerSubject extends Subject {

  @Nullable
  private final RecyclerView.SmoothScroller actual;

  public RecyclerViewSmoothScrollerSubject(@Nonnull FailureMetadata failureMetadata, @Nullable RecyclerView.SmoothScroller actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void isPendingInitialRun() {
    check("isPendingInitialRun()").that(actual.isPendingInitialRun()).isTrue();
  }

  public void isNotPendingInitialRun() {
    check("isPendingInitialRun()").that(actual.isPendingInitialRun()).isFalse();
  }

  public void isRunning() {
    check("isRunning()").that(actual.isRunning()).isTrue();
  }

  public void isNotRunning() {
    check("isRunning()").that(actual.isRunning()).isFalse();
  }

  public void hasTargetPosition(int position) {
    check("getTargetPosition()").that(actual.getTargetPosition()).isEqualTo(position);
  }

  public void hasChildCount(int count) {
    check("getChildCount()").that(actual.getChildCount()).isEqualTo(count);
  }
}
