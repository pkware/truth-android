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

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;

import com.google.common.truth.FailureMetadata;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link BitmapDrawable} subjects.
 */
public class BitmapDrawableSubject extends AbstractDrawableSubject<BitmapDrawable> {

  @Nullable
  private BitmapDrawable actual;

  public BitmapDrawableSubject(@Nonnull FailureMetadata failureMetadata, @Nullable BitmapDrawable actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasBitmap(@Nullable Bitmap bitmap) {
    check("getBitmap()").that(actual.getBitmap()).isEqualTo(bitmap);
  }

  public void hasGravity(int gravity) {
    check("getGravity()").that(actual.getGravity()).isEqualTo(gravity);
  }

  public void hasPaint(@Nullable Paint paint) {
    check("getPaint()").that(actual.getPaint()).isEqualTo(paint);
  }

  public void hasTileModeX(@Nullable Shader.TileMode mode) {
    check("getTileModeX()").that(actual.getTileModeX()).isEqualTo(mode);
  }

  public void hasTileModeY(@Nullable Shader.TileMode mode) {
    check("getTileModeY()").that(actual.getTileModeY()).isEqualTo(mode);
  }
}
