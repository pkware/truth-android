// Copyright 2019 PKWARE, Inc.
//
// This class is generated. Do not modify directly!
package com.pkware.truth.androidx.appcompat;

import com.google.common.truth.Subject;

import static com.google.common.truth.Truth.assertAbout;

/** Assertions for testing Android classes. */
@SuppressWarnings("deprecation")
public final class Assertions {
  public static com.pkware.truth.androidx.appcompat.app.ActionBarSubject assertThat(
      androidx.appcompat.app.ActionBar target) {
    Subject.Factory<com.pkware.truth.androidx.appcompat.app.ActionBarSubject, androidx.appcompat.app.ActionBar> type = com.pkware.truth.androidx.appcompat.app.ActionBarSubject.type();
    return assertAbout(type).that(target);
  }

  public static com.pkware.truth.androidx.appcompat.view.ActionModeSubject assertThat(
      androidx.appcompat.view.ActionMode target) {
    Subject.Factory<com.pkware.truth.androidx.appcompat.view.ActionModeSubject, androidx.appcompat.view.ActionMode> type = com.pkware.truth.androidx.appcompat.view.ActionModeSubject.type();
    return assertAbout(type).that(target);
  }

  public static com.pkware.truth.androidx.appcompat.widget.LinearLayoutCompatSubject assertThat(
      androidx.appcompat.widget.LinearLayoutCompat target) {
    Subject.Factory<com.pkware.truth.androidx.appcompat.widget.LinearLayoutCompatSubject, androidx.appcompat.widget.LinearLayoutCompat> type = com.pkware.truth.androidx.appcompat.widget.LinearLayoutCompatSubject.type();
    return assertAbout(type).that(target);
  }

  public static com.pkware.truth.androidx.appcompat.widget.SearchViewSubject assertThat(
      androidx.appcompat.widget.SearchView target) {
    Subject.Factory<com.pkware.truth.androidx.appcompat.widget.SearchViewSubject, androidx.appcompat.widget.SearchView> type = com.pkware.truth.androidx.appcompat.widget.SearchViewSubject.type();
    return assertAbout(type).that(target);
  }

  private Assertions() {
    throw new AssertionError("No instances.");
  }
}
