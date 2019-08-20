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
package com.pkware.truth.android.telephony.gsm;

import android.telephony.gsm.GsmCellLocation;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link GsmCellLocation} subjects.
 */
public class GsmCellLocationSubject extends Subject<GsmCellLocationSubject, GsmCellLocation> {
  public GsmCellLocationSubject(FailureMetadata failureMetadata, GsmCellLocation subject) {
    super(failureMetadata, subject);
  }

  public GsmCellLocationSubject hasCid(int cid) {
    assertThat(actual().getCid())
        .named("CID")
        .isEqualTo(cid);
    return this;
  }

  public GsmCellLocationSubject hasLac(int lac) {
    assertThat(actual().getLac())
        .named("LAC")
        .isEqualTo(lac);
    return this;
  }

  public GsmCellLocationSubject hasPsc(int psc) {
    assertThat(actual().getPsc())
        .named("PSC")
        .isEqualTo(psc);
    return this;
  }
}
