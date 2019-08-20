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
package com.pkware.truth.android.graphics.drawable.shapes;

import android.graphics.drawable.shapes.Shape;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link Shape} subjects.
 */
public class ShapeSubject extends Subject {

  @Nullable
  private final Shape actual;

  public ShapeSubject(@Nonnull FailureMetadata failureMetadata, @Nullable Shape actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public ShapeSubject hasHeight(float height, float tolerance) {
    check("getHeight()").that(actual.getHeight()).isWithin(tolerance)
        .of(height);
    return this;
  }

  public ShapeSubject hasWidth(float width, float tolerance) {
    check("getWidth()").that(actual.getWidth()).isWithin(tolerance)
        .of(width);
    return this;
  }

  public ShapeSubject hasAlpha() {
    check("hasAlpha()").that(actual.hasAlpha()).isTrue();
    return this;
  }

  public ShapeSubject hasNoAlpha() {
    check("hasAlpha()").that(actual.hasAlpha()).isFalse();
    return this;
  }
}
