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

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link BitmapDrawable} subjects.
 */
public class BitmapDrawableSubject extends AbstractDrawableSubject<BitmapDrawableSubject, BitmapDrawable> {
  protected BitmapDrawableSubject(FailureStrategy failureStrategy, BitmapDrawable subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<BitmapDrawableSubject, BitmapDrawable> type() {
    return new SubjectFactory<BitmapDrawableSubject, BitmapDrawable>() {
      @Override
      public BitmapDrawableSubject getSubject(FailureStrategy fs, BitmapDrawable that) {
        return new BitmapDrawableSubject(fs, that);
      }
    };
  }

  public BitmapDrawableSubject hasBitmap(Bitmap bitmap) {
    assertThat(getSubject().getBitmap())
        .named("bitmap")
        .isEqualTo(bitmap);
    return this;
  }

  public BitmapDrawableSubject hasGravity(int gravity) {
    assertThat(getSubject().getGravity())
        .named("gravity")
        .isEqualTo(gravity);
    return this;
  }

  public BitmapDrawableSubject hasPaint(Paint paint) {
    assertThat(getSubject().getPaint())
        .named("paint")
        .isEqualTo(paint);
    return this;
  }

  public BitmapDrawableSubject hasTileModeX(Shader.TileMode mode) {
    assertThat(getSubject().getTileModeX())
        .named("X tile mode")
        .isEqualTo(mode);
    return this;
  }

  public BitmapDrawableSubject hasTileModeY(Shader.TileMode mode) {
    assertThat(getSubject().getTileModeY())
        .named("Y tile mode")
        .isEqualTo(mode);
    return this;
  }
}
