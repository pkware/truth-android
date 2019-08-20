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
package com.pkware.truth.android.gesture;

import android.gesture.GestureOverlayView;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.gesture.GestureOverlayView.GESTURE_STROKE_TYPE_MULTIPLE;
import static android.gesture.GestureOverlayView.GESTURE_STROKE_TYPE_SINGLE;
import static android.gesture.GestureOverlayView.ORIENTATION_HORIZONTAL;
import static android.gesture.GestureOverlayView.ORIENTATION_VERTICAL;
import static com.pkware.truth.android.internal.IntegerUtils.buildNamedValueString;

/**
 * Propositions for {@link GestureOverlayView} subjects.
 */
public class GestureOverlayViewSubject extends Subject {

  @Nullable
  private final GestureOverlayView actual;

  public GestureOverlayViewSubject(@Nonnull FailureMetadata failureMetadata, @Nullable GestureOverlayView actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  @Nonnull
  public static String gestureStrokeTypeToString(@GestureOverlayViewGestureStrokeType int type) {
    return buildNamedValueString(type)
        .value(GESTURE_STROKE_TYPE_SINGLE, "single")
        .value(GESTURE_STROKE_TYPE_MULTIPLE, "multiple")
        .get();
  }

  @Nonnull
  public static String orientationToString(@GestureOverlayViewOrientation int orientation) {
    return buildNamedValueString(orientation)
        .value(ORIENTATION_HORIZONTAL, "horizontal")
        .value(ORIENTATION_VERTICAL, "vertical")
        .get();
  }

  public GestureOverlayViewSubject hasFadeOffset(long offset) {
    check("getFadeOffset()").that(actual.getFadeOffset()).isEqualTo(offset);
    return this;
  }

  public GestureOverlayViewSubject hasGestureColor(int color) {
    int actualColor = actual.getGestureColor();
    check("getGestureColor()")
        .withMessage("Expected gesture color <%s> but was <%s>.", Integer.toHexString(color), Integer.toHexString(actualColor))
        .that(actualColor)
        .isEqualTo(color);
    return this;
  }

  public GestureOverlayViewSubject hasGestureStrokeAngleThreshold(float threshold, float tolerance) {
    check("getGestureStrokeAngleThreshold()").that(actual.getGestureStrokeAngleThreshold()).isWithin(tolerance)
        .of(threshold);
    return this;
  }

  public GestureOverlayViewSubject hasGestureStrokeLengthThreshold(float threshold, float tolerance) {
    check("getGestureStrokeLengthThreshold()").that(actual.getGestureStrokeLengthThreshold()).isWithin(tolerance)
        .of(threshold);
    return this;
  }

  public GestureOverlayViewSubject hasGestureStrokeSquarenessThreshold(float threshold, float tolerance) {
    check("getGestureStrokeSquarenessTreshold()").that(actual.getGestureStrokeSquarenessTreshold()).isWithin(tolerance)
        .of(threshold);
    return this;
  }

  public GestureOverlayViewSubject hasGestureStokeType(@GestureOverlayViewGestureStrokeType int type) {
    int actualType = actual.getGestureStrokeType();
    //noinspection ResourceType
    check("getGestureStrokeType()")
        .withMessage("Expected gesture stroke type <%s> but was <%s>.", gestureStrokeTypeToString(type), gestureStrokeTypeToString(actualType))
        .that(actualType)
        .isEqualTo(type);
    return this;
  }

  public GestureOverlayViewSubject hasGestureStrokeWidth(float width, float tolerance) {
    check("getGestureStrokeWidth()").that(actual.getGestureStrokeWidth()).isWithin(tolerance)
        .of(width);
    return this;
  }

  public GestureOverlayViewSubject hasOrientation(@GestureOverlayViewOrientation int orientation) {
    int actualOrientation = actual.getOrientation();
    //noinspection ResourceType
    check("getOrientation()")
        .withMessage("Expected orientation <%s> but was <%s>.", orientationToString(orientation), orientationToString(actualOrientation))
        .that(actualOrientation)
        .isEqualTo(orientation);
    return this;
  }

  public GestureOverlayViewSubject hasUncertainGestureColor(int color) {
    int actualColor = actual.getUncertainGestureColor();
    check("getUncertainGestureColor()")
        .withMessage("Expected uncertain gesture color <%s> but was <%s>.", Integer.toHexString(color), Integer.toHexString(actualColor))
        .that(actualColor)
        .isEqualTo(color);
    return this;
  }

  public GestureOverlayViewSubject isInterceptingEvents() {
    check("isEventsInterceptionEnabled()").that(actual.isEventsInterceptionEnabled()).isTrue();
    return this;
  }

  public GestureOverlayViewSubject isNotInterceptingEvents() {
    check("isEventsInterceptionEnabled()").that(actual.isEventsInterceptionEnabled()).isFalse();
    return this;
  }

  public GestureOverlayViewSubject isFadeEnabled() {
    check("isFadeEnabled()").that(actual.isFadeEnabled()).isTrue();
    return this;
  }

  public GestureOverlayViewSubject isFadeDisabled() {
    check("isFadeEnabled()").that(actual.isFadeEnabled()).isFalse();
    return this;
  }

  public GestureOverlayViewSubject isGestureVisible() {
    check("isGestureVisible()").that(actual.isGestureVisible()).isTrue();
    return this;
  }

  public GestureOverlayViewSubject isGestureNotVisible() {
    check("isGestureVisible()").that(actual.isGestureVisible()).isFalse();
    return this;
  }

  public GestureOverlayViewSubject isGesturing() {
    check("isGesturing()").that(actual.isGesturing()).isTrue();
    return this;
  }

  public GestureOverlayViewSubject isNotGesturing() {
    check("isGesturing()").that(actual.isGesturing()).isFalse();
    return this;
  }
}
