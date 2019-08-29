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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link Movie} subjects.
 */
public class MovieSubject extends Subject {

  @Nullable
  private final Movie actual;

  public MovieSubject(@Nonnull FailureMetadata failureMetadata, @Nullable Movie actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasDuration(int duration) {
    check("duration()").that(actual.duration()).isEqualTo(duration);
  }

  public void hasHeight(int height) {
    check("height()").that(actual.height()).isEqualTo(height);
  }

  public void isOpaque() {
    check("isOpaque()").that(actual.isOpaque()).isTrue();
  }

  public void isNotOpaque() {
    check("isOpaque()").that(actual.isOpaque()).isFalse();
  }

  public void hasWidth(int width) {
    check("width()").that(actual.width()).isEqualTo(width);
  }
}
