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

import android.graphics.Point;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link Point} subjects.
 */
public class PointSubject extends Subject {

  @Nullable
  private final Point actual;

  public PointSubject(@Nonnull FailureMetadata failureMetadata, @Nullable Point actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public PointSubject hasX(int x) {
    check("x").that(actual.x).isEqualTo(x);
    return this;
  }

  public PointSubject hasY(int y) {
    check("y").that(actual.y).isEqualTo(y);
    return this;
  }
}
