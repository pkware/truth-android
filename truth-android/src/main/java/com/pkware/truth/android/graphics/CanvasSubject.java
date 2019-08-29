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

  public void hasClipBounds(@Nullable Rect bounds) {
    check("getClipBounds()").that(actual.getClipBounds()).isEqualTo(bounds);
  }

  public void hasDensity(int density) {
    check("getDensity()").that(actual.getDensity()).isEqualTo(density);
  }

  public void hasHeight(int height) {
    check("getHeight()").that(actual.getHeight()).isEqualTo(height);
  }

  public void hasMaximumBitmapHeight(int height) {
    check("getMaximumBitmapHeight()").that(actual.getMaximumBitmapHeight()).isEqualTo(height);
  }

  public void hasMaximumBitmapWidth(int width) {
    check("getMaximumBitmapWidth()").that(actual.getMaximumBitmapWidth()).isEqualTo(width);
  }

  public void hasSaveCount(int count) {
    check("getSaveCount()").that(actual.getSaveCount()).isEqualTo(count);
  }

  public void hasWidth(int width) {
    check("getWidth()").that(actual.getWidth()).isEqualTo(width);
  }

  public void isHardwareAccelerated() {
    check("isHardwareAccelerated()").that(actual.isHardwareAccelerated()).isTrue();
  }

  public void isNotHardwareAccelerated() {
    check("isHardwareAccelerated()").that(actual.isHardwareAccelerated()).isFalse();
  }

  public void isOpaque() {
    check("isOpaque()").that(actual.isOpaque()).isTrue();
  }

  public void isNotOpaque() {
    check("isOpaque()").that(actual.isOpaque()).isFalse();
  }
}
