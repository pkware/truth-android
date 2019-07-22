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

import android.gesture.GesturePoint;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link GesturePoint} subjects.
 */
public class GesturePointSubject extends Subject<GesturePointSubject, GesturePoint> {
  protected GesturePointSubject(FailureMetadata failureMetadata, GesturePoint subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<GesturePointSubject, GesturePoint> type() {
    return GesturePointSubject::new;
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
