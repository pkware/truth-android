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

import android.widget.NumberPicker;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link NumberPicker} subjects.
 */
public class NumberPickerSubject extends AbstractLinearLayoutSubject<NumberPickerSubject, NumberPicker> {
  protected NumberPickerSubject(FailureStrategy failureStrategy, NumberPicker subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<NumberPickerSubject, NumberPicker> type() {
    return new SubjectFactory<NumberPickerSubject, NumberPicker>() {
      @Override
      public NumberPickerSubject getSubject(FailureStrategy fs, NumberPicker that) {
        return new NumberPickerSubject(fs, that);
      }
    };
  }

  public NumberPickerSubject hasDisplayedValues(String[] values) {
    assertThat(actual().getDisplayedValues())
        .named("displayed values")
        .isEqualTo(values);
    return this;
  }

  public NumberPickerSubject hasMaxValue(int value) {
    assertThat(actual().getMaxValue())
        .named("maximum value")
        .isEqualTo(value);
    return this;
  }

  public NumberPickerSubject hasMinValue(int value) {
    assertThat(actual().getMinValue())
        .named("minimum value")
        .isEqualTo(value);
    return this;
  }

  public NumberPickerSubject hasValue(int value) {
    assertThat(actual().getValue())
        .named("value")
        .isEqualTo(value);
    return this;
  }

  public NumberPickerSubject isWrappingSelectorWheel() {
    assertThat(actual().getWrapSelectorWheel())
        .named("is wrapping selector wheel")
        .isTrue();
    return this;
  }

  public NumberPickerSubject isNotWrappingSelectorWheel() {
    assertThat(actual().getWrapSelectorWheel())
        .named("is wrapping selector wheel")
        .isFalse();
    return this;
  }
}
