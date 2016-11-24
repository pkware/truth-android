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
package com.pkware.truth.android.preferences;

import android.preference.SwitchPreference;
import android.support.annotation.StringRes;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link SwitchPreference} subjects.
 */
public class SwitchPreferenceSubject extends AbstractTwoStatePreferenceSubject<SwitchPreferenceSubject, SwitchPreference> {
  protected SwitchPreferenceSubject(FailureStrategy failureStrategy, SwitchPreference subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<SwitchPreferenceSubject, SwitchPreference> type() {
    return new SubjectFactory<SwitchPreferenceSubject, SwitchPreference>() {
      @Override
      public SwitchPreferenceSubject getSubject(FailureStrategy fs, SwitchPreference that) {
        return new SwitchPreferenceSubject(fs, that);
      }
    };
  }

  public SwitchPreferenceSubject hasSwitchTextOff(CharSequence text) {
    assertThat(actual().getSwitchTextOff())
        .named("switch off text")
        .isEqualTo(text);
    return this;
  }

  public SwitchPreferenceSubject hasSwitchTextOff(@StringRes int resId) {
    return hasSwitchTextOff(actual().getContext().getString(resId));
  }

  public SwitchPreferenceSubject hasSwitchTextOn(CharSequence text) {
    assertThat(actual().getSwitchTextOn())
        .named("switch on text")
        .isEqualTo(text);
    return this;
  }

  public SwitchPreferenceSubject hasSwitchTextOn(@StringRes int resId) {
    return hasSwitchTextOn(actual().getContext().getString(resId));
  }
}
