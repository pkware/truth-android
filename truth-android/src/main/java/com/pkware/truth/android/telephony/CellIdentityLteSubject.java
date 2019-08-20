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
import android.telephony.CellIdentityLte;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR1;
import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link CellIdentityLte} subjects.
 */
@TargetApi(JELLY_BEAN_MR1)
public final class CellIdentityLteSubject extends Subject<CellIdentityLteSubject, CellIdentityLte> {
  public CellIdentityLteSubject(FailureMetadata failureMetadata, CellIdentityLte subject) {
    super(failureMetadata, subject);
  }

  public CellIdentityLteSubject hasCi(int ci) {
    assertThat(actual().getCi())
        .named("CI")
        .isEqualTo(ci);
    return this;
  }

  public CellIdentityLteSubject hasMcc(int mcc) {
    assertThat(actual().getMcc())
        .named("MCC")
        .isEqualTo(mcc);
    return this;
  }

  public CellIdentityLteSubject hasMnc(int mnc) {
    assertThat(actual().getMnc())
        .named("MNC")
        .isEqualTo(mnc);
    return this;
  }

  public CellIdentityLteSubject hasPci(int pci) {
    assertThat(actual().getPci())
        .named("PCI")
        .isEqualTo(pci);
    return this;
  }

  public CellIdentityLteSubject hasTac(int tac) {
    assertThat(actual().getTac())
        .named("TAC")
        .isEqualTo(tac);
    return this;
  }
}
