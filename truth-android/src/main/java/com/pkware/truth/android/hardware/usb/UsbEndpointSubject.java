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

import android.hardware.usb.UsbEndpoint;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link UsbEndpoint} subjects.
 */
public class UsbEndpointSubject extends Subject<UsbEndpointSubject, UsbEndpoint> {
  protected UsbEndpointSubject(FailureStrategy failureStrategy, UsbEndpoint subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<UsbEndpointSubject, UsbEndpoint> type() {
    return new SubjectFactory<UsbEndpointSubject, UsbEndpoint>() {
      @Override
      public UsbEndpointSubject getSubject(FailureStrategy fs, UsbEndpoint that) {
        return new UsbEndpointSubject(fs, that);
      }
    };
  }

  public UsbEndpointSubject hasAddress(int address) {
    assertThat(getSubject().getAddress())
        .named("address")
        .isEqualTo(address);
    return this;
  }

  public UsbEndpointSubject hasAttributes(int attributes) {
    assertThat(getSubject().getAttributes())
        .named("attributes")
        .isEqualTo(attributes);
    return this;
  }

  public UsbEndpointSubject hasDirection(int direction) {
    assertThat(getSubject().getDirection())
        .named("direction")
        .isEqualTo(direction);
    return this;
  }

  public UsbEndpointSubject hasEndpointNumber(int number) {
    assertThat(getSubject().getEndpointNumber())
        .named("endpoint number")
        .isEqualTo(number);
    return this;
  }

  public UsbEndpointSubject hasInterval(int interval) {
    assertThat(getSubject().getInterval())
        .named("interval")
        .isEqualTo(interval);
    return this;
  }

  public UsbEndpointSubject hasMaximumPacketSize(int size) {
    assertThat(getSubject().getMaxPacketSize())
        .named("maximum packet size")
        .isEqualTo(size);
    return this;
  }

  public UsbEndpointSubject hasType(int type) {
    assertThat(getSubject().getType())
        .named("type")
        .isEqualTo(type);
    return this;
  }
}
