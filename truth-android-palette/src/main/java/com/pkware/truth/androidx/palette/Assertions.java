// Copyright 2019 PKWARE, Inc.
//
// This class is generated. Do not modify directly!
package com.pkware.truth.androidx.palette;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static com.google.common.truth.Truth.assertAbout;

/** Assertions for testing Android classes. */
@SuppressWarnings("deprecation")
public final class Assertions {
  @Nonnull
  public static com.pkware.truth.androidx.palette.graphics.PaletteSubject assertThat(
      @Nullable androidx.palette.graphics.Palette target) {
    return assertAbout(com.pkware.truth.androidx.palette.graphics.PaletteSubject::new).that(target);
  }

  @Nonnull
  public static com.pkware.truth.androidx.palette.graphics.PaletteSwatchSubject assertThat(
      @Nullable androidx.palette.graphics.Palette.Swatch target) {
    return assertAbout(com.pkware.truth.androidx.palette.graphics.PaletteSwatchSubject::new).that(target);
  }

  private Assertions() {
    throw new AssertionError("No instances.");
  }
}
