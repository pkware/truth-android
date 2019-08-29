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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link UsbAccessory} subjects.
 */
public class UsbAccessorySubject extends Subject {

  @Nullable
  private final UsbAccessory actual;

  public UsbAccessorySubject(@Nonnull FailureMetadata failureMetadata, @Nullable UsbAccessory actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasDescription(@Nullable String description) {
    check("getDescription()").that(actual.getDescription()).isEqualTo(description);
  }

  public void hasManufacturer(@Nullable String manufacturer) {
    check("getManufacturer()").that(actual.getManufacturer()).isEqualTo(manufacturer);
  }

  public void hasModel(@Nullable String model) {
    check("getModel()").that(actual.getModel()).isEqualTo(model);
  }

  public void hasSerial(@Nullable String serial) {
    check("getSerial()").that(actual.getSerial()).isEqualTo(serial);
  }

  public void hasUri(@Nullable String uri) {
    check("getUri()").that(actual.getUri()).isEqualTo(uri);
  }

  public void hasVersion(@Nullable String version) {
    check("getVersion()").that(actual.getVersion()).isEqualTo(version);
  }
}
