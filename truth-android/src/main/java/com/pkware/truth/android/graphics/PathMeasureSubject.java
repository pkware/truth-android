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

import android.graphics.PathMeasure;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link PathMeasure} subjects.
 */
public class PathMeasureSubject extends Subject<PathMeasureSubject, PathMeasure> {
  protected PathMeasureSubject(FailureStrategy failureStrategy, PathMeasure subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<PathMeasureSubject, PathMeasure> type() {
    return new SubjectFactory<PathMeasureSubject, PathMeasure>() {
      @Override
      public PathMeasureSubject getSubject(FailureStrategy fs, PathMeasure that) {
        return new PathMeasureSubject(fs, that);
      }
    };
  }

  public PathMeasureSubject hasLength(float length, float tolerance) {
    assertThat(actual().getLength())
        .named("length")
        .isWithin(tolerance)
        .of(length);
    return this;
  }

  public PathMeasureSubject isClosed() {
    assertThat(actual().isClosed())
        .named("is closed")
        .isTrue();
    return this;
  }

  public PathMeasureSubject isNotClosed() {
    assertThat(actual().isClosed())
        .named("is closed")
        .isFalse();
    return this;
  }
}
