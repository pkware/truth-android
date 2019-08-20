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

import android.location.GpsSatellite;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link GpsSatellite} subjects.
 */
public class GpsSatelliteSubject extends Subject {

  @Nullable
  private final GpsSatellite actual;

  public GpsSatelliteSubject(@Nonnull FailureMetadata failureMetadata, @Nullable GpsSatellite actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public GpsSatelliteSubject hasAzimuth(float azimuth, float tolerance) {
    check("getAzimuth()").that(actual.getAzimuth()).isWithin(tolerance).of(azimuth);
    return this;
  }

  public GpsSatelliteSubject hasElevation(float elevation, float tolerance) {
    check("getElevation()").that(actual.getElevation()).isWithin(tolerance).of(elevation);
    return this;
  }

  public GpsSatelliteSubject hasPrn(int prn) {
    check("getPrn()").that(actual.getPrn()).isEqualTo(prn);
    return this;
  }

  public GpsSatelliteSubject hasSnr(float snr, float tolerance) {
    check("getSnr()").that(actual.getSnr()).isWithin(tolerance).of(snr);
    return this;
  }

  public GpsSatelliteSubject hasAlmanac() {
    check("hasAlmanac()").that(actual.hasAlmanac()).isTrue();
    return this;
  }

  public GpsSatelliteSubject hasNoAlmanac() {
    check("hasAlmanac()").that(actual.hasAlmanac()).isFalse();
    return this;
  }

  public GpsSatelliteSubject hasEphemeris() {
    check("hasEphemeris()").that(actual.hasEphemeris()).isTrue();
    return this;
  }

  public GpsSatelliteSubject hasNotEphemeris() {
    check("hasEphemeris()").that(actual.hasEphemeris()).isFalse();
    return this;
  }

  public GpsSatelliteSubject isUsedInFix() {
    check("usedInFix()").that(actual.usedInFix()).isTrue();
    return this;
  }

  public GpsSatelliteSubject isNotUsedInFix() {
    check("usedInFix()").that(actual.usedInFix()).isFalse();
    return this;
  }
}
