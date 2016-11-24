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
import android.telephony.CellIdentityCdma;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR1;
import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link CellIdentityCdma} subjects.
 */
@TargetApi(JELLY_BEAN_MR1)
public final class CellIdentityCdmaSubject extends Subject<CellIdentityCdmaSubject, CellIdentityCdma> {
  private CellIdentityCdmaSubject(FailureStrategy failureStrategy, CellIdentityCdma subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<CellIdentityCdmaSubject, CellIdentityCdma> type() {
    return new SubjectFactory<CellIdentityCdmaSubject, CellIdentityCdma>() {
      @Override
      public CellIdentityCdmaSubject getSubject(FailureStrategy fs, CellIdentityCdma that) {
        return new CellIdentityCdmaSubject(fs, that);
      }
    };
  }

  public CellIdentityCdmaSubject hasBaseStationId(int id) {
    assertThat(actual().getBasestationId())
        .named("base station ID")
        .isEqualTo(id);
    return this;
  }

  public CellIdentityCdmaSubject hasLatitude(int latitude) {
    assertThat(actual().getLatitude())
        .named("latitude")
        .isEqualTo(latitude);
    return this;
  }

  public CellIdentityCdmaSubject hasLongitude(int longitude) {
    assertThat(actual().getLongitude())
        .named("longitude")
        .isEqualTo(longitude);
    return this;
  }

  public CellIdentityCdmaSubject hasNetworkId(int id) {
    assertThat(actual().getNetworkId())
        .named("network ID")
        .isEqualTo(id);
    return this;
  }

  public CellIdentityCdmaSubject hasSystemId(int id) {
    assertThat(actual().getSystemId())
        .named("system ID")
        .isEqualTo(id);
    return this;
  }
}
