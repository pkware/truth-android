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
import android.telephony.CellIdentityWcdma;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR2;
import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link CellIdentityWcdma} subjects.
 */
@TargetApi(JELLY_BEAN_MR2)
public final class CellIdentityWcdmaSubject extends Subject<CellIdentityWcdmaSubject, CellIdentityWcdma> {
  private CellIdentityWcdmaSubject(FailureMetadata failureMetadata, CellIdentityWcdma subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<CellIdentityWcdmaSubject, CellIdentityWcdma> type() {
    return CellIdentityWcdmaSubject::new;
  }

  public CellIdentityWcdmaSubject hasCid(int cid) {
    assertThat(actual().getCid())
        .named("CID")
        .isEqualTo(cid);
    return this;
  }

  public CellIdentityWcdmaSubject hasLac(int lac) {
    assertThat(actual().getLac())
        .named("LAC")
        .isEqualTo(lac);
    return this;
  }

  public CellIdentityWcdmaSubject hasMcc(int mcc) {
    assertThat(actual().getMcc())
        .named("MCC")
        .isEqualTo(mcc);
    return this;
  }

  public CellIdentityWcdmaSubject hasMnc(int mnc) {
    assertThat(actual().getMnc())
        .named("MNC")
        .isEqualTo(mnc);
    return this;
  }

  public CellIdentityWcdmaSubject hasPsc(int psc) {
    assertThat(actual().getPsc())
        .named("PSC")
        .isEqualTo(psc);
    return this;
  }
}
