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
import android.telephony.CellSignalStrengthCdma;

import com.google.common.truth.FailureMetadata;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR1;

/**
 * Propositions for {@link CellSignalStrengthCdma} subjects.
 * <p/>
 * This class is final. To extend use {@link AbstractCellSignalStrengthSubject}.
 */
@TargetApi(JELLY_BEAN_MR1)
public final class CellSignalStrengthCdmaSubject
    extends AbstractCellSignalStrengthSubject<CellSignalStrengthCdma> {

  @Nullable
  private CellSignalStrengthCdma actual;

  public CellSignalStrengthCdmaSubject(@Nonnull FailureMetadata failureMetadata, @Nullable CellSignalStrengthCdma actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public CellSignalStrengthCdmaSubject hasCdmaDbm(int dbm) {
    check("getCdmaDbm()").that(actual.getCdmaDbm()).isEqualTo(dbm);
    return this;
  }

  public CellSignalStrengthCdmaSubject hasCdmaEcio(int ecio) {
    check("getCdmaEcio()").that(actual.getCdmaEcio()).isEqualTo(ecio);
    return this;
  }

  public CellSignalStrengthCdmaSubject hasCdmaLevel(int level) {
    check("getCdmaLevel()").that(actual.getCdmaLevel()).isEqualTo(level);
    return this;
  }

  public CellSignalStrengthCdmaSubject hasEvdoDbm(int dbm) {
    check("getEvdoDbm()").that(actual.getEvdoDbm()).isEqualTo(dbm);
    return this;
  }

  public CellSignalStrengthCdmaSubject hasEvdoEcio(int ecio) {
    check("getEvdoEcio()").that(actual.getEvdoEcio()).isEqualTo(ecio);
    return this;
  }

  public CellSignalStrengthCdmaSubject hasEvdoLevel(int level) {
    check("getEvdoLevel()").that(actual.getEvdoLevel()).isEqualTo(level);
    return this;
  }

  public CellSignalStrengthCdmaSubject hasEvdoSnr(int snr) {
    check("getEvdoSnr()").that(actual.getEvdoSnr()).isEqualTo(snr);
    return this;
  }
}
