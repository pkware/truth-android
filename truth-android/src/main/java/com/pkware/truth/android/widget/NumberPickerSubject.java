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

import android.widget.NumberPicker;

import com.google.common.truth.FailureMetadata;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link NumberPicker} subjects.
 */
public class NumberPickerSubject extends AbstractLinearLayoutSubject<NumberPicker> {

  @Nullable
  private final NumberPicker actual;

  public NumberPickerSubject(@Nonnull FailureMetadata failureMetadata, @Nullable NumberPicker actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasDisplayedValues(@Nonnull String[] values) {
    check("getDisplayedValues()").that(actual.getDisplayedValues()).asList().containsExactlyElementsIn(values).inOrder();
  }

  public void hasMaxValue(int value) {
    check("getMaxValue()").that(actual.getMaxValue()).isEqualTo(value);
  }

  public void hasMinValue(int value) {
    check("getMinValue()").that(actual.getMinValue()).isEqualTo(value);
  }

  public void hasValue(int value) {
    check("getValue()").that(actual.getValue()).isEqualTo(value);
  }

  public void isWrappingSelectorWheel() {
    check("getWrapSelectorWheel()").that(actual.getWrapSelectorWheel()).isTrue();
  }

  public void isNotWrappingSelectorWheel() {
    check("getWrapSelectorWheel()").that(actual.getWrapSelectorWheel()).isFalse();
  }
}
