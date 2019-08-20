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

import android.annotation.TargetApi;
import android.location.Location;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR1;
import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR2;

/**
 * Propositions for {@link Location} subjects.
 */
public class LocationSubject extends Subject {

  @Nullable
  private final Location actual;

  public LocationSubject(@Nonnull FailureMetadata failureMetadata, @Nullable Location actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public LocationSubject hasAccuracy(float accuracy, float tolerance) {
    check("getAccuracy()").that(actual.getAccuracy()).isWithin(tolerance).of(accuracy);
    return this;
  }

  public LocationSubject hasAltitude(double altitude, double tolerance) {
    check("getAltitude()").that(actual.getAltitude()).isWithin(tolerance).of(altitude);
    return this;
  }

  public LocationSubject hasBearing(float bearing, float tolerance) {
    check("getBearing()").that(actual.getBearing()).isWithin(tolerance).of(bearing);
    return this;
  }

  @TargetApi(JELLY_BEAN_MR1)
  public LocationSubject hasElapsedRealTimeNanos(long nanos) {
    check("getElapsedRealtimeNanos()").that(actual.getElapsedRealtimeNanos()).isEqualTo(nanos);
    return this;
  }

  public LocationSubject hasLatitude(double latitude, double tolerance) {
    check("getLatitude()").that(actual.getLatitude()).isWithin(tolerance).of(latitude);
    return this;
  }

  public LocationSubject hasLongitude(double longitude, double tolerance) {
    check("getLongitude()").that(actual.getLongitude()).isWithin(tolerance).of(longitude);
    return this;
  }

  public LocationSubject hasProvider(@Nullable String name) {
    check("getProvider()").that(actual.getProvider()).isEqualTo(name);
    return this;
  }

  public LocationSubject hasSpeed(float speed, float tolerance) {
    check("getSpeed()").that(actual.getSpeed()).isWithin(tolerance).of(speed);
    return this;
  }

  public LocationSubject hasTime(long time) {
    check("getTime()").that(actual.getTime()).isEqualTo(time);
    return this;
  }

  public LocationSubject hasAccuracy() {
    check("hasAccuracy()").that(actual.hasAccuracy()).isTrue();
    return this;
  }

  public LocationSubject hasNoAccuracy() {
    check("hasAccuracy()").that(actual.hasAccuracy()).isFalse();
    return this;
  }

  public LocationSubject hasAltitude() {
    check("hasAltitude()").that(actual.hasAltitude()).isTrue();
    return this;
  }

  public LocationSubject hasNoAltitude() {
    check("hasAltitude()").that(actual.hasAltitude()).isFalse();
    return this;
  }

  public LocationSubject hasBearing() {
    check("hasBearing()").that(actual.hasBearing()).isTrue();
    return this;
  }

  public LocationSubject hasNoBearing() {
    check("hasBearing()").that(actual.hasBearing()).isFalse();
    return this;
  }

  public LocationSubject hasSpeed() {
    check("hasSpeed()").that(actual.hasSpeed()).isTrue();
    return this;
  }

  public LocationSubject hasNoSpeed() {
    check("hasSpeed()").that(actual.hasSpeed()).isFalse();
    return this;
  }

  @TargetApi(JELLY_BEAN_MR2)
  public LocationSubject isFromMockProvider() {
    check("isFromMockProvider()").that(actual.isFromMockProvider()).isTrue();
    return this;
  }

  @TargetApi(JELLY_BEAN_MR2)
  public LocationSubject isNotFromMockProvider() {
    check("isFromMockProvider()").that(actual.isFromMockProvider()).isFalse();
    return this;
  }
}
