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

import android.hardware.usb.UsbEndpoint;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link UsbEndpoint} subjects.
 */
public class UsbEndpointSubject extends Subject {

  @Nullable
  private final UsbEndpoint actual;

  public UsbEndpointSubject(@Nonnull FailureMetadata failureMetadata, @Nullable UsbEndpoint actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public UsbEndpointSubject hasAddress(int address) {
    check("getAddress()").that(actual.getAddress()).isEqualTo(address);
    return this;
  }

  public UsbEndpointSubject hasAttributes(int attributes) {
    check("getAttributes()").that(actual.getAttributes()).isEqualTo(attributes);
    return this;
  }

  public UsbEndpointSubject hasDirection(int direction) {
    check("getDirection()").that(actual.getDirection()).isEqualTo(direction);
    return this;
  }

  public UsbEndpointSubject hasEndpointNumber(int number) {
    check("getEndpointNumber()").that(actual.getEndpointNumber()).isEqualTo(number);
    return this;
  }

  public UsbEndpointSubject hasInterval(int interval) {
    check("getInterval()").that(actual.getInterval()).isEqualTo(interval);
    return this;
  }

  public UsbEndpointSubject hasMaximumPacketSize(int size) {
    check("getMaxPacketSize()").that(actual.getMaxPacketSize()).isEqualTo(size);
    return this;
  }

  public UsbEndpointSubject hasType(int type) {
    check("getType()").that(actual.getType()).isEqualTo(type);
    return this;
  }
}
