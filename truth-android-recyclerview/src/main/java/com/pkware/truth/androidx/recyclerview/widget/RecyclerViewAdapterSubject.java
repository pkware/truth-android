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

import static androidx.recyclerview.widget.RecyclerView.ViewHolder;

/**
 * Propositions for {@link RecyclerView.Adapter} subjects.
 */
public class RecyclerViewAdapterSubject<VH extends ViewHolder> extends Subject {

  @Nullable
  private final RecyclerView.Adapter<VH> actual;

  public RecyclerViewAdapterSubject(@Nonnull FailureMetadata failureMetadata, @Nullable RecyclerView.Adapter<VH> actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasItemCount(int count) {
    check("getItemCount()").that(actual.getItemCount()).isEqualTo(count);
  }

  public void hasStableIds() {
    check("hasStableIds()").that(actual.hasStableIds()).isTrue();
  }

  public void doesNotHaveStableIds() {
    check("hasStableIds()").that(actual.hasStableIds()).isFalse();
  }

  public void hasObservers() {
    check("hasObservers()").that(actual.hasObservers()).isTrue();
  }

  public void doesNotHaveObservers() {
    check("hasObservers()").that(actual.hasObservers()).isFalse();
  }
}
