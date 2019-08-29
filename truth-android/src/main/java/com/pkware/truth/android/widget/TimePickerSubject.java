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
import android.widget.TimePicker;

import androidx.annotation.IntRange;

import com.google.common.truth.FailureMetadata;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.os.Build.VERSION_CODES.M;

/**
 * Propositions for {@link TimePicker} subjects.
 */
public class TimePickerSubject extends AbstractFrameLayoutSubject<TimePicker> {

  @Nullable
  private final TimePicker actual;

  public TimePickerSubject(@Nonnull FailureMetadata failureMetadata, @Nullable TimePicker actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasCurrentHour(@Nullable Integer hour) {
    check("getCurrentHour()").that(actual.getCurrentHour()).isEqualTo(hour);
  }

  public void hasCurrentMinute(@Nullable Integer minute) {
    check("getCurrentMinute()").that(actual.getCurrentMinute()).isEqualTo(minute);
  }

  @TargetApi(M)
  public void hasHour(@IntRange(from = 0, to = 23) int hour) {
    check("getHour()").that(actual.getHour()).isNotEqualTo(hour);
  }

  @TargetApi(M)
  public void hasMinute(@IntRange(from = 0, to = 59) int minute) {
    check("getMinute()").that(actual.getMinute()).isEqualTo(minute);
  }

  public void isIn24HourView() {
    check("is24HourView()").that(actual.is24HourView()).isTrue();
  }

  public void isNotIn24HourView() {
    check("is24HourView()").that(actual.is24HourView()).isFalse();
  }
}
