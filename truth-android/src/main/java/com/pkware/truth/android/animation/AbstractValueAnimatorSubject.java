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

import static android.animation.ValueAnimator.INFINITE;
import static android.animation.ValueAnimator.RESTART;
import static android.animation.ValueAnimator.REVERSE;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assert_;
import static com.pkware.truth.android.internal.IntegerUtils.buildNamedValueString;

public abstract class AbstractValueAnimatorSubject<S extends AbstractValueAnimatorSubject<S, T>, T extends ValueAnimator> extends Subject<S, T> {
  protected AbstractValueAnimatorSubject(FailureMetadata failureMetadata, T subject) {
    super(failureMetadata, subject);
  }

  public static String repeatCountToString(int count) {
    return buildNamedValueString(count)
        .value(INFINITE, "infinite")
        .getOrValue();
  }

  public static String repeatModeToString(@ValueAnimatorRepeatMode int mode) {
    return buildNamedValueString(mode)
        .value(RESTART, "restart")
        .value(REVERSE, "reverse")
        .get();
  }

  public S hasAnimatedValue(Object value) {
    assertThat(actual().getAnimatedValue())
        .named("animated value")
        .isEqualTo(value);
    //noinspection unchecked
    return (S) this;
  }

  public S hasCurrentPlayTime(long time) {
    assertThat(actual().getCurrentPlayTime())
        .named("current play time")
        .isEqualTo(time);
    //noinspection unchecked
    return (S) this;
  }

  public S hasRepeatCount(int count) {
    int actualCount = actual().getRepeatCount();
    assert_()
        .withMessage("Expected repeat count <%s> but was <%s>.", repeatCountToString(count), repeatCountToString(actualCount))
        .that(actualCount)
        .isEqualTo(count);
    //noinspection unchecked
    return (S) this;
  }

  public S hasRepeatMode(@ValueAnimatorRepeatMode int mode) {
    int actualMode = actual().getRepeatMode();
    //noinspection ResourceType
    assert_()
        .withMessage("Expected repeat mode <%s> but was <%s>.", repeatModeToString(mode), repeatModeToString(actualMode))
        .that(actualMode)
        .isEqualTo(mode);
    //noinspection unchecked
    return (S) this;
  }
}
