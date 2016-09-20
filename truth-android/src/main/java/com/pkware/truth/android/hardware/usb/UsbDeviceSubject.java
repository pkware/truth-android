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
package com.pkware.truth.android.hardware.usb;

import android.hardware.usb.UsbDevice;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link UsbDevice} subjects.
 */
public class UsbDeviceSubject extends Subject<UsbDeviceSubject, UsbDevice> {
  protected UsbDeviceSubject(FailureStrategy failureStrategy, UsbDevice subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<UsbDeviceSubject, UsbDevice> type() {
    return new SubjectFactory<UsbDeviceSubject, UsbDevice>() {
      @Override
      public UsbDeviceSubject getSubject(FailureStrategy fs, UsbDevice that) {
        return new UsbDeviceSubject(fs, that);
      }
    };
  }

  public UsbDeviceSubject hasDeviceClass(int value) {
    assertThat(actual().getDeviceClass())
        .named("device class")
        .isEqualTo(value);
    return this;
  }

  public UsbDeviceSubject hasDeviceId(int id) {
    assertThat(actual().getDeviceId())
        .named("device id")
        .isEqualTo(id);
    return this;
  }

  public UsbDeviceSubject hasDeviceName(String name) {
    assertThat(actual().getDeviceName())
        .named("device name")
        .isEqualTo(name);
    return this;
  }

  public UsbDeviceSubject hasDeviceProtocol(int protocol) {
    assertThat(actual().getDeviceProtocol())
        .named("device protocol")
        .isEqualTo(protocol);
    return this;
  }

  public UsbDeviceSubject hasDeviceSubclass(int subclass) {
    assertThat(actual().getDeviceSubclass())
        .named("device subclass")
        .isEqualTo(subclass);
    return this;
  }

  public UsbDeviceSubject hasInterfaceCount(int count) {
    assertThat(actual().getInterfaceCount())
        .named("interface count")
        .isEqualTo(count);
    return this;
  }

  public UsbDeviceSubject hasProductId(int id) {
    assertThat(actual().getProductId())
        .named("product id")
        .isEqualTo(id);
    return this;
  }

  public UsbDeviceSubject hasVendorId(int id) {
    assertThat(actual().getVendorId())
        .named("vendor id")
        .isEqualTo(id);
    return this;
  }
}
