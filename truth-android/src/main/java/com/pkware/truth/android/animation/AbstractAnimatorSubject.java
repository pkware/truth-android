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

import android.animation.Animator;
import android.annotation.TargetApi;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.os.Build.VERSION_CODES.KITKAT;

public abstract class AbstractAnimatorSubject<T extends Animator> extends Subject {

  @Nullable
  private final T actual;

  protected AbstractAnimatorSubject(@Nonnull FailureMetadata failureMetadata, @Nullable T actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasDuration(long duration) {
    check("getDuration()").that(actual.getDuration()).isEqualTo(duration);
  }

  public void hasListener(@Nonnull Animator.AnimatorListener listener) {
    check("getListeners()").that(actual.getListeners()).contains(listener);
  }

  public void hasStartDelay(long delay) {
    check("getStartDelay()").that(actual.getStartDelay()).isEqualTo(delay);
  }

  @TargetApi(KITKAT)
  public void isPaused() {
    check("isPaused()").that(actual.isPaused()).isTrue();
  }

  @TargetApi(KITKAT)
  public void isNotPaused() {
    check("isPaused()").that(actual.isPaused()).isFalse();
  }

  public void isRunning() {
    check("isRunning()").that(actual.isRunning()).isTrue();
  }

  public void isNotRunning() {
    check("isRunning()").that(actual.isRunning()).isFalse();
  }

  public void isStarted() {
    check("isStarted()").that(actual.isStarted()).isTrue();
  }

  public void isNotStarted() {
    check("isStarted()").that(actual.isStarted()).isFalse();
  }
}
