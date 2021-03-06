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
package com.pkware.truth.android.playservices.location;

import com.google.android.gms.location.DetectedActivity;
import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static com.google.android.gms.location.DetectedActivity.IN_VEHICLE;
import static com.google.android.gms.location.DetectedActivity.ON_BICYCLE;
import static com.google.android.gms.location.DetectedActivity.ON_FOOT;
import static com.google.android.gms.location.DetectedActivity.RUNNING;
import static com.google.android.gms.location.DetectedActivity.STILL;
import static com.google.android.gms.location.DetectedActivity.TILTING;
import static com.google.android.gms.location.DetectedActivity.UNKNOWN;
import static com.google.android.gms.location.DetectedActivity.WALKING;
import static com.pkware.truth.android.internal.IntegerUtils.buildNamedValueString;

/**
 * Propositions for {@link DetectedActivity} subjects.
 */
public class DetectedActivitySubject extends Subject {

  @Nullable
  private final DetectedActivity actual;

  public DetectedActivitySubject(@Nonnull FailureMetadata failureMetadata, @Nullable DetectedActivity actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  @Nonnull
  public static String typeToString(@DetectedActivityType int type) {
    return buildNamedValueString(type)
        .value(IN_VEHICLE, "in vehicle")
        .value(ON_BICYCLE, "on bicycle")
        .value(ON_FOOT, "on foot")
        .value(RUNNING, "running")
        .value(STILL, "still")
        .value(TILTING, "tilting")
        .value(UNKNOWN, "unknown")
        .value(WALKING, "walking")
        .get();
  }

  public void hasConfidence(int confidence) {
    check("getConfidence()").that(actual.getConfidence()).isEqualTo(confidence);
  }

  public void hasType(@DetectedActivityType int type) {
    int actualType = actual.getType();
    //noinspection ResourceType
    check("getType()")
        .withMessage("Expected type <%s> but was <%s>.", typeToString(type),
            typeToString(actualType))
        .that(actualType)
        .isEqualTo(type);
  }
}
