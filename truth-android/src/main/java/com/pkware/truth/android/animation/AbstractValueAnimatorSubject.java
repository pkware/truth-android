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
package com.pkware.truth.android.animation;

import android.animation.ValueAnimator;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.animation.ValueAnimator.INFINITE;
import static android.animation.ValueAnimator.RESTART;
import static android.animation.ValueAnimator.REVERSE;
import static com.pkware.truth.android.internal.IntegerUtils.buildNamedValueString;

public abstract class AbstractValueAnimatorSubject<T extends ValueAnimator> extends Subject {

  @Nullable
  private final T actual;

  protected AbstractValueAnimatorSubject(@Nonnull FailureMetadata failureMetadata, @Nullable T actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  @Nonnull
  public static String repeatCountToString(int count) {
    return buildNamedValueString(count)
        .value(INFINITE, "infinite")
        .getOrValue();
  }

  @Nonnull
  public static String repeatModeToString(@ValueAnimatorRepeatMode int mode) {
    return buildNamedValueString(mode)
        .value(RESTART, "restart")
        .value(REVERSE, "reverse")
        .get();
  }

  public void hasAnimatedValue(@Nullable Object value) {
    check("getAnimatedValue()").that(actual.getAnimatedValue()).isEqualTo(value);
  }

  public void hasCurrentPlayTime(long time) {
    check("getCurrentPlayTime()").that(actual.getCurrentPlayTime()).isEqualTo(time);
  }

  public void hasRepeatCount(int count) {
    int actualCount = actual.getRepeatCount();
    check("getRepeatCount()")
        .withMessage("Expected repeat count <%s> but was <%s>.", repeatCountToString(count), repeatCountToString(actualCount))
        .that(actualCount)
        .isEqualTo(count);
  }

  public void hasRepeatMode(@ValueAnimatorRepeatMode int mode) {
    int actualMode = actual.getRepeatMode();
    //noinspection ResourceType
    check("getRepeatMode()")
        .withMessage("Expected repeat mode <%s> but was <%s>.", repeatModeToString(mode), repeatModeToString(actualMode))
        .that(actualMode)
        .isEqualTo(mode);
  }
}
