/*
 * Copyright 2013 Square, Inc.
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

import android.support.annotation.IntDef;
import android.telephony.TelephonyManager;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;

@IntDef({
    TelephonyManager.NETWORK_TYPE_1xRTT,
    TelephonyManager.NETWORK_TYPE_CDMA,
    TelephonyManager.NETWORK_TYPE_EDGE,
    TelephonyManager.NETWORK_TYPE_EHRPD,
    TelephonyManager.NETWORK_TYPE_EVDO_0,
    TelephonyManager.NETWORK_TYPE_EVDO_A,
    TelephonyManager.NETWORK_TYPE_EVDO_B,
    TelephonyManager.NETWORK_TYPE_GPRS,
    TelephonyManager.NETWORK_TYPE_HSDPA,
    TelephonyManager.NETWORK_TYPE_HSPA,
    TelephonyManager.NETWORK_TYPE_HSPAP,
    TelephonyManager.NETWORK_TYPE_HSUPA,
    TelephonyManager.NETWORK_TYPE_IDEN,
    TelephonyManager.NETWORK_TYPE_LTE,
    TelephonyManager.NETWORK_TYPE_UMTS,
    TelephonyManager.NETWORK_TYPE_UNKNOWN
})
@Retention(SOURCE)
@interface TelephonyManagerNetworkType {
}
