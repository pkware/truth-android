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
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR2;
import static android.os.Build.VERSION_CODES.KITKAT;
import static android.telephony.TelephonyManager.CALL_STATE_IDLE;
import static android.telephony.TelephonyManager.CALL_STATE_OFFHOOK;
import static android.telephony.TelephonyManager.CALL_STATE_RINGING;
import static android.telephony.TelephonyManager.DATA_ACTIVITY_DORMANT;
import static android.telephony.TelephonyManager.DATA_ACTIVITY_IN;
import static android.telephony.TelephonyManager.DATA_ACTIVITY_INOUT;
import static android.telephony.TelephonyManager.DATA_ACTIVITY_NONE;
import static android.telephony.TelephonyManager.DATA_ACTIVITY_OUT;
import static android.telephony.TelephonyManager.DATA_CONNECTED;
import static android.telephony.TelephonyManager.DATA_CONNECTING;
import static android.telephony.TelephonyManager.DATA_DISCONNECTED;
import static android.telephony.TelephonyManager.DATA_SUSPENDED;
import static android.telephony.TelephonyManager.NETWORK_TYPE_1xRTT;
import static android.telephony.TelephonyManager.NETWORK_TYPE_CDMA;
import static android.telephony.TelephonyManager.NETWORK_TYPE_EDGE;
import static android.telephony.TelephonyManager.NETWORK_TYPE_EHRPD;
import static android.telephony.TelephonyManager.NETWORK_TYPE_EVDO_0;
import static android.telephony.TelephonyManager.NETWORK_TYPE_EVDO_A;
import static android.telephony.TelephonyManager.NETWORK_TYPE_EVDO_B;
import static android.telephony.TelephonyManager.NETWORK_TYPE_GPRS;
import static android.telephony.TelephonyManager.NETWORK_TYPE_HSDPA;
import static android.telephony.TelephonyManager.NETWORK_TYPE_HSPA;
import static android.telephony.TelephonyManager.NETWORK_TYPE_HSPAP;
import static android.telephony.TelephonyManager.NETWORK_TYPE_HSUPA;
import static android.telephony.TelephonyManager.NETWORK_TYPE_IDEN;
import static android.telephony.TelephonyManager.NETWORK_TYPE_LTE;
import static android.telephony.TelephonyManager.NETWORK_TYPE_UMTS;
import static android.telephony.TelephonyManager.NETWORK_TYPE_UNKNOWN;
import static android.telephony.TelephonyManager.PHONE_TYPE_CDMA;
import static android.telephony.TelephonyManager.PHONE_TYPE_GSM;
import static android.telephony.TelephonyManager.PHONE_TYPE_NONE;
import static android.telephony.TelephonyManager.PHONE_TYPE_SIP;
import static android.telephony.TelephonyManager.SIM_STATE_ABSENT;
import static android.telephony.TelephonyManager.SIM_STATE_NETWORK_LOCKED;
import static android.telephony.TelephonyManager.SIM_STATE_PIN_REQUIRED;
import static android.telephony.TelephonyManager.SIM_STATE_PUK_REQUIRED;
import static android.telephony.TelephonyManager.SIM_STATE_READY;
import static android.telephony.TelephonyManager.SIM_STATE_UNKNOWN;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assert_;
import static com.pkware.truth.android.internal.IntegerUtils.buildNamedValueString;

/**
 * Propositions for {@link TelephonyManager} subjects.
 */
public class TelephonyManagerSubject extends Subject<TelephonyManagerSubject, TelephonyManager> {
  protected TelephonyManagerSubject(FailureMetadata failureMetadata, TelephonyManager subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<TelephonyManagerSubject, TelephonyManager> type() {
    return new Subject.Factory<TelephonyManagerSubject, TelephonyManager>() {
      @Override
      public TelephonyManagerSubject createSubject(FailureMetadata fm, TelephonyManager that) {
        return new TelephonyManagerSubject(fm, that);
      }
    };
  }

  public static String callStateToString(@TelephonyManagerCallState int callState) {
    return buildNamedValueString(callState)
        .value(CALL_STATE_IDLE, "idle")
        .value(CALL_STATE_OFFHOOK, "offhook")
        .value(CALL_STATE_RINGING, "ringing")
        .get();
  }

  public static String dataActivityToString(@TelephonyManagerDataActivity int dataActivity) {
    return buildNamedValueString(dataActivity)
        .value(DATA_ACTIVITY_DORMANT, "dormant")
        .value(DATA_ACTIVITY_IN, "in")
        .value(DATA_ACTIVITY_INOUT, "inout")
        .value(DATA_ACTIVITY_NONE, "none")
        .value(DATA_ACTIVITY_OUT, "out")
        .get();
  }

  public static String dataStateToString(@TelephonyManagerDataState int dataState) {
    return buildNamedValueString(dataState)
        .value(DATA_CONNECTED, "connected")
        .value(DATA_CONNECTING, "connecting")
        .value(DATA_DISCONNECTED, "disconnected")
        .value(DATA_SUSPENDED, "suspended")
        .get();
  }

  public static String networkTypeToString(@TelephonyManagerNetworkType int networkType) {
    return buildNamedValueString(networkType)
        .value(NETWORK_TYPE_1xRTT, "1xRTT")
        .value(NETWORK_TYPE_CDMA, "cdma")
        .value(NETWORK_TYPE_EDGE, "edge")
        .value(NETWORK_TYPE_EHRPD, "ehrpd")
        .value(NETWORK_TYPE_EVDO_0, "evdo_0")
        .value(NETWORK_TYPE_EVDO_A, "evdo_A")
        .value(NETWORK_TYPE_EVDO_B, "evdo_b")
        .value(NETWORK_TYPE_GPRS, "gprs")
        .value(NETWORK_TYPE_HSDPA, "hsdpa")
        .value(NETWORK_TYPE_HSPA, "hspa")
        .value(NETWORK_TYPE_HSPAP, "hspap")
        .value(NETWORK_TYPE_HSUPA, "hsupa")
        .value(NETWORK_TYPE_IDEN, "iden")
        .value(NETWORK_TYPE_LTE, "lte")
        .value(NETWORK_TYPE_UMTS, "umts")
        .value(NETWORK_TYPE_UNKNOWN, "uknown")
        .get();
  }

  public static String phoneTypeToString(@TelephonyManagerPhoneType int phoneType) {
    return buildNamedValueString(phoneType)
        .value(PHONE_TYPE_CDMA, "cdma")
        .value(PHONE_TYPE_GSM, "gsm")
        .value(PHONE_TYPE_NONE, "none")
        .value(PHONE_TYPE_SIP, "sip")
        .get();
  }

  public static String simStateToString(@TelephonyManagerSimState int simState) {
    return buildNamedValueString(simState)
        .value(SIM_STATE_ABSENT, "absent")
        .value(SIM_STATE_NETWORK_LOCKED, "network_locked")
        .value(SIM_STATE_PIN_REQUIRED, "pin_required")
        .value(SIM_STATE_PUK_REQUIRED, "puk_required")
        .value(SIM_STATE_READY, "ready")
        .value(SIM_STATE_UNKNOWN, "uknown")
        .get();
  }

  public TelephonyManagerSubject hasCallState(@TelephonyManagerCallState int state) {
    int actualState = actual().getCallState();
    //noinspection ResourceType
    assert_()
        .withMessage("Expected call state <%s> but was <%s>.", callStateToString(state),
            callStateToString(actualState))
        .that(actualState)
        .isEqualTo(state);
    return this;
  }

  public TelephonyManagerSubject hasCellLocation(CellLocation cellLocation) {
    assertThat(actual().getCellLocation())
        .named("cell location")
        .isEqualTo(cellLocation);
    return this;
  }

  public TelephonyManagerSubject hasDataActivity(@TelephonyManagerDataActivity int dataActivity) {
    int actualDataActivity = actual().getDataActivity();
    //noinspection ResourceType
    assert_()
        .withMessage("Expected data activity <%s> but was <%s>.",
            dataActivityToString(dataActivity), dataActivityToString(actualDataActivity))
        .that(actualDataActivity)
        .isEqualTo(dataActivity);
    return this;
  }

  public TelephonyManagerSubject hasDataState(@TelephonyManagerDataState int dataState) {
    int actualDataState = actual().getDataState();
    //noinspection ResourceType
    assert_()
        .withMessage("Expected data state <%s> but was <%s>.",
            dataStateToString(dataState), dataStateToString(actualDataState))
        .that(actualDataState)
        .isEqualTo(dataState);
    return this;
  }

  public TelephonyManagerSubject hasDeviceId(String deviceId) {
    assertThat(actual().getDeviceId())
        .named("device ID")
        .isEqualTo(deviceId);
    return this;
  }

  public TelephonyManagerSubject hasDeviceSoftwareVersion(String version) {
    assertThat(actual().getDeviceSoftwareVersion())
        .named("device software version")
        .isEqualTo(version);
    return this;
  }

  @TargetApi(JELLY_BEAN_MR2)
  public TelephonyManagerSubject hasGroupIdLevel1(String level) {
    assertThat(actual().getGroupIdLevel1())
        .named("group ID level 1")
        .isEqualTo(level);
    return this;
  }

  public TelephonyManagerSubject hasLine1Number(String number) {
    assertThat(actual().getLine1Number())
        .named("line 1 number")
        .isEqualTo(number);
    return this;
  }

  @TargetApi(KITKAT)
  public TelephonyManagerSubject hasMmsUAProfUrl(String url) {
    assertThat(actual().getMmsUAProfUrl())
        .named("MMS user agent profile URL")
        .isEqualTo(url);
    return this;
  }

  @TargetApi(KITKAT)
  public TelephonyManagerSubject hasMmsUserAgent(String userAgent) {
    assertThat(actual().getMmsUserAgent())
        .named("MMS user agent")
        .isEqualTo(userAgent);
    return this;
  }

  public TelephonyManagerSubject hasNetworkCountryIso(String iso) {
    assertThat(actual().getNetworkCountryIso())
        .named("network country ISO")
        .isEqualTo(iso);
    return this;
  }

  public TelephonyManagerSubject hasNetworkOperator(String operator) {
    assertThat(actual().getNetworkOperator())
        .named("network operator")
        .isEqualTo(operator);
    return this;
  }

  public TelephonyManagerSubject hasNetworkOperatorName(String name) {
    assertThat(actual().getNetworkOperatorName())
        .named("network operator name")
        .isEqualTo(name);
    return this;
  }

  public TelephonyManagerSubject hasNetworkType(@TelephonyManagerNetworkType int type) {
    int actualType = actual().getNetworkType();
    //noinspection ResourceType
    assert_()
        .withMessage("Expected network type <%s> but was <%s>.",
            networkTypeToString(type), networkTypeToString(actualType))
        .that(actualType)
        .isEqualTo(type);
    return this;
  }

  public TelephonyManagerSubject hasPhoneType(@TelephonyManagerPhoneType int type) {
    int actualType = actual().getPhoneType();
    //noinspection ResourceType
    assert_()
        .withMessage("Expected phone type <%s> but was <%s>.", phoneTypeToString(type),
            phoneTypeToString(actualType))
        .that(actualType)
        .isEqualTo(type);
    return this;
  }

  public TelephonyManagerSubject hasSimCountryIso(String iso) {
    assertThat(actual().getSimCountryIso())
        .named("SIM country ISO")
        .isEqualTo(iso);
    return this;
  }

  public TelephonyManagerSubject hasSimOperator(String operator) {
    assertThat(actual().getSimOperator())
        .named("SIM operator")
        .isEqualTo(operator);
    return this;
  }

  public TelephonyManagerSubject hasSimOperatorName(String name) {
    assertThat(actual().getSimOperatorName())
        .named("SIM operator name")
        .isEqualTo(name);
    return this;
  }

  public TelephonyManagerSubject hasSimSerialNumber(String serialNumber) {
    assertThat(actual().getSimSerialNumber())
        .named("SIM serial number")
        .isEqualTo(serialNumber);
    return this;
  }

  public TelephonyManagerSubject hasSimState(@TelephonyManagerSimState int state) {
    int actualState = actual().getSimState();
    //noinspection ResourceType
    assert_()
        .withMessage("Expected SIM state <%s> but was <%s>.", simStateToString(state),
            simStateToString(actualState))
        .that(actualState)
        .isEqualTo(state);
    return this;
  }

  public TelephonyManagerSubject hasSubscriberId(String id) {
    assertThat(actual().getSubscriberId())
        .named("subscriber ID")
        .isEqualTo(id);
    return this;
  }

  public TelephonyManagerSubject hasVoiceMailAlphaTag(String tag) {
    assertThat(actual().getVoiceMailAlphaTag())
        .named("voice mail alpha tag")
        .isEqualTo(tag);
    return this;
  }

  public TelephonyManagerSubject hasVoiceMailNumber(String number) {
    assertThat(actual().getVoiceMailNumber())
        .named("voice mail number")
        .isEqualTo(number);
    return this;
  }

  public TelephonyManagerSubject hasIccCard() {
    assertThat(actual().hasIccCard())
        .named("has ICC card")
        .isTrue();
    return this;
  }

  public TelephonyManagerSubject doesNotHaveIccCard() {
    assertThat(actual().hasIccCard())
        .named("has ICC card")
        .isFalse();
    return this;
  }

  public TelephonyManagerSubject isNetworkRoaming() {
    assertThat(actual().isNetworkRoaming())
        .named("is roaming")
        .isTrue();
    return this;
  }

  public TelephonyManagerSubject isNotNetworkRoaming() {
    assertThat(actual().isNetworkRoaming())
        .named("is roaming")
        .isFalse();
    return this;
  }
}
