// Copyright 2018 PKWARE, Inc.
//
// This class is generated. Do not modify directly!
package com.pkware.truth.android.appcompat.v7;

import com.google.common.truth.Subject;

import static com.google.common.truth.Truth.assertAbout;

/** Assertions for testing Android classes. */
@SuppressWarnings("deprecation")
public final class Assertions {
  public static com.pkware.truth.android.appcompat.v7.app.ActionBarSubject assertThat(
      androidx.appcompat.app.ActionBar target) {
    Subject.Factory<com.pkware.truth.android.appcompat.v7.app.ActionBarSubject, androidx.appcompat.app.ActionBar> type = com.pkware.truth.android.appcompat.v7.app.ActionBarSubject.type();
    return assertAbout(type).that(target);
  }

  public static com.pkware.truth.android.appcompat.v7.view.ActionModeSubject assertThat(
      androidx.appcompat.view.ActionMode target) {
    Subject.Factory<com.pkware.truth.android.appcompat.v7.view.ActionModeSubject, androidx.appcompat.view.ActionMode> type = com.pkware.truth.android.appcompat.v7.view.ActionModeSubject.type();
    return assertAbout(type).that(target);
  }

  public static com.pkware.truth.android.appcompat.v7.widget.LinearLayoutCompatSubject assertThat(
      androidx.appcompat.widget.LinearLayoutCompat target) {
    Subject.Factory<com.pkware.truth.android.appcompat.v7.widget.LinearLayoutCompatSubject, androidx.appcompat.widget.LinearLayoutCompat> type = com.pkware.truth.android.appcompat.v7.widget.LinearLayoutCompatSubject.type();
    return assertAbout(type).that(target);
  }

  public static com.pkware.truth.android.appcompat.v7.widget.SearchViewSubject assertThat(
      androidx.appcompat.widget.SearchView target) {
    Subject.Factory<com.pkware.truth.android.appcompat.v7.widget.SearchViewSubject, androidx.appcompat.widget.SearchView> type = com.pkware.truth.android.appcompat.v7.widget.SearchViewSubject.type();
    return assertAbout(type).that(target);
  }

  private Assertions() {
    throw new AssertionError("No instances.");
  }
}
