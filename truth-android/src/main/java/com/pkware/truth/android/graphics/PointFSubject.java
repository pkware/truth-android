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

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link PointF} subjects.
 */
public class PointFSubject extends Subject<PointFSubject, PointF> {
  protected PointFSubject(FailureMetadata failureMetadata, PointF subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<PointFSubject, PointF> type() {
    return new Subject.Factory<PointFSubject, PointF>() {
      @Override
      public PointFSubject createSubject(FailureMetadata fm, PointF that) {
        return new PointFSubject(fm, that);
      }
    };
  }

  public PointFSubject hasX(float x, float tolerance) {
    assertThat(actual().x)
        .named("X")
        .isWithin(tolerance)
        .of(x);
    return this;
  }

  public PointFSubject hasY(float y, float tolerance) {
    assertThat(actual().y)
        .named("Y")
        .isWithin(tolerance)
        .of(y);
    return this;
  }

  public PointFSubject hasLength(float length, float tolerance) {
    assertThat(actual().length())
        .named("length")
        .isWithin(tolerance)
        .of(length);
    return this;
  }
}
