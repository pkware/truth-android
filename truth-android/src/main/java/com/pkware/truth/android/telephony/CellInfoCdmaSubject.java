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
import android.telephony.CellInfoCdma;
import android.telephony.CellSignalStrengthCdma;

import com.google.common.truth.FailureMetadata;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR1;

/**
 * Propositions for {@link CellInfoCdma} subjects.
 */
@TargetApi(JELLY_BEAN_MR1)
public final class CellInfoCdmaSubject extends AbstractCellInfoSubject<CellInfoCdma> {

  @Nullable
  private CellInfoCdma actual;

  public CellInfoCdmaSubject(@Nonnull FailureMetadata failureMetadata, @Nullable CellInfoCdma actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public CellInfoCdmaSubject hasCellIdentity(@Nullable CellIdentityCdma cellIdentity) {
    check("getCellIdentity()").that(actual.getCellIdentity()).isEqualTo(cellIdentity);
    return this;
  }

  public CellInfoCdmaSubject hasCellSignalStrength(@Nullable CellSignalStrengthCdma cellSignalStrength) {
    check("getCellSignalStrength()").that(actual.getCellSignalStrength()).isEqualTo(cellSignalStrength);
    return this;
  }
}
