// Copyright 2019 PKWARE, Inc.
//
// This class is generated. Do not modify directly!
package com.pkware.truth.androidx.loader;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static com.google.common.truth.Truth.assertAbout;

/** Assertions for testing Android classes. */
@SuppressWarnings("deprecation")
public final class Assertions {
  @Nonnull
  public static com.pkware.truth.androidx.loader.app.LoaderManagerSubject assertThat(
      @Nullable androidx.loader.app.LoaderManager target) {
    return assertAbout(com.pkware.truth.androidx.loader.app.LoaderManagerSubject::new).that(target);
  }

  @Nonnull
  public static com.pkware.truth.androidx.loader.content.CursorLoaderSubject assertThat(
      @Nullable androidx.loader.content.CursorLoader target) {
    return assertAbout(com.pkware.truth.androidx.loader.content.CursorLoaderSubject::new).that(target);
  }

  @Nonnull
  public static com.pkware.truth.androidx.loader.content.LoaderSubject assertThat(
      @Nullable androidx.loader.content.Loader target) {
    return assertAbout(com.pkware.truth.androidx.loader.content.LoaderSubject::new).that(target);
  }

  private Assertions() {
    throw new AssertionError("No instances.");
  }
}
