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
import com.pkware.truth.android.view.AbstractViewGroupSubject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static androidx.recyclerview.widget.RecyclerView.Adapter;
import static androidx.recyclerview.widget.RecyclerView.ItemAnimator;
import static androidx.recyclerview.widget.RecyclerView.LayoutManager;
import static androidx.recyclerview.widget.RecyclerView.RecycledViewPool;
import static androidx.recyclerview.widget.RecyclerView.SCROLL_STATE_DRAGGING;
import static androidx.recyclerview.widget.RecyclerView.SCROLL_STATE_IDLE;
import static androidx.recyclerview.widget.RecyclerView.SCROLL_STATE_SETTLING;
import static androidx.recyclerview.widget.RecyclerView.ViewHolder;
import static com.pkware.truth.android.internal.IntegerUtils.buildNamedValueString;

/**
 * Propositions for {@link RecyclerView} subjects.
 */
public class RecyclerViewSubject extends AbstractViewGroupSubject<RecyclerView> {

  @Nullable
  private final RecyclerView actual;

  public RecyclerViewSubject(@Nonnull FailureMetadata failureMetadata, @Nullable RecyclerView actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  @Nonnull
  public static String scrollStateToString(@RecyclerViewScrollState int scrollState) {
    return buildNamedValueString(scrollState)
        .value(SCROLL_STATE_DRAGGING, "dragging")
        .value(SCROLL_STATE_IDLE, "idle")
        .value(SCROLL_STATE_SETTLING, "settling")
        .get();
  }

  public <VH extends ViewHolder> void hasAdapter(@Nullable Adapter<VH> adapter) {
    check("getAdapter()").that(actual.getAdapter()).isEqualTo(adapter);
  }

  public void hasItemAnimator(@Nullable ItemAnimator itemAnimator) {
    check("getItemAnimator()").that(actual.getItemAnimator()).isEqualTo(itemAnimator);
  }

  public void hasLayoutManager(@Nullable LayoutManager layoutManager) {
    check("getLayoutManager()").that(actual.getLayoutManager()).isEqualTo(layoutManager);
  }

  public void hasRecycledViewPool(@Nullable RecycledViewPool recycledViewPool) {
    check("getRecycledViewPool()").that(actual.getRecycledViewPool()).isEqualTo(recycledViewPool);
  }

  public void hasScrollState(@RecyclerViewScrollState int scrollState) {
    int actualScrollState = actual.getScrollState();
    //noinspection ResourceType
    check("getScrollState()")
        .withMessage("Expected scroll state <%s> but was <%s>.",
            scrollStateToString(scrollState), scrollStateToString(actualScrollState))
        .that(actualScrollState)
        .isEqualTo(scrollState);
  }

  public void hasFixedSize() {
    check("hasFixedSize()").that(actual.hasFixedSize()).isTrue();
  }

  public void doesNotHaveFixedSize() {
    check("hasFixedSize()").that(actual.hasFixedSize()).isFalse();
  }
}
