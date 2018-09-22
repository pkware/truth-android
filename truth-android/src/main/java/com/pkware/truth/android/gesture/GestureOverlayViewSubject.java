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

import static android.gesture.GestureOverlayView.GESTURE_STROKE_TYPE_MULTIPLE;
import static android.gesture.GestureOverlayView.GESTURE_STROKE_TYPE_SINGLE;
import static android.gesture.GestureOverlayView.ORIENTATION_HORIZONTAL;
import static android.gesture.GestureOverlayView.ORIENTATION_VERTICAL;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assert_;
import static com.pkware.truth.android.internal.IntegerUtils.buildNamedValueString;

/**
 * Propositions for {@link GestureOverlayView} subjects.
 */
public class GestureOverlayViewSubject extends Subject<GestureOverlayViewSubject, GestureOverlayView> {
  protected GestureOverlayViewSubject(FailureMetadata failureMetadata, GestureOverlayView subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<GestureOverlayViewSubject, GestureOverlayView> type() {
    return new Subject.Factory<GestureOverlayViewSubject, GestureOverlayView>() {
      @Override
      public GestureOverlayViewSubject createSubject(FailureMetadata fm, GestureOverlayView that) {
        return new GestureOverlayViewSubject(fm, that);
      }
    };
  }

  public static String gestureStrokeTypeToString(@GestureOverlayViewGestureStrokeType int type) {
    return buildNamedValueString(type)
        .value(GESTURE_STROKE_TYPE_SINGLE, "single")
        .value(GESTURE_STROKE_TYPE_MULTIPLE, "multiple")
        .get();
  }

  public static String orientationToString(@GestureOverlayViewOrientation int orientation) {
    return buildNamedValueString(orientation)
        .value(ORIENTATION_HORIZONTAL, "horizontal")
        .value(ORIENTATION_VERTICAL, "vertical")
        .get();
  }

  public GestureOverlayViewSubject hasFadeOffset(long offset) {
    assertThat(actual().getFadeOffset())
        .named("fade offset")
        .isEqualTo(offset);
    return this;
  }

  public GestureOverlayViewSubject hasGestureColor(int color) {
    int actualColor = actual().getGestureColor();
    assert_()
        .withMessage("Expected gesture color <%s> but was <%s>.", Integer.toHexString(color), Integer.toHexString(actualColor))
        .that(actualColor)
        .isEqualTo(color);
    return this;
  }

  public GestureOverlayViewSubject hasGestureStrokeAngleThreshold(float threshold, float tolerance) {
    assertThat(actual().getGestureStrokeAngleThreshold())
        .named("gesture stroke angle threshold")
        .isWithin(tolerance)
        .of(threshold);
    return this;
  }

  public GestureOverlayViewSubject hasGestureStrokeLengthThreshold(float threshold, float tolerance) {
    assertThat(actual().getGestureStrokeLengthThreshold())
        .named("gesture stroke length threshold")
        .isWithin(tolerance)
        .of(threshold);
    return this;
  }

  public GestureOverlayViewSubject hasGestureStrokeSquarenessThreshold(float threshold, float tolerance) {
    assertThat(actual().getGestureStrokeSquarenessTreshold())
        .named("gesture stroke squareness threshold")
        .isWithin(tolerance)
        .of(threshold);
    return this;
  }

  public GestureOverlayViewSubject hasGestureStokeType(@GestureOverlayViewGestureStrokeType int type) {
    int actualType = actual().getGestureStrokeType();
    //noinspection ResourceType
    assert_()
        .withMessage("Expected gesture stroke type <%s> but was <%s>.", gestureStrokeTypeToString(type), gestureStrokeTypeToString(actualType))
        .that(actualType)
        .isEqualTo(type);
    return this;
  }

  public GestureOverlayViewSubject hasGestureStrokeWidth(float width, float tolerance) {
    assertThat(actual().getGestureStrokeWidth())
        .named("gesture stroke width")
        .isWithin(tolerance)
        .of(width);
    return this;
  }

  public GestureOverlayViewSubject hasOrientation(@GestureOverlayViewOrientation int orientation) {
    int actualOrientation = actual().getOrientation();
    //noinspection ResourceType
    assert_()
        .withMessage("Expected orientation <%s> but was <%s>.", orientationToString(orientation), orientationToString(actualOrientation))
        .that(actualOrientation)
        .isEqualTo(orientation);
    return this;
  }

  public GestureOverlayViewSubject hasUncertainGestureColor(int color) {
    int actualColor = actual().getUncertainGestureColor();
    assert_()
        .withMessage("Expected uncertain gesture color <%s> but was <%s>.", Integer.toHexString(color), Integer.toHexString(actualColor))
        .that(actualColor)
        .isEqualTo(color);
    return this;
  }

  public GestureOverlayViewSubject isInterceptingEvents() {
    assertThat(actual().isEventsInterceptionEnabled())
        .named("events intercepting is enabled")
        .isTrue();
    return this;
  }

  public GestureOverlayViewSubject isNotInterceptingEvents() {
    assertThat(actual().isEventsInterceptionEnabled())
        .named("events intercepting is enabled")
        .isFalse();
    return this;
  }

  public GestureOverlayViewSubject isFadeEnabled() {
    assertThat(actual().isFadeEnabled())
        .named("fade is enabled")
        .isTrue();
    return this;
  }

  public GestureOverlayViewSubject isFadeDisabled() {
    assertThat(actual().isFadeEnabled())
        .named("fade is enabled")
        .isFalse();
    return this;
  }

  public GestureOverlayViewSubject isGestureVisible() {
    assertThat(actual().isGestureVisible())
        .named("gesture is visible")
        .isTrue();
    return this;
  }

  public GestureOverlayViewSubject isGestureNotVisible() {
    assertThat(actual().isGestureVisible())
        .named("gesture is visible")
        .isFalse();
    return this;
  }

  public GestureOverlayViewSubject isGesturing() {
    assertThat(actual().isGesturing())
        .named("is gesturing")
        .isTrue();
    return this;
  }

  public GestureOverlayViewSubject isNotGesturing() {
    assertThat(actual().isGesturing())
        .named("is gesturing")
        .isFalse();
    return this;
  }
}
