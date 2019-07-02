// Copyright 2018 PKWARE, Inc.
//
// This class is generated. Do not modify directly!
package com.pkware.truth.android.palette.v7;

import com.google.common.truth.Subject;

import static com.google.common.truth.Truth.assertAbout;

/** Assertions for testing Android classes. */
@SuppressWarnings("deprecation")
public final class Assertions {
  public static com.pkware.truth.android.palette.v7.graphics.PaletteSubject assertThat(
      androidx.palette.graphics.Palette target) {
    Subject.Factory<com.pkware.truth.android.palette.v7.graphics.PaletteSubject, androidx.palette.graphics.Palette> type = com.pkware.truth.android.palette.v7.graphics.PaletteSubject.type();
    return assertAbout(type).that(target);
  }

  public static com.pkware.truth.android.palette.v7.graphics.PaletteSwatchSubject assertThat(
      androidx.palette.graphics.Palette.Swatch target) {
    Subject.Factory<com.pkware.truth.android.palette.v7.graphics.PaletteSwatchSubject, androidx.palette.graphics.Palette.Swatch> type = com.pkware.truth.android.palette.v7.graphics.PaletteSwatchSubject.type();
    return assertAbout(type).that(target);
  }

  private Assertions() {
    throw new AssertionError("No instances.");
  }
}
