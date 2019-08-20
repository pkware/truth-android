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
import android.view.animation.LayoutAnimationController;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class AbstractLayoutAnimationControllerSubject<T extends LayoutAnimationController> extends Subject {

  @Nullable
  private final T actual;

  protected AbstractLayoutAnimationControllerSubject(@Nonnull FailureMetadata failureMetadata, @Nullable T actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasAnimation(@Nullable Animation animation) {
    check("getAnimation()").that(actual.getAnimation()).isSameInstanceAs(animation);
  }

  public void hasDelay(float delay, float tolerance) {
    check("getDelay()").that(actual.getDelay()).isWithin(tolerance).of(delay);
  }

  public void hasInterpolator(@Nullable Interpolator interpolator) {
    check("getInterpolator()").that(actual.getInterpolator()).isSameInstanceAs(interpolator);
  }

  public void hasOrder(int order) {
    check("getOrder()").that(actual.getOrder()).isEqualTo(order);
  }

  public void isDone() {
    check("isDone()").that(actual.isDone()).isTrue();
  }

  public void isNotDone() {
    check("isDone()").that(actual.isDone()).isFalse();
  }

  public void isOverlapping() {
    check("willOverlap()").that(actual.willOverlap()).isTrue();
  }

  public void isNotOverlapping() {
    check("willOverlap()").that(actual.willOverlap()).isFalse();
  }
}
