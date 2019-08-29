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

  public void hasAccuracy(float accuracy, float tolerance) {
    check("getAccuracy()").that(actual.getAccuracy()).isWithin(tolerance).of(accuracy);
  }

  public void hasAltitude(double altitude, double tolerance) {
    check("getAltitude()").that(actual.getAltitude()).isWithin(tolerance).of(altitude);
  }

  public void hasBearing(float bearing, float tolerance) {
    check("getBearing()").that(actual.getBearing()).isWithin(tolerance).of(bearing);
  }

  @TargetApi(JELLY_BEAN_MR1)
  public void hasElapsedRealTimeNanos(long nanos) {
    check("getElapsedRealtimeNanos()").that(actual.getElapsedRealtimeNanos()).isEqualTo(nanos);
  }

  public void hasLatitude(double latitude, double tolerance) {
    check("getLatitude()").that(actual.getLatitude()).isWithin(tolerance).of(latitude);
  }

  public void hasLongitude(double longitude, double tolerance) {
    check("getLongitude()").that(actual.getLongitude()).isWithin(tolerance).of(longitude);
  }

  public void hasProvider(@Nullable String name) {
    check("getProvider()").that(actual.getProvider()).isEqualTo(name);
  }

  public void hasSpeed(float speed, float tolerance) {
    check("getSpeed()").that(actual.getSpeed()).isWithin(tolerance).of(speed);
  }

  public void hasTime(long time) {
    check("getTime()").that(actual.getTime()).isEqualTo(time);
  }

  public void hasAccuracy() {
    check("hasAccuracy()").that(actual.hasAccuracy()).isTrue();
  }

  public void hasNoAccuracy() {
    check("hasAccuracy()").that(actual.hasAccuracy()).isFalse();
  }

  public void hasAltitude() {
    check("hasAltitude()").that(actual.hasAltitude()).isTrue();
  }

  public void hasNoAltitude() {
    check("hasAltitude()").that(actual.hasAltitude()).isFalse();
  }

  public void hasBearing() {
    check("hasBearing()").that(actual.hasBearing()).isTrue();
  }

  public void hasNoBearing() {
    check("hasBearing()").that(actual.hasBearing()).isFalse();
  }

  public void hasSpeed() {
    check("hasSpeed()").that(actual.hasSpeed()).isTrue();
  }

  public void hasNoSpeed() {
    check("hasSpeed()").that(actual.hasSpeed()).isFalse();
  }

  @TargetApi(JELLY_BEAN_MR2)
  public void isFromMockProvider() {
    check("isFromMockProvider()").that(actual.isFromMockProvider()).isTrue();
  }

  @TargetApi(JELLY_BEAN_MR2)
  public void isNotFromMockProvider() {
    check("isFromMockProvider()").that(actual.isFromMockProvider()).isFalse();
  }
}
