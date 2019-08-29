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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR1;

/**
 * Propositions for {@link CellIdentityLte} subjects.
 */
@TargetApi(JELLY_BEAN_MR1)
public final class CellIdentityLteSubject extends Subject {

  @Nullable
  private final CellIdentityLte actual;

  public CellIdentityLteSubject(@Nonnull FailureMetadata failureMetadata, @Nullable CellIdentityLte actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasCi(int ci) {
    check("getCi()").that(actual.getCi()).isEqualTo(ci);
  }

  public void hasMcc(int mcc) {
    check("getMcc()").that(actual.getMcc()).isEqualTo(mcc);
  }

  public void hasMnc(int mnc) {
    check("getMnc()").that(actual.getMnc()).isEqualTo(mnc);
  }

  public void hasPci(int pci) {
    check("getPci()").that(actual.getPci()).isEqualTo(pci);
  }

  public void hasTac(int tac) {
    check("getTac()").that(actual.getTac()).isEqualTo(tac);
  }
}
