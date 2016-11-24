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

import android.hardware.usb.UsbInterface;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link UsbInterface} subjects.
 */
public class UsbInterfaceSubject extends Subject<UsbInterfaceSubject, UsbInterface> {
  protected UsbInterfaceSubject(FailureStrategy failureStrategy, UsbInterface subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<UsbInterfaceSubject, UsbInterface> type() {
    return new SubjectFactory<UsbInterfaceSubject, UsbInterface>() {
      @Override
      public UsbInterfaceSubject getSubject(FailureStrategy fs, UsbInterface that) {
        return new UsbInterfaceSubject(fs, that);
      }
    };
  }

  public UsbInterfaceSubject hasEndpointCount(int count) {
    assertThat(actual().getEndpointCount())
        .named("endpoint count")
        .isEqualTo(count);
    return this;
  }

  public UsbInterfaceSubject hasId(int id) {
    assertThat(actual().getId())
        .named("id")
        .isEqualTo(id);
    return this;
  }

  public UsbInterfaceSubject hasInterfaceClass(int interfaceClass) {
    assertThat(actual().getInterfaceClass())
        .named("interface class")
        .isEqualTo(interfaceClass);
    return this;
  }

  public UsbInterfaceSubject hasInterfaceProtocol(int protocol) {
    assertThat(actual().getInterfaceProtocol())
        .named("interface protocol")
        .isEqualTo(protocol);
    return this;
  }

  public UsbInterfaceSubject hasInterfaceSubclass(int subclass) {
    assertThat(actual().getInterfaceSubclass())
        .named("interface subclass")
        .isEqualTo(subclass);
    return this;
  }
}
