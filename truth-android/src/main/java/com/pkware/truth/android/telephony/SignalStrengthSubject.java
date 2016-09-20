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
package com.pkware.truth.android.telephony;

import android.telephony.SignalStrength;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link SignalStrength} subjects.
 */
public class SignalStrengthSubject extends Subject<SignalStrengthSubject, SignalStrength> {
  protected SignalStrengthSubject(FailureStrategy failureStrategy, SignalStrength subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<SignalStrengthSubject, SignalStrength> type() {
    return new SubjectFactory<SignalStrengthSubject, SignalStrength>() {
      @Override
      public SignalStrengthSubject getSubject(FailureStrategy fs, SignalStrength that) {
        return new SignalStrengthSubject(fs, that);
      }
    };
  }

  public SignalStrengthSubject hasCdmaDbm(int dbm) {
    assertThat(actual().getCdmaDbm())
        .named("CDMA dBm")
        .isEqualTo(dbm);
    return this;
  }

  public SignalStrengthSubject hasCdmaEcio(int ecio) {
    assertThat(actual().getCdmaEcio())
        .named("CDMA Ec/Io")
        .isEqualTo(ecio);
    return this;
  }

  public SignalStrengthSubject hasEvdoDbm(int dbm) {
    assertThat(actual().getEvdoDbm())
        .named("EVDO dBm")
        .isEqualTo(dbm);
    return this;
  }

  public SignalStrengthSubject hasEvdoEcio(int ecio) {
    assertThat(actual().getEvdoEcio())
        .named("EVDO Ec/Io")
        .isEqualTo(ecio);
    return this;
  }

  public SignalStrengthSubject hasEvdoSnr(int snr) {
    assertThat(actual().getEvdoSnr())
        .named("EVDO signal to noise ratio")
        .isEqualTo(snr);
    return this;
  }

  public SignalStrengthSubject hasGsmSignalStrength(int signalStrength) {
    assertThat(actual().getGsmSignalStrength())
        .named("GSM signal strength")
        .isEqualTo(signalStrength);
    return this;
  }

  public SignalStrengthSubject isGsm() {
    assertThat(actual().isGsm())
        .named("is GSM")
        .isTrue();
    return this;
  }

  public SignalStrengthSubject isNotGsm() {
    assertThat(actual().isGsm())
        .named("is GSM")
        .isFalse();
    return this;
  }
}
