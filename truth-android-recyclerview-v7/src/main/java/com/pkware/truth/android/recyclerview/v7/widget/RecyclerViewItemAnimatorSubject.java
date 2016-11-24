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
 * Propositions for {@link RecyclerView.ItemAnimator} subjects.
 */
public class RecyclerViewItemAnimatorSubject
    extends Subject<RecyclerViewItemAnimatorSubject, RecyclerView.ItemAnimator> {

  protected RecyclerViewItemAnimatorSubject(FailureStrategy failureStrategy, RecyclerView.ItemAnimator subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<RecyclerViewItemAnimatorSubject, RecyclerView.ItemAnimator> type() {
    return new SubjectFactory<RecyclerViewItemAnimatorSubject, RecyclerView.ItemAnimator>() {
      @Override
      public RecyclerViewItemAnimatorSubject getSubject(FailureStrategy fs, RecyclerView.ItemAnimator that) {
        return new RecyclerViewItemAnimatorSubject(fs, that);
      }
    };
  }

  public RecyclerViewItemAnimatorSubject hasMoveDuration(long duration) {
    assertThat(actual().getMoveDuration())
        .named("move duration")
        .isEqualTo(duration);
    return this;
  }

  public RecyclerViewItemAnimatorSubject hasAddDuration(long duration) {
    assertThat(actual().getAddDuration())
        .named("add duration")
        .isEqualTo(duration);
    return this;
  }

  public RecyclerViewItemAnimatorSubject hasRemoveDuration(long duration) {
    assertThat(actual().getRemoveDuration())
        .named("remove duration")
        .isEqualTo(duration);
    return this;
  }

  public RecyclerViewItemAnimatorSubject isRunning() {
    assertThat(actual().isRunning())
        .named("is running")
        .isTrue();
    return this;
  }

  public RecyclerViewItemAnimatorSubject isNotRunning() {
    assertThat(actual().isRunning())
        .named("is running")
        .isFalse();
    return this;
  }
}
