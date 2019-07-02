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

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;
import com.pkware.truth.android.view.AbstractViewGroupSubject;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link SwipeRefreshLayout} subjects.
 */
public class SwipeRefreshLayoutSubject
    extends AbstractViewGroupSubject<SwipeRefreshLayoutSubject, SwipeRefreshLayout> {
  protected SwipeRefreshLayoutSubject(FailureMetadata failureMetadata, SwipeRefreshLayout subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<SwipeRefreshLayoutSubject, SwipeRefreshLayout> type() {
    return SwipeRefreshLayoutSubject::new;
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
