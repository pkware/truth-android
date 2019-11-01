// Copyright 2019 PKWARE, Inc.
//
// This class is generated. Do not modify directly!
package com.pkware.truth.androidx.core;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static com.google.common.truth.Truth.assertAbout;

/** Assertions for testing Android classes. */
@SuppressWarnings("deprecation")
public final class Assertions {
  @Nonnull
  public static com.pkware.truth.androidx.core.util.AtomicFileSubject assertThat(
      @Nullable androidx.core.util.AtomicFile target) {
    return assertAbout(com.pkware.truth.androidx.core.util.AtomicFileSubject::new).that(target);
  }

  private Assertions() {
    throw new AssertionError("No instances.");
  }
}
