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
import com.pkware.truth.android.app.AbstractListActivitySubject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link PreferenceActivity} subjects.
 */
public class PreferenceActivitySubject
    extends AbstractListActivitySubject<PreferenceActivity> {

  @Nullable
  private PreferenceActivity actual;

  public PreferenceActivitySubject(@Nonnull FailureMetadata failureMetadata, @Nullable PreferenceActivity actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public PreferenceActivitySubject hasHeaders() {
    check("hasHeaders()").that(actual.hasHeaders()).isTrue();
    return this;
  }

  public PreferenceActivitySubject hasNoHeaders() {
    check("hasHeaders()").that(actual.hasHeaders()).isFalse();
    return this;
  }

  public PreferenceActivitySubject isMultiPane() {
    check("isMultiPane()").that(actual.isMultiPane()).isTrue();
    return this;
  }

  public PreferenceActivitySubject isNotMultiPane() {
    check("isMultiPane()").that(actual.isMultiPane()).isFalse();
    return this;
  }
}
