// Copyright 2019 PKWARE, Inc.
//
// This class is generated. Do not modify directly!
package com.pkware.truth.androidx.cardview;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static com.google.common.truth.Truth.assertAbout;

/** Assertions for testing Android classes. */
@SuppressWarnings("deprecation")
public final class Assertions {
  @Nonnull
  public static com.pkware.truth.androidx.cardview.widget.CardViewSubject assertThat(
      @Nullable androidx.cardview.widget.CardView target) {
    return assertAbout(com.pkware.truth.androidx.cardview.widget.CardViewSubject::new).that(target);
  }

  private Assertions() {
    throw new AssertionError("No instances.");
  }
}
