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
package com.pkware.truth.android.telephony.gsm;

import android.telephony.gsm.GsmCellLocation;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link GsmCellLocation} subjects.
 */
public class GsmCellLocationSubject extends Subject<GsmCellLocationSubject, GsmCellLocation> {
  protected GsmCellLocationSubject(FailureStrategy failureStrategy, GsmCellLocation subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<GsmCellLocationSubject, GsmCellLocation> type() {
    return new SubjectFactory<GsmCellLocationSubject, GsmCellLocation>() {
      @Override
      public GsmCellLocationSubject getSubject(FailureStrategy fs, GsmCellLocation that) {
        return new GsmCellLocationSubject(fs, that);
      }
    };
  }

  public GsmCellLocationSubject hasCid(int cid) {
    assertThat(getSubject().getCid())
        .named("CID")
        .isEqualTo(cid);
    return this;
  }

  public GsmCellLocationSubject hasLac(int lac) {
    assertThat(getSubject().getLac())
        .named("LAC")
        .isEqualTo(lac);
    return this;
  }

  public GsmCellLocationSubject hasPsc(int psc) {
    assertThat(getSubject().getPsc())
        .named("PSC")
        .isEqualTo(psc);
    return this;
  }
}
