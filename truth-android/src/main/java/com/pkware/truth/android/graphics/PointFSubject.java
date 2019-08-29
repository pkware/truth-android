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

import android.graphics.PointF;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link PointF} subjects.
 */
public class PointFSubject extends Subject {

  @Nullable
  private final PointF actual;

  public PointFSubject(@Nonnull FailureMetadata failureMetadata, @Nullable PointF actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasX(float x, float tolerance) {
    check("x").that(actual.x).isWithin(tolerance).of(x);
  }

  public void hasY(float y, float tolerance) {
    check("y").that(actual.y).isWithin(tolerance).of(y);
  }

  public void hasLength(float length, float tolerance) {
    check("length()").that(actual.length()).isWithin(tolerance).of(length);
  }
}
