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

import android.telephony.ServiceState;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static android.telephony.ServiceState.STATE_EMERGENCY_ONLY;
import static android.telephony.ServiceState.STATE_IN_SERVICE;
import static android.telephony.ServiceState.STATE_OUT_OF_SERVICE;
import static android.telephony.ServiceState.STATE_POWER_OFF;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assert_;
import static com.pkware.truth.android.internal.IntegerUtils.buildNamedValueString;

/**
 * Propositions for {@link ServiceState} subjects.
 */
public class ServiceStateSubject extends Subject<ServiceStateSubject, ServiceState> {
  protected ServiceStateSubject(FailureStrategy failureStrategy, ServiceState subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<ServiceStateSubject, ServiceState> type() {
    return new SubjectFactory<ServiceStateSubject, ServiceState>() {
      @Override
      public ServiceStateSubject getSubject(FailureStrategy fs, ServiceState that) {
        return new ServiceStateSubject(fs, that);
      }
    };
  }

  public static String serviceStateToString(@ServiceStateState int serviceState) {
    return buildNamedValueString(serviceState)
        .value(STATE_EMERGENCY_ONLY, "emergency_only")
        .value(STATE_IN_SERVICE, "in_service")
        .value(STATE_OUT_OF_SERVICE, "out_of_service")
        .value(STATE_POWER_OFF, "power_off")
        .get();
  }

  public ServiceStateSubject isManualSelection() {
    assertThat(getSubject().getIsManualSelection())
        .named("is manual selection mode")
        .isTrue();
    return this;
  }

  public ServiceStateSubject isAutomaticSelection() {
    assertThat(!getSubject().getIsManualSelection())
        .named("is automatic selection mode")
        .isTrue();
    return this;
  }

  public ServiceStateSubject hasOperatorAlphaLong(String operatorAlphaLong) {
    assertThat(getSubject().getOperatorAlphaLong())
        .named("operator name in long alphanumeric format")
        .isEqualTo(operatorAlphaLong);
    return this;
  }

  public ServiceStateSubject hasOperatorAlphaShort(String operatorAlphaShort) {
    assertThat(getSubject().getOperatorAlphaShort())
        .named("operator name in short alphanumeric format")
        .isEqualTo(operatorAlphaShort);
    return this;
  }

  public ServiceStateSubject hasOperatorNumeric(String operatorNumeric) {
    assertThat(getSubject().getOperatorNumeric())
        .named("operator numeric ID")
        .isEqualTo(operatorNumeric);
    return this;
  }

  public ServiceStateSubject isRoaming() {
    assertThat(getSubject().getRoaming())
        .named("is roaming")
        .isTrue();
    return this;
  }

  public ServiceStateSubject isNotRoaming() {
    assertThat(getSubject().getRoaming())
        .named("is roaming")
        .isFalse();
    return this;
  }

  public ServiceStateSubject hasState(@ServiceStateState int state) {
    int actualState = getSubject().getState();
    //noinspection ResourceType
    assert_()
        .withFailureMessage("Expected state <%s> but was <%s>.", serviceStateToString(state),
            serviceStateToString(actualState))
        .that(actualState)
        .isEqualTo(state);
    return this;
  }
}
