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
import android.hardware.usb.UsbRequest;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link UsbRequest} subjects.
 */
public class UsbRequestSubject extends Subject<UsbRequestSubject, UsbRequest> {
  protected UsbRequestSubject(FailureStrategy failureStrategy, UsbRequest subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<UsbRequestSubject, UsbRequest> type() {
    return new SubjectFactory<UsbRequestSubject, UsbRequest>() {
      @Override
      public UsbRequestSubject getSubject(FailureStrategy fs, UsbRequest that) {
        return new UsbRequestSubject(fs, that);
      }
    };
  }

  public UsbRequestSubject hasClientData(Object data) {
    assertThat(getSubject().getClientData())
        .named("client data")
        .isEqualTo(data);
    return this;
  }

  public UsbRequestSubject hasEndpoint(UsbEndpoint endpoint) {
    assertThat(getSubject().getEndpoint())
        .named("endpoint")
        .isEqualTo(endpoint);
    return this;
  }
}
