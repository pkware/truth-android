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

import android.hardware.usb.UsbAccessory;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link UsbAccessory} subjects.
 */
public class UsbAccessorySubject extends Subject<UsbAccessorySubject, UsbAccessory> {
  protected UsbAccessorySubject(FailureMetadata failureMetadata, UsbAccessory subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<UsbAccessorySubject, UsbAccessory> type() {
    return UsbAccessorySubject::new;
  }

  public UsbAccessorySubject hasDescription(String description) {
    assertThat(actual().getDescription())
        .named("description")
        .isEqualTo(description);
    return this;
  }

  public UsbAccessorySubject hasManufacturer(String manufacturer) {
    assertThat(actual().getManufacturer())
        .named("manufacturer")
        .isEqualTo(manufacturer);
    return this;
  }

  public UsbAccessorySubject hasModel(String model) {
    assertThat(actual().getModel())
        .named("model")
        .isEqualTo(model);
    return this;
  }

  public UsbAccessorySubject hasSerial(String serial) {
    assertThat(actual().getSerial())
        .named("serial")
        .isEqualTo(serial);
    return this;
  }

  public UsbAccessorySubject hasUri(String uri) {
    assertThat(actual().getUri())
        .named("uri")
        .isEqualTo(uri);
    return this;
  }

  public UsbAccessorySubject hasVersion(String version) {
    assertThat(actual().getVersion())
        .named("version")
        .isEqualTo(version);
    return this;
  }
}
