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

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;
import com.pkware.truth.android.view.AbstractViewGroupSubject;

import static android.support.v7.widget.RecyclerView.Adapter;
import static android.support.v7.widget.RecyclerView.ItemAnimator;
import static android.support.v7.widget.RecyclerView.LayoutManager;
import static android.support.v7.widget.RecyclerView.RecycledViewPool;
import static android.support.v7.widget.RecyclerView.SCROLL_STATE_DRAGGING;
import static android.support.v7.widget.RecyclerView.SCROLL_STATE_IDLE;
import static android.support.v7.widget.RecyclerView.SCROLL_STATE_SETTLING;
import static android.support.v7.widget.RecyclerView.ViewHolder;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assert_;
import static com.pkware.truth.android.internal.IntegerUtils.buildNamedValueString;

/**
 * Propositions for {@link RecyclerView} subjects.
 */
public class RecyclerViewSubject extends AbstractViewGroupSubject<RecyclerViewSubject, RecyclerView> {
  protected RecyclerViewSubject(FailureMetadata failureMetadata, RecyclerView subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<RecyclerViewSubject, RecyclerView> type() {
    return RecyclerViewSubject::new;
  }

  public static String scrollStateToString(@RecyclerViewScrollState int scrollState) {
    return buildNamedValueString(scrollState)
        .value(SCROLL_STATE_DRAGGING, "dragging")
        .value(SCROLL_STATE_IDLE, "idle")
        .value(SCROLL_STATE_SETTLING, "settling")
        .get();
  }

  public <VH extends ViewHolder> RecyclerViewSubject hasAdapter(Adapter<VH> adapter) {
    assertThat(actual().getAdapter())
        .named("adapter")
        .isEqualTo(adapter);
    return this;
  }

  public RecyclerViewSubject hasItemAnimator(ItemAnimator itemAnimator) {
    assertThat(actual().getItemAnimator())
        .named("item animator")
        .isEqualTo(itemAnimator);
    return this;
  }

  public RecyclerViewSubject hasLayoutManager(LayoutManager layoutManager) {
    assertThat(actual().getLayoutManager())
        .named("layout manager")
        .isEqualTo(layoutManager);
    return this;
  }

  public RecyclerViewSubject hasRecycledViewPool(RecycledViewPool recycledViewPool) {
    assertThat(actual().getRecycledViewPool())
        .named("recycled view pool")
        .isEqualTo(recycledViewPool);
    return this;
  }

  public RecyclerViewSubject hasScrollState(@RecyclerViewScrollState int scrollState) {
    int actualScrollState = actual().getScrollState();
    //noinspection ResourceType
    assert_()
        .withMessage("Expected scroll state <%s> but was <%s>.",
            scrollStateToString(scrollState), scrollStateToString(actualScrollState))
        .that(actualScrollState)
        .isEqualTo(scrollState);
    return this;
  }

  public RecyclerViewSubject hasFixedSize() {
    assertThat(actual().hasFixedSize())
        .named("has fixed size")
        .isTrue();
    return this;
  }

  public RecyclerViewSubject doesNotHaveFixedSize() {
    assertThat(actual().hasFixedSize())
        .named("has fixed size")
        .isFalse();
    return this;
  }
}
