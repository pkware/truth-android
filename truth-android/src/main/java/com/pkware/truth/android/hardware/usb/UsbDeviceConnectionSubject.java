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

import android.hardware.usb.UsbDeviceConnection;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link UsbDeviceConnection} subjects.
 */
public class UsbDeviceConnectionSubject extends Subject {

  @Nullable
  private final UsbDeviceConnection actual;

  public UsbDeviceConnectionSubject(@Nonnull FailureMetadata failureMetadata, @Nullable UsbDeviceConnection actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public UsbDeviceConnectionSubject hasFileDescriptor(int descriptor) {
    check("getFileDescriptor()").that(actual.getFileDescriptor()).isEqualTo(descriptor);
    return this;
  }

  public UsbDeviceConnectionSubject hasRawDescriptors(byte[] descriptors) {
    check("getRawDescriptors()").that(actual.getRawDescriptors()).isEqualTo(descriptors);
    return this;
  }

  public UsbDeviceConnectionSubject hasSerial(@Nullable String serial) {
    check("getSerial()").that(actual.getSerial()).isEqualTo(serial);
    return this;
  }
}
