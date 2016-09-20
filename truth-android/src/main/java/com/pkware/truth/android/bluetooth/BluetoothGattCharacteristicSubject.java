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
package com.pkware.truth.android.bluetooth;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGattCharacteristic;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import java.util.UUID;

import static android.bluetooth.BluetoothGattCharacteristic.PERMISSION_READ;
import static android.bluetooth.BluetoothGattCharacteristic.PERMISSION_READ_ENCRYPTED;
import static android.bluetooth.BluetoothGattCharacteristic.PERMISSION_READ_ENCRYPTED_MITM;
import static android.bluetooth.BluetoothGattCharacteristic.PERMISSION_WRITE;
import static android.bluetooth.BluetoothGattCharacteristic.PERMISSION_WRITE_ENCRYPTED;
import static android.bluetooth.BluetoothGattCharacteristic.PERMISSION_WRITE_ENCRYPTED_MITM;
import static android.bluetooth.BluetoothGattCharacteristic.PERMISSION_WRITE_SIGNED;
import static android.bluetooth.BluetoothGattCharacteristic.PERMISSION_WRITE_SIGNED_MITM;
import static android.bluetooth.BluetoothGattCharacteristic.PROPERTY_BROADCAST;
import static android.bluetooth.BluetoothGattCharacteristic.PROPERTY_EXTENDED_PROPS;
import static android.bluetooth.BluetoothGattCharacteristic.PROPERTY_INDICATE;
import static android.bluetooth.BluetoothGattCharacteristic.PROPERTY_NOTIFY;
import static android.bluetooth.BluetoothGattCharacteristic.PROPERTY_READ;
import static android.bluetooth.BluetoothGattCharacteristic.PROPERTY_SIGNED_WRITE;
import static android.bluetooth.BluetoothGattCharacteristic.PROPERTY_WRITE;
import static android.bluetooth.BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE;
import static android.bluetooth.BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT;
import static android.bluetooth.BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE;
import static android.bluetooth.BluetoothGattCharacteristic.WRITE_TYPE_SIGNED;
import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR2;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assert_;
import static com.pkware.truth.android.internal.IntegerUtils.buildBitMaskString;
import static com.pkware.truth.android.internal.IntegerUtils.buildNamedValueString;

/**
 * Propositions for {@link BluetoothGattCharacteristic} subjects.
 */
@TargetApi(JELLY_BEAN_MR2)
public class BluetoothGattCharacteristicSubject extends Subject<BluetoothGattCharacteristicSubject, BluetoothGattCharacteristic> {
  protected BluetoothGattCharacteristicSubject(FailureStrategy failureStrategy, BluetoothGattCharacteristic subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<BluetoothGattCharacteristicSubject, BluetoothGattCharacteristic> type() {
    return new SubjectFactory<BluetoothGattCharacteristicSubject, BluetoothGattCharacteristic>() {
      @Override
      public BluetoothGattCharacteristicSubject getSubject(FailureStrategy fs, BluetoothGattCharacteristic that) {
        return new BluetoothGattCharacteristicSubject(fs, that);
      }
    };
  }

  public static String writeTypeToString(@BluetoothGattCharacteristicWriteType int writeType) {
    return buildNamedValueString(writeType)
        .value(WRITE_TYPE_DEFAULT, "default")
        .value(WRITE_TYPE_NO_RESPONSE, "no_response")
        .value(WRITE_TYPE_SIGNED, "signed")
        .get();
  }

  public static String permissionsToString(@BluetoothGattCharacteristicPermissions int permissions) {
    return buildBitMaskString(permissions)
        .flag(PERMISSION_READ, "read")
        .flag(PERMISSION_READ_ENCRYPTED, "read_encrypted")
        .flag(PERMISSION_READ_ENCRYPTED_MITM, "read_encrypted_mitm")
        .flag(PERMISSION_WRITE, "write")
        .flag(PERMISSION_WRITE_ENCRYPTED, "write_encrypted")
        .flag(PERMISSION_WRITE_ENCRYPTED_MITM, "write_encrypted_mitm")
        .flag(PERMISSION_WRITE_SIGNED, "write_signed")
        .flag(PERMISSION_WRITE_SIGNED_MITM, "write_signed_mitm")
        .get();
  }

  public static String propertiesToString(@BluetoothGattCharacteristicProperties int properties) {
    return buildBitMaskString(properties)
        .flag(PROPERTY_BROADCAST, "broadcast")
        .flag(PROPERTY_EXTENDED_PROPS, "extended_props")
        .flag(PROPERTY_INDICATE, "indicate")
        .flag(PROPERTY_NOTIFY, "notify")
        .flag(PROPERTY_READ, "read")
        .flag(PROPERTY_SIGNED_WRITE, "signed_write")
        .flag(PROPERTY_WRITE, "write")
        .flag(PROPERTY_WRITE_NO_RESPONSE, "write_no_response")
        .get();
  }

  public BluetoothGattCharacteristicSubject hasInstanceId(int id) {
    assertThat(actual().getInstanceId())
        .named("instance id")
        .isEqualTo(id);
    return this;
  }

  public BluetoothGattCharacteristicSubject hasPermissions(@BluetoothGattCharacteristicPermissions int permissions) {
    int actualPermissions = actual().getPermissions();
    //noinspection ResourceType
    assert_()
        .withFailureMessage("Expected permissions <%s> but was <%s>.",
            permissionsToString(permissions),
            permissionsToString(actualPermissions))
        .that(actualPermissions)
        .isEqualTo(permissions);
    return this;
  }

  public BluetoothGattCharacteristicSubject hasProperties(@BluetoothGattCharacteristicProperties int properties) {
    int actualProperties = actual().getProperties();
    //noinspection ResourceType
    assert_()
        .withFailureMessage("Expected properties <%s> but was <%s>.",
            propertiesToString(properties),
            propertiesToString(actualProperties))
        .that(actualProperties)
        .isEqualTo(properties);
    return this;
  }

  public BluetoothGattCharacteristicSubject hasUuid(UUID uuid) {
    assertThat(actual().getUuid())
        .named("UUID")
        .isEqualTo(uuid);
    return this;
  }

  public BluetoothGattCharacteristicSubject hasValue(byte[] value) {
    byte[] actualValue = actual().getValue();
    assertThat(actualValue)
        .named("value")
        .isEqualTo(value);
    return this;
  }

  public BluetoothGattCharacteristicSubject hasWriteType(@BluetoothGattCharacteristicWriteType int writeType) {
    int actualWriteType = actual().getWriteType();
    //noinspection ResourceType
    assert_()
        .withFailureMessage("Expected write type <%s> but was <%s>.",
            writeTypeToString(writeType),
            writeTypeToString(actualWriteType))
        .that(actualWriteType)
        .isEqualTo(writeType);
    return this;
  }
}
