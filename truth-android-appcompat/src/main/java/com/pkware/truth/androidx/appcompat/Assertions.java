// Copyright 2019 PKWARE, Inc.
//
// This class is generated. Do not modify directly!
package com.pkware.truth.androidx.appcompat;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static com.google.common.truth.Truth.assertAbout;

/** Assertions for testing Android classes. */
@SuppressWarnings("deprecation")
public final class Assertions {
  @Nonnull
  public static com.pkware.truth.androidx.appcompat.app.ActionBarSubject assertThat(
      @Nullable androidx.appcompat.app.ActionBar target) {
    return assertAbout(com.pkware.truth.androidx.appcompat.app.ActionBarSubject::new).that(target);
  }

  @Nonnull
  public static com.pkware.truth.androidx.appcompat.view.ActionModeSubject assertThat(
      @Nullable androidx.appcompat.view.ActionMode target) {
    return assertAbout(com.pkware.truth.androidx.appcompat.view.ActionModeSubject::new).that(target);
  }

  @Nonnull
  public static com.pkware.truth.androidx.appcompat.widget.LinearLayoutCompatSubject assertThat(
      @Nullable androidx.appcompat.widget.LinearLayoutCompat target) {
    return assertAbout(com.pkware.truth.androidx.appcompat.widget.LinearLayoutCompatSubject::new).that(target);
  }

  @Nonnull
  public static com.pkware.truth.androidx.appcompat.widget.SearchViewSubject assertThat(
      @Nullable androidx.appcompat.widget.SearchView target) {
    return assertAbout(com.pkware.truth.androidx.appcompat.widget.SearchViewSubject::new).that(target);
  }

  private Assertions() {
    throw new AssertionError("No instances.");
  }
}
