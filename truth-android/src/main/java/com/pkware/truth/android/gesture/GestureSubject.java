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

import android.gesture.Gesture;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link Gesture} subjects.
 */
public class GestureSubject extends Subject<GestureSubject, Gesture> {
  protected GestureSubject(FailureStrategy failureStrategy, Gesture subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<GestureSubject, Gesture> type() {
    return new SubjectFactory<GestureSubject, Gesture>() {
      @Override
      public GestureSubject getSubject(FailureStrategy fs, Gesture that) {
        return new GestureSubject(fs, that);
      }
    };
  }

  public GestureSubject hasId(long id) {
    assertThat(getSubject().getID())
        .named("id")
        .isEqualTo(id);
    return this;
  }

  public GestureSubject hasLength(float length, float tolerance) {
    assertThat(getSubject().getLength())
        .named("length")
        .isWithin(tolerance)
        .of(length);
    return this;
  }

  public GestureSubject hasStrokeCount(int count) {
    assertThat(getSubject().getStrokesCount())
        .named("stroke count")
        .isEqualTo(count);
    return this;
  }
}
