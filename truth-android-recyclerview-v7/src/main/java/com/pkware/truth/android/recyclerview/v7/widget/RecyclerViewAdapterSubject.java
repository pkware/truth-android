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

import static android.support.v7.widget.RecyclerView.ViewHolder;
import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link RecyclerView.Adapter} subjects.
 */
public class RecyclerViewAdapterSubject<VH extends ViewHolder>
    extends Subject<RecyclerViewAdapterSubject<VH>, RecyclerView.Adapter<VH>> {

  protected RecyclerViewAdapterSubject(FailureStrategy failureStrategy, RecyclerView.Adapter<VH> subject) {
    super(failureStrategy, subject);
  }

  public static <VH extends ViewHolder> SubjectFactory<RecyclerViewAdapterSubject<VH>, RecyclerView.Adapter<VH>> type() {
    return new SubjectFactory<RecyclerViewAdapterSubject<VH>, RecyclerView.Adapter<VH>>() {
      @Override
      public RecyclerViewAdapterSubject<VH> getSubject(FailureStrategy fs, RecyclerView.Adapter<VH> that) {
        return new RecyclerViewAdapterSubject<VH>(fs, that);
      }
    };
  }

  public RecyclerViewAdapterSubject<VH> hasItemCount(int count) {
    assertThat(actual().getItemCount())
        .named("item count")
        .isEqualTo(count);
    return this;
  }

  public RecyclerViewAdapterSubject<VH> hasStableIds() {
    assertThat(actual().hasStableIds())
        .named("has stable IDs")
        .isTrue();
    return this;
  }

  public RecyclerViewAdapterSubject<VH> doesNotHaveStableIds() {
    assertThat(actual().hasStableIds())
        .named("has stable IDs")
        .isFalse();
    return this;
  }

  public RecyclerViewAdapterSubject<VH> hasObservers() {
    assertThat(actual().hasObservers())
        .named("has observers")
        .isTrue();
    return this;
  }

  public RecyclerViewAdapterSubject<VH> doesNotHaveObservers() {
    assertThat(actual().hasObservers())
        .named("has observers")
        .isFalse();
    return this;
  }
}
