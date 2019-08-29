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
import android.telephony.CellInfoWcdma;
import android.telephony.CellSignalStrengthWcdma;

import com.google.common.truth.FailureMetadata;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR2;

/**
 * Propositions for {@link CellInfoWcdma} subjects.
 */
@TargetApi(JELLY_BEAN_MR2)
public final class CellInfoWcdmaSubject extends AbstractCellInfoSubject<CellInfoWcdma> {

  @Nullable
  private CellInfoWcdma actual;

  public CellInfoWcdmaSubject(@Nonnull FailureMetadata failureMetadata, @Nullable CellInfoWcdma actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasCellIdentity(@Nullable CellIdentityWcdma cellIdentity) {
    check("getCellIdentity()").that(actual.getCellIdentity()).isEqualTo(cellIdentity);
  }

  public void hasCellSignalStrength(@Nullable CellSignalStrengthWcdma cellSignalStrength) {
    check("getCellSignalStrength()").that(actual.getCellSignalStrength()).isEqualTo(cellSignalStrength);
  }
}
