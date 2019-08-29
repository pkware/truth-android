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
import android.hardware.usb.UsbRequest;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link UsbRequest} subjects.
 */
public class UsbRequestSubject extends Subject {

  @Nullable
  private final UsbRequest actual;

  public UsbRequestSubject(@Nonnull FailureMetadata failureMetadata, @Nullable UsbRequest actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasClientData(@Nullable Object data) {
    check("getClientData()").that(actual.getClientData()).isEqualTo(data);
  }

  public void hasEndpoint(@Nullable UsbEndpoint endpoint) {
    check("getEndpoint()").that(actual.getEndpoint()).isEqualTo(endpoint);
  }
}
