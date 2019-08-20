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

import android.annotation.TargetApi;
import android.view.ScaleGestureDetector;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.os.Build.VERSION_CODES.KITKAT;

/**
 * Propositions for {@link ScaleGestureDetector} subjects.
 */
public class ScaleGestureDetectorSubject extends Subject {

  @Nullable
  private final ScaleGestureDetector actual;

  public ScaleGestureDetectorSubject(@Nonnull FailureMetadata failureMetadata, @Nullable ScaleGestureDetector actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public ScaleGestureDetectorSubject hasCurrentSpan(float span, float tolerance) {
    check("getCurrentSpan()").that(actual.getCurrentSpan()).isWithin(tolerance).of(span);
    return this;
  }

  public ScaleGestureDetectorSubject hasCurrentSpanX(float span, float tolerance) {
    check("getCurrentSpanX()").that(actual.getCurrentSpanX()).isWithin(tolerance).of(span);
    return this;
  }

  public ScaleGestureDetectorSubject hasCurrentSpanY(float span, float tolerance) {
    check("getCurrentSpanY()").that(actual.getCurrentSpanY()).isWithin(tolerance).of(span);
    return this;
  }

  public ScaleGestureDetectorSubject hasEventTime(long time) {
    check("getEventTime()").that(actual.getEventTime()).isEqualTo(time);
    return this;
  }

  public ScaleGestureDetectorSubject hasFocusX(float focus, float tolerance) {
    check("getFocusX()").that(actual.getFocusX()).isWithin(tolerance).of(focus);
    return this;
  }

  public ScaleGestureDetectorSubject hasFocusY(float focus, float tolerance) {
    check("getFocusY()").that(actual.getFocusY()).isWithin(tolerance).of(focus);
    return this;
  }

  public ScaleGestureDetectorSubject hasPreviousSpan(float span, float tolerance) {
    check("getPreviousSpan()").that(actual.getPreviousSpan()).isWithin(tolerance).of(span);
    return this;
  }

  public ScaleGestureDetectorSubject hasPreviousSpanX(float span, float tolerance) {
    check("getPreviousSpanX()").that(actual.getPreviousSpanX()).isWithin(tolerance).of(span);
    return this;
  }

  public ScaleGestureDetectorSubject hasPreviousSpanY(float span, float tolerance) {
    check("getPreviousSpanY()").that(actual.getPreviousSpanY()).isWithin(tolerance).of(span);
    return this;
  }

  public ScaleGestureDetectorSubject hasScaleFactor(float factor, float tolerance) {
    check("getScaleFactor()").that(actual.getScaleFactor()).isWithin(tolerance).of(factor);
    return this;
  }

  public ScaleGestureDetectorSubject hasTimeDelta(long delta) {
    check("getTimeDelta()").that(actual.getTimeDelta()).isEqualTo(delta);
    return this;
  }

  public ScaleGestureDetectorSubject isInProgress() {
    check("isInProgress()").that(actual.isInProgress()).isTrue();
    return this;
  }

  public ScaleGestureDetectorSubject isNotInProgress() {
    check("isInProgress()").that(actual.isInProgress()).isFalse();
    return this;
  }

  @TargetApi(KITKAT)
  public ScaleGestureDetectorSubject isQuickScaleEnabled() {
    check("isQuickScaleEnabled()").that(actual.isQuickScaleEnabled()).isTrue();
    return this;
  }

  @TargetApi(KITKAT)
  public ScaleGestureDetectorSubject isQuickScaleDisabled() {
    check("isQuickScaleEnabled()").that(actual.isQuickScaleEnabled()).isFalse();
    return this;
  }
}
