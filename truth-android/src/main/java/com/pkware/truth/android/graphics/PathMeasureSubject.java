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

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link PathMeasure} subjects.
 */
public class PathMeasureSubject extends Subject {

  @Nullable
  private final PathMeasure actual;

  public PathMeasureSubject(@Nonnull FailureMetadata failureMetadata, @Nullable PathMeasure actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public PathMeasureSubject hasLength(float length, float tolerance) {
    check("getLength()").that(actual.getLength()).isWithin(tolerance)
        .of(length);
    return this;
  }

  public PathMeasureSubject isClosed() {
    check("isClosed()").that(actual.isClosed()).isTrue();
    return this;
  }

  public PathMeasureSubject isNotClosed() {
    check("isClosed()").that(actual.isClosed()).isFalse();
    return this;
  }
}
