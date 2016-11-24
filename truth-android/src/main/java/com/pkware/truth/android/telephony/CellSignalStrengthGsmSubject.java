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
import android.telephony.CellSignalStrengthGsm;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR1;

/**
 * Propositions for {@link CellSignalStrengthGsm} subjects.
 * <p/>
 * This class is final. To extend use {@link AbstractCellSignalStrengthSubject}.
 */
@TargetApi(JELLY_BEAN_MR1)
public final class CellSignalStrengthGsmSubject
    extends AbstractCellSignalStrengthSubject<CellSignalStrengthGsmSubject, CellSignalStrengthGsm> {
  private CellSignalStrengthGsmSubject(FailureStrategy failureStrategy, CellSignalStrengthGsm subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<CellSignalStrengthGsmSubject, CellSignalStrengthGsm> type() {
    return new SubjectFactory<CellSignalStrengthGsmSubject, CellSignalStrengthGsm>() {
      @Override
      public CellSignalStrengthGsmSubject getSubject(FailureStrategy fs, CellSignalStrengthGsm that) {
        return new CellSignalStrengthGsmSubject(fs, that);
      }
    };
  }
}
