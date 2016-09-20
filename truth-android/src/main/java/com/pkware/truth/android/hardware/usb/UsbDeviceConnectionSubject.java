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

import android.hardware.usb.UsbDeviceConnection;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link UsbDeviceConnection} subjects.
 */
public class UsbDeviceConnectionSubject extends Subject<UsbDeviceConnectionSubject, UsbDeviceConnection> {
  protected UsbDeviceConnectionSubject(FailureStrategy failureStrategy, UsbDeviceConnection subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<UsbDeviceConnectionSubject, UsbDeviceConnection> type() {
    return new SubjectFactory<UsbDeviceConnectionSubject, UsbDeviceConnection>() {
      @Override
      public UsbDeviceConnectionSubject getSubject(FailureStrategy fs, UsbDeviceConnection that) {
        return new UsbDeviceConnectionSubject(fs, that);
      }
    };
  }

  public UsbDeviceConnectionSubject hasFileDescriptor(int descriptor) {
    assertThat(actual().getFileDescriptor())
        .named("file descriptor")
        .isEqualTo(descriptor);
    return this;
  }

  public UsbDeviceConnectionSubject hasRawDescriptors(byte[] descriptors) {
    assertThat(actual().getRawDescriptors())
        .named("raw descriptors")
        .isEqualTo(descriptors);
    return this;
  }

  public UsbDeviceConnectionSubject hasSerial(String serial) {
    assertThat(actual().getSerial())
        .named("serial")
        .isEqualTo(serial);
    return this;
  }
}
