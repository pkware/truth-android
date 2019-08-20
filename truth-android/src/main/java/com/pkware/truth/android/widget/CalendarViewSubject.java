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

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.widget.CalendarView;
import com.google.common.truth.FailureMetadata;

import java.util.Calendar;

import static android.os.Build.VERSION_CODES.JELLY_BEAN;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assert_;

/**
 * Propositions for {@link CalendarView} subjects.
 */
public class CalendarViewSubject extends AbstractFrameLayoutSubject<CalendarViewSubject, CalendarView> {
  public CalendarViewSubject(FailureMetadata failureMetadata, CalendarView subject) {
    super(failureMetadata, subject);
  }

  private static String dayOfWeekToString(@DayOfTheWeek int day) {
    switch (day) {
      case Calendar.SUNDAY:
        return "Sunday";
      case Calendar.MONDAY:
        return "Monday";
      case Calendar.TUESDAY:
        return "Tuesday";
      case Calendar.WEDNESDAY:
        return "Wednesday";
      case Calendar.THURSDAY:
        return "Thursday";
      case Calendar.FRIDAY:
        return "Friday";
      case Calendar.SATURDAY:
        return "Saturday";
      default:
        return "Unknown";
    }
  }

  public CalendarViewSubject hasDate(long date) {
    assertThat(actual().getDate())
        .named("date")
        .isEqualTo(date);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public CalendarViewSubject hasDateTextAppearance(int resId) {
    assertThat(actual().getDateTextAppearance())
        .named("date text appearance resource ID")
        .isEqualTo(resId);
    return this;
  }

  public CalendarViewSubject hasFirstDayOfWeek(@DayOfTheWeek int day) {
    int actualDay = actual().getFirstDayOfWeek();
    //noinspection WrongConstant
    assert_()
        .withMessage("Expected first day of the week to be <%s> but was <%s>",
            dayOfWeekToString(day), dayOfWeekToString(actualDay))
        .that(actualDay)
        .isEqualTo(day);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public CalendarViewSubject hasFocusedMonthDateColor(int color) {
    int actualColor = actual().getFocusedMonthDateColor();
    assert_()
        .withMessage("Expected focused month date color <%s> but was <%s>.",
            Integer.toHexString(color), Integer.toHexString(actualColor))
        .that(actualColor)
        .isEqualTo(color);
    return this;
  }

  public CalendarViewSubject hasMaxDate(long date) {
    assertThat(actual().getMaxDate())
        .named("maximum date")
        .isEqualTo(date);
    return this;
  }

  public CalendarViewSubject hasMinDate(long date) {
    assertThat(actual().getMinDate())
        .named("minimum date")
        .isEqualTo(date);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public CalendarViewSubject hasSelectedDateVerticalBar(Drawable drawable) {
    assertThat(actual().getSelectedDateVerticalBar())
        .named("selected date vertical bar")
        .isSameAs(drawable);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public CalendarViewSubject hasSelectedWeekBackgroundColor(int color) {
    int actualColor = actual().getSelectedWeekBackgroundColor();
    assert_()
        .withMessage("Expected selected week background color <%s> but was <%s>.",
            Integer.toHexString(color), Integer.toHexString(actualColor))
        .that(actualColor)
        .isEqualTo(color);
    return this;
  }

  public CalendarViewSubject isShowingWeekNumber() {
    assertThat(actual().getShowWeekNumber())
        .named("is showing week number")
        .isTrue();
    return this;
  }

  public CalendarViewSubject isNotShowingWeekNumber() {
    assertThat(actual().getShowWeekNumber())
        .named("is showing week number")
        .isFalse();
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public CalendarViewSubject hasShownWeekCount(int count) {
    assertThat(actual().getShownWeekCount())
        .named("shown week count")
        .isEqualTo(count);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public CalendarViewSubject hasUnfocusedMonthDateColor(int color) {
    int actualColor = actual().getUnfocusedMonthDateColor();
    assert_()
        .withMessage("Expected unfocused month date color <%s> but was <%s>.",
            Integer.toHexString(color), Integer.toHexString(actualColor))
        .that(actualColor)
        .isEqualTo(color);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public CalendarViewSubject hasWeekDayTextAppearance(int resId) {
    assertThat(actual().getWeekDayTextAppearance())
        .named("week day text appearance resource ID")
        .isEqualTo(resId);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public CalendarViewSubject hasWeekNumberColor(int color) {
    int actualColor = actual().getWeekNumberColor();
    assert_()
        .withMessage("Expected week number color <%s> but was <%s>.",
            Integer.toHexString(color), Integer.toHexString(actualColor))
        .that(actualColor)
        .isEqualTo(color);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public CalendarViewSubject hasWeekSeparatorLineColor(int color) {
    int actualColor = actual().getWeekSeparatorLineColor();
    assert_()
        .withMessage("Expected week separator line color <%s> but was <%s>.",
            Integer.toHexString(color), Integer.toHexString(actualColor))
        .that(actualColor)
        .isEqualTo(color);
    return this;
  }
}
