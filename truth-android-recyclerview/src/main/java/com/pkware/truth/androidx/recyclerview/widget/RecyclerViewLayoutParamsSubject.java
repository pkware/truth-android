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
 * Propositions for {@link RecyclerView.LayoutParams} subjects.
 */
public class RecyclerViewLayoutParamsSubject extends Subject {

  @Nullable
  private final RecyclerView.LayoutParams actual;

  public RecyclerViewLayoutParamsSubject(@Nonnull FailureMetadata failureMetadata, @Nullable RecyclerView.LayoutParams actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public RecyclerViewLayoutParamsSubject viewNeedsUpdate() {
    check("viewNeedsUpdate()").that(actual.viewNeedsUpdate()).isTrue();
    return this;
  }

  public RecyclerViewLayoutParamsSubject viewDoesNotNeedUpdate() {
    check("viewNeedsUpdate()").that(actual.viewNeedsUpdate()).isFalse();
    return this;
  }

  public RecyclerViewLayoutParamsSubject isViewInvalid() {
    check("isViewInvalid()").that(actual.isViewInvalid()).isTrue();
    return this;
  }

  public RecyclerViewLayoutParamsSubject isViewValid() {
    check("isViewInvalid()").that(actual.isViewInvalid()).isFalse();
    return this;
  }

  public RecyclerViewLayoutParamsSubject isItemRemoved() {
    check("isItemRemoved()").that(actual.isItemRemoved()).isTrue();
    return this;
  }

  public RecyclerViewLayoutParamsSubject isItemNotRemoved() {
    check("isItemRemoved()").that(actual.isItemRemoved()).isFalse();
    return this;
  }

  @SuppressWarnings("deprecation")
  public RecyclerViewLayoutParamsSubject hasViewPosition(int position) {
    check("getViewPosition()").that(actual.getViewPosition()).isEqualTo(position);
    return this;
  }
}
