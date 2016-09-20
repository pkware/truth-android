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

import android.annotation.TargetApi;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfoWcdma;
import android.telephony.CellSignalStrengthWcdma;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR2;
import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link CellInfoWcdma} subjects.
 */
@TargetApi(JELLY_BEAN_MR2)
public final class CellInfoWcdmaSubject extends AbstractCellInfoSubject<CellInfoWcdmaSubject, CellInfoWcdma> {
  private CellInfoWcdmaSubject(FailureStrategy failureStrategy, CellInfoWcdma subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<CellInfoWcdmaSubject, CellInfoWcdma> type() {
    return new SubjectFactory<CellInfoWcdmaSubject, CellInfoWcdma>() {
      @Override
      public CellInfoWcdmaSubject getSubject(FailureStrategy fs, CellInfoWcdma that) {
        return new CellInfoWcdmaSubject(fs, that);
      }
    };
  }

  public CellInfoWcdmaSubject hasCellIdentity(CellIdentityWcdma cellIdentity) {
    assertThat(actual().getCellIdentity())
        .named("cell identity")
        .isEqualTo(cellIdentity);
    return this;
  }

  public CellInfoWcdmaSubject hasCellSignalStrength(CellSignalStrengthWcdma cellSignalStrength) {
    assertThat(actual().getCellSignalStrength())
        .named("cell signal strength")
        .isEqualTo(cellSignalStrength);
    return this;
  }
}
