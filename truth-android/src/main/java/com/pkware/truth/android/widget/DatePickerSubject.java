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

  public void isShowingCalendarView() {
    check("getCalendarViewShown()").that(actual.getCalendarViewShown()).isTrue();
  }

  public void isNotShowingCalendarView() {
    check("getCalendarViewShown()").that(actual.getCalendarViewShown()).isFalse();
  }

  public void hasDayOfMonth(int day) {
    check("getDayOfMonth()").that(actual.getDayOfMonth()).isEqualTo(day);
  }

  public void hasMaxDate(long date) {
    check("getMaxDate()").that(actual.getMaxDate()).isEqualTo(date);
  }

  public void hasMinDate(long date) {
    check("getMinDate()").that(actual.getMinDate()).isEqualTo(date);
  }

  public void hasMonth(int month) {
    check("getMonth()").that(actual.getMonth()).isEqualTo(month);
  }

  public void isShowingSpinners() {
    check("getSpinnersShown()").that(actual.getSpinnersShown()).isTrue();
  }

  public void isNotShowingSpinners() {
    check("getSpinnersShown()").that(actual.getSpinnersShown()).isFalse();
  }

  public void hasYear(int year) {
    check("getYear()").that(actual.getYear()).isEqualTo(year);
  }
}
