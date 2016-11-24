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

import android.support.v4.widget.SwipeRefreshLayout;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;
import com.pkware.truth.android.view.AbstractViewGroupSubject;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link SwipeRefreshLayout} subjects.
 */
public class SwipeRefreshLayoutSubject
    extends AbstractViewGroupSubject<SwipeRefreshLayoutSubject, SwipeRefreshLayout> {
  protected SwipeRefreshLayoutSubject(FailureStrategy failureStrategy, SwipeRefreshLayout subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<SwipeRefreshLayoutSubject, SwipeRefreshLayout> type() {
    return new SubjectFactory<SwipeRefreshLayoutSubject, SwipeRefreshLayout>() {
      @Override
      public SwipeRefreshLayoutSubject getSubject(FailureStrategy fs, SwipeRefreshLayout that) {
        return new SwipeRefreshLayoutSubject(fs, that);
      }
    };
  }

  public SwipeRefreshLayoutSubject isRefreshing() {
    assertThat(actual().isRefreshing())
        .named("is refreshing")
        .isTrue();
    return this;
  }

  public SwipeRefreshLayoutSubject isNotRefreshing() {
    assertThat(actual().isRefreshing())
        .named("is refreshing")
        .isFalse();
    return this;
  }
}
