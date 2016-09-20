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
package com.pkware.truth.android.graphics.drawable;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;

import static android.os.Build.VERSION_CODES.KITKAT;
import static com.google.common.truth.Truth.assertThat;

public class AbstractDrawableSubject<S extends AbstractDrawableSubject<S, T>, T extends Drawable> extends Subject<S, T> {
  protected AbstractDrawableSubject(FailureStrategy failureStrategy, T subject) {
    super(failureStrategy, subject);
  }

  public S hasBounds(Rect bounds) {
    assertThat(actual().getBounds())
        .named("bounds")
        .isEqualTo(bounds);
    //noinspection unchecked
    return (S) this;
  }

  public S hasCallback(Drawable.Callback callback) {
    assertThat(actual().getCallback())
        .named("callback")
        .isSameAs(callback);
    //noinspection unchecked
    return (S) this;
  }

  public S hasChangingConfigurations(int mask) {
    assertThat(actual().getChangingConfigurations())
        .named("changing configurations")
        .isEqualTo(mask);
    //noinspection unchecked
    return (S) this;
  }

  public S hasConstantState(Drawable.ConstantState state) {
    assertThat(actual().getConstantState())
        .named("constant state")
        .isEqualTo(state);
    //noinspection unchecked
    return (S) this;
  }

  public S hasIntrinsicHeight(int height) {
    assertThat(actual().getIntrinsicHeight())
        .named("intrinsic height")
        .isEqualTo(height);
    //noinspection unchecked
    return (S) this;
  }

  public S hasIntrinsicWidth(int width) {
    assertThat(actual().getIntrinsicWidth())
        .named("intrinsic width")
        .isEqualTo(width);
    //noinspection unchecked
    return (S) this;
  }

  public S hasLevel(int level) {
    assertThat(actual().getLevel())
        .named("level")
        .isEqualTo(level);
    //noinspection unchecked
    return (S) this;
  }

  public S hasMinimumHeight(int height) {
    assertThat(actual().getMinimumHeight())
        .named("minimum height")
        .isEqualTo(height);
    //noinspection unchecked
    return (S) this;
  }

  public S hasMinimumWidth(int width) {
    assertThat(actual().getMinimumWidth())
        .named("minimum width")
        .isEqualTo(width);
    //noinspection unchecked
    return (S) this;
  }

  public S hasOpacity(int opacity) {
    assertThat(actual().getOpacity())
        .named("opacity")
        .isEqualTo(opacity);
    //noinspection unchecked
    return (S) this;
  }

  public S isStateful() {
    assertThat(actual().isStateful())
        .named("is stateful")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotStateful() {
    assertThat(actual().isStateful())
        .named("is stateful")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S isVisible() {
    assertThat(actual().isVisible())
        .named("is visible")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotVisible() {
    assertThat(actual().isVisible())
        .named("is visible")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(KITKAT)
  public S hasAlpha(int alpha) {
    assertThat(actual().getAlpha())
        .named("alpha")
        .isEqualTo(alpha);
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(KITKAT)
  public S isAutoMirrored() {
    assertThat(actual().isAutoMirrored())
        .named("is auto mirrored")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(KITKAT)
  public S isNotAutoMirrored() {
    assertThat(actual().isAutoMirrored())
        .named("is auto mirrored")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }
}
