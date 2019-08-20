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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link LocationRequest} subjects.
 */
public class LocationRequestSubject extends Subject {

  @Nullable
  private final LocationRequest actual;

  public LocationRequestSubject(@Nonnull FailureMetadata failureMetadata, @Nullable LocationRequest actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public LocationRequestSubject hasExpirationTime(long time) {
    check("getExpirationTime()").that(actual.getExpirationTime()).isEqualTo(time);
    return this;
  }

  public LocationRequestSubject hasFastestInterval(long interval) {
    check("getFastestInterval()").that(actual.getFastestInterval()).isEqualTo(interval);
    return this;
  }

  public LocationRequestSubject hasInterval(long interval) {
    long actualInterval = actual.getInterval();
    check("getInterval()").that(actual.getInterval()).isEqualTo(interval);
    return this;
  }

  public LocationRequestSubject hasUpdates(int updates) {
    check("getNumUpdates()").that(actual.getNumUpdates()).isEqualTo(updates);
    return this;
  }

  public LocationRequestSubject hasPriority(int priority) {
    check("getPriority()").that(actual.getPriority()).isEqualTo(priority);
    return this;
  }

  public LocationRequestSubject hasSmallestDisplacement(float displacement, float tolerance) {
    check("getSmallestDisplacement()").that(actual.getSmallestDisplacement()).isWithin(tolerance)
        .of(displacement);
    return this;
  }
}
