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

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;

import static android.os.Build.VERSION_CODES.KITKAT;
import static com.google.common.truth.Truth.assertThat;

public abstract class AbstractAnimatorSubject<S extends AbstractAnimatorSubject<S, T>, T extends Animator> extends Subject<S, T> {
  protected AbstractAnimatorSubject(FailureStrategy failureStrategy, T subject) {
    super(failureStrategy, subject);
  }

  public S hasDuration(long duration) {
    assertThat(actual().getDuration())
        .named("duration")
        .isEqualTo(duration);
    //noinspection unchecked
    return (S) this;
  }

  public S hasListener(Animator.AnimatorListener listener) {
    assertThat(actual().getListeners())
        .named("listeners")
        .contains(listener);
    //noinspection unchecked
    return (S) this;
  }

  public S hasStartDelay(long delay) {
    assertThat(actual().getStartDelay())
        .named("start delay")
        .isEqualTo(delay);
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(KITKAT)
  public S isPaused() {
    assertThat(actual().isPaused())
        .named("is paused")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(KITKAT)
  public S isNotPaused() {
    assertThat(actual().isPaused())
        .named("is paused")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S isRunning() {
    assertThat(actual().isRunning())
        .named("is running")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotRunning() {
    assertThat(actual().isRunning())
        .named("is running")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S isStarted() {
    assertThat(actual().isStarted())
        .named("is started")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotStarted() {
    assertThat(actual().isStarted())
        .named("is started")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }
}
