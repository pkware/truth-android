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

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link UsbInterface} subjects.
 */
public class UsbInterfaceSubject extends Subject {

  @Nullable
  private final UsbInterface actual;

  public UsbInterfaceSubject(@Nonnull FailureMetadata failureMetadata, @Nullable UsbInterface actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public UsbInterfaceSubject hasEndpointCount(int count) {
    check("getEndpointCount()").that(actual.getEndpointCount()).isEqualTo(count);
    return this;
  }

  public UsbInterfaceSubject hasId(int id) {
    check("getId()").that(actual.getId()).isEqualTo(id);
    return this;
  }

  public UsbInterfaceSubject hasInterfaceClass(int interfaceClass) {
    check("getInterfaceClass()").that(actual.getInterfaceClass()).isEqualTo(interfaceClass);
    return this;
  }

  public UsbInterfaceSubject hasInterfaceProtocol(int protocol) {
    check("getInterfaceProtocol()").that(actual.getInterfaceProtocol()).isEqualTo(protocol);
    return this;
  }

  public UsbInterfaceSubject hasInterfaceSubclass(int subclass) {
    check("getInterfaceSubclass()").that(actual.getInterfaceSubclass()).isEqualTo(subclass);
    return this;
  }
}
