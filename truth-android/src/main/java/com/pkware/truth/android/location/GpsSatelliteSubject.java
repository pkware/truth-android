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

import android.location.GpsSatellite;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link GpsSatellite} subjects.
 */
public class GpsSatelliteSubject extends Subject<GpsSatelliteSubject, GpsSatellite> {
  protected GpsSatelliteSubject(FailureStrategy failureStrategy, GpsSatellite subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<GpsSatelliteSubject, GpsSatellite> type() {
    return new SubjectFactory<GpsSatelliteSubject, GpsSatellite>() {
      @Override
      public GpsSatelliteSubject getSubject(FailureStrategy fs, GpsSatellite that) {
        return new GpsSatelliteSubject(fs, that);
      }
    };
  }

  public GpsSatelliteSubject hasAzimuth(float azimuth, float tolerance) {
    assertThat(getSubject().getAzimuth())
        .named("azimuth")
        .isWithin(tolerance)
        .of(azimuth);
    return this;
  }

  public GpsSatelliteSubject hasElevation(float elevation, float tolerance) {
    assertThat(getSubject().getElevation())
        .named("elevation")
        .isWithin(tolerance)
        .of(elevation);
    return this;
  }

  public GpsSatelliteSubject hasPrn(int prn) {
    assertThat(getSubject().getPrn())
        .named("PRN")
        .isEqualTo(prn);
    return this;
  }

  public GpsSatelliteSubject hasSnr(float snr, float tolerance) {
    assertThat(getSubject().getSnr())
        .named("SNR")
        .isWithin(tolerance)
        .of(snr);
    return this;
  }

  public GpsSatelliteSubject hasAlmanac() {
    assertThat(getSubject().hasAlmanac())
        .named("has almanac")
        .isTrue();
    return this;
  }

  public GpsSatelliteSubject hasNoAlmanac() {
    assertThat(getSubject().hasAlmanac())
        .named("has almanac")
        .isFalse();
    return this;
  }

  public GpsSatelliteSubject hasEphemeris() {
    assertThat(getSubject().hasEphemeris())
        .named("has ephemeris")
        .isTrue();
    return this;
  }

  public GpsSatelliteSubject hasNotEphemeris() {
    assertThat(getSubject().hasEphemeris())
        .named("has ephemeris")
        .isFalse();
    return this;
  }

  public GpsSatelliteSubject isUsedInFix() {
    assertThat(getSubject().usedInFix())
        .named("used in fix")
        .isTrue();
    return this;
  }

  public GpsSatelliteSubject isNotUsedInFix() {
    assertThat(getSubject().usedInFix())
        .named("used in fix")
        .isFalse();
    return this;
  }
}
