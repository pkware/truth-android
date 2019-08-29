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
package com.pkware.truth.android.os;

import android.annotation.TargetApi;
import android.os.PowerManager;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.os.Build.VERSION_CODES.KITKAT_WATCH;

/**
 * Propositions for {@link PowerManager} subjects.
 */
public class PowerManagerSubject extends Subject {

  @Nullable
  private final PowerManager actual;

  public PowerManagerSubject(@Nonnull FailureMetadata failureMetadata, @Nullable PowerManager actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void isScreenOn() {
    check("isScreenOn()").that(actual.isScreenOn()).isTrue();
  }

  public void isScreenOff() {
    check("isScreenOn()").that(actual.isScreenOn()).isFalse();
  }

  @TargetApi(KITKAT_WATCH)
  public void isInteractive() {
    check("isInteractive()").that(actual.isInteractive()).isTrue();
  }

  @TargetApi(KITKAT_WATCH)
  public void isNotInteractive() {
    check("isInteractive()").that(actual.isInteractive()).isFalse();
  }
}
