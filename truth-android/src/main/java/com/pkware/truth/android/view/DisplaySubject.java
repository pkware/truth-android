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
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assert_;
import static com.pkware.truth.android.internal.IntegerUtils.buildBitMaskString;
import static com.pkware.truth.android.internal.IntegerUtils.buildNamedValueString;

/**
 * Propositions for {@link Display} subjects.
 */
public class DisplaySubject extends Subject<DisplaySubject, Display> {
  public DisplaySubject(FailureMetadata failureMetadata, Display subject) {
    super(failureMetadata, subject);
  }

  public static String orientationToString(@SurfaceRotation int orientation) {
    return buildNamedValueString(orientation)
        .value(ROTATION_0, "portrait (0)")
        .value(ROTATION_90, "landscape (90)")
        .value(ROTATION_180, "inverted portrait (180)")
        .value(ROTATION_270, "inverted landscape (270)")
        .get();
  }

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

  public static String flagsToString(@DisplayFlags int flags) {
    return buildBitMaskString(flags)
        .flag(FLAG_PRESENTATION, "presentation")
        .flag(FLAG_PRIVATE, "private")
        .flag(FLAG_SECURE, "secure")
        .flag(FLAG_SUPPORTS_PROTECTED_BUFFERS, "supports_protected_buffers")
        .get();
  }

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

  public DisplaySubject hasDisplayId(int id) {
    assertThat(actual().getDisplayId())
        .named("display ID")
        .isEqualTo(id);
    return this;
  }

  @TargetApi(JELLY_BEAN_MR1)
  public DisplaySubject hasFlag(int flag) {
    assert_()
        .withMessage("Expected flag <%s> but was not present", flag)
        .that(actual().getFlags() & flag)
        .isNotEqualTo(0);
    return this;
  }

  @TargetApi(JELLY_BEAN_MR1)
  public DisplaySubject hasFlags(@DisplayFlags int flags) {
    int actualFlags = actual().getFlags();
    //noinspection ResourceType
    assert_()
        .withMessage("Expected flags <%s> but was <%s>", flagsToString(flags),
            flagsToString(actualFlags))
        .that(actualFlags)
        .isEqualTo(flags);
    return this;
  }

  public DisplaySubject hasHeight(int height) {
    assertThat(actual().getHeight())
        .named("height")
        .isEqualTo(height);
    return this;
  }

  @TargetApi(JELLY_BEAN_MR1)
  public DisplaySubject hasName(String name) {
    assertThat(actual().getName())
        .named("name")
        .isEqualTo(name);
    return this;
  }

  public DisplaySubject hasOrientation(@SurfaceRotation int orientation) {
    int actualOrientation = actual().getOrientation();
    //noinspection ResourceType
    assert_()
        .withMessage("Expected orientation <%s> but was <%s>",
            orientationToString(orientation), orientationToString(actualOrientation))
        .that(actualOrientation)
        .isEqualTo(orientation);
    return this;
  }

  public DisplaySubject isPortrait() {
    int actualOrientation = actual().getOrientation();
    //noinspection ResourceType
    assert_()
        .withMessage("Expected orientation <%s> or <%s>, but was <%s>",
            orientationToString(ROTATION_0), orientationToString(ROTATION_180),
            orientationToString(actualOrientation))
        .that(actualOrientation)
        .isAnyOf(ROTATION_0, ROTATION_180);
    return this;
  }

  public DisplaySubject isLandscape() {
    int actualOrientation = actual().getOrientation();
    //noinspection ResourceType
    assert_()
        .withMessage("Expected orientation <%s> or <%s>, but was <%s>",
            orientationToString(ROTATION_270), orientationToString(ROTATION_90),
            orientationToString(actualOrientation))
        .that(actualOrientation)
        .isAnyOf(ROTATION_270, ROTATION_90);
    return this;
  }

  public DisplaySubject hasPixelFormat(@DisplayPixelFormat int format) {
    int actualFormat = actual().getPixelFormat();
    //noinspection ResourceType
    assert_()
        .withMessage("Expected pixel format <%s> but was <%s>",
            pixelFormatToString(format), pixelFormatToString(actualFormat))
        .that(actualFormat)
        .isEqualTo(format);
    return this;
  }

  @TargetApi(JELLY_BEAN_MR1)
  public DisplaySubject hasRealSize(int width, int height) {
    Point actualSize = new Point();
    actual().getRealSize(actualSize);
    assert_()
        .withMessage("Expected real size of <%s, %s> but was <%s, %s>", width, height,
            actualSize.x, actualSize.y)
        .that(actualSize.x)
        .isNotEqualTo(width);
    assert_()
        .withMessage("Expected real size of <%s, %s> but was <%s, %s>", width, height,
            actualSize.x, actualSize.y)
        .that(actualSize.y)
        .isNotEqualTo(height);
    return this;
  }

  public DisplaySubject hasRefreshRate(float rate, float tolerance) {
    assertThat(actual().getRefreshRate())
        .named("refresh rate")
        .isWithin(tolerance)
        .of(rate);
    return this;
  }

  public DisplaySubject hasRotation(int rotation) {
    assertThat(actual().getRotation())
        .named("rotation")
        .isEqualTo(rotation);
    return this;
  }

  public DisplaySubject hasSize(int width, int height) {
    Point actualSize = new Point();
    actual().getSize(actualSize);
    assert_()
        .withMessage("Expected size of <%s, %s> but was <%s, %s>", width, height,
            actualSize.x, actualSize.y)
        .that(actualSize.x)
        .isNotEqualTo(width);
    assert_()
        .withMessage("Expected size of <%s, %s> but was <%s, %s>", width, height,
            actualSize.x, actualSize.y)
        .that(actualSize.y)
        .isNotEqualTo(height);
    return this;
  }

  @TargetApi(KITKAT_WATCH)
  public DisplaySubject hasState(@DisplayState int state) {
    int actualState = actual().getState();
    //noinspection ResourceType
    assert_()
        .withMessage("Expected state <%s> but was <%s>", stateToString(state),
            stateToString(actualState))
        .that(actualState)
        .isEqualTo(state);
    return this;
  }

  public DisplaySubject hasWidth(int width) {
    assertThat(actual().getWidth())
        .named("width")
        .isEqualTo(width);
    return this;
  }

  @TargetApi(JELLY_BEAN_MR1)
  public DisplaySubject isValid() {
    assertThat(actual().isValid())
        .named("is valid")
        .isTrue();
    return this;
  }

  @TargetApi(JELLY_BEAN_MR1)
  public DisplaySubject isNotValid() {
    assertThat(actual().isValid())
        .named("is valid")
        .isFalse();
    return this;
  }
}
