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

import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR1;
import static android.os.Build.VERSION_CODES.KITKAT;
import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link Bitmap} subjects.
 */
public class BitmapSubject extends Subject<BitmapSubject, Bitmap> {
  protected BitmapSubject(FailureMetadata failureMetadata, Bitmap subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<BitmapSubject, Bitmap> type() {
    return new Subject.Factory<BitmapSubject, Bitmap>() {
      @Override
      public BitmapSubject createSubject(FailureMetadata fm, Bitmap that) {
        return new BitmapSubject(fm, that);
      }
    };
  }

  public BitmapSubject isRecycled() {
    assertThat(actual().isRecycled())
        .named("is recycled")
        .isTrue();
    return this;
  }

  public BitmapSubject isNotRecycled() {
    assertThat(actual().isRecycled())
        .named("is recycled")
        .isFalse();
    return this;
  }

  public BitmapSubject isMutable() {
    assertThat(actual().isMutable())
        .named("is mutable")
        .isTrue();
    return this;
  }

  public BitmapSubject isNotMutable() {
    assertThat(actual().isMutable())
        .named("is mutable")
        .isFalse();
    return this;
  }

  @TargetApi(JELLY_BEAN_MR1)
  public BitmapSubject isPremultiplied() {
    assertThat(actual().isPremultiplied())
        .named("is premultiplied")
        .isTrue();
    return this;
  }

  @TargetApi(JELLY_BEAN_MR1)
  public BitmapSubject isNotPremultiplied() {
    assertThat(actual().isPremultiplied())
        .named("is premultiplied")
        .isFalse();
    return this;
  }

  @TargetApi(KITKAT)
  public BitmapSubject hasAllocationByteCount(int count) {
    assertThat(actual().getAllocationByteCount())
        .named("allocation byte count")
        .isEqualTo(count);
    return this;
  }

  public BitmapSubject hasByteCount(int count) {
    assertThat(actual().getByteCount())
        .named("byte count")
        .isEqualTo(count);
    return this;
  }

  public BitmapSubject hasDensity(int density) {
    assertThat(actual().getDensity())
        .named("density")
        .isEqualTo(density);
    return this;
  }

  public BitmapSubject hasWidth(int width) {
    assertThat(actual().getWidth())
        .named("width")
        .isEqualTo(width);
    return this;
  }

  public BitmapSubject hasHeight(int height) {
    assertThat(actual().getHeight())
        .named("height")
        .isEqualTo(height);
    return this;
  }

  public BitmapSubject hasAlphaSupport() {
    assertThat(actual().hasAlpha())
        .named("has alpha support")
        .isTrue();
    return this;
  }

  public BitmapSubject hasNoAlphaSupport() {
    assertThat(actual().hasAlpha())
        .named("has alpha support")
        .isFalse();
    return this;
  }
}
