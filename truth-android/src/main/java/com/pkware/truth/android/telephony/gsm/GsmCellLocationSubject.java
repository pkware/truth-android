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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link GsmCellLocation} subjects.
 */
public class GsmCellLocationSubject extends Subject {

  @Nullable
  private final GsmCellLocation actual;

  public GsmCellLocationSubject(@Nonnull FailureMetadata failureMetadata, @Nullable GsmCellLocation actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasCid(int cid) {
    check("getCid()").that(actual.getCid()).isEqualTo(cid);
  }

  public void hasLac(int lac) {
    check("getLac()").that(actual.getLac()).isEqualTo(lac);
  }

  public void hasPsc(int psc) {
    check("getPsc()").that(actual.getPsc()).isEqualTo(psc);
  }
}
