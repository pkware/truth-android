// Copyright 2019 PKWARE, Inc.
//
// This class is generated. Do not modify directly!
package com.pkware.truth.androidx.fragment;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static com.google.common.truth.Truth.assertAbout;

/** Assertions for testing Android classes. */
@SuppressWarnings("deprecation")
public final class Assertions {
  @Nonnull
  public static com.pkware.truth.androidx.fragment.app.DialogFragmentSubject assertThat(
      @Nullable androidx.fragment.app.DialogFragment target) {
    return assertAbout(com.pkware.truth.androidx.fragment.app.DialogFragmentSubject::new).that(target);
  }

  @Nonnull
  public static com.pkware.truth.androidx.fragment.app.FragmentManagerSubject assertThat(
      @Nullable androidx.fragment.app.FragmentManager target) {
    return assertAbout(com.pkware.truth.androidx.fragment.app.FragmentManagerSubject::new).that(target);
  }

  @Nonnull
  public static com.pkware.truth.androidx.fragment.app.FragmentSubject assertThat(
      @Nullable androidx.fragment.app.Fragment target) {
    return assertAbout(com.pkware.truth.androidx.fragment.app.FragmentSubject::new).that(target);
  }

  @Nonnull
  public static com.pkware.truth.androidx.fragment.app.FragmentTransactionSubject assertThat(
      @Nullable androidx.fragment.app.FragmentTransaction target) {
    return assertAbout(com.pkware.truth.androidx.fragment.app.FragmentTransactionSubject::new).that(target);
  }

  @Nonnull
  public static com.pkware.truth.androidx.fragment.app.ListFragmentSubject assertThat(
      @Nullable androidx.fragment.app.ListFragment target) {
    return assertAbout(com.pkware.truth.androidx.fragment.app.ListFragmentSubject::new).that(target);
  }

  private Assertions() {
    throw new AssertionError("No instances.");
  }
}
