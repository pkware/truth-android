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

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import java.util.UUID;

import static android.bluetooth.BluetoothGattService.SERVICE_TYPE_PRIMARY;
import static android.bluetooth.BluetoothGattService.SERVICE_TYPE_SECONDARY;
import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR2;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assert_;
import static com.pkware.truth.android.internal.IntegerUtils.buildNamedValueString;

/**
 * Propositions for {@link BluetoothGattService} subjects.
 */
@TargetApi(JELLY_BEAN_MR2)
public class BluetoothGattServiceSubject extends Subject<BluetoothGattServiceSubject, BluetoothGattService> {
  protected BluetoothGattServiceSubject(FailureStrategy failureStrategy, BluetoothGattService subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<BluetoothGattServiceSubject, BluetoothGattService> type() {
    return new SubjectFactory<BluetoothGattServiceSubject, BluetoothGattService>() {
      @Override
      public BluetoothGattServiceSubject getSubject(FailureStrategy fs, BluetoothGattService that) {
        return new BluetoothGattServiceSubject(fs, that);
      }
    };
  }

  public static String typeToString(@BluetoothGattServiceType int type) {
    return buildNamedValueString(type)
        .value(SERVICE_TYPE_PRIMARY, "primary")
        .value(SERVICE_TYPE_SECONDARY, "secondary")
        .get();
  }

  public BluetoothGattServiceSubject hasInstanceId(int id) {
    assertThat(actual().getInstanceId())
        .named("instance id")
        .isEqualTo(id);
    return this;
  }

  public BluetoothGattServiceSubject hasType(@BluetoothGattServiceType int type) {
    int actualType = actual().getType();
    //noinspection ResourceType
    assert_()
        .withFailureMessage("Expected type <%s> but was <%s>.",
            typeToString(type),
            typeToString(actualType))
        .that(actualType)
        .isEqualTo(type);
    return this;
  }

  public BluetoothGattServiceSubject hasUuid(UUID uuid) {
    assertThat(actual().getUuid())
        .named("UUID")
        .isEqualTo(uuid);
    return this;
  }
}
