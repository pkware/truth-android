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

import android.graphics.Path;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link Path} subjects.
 */
public class PathSubject extends Subject {

  @Nullable
  private final Path actual;

  public PathSubject(@Nonnull FailureMetadata failureMetadata, @Nullable Path actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public PathSubject hasFillType(@Nullable Path.FillType type) {
    check("getFillType()").that(actual.getFillType()).isEqualTo(type);
    return this;
  }

  public PathSubject isEmpty() {
    check("isEmpty()").that(actual.isEmpty()).isTrue();
    return this;
  }

  public PathSubject isNotEmpty() {
    check("isEmpty()").that(actual.isEmpty()).isFalse();
    return this;
  }
}
