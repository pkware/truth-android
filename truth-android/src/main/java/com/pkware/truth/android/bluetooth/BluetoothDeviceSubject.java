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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.bluetooth.BluetoothDevice.BOND_BONDED;
import static android.bluetooth.BluetoothDevice.BOND_BONDING;
import static android.bluetooth.BluetoothDevice.BOND_NONE;
import static android.bluetooth.BluetoothDevice.DEVICE_TYPE_CLASSIC;
import static android.bluetooth.BluetoothDevice.DEVICE_TYPE_DUAL;
import static android.bluetooth.BluetoothDevice.DEVICE_TYPE_LE;
import static android.bluetooth.BluetoothDevice.DEVICE_TYPE_UNKNOWN;
import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR2;
import static com.pkware.truth.android.internal.IntegerUtils.buildNamedValueString;

/**
 * Propositions for {@link BluetoothDevice} subjects.
 */
@SuppressWarnings("MissingPermission")
public class BluetoothDeviceSubject extends Subject {

  @Nullable
  private final BluetoothDevice actual;

  public BluetoothDeviceSubject(@Nonnull FailureMetadata failureMetadata, @Nullable BluetoothDevice actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  @Nonnull
  public static String bondStateToString(@BluetoothDeviceBondState int state) {
    return buildNamedValueString(state)
        .value(BOND_NONE, "none")
        .value(BOND_BONDED, "bonded")
        .value(BOND_BONDING, "bonding")
        .get();
  }

  @Nonnull
  @TargetApi(JELLY_BEAN_MR2)
  public static String typeToString(@BluetoothDeviceType int type) {
    return buildNamedValueString(type)
        .value(DEVICE_TYPE_CLASSIC, "classic")
        .value(DEVICE_TYPE_DUAL, "dual")
        .value(DEVICE_TYPE_LE, "le")
        .value(DEVICE_TYPE_UNKNOWN, "unknown")
        .get();
  }

  public void hasAddress(@Nullable String address) {
    check("getAddress()").that(actual.getAddress()).isEqualTo(address);
  }

  public void hasBondState(@BluetoothDeviceBondState int state) {
    int actualState = actual.getBondState();
    //noinspection ResourceType
    check("getBondState()")
        .withMessage("Expected bond state <%s> but was <%s>.",
            bondStateToString(state),
            bondStateToString(actualState))
        .that(actualState)
        .isEqualTo(state);
  }

  public void hasName(@Nullable String name) {
    check("getName()").that(actual.getName()).isEqualTo(name);
  }

  @TargetApi(JELLY_BEAN_MR2)
  public void hasType(@BluetoothDeviceType int type) {
    int actualType = actual.getType();
    //noinspection ResourceType
    check("getType()")
        .withMessage("Expected type <%s> but was <%s>.",
            typeToString(type),
            typeToString(actualType))
        .that(actualType)
        .isEqualTo(type);
  }
}
