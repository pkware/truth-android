// Copyright 2019 PKWARE, Inc.
//
// This class is generated. Do not modify directly!
package com.pkware.truth.androidx.recyclerview;

import com.google.common.truth.Subject;

import static com.google.common.truth.Truth.assertAbout;

/** Assertions for testing Android classes. */
@SuppressWarnings("deprecation")
public final class Assertions {
  public static <VH extends androidx.recyclerview.widget.RecyclerView.ViewHolder> com.pkware.truth.androidx.recyclerview.widget.RecyclerViewAdapterSubject<VH> assertThat(
      androidx.recyclerview.widget.RecyclerView.Adapter<VH> target) {
    Subject.Factory<com.pkware.truth.androidx.recyclerview.widget.RecyclerViewAdapterSubject<VH>, androidx.recyclerview.widget.RecyclerView.Adapter<VH>> type = com.pkware.truth.androidx.recyclerview.widget.RecyclerViewAdapterSubject.type();
    return assertAbout(type).that(target);
  }

  public static com.pkware.truth.androidx.recyclerview.widget.RecyclerViewItemAnimatorSubject assertThat(
      androidx.recyclerview.widget.RecyclerView.ItemAnimator target) {
    Subject.Factory<com.pkware.truth.androidx.recyclerview.widget.RecyclerViewItemAnimatorSubject, androidx.recyclerview.widget.RecyclerView.ItemAnimator> type = com.pkware.truth.androidx.recyclerview.widget.RecyclerViewItemAnimatorSubject.type();
    return assertAbout(type).that(target);
  }

  public static com.pkware.truth.androidx.recyclerview.widget.RecyclerViewLayoutManagerSubject assertThat(
      androidx.recyclerview.widget.RecyclerView.LayoutManager target) {
    Subject.Factory<com.pkware.truth.androidx.recyclerview.widget.RecyclerViewLayoutManagerSubject, androidx.recyclerview.widget.RecyclerView.LayoutManager> type = com.pkware.truth.androidx.recyclerview.widget.RecyclerViewLayoutManagerSubject.type();
    return assertAbout(type).that(target);
  }

  public static com.pkware.truth.androidx.recyclerview.widget.RecyclerViewLayoutParamsSubject assertThat(
      androidx.recyclerview.widget.RecyclerView.LayoutParams target) {
    Subject.Factory<com.pkware.truth.androidx.recyclerview.widget.RecyclerViewLayoutParamsSubject, androidx.recyclerview.widget.RecyclerView.LayoutParams> type = com.pkware.truth.androidx.recyclerview.widget.RecyclerViewLayoutParamsSubject.type();
    return assertAbout(type).that(target);
  }

  public static com.pkware.truth.androidx.recyclerview.widget.RecyclerViewSmoothScrollerActionSubject assertThat(
      androidx.recyclerview.widget.RecyclerView.SmoothScroller.Action target) {
    Subject.Factory<com.pkware.truth.androidx.recyclerview.widget.RecyclerViewSmoothScrollerActionSubject, androidx.recyclerview.widget.RecyclerView.SmoothScroller.Action> type = com.pkware.truth.androidx.recyclerview.widget.RecyclerViewSmoothScrollerActionSubject.type();
    return assertAbout(type).that(target);
  }

  public static com.pkware.truth.androidx.recyclerview.widget.RecyclerViewSmoothScrollerSubject assertThat(
      androidx.recyclerview.widget.RecyclerView.SmoothScroller target) {
    Subject.Factory<com.pkware.truth.androidx.recyclerview.widget.RecyclerViewSmoothScrollerSubject, androidx.recyclerview.widget.RecyclerView.SmoothScroller> type = com.pkware.truth.androidx.recyclerview.widget.RecyclerViewSmoothScrollerSubject.type();
    return assertAbout(type).that(target);
  }

  public static com.pkware.truth.androidx.recyclerview.widget.RecyclerViewSubject assertThat(
      androidx.recyclerview.widget.RecyclerView target) {
    Subject.Factory<com.pkware.truth.androidx.recyclerview.widget.RecyclerViewSubject, androidx.recyclerview.widget.RecyclerView> type = com.pkware.truth.androidx.recyclerview.widget.RecyclerViewSubject.type();
    return assertAbout(type).that(target);
  }

  public static com.pkware.truth.androidx.recyclerview.widget.RecyclerViewViewHolderSubject assertThat(
      androidx.recyclerview.widget.RecyclerView.ViewHolder target) {
    Subject.Factory<com.pkware.truth.androidx.recyclerview.widget.RecyclerViewViewHolderSubject, androidx.recyclerview.widget.RecyclerView.ViewHolder> type = com.pkware.truth.androidx.recyclerview.widget.RecyclerViewViewHolderSubject.type();
    return assertAbout(type).that(target);
  }

  private Assertions() {
    throw new AssertionError("No instances.");
  }
}
