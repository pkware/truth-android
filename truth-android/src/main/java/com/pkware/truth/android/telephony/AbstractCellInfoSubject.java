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
import android.telephony.CellInfo;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;

import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR1;
import static com.google.common.truth.Truth.assertThat;

@TargetApi(JELLY_BEAN_MR1)
public abstract class AbstractCellInfoSubject<S extends AbstractCellInfoSubject<S, T>, T extends CellInfo>
    extends Subject<S, T> {

  protected AbstractCellInfoSubject(FailureStrategy failureStrategy, T subject) {
    super(failureStrategy, subject);
  }

  public S hasTimeStamp(long timeStamp) {
    assertThat(actual().getTimeStamp())
        .named("time stamp")
        .isEqualTo(timeStamp);
    return (S) this;
  }

  public S isRegistered() {
    assertThat(actual().isRegistered())
        .named("is registered")
        .isTrue();
    return (S) this;
  }
}
