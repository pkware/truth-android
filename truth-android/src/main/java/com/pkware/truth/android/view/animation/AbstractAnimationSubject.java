/*
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
package com.pkware.truth.android.view.animation;

import android.view.animation.Animation;
import android.view.animation.Interpolator;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;

import static android.view.animation.Animation.INFINITE;
import static android.view.animation.Animation.RESTART;
import static android.view.animation.Animation.REVERSE;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assert_;
import static com.pkware.truth.android.internal.IntegerUtils.buildNamedValueString;

public abstract class AbstractAnimationSubject<S extends AbstractAnimationSubject<S, T>, T extends Animation>
    extends Subject<S, T> {
  protected AbstractAnimationSubject(FailureStrategy failureStrategy, T subject) {
    super(failureStrategy, subject);
  }

  public static String repeatCountToString(int count) {
    return buildNamedValueString(count)
        .value(INFINITE, "infinite")
        .getOrValue();
  }

  public static String repeatModeToString(@AnimationRepeatMode int mode) {
    return buildNamedValueString(mode)
        .value(RESTART, "restart")
        .value(REVERSE, "reverse")
        .get();
  }

  public S hasBackgroundColor(int color) {
    int actualColor = getSubject().getBackgroundColor();
    assert_()
        .withFailureMessage("Expected background color <%s> but was <%s>.",
            Integer.toHexString(color), Integer.toHexString(actualColor))
        .that(actualColor)
        .isEqualTo(color);
    //noinspection unchecked
    return (S) this;
  }

  public S hasDuration(long duration) {
    long actualDuration = getSubject().getDuration();
    assertThat(getSubject().getDuration())
        .named("duration")
        .isEqualTo(duration);
    //noinspection unchecked
    return (S) this;
  }

  public S isFillingAfter() {
    assertThat(getSubject().getFillAfter())
        .named("is filling after")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotFillingAfter() {
    assertThat(getSubject().getFillAfter())
        .named("is filling after")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S isFillingBefore() {
    assertThat(getSubject().getFillBefore())
        .named("is filling before")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotFillingBefore() {
    assertThat(getSubject().getFillBefore())
        .named("is filling before")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S hasInterpolator(Interpolator interpolator) {
    assertThat(getSubject().getInterpolator())
        .named("interpolator")
        .isSameAs(interpolator);
    //noinspection unchecked
    return (S) this;
  }

  public S hasRepeatCount(int count) {
    int actualCount = getSubject().getRepeatCount();
    assert_()
        .withFailureMessage("Expected repeat count <%s> but was <%s>.",
            repeatCountToString(count), repeatCountToString(actualCount))
        .that(actualCount)
        .isEqualTo(count);
    //noinspection unchecked
    return (S) this;
  }

  public S hasRepeatMode(@AnimationRepeatMode int mode) {
    int actualMode = getSubject().getRepeatMode();
    //noinspection ResourceType
    assert_()
        .withFailureMessage("Expected repeat mode <%s> but was <%s>.", repeatModeToString(mode),
            repeatModeToString(actualMode))
        .that(actualMode)
        .isEqualTo(mode);
    //noinspection unchecked
    return (S) this;
  }

  public S hasStartOffset(long offset) {
    assertThat(getSubject().getStartOffset())
        .named("start offset")
        .isEqualTo(offset);
    //noinspection unchecked
    return (S) this;
  }

  public S hasStartTime(long time) {
    assertThat(getSubject().getStartTime())
        .named("start time")
        .isEqualTo(time);
    //noinspection unchecked
    return (S) this;
  }

  public S hasZAdjustment(int adjustment) {
    assertThat(getSubject().getZAdjustment())
        .named("Z adjustment")
        .isEqualTo(adjustment);
    //noinspection unchecked
    return (S) this;
  }

  public S isEnded() {
    assertThat(getSubject().hasEnded())
        .named("has ended")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotEnded() {
    assertThat(getSubject().hasEnded())
        .named("has ended")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S isStarted() {
    assertThat(getSubject().hasStarted())
        .named("has started")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotStarted() {
    assertThat(getSubject().hasStarted())
        .named("has started")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S isFillEnabled() {
    assertThat(getSubject().isFillEnabled())
        .named("is fill enabled")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isFillDisabled() {
    assertThat(!getSubject().isFillEnabled())
        .named("is fill disabled")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isInitialized() {
    assertThat(getSubject().isInitialized())
        .named("is initialized")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotInitialized() {
    assertThat(getSubject().isInitialized())
        .named("is initialized")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S isChangingBounds() {
    assertThat(getSubject().willChangeBounds())
        .named("is changing bounds")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotChangingBounds() {
    assertThat(getSubject().willChangeBounds())
        .named("is changing bounds")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S isChangingTransformationMatrix() {
    assertThat(getSubject().willChangeTransformationMatrix())
        .named("is changing transformation matrix")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotChangingTransformationMatrix() {
    assertThat(getSubject().willChangeTransformationMatrix())
        .named("is changing transformation matrix")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }
}
