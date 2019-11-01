// Copyright 2019 PKWARE, Inc.
//
// This class is generated. Do not modify directly!
package com.pkware.truth.androidx.swiperefreshlayout;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static com.google.common.truth.Truth.assertAbout;

/** Assertions for testing Android classes. */
@SuppressWarnings("deprecation")
public final class Assertions {
  @Nonnull
  public static com.pkware.truth.androidx.swiperefreshlayout.widget.SwipeRefreshLayoutSubject assertThat(
      @Nullable androidx.swiperefreshlayout.widget.SwipeRefreshLayout target) {
    return assertAbout(com.pkware.truth.androidx.swiperefreshlayout.widget.SwipeRefreshLayoutSubject::new).that(target);
  }

  private Assertions() {
    throw new AssertionError("No instances.");
  }
}
