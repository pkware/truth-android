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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.os.Build.VERSION_CODES.JELLY_BEAN;

/**
 * Propositions for {@link CalendarView} subjects.
 */
public class CalendarViewSubject extends AbstractFrameLayoutSubject<CalendarView> {

  @Nullable
  private final CalendarView actual;

  public CalendarViewSubject(@Nonnull FailureMetadata failureMetadata, @Nullable CalendarView actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  @Nonnull
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

  public void hasDate(long date) {
    check("getDate()").that(actual.getDate()).isEqualTo(date);
  }

  @TargetApi(JELLY_BEAN)
  public void hasDateTextAppearance(int resId) {
    check("getDateTextAppearance()").that(actual.getDateTextAppearance()).isEqualTo(resId);
  }

  public void hasFirstDayOfWeek(@DayOfTheWeek int day) {
    int actualDay = actual.getFirstDayOfWeek();
    //noinspection WrongConstant
    check("getFirstDayOfWeek()")
        .withMessage("Expected first day of the week to be <%s> but was <%s>",
            dayOfWeekToString(day), dayOfWeekToString(actualDay))
        .that(actualDay)
        .isEqualTo(day);
  }

  @TargetApi(JELLY_BEAN)
  public void hasFocusedMonthDateColor(int color) {
    int actualColor = actual.getFocusedMonthDateColor();
    check("getFocusedMonthDateColor()")
        .withMessage("Expected focused month date color <%s> but was <%s>.",
            Integer.toHexString(color), Integer.toHexString(actualColor))
        .that(actualColor)
        .isEqualTo(color);
  }

  public void hasMaxDate(long date) {
    check("getMaxDate()").that(actual.getMaxDate()).isEqualTo(date);
  }

  public void hasMinDate(long date) {
    check("getMinDate()").that(actual.getMinDate()).isEqualTo(date);
  }

  @TargetApi(JELLY_BEAN)
  public void hasSelectedDateVerticalBar(@Nullable Drawable drawable) {
    check("getSelectedDateVerticalBar()").that(actual.getSelectedDateVerticalBar()).isSameInstanceAs(drawable);
  }

  @TargetApi(JELLY_BEAN)
  public void hasSelectedWeekBackgroundColor(int color) {
    int actualColor = actual.getSelectedWeekBackgroundColor();
    check("getSelectedWeekBackgroundColor()")
        .withMessage("Expected selected week background color <%s> but was <%s>.",
            Integer.toHexString(color), Integer.toHexString(actualColor))
        .that(actualColor)
        .isEqualTo(color);
  }

  public void isShowingWeekNumber() {
    check("getShowWeekNumber()").that(actual.getShowWeekNumber()).isTrue();
  }

  public void isNotShowingWeekNumber() {
    check("getShowWeekNumber()").that(actual.getShowWeekNumber()).isFalse();
  }

  @TargetApi(JELLY_BEAN)
  public void hasShownWeekCount(int count) {
    check("getShownWeekCount()").that(actual.getShownWeekCount()).isEqualTo(count);
  }

  @TargetApi(JELLY_BEAN)
  public void hasUnfocusedMonthDateColor(int color) {
    int actualColor = actual.getUnfocusedMonthDateColor();
    check("getUnfocusedMonthDateColor()")
        .withMessage("Expected unfocused month date color <%s> but was <%s>.",
            Integer.toHexString(color), Integer.toHexString(actualColor))
        .that(actualColor)
        .isEqualTo(color);
  }

  @TargetApi(JELLY_BEAN)
  public void hasWeekDayTextAppearance(int resId) {
    check("getWeekDayTextAppearance()").that(actual.getWeekDayTextAppearance()).isEqualTo(resId);
  }

  @TargetApi(JELLY_BEAN)
  public void hasWeekNumberColor(int color) {
    int actualColor = actual.getWeekNumberColor();
    check("getWeekNumberColor()")
        .withMessage("Expected week number color <%s> but was <%s>.",
            Integer.toHexString(color), Integer.toHexString(actualColor))
        .that(actualColor)
        .isEqualTo(color);
  }

  @TargetApi(JELLY_BEAN)
  public void hasWeekSeparatorLineColor(int color) {
    int actualColor = actual.getWeekSeparatorLineColor();
    check("getWeekSeparatorLineColor()")
        .withMessage("Expected week separator line color <%s> but was <%s>.",
            Integer.toHexString(color), Integer.toHexString(actualColor))
        .that(actualColor)
        .isEqualTo(color);
  }
}
