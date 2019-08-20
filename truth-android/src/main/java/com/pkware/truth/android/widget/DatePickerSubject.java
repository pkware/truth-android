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

import android.widget.DatePicker;

import com.google.common.truth.FailureMetadata;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link DatePicker} subjects.
 */
public class DatePickerSubject extends AbstractFrameLayoutSubject<DatePicker> {

  @Nullable
  private final DatePicker actual;

  public DatePickerSubject(@Nonnull FailureMetadata failureMetadata, @Nullable DatePicker actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public DatePickerSubject isShowingCalendarView() {
    check("getCalendarViewShown()").that(actual.getCalendarViewShown()).isTrue();
    return this;
  }

  public DatePickerSubject isNotShowingCalendarView() {
    check("getCalendarViewShown()").that(actual.getCalendarViewShown()).isFalse();
    return this;
  }

  public DatePickerSubject hasDayOfMonth(int day) {
    check("getDayOfMonth()").that(actual.getDayOfMonth()).isEqualTo(day);
    return this;
  }

  public DatePickerSubject hasMaxDate(long date) {
    check("getMaxDate()").that(actual.getMaxDate()).isEqualTo(date);
    return this;
  }

  public DatePickerSubject hasMinDate(long date) {
    check("getMinDate()").that(actual.getMinDate()).isEqualTo(date);
    return this;
  }

  public DatePickerSubject hasMonth(int month) {
    check("getMonth()").that(actual.getMonth()).isEqualTo(month);
    return this;
  }

  public DatePickerSubject isShowingSpinners() {
    check("getSpinnersShown()").that(actual.getSpinnersShown()).isTrue();
    return this;
  }

  public DatePickerSubject isNotShowingSpinners() {
    check("getSpinnersShown()").that(actual.getSpinnersShown()).isFalse();
    return this;
  }

  public DatePickerSubject hasYear(int year) {
    check("getYear()").that(actual.getYear()).isEqualTo(year);
    return this;
  }
}
