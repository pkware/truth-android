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
import android.telephony.CellIdentityGsm;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR1;

/**
 * Propositions for {@link CellIdentityGsm} subject.
 */
@TargetApi(JELLY_BEAN_MR1)
public final class CellIdentityGsmSubject extends Subject {

  @Nullable
  private final CellIdentityGsm actual;

  public CellIdentityGsmSubject(@Nonnull FailureMetadata failureMetadata, @Nullable CellIdentityGsm actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public CellIdentityGsmSubject hasCid(int cid) {
    check("getCid()").that(actual.getCid()).isEqualTo(cid);
    return this;
  }

  public CellIdentityGsmSubject hasLac(int lac) {
    check("getLac()").that(actual.getLac()).isEqualTo(lac);
    return this;
  }

  public CellIdentityGsmSubject hasMcc(int mcc) {
    check("getMcc()").that(actual.getMcc()).isEqualTo(mcc);
    return this;
  }

  public CellIdentityGsmSubject hasMnc(int mnc) {
    check("getMnc()").that(actual.getMnc()).isEqualTo(mnc);
    return this;
  }

  public CellIdentityGsmSubject hasPsc(int psc) {
    check("getPsc()").that(actual.getPsc()).isEqualTo(psc);
    return this;
  }
}
