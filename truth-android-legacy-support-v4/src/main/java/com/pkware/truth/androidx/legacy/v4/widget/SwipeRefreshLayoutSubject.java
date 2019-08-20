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
package com.pkware.truth.androidx.legacy.v4.widget;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.common.truth.FailureMetadata;
import com.pkware.truth.android.view.AbstractViewGroupSubject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link SwipeRefreshLayout} subjects.
 */
public class SwipeRefreshLayoutSubject extends AbstractViewGroupSubject<SwipeRefreshLayout> {

  @Nullable
  private final SwipeRefreshLayout actual;

  public SwipeRefreshLayoutSubject(@Nonnull FailureMetadata failureMetadata, @Nullable SwipeRefreshLayout actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public SwipeRefreshLayoutSubject isRefreshing() {
    check("isRefreshing()").that(actual.isRefreshing()).isTrue();
    return this;
  }

  public SwipeRefreshLayoutSubject isNotRefreshing() {
    check("isRefreshing()").that(actual.isRefreshing()).isFalse();
    return this;
  }
}
