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

import android.os.Vibrator;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link Vibrator} subjects.
 */
public class VibratorSubject extends Subject<VibratorSubject, Vibrator> {
  protected VibratorSubject(FailureStrategy failureStrategy, Vibrator subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<VibratorSubject, Vibrator> type() {
    return new SubjectFactory<VibratorSubject, Vibrator>() {
      @Override
      public VibratorSubject getSubject(FailureStrategy fs, Vibrator that) {
        return new VibratorSubject(fs, that);
      }
    };
  }

  public VibratorSubject hasVibrator() {
    assertThat(actual().hasVibrator())
        .named("has vibrator")
        .isTrue();
    return this;
  }

  public VibratorSubject hasNoVibrator() {
    assertThat(actual().hasVibrator())
        .named("has vibrator")
        .isFalse();
    return this;
  }
}
