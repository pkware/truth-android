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
package com.pkware.truth.android.graphics;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.NinePatch;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.os.Build.VERSION_CODES.KITKAT;

/**
 * Propositions for {@link NinePatch} subjects.
 */
public class NinePatchSubject extends Subject {

  @Nullable
  private final NinePatch actual;

  public NinePatchSubject(@Nonnull FailureMetadata failureMetadata, @Nullable NinePatch actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasDensity(int density) {
    check("getDensity()").that(actual.getDensity()).isEqualTo(density);
  }

  public void hasHeight(int height) {
    check("getHeight()").that(actual.getHeight()).isEqualTo(height);
  }

  public void hasWidth(int width) {
    check("getWidth()").that(actual.getWidth()).isEqualTo(width);
  }

  public void hasAlpha() {
    check("hasAlpha()").that(actual.hasAlpha()).isTrue();
  }

  public void hasNoAlpha() {
    check("hasAlpha()").that(actual.hasAlpha()).isFalse();
  }

  @TargetApi(KITKAT)
  public void hasName(@Nullable String name) {
    check("getName()").that(actual.getName()).isEqualTo(name);
  }

  @TargetApi(KITKAT)
  public void hasBitmap(@Nullable Bitmap bitmap) {
    check("getBitmap()").that(actual.getBitmap()).isEqualTo(bitmap);
  }
}
