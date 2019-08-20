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

import android.graphics.Canvas;
import android.graphics.Rect;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link Canvas} subjects.
 */
public class CanvasSubject extends Subject {

  @Nullable
  private final Canvas actual;

  public CanvasSubject(@Nonnull FailureMetadata failureMetadata, @Nullable Canvas actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public CanvasSubject hasClipBounds(@Nullable Rect bounds) {
    check("getClipBounds()").that(actual.getClipBounds()).isEqualTo(bounds);
    return this;
  }

  public CanvasSubject hasDensity(int density) {
    check("getDensity()").that(actual.getDensity()).isEqualTo(density);
    return this;
  }

  public CanvasSubject hasHeight(int height) {
    check("getHeight()").that(actual.getHeight()).isEqualTo(height);
    return this;
  }

  public CanvasSubject hasMaximumBitmapHeight(int height) {
    check("getMaximumBitmapHeight()").that(actual.getMaximumBitmapHeight()).isEqualTo(height);
    return this;
  }

  public CanvasSubject hasMaximumBitmapWidth(int width) {
    check("getMaximumBitmapWidth()").that(actual.getMaximumBitmapWidth()).isEqualTo(width);
    return this;
  }

  public CanvasSubject hasSaveCount(int count) {
    check("getSaveCount()").that(actual.getSaveCount()).isEqualTo(count);
    return this;
  }

  public CanvasSubject hasWidth(int width) {
    check("getWidth()").that(actual.getWidth()).isEqualTo(width);
    return this;
  }

  public CanvasSubject isHardwareAccelerated() {
    check("isHardwareAccelerated()").that(actual.isHardwareAccelerated()).isTrue();
    return this;
  }

  public CanvasSubject isNotHardwareAccelerated() {
    check("isHardwareAccelerated()").that(actual.isHardwareAccelerated()).isFalse();
    return this;
  }

  public CanvasSubject isOpaque() {
    check("isOpaque()").that(actual.isOpaque()).isTrue();
    return this;
  }

  public CanvasSubject isNotOpaque() {
    check("isOpaque()").that(actual.isOpaque()).isFalse();
    return this;
  }
}
