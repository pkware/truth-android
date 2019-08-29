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
 * Propositions for {@link RecyclerView.ViewHolder} subjects.
 */
public class RecyclerViewViewHolderSubject extends Subject {

  @Nullable
  private final RecyclerView.ViewHolder actual;

  public RecyclerViewViewHolderSubject(@Nonnull FailureMetadata failureMetadata, @Nullable RecyclerView.ViewHolder actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  @SuppressWarnings("deprecation")
  public void hasPosition(int position) {
    check("getPosition()").that(actual.getPosition()).isEqualTo(position);
  }

  public void hasItemId(long itemId) {
    check("getItemId()").that(actual.getItemId()).isEqualTo(itemId);
  }

  public void hasItemViewType(int itemViewType) {
    check("getItemViewType()").that(actual.getItemViewType()).isEqualTo(itemViewType);
  }

  public void isRecyclable() {
    check("isRecyclable()").that(actual.isRecyclable()).isTrue();
  }

  public void isNotRecyclable() {
    check("isRecyclable()").that(actual.isRecyclable()).isFalse();
  }
}
