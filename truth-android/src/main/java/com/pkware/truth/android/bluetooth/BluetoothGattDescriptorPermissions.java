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
package com.pkware.truth.android.bluetooth;

import android.bluetooth.BluetoothGattDescriptor;
import android.support.annotation.IntDef;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;

@IntDef(
    flag = true,
    value = {
        BluetoothGattDescriptor.PERMISSION_READ,
        BluetoothGattDescriptor.PERMISSION_READ_ENCRYPTED,
        BluetoothGattDescriptor.PERMISSION_READ_ENCRYPTED_MITM,
        BluetoothGattDescriptor.PERMISSION_WRITE,
        BluetoothGattDescriptor.PERMISSION_WRITE_ENCRYPTED,
        BluetoothGattDescriptor.PERMISSION_WRITE_ENCRYPTED_MITM,
        BluetoothGattDescriptor.PERMISSION_WRITE_SIGNED,
        BluetoothGattDescriptor.PERMISSION_WRITE_SIGNED_MITM
    }
)
@Retention(SOURCE)
@interface BluetoothGattDescriptorPermissions {
}
