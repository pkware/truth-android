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
package com.pkware.truth.android.location;


import android.location.GpsStatus;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link GpsStatus} subjects.
 */
public class GpsStatusSubject extends Subject<GpsStatusSubject, GpsStatus> {
  public GpsStatusSubject(FailureMetadata failureMetadata, GpsStatus subject) {
    super(failureMetadata, subject);
  }

  public GpsStatusSubject hasMaximumSatellites(int count) {
    assertThat(actual().getMaxSatellites())
        .named("maximum satellites")
        .isEqualTo(count);
    return this;
  }

  public GpsStatusSubject hasTimeToFirstFix(int time) {
    assertThat(actual().getTimeToFirstFix())
        .named("time to first fix")
        .isEqualTo(time);
    return this;
  }
}
