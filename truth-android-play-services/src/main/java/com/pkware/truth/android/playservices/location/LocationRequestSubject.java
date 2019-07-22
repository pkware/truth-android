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

import com.google.android.gms.location.LocationRequest;
import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link LocationRequest} subjects.
 */
public class LocationRequestSubject extends Subject<LocationRequestSubject, LocationRequest> {
  protected LocationRequestSubject(FailureMetadata failureMetadata, LocationRequest subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<LocationRequestSubject, LocationRequest> type() {
    return LocationRequestSubject::new;
  }

  public LocationRequestSubject hasExpirationTime(long time) {
    assertThat(actual().getExpirationTime())
        .named("expiration time")
        .isEqualTo(time);
    return this;
  }

  public LocationRequestSubject hasFastestInterval(long interval) {
    assertThat(actual().getFastestInterval())
        .named("fastest interval")
        .isEqualTo(interval);
    return this;
  }

  public LocationRequestSubject hasInterval(long interval) {
    long actualInterval = actual().getInterval();
    assertThat(actual().getInterval())
        .named("interval")
        .isEqualTo(interval);
    return this;
  }

  public LocationRequestSubject hasUpdates(int updates) {
    assertThat(actual().getNumUpdates())
        .named("update count")
        .isEqualTo(updates);
    return this;
  }

  public LocationRequestSubject hasPriority(int priority) {
    assertThat(actual().getPriority())
        .named("priority")
        .isEqualTo(priority);
    return this;
  }

  public LocationRequestSubject hasSmallestDisplacement(float displacement, float tolerance) {
    assertThat(actual().getSmallestDisplacement())
        .named("smallest displacement")
        .isWithin(tolerance)
        .of(displacement);
    return this;
  }
}
