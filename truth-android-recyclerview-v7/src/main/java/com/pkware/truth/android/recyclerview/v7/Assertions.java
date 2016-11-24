// Copyright 2016 PKWARE, Inc.
//
// This class is generated. Do not modify directly!
package com.pkware.truth.android.recyclerview.v7;

import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertAbout;

/** Assertions for testing Android classes. */
@SuppressWarnings("deprecation")
public final class Assertions {
  public static <VH extends android.support.v7.widget.RecyclerView.ViewHolder> com.pkware.truth.android.recyclerview.v7.widget.RecyclerViewAdapterSubject<VH> assertThat(
      android.support.v7.widget.RecyclerView.Adapter<VH> target) {
    SubjectFactory<com.pkware.truth.android.recyclerview.v7.widget.RecyclerViewAdapterSubject<VH>, android.support.v7.widget.RecyclerView.Adapter<VH>> type = com.pkware.truth.android.recyclerview.v7.widget.RecyclerViewAdapterSubject.type();
    return assertAbout(type).that(target);
  }

  public static com.pkware.truth.android.recyclerview.v7.widget.RecyclerViewItemAnimatorSubject assertThat(
      android.support.v7.widget.RecyclerView.ItemAnimator target) {
    SubjectFactory<com.pkware.truth.android.recyclerview.v7.widget.RecyclerViewItemAnimatorSubject, android.support.v7.widget.RecyclerView.ItemAnimator> type = com.pkware.truth.android.recyclerview.v7.widget.RecyclerViewItemAnimatorSubject.type();
    return assertAbout(type).that(target);
  }

  public static com.pkware.truth.android.recyclerview.v7.widget.RecyclerViewLayoutManagerSubject assertThat(
      android.support.v7.widget.RecyclerView.LayoutManager target) {
    SubjectFactory<com.pkware.truth.android.recyclerview.v7.widget.RecyclerViewLayoutManagerSubject, android.support.v7.widget.RecyclerView.LayoutManager> type = com.pkware.truth.android.recyclerview.v7.widget.RecyclerViewLayoutManagerSubject.type();
    return assertAbout(type).that(target);
  }

  public static com.pkware.truth.android.recyclerview.v7.widget.RecyclerViewLayoutParamsSubject assertThat(
      android.support.v7.widget.RecyclerView.LayoutParams target) {
    SubjectFactory<com.pkware.truth.android.recyclerview.v7.widget.RecyclerViewLayoutParamsSubject, android.support.v7.widget.RecyclerView.LayoutParams> type = com.pkware.truth.android.recyclerview.v7.widget.RecyclerViewLayoutParamsSubject.type();
    return assertAbout(type).that(target);
  }

  public static com.pkware.truth.android.recyclerview.v7.widget.RecyclerViewSmoothScrollerActionSubject assertThat(
      android.support.v7.widget.RecyclerView.SmoothScroller.Action target) {
    SubjectFactory<com.pkware.truth.android.recyclerview.v7.widget.RecyclerViewSmoothScrollerActionSubject, android.support.v7.widget.RecyclerView.SmoothScroller.Action> type = com.pkware.truth.android.recyclerview.v7.widget.RecyclerViewSmoothScrollerActionSubject.type();
    return assertAbout(type).that(target);
  }

  public static com.pkware.truth.android.recyclerview.v7.widget.RecyclerViewSmoothScrollerSubject assertThat(
      android.support.v7.widget.RecyclerView.SmoothScroller target) {
    SubjectFactory<com.pkware.truth.android.recyclerview.v7.widget.RecyclerViewSmoothScrollerSubject, android.support.v7.widget.RecyclerView.SmoothScroller> type = com.pkware.truth.android.recyclerview.v7.widget.RecyclerViewSmoothScrollerSubject.type();
    return assertAbout(type).that(target);
  }

  public static com.pkware.truth.android.recyclerview.v7.widget.RecyclerViewSubject assertThat(
      android.support.v7.widget.RecyclerView target) {
    SubjectFactory<com.pkware.truth.android.recyclerview.v7.widget.RecyclerViewSubject, android.support.v7.widget.RecyclerView> type = com.pkware.truth.android.recyclerview.v7.widget.RecyclerViewSubject.type();
    return assertAbout(type).that(target);
  }

  public static com.pkware.truth.android.recyclerview.v7.widget.RecyclerViewViewHolderSubject assertThat(
      android.support.v7.widget.RecyclerView.ViewHolder target) {
    SubjectFactory<com.pkware.truth.android.recyclerview.v7.widget.RecyclerViewViewHolderSubject, android.support.v7.widget.RecyclerView.ViewHolder> type = com.pkware.truth.android.recyclerview.v7.widget.RecyclerViewViewHolderSubject.type();
    return assertAbout(type).that(target);
  }

  private Assertions() {
    throw new AssertionError("No instances.");
  }
}
