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

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR1;
import static android.os.Build.VERSION_CODES.KITKAT;

/**
 * Propositions for {@link Bitmap} subjects.
 */
public class BitmapSubject extends Subject {

  @Nullable
  private final Bitmap actual;

  public BitmapSubject(@Nonnull FailureMetadata failureMetadata, @Nullable Bitmap actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void isRecycled() {
    check("isRecycled()").that(actual.isRecycled()).isTrue();
  }

  public void isNotRecycled() {
    check("isRecycled()").that(actual.isRecycled()).isFalse();
  }

  public void isMutable() {
    check("isMutable()").that(actual.isMutable()).isTrue();
  }

  public void isNotMutable() {
    check("isMutable()").that(actual.isMutable()).isFalse();
  }

  @TargetApi(JELLY_BEAN_MR1)
  public void isPremultiplied() {
    check("isPremultiplied()").that(actual.isPremultiplied()).isTrue();
  }

  @TargetApi(JELLY_BEAN_MR1)
  public void isNotPremultiplied() {
    check("isPremultiplied()").that(actual.isPremultiplied()).isFalse();
  }

  @TargetApi(KITKAT)
  public void hasAllocationByteCount(int count) {
    check("getAllocationByteCount()").that(actual.getAllocationByteCount()).isEqualTo(count);
  }

  public void hasByteCount(int count) {
    check("getByteCount()").that(actual.getByteCount()).isEqualTo(count);
  }

  public void hasDensity(int density) {
    check("getDensity()").that(actual.getDensity()).isEqualTo(density);
  }

  public void hasWidth(int width) {
    check("getWidth()").that(actual.getWidth()).isEqualTo(width);
  }

  public void hasHeight(int height) {
    check("getHeight()").that(actual.getHeight()).isEqualTo(height);
  }

  public void hasAlphaSupport() {
    check("hasAlpha()").that(actual.hasAlpha()).isTrue();
  }

  public void hasNoAlphaSupport() {
    check("hasAlpha()").that(actual.hasAlpha()).isFalse();
  }
}
