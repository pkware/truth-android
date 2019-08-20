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
package com.pkware.truth.android.view.animation;

import android.view.animation.Animation;
import android.view.animation.Interpolator;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.view.animation.Animation.INFINITE;
import static android.view.animation.Animation.RESTART;
import static android.view.animation.Animation.REVERSE;
import static com.pkware.truth.android.internal.IntegerUtils.buildNamedValueString;

public abstract class AbstractAnimationSubject<T extends Animation> extends Subject {

  @Nullable
  private final T actual;

  protected AbstractAnimationSubject(@Nonnull FailureMetadata failureMetadata, @Nullable T actual) {
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
  public static String repeatModeToString(@AnimationRepeatMode int mode) {
    return buildNamedValueString(mode)
        .value(RESTART, "restart")
        .value(REVERSE, "reverse")
        .get();
  }

  public void hasBackgroundColor(int color) {
    int actualColor = actual.getBackgroundColor();
    check("getBackgroundColor()")
        .withMessage("Expected background color <%s> but was <%s>.",
            Integer.toHexString(color), Integer.toHexString(actualColor))
        .that(actualColor)
        .isEqualTo(color);
  }

  public void hasDuration(long duration) {
    check("getDuration()").that(actual.getDuration()).isEqualTo(duration);
  }

  public void isFillingAfter() {
    check("getFillAfter()").that(actual.getFillAfter()).isTrue();
  }

  public void isNotFillingAfter() {
    check("getFillAfter()").that(actual.getFillAfter()).isFalse();
  }

  public void isFillingBefore() {
    check("getFillBefore()").that(actual.getFillBefore()).isTrue();
  }

  public void isNotFillingBefore() {
    check("getFillBefore()").that(actual.getFillBefore()).isFalse();
  }

  public void hasInterpolator(@Nullable Interpolator interpolator) {
    check("getInterpolator()").that(actual.getInterpolator()).isSameInstanceAs(interpolator);
  }

  public void hasRepeatCount(int count) {
    int actualCount = actual.getRepeatCount();
    check("getRepeatCount()")
        .withMessage("Expected repeat count <%s> but was <%s>.",
            repeatCountToString(count), repeatCountToString(actualCount))
        .that(actualCount)
        .isEqualTo(count);
  }

  public void hasRepeatMode(@AnimationRepeatMode int mode) {
    int actualMode = actual.getRepeatMode();
    //noinspection ResourceType
    check("getRepeatMode()")
        .withMessage("Expected repeat mode <%s> but was <%s>.", repeatModeToString(mode),
            repeatModeToString(actualMode))
        .that(actualMode)
        .isEqualTo(mode);
  }

  public void hasStartOffset(long offset) {
    check("getStartOffset()").that(actual.getStartOffset()).isEqualTo(offset);
  }

  public void hasStartTime(long time) {
    check("getStartTime()").that(actual.getStartTime()).isEqualTo(time);
  }

  public void hasZAdjustment(int adjustment) {
    check("getZAdjustment()").that(actual.getZAdjustment()).isEqualTo(adjustment);
  }

  public void isEnded() {
    check("hasEnded()").that(actual.hasEnded()).isTrue();
  }

  public void isNotEnded() {
    check("hasEnded()").that(actual.hasEnded()).isFalse();
  }

  public void isStarted() {
    check("hasStarted()").that(actual.hasStarted()).isTrue();
  }

  public void isNotStarted() {
    check("hasStarted()").that(actual.hasStarted()).isFalse();
  }

  public void isFillEnabled() {
    check("isFillEnabled()").that(actual.isFillEnabled()).isTrue();
  }

  public void isFillDisabled() {
    check("isFillEnabled()").that(actual.isFillEnabled()).isFalse();
  }

  public void isInitialized() {
    check("isInitialized()").that(actual.isInitialized()).isTrue();
  }

  public void isNotInitialized() {
    check("isInitialized()").that(actual.isInitialized()).isFalse();
  }

  public void isChangingBounds() {
    check("willChangeBounds()").that(actual.willChangeBounds()).isTrue();
  }

  public void isNotChangingBounds() {
    check("willChangeBounds()").that(actual.willChangeBounds()).isFalse();
  }

  public void isChangingTransformationMatrix() {
    check("willChangeTransformationMatrix()").that(actual.willChangeTransformationMatrix()).isTrue();
  }

  public void isNotChangingTransformationMatrix() {
    check("willChangeTransformationMatrix()").that(actual.willChangeTransformationMatrix()).isFalse();
  }
}
