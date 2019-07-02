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
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assert_;
import static com.pkware.truth.android.internal.IntegerUtils.buildNamedValueString;

public abstract class AbstractActivitySubject<S extends AbstractActivitySubject<S, T>, T extends Activity> extends Subject<S, T> {
  protected AbstractActivitySubject(FailureMetadata failureMetadata, T subject) {
    super(failureMetadata, subject);
  }

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

  public S hasRequestedOrientation(@ActivityScreenOrientation int orientation) {
    int actualOrientation = actual().getRequestedOrientation();
    assert_()
        .withMessage("Expected orientation <%s> but was <%s>.", screenOrientationToString(orientation), screenOrientationToString(actualOrientation))
        .that(actualOrientation)
        .isEqualTo(orientation);
    //noinspection unchecked
    return (S) this;
  }

  public S hasTitle(CharSequence title) {
    assertThat(actual().getTitle())
        .named("title")
        .isEqualTo(title);
    //noinspection unchecked
    return (S) this;
  }

  public S hasTitle(@StringRes int resId) {
    return hasTitle(actual().getString(resId));
  }

  public S hasTitleColor(@ColorRes int color) {
    int actualColor = actual().getTitleColor();
    assert_()
        .withMessage("Expected title color <%s> but was <%s>.", Integer.toHexString(color), Integer.toHexString(actualColor))
        .that(actualColor)
        .isEqualTo(color);
    //noinspection unchecked
    return (S) this;
  }

  public S hasWindowFocus() {
    assertThat(actual().hasWindowFocus())
        .named("has window focus")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isChangingConfigurations() {
    assertThat(actual().isChangingConfigurations())
        .named("is changing configurations")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotChangingConfigurations() {
    assertThat(actual().isChangingConfigurations())
        .named("is changing configurations")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S isChild() {
    assertThat(actual().isChild())
        .named("is child")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotChild() {
    assertThat(actual().isChild())
        .named("is child")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(JELLY_BEAN_MR1)
  public S isDestroyed() {
    assertThat(actual().isDestroyed())
        .named("is destroyed")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(JELLY_BEAN_MR1)
  public S isNotDestroyed() {
    assertThat(actual().isDestroyed())
        .named("is destroyed")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S isFinishing() {
    assertThat(actual().isFinishing())
        .named("is finishing")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotFinishing() {
    assertThat(actual().isFinishing())
        .named("is finishing")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(JELLY_BEAN_MR2)
  public S isImmersive() {
    assertThat(actual().isImmersive())
        .named("is immersive")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(JELLY_BEAN_MR2)
  public S isNotImmersive() {
    assertThat(actual().isImmersive())
        .named("is immersive")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S isTaskRoot() {
    assertThat(actual().isTaskRoot())
        .named("is task root")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotTaskRoot() {
    assertThat(actual().isTaskRoot())
        .named("is task root")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }
}
