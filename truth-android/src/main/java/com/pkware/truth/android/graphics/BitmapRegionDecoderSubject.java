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

import android.graphics.BitmapRegionDecoder;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link BitmapRegionDecoder} subjects.
 */
public class BitmapRegionDecoderSubject extends Subject {

  @Nullable
  private final BitmapRegionDecoder actual;

  public BitmapRegionDecoderSubject(@Nonnull FailureMetadata failureMetadata, @Nullable BitmapRegionDecoder actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public BitmapRegionDecoderSubject hasHeight(int height) {
    check("getHeight()").that(actual.getHeight()).isEqualTo(height);
    return this;
  }

  public BitmapRegionDecoderSubject hasWidth(int width) {
    check("getWidth()").that(actual.getWidth()).isEqualTo(width);
    return this;
  }

  public BitmapRegionDecoderSubject isRecycled() {
    check("isRecycled()").that(actual.isRecycled()).isTrue();
    return this;
  }

  public BitmapRegionDecoderSubject isNotRecycled() {
    check("isRecycled()").that(actual.isRecycled()).isFalse();
    return this;
  }
}
