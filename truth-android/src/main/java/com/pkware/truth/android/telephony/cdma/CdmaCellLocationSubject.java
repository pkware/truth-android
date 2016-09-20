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
package com.pkware.truth.android.telephony.cdma;

import android.telephony.cdma.CdmaCellLocation;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link CdmaCellLocation} subjects.
 */
public class CdmaCellLocationSubject extends Subject<CdmaCellLocationSubject, CdmaCellLocation> {
  protected CdmaCellLocationSubject(FailureStrategy failureStrategy, CdmaCellLocation subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<CdmaCellLocationSubject, CdmaCellLocation> type() {
    return new SubjectFactory<CdmaCellLocationSubject, CdmaCellLocation>() {
      @Override
      public CdmaCellLocationSubject getSubject(FailureStrategy fs, CdmaCellLocation that) {
        return new CdmaCellLocationSubject(fs, that);
      }
    };
  }

  public CdmaCellLocationSubject hasBaseStationId(int id) {
    assertThat(actual().getBaseStationId())
        .named("base station ID")
        .isEqualTo(id);
    return this;
  }

  public CdmaCellLocationSubject hasBaseStationLatitude(int latitude) {
    assertThat(actual().getBaseStationLatitude())
        .named("base station latitude")
        .isEqualTo(latitude);
    return this;
  }

  public CdmaCellLocationSubject hasBaseStationLongitude(int longitude) {
    assertThat(actual().getBaseStationLongitude())
        .named("base station longitude")
        .isEqualTo(longitude);
    return this;
  }

  public CdmaCellLocationSubject hasNetworkId(int id) {
    assertThat(actual().getNetworkId())
        .named("network ID")
        .isEqualTo(id);
    return this;
  }

  public CdmaCellLocationSubject hasSystemId(int id) {
    assertThat(actual().getSystemId())
        .named("system ID")
        .isEqualTo(id);
    return this;
  }
}
