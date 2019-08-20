// Copyright 2019 PKWARE, Inc.
//
// This class is generated. Do not modify directly!
package com.pkware.truth.androidx.palette;

import static com.google.common.truth.Truth.assertAbout;

/** Assertions for testing Android classes. */
@SuppressWarnings("deprecation")
public final class Assertions {
  public static com.pkware.truth.androidx.palette.graphics.PaletteSubject assertThat(
      androidx.palette.graphics.Palette target) {
    return assertAbout(com.pkware.truth.androidx.palette.graphics.PaletteSubject::new).that(target);
  }

  public static com.pkware.truth.androidx.palette.graphics.PaletteSwatchSubject assertThat(
      androidx.palette.graphics.Palette.Swatch target) {
    return assertAbout(com.pkware.truth.androidx.palette.graphics.PaletteSwatchSubject::new).that(target);
  }

  private Assertions() {
    throw new AssertionError("No instances.");
  }
}
