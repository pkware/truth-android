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

import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR1;
import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR2;
import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link Location} subjects.
 */
public class LocationSubject extends Subject<LocationSubject, Location> {
  protected LocationSubject(FailureMetadata failureMetadata, Location subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<LocationSubject, Location> type() {
    return LocationSubject::new;
  }

  public LocationSubject hasAccuracy(float accuracy, float tolerance) {
    assertThat(actual().getAccuracy())
        .named("accuracy")
        .isWithin(tolerance)
        .of(accuracy);
    return this;
  }

  public LocationSubject hasAltitude(double altitude, double tolerance) {
    assertThat(actual().getAltitude())
        .named("altitude")
        .isWithin(tolerance)
        .of(altitude);
    return this;
  }

  public LocationSubject hasBearing(float bearing, float tolerance) {
    assertThat(actual().getBearing())
        .named("bearing")
        .isWithin(tolerance)
        .of(bearing);
    return this;
  }

  @TargetApi(JELLY_BEAN_MR1)
  public LocationSubject hasElapsedRealTimeNanos(long nanos) {
    assertThat(actual().getElapsedRealtimeNanos())
        .named("elapsed real-time nanos")
        .isEqualTo(nanos);
    return this;
  }

  public LocationSubject hasLatitude(double latitude, double tolerance) {
    assertThat(actual().getLatitude())
        .named("latitude")
        .isWithin(tolerance)
        .of(latitude);
    return this;
  }

  public LocationSubject hasLongitude(double longitude, double tolerance) {
    assertThat(actual().getLongitude())
        .named("longitude")
        .isWithin(tolerance)
        .of(longitude);
    return this;
  }

  public LocationSubject hasProvider(String name) {
    assertThat(actual().getProvider())
        .named("provider")
        .isEqualTo(name);
    return this;
  }

  public LocationSubject hasSpeed(float speed, float tolerance) {
    assertThat(actual().getSpeed())
        .named("speed")
        .isWithin(tolerance)
        .of(speed);
    return this;
  }

  public LocationSubject hasTime(long time) {
    assertThat(actual().getTime())
        .named("time")
        .isEqualTo(time);
    return this;
  }

  public LocationSubject hasAccuracy() {
    assertThat(actual().hasAccuracy())
        .named("has accuracy")
        .isTrue();
    return this;
  }

  public LocationSubject hasNoAccuracy() {
    assertThat(actual().hasAccuracy())
        .named("has accuracy")
        .isFalse();
    return this;
  }

  public LocationSubject hasAltitude() {
    assertThat(actual().hasAltitude())
        .named("has altitude")
        .isTrue();
    return this;
  }

  public LocationSubject hasNoAltitude() {
    assertThat(actual().hasAltitude())
        .named("has altitude")
        .isFalse();
    return this;
  }

  public LocationSubject hasBearing() {
    assertThat(actual().hasBearing())
        .named("has bearing")
        .isTrue();
    return this;
  }

  public LocationSubject hasNoBearing() {
    assertThat(actual().hasBearing())
        .named("has bearing")
        .isFalse();
    return this;
  }

  public LocationSubject hasSpeed() {
    assertThat(actual().hasSpeed())
        .named("has speed")
        .isTrue();
    return this;
  }

  public LocationSubject hasNoSpeed() {
    assertThat(actual().hasSpeed())
        .named("has speed")
        .isFalse();
    return this;
  }

  @TargetApi(JELLY_BEAN_MR2)
  public LocationSubject isFromMockProvider() {
    assertThat(actual().isFromMockProvider())
        .named("is from mock provider")
        .isTrue();
    return this;
  }

  @TargetApi(JELLY_BEAN_MR2)
  public LocationSubject isNotFromMockProvider() {
    assertThat(actual().isFromMockProvider())
        .named("is from mock provider")
        .isFalse();
    return this;
  }
}
