// Copyright 2018 PKWARE, Inc.
//
// This class is generated. Do not modify directly!
package com.pkware.truth.android.design;

import com.google.common.truth.Subject;

import static com.google.common.truth.Truth.assertAbout;

/** Assertions for testing Android classes. */
@SuppressWarnings("deprecation")
public final class Assertions {
  public static com.pkware.truth.android.design.widget.NavigationViewSubject assertThat(
      com.google.android.material.navigation.NavigationView target) {
    Subject.Factory<com.pkware.truth.android.design.widget.NavigationViewSubject, com.google.android.material.navigation.NavigationView> type = com.pkware.truth.android.design.widget.NavigationViewSubject.type();
    return assertAbout(type).that(target);
  }

  public static com.pkware.truth.android.design.widget.SnackbarSubject assertThat(
      com.google.android.material.snackbar.Snackbar target) {
    Subject.Factory<com.pkware.truth.android.design.widget.SnackbarSubject, com.google.android.material.snackbar.Snackbar> type = com.pkware.truth.android.design.widget.SnackbarSubject.type();
    return assertAbout(type).that(target);
  }

  public static com.pkware.truth.android.design.widget.TabLayoutSubject assertThat(
      com.google.android.material.tabs.TabLayout target) {
    Subject.Factory<com.pkware.truth.android.design.widget.TabLayoutSubject, com.google.android.material.tabs.TabLayout> type = com.pkware.truth.android.design.widget.TabLayoutSubject.type();
    return assertAbout(type).that(target);
  }

  public static com.pkware.truth.android.design.widget.TabLayoutTabSubject assertThat(
      com.google.android.material.tabs.TabLayout.Tab target) {
    Subject.Factory<com.pkware.truth.android.design.widget.TabLayoutTabSubject, com.google.android.material.tabs.TabLayout.Tab> type = com.pkware.truth.android.design.widget.TabLayoutTabSubject.type();
    return assertAbout(type).that(target);
  }

  public static com.pkware.truth.android.design.widget.TextInputLayoutSubject assertThat(
      com.google.android.material.textfield.TextInputLayout target) {
    Subject.Factory<com.pkware.truth.android.design.widget.TextInputLayoutSubject, com.google.android.material.textfield.TextInputLayout> type = com.pkware.truth.android.design.widget.TextInputLayoutSubject.type();
    return assertAbout(type).that(target);
  }

  private Assertions() {
    throw new AssertionError("No instances.");
  }
}
