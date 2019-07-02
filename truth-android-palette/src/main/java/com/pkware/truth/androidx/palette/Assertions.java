// Copyright 2019 PKWARE, Inc.
//
// This class is generated. Do not modify directly!
package com.pkware.truth.androidx.palette;

import com.google.common.truth.Subject;

import static com.google.common.truth.Truth.assertAbout;

/** Assertions for testing Android classes. */
@SuppressWarnings("deprecation")
public final class Assertions {
  public static com.pkware.truth.androidx.palette.graphics.PaletteSubject assertThat(
      androidx.palette.graphics.Palette target) {
    Subject.Factory<com.pkware.truth.androidx.palette.graphics.PaletteSubject, androidx.palette.graphics.Palette> type = com.pkware.truth.androidx.palette.graphics.PaletteSubject.type();
    return assertAbout(type).that(target);
  }

  public static com.pkware.truth.androidx.palette.graphics.PaletteSwatchSubject assertThat(
      androidx.palette.graphics.Palette.Swatch target) {
    Subject.Factory<com.pkware.truth.androidx.palette.graphics.PaletteSwatchSubject, androidx.palette.graphics.Palette.Swatch> type = com.pkware.truth.androidx.palette.graphics.PaletteSwatchSubject.type();
    return assertAbout(type).that(target);
  }

  private Assertions() {
    throw new AssertionError("No instances.");
  }
}
