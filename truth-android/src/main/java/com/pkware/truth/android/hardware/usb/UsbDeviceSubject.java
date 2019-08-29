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
package com.pkware.truth.android.hardware.usb;

import android.hardware.usb.UsbDevice;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link UsbDevice} subjects.
 */
public class UsbDeviceSubject extends Subject {

  @Nullable
  private final UsbDevice actual;

  public UsbDeviceSubject(@Nonnull FailureMetadata failureMetadata, @Nullable UsbDevice actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasDeviceClass(int value) {
    check("getDeviceClass()").that(actual.getDeviceClass()).isEqualTo(value);
  }

  public void hasDeviceId(int id) {
    check("getDeviceId()").that(actual.getDeviceId()).isEqualTo(id);
  }

  public void hasDeviceName(@Nullable String name) {
    check("getDeviceName()").that(actual.getDeviceName()).isEqualTo(name);
  }

  public void hasDeviceProtocol(int protocol) {
    check("getDeviceProtocol()").that(actual.getDeviceProtocol()).isEqualTo(protocol);
  }

  public void hasDeviceSubclass(int subclass) {
    check("getDeviceSubclass()").that(actual.getDeviceSubclass()).isEqualTo(subclass);
  }

  public void hasInterfaceCount(int count) {
    check("getInterfaceCount()").that(actual.getInterfaceCount()).isEqualTo(count);
  }

  public void hasProductId(int id) {
    check("getProductId()").that(actual.getProductId()).isEqualTo(id);
  }

  public void hasVendorId(int id) {
    check("getVendorId()").that(actual.getVendorId()).isEqualTo(id);
  }
}
