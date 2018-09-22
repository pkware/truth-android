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

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link Shape} subjects.
 */
public class ShapeSubject extends Subject<ShapeSubject, Shape> {
  protected ShapeSubject(FailureMetadata failureMetadata, Shape subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<ShapeSubject, Shape> type() {
    return new Subject.Factory<ShapeSubject, Shape>() {
      @Override
      public ShapeSubject createSubject(FailureMetadata fm, Shape that) {
        return new ShapeSubject(fm, that);
      }
    };
  }

  public ShapeSubject hasHeight(float height, float tolerance) {
    assertThat(actual().getHeight())
        .named("height")
        .isWithin(tolerance)
        .of(height);
    return this;
  }

  public ShapeSubject hasWidth(float width, float tolerance) {
    assertThat(actual().getWidth())
        .named("width")
        .isWithin(tolerance)
        .of(width);
    return this;
  }

  public ShapeSubject hasAlpha() {
    assertThat(actual().hasAlpha())
        .named("has alpha")
        .isTrue();
    return this;
  }

  public ShapeSubject hasNoAlpha() {
    assertThat(actual().hasAlpha())
        .named("has alpha")
        .isFalse();
    return this;
  }
}
