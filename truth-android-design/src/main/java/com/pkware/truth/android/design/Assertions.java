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
      android.support.design.widget.NavigationView target) {
    Subject.Factory<com.pkware.truth.android.design.widget.NavigationViewSubject, android.support.design.widget.NavigationView> type = com.pkware.truth.android.design.widget.NavigationViewSubject.type();
    return assertAbout(type).that(target);
  }

  public static com.pkware.truth.android.design.widget.SnackbarSubject assertThat(
      android.support.design.widget.Snackbar target) {
    Subject.Factory<com.pkware.truth.android.design.widget.SnackbarSubject, android.support.design.widget.Snackbar> type = com.pkware.truth.android.design.widget.SnackbarSubject.type();
    return assertAbout(type).that(target);
  }

  public static com.pkware.truth.android.design.widget.TabLayoutSubject assertThat(
      android.support.design.widget.TabLayout target) {
    Subject.Factory<com.pkware.truth.android.design.widget.TabLayoutSubject, android.support.design.widget.TabLayout> type = com.pkware.truth.android.design.widget.TabLayoutSubject.type();
    return assertAbout(type).that(target);
  }

  public static com.pkware.truth.android.design.widget.TabLayoutTabSubject assertThat(
      android.support.design.widget.TabLayout.Tab target) {
    Subject.Factory<com.pkware.truth.android.design.widget.TabLayoutTabSubject, android.support.design.widget.TabLayout.Tab> type = com.pkware.truth.android.design.widget.TabLayoutTabSubject.type();
    return assertAbout(type).that(target);
  }

  public static com.pkware.truth.android.design.widget.TextInputLayoutSubject assertThat(
      android.support.design.widget.TextInputLayout target) {
    Subject.Factory<com.pkware.truth.android.design.widget.TextInputLayoutSubject, android.support.design.widget.TextInputLayout> type = com.pkware.truth.android.design.widget.TextInputLayoutSubject.type();
    return assertAbout(type).that(target);
  }

  private Assertions() {
    throw new AssertionError("No instances.");
  }
}
