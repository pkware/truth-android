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
package com.pkware.truth.android.graphics;

import android.graphics.Canvas;
import android.graphics.Rect;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link Canvas} subjects.
 */
public class CanvasSubject extends Subject<CanvasSubject, Canvas> {
  protected CanvasSubject(FailureStrategy failureStrategy, Canvas subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<CanvasSubject, Canvas> type() {
    return new SubjectFactory<CanvasSubject, Canvas>() {
      @Override
      public CanvasSubject getSubject(FailureStrategy fs, Canvas that) {
        return new CanvasSubject(fs, that);
      }
    };
  }

  public CanvasSubject hasClipBounds(Rect bounds) {
    assertThat(getSubject().getClipBounds())
        .named("clip bound")
        .isEqualTo(bounds);
    return this;
  }

  public CanvasSubject hasDensity(int density) {
    assertThat(getSubject().getDensity())
        .named("density")
        .isEqualTo(density);
    return this;
  }

  public CanvasSubject hasHeight(int height) {
    assertThat(getSubject().getHeight())
        .named("height")
        .isEqualTo(height);
    return this;
  }

  public CanvasSubject hasMaximumBitmapHeight(int height) {
    assertThat(getSubject().getMaximumBitmapHeight())
        .named("maximum bitmap height")
        .isEqualTo(height);
    return this;
  }

  public CanvasSubject hasMaximumBitmapWidth(int width) {
    assertThat(getSubject().getMaximumBitmapWidth())
        .named("maximum bitmap width")
        .isEqualTo(width);
    return this;
  }

  public CanvasSubject hasSaveCount(int count) {
    assertThat(getSubject().getSaveCount())
        .named("save count")
        .isEqualTo(count);
    return this;
  }

  public CanvasSubject hasWidth(int width) {
    assertThat(getSubject().getWidth())
        .named("width")
        .isEqualTo(width);
    return this;
  }

  public CanvasSubject isHardwareAccelerated() {
    assertThat(getSubject().isHardwareAccelerated())
        .named("is hardware accelerated")
        .isTrue();
    return this;
  }

  public CanvasSubject isNotHardwareAccelerated() {
    assertThat(getSubject().isHardwareAccelerated())
        .named("is hardware accelerated")
        .isFalse();
    return this;
  }

  public CanvasSubject isOpaque() {
    assertThat(getSubject().isOpaque())
        .named("is opaque")
        .isTrue();
    return this;
  }

  public CanvasSubject isNotOpaque() {
    assertThat(getSubject().isOpaque())
        .named("is opaque")
        .isFalse();
    return this;
  }
}
