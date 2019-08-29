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
package com.pkware.truth.android.view;

import android.animation.TimeInterpolator;
import android.annotation.TargetApi;
import android.view.ViewPropertyAnimator;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR2;

/**
 * Propositions for {@link ViewPropertyAnimator} subjects.
 */
public class ViewPropertyAnimatorSubject extends Subject {

  @Nullable
  private final ViewPropertyAnimator actual;

  public ViewPropertyAnimatorSubject(@Nonnull FailureMetadata failureMetadata, @Nullable ViewPropertyAnimator actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasDuration(long duration) {
    check("getDuration()").that(actual.getDuration()).isEqualTo(duration);
  }

  @TargetApi(JELLY_BEAN_MR2)
  public void hasInterpolator(@Nullable TimeInterpolator interpolator) {
    check("getInterpolator()").that(actual.getInterpolator()).isEqualTo(interpolator);
  }

  public void hasStartDelay(long delay) {
    check("getStartDelay()").that(actual.getStartDelay()).isEqualTo(delay);
  }
}
