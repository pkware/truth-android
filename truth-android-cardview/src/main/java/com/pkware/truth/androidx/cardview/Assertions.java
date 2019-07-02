// Copyright 2019 PKWARE, Inc.
//
// This class is generated. Do not modify directly!
package com.pkware.truth.androidx.cardview;

import com.google.common.truth.Subject;

import static com.google.common.truth.Truth.assertAbout;

/** Assertions for testing Android classes. */
@SuppressWarnings("deprecation")
public final class Assertions {
  public static com.pkware.truth.androidx.cardview.widget.CardViewSubject assertThat(
      androidx.cardview.widget.CardView target) {
    Subject.Factory<com.pkware.truth.androidx.cardview.widget.CardViewSubject, androidx.cardview.widget.CardView> type = com.pkware.truth.androidx.cardview.widget.CardViewSubject.type();
    return assertAbout(type).that(target);
  }

  private Assertions() {
    throw new AssertionError("No instances.");
  }
}
