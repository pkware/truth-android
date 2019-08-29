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

import android.telephony.ServiceState;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.telephony.ServiceState.STATE_EMERGENCY_ONLY;
import static android.telephony.ServiceState.STATE_IN_SERVICE;
import static android.telephony.ServiceState.STATE_OUT_OF_SERVICE;
import static android.telephony.ServiceState.STATE_POWER_OFF;
import static com.pkware.truth.android.internal.IntegerUtils.buildNamedValueString;

/**
 * Propositions for {@link ServiceState} subjects.
 */
public class ServiceStateSubject extends Subject {

  @Nullable
  private final ServiceState actual;

  public ServiceStateSubject(@Nonnull FailureMetadata failureMetadata, @Nullable ServiceState actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  @Nonnull
  public static String serviceStateToString(@ServiceStateState int serviceState) {
    return buildNamedValueString(serviceState)
        .value(STATE_EMERGENCY_ONLY, "emergency_only")
        .value(STATE_IN_SERVICE, "in_service")
        .value(STATE_OUT_OF_SERVICE, "out_of_service")
        .value(STATE_POWER_OFF, "power_off")
        .get();
  }

  public void isManualSelection() {
    check("getIsManualSelection()").that(actual.getIsManualSelection()).isTrue();
  }

  public void isAutomaticSelection() {
    check("getIsManualSelection()").that(actual.getIsManualSelection()).isFalse();
  }

  public void hasOperatorAlphaLong(@Nullable String operatorAlphaLong) {
    check("getOperatorAlphaLong()").that(actual.getOperatorAlphaLong()).isEqualTo(operatorAlphaLong);
  }

  public void hasOperatorAlphaShort(@Nullable String operatorAlphaShort) {
    check("getOperatorAlphaShort()").that(actual.getOperatorAlphaShort()).isEqualTo(operatorAlphaShort);
  }

  public void hasOperatorNumeric(@Nullable String operatorNumeric) {
    check("getOperatorNumeric()").that(actual.getOperatorNumeric()).isEqualTo(operatorNumeric);
  }

  public void isRoaming() {
    check("getRoaming()").that(actual.getRoaming()).isTrue();
  }

  public void isNotRoaming() {
    check("getRoaming()").that(actual.getRoaming()).isFalse();
  }

  public void hasState(@ServiceStateState int state) {
    int actualState = actual.getState();
    //noinspection ResourceType
    check("getState()")
        .withMessage("Expected state <%s> but was <%s>.", serviceStateToString(state),
            serviceStateToString(actualState))
        .that(actualState)
        .isEqualTo(state);
  }
}
