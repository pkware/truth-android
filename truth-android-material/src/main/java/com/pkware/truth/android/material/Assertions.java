// Copyright 2019 PKWARE, Inc.
//
// This class is generated. Do not modify directly!
package com.pkware.truth.android.material;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static com.google.common.truth.Truth.assertAbout;

/** Assertions for testing Android classes. */
@SuppressWarnings("deprecation")
public final class Assertions {
  @Nonnull
  public static com.pkware.truth.android.material.navigation.NavigationViewSubject assertThat(
      @Nullable com.google.android.material.navigation.NavigationView target) {
    return assertAbout(com.pkware.truth.android.material.navigation.NavigationViewSubject::new).that(target);
  }

  @Nonnull
  public static com.pkware.truth.android.material.snackbar.SnackbarSubject assertThat(
      @Nullable com.google.android.material.snackbar.Snackbar target) {
    return assertAbout(com.pkware.truth.android.material.snackbar.SnackbarSubject::new).that(target);
  }

  @Nonnull
  public static com.pkware.truth.android.material.tabs.TabLayoutSubject assertThat(
      @Nullable com.google.android.material.tabs.TabLayout target) {
    return assertAbout(com.pkware.truth.android.material.tabs.TabLayoutSubject::new).that(target);
  }

  @Nonnull
  public static com.pkware.truth.android.material.tabs.TabLayoutTabSubject assertThat(
      @Nullable com.google.android.material.tabs.TabLayout.Tab target) {
    return assertAbout(com.pkware.truth.android.material.tabs.TabLayoutTabSubject::new).that(target);
  }

  @Nonnull
  public static com.pkware.truth.android.material.textfield.TextInputLayoutSubject assertThat(
      @Nullable com.google.android.material.textfield.TextInputLayout target) {
    return assertAbout(com.pkware.truth.android.material.textfield.TextInputLayoutSubject::new).that(target);
  }

  private Assertions() {
    throw new AssertionError("No instances.");
  }
}
