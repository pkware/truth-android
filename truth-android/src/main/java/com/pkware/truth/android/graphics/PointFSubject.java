/*
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

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link PointF} subjects.
 */
public class PointFSubject extends Subject<PointFSubject, PointF> {
  protected PointFSubject(FailureStrategy failureStrategy, PointF subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<PointFSubject, PointF> type() {
    return new SubjectFactory<PointFSubject, PointF>() {
      @Override
      public PointFSubject getSubject(FailureStrategy fs, PointF that) {
        return new PointFSubject(fs, that);
      }
    };
  }

  public PointFSubject hasX(float x, float tolerance) {
    assertThat(getSubject().x)
        .named("X")
        .isWithin(tolerance)
        .of(x);
    return this;
  }

  public PointFSubject hasY(float y, float tolerance) {
    assertThat(getSubject().y)
        .named("Y")
        .isWithin(tolerance)
        .of(y);
    return this;
  }

  public PointFSubject hasLength(float length, float tolerance) {
    assertThat(getSubject().length())
        .named("length")
        .isWithin(tolerance)
        .of(length);
    return this;
  }
}
