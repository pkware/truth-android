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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

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
import static com.pkware.truth.android.internal.IntegerUtils.buildNamedValueString;

/**
 * Propositions for {@link TelephonyManager} subjects.
 */
public class TelephonyManagerSubject extends Subject {

  @Nullable
  private final TelephonyManager actual;

  public TelephonyManagerSubject(@Nonnull FailureMetadata failureMetadata, @Nullable TelephonyManager actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  @Nonnull
  public static String callStateToString(@TelephonyManagerCallState int callState) {
    return buildNamedValueString(callState)
        .value(CALL_STATE_IDLE, "idle")
        .value(CALL_STATE_OFFHOOK, "offhook")
        .value(CALL_STATE_RINGING, "ringing")
        .get();
  }

  @Nonnull
  public static String dataActivityToString(@TelephonyManagerDataActivity int dataActivity) {
    return buildNamedValueString(dataActivity)
        .value(DATA_ACTIVITY_DORMANT, "dormant")
        .value(DATA_ACTIVITY_IN, "in")
        .value(DATA_ACTIVITY_INOUT, "inout")
        .value(DATA_ACTIVITY_NONE, "none")
        .value(DATA_ACTIVITY_OUT, "out")
        .get();
  }

  @Nonnull
  public static String dataStateToString(@TelephonyManagerDataState int dataState) {
    return buildNamedValueString(dataState)
        .value(DATA_CONNECTED, "connected")
        .value(DATA_CONNECTING, "connecting")
        .value(DATA_DISCONNECTED, "disconnected")
        .value(DATA_SUSPENDED, "suspended")
        .get();
  }

  @Nonnull
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

  @Nonnull
  public static String phoneTypeToString(@TelephonyManagerPhoneType int phoneType) {
    return buildNamedValueString(phoneType)
        .value(PHONE_TYPE_CDMA, "cdma")
        .value(PHONE_TYPE_GSM, "gsm")
        .value(PHONE_TYPE_NONE, "none")
        .value(PHONE_TYPE_SIP, "sip")
        .get();
  }

  @Nonnull
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

  public void hasCallState(@TelephonyManagerCallState int state) {
    int actualState = actual.getCallState();
    //noinspection ResourceType
    check("getCallState()")
        .withMessage("Expected call state <%s> but was <%s>.", callStateToString(state),
            callStateToString(actualState))
        .that(actualState)
        .isEqualTo(state);
  }

  public void hasCellLocation(@Nullable CellLocation cellLocation) {
    check("getCellLocation()").that(actual.getCellLocation()).isEqualTo(cellLocation);
  }

  public void hasDataActivity(@TelephonyManagerDataActivity int dataActivity) {
    int actualDataActivity = actual.getDataActivity();
    //noinspection ResourceType
    check("getDataActivity()")
        .withMessage("Expected data activity <%s> but was <%s>.",
            dataActivityToString(dataActivity), dataActivityToString(actualDataActivity))
        .that(actualDataActivity)
        .isEqualTo(dataActivity);
  }

  public void hasDataState(@TelephonyManagerDataState int dataState) {
    int actualDataState = actual.getDataState();
    //noinspection ResourceType
    check("getDataState()")
        .withMessage("Expected data state <%s> but was <%s>.",
            dataStateToString(dataState), dataStateToString(actualDataState))
        .that(actualDataState)
        .isEqualTo(dataState);
  }

  public void hasDeviceId(@Nullable String deviceId) {
    check("getDeviceId()").that(actual.getDeviceId()).isEqualTo(deviceId);
  }

  public void hasDeviceSoftwareVersion(@Nullable String version) {
    check("getDeviceSoftwareVersion()").that(actual.getDeviceSoftwareVersion()).isEqualTo(version);
  }

  @TargetApi(JELLY_BEAN_MR2)
  public void hasGroupIdLevel1(@Nullable String level) {
    check("getGroupIdLevel1()").that(actual.getGroupIdLevel1()).isEqualTo(level);
  }

  public void hasLine1Number(@Nullable String number) {
    check("getLine1Number()").that(actual.getLine1Number()).isEqualTo(number);
  }

  @TargetApi(KITKAT)
  public void hasMmsUAProfUrl(@Nullable String url) {
    check("getMmsUAProfUrl()").that(actual.getMmsUAProfUrl()).isEqualTo(url);
  }

  @TargetApi(KITKAT)
  public void hasMmsUserAgent(@Nullable String userAgent) {
    check("getMmsUserAgent()").that(actual.getMmsUserAgent()).isEqualTo(userAgent);
  }

  public void hasNetworkCountryIso(@Nullable String iso) {
    check("getNetworkCountryIso()").that(actual.getNetworkCountryIso()).isEqualTo(iso);
  }

  public void hasNetworkOperator(@Nullable String operator) {
    check("getNetworkOperator()").that(actual.getNetworkOperator()).isEqualTo(operator);
  }

  public void hasNetworkOperatorName(@Nullable String name) {
    check("getNetworkOperatorName()").that(actual.getNetworkOperatorName()).isEqualTo(name);
  }

  public void hasNetworkType(@TelephonyManagerNetworkType int type) {
    int actualType = actual.getNetworkType();
    //noinspection ResourceType
    check("getNetworkType()")
        .withMessage("Expected network type <%s> but was <%s>.",
            networkTypeToString(type), networkTypeToString(actualType))
        .that(actualType)
        .isEqualTo(type);
  }

  public void hasPhoneType(@TelephonyManagerPhoneType int type) {
    int actualType = actual.getPhoneType();
    //noinspection ResourceType
    check("getPhoneType()")
        .withMessage("Expected phone type <%s> but was <%s>.", phoneTypeToString(type),
            phoneTypeToString(actualType))
        .that(actualType)
        .isEqualTo(type);
  }

  public void hasSimCountryIso(@Nullable String iso) {
    check("getSimCountryIso()").that(actual.getSimCountryIso()).isEqualTo(iso);
  }

  public void hasSimOperator(@Nullable String operator) {
    check("getSimOperator()").that(actual.getSimOperator()).isEqualTo(operator);
  }

  public void hasSimOperatorName(@Nullable String name) {
    check("getSimOperatorName()").that(actual.getSimOperatorName()).isEqualTo(name);
  }

  public void hasSimSerialNumber(@Nullable String serialNumber) {
    check("getSimSerialNumber()").that(actual.getSimSerialNumber()).isEqualTo(serialNumber);
  }

  public void hasSimState(@TelephonyManagerSimState int state) {
    int actualState = actual.getSimState();
    //noinspection ResourceType
    check("getSimState()")
        .withMessage("Expected SIM state <%s> but was <%s>.", simStateToString(state),
            simStateToString(actualState))
        .that(actualState)
        .isEqualTo(state);
  }

  public void hasSubscriberId(@Nullable String id) {
    check("getSubscriberId()").that(actual.getSubscriberId()).isEqualTo(id);
  }

  public void hasVoiceMailAlphaTag(@Nullable String tag) {
    check("getVoiceMailAlphaTag()").that(actual.getVoiceMailAlphaTag()).isEqualTo(tag);
  }

  public void hasVoiceMailNumber(@Nullable String number) {
    check("getVoiceMailNumber()").that(actual.getVoiceMailNumber()).isEqualTo(number);
  }

  public void hasIccCard() {
    check("hasIccCard()").that(actual.hasIccCard()).isTrue();
  }

  public void doesNotHaveIccCard() {
    check("hasIccCard()").that(actual.hasIccCard()).isFalse();
  }

  public void isNetworkRoaming() {
    check("isNetworkRoaming()").that(actual.isNetworkRoaming()).isTrue();
  }

  public void isNotNetworkRoaming() {
    check("isNetworkRoaming()").that(actual.isNetworkRoaming()).isFalse();
  }
}
