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
package com.pkware.truth.android.app;

import android.annotation.TargetApi;
import android.app.Activity;

import androidx.annotation.ColorRes;
import androidx.annotation.StringRes;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_BEHIND;
import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR;
import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_FULL_USER;
import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LOCKED;
import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_NOSENSOR;
import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE;
import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT;
import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_SENSOR;
import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE;
import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT;
import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED;
import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_USER;
import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_USER_LANDSCAPE;
import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_USER_PORTRAIT;
import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR1;
import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR2;
import static com.pkware.truth.android.internal.IntegerUtils.buildNamedValueString;

public abstract class AbstractActivitySubject<T extends Activity> extends Subject {

  @Nullable
  private final T actual;

  protected AbstractActivitySubject(@Nonnull FailureMetadata failureMetadata, @Nullable T actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  @Nonnull
  public static String screenOrientationToString(@ActivityScreenOrientation int orientation) {
    return buildNamedValueString(orientation)
        .value(SCREEN_ORIENTATION_UNSPECIFIED, "unspecified")
        .value(SCREEN_ORIENTATION_LANDSCAPE, "landscape")
        .value(SCREEN_ORIENTATION_PORTRAIT, "portrait")
        .value(SCREEN_ORIENTATION_USER, "user")
        .value(SCREEN_ORIENTATION_BEHIND, "behind")
        .value(SCREEN_ORIENTATION_SENSOR, "sensor")
        .value(SCREEN_ORIENTATION_NOSENSOR, "nosensor")
        .value(SCREEN_ORIENTATION_SENSOR_LANDSCAPE, "sensor_landscape")
        .value(SCREEN_ORIENTATION_SENSOR_PORTRAIT, "sensor_portrait")
        .value(SCREEN_ORIENTATION_REVERSE_LANDSCAPE, "reverse_landscape")
        .value(SCREEN_ORIENTATION_REVERSE_PORTRAIT, "reverse_portrait")
        .value(SCREEN_ORIENTATION_FULL_SENSOR, "full_sensor")
        .value(SCREEN_ORIENTATION_USER_LANDSCAPE, "user_landscape")
        .value(SCREEN_ORIENTATION_USER_PORTRAIT, "user_portrait")
        .value(SCREEN_ORIENTATION_FULL_USER, "full_user")
        .value(SCREEN_ORIENTATION_LOCKED, "locked")
        .get();
  }

  public void hasRequestedOrientation(@ActivityScreenOrientation int orientation) {
    int actualOrientation = actual.getRequestedOrientation();
    check("getRequestedOrientation()")
        .withMessage("Expected orientation <%s> but was <%s>.", screenOrientationToString(orientation), screenOrientationToString(actualOrientation))
        .that(actualOrientation)
        .isEqualTo(orientation);
  }

  public void hasTitle(@Nullable CharSequence title) {
    check("getTitle()").that(actual.getTitle()).isEqualTo(title);
  }

  public void hasTitle(@StringRes int resId) {
    hasTitle(actual.getString(resId));
  }

  public void hasTitleColor(@ColorRes int color) {
    int actualColor = actual.getTitleColor();
    check("getTitleColor()")
        .withMessage("Expected title color <%s> but was <%s>.", Integer.toHexString(color), Integer.toHexString(actualColor))
        .that(actualColor)
        .isEqualTo(color);
  }

  public void hasWindowFocus() {
    check("hasWindowFocus()").that(actual.hasWindowFocus()).isTrue();
  }

  public void isChangingConfigurations() {
    check("isChangingConfigurations()").that(actual.isChangingConfigurations()).isTrue();
  }

  public void isNotChangingConfigurations() {
    check("isChangingConfigurations()").that(actual.isChangingConfigurations()).isFalse();
  }

  public void isChild() {
    check("isChild()").that(actual.isChild()).isTrue();
  }

  public void isNotChild() {
    check("isChild()").that(actual.isChild()).isFalse();
  }

  @TargetApi(JELLY_BEAN_MR1)
  public void isDestroyed() {
    check("isDestroyed()").that(actual.isDestroyed()).isTrue();
  }

  @TargetApi(JELLY_BEAN_MR1)
  public void isNotDestroyed() {
    check("isDestroyed()").that(actual.isDestroyed()).isFalse();
  }

  public void isFinishing() {
    check("isFinishing()").that(actual.isFinishing()).isTrue();
  }

  public void isNotFinishing() {
    check("isFinishing()").that(actual.isFinishing()).isFalse();
  }

  @TargetApi(JELLY_BEAN_MR2)
  public void isImmersive() {
    check("isImmersive()").that(actual.isImmersive()).isTrue();
  }

  @TargetApi(JELLY_BEAN_MR2)
  public void isNotImmersive() {
    check("isImmersive()").that(actual.isImmersive()).isFalse();
  }

  public void isTaskRoot() {
    check("isTaskRoot()").that(actual.isTaskRoot()).isTrue();
  }

  public void isNotTaskRoot() {
    check("isTaskRoot()").that(actual.isTaskRoot()).isFalse();
  }
}
