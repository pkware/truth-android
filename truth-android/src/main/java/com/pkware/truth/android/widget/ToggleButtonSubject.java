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
package com.pkware.truth.android.widget;

import android.widget.ToggleButton;
import androidx.annotation.StringRes;

import com.google.common.truth.FailureMetadata;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link ToggleButton} subjects.
 */
public class ToggleButtonSubject
    extends AbstractCompoundButtonSubject<ToggleButtonSubject, ToggleButton> {
  public ToggleButtonSubject(FailureMetadata failureMetadata, ToggleButton subject) {
    super(failureMetadata, subject);
  }

  public ToggleButtonSubject hasOnText(String text) {
    assertThat(actual().getTextOn().toString())
        .named("'on' text")
        .isEqualTo(text);
    return this;
  }

  public ToggleButtonSubject hasOnText(@StringRes int resId) {
    return hasOnText(actual().getContext().getString(resId));
  }

  public ToggleButtonSubject hasOffText(String text) {
    assertThat(actual().getTextOff().toString())
        .named("'off' text")
        .isEqualTo(text);
    return this;
  }

  public ToggleButtonSubject hasOffText(@StringRes int resId) {
    return hasOffText(actual().getContext().getString(resId));
  }
}
