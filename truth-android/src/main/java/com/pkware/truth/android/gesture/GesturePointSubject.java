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
package com.pkware.truth.android.gesture;

import android.gesture.GesturePoint;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link GesturePoint} subjects.
 */
public class GesturePointSubject extends Subject<GesturePointSubject, GesturePoint> {
  protected GesturePointSubject(FailureStrategy failureStrategy, GesturePoint subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<GesturePointSubject, GesturePoint> type() {
    return new SubjectFactory<GesturePointSubject, GesturePoint>() {
      @Override
      public GesturePointSubject getSubject(FailureStrategy fs, GesturePoint that) {
        return new GesturePointSubject(fs, that);
      }
    };
  }

  public GesturePointSubject hasTimestamp(long timestamp) {
    assertThat(actual().timestamp)
        .named("timestamp")
        .isEqualTo(timestamp);
    return this;
  }

  public GesturePointSubject hasX(float x, float tolerance) {
    assertThat(actual().x)
        .named("X")
        .isWithin(tolerance)
        .of(x);
    return this;
  }

  public GesturePointSubject hasY(float y, float tolerance) {
    assertThat(actual().y)
        .named("Y")
        .isWithin(tolerance)
        .of(y);
    return this;
  }
}
