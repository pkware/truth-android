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

import android.gesture.Gesture;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link Gesture} subjects.
 */
public class GestureSubject extends Subject<GestureSubject, Gesture> {
  protected GestureSubject(FailureMetadata failureMetadata, Gesture subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<GestureSubject, Gesture> type() {
    return GestureSubject::new;
  }

  public GestureSubject hasId(long id) {
    assertThat(actual().getID())
        .named("id")
        .isEqualTo(id);
    return this;
  }

  public GestureSubject hasLength(float length, float tolerance) {
    assertThat(actual().getLength())
        .named("length")
        .isWithin(tolerance)
        .of(length);
    return this;
  }

  public GestureSubject hasStrokeCount(int count) {
    assertThat(actual().getStrokesCount())
        .named("stroke count")
        .isEqualTo(count);
    return this;
  }
}
