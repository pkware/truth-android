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
package com.pkware.truth.android.location;

import android.annotation.TargetApi;
import android.location.Location;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR1;
import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR2;
import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link Location} subjects.
 */
public class LocationSubject extends Subject<LocationSubject, Location> {
  protected LocationSubject(FailureStrategy failureStrategy, Location subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<LocationSubject, Location> type() {
    return new SubjectFactory<LocationSubject, Location>() {
      @Override
      public LocationSubject getSubject(FailureStrategy fs, Location that) {
        return new LocationSubject(fs, that);
      }
    };
  }

  public LocationSubject hasAccuracy(float accuracy, float tolerance) {
    assertThat(getSubject().getAccuracy())
        .named("accuracy")
        .isWithin(tolerance)
        .of(accuracy);
    return this;
  }

  public LocationSubject hasAltitude(double altitude, double tolerance) {
    assertThat(getSubject().getAltitude())
        .named("altitude")
        .isWithin(tolerance)
        .of(altitude);
    return this;
  }

  public LocationSubject hasBearing(float bearing, float tolerance) {
    assertThat(getSubject().getBearing())
        .named("bearing")
        .isWithin(tolerance)
        .of(bearing);
    return this;
  }

  @TargetApi(JELLY_BEAN_MR1)
  public LocationSubject hasElapsedRealTimeNanos(long nanos) {
    assertThat(getSubject().getElapsedRealtimeNanos())
        .named("elapsed real-time nanos")
        .isEqualTo(nanos);
    return this;
  }

  public LocationSubject hasLatitude(double latitude, double tolerance) {
    assertThat(getSubject().getLatitude())
        .named("latitude")
        .isWithin(tolerance)
        .of(latitude);
    return this;
  }

  public LocationSubject hasLongitude(double longitude, double tolerance) {
    assertThat(getSubject().getLongitude())
        .named("longitude")
        .isWithin(tolerance)
        .of(longitude);
    return this;
  }

  public LocationSubject hasProvider(String name) {
    assertThat(getSubject().getProvider())
        .named("provider")
        .isEqualTo(name);
    return this;
  }

  public LocationSubject hasSpeed(float speed, float tolerance) {
    assertThat(getSubject().getSpeed())
        .named("speed")
        .isWithin(tolerance)
        .of(speed);
    return this;
  }

  public LocationSubject hasTime(long time) {
    assertThat(getSubject().getTime())
        .named("time")
        .isEqualTo(time);
    return this;
  }

  public LocationSubject hasAccuracy() {
    assertThat(getSubject().hasAccuracy())
        .named("has accuracy")
        .isTrue();
    return this;
  }

  public LocationSubject hasNoAccuracy() {
    assertThat(getSubject().hasAccuracy())
        .named("has accuracy")
        .isFalse();
    return this;
  }

  public LocationSubject hasAltitude() {
    assertThat(getSubject().hasAltitude())
        .named("has altitude")
        .isTrue();
    return this;
  }

  public LocationSubject hasNoAltitude() {
    assertThat(getSubject().hasAltitude())
        .named("has altitude")
        .isFalse();
    return this;
  }

  public LocationSubject hasBearing() {
    assertThat(getSubject().hasBearing())
        .named("has bearing")
        .isTrue();
    return this;
  }

  public LocationSubject hasNoBearing() {
    assertThat(getSubject().hasBearing())
        .named("has bearing")
        .isFalse();
    return this;
  }

  public LocationSubject hasSpeed() {
    assertThat(getSubject().hasSpeed())
        .named("has speed")
        .isTrue();
    return this;
  }

  public LocationSubject hasNoSpeed() {
    assertThat(getSubject().hasSpeed())
        .named("has speed")
        .isFalse();
    return this;
  }

  @TargetApi(JELLY_BEAN_MR2)
  public LocationSubject isFromMockProvider() {
    assertThat(getSubject().isFromMockProvider())
        .named("is from mock provider")
        .isTrue();
    return this;
  }

  @TargetApi(JELLY_BEAN_MR2)
  public LocationSubject isNotFromMockProvider() {
    assertThat(getSubject().isFromMockProvider())
        .named("is from mock provider")
        .isFalse();
    return this;
  }
}
