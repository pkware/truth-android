/*
 * Copyright 2013 Square, Inc.
 * Copyright 2016 PKWARE, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.pkware.truth.android.preferences;

import android.preference.PreferenceActivity;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;
import com.pkware.truth.android.app.AbstractListActivitySubject;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link PreferenceActivity} subjects.
 */
public class PreferenceActivitySubject
    extends AbstractListActivitySubject<PreferenceActivitySubject, PreferenceActivity> {
  protected PreferenceActivitySubject(FailureMetadata failureMetadata, PreferenceActivity subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<PreferenceActivitySubject, PreferenceActivity> type() {
    return new Subject.Factory<PreferenceActivitySubject, PreferenceActivity>() {
      @Override
      public PreferenceActivitySubject createSubject(FailureMetadata fm, PreferenceActivity that) {
        return new PreferenceActivitySubject(fm, that);
      }
    };
  }

  public PreferenceActivitySubject hasHeaders() {
    assertThat(actual().hasHeaders())
        .named("has headers")
        .isTrue();
    return this;
  }

  public PreferenceActivitySubject hasNoHeaders() {
    assertThat(actual().hasHeaders())
        .named("has headers")
        .isFalse();
    return this;
  }

  public PreferenceActivitySubject isMultiPane() {
    assertThat(actual().isMultiPane())
        .named("is multi-pane")
        .isTrue();
    return this;
  }

  public PreferenceActivitySubject isNotMultiPane() {
    assertThat(actual().isMultiPane())
        .named("is multi-pane")
        .isFalse();
    return this;
  }
}
