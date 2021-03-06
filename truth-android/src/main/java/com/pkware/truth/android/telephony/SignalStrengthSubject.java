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

import android.telephony.SignalStrength;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link SignalStrength} subjects.
 */
public class SignalStrengthSubject extends Subject {

  @Nullable
  private final SignalStrength actual;

  public SignalStrengthSubject(@Nonnull FailureMetadata failureMetadata, @Nullable SignalStrength actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasCdmaDbm(int dbm) {
    check("getCdmaDbm()").that(actual.getCdmaDbm()).isEqualTo(dbm);
  }

  public void hasCdmaEcio(int ecio) {
    check("getCdmaEcio()").that(actual.getCdmaEcio()).isEqualTo(ecio);
  }

  public void hasEvdoDbm(int dbm) {
    check("getEvdoDbm()").that(actual.getEvdoDbm()).isEqualTo(dbm);
  }

  public void hasEvdoEcio(int ecio) {
    check("getEvdoEcio()").that(actual.getEvdoEcio()).isEqualTo(ecio);
  }

  public void hasEvdoSnr(int snr) {
    check("getEvdoSnr()").that(actual.getEvdoSnr()).isEqualTo(snr);
  }

  public void hasGsmSignalStrength(int signalStrength) {
    check("getGsmSignalStrength()").that(actual.getGsmSignalStrength()).isEqualTo(signalStrength);
  }

  public void isGsm() {
    check("isGsm()").that(actual.isGsm()).isTrue();
  }

  public void isNotGsm() {
    check("isGsm()").that(actual.isGsm()).isFalse();
  }
}
