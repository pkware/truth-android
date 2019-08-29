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

  public void hasCurrentSpan(float span, float tolerance) {
    check("getCurrentSpan()").that(actual.getCurrentSpan()).isWithin(tolerance).of(span);
  }

  public void hasCurrentSpanX(float span, float tolerance) {
    check("getCurrentSpanX()").that(actual.getCurrentSpanX()).isWithin(tolerance).of(span);
  }

  public void hasCurrentSpanY(float span, float tolerance) {
    check("getCurrentSpanY()").that(actual.getCurrentSpanY()).isWithin(tolerance).of(span);
  }

  public void hasEventTime(long time) {
    check("getEventTime()").that(actual.getEventTime()).isEqualTo(time);
  }

  public void hasFocusX(float focus, float tolerance) {
    check("getFocusX()").that(actual.getFocusX()).isWithin(tolerance).of(focus);
  }

  public void hasFocusY(float focus, float tolerance) {
    check("getFocusY()").that(actual.getFocusY()).isWithin(tolerance).of(focus);
  }

  public void hasPreviousSpan(float span, float tolerance) {
    check("getPreviousSpan()").that(actual.getPreviousSpan()).isWithin(tolerance).of(span);
  }

  public void hasPreviousSpanX(float span, float tolerance) {
    check("getPreviousSpanX()").that(actual.getPreviousSpanX()).isWithin(tolerance).of(span);
  }

  public void hasPreviousSpanY(float span, float tolerance) {
    check("getPreviousSpanY()").that(actual.getPreviousSpanY()).isWithin(tolerance).of(span);
  }

  public void hasScaleFactor(float factor, float tolerance) {
    check("getScaleFactor()").that(actual.getScaleFactor()).isWithin(tolerance).of(factor);
  }

  public void hasTimeDelta(long delta) {
    check("getTimeDelta()").that(actual.getTimeDelta()).isEqualTo(delta);
  }

  public void isInProgress() {
    check("isInProgress()").that(actual.isInProgress()).isTrue();
  }

  public void isNotInProgress() {
    check("isInProgress()").that(actual.isInProgress()).isFalse();
  }

  @TargetApi(KITKAT)
  public void isQuickScaleEnabled() {
    check("isQuickScaleEnabled()").that(actual.isQuickScaleEnabled()).isTrue();
  }

  @TargetApi(KITKAT)
  public void isQuickScaleDisabled() {
    check("isQuickScaleEnabled()").that(actual.isQuickScaleEnabled()).isFalse();
  }
}
