// Copyright 2019 PKWARE, Inc.
//
// This class is generated. Do not modify directly!
package com.pkware.truth.androidx.cursoradapter;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static com.google.common.truth.Truth.assertAbout;

/** Assertions for testing Android classes. */
@SuppressWarnings("deprecation")
public final class Assertions {
  @Nonnull
  public static com.pkware.truth.androidx.cursoradapter.widget.CursorAdapterSubject assertThat(
      @Nullable androidx.cursoradapter.widget.CursorAdapter target) {
    return assertAbout(com.pkware.truth.androidx.cursoradapter.widget.CursorAdapterSubject::new).that(target);
  }

  @Nonnull
  public static com.pkware.truth.androidx.cursoradapter.widget.SimpleCursorAdapterSubject assertThat(
      @Nullable androidx.cursoradapter.widget.SimpleCursorAdapter target) {
    return assertAbout(com.pkware.truth.androidx.cursoradapter.widget.SimpleCursorAdapterSubject::new).that(target);
  }

  private Assertions() {
    throw new AssertionError("No instances.");
  }
}
