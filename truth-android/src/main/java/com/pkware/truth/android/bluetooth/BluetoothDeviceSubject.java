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
package com.pkware.truth.android.bluetooth;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothDevice;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import static android.bluetooth.BluetoothDevice.BOND_BONDED;
import static android.bluetooth.BluetoothDevice.BOND_BONDING;
import static android.bluetooth.BluetoothDevice.BOND_NONE;
import static android.bluetooth.BluetoothDevice.DEVICE_TYPE_CLASSIC;
import static android.bluetooth.BluetoothDevice.DEVICE_TYPE_DUAL;
import static android.bluetooth.BluetoothDevice.DEVICE_TYPE_LE;
import static android.bluetooth.BluetoothDevice.DEVICE_TYPE_UNKNOWN;
import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR2;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assert_;
import static com.pkware.truth.android.internal.IntegerUtils.buildNamedValueString;

/**
 * Propositions for {@link BluetoothDevice} subjects.
 */
@SuppressWarnings("MissingPermission")
public class BluetoothDeviceSubject extends Subject<BluetoothDeviceSubject, BluetoothDevice> {

  protected BluetoothDeviceSubject(FailureMetadata failureMetadata, BluetoothDevice subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<BluetoothDeviceSubject, BluetoothDevice> type() {
    return new Subject.Factory<BluetoothDeviceSubject, BluetoothDevice>() {
      @Override
      public BluetoothDeviceSubject createSubject(FailureMetadata fm, BluetoothDevice that) {
        return new BluetoothDeviceSubject(fm, that);
      }
    };
  }

  public static String bondStateToString(@BluetoothDeviceBondState int state) {
    return buildNamedValueString(state)
        .value(BOND_NONE, "none")
        .value(BOND_BONDED, "bonded")
        .value(BOND_BONDING, "bonding")
        .get();
  }

  @TargetApi(JELLY_BEAN_MR2)
  public static String typeToString(@BluetoothDeviceType int type) {
    return buildNamedValueString(type)
        .value(DEVICE_TYPE_CLASSIC, "classic")
        .value(DEVICE_TYPE_DUAL, "dual")
        .value(DEVICE_TYPE_LE, "le")
        .value(DEVICE_TYPE_UNKNOWN, "unknown")
        .get();
  }

  public BluetoothDeviceSubject hasAddress(String address) {
    assertThat(actual().getAddress())
        .named("address")
        .isEqualTo(address);
    return this;
  }

  public BluetoothDeviceSubject hasBondState(@BluetoothDeviceBondState int state) {
    int actualState = actual().getBondState();
    //noinspection ResourceType
    assert_()
        .withMessage("Expected bond state <%s> but was <%s>.",
            bondStateToString(state),
            bondStateToString(actualState))
        .that(actualState)
        .isEqualTo(state);
    return this;
  }

  public BluetoothDeviceSubject hasName(String name) {
    assertThat(actual().getName())
        .named("name")
        .isEqualTo(name);
    return this;
  }

  @TargetApi(JELLY_BEAN_MR2)
  public BluetoothDeviceSubject hasType(@BluetoothDeviceType int type) {
    int actualType = actual().getType();
    //noinspection ResourceType
    assert_()
        .withMessage("Expected type <%s> but was <%s>.",
            typeToString(type),
            typeToString(actualType))
        .that(actualType)
        .isEqualTo(type);
    return this;
  }
}
