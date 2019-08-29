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
import android.bluetooth.BluetoothGattDescriptor;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import java.util.UUID;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.bluetooth.BluetoothGattDescriptor.PERMISSION_READ;
import static android.bluetooth.BluetoothGattDescriptor.PERMISSION_READ_ENCRYPTED;
import static android.bluetooth.BluetoothGattDescriptor.PERMISSION_READ_ENCRYPTED_MITM;
import static android.bluetooth.BluetoothGattDescriptor.PERMISSION_WRITE;
import static android.bluetooth.BluetoothGattDescriptor.PERMISSION_WRITE_ENCRYPTED;
import static android.bluetooth.BluetoothGattDescriptor.PERMISSION_WRITE_ENCRYPTED_MITM;
import static android.bluetooth.BluetoothGattDescriptor.PERMISSION_WRITE_SIGNED;
import static android.bluetooth.BluetoothGattDescriptor.PERMISSION_WRITE_SIGNED_MITM;
import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR2;
import static com.pkware.truth.android.internal.IntegerUtils.buildBitMaskString;

/**
 * Propositions for {@link BluetoothGattDescriptor} subjects.
 */
@TargetApi(JELLY_BEAN_MR2)
public class BluetoothGattDescriptorSubject extends Subject {

  @Nullable
  private final BluetoothGattDescriptor actual;

  public BluetoothGattDescriptorSubject(@Nonnull FailureMetadata failureMetadata, @Nullable BluetoothGattDescriptor actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  @Nonnull
  public static String permissionsToString(@BluetoothGattDescriptorPermissions int permissions) {
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

  public void hasPermissions(@BluetoothGattDescriptorPermissions int permissions) {
    int actualPermissions = actual.getPermissions();
    //noinspection ResourceType
    check("getPermissions()")
        .withMessage("Expected permissions <%s> but was <%s>.",
            permissionsToString(permissions),
            permissionsToString(actualPermissions))
        .that(actualPermissions)
        .isEqualTo(permissions);
  }

  public void hasUuid(@Nullable UUID uuid) {
    check("getUuid()").that(actual.getUuid()).isEqualTo(uuid);
  }

  public void hasValue(@Nonnull byte[] value) {
    check("getValue()").that(actual.getValue()).isEqualTo(value);
  }
}
