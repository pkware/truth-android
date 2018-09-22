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
import com.google.common.truth.Subject;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link DatePicker} subjects.
 */
public class DatePickerSubject extends AbstractFrameLayoutSubject<DatePickerSubject, DatePicker> {
  protected DatePickerSubject(FailureMetadata failureMetadata, DatePicker subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<DatePickerSubject, DatePicker> type() {
    return new Subject.Factory<DatePickerSubject, DatePicker>() {
      @Override
      public DatePickerSubject createSubject(FailureMetadata fm, DatePicker that) {
        return new DatePickerSubject(fm, that);
      }
    };
  }

  public DatePickerSubject isShowingCalendarView() {
    assertThat(actual().getCalendarViewShown())
        .named("is showing calendar view")
        .isTrue();
    return this;
  }

  public DatePickerSubject isNotShowingCalendarView() {
    assertThat(actual().getCalendarViewShown())
        .named("is showing calendar view")
        .isFalse();
    return this;
  }

  public DatePickerSubject hasDayOfMonth(int day) {
    assertThat(actual().getDayOfMonth())
        .named("day of the month")
        .isEqualTo(day);
    return this;
  }

  public DatePickerSubject hasMaxDate(long date) {
    assertThat(actual().getMaxDate())
        .named("maximum date")
        .isEqualTo(date);
    return this;
  }

  public DatePickerSubject hasMinDate(long date) {
    assertThat(actual().getMinDate())
        .named("minimum date")
        .isEqualTo(date);
    return this;
  }

  public DatePickerSubject hasMonth(int month) {
    assertThat(actual().getMonth())
        .named("month")
        .isEqualTo(month);
    return this;
  }

  public DatePickerSubject isShowingSpinners() {
    assertThat(actual().getSpinnersShown())
        .named("is showing spinners")
        .isTrue();
    return this;
  }

  public DatePickerSubject isNotShowingSpinners() {
    assertThat(actual().getSpinnersShown())
        .named("is showing spinners")
        .isFalse();
    return this;
  }

  public DatePickerSubject hasYear(int year) {
    assertThat(actual().getYear())
        .named("year")
        .isEqualTo(year);
    return this;
  }
}
