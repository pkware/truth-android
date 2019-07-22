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
package com.pkware.truth.android.hardware;

import android.hardware.SensorEvent;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link SensorEvent} subjects.
 */
public class SensorEventSubject extends Subject<SensorEventSubject, SensorEvent> {
  protected SensorEventSubject(FailureMetadata failureMetadata, SensorEvent subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<SensorEventSubject, SensorEvent> type() {
    return SensorEventSubject::new;
  }

  public SensorEventSubject hasAccuracy(int accuracy) {
    assertThat(actual().accuracy)
        .named("accuracy")
        .isEqualTo(accuracy);
    return this;
  }

  public SensorEventSubject hasTimestamp(long timestamp) {
    assertThat(actual().timestamp)
        .named("timestamp")
        .isEqualTo(timestamp);
    return this;
  }

  public SensorEventSubject hasValues(float[] values, float tolerance) {
    assertThat(actual().values)
        .named("values")
        .hasValuesWithin(tolerance)
        .of(values);
    return this;
  }
}
