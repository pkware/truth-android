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
import android.bluetooth.BluetoothGattService;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import java.util.UUID;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.bluetooth.BluetoothGattService.SERVICE_TYPE_PRIMARY;
import static android.bluetooth.BluetoothGattService.SERVICE_TYPE_SECONDARY;
import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR2;
import static com.pkware.truth.android.internal.IntegerUtils.buildNamedValueString;

/**
 * Propositions for {@link BluetoothGattService} subjects.
 */
@TargetApi(JELLY_BEAN_MR2)
public class BluetoothGattServiceSubject extends Subject {

  @Nullable
  private final BluetoothGattService actual;

  public BluetoothGattServiceSubject(@Nonnull FailureMetadata failureMetadata, @Nullable BluetoothGattService actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  @Nonnull
  public static String typeToString(@BluetoothGattServiceType int type) {
    return buildNamedValueString(type)
        .value(SERVICE_TYPE_PRIMARY, "primary")
        .value(SERVICE_TYPE_SECONDARY, "secondary")
        .get();
  }

  public void hasInstanceId(int id) {
    check("getInstanceId()").that(actual.getInstanceId()).isEqualTo(id);
  }

  public void hasType(@BluetoothGattServiceType int type) {
    int actualType = actual.getType();
    //noinspection ResourceType
    check("getType()")
        .withMessage("Expected type <%s> but was <%s>.",
            typeToString(type),
            typeToString(actualType))
        .that(actualType)
        .isEqualTo(type);
  }

  public void hasUuid(@Nullable UUID uuid) {
    check("getUuid()").that(actual.getUuid()).isEqualTo(uuid);
  }
}
