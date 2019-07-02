// Copyright 2019 PKWARE, Inc.
//
// This class is generated. Do not modify directly!
package com.pkware.truth.android.material;

import com.google.common.truth.Subject;

import static com.google.common.truth.Truth.assertAbout;

/** Assertions for testing Android classes. */
@SuppressWarnings("deprecation")
public final class Assertions {
  public static com.pkware.truth.android.material.navigation.NavigationViewSubject assertThat(
      com.google.android.material.navigation.NavigationView target) {
    Subject.Factory<com.pkware.truth.android.material.navigation.NavigationViewSubject, com.google.android.material.navigation.NavigationView> type = com.pkware.truth.android.material.navigation.NavigationViewSubject.type();
    return assertAbout(type).that(target);
  }

  public static com.pkware.truth.android.material.snackbar.SnackbarSubject assertThat(
      com.google.android.material.snackbar.Snackbar target) {
    Subject.Factory<com.pkware.truth.android.material.snackbar.SnackbarSubject, com.google.android.material.snackbar.Snackbar> type = com.pkware.truth.android.material.snackbar.SnackbarSubject.type();
    return assertAbout(type).that(target);
  }

  public static com.pkware.truth.android.material.tabs.TabLayoutSubject assertThat(
      com.google.android.material.tabs.TabLayout target) {
    Subject.Factory<com.pkware.truth.android.material.tabs.TabLayoutSubject, com.google.android.material.tabs.TabLayout> type = com.pkware.truth.android.material.tabs.TabLayoutSubject.type();
    return assertAbout(type).that(target);
  }

  public static com.pkware.truth.android.material.tabs.TabLayoutTabSubject assertThat(
      com.google.android.material.tabs.TabLayout.Tab target) {
    Subject.Factory<com.pkware.truth.android.material.tabs.TabLayoutTabSubject, com.google.android.material.tabs.TabLayout.Tab> type = com.pkware.truth.android.material.tabs.TabLayoutTabSubject.type();
    return assertAbout(type).that(target);
  }

  public static com.pkware.truth.android.material.textfield.TextInputLayoutSubject assertThat(
      com.google.android.material.textfield.TextInputLayout target) {
    Subject.Factory<com.pkware.truth.android.material.textfield.TextInputLayoutSubject, com.google.android.material.textfield.TextInputLayout> type = com.pkware.truth.android.material.textfield.TextInputLayoutSubject.type();
    return assertAbout(type).that(target);
  }

  private Assertions() {
    throw new AssertionError("No instances.");
  }
}
