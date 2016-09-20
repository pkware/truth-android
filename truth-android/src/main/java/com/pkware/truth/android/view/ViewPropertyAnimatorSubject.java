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
package com.pkware.truth.android.view;

import android.animation.TimeInterpolator;
import android.annotation.TargetApi;
import android.view.ViewPropertyAnimator;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR2;
import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link ViewPropertyAnimator} subjects.
 */
public class ViewPropertyAnimatorSubject extends Subject<ViewPropertyAnimatorSubject, ViewPropertyAnimator> {
  protected ViewPropertyAnimatorSubject(FailureStrategy failureStrategy, ViewPropertyAnimator subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<ViewPropertyAnimatorSubject, ViewPropertyAnimator> type() {
    return new SubjectFactory<ViewPropertyAnimatorSubject, ViewPropertyAnimator>() {
      @Override
      public ViewPropertyAnimatorSubject getSubject(FailureStrategy fs, ViewPropertyAnimator that) {
        return new ViewPropertyAnimatorSubject(fs, that);
      }
    };
  }

  public ViewPropertyAnimatorSubject hasDuration(long duration) {
    assertThat(actual().getDuration())
        .named("duration")
        .isEqualTo(duration);
    return this;
  }

  @TargetApi(JELLY_BEAN_MR2)
  public ViewPropertyAnimatorSubject hasInterpolator(TimeInterpolator interpolator) {
    assertThat(actual().getInterpolator())
        .named("interpolator")
        .isEqualTo(interpolator);
    return this;
  }

  public ViewPropertyAnimatorSubject hasStartDelay(long delay) {
    assertThat(actual().getStartDelay())
        .named("start delay")
        .isEqualTo(delay);
    return this;
  }
}
