// Copyright 2019 PKWARE, Inc.
//
// This class is generated. Do not modify directly!
package com.pkware.truth.androidx.gridlayout;

import static com.google.common.truth.Truth.assertAbout;

/** Assertions for testing Android classes. */
@SuppressWarnings("deprecation")
public final class Assertions {
  public static com.pkware.truth.androidx.gridlayout.widget.GridLayoutSubject assertThat(
      androidx.gridlayout.widget.GridLayout target) {
    return assertAbout(com.pkware.truth.androidx.gridlayout.widget.GridLayoutSubject::new).that(target);
  }

  private Assertions() {
    throw new AssertionError("No instances.");
  }
}
