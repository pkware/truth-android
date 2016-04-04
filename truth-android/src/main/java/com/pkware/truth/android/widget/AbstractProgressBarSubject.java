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
package com.pkware.truth.android.widget;

import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.widget.ProgressBar;

import com.google.common.truth.FailureStrategy;
import com.pkware.truth.android.view.AbstractViewSubject;

import static com.google.common.truth.Truth.assertThat;

public abstract class AbstractProgressBarSubject<S extends AbstractProgressBarSubject<S, T>, T extends ProgressBar>
    extends AbstractViewSubject<S, T> {
  protected AbstractProgressBarSubject(FailureStrategy failureStrategy, T subject) {
    super(failureStrategy, subject);
  }

  public S hasIndeterminateDrawable(Drawable drawable) {
    assertThat(getSubject().getIndeterminateDrawable())
        .named("indeterminate drawable")
        .isSameAs(drawable);
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

  public S hasMaximum(int maximum) {
    assertThat(getSubject().getMax())
        .named("maximum")
        .isEqualTo(maximum);
    //noinspection unchecked
    return (S) this;
  }

  public S hasProgress(int progress) {
    assertThat(getSubject().getProgress())
        .named("progress")
        .isEqualTo(progress);
    //noinspection unchecked
    return (S) this;
  }

  public S hasProgressDrawable(Drawable drawable) {
    assertThat(getSubject().getProgressDrawable())
        .named("progress drawable")
        .isSameAs(drawable);
    //noinspection unchecked
    return (S) this;
  }

  public S hasSecondaryProgress(int progress) {
    assertThat(getSubject().getSecondaryProgress())
        .named("secondary progress")
        .isEqualTo(progress);
    //noinspection unchecked
    return (S) this;
  }

  public S isIndeterminate() {
    assertThat(getSubject().isIndeterminate())
        .named("is indeterminate")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotIndeterminate() {
    assertThat(getSubject().isIndeterminate())
        .named("is indeterminate")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }
}
