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
 * Propositions for {@link RecyclerView.LayoutParams} subjects.
 */
public class RecyclerViewLayoutParamsSubject
    extends Subject<RecyclerViewLayoutParamsSubject, RecyclerView.LayoutParams> {

  public RecyclerViewLayoutParamsSubject(FailureMetadata failureMetadata, RecyclerView.LayoutParams subject) {
    super(failureMetadata, subject);
  }

  public RecyclerViewLayoutParamsSubject viewNeedsUpdate() {
    assertThat(actual().viewNeedsUpdate())
        .named("view needs update")
        .isTrue();
    return this;
  }

  public RecyclerViewLayoutParamsSubject viewDoesNotNeedUpdate() {
    assertThat(actual().viewNeedsUpdate())
        .named("view needs update")
        .isFalse();
    return this;
  }

  public RecyclerViewLayoutParamsSubject isViewInvalid() {
    assertThat(actual().isViewInvalid())
        .named("is view invalid")
        .isTrue();
    return this;
  }

  public RecyclerViewLayoutParamsSubject isViewValid() {
    assertThat(actual().isViewInvalid())
        .named("is view invalid")
        .isFalse();
    return this;
  }

  public RecyclerViewLayoutParamsSubject isItemRemoved() {
    assertThat(actual().isItemRemoved())
        .named("is item removed")
        .isTrue();
    return this;
  }

  public RecyclerViewLayoutParamsSubject isItemNotRemoved() {
    assertThat(actual().isItemRemoved())
        .named("is item removed")
        .isFalse();
    return this;
  }

  @SuppressWarnings("deprecation")
  public RecyclerViewLayoutParamsSubject hasViewPosition(int position) {
    assertThat(actual().getViewPosition())
        .named("view position")
        .isEqualTo(position);
    return this;
  }
}
