// Copyright 2016 PKWARE, Inc.
//
// This class is generated. Do not modify directly!
package com.pkware.truth.android.gridlayout.v7;

import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertAbout;

/** Assertions for testing Android classes. */
@SuppressWarnings("deprecation")
public final class Assertions {
  public static com.pkware.truth.android.gridlayout.v7.widget.GridLayoutSubject assertThat(
      android.support.v7.widget.GridLayout target) {
    SubjectFactory<com.pkware.truth.android.gridlayout.v7.widget.GridLayoutSubject, android.support.v7.widget.GridLayout> type = com.pkware.truth.android.gridlayout.v7.widget.GridLayoutSubject.type();
    return assertAbout(type).that(target);
  }

  private Assertions() {
    throw new AssertionError("No instances.");
  }
}
