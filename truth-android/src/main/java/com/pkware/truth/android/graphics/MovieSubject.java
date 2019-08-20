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
package com.pkware.truth.android.graphics;

import android.graphics.Movie;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link Movie} subjects.
 */
public class MovieSubject extends Subject<MovieSubject, Movie> {
  public MovieSubject(FailureMetadata failureMetadata, Movie subject) {
    super(failureMetadata, subject);
  }

  public MovieSubject hasDuration(int duration) {
    assertThat(actual().duration())
        .named("duration")
        .isEqualTo(duration);
    return this;
  }

  public MovieSubject hasHeight(int height) {
    assertThat(actual().height())
        .named("height")
        .isEqualTo(height);
    return this;
  }

  public MovieSubject isOpaque() {
    assertThat(actual().isOpaque())
        .named("is opaque")
        .isTrue();
    return this;
  }

  public MovieSubject isNotOpaque() {
    assertThat(actual().isOpaque())
        .named("is opaque")
        .isFalse();
    return this;
  }

  public MovieSubject hasWidth(int width) {
    assertThat(actual().width())
        .named("width")
        .isEqualTo(width);
    return this;
  }
}
