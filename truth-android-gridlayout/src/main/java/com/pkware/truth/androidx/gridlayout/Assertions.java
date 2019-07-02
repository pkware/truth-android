// Copyright 2019 PKWARE, Inc.
//
// This class is generated. Do not modify directly!
package com.pkware.truth.androidx.gridlayout;

import com.google.common.truth.Subject;

import static com.google.common.truth.Truth.assertAbout;

/** Assertions for testing Android classes. */
@SuppressWarnings("deprecation")
public final class Assertions {
  public static com.pkware.truth.androidx.gridlayout.widget.GridLayoutSubject assertThat(
      androidx.gridlayout.widget.GridLayout target) {
    Subject.Factory<com.pkware.truth.androidx.gridlayout.widget.GridLayoutSubject, androidx.gridlayout.widget.GridLayout> type = com.pkware.truth.androidx.gridlayout.widget.GridLayoutSubject.type();
    return assertAbout(type).that(target);
  }

  private Assertions() {
    throw new AssertionError("No instances.");
  }
}
