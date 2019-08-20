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

import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR1;
import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link CellSignalStrengthCdma} subjects.
 * <p/>
 * This class is final. To extend use {@link AbstractCellSignalStrengthSubject}.
 */
@TargetApi(JELLY_BEAN_MR1)
public final class CellSignalStrengthCdmaSubject
    extends AbstractCellSignalStrengthSubject<CellSignalStrengthCdmaSubject, CellSignalStrengthCdma> {
  public CellSignalStrengthCdmaSubject(FailureMetadata failureMetadata, CellSignalStrengthCdma subject) {
    super(failureMetadata, subject);
  }

  public CellSignalStrengthCdmaSubject hasCdmaDbm(int dbm) {
    assertThat(actual().getCdmaDbm())
        .named("CDMA dBm")
        .isEqualTo(dbm);
    return this;
  }

  public CellSignalStrengthCdmaSubject hasCdmaEcio(int ecio) {
    assertThat(actual().getCdmaEcio())
        .named("CDMA Ec/Io")
        .isEqualTo(ecio);
    return this;
  }

  public CellSignalStrengthCdmaSubject hasCdmaLevel(int level) {
    assertThat(actual().getCdmaLevel())
        .named("CDMA level")
        .isEqualTo(level);
    return this;
  }

  public CellSignalStrengthCdmaSubject hasEvdoDbm(int dbm) {
    assertThat(actual().getEvdoDbm())
        .named("EVDO dBm")
        .isEqualTo(dbm);
    return this;
  }

  public CellSignalStrengthCdmaSubject hasEvdoEcio(int ecio) {
    assertThat(actual().getEvdoEcio())
        .named("EVDO Ec/Io")
        .isEqualTo(ecio);
    return this;
  }

  public CellSignalStrengthCdmaSubject hasEvdoLevel(int level) {
    assertThat(actual().getEvdoLevel())
        .named("EVDO level")
        .isEqualTo(level);
    return this;
  }

  public CellSignalStrengthCdmaSubject hasEvdoSnr(int snr) {
    assertThat(actual().getEvdoSnr())
        .named("EVDO signal to noise ratio")
        .isEqualTo(snr);
    return this;
  }
}
