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

import android.telephony.NeighboringCellInfo;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static com.pkware.truth.android.telephony.TelephonyManagerSubject.networkTypeToString;

/**
 * Propositions for {@link NeighboringCellInfo} subjects.
 */
public class NeighboringCellInfoSubject extends Subject {

  @Nullable
  private final NeighboringCellInfo actual;

  public NeighboringCellInfoSubject(@Nonnull FailureMetadata failureMetadata, @Nullable NeighboringCellInfo actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public NeighboringCellInfoSubject hasCid(int cid) {
    check("getCid()").that(actual.getCid()).isEqualTo(cid);
    return this;
  }

  public NeighboringCellInfoSubject hasLac(int lac) {
    check("getLac()").that(actual.getLac()).isEqualTo(lac);
    return this;
  }

  public NeighboringCellInfoSubject hasNetworkType(@TelephonyManagerNetworkType int networkType) {
    int actualNetworkType = actual.getNetworkType();
    //noinspection ResourceType
    check("getNetworkType()")
        .withMessage("Expected network type <%s> but was <%s>.",
            networkTypeToString(networkType), networkTypeToString(actualNetworkType))
        .that(actualNetworkType)
        .isEqualTo(networkType);
    return this;
  }

  public NeighboringCellInfoSubject hasPsc(int psc) {
    check("getPsc()").that(actual.getPsc()).isEqualTo(psc);
    return this;
  }

  public NeighboringCellInfoSubject hasRssi(int rssi) {
    check("getRssi()").that(actual.getRssi()).isEqualTo(rssi);
    return this;
  }
}
