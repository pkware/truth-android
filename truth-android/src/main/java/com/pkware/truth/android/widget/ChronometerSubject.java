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
package com.pkware.truth.android.widget;

import android.widget.Chronometer;
import com.google.common.truth.FailureMetadata;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link Chronometer} subjects.
 */
public class ChronometerSubject extends AbstractTextViewSubject<ChronometerSubject, Chronometer> {
  public ChronometerSubject(FailureMetadata failureMetadata, Chronometer subject) {
    super(failureMetadata, subject);
  }

  public ChronometerSubject hasBase(long base) {
    assertThat(actual().getBase())
        .named("base time")
        .isEqualTo(base);
    return this;
  }

  public ChronometerSubject hasFormat(String format) {
    assertThat(actual().getFormat())
        .named("format")
        .isEqualTo(format);
    return this;
  }
}
