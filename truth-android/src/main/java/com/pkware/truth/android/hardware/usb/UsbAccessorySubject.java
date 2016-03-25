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

import android.hardware.usb.UsbAccessory;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link UsbAccessory} subjects.
 */
public class UsbAccessorySubject extends Subject<UsbAccessorySubject, UsbAccessory> {
  protected UsbAccessorySubject(FailureStrategy failureStrategy, UsbAccessory subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<UsbAccessorySubject, UsbAccessory> type() {
    return new SubjectFactory<UsbAccessorySubject, UsbAccessory>() {
      @Override
      public UsbAccessorySubject getSubject(FailureStrategy fs, UsbAccessory that) {
        return new UsbAccessorySubject(fs, that);
      }
    };
  }

  public UsbAccessorySubject hasDescription(String description) {
    assertThat(getSubject().getDescription())
        .named("description")
        .isEqualTo(description);
    return this;
  }

  public UsbAccessorySubject hasManufacturer(String manufacturer) {
    assertThat(getSubject().getManufacturer())
        .named("manufacturer")
        .isEqualTo(manufacturer);
    return this;
  }

  public UsbAccessorySubject hasModel(String model) {
    assertThat(getSubject().getModel())
        .named("model")
        .isEqualTo(model);
    return this;
  }

  public UsbAccessorySubject hasSerial(String serial) {
    assertThat(getSubject().getSerial())
        .named("serial")
        .isEqualTo(serial);
    return this;
  }

  public UsbAccessorySubject hasUri(String uri) {
    assertThat(getSubject().getUri())
        .named("uri")
        .isEqualTo(uri);
    return this;
  }

  public UsbAccessorySubject hasVersion(String version) {
    assertThat(getSubject().getVersion())
        .named("version")
        .isEqualTo(version);
    return this;
  }
}
