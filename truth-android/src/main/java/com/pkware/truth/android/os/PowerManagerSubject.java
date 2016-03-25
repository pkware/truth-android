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
package com.pkware.truth.android.os;

import android.annotation.TargetApi;
import android.os.PowerManager;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.KITKAT_WATCH;
import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link PowerManager} subjects.
 */
public class PowerManagerSubject extends Subject<PowerManagerSubject, PowerManager> {
  protected PowerManagerSubject(FailureStrategy failureStrategy, PowerManager subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<PowerManagerSubject, PowerManager> type() {
    return new SubjectFactory<PowerManagerSubject, PowerManager>() {
      @Override
      public PowerManagerSubject getSubject(FailureStrategy fs, PowerManager that) {
        return new PowerManagerSubject(fs, that);
      }
    };
  }

  public PowerManagerSubject isScreenOn() {
    assertThat(getSubject().isScreenOn())
        .named("is screen on")
        .isTrue();
    return this;
  }

  public PowerManagerSubject isScreenOff() {
    assertThat(!getSubject().isScreenOn())
        .named("is screen off")
        .isTrue();
    return this;
  }

  @TargetApi(KITKAT_WATCH)
  public PowerManagerSubject isInteractive() {
    assertThat(getSubject().isInteractive())
        .named("is interactive")
        .isTrue();
    return this;
  }

  @TargetApi(KITKAT_WATCH)
  public PowerManagerSubject isNotInteractive() {
    isNotNull();
    assertThat(getSubject().isInteractive())
        .named("is interactive")
        .isFalse();
    return this;
  }
}
