// Copyright 2018 PKWARE, Inc.
//
// This class is generated. Do not modify directly!
package com.pkware.truth.android.cardview.v7;

import com.google.common.truth.Subject;

import static com.google.common.truth.Truth.assertAbout;

/** Assertions for testing Android classes. */
@SuppressWarnings("deprecation")
public final class Assertions {
  public static com.pkware.truth.android.cardview.v7.widget.CardViewSubject assertThat(
      android.support.v7.widget.CardView target) {
    Subject.Factory<com.pkware.truth.android.cardview.v7.widget.CardViewSubject, android.support.v7.widget.CardView> type = com.pkware.truth.android.cardview.v7.widget.CardViewSubject.type();
    return assertAbout(type).that(target);
  }

  private Assertions() {
    throw new AssertionError("No instances.");
  }
}
