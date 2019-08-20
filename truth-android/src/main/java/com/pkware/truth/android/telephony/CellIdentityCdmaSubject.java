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
package com.pkware.truth.android.telephony;

import android.annotation.TargetApi;
import android.telephony.CellIdentityCdma;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR1;

/**
 * Propositions for {@link CellIdentityCdma} subjects.
 */
@TargetApi(JELLY_BEAN_MR1)
public final class CellIdentityCdmaSubject extends Subject {

  @Nullable
  private final CellIdentityCdma actual;

  public CellIdentityCdmaSubject(@Nonnull FailureMetadata failureMetadata, @Nullable CellIdentityCdma actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public CellIdentityCdmaSubject hasBaseStationId(int id) {
    check("getBasestationId()").that(actual.getBasestationId()).isEqualTo(id);
    return this;
  }

  public CellIdentityCdmaSubject hasLatitude(int latitude) {
    check("getLatitude()").that(actual.getLatitude()).isEqualTo(latitude);
    return this;
  }

  public CellIdentityCdmaSubject hasLongitude(int longitude) {
    check("getLongitude()").that(actual.getLongitude()).isEqualTo(longitude);
    return this;
  }

  public CellIdentityCdmaSubject hasNetworkId(int id) {
    check("getNetworkId()").that(actual.getNetworkId()).isEqualTo(id);
    return this;
  }

  public CellIdentityCdmaSubject hasSystemId(int id) {
    check("getSystemId()").that(actual.getSystemId()).isEqualTo(id);
    return this;
  }
}
