/*
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

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;
import com.pkware.truth.android.app.AbstractListActivitySubject;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link PreferenceActivity} subjects.
 */
public class PreferenceActivitySubject
    extends AbstractListActivitySubject<PreferenceActivitySubject, PreferenceActivity> {
  protected PreferenceActivitySubject(FailureStrategy failureStrategy, PreferenceActivity subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<PreferenceActivitySubject, PreferenceActivity> type() {
    return new SubjectFactory<PreferenceActivitySubject, PreferenceActivity>() {
      @Override
      public PreferenceActivitySubject getSubject(FailureStrategy fs, PreferenceActivity that) {
        return new PreferenceActivitySubject(fs, that);
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
