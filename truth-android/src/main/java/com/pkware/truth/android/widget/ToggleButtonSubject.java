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
package com.pkware.truth.android.widget;

import android.support.annotation.StringRes;
import android.widget.ToggleButton;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link ToggleButton} subjects.
 */
public class ToggleButtonSubject
    extends AbstractCompoundButtonSubject<ToggleButtonSubject, ToggleButton> {
  protected ToggleButtonSubject(FailureStrategy failureStrategy, ToggleButton subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<ToggleButtonSubject, ToggleButton> type() {
    return new SubjectFactory<ToggleButtonSubject, ToggleButton>() {
      @Override
      public ToggleButtonSubject getSubject(FailureStrategy fs, ToggleButton that) {
        return new ToggleButtonSubject(fs, that);
      }
    };
  }

  public ToggleButtonSubject hasOnText(String text) {
    assertThat(getSubject().getTextOn().toString())
        .named("'on' text")
        .isEqualTo(text);
    return this;
  }

  public ToggleButtonSubject hasOnText(@StringRes int resId) {
    return hasOnText(getSubject().getContext().getString(resId));
  }

  public ToggleButtonSubject hasOffText(String text) {
    assertThat(getSubject().getTextOff().toString())
        .named("'off' text")
        .isEqualTo(text);
    return this;
  }

  public ToggleButtonSubject hasOffText(@StringRes int resId) {
    return hasOffText(getSubject().getContext().getString(resId));
  }
}
