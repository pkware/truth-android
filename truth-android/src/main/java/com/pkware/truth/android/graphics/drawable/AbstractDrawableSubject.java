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
package com.pkware.truth.android.graphics.drawable;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.os.Build.VERSION_CODES.KITKAT;

public abstract class AbstractDrawableSubject<T extends Drawable> extends Subject {

  @Nullable
  private final T actual;

  protected AbstractDrawableSubject(@Nonnull FailureMetadata failureMetadata, @Nullable T actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasBounds(@Nullable Rect bounds) {
    check("getBounds()").that(actual.getBounds()).isEqualTo(bounds);
  }

  public void hasCallback(@Nullable Drawable.Callback callback) {
    check("getCallback()").that(actual.getCallback()).isSameInstanceAs(callback);
  }

  public void hasChangingConfigurations(int mask) {
    check("getChangingConfigurations()").that(actual.getChangingConfigurations()).isEqualTo(mask);
  }

  public void hasConstantState(@Nullable Drawable.ConstantState state) {
    check("getConstantState()").that(actual.getConstantState()).isEqualTo(state);
  }

  public void hasIntrinsicHeight(int height) {
    check("getIntrinsicHeight()").that(actual.getIntrinsicHeight()).isEqualTo(height);
  }

  public void hasIntrinsicWidth(int width) {
    check("getIntrinsicWidth()").that(actual.getIntrinsicWidth()).isEqualTo(width);
  }

  public void hasLevel(int level) {
    check("getLevel()").that(actual.getLevel()).isEqualTo(level);
  }

  public void hasMinimumHeight(int height) {
    check("getMinimumHeight()").that(actual.getMinimumHeight()).isEqualTo(height);
  }

  public void hasMinimumWidth(int width) {
    check("getMinimumWidth()").that(actual.getMinimumWidth()).isEqualTo(width);
  }

  public void hasOpacity(int opacity) {
    check("getOpacity()").that(actual.getOpacity()).isEqualTo(opacity);
  }

  public void isStateful() {
    check("isStateful()").that(actual.isStateful()).isTrue();
  }

  public void isNotStateful() {
    check("isStateful()").that(actual.isStateful()).isFalse();
  }

  public void isVisible() {
    check("isVisible()").that(actual.isVisible()).isTrue();
  }

  public void isNotVisible() {
    check("isVisible()").that(actual.isVisible()).isFalse();
  }

  @TargetApi(KITKAT)
  public void hasAlpha(int alpha) {
    check("getAlpha()").that(actual.getAlpha()).isEqualTo(alpha);
  }

  @TargetApi(KITKAT)
  public void isAutoMirrored() {
    check("isAutoMirrored()").that(actual.isAutoMirrored()).isTrue();
  }

  @TargetApi(KITKAT)
  public void isNotAutoMirrored() {
    check("isAutoMirrored()").that(actual.isAutoMirrored()).isFalse();
  }
}
