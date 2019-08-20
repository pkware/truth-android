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

import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.widget.ProgressBar;

import com.google.common.truth.FailureMetadata;
import com.pkware.truth.android.view.AbstractViewSubject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class AbstractProgressBarSubject<T extends ProgressBar>
    extends AbstractViewSubject<T> {

  @Nullable
  private final T actual;

  protected AbstractProgressBarSubject(@Nonnull FailureMetadata failureMetadata, @Nullable T actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasIndeterminateDrawable(@Nullable Drawable drawable) {
    check("getIndeterminateDrawable()").that(actual.getIndeterminateDrawable()).isSameInstanceAs(drawable);
  }

  public void hasInterpolator(@Nullable Interpolator interpolator) {
    check("getInterpolator()").that(actual.getInterpolator()).isSameInstanceAs(interpolator);
  }

  public void hasMaximum(int maximum) {
    check("getMax()").that(actual.getMax()).isEqualTo(maximum);
  }

  public void hasProgress(int progress) {
    check("getProgress()").that(actual.getProgress()).isEqualTo(progress);
  }

  public void hasProgressDrawable(@Nullable Drawable drawable) {
    check("getProgressDrawable()").that(actual.getProgressDrawable()).isSameInstanceAs(drawable);
  }

  public void hasSecondaryProgress(int progress) {
    check("getSecondaryProgress()").that(actual.getSecondaryProgress()).isEqualTo(progress);
  }

  public void isIndeterminate() {
    check("isIndeterminate()").that(actual.isIndeterminate()).isTrue();
  }

  public void isNotIndeterminate() {
    check("isIndeterminate()").that(actual.isIndeterminate()).isFalse();
  }
}
