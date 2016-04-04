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

import android.annotation.TargetApi;
import android.view.ScaleGestureDetector;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.KITKAT;
import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link ScaleGestureDetector} subjects.
 */
public class ScaleGestureDetectorSubject extends Subject<ScaleGestureDetectorSubject, ScaleGestureDetector> {
  protected ScaleGestureDetectorSubject(FailureStrategy failureStrategy, ScaleGestureDetector subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<ScaleGestureDetectorSubject, ScaleGestureDetector> type() {
    return new SubjectFactory<ScaleGestureDetectorSubject, ScaleGestureDetector>() {
      @Override
      public ScaleGestureDetectorSubject getSubject(FailureStrategy fs, ScaleGestureDetector that) {
        return new ScaleGestureDetectorSubject(fs, that);
      }
    };
  }

  public ScaleGestureDetectorSubject hasCurrentSpan(float span, float tolerance) {
    assertThat(getSubject().getCurrentSpan())
        .named("current span")
        .isWithin(tolerance)
        .of(span);
    return this;
  }

  public ScaleGestureDetectorSubject hasCurrentSpanX(float span, float tolerance) {
    assertThat(getSubject().getCurrentSpanX())
        .named("current X span")
        .isWithin(tolerance)
        .of(span);
    return this;
  }

  public ScaleGestureDetectorSubject hasCurrentSpanY(float span, float tolerance) {
    assertThat(getSubject().getCurrentSpanY())
        .named("current Y span")
        .isWithin(tolerance)
        .of(span);
    return this;
  }

  public ScaleGestureDetectorSubject hasEventTime(long time) {
    assertThat(getSubject().getEventTime())
        .named("event time")
        .isEqualTo(time);
    return this;
  }

  public ScaleGestureDetectorSubject hasFocusX(float focus, float tolerance) {
    assertThat(getSubject().getFocusX())
        .named("X focus")
        .isWithin(tolerance)
        .of(focus);
    return this;
  }

  public ScaleGestureDetectorSubject hasFocusY(float focus, float tolerance) {
    assertThat(getSubject().getFocusY())
        .named("Y focus")
        .isWithin(tolerance)
        .of(focus);
    return this;
  }

  public ScaleGestureDetectorSubject hasPreviousSpan(float span, float tolerance) {
    assertThat(getSubject().getPreviousSpan())
        .named("previous span")
        .isWithin(tolerance)
        .of(span);
    return this;
  }

  public ScaleGestureDetectorSubject hasPreviousSpanX(float span, float tolerance) {
    assertThat(getSubject().getPreviousSpanX())
        .named("previous X span")
        .isWithin(tolerance)
        .of(span);
    return this;
  }

  public ScaleGestureDetectorSubject hasPreviousSpanY(float span, float tolerance) {
    assertThat(getSubject().getPreviousSpanY())
        .named("previous Y span")
        .isWithin(tolerance)
        .of(span);
    return this;
  }

  public ScaleGestureDetectorSubject hasScaleFactor(float factor, float tolerance) {
    assertThat(getSubject().getScaleFactor())
        .named("scale factor")
        .isWithin(tolerance)
        .of(factor);
    return this;
  }

  public ScaleGestureDetectorSubject hasTimeDelta(long delta) {
    assertThat(getSubject().getTimeDelta())
        .named("time delta")
        .isEqualTo(delta);
    return this;
  }

  public ScaleGestureDetectorSubject isInProgress() {
    assertThat(getSubject().isInProgress())
        .named("is in progress")
        .isTrue();
    return this;
  }

  public ScaleGestureDetectorSubject isNotInProgress() {
    assertThat(getSubject().isInProgress())
        .named("is in progress")
        .isFalse();
    return this;
  }

  @TargetApi(KITKAT)
  public ScaleGestureDetectorSubject isQuickScaleEnabled() {
    assertThat(getSubject().isQuickScaleEnabled())
        .named("is quick scale enabled")
        .isTrue();
    return this;
  }

  @TargetApi(KITKAT)
  public ScaleGestureDetectorSubject isQuickScaleDisabled() {
    assertThat(getSubject().isQuickScaleEnabled())
        .named("is quick scale enabled")
        .isFalse();
    return this;
  }
}
