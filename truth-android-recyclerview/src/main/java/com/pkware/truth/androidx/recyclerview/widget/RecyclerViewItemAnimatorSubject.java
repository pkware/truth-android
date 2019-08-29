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
 * Propositions for {@link RecyclerView.ItemAnimator} subjects.
 */
public class RecyclerViewItemAnimatorSubject extends Subject {

  @Nullable
  private final RecyclerView.ItemAnimator actual;

  public RecyclerViewItemAnimatorSubject(@Nonnull FailureMetadata failureMetadata, @Nullable RecyclerView.ItemAnimator actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasMoveDuration(long duration) {
    check("getMoveDuration()").that(actual.getMoveDuration()).isEqualTo(duration);
  }

  public void hasAddDuration(long duration) {
    check("getAddDuration()").that(actual.getAddDuration()).isEqualTo(duration);
  }

  public void hasRemoveDuration(long duration) {
    check("getRemoveDuration()").that(actual.getRemoveDuration()).isEqualTo(duration);
  }

  public void isRunning() {
    check("isRunning()").that(actual.isRunning()).isTrue();
  }

  public void isNotRunning() {
    check("isRunning()").that(actual.isRunning()).isFalse();
  }
}
