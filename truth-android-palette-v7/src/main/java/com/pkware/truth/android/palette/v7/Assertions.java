// Copyright 2016 PKWARE, Inc.
//
// This class is generated. Do not modify directly!
package com.pkware.truth.android.palette.v7;

import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertAbout;

/** Assertions for testing Android classes. */
@SuppressWarnings("deprecation")
public final class Assertions {
  public static com.pkware.truth.android.palette.v7.graphics.PaletteSubject assertThat(
      android.support.v7.graphics.Palette target) {
    SubjectFactory<com.pkware.truth.android.palette.v7.graphics.PaletteSubject, android.support.v7.graphics.Palette> type = com.pkware.truth.android.palette.v7.graphics.PaletteSubject.type();
    return assertAbout(type).that(target);
  }

  public static com.pkware.truth.android.palette.v7.graphics.PaletteSwatchSubject assertThat(
      android.support.v7.graphics.Palette.Swatch target) {
    SubjectFactory<com.pkware.truth.android.palette.v7.graphics.PaletteSwatchSubject, android.support.v7.graphics.Palette.Swatch> type = com.pkware.truth.android.palette.v7.graphics.PaletteSwatchSubject.type();
    return assertAbout(type).that(target);
  }

  private Assertions() {
    throw new AssertionError("No instances.");
  }
}
