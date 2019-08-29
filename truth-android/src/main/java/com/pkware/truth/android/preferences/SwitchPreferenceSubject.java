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

import androidx.annotation.StringRes;

import com.google.common.truth.FailureMetadata;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link SwitchPreference} subjects.
 */
public class SwitchPreferenceSubject extends AbstractTwoStatePreferenceSubject<SwitchPreference> {

  @Nullable
  private SwitchPreference actual;

  public SwitchPreferenceSubject(@Nonnull FailureMetadata failureMetadata, @Nullable SwitchPreference actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasSwitchTextOff(@Nullable CharSequence text) {
    check("getSwitchTextOff()").that(actual.getSwitchTextOff()).isEqualTo(text);
  }

  public void hasSwitchTextOff(@StringRes int resId) {
    hasSwitchTextOff(actual.getContext().getString(resId));
  }

  public void hasSwitchTextOn(@Nullable CharSequence text) {
    check("getSwitchTextOn()").that(actual.getSwitchTextOn()).isEqualTo(text);
  }

  public void hasSwitchTextOn(@StringRes int resId) {
    hasSwitchTextOn(actual.getContext().getString(resId));
  }
}
