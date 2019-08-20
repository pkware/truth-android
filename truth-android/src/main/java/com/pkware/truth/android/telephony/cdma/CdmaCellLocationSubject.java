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
package com.pkware.truth.android.telephony.cdma;

import android.telephony.cdma.CdmaCellLocation;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link CdmaCellLocation} subjects.
 */
public class CdmaCellLocationSubject extends Subject {

  @Nullable
  private final CdmaCellLocation actual;

  public CdmaCellLocationSubject(@Nonnull FailureMetadata failureMetadata, @Nullable CdmaCellLocation actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public CdmaCellLocationSubject hasBaseStationId(int id) {
    check("getBaseStationId()").that(actual.getBaseStationId()).isEqualTo(id);
    return this;
  }

  public CdmaCellLocationSubject hasBaseStationLatitude(int latitude) {
    check("getBaseStationLatitude()").that(actual.getBaseStationLatitude()).isEqualTo(latitude);
    return this;
  }

  public CdmaCellLocationSubject hasBaseStationLongitude(int longitude) {
    check("getBaseStationLongitude()").that(actual.getBaseStationLongitude()).isEqualTo(longitude);
    return this;
  }

  public CdmaCellLocationSubject hasNetworkId(int id) {
    check("getNetworkId()").that(actual.getNetworkId()).isEqualTo(id);
    return this;
  }

  public CdmaCellLocationSubject hasSystemId(int id) {
    check("getSystemId()").that(actual.getSystemId()).isEqualTo(id);
    return this;
  }
}
