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
package com.pkware.truth.android.gesture;

import android.gesture.GestureStroke;
import android.graphics.RectF;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link GestureStroke} subjects.
 */
public class GestureStrokeSubject extends Subject<GestureStrokeSubject, GestureStroke> {
  protected GestureStrokeSubject(FailureMetadata failureMetadata, GestureStroke subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<GestureStrokeSubject, GestureStroke> type() {
    return GestureStrokeSubject::new;
  }

  public GestureStrokeSubject hasBoundingBox(RectF rect) {
    assertThat(actual().boundingBox)
        .named("bounding box")
        .isEqualTo(rect);
    return this;
  }

  public GestureStrokeSubject hasLength(float length, float tolerance) {
    assertThat(actual().length)
        .named("length")
        .isWithin(tolerance)
        .of(length);
    return this;
  }

  public GestureStrokeSubject hasPoints(float[] points, float tolerance) {
    assertThat(actual().points)
        .hasValuesWithin(tolerance)
        .of(points);
    return this;
  }
}
