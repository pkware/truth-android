// Copyright 2019 PKWARE, Inc.
//
// This class is generated. Do not modify directly!
package com.pkware.truth.androidx.recyclerview;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static com.google.common.truth.Truth.assertAbout;

/** Assertions for testing Android classes. */
@SuppressWarnings("deprecation")
public final class Assertions {
  @Nonnull
  public static <VH extends androidx.recyclerview.widget.RecyclerView.ViewHolder> com.pkware.truth.androidx.recyclerview.widget.RecyclerViewAdapterSubject<VH> assertThat(
      @Nullable androidx.recyclerview.widget.RecyclerView.Adapter<VH> target) {
    return assertAbout(com.pkware.truth.androidx.recyclerview.widget.RecyclerViewAdapterSubject<VH>::new).that(target);
  }

  @Nonnull
  public static com.pkware.truth.androidx.recyclerview.widget.RecyclerViewItemAnimatorSubject assertThat(
      @Nullable androidx.recyclerview.widget.RecyclerView.ItemAnimator target) {
    return assertAbout(com.pkware.truth.androidx.recyclerview.widget.RecyclerViewItemAnimatorSubject::new).that(target);
  }

  @Nonnull
  public static com.pkware.truth.androidx.recyclerview.widget.RecyclerViewLayoutManagerSubject assertThat(
      @Nullable androidx.recyclerview.widget.RecyclerView.LayoutManager target) {
    return assertAbout(com.pkware.truth.androidx.recyclerview.widget.RecyclerViewLayoutManagerSubject::new).that(target);
  }

  @Nonnull
  public static com.pkware.truth.androidx.recyclerview.widget.RecyclerViewLayoutParamsSubject assertThat(
      @Nullable androidx.recyclerview.widget.RecyclerView.LayoutParams target) {
    return assertAbout(com.pkware.truth.androidx.recyclerview.widget.RecyclerViewLayoutParamsSubject::new).that(target);
  }

  @Nonnull
  public static com.pkware.truth.androidx.recyclerview.widget.RecyclerViewSmoothScrollerActionSubject assertThat(
      @Nullable androidx.recyclerview.widget.RecyclerView.SmoothScroller.Action target) {
    return assertAbout(com.pkware.truth.androidx.recyclerview.widget.RecyclerViewSmoothScrollerActionSubject::new).that(target);
  }

  @Nonnull
  public static com.pkware.truth.androidx.recyclerview.widget.RecyclerViewSmoothScrollerSubject assertThat(
      @Nullable androidx.recyclerview.widget.RecyclerView.SmoothScroller target) {
    return assertAbout(com.pkware.truth.androidx.recyclerview.widget.RecyclerViewSmoothScrollerSubject::new).that(target);
  }

  @Nonnull
  public static com.pkware.truth.androidx.recyclerview.widget.RecyclerViewSubject assertThat(
      @Nullable androidx.recyclerview.widget.RecyclerView target) {
    return assertAbout(com.pkware.truth.androidx.recyclerview.widget.RecyclerViewSubject::new).that(target);
  }

  @Nonnull
  public static com.pkware.truth.androidx.recyclerview.widget.RecyclerViewViewHolderSubject assertThat(
      @Nullable androidx.recyclerview.widget.RecyclerView.ViewHolder target) {
    return assertAbout(com.pkware.truth.androidx.recyclerview.widget.RecyclerViewViewHolderSubject::new).that(target);
  }

  private Assertions() {
    throw new AssertionError("No instances.");
  }
}
