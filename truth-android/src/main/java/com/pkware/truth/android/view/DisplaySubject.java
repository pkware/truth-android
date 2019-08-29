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
import android.graphics.Point;
import android.view.Display;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.graphics.PixelFormat.A_8;
import static android.graphics.PixelFormat.JPEG;
import static android.graphics.PixelFormat.LA_88;
import static android.graphics.PixelFormat.L_8;
import static android.graphics.PixelFormat.OPAQUE;
import static android.graphics.PixelFormat.RGBA_4444;
import static android.graphics.PixelFormat.RGBA_5551;
import static android.graphics.PixelFormat.RGBA_8888;
import static android.graphics.PixelFormat.RGBX_8888;
import static android.graphics.PixelFormat.RGB_332;
import static android.graphics.PixelFormat.RGB_565;
import static android.graphics.PixelFormat.RGB_888;
import static android.graphics.PixelFormat.TRANSLUCENT;
import static android.graphics.PixelFormat.TRANSPARENT;
import static android.graphics.PixelFormat.UNKNOWN;
import static android.graphics.PixelFormat.YCbCr_420_SP;
import static android.graphics.PixelFormat.YCbCr_422_I;
import static android.graphics.PixelFormat.YCbCr_422_SP;
import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR1;
import static android.os.Build.VERSION_CODES.KITKAT_WATCH;
import static android.view.Display.FLAG_PRESENTATION;
import static android.view.Display.FLAG_PRIVATE;
import static android.view.Display.FLAG_SECURE;
import static android.view.Display.FLAG_SUPPORTS_PROTECTED_BUFFERS;
import static android.view.Display.STATE_DOZE;
import static android.view.Display.STATE_DOZE_SUSPEND;
import static android.view.Display.STATE_OFF;
import static android.view.Display.STATE_ON;
import static android.view.Display.STATE_UNKNOWN;
import static android.view.Surface.ROTATION_0;
import static android.view.Surface.ROTATION_180;
import static android.view.Surface.ROTATION_270;
import static android.view.Surface.ROTATION_90;
import static com.pkware.truth.android.internal.IntegerUtils.buildBitMaskString;
import static com.pkware.truth.android.internal.IntegerUtils.buildNamedValueString;

/**
 * Propositions for {@link Display} subjects.
 */
public class DisplaySubject extends Subject {

  @Nullable
  private final Display actual;

  public DisplaySubject(@Nonnull FailureMetadata failureMetadata, @Nullable Display actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  @Nonnull
  public static String orientationToString(@SurfaceRotation int orientation) {
    return buildNamedValueString(orientation)
        .value(ROTATION_0, "portrait (0)")
        .value(ROTATION_90, "landscape (90)")
        .value(ROTATION_180, "inverted portrait (180)")
        .value(ROTATION_270, "inverted landscape (270)")
        .get();
  }

  @Nonnull
  @TargetApi(KITKAT_WATCH)
  public static String stateToString(@DisplayState int state) {
    return buildNamedValueString(state)
        .value(STATE_DOZE, "dozing")
        .value(STATE_DOZE_SUSPEND, "doze suspend")
        .value(STATE_OFF, "off")
        .value(STATE_ON, "on")
        .value(STATE_UNKNOWN, "unknown")
        .get();
  }

  @Nonnull
  public static String flagsToString(@DisplayFlags int flags) {
    return buildBitMaskString(flags)
        .flag(FLAG_PRESENTATION, "presentation")
        .flag(FLAG_PRIVATE, "private")
        .flag(FLAG_SECURE, "secure")
        .flag(FLAG_SUPPORTS_PROTECTED_BUFFERS, "supports_protected_buffers")
        .get();
  }

  @Nonnull
  public static String pixelFormatToString(@DisplayPixelFormat int format) {
    return buildNamedValueString(format)
        .value(UNKNOWN, "unknown")
        .value(TRANSLUCENT, "translucent")
        .value(TRANSPARENT, "transparent")
        .value(OPAQUE, "opaque")
        .value(RGBA_8888, "rgba_8888")
        .value(RGBX_8888, "rgbx_8888")
        .value(RGB_888, "rgb_888")
        .value(RGB_565, "rgb_565")
        .value(RGBA_5551, "rgba_5551")
        .value(RGBA_4444, "rgba_4444")
        .value(A_8, "a_8")
        .value(L_8, "l_8")
        .value(LA_88, "la_88")
        .value(RGB_332, "rgb_332")
        .value(YCbCr_422_SP, "ycbcr_422_sp")
        .value(YCbCr_420_SP, "ycbcr_420_sp")
        .value(YCbCr_422_I, "ycbcr_422_i")
        .value(JPEG, "jpeg")
        .get();
  }

  public void hasDisplayId(int id) {
    check("getDisplayId()").that(actual.getDisplayId()).isEqualTo(id);
  }

  @TargetApi(JELLY_BEAN_MR1)
  public void hasFlag(int flag) {
    check("getFlags()")
        .withMessage("Expected flag <%s> but was not present", flag)
        .that(actual.getFlags() & flag)
        .isNotEqualTo(0);
  }

  @TargetApi(JELLY_BEAN_MR1)
  public void hasFlags(@DisplayFlags int flags) {
    int actualFlags = actual.getFlags();
    //noinspection ResourceType
    check("getFlags()")
        .withMessage("Expected flags <%s> but was <%s>", flagsToString(flags),
            flagsToString(actualFlags))
        .that(actualFlags)
        .isEqualTo(flags);
  }

  public void hasHeight(int height) {
    check("getHeight()").that(actual.getHeight()).isEqualTo(height);
  }

  @TargetApi(JELLY_BEAN_MR1)
  public void hasName(@Nullable String name) {
    check("getName()").that(actual.getName()).isEqualTo(name);
  }

  public void hasOrientation(@SurfaceRotation int orientation) {
    int actualOrientation = actual.getOrientation();
    //noinspection ResourceType
    check("getOrientation()")
        .withMessage("Expected orientation <%s> but was <%s>",
            orientationToString(orientation), orientationToString(actualOrientation))
        .that(actualOrientation)
        .isEqualTo(orientation);
  }

  public void isPortrait() {
    int actualOrientation = actual.getOrientation();
    //noinspection ResourceType
    check("getOrientation()")
        .withMessage("Expected orientation <%s> or <%s>, but was <%s>",
            orientationToString(ROTATION_0), orientationToString(ROTATION_180),
            orientationToString(actualOrientation))
        .that(actualOrientation)
        .isAnyOf(ROTATION_0, ROTATION_180);
  }

  public void isLandscape() {
    int actualOrientation = actual.getOrientation();
    //noinspection ResourceType
    check("getOrientation()")
        .withMessage("Expected orientation <%s> or <%s>, but was <%s>",
            orientationToString(ROTATION_270), orientationToString(ROTATION_90),
            orientationToString(actualOrientation))
        .that(actualOrientation)
        .isAnyOf(ROTATION_270, ROTATION_90);
  }

  public void hasPixelFormat(@DisplayPixelFormat int format) {
    int actualFormat = actual.getPixelFormat();
    //noinspection ResourceType
    check("getPixelFormat()")
        .withMessage("Expected pixel format <%s> but was <%s>",
            pixelFormatToString(format), pixelFormatToString(actualFormat))
        .that(actualFormat)
        .isEqualTo(format);
  }

  @TargetApi(JELLY_BEAN_MR1)
  public void hasRealSize(int width, int height) {
    Point actualSize = new Point();
    actual.getRealSize(actualSize);
    check("getRealSize(Point) -> Point.x")
        .withMessage("Expected real size of <%s, %s> but was <%s, %s>", width, height,
            actualSize.x, actualSize.y)
        .that(actualSize.x)
        .isNotEqualTo(width);
    check("getRealSize(Point) -> Point.y")
        .withMessage("Expected real size of <%s, %s> but was <%s, %s>", width, height,
            actualSize.x, actualSize.y)
        .that(actualSize.y)
        .isNotEqualTo(height);
  }

  public void hasRefreshRate(float rate, float tolerance) {
    check("getRefreshRate()").that(actual.getRefreshRate()).isWithin(tolerance).of(rate);
  }

  public void hasRotation(int rotation) {
    check("getRotation()").that(actual.getRotation()).isEqualTo(rotation);
  }

  public void hasSize(int width, int height) {
    Point actualSize = new Point();
    actual.getSize(actualSize);
    check("getSize(Point) -> Point.x")
        .withMessage("Expected size of <%s, %s> but was <%s, %s>", width, height,
            actualSize.x, actualSize.y)
        .that(actualSize.x)
        .isNotEqualTo(width);
    check("getSize(Point) -> Point.y")
        .withMessage("Expected size of <%s, %s> but was <%s, %s>", width, height,
            actualSize.x, actualSize.y)
        .that(actualSize.y)
        .isNotEqualTo(height);
  }

  @TargetApi(KITKAT_WATCH)
  public void hasState(@DisplayState int state) {
    int actualState = actual.getState();
    //noinspection ResourceType
    check("getState()")
        .withMessage("Expected state <%s> but was <%s>", stateToString(state),
            stateToString(actualState))
        .that(actualState)
        .isEqualTo(state);
  }

  public void hasWidth(int width) {
    check("getWidth()").that(actual.getWidth()).isEqualTo(width);
  }

  @TargetApi(JELLY_BEAN_MR1)
  public void isValid() {
    check("isValid()").that(actual.isValid()).isTrue();
  }

  @TargetApi(JELLY_BEAN_MR1)
  public void isNotValid() {
    check("isValid()").that(actual.isValid()).isFalse();
  }
}
