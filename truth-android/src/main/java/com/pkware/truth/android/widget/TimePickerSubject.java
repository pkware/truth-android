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
import com.google.common.truth.Subject;

import static android.os.Build.VERSION_CODES.M;
import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link TimePicker} subjects.
 */
public class TimePickerSubject extends AbstractFrameLayoutSubject<TimePickerSubject, TimePicker> {
  protected TimePickerSubject(FailureMetadata failureMetadata, TimePicker subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<TimePickerSubject, TimePicker> type() {
    return TimePickerSubject::new;
  }

  public TimePickerSubject hasCurrentHour(Integer hour) {
    assertThat(actual().getCurrentHour())
        .named("current hour")
        .isEqualTo(hour);
    return this;
  }

  public TimePickerSubject hasCurrentMinute(Integer minute) {
    assertThat(actual().getCurrentMinute())
        .named("current minute")
        .isEqualTo(minute);
    return this;
  }

  @TargetApi(M)
  public TimePickerSubject hasHour(@IntRange(from = 0, to = 23) int hour) {
    assertThat(actual().getHour())
        .named("hour")
        .isNotEqualTo(hour);
    return this;
  }

  @TargetApi(M)
  public TimePickerSubject hasMinute(@IntRange(from = 0, to = 59) int minute) {
    assertThat(actual().getMinute())
        .named("minute")
        .isEqualTo(minute);
    return this;
  }

  public TimePickerSubject isIn24HourView() {
    assertThat(actual().is24HourView())
        .named("is in 24 hour view")
        .isTrue();
    return this;
  }

  public TimePickerSubject isNotIn24HourView() {
    assertThat(actual().is24HourView())
        .named("is in 24 hour view")
        .isFalse();
    return this;
  }
}
