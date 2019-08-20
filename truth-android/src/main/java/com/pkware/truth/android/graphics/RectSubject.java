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

import android.graphics.Rect;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link Rect} subjects.
 */
public class RectSubject extends Subject<RectSubject, Rect> {
  public RectSubject(FailureMetadata failureMetadata, Rect subject) {
    super(failureMetadata, subject);
  }

  public RectSubject hasBottom(int bottom) {
    assertThat(actual().bottom)
        .named("bottom")
        .isEqualTo(bottom);
    return this;
  }

  public RectSubject hasLeft(int left) {
    assertThat(actual().left)
        .named("left")
        .isEqualTo(left);
    return this;
  }

  public RectSubject hasRight(int right) {
    assertThat(actual().right)
        .named("right")
        .isEqualTo(right);
    return this;
  }

  public RectSubject hasTop(int top) {
    assertThat(actual().top)
        .named("top")
        .isEqualTo(top);
    return this;
  }

  public RectSubject hasCenterX(int center) {
    assertThat(actual().centerX())
        .named("X center")
        .isEqualTo(center);
    return this;
  }

  public RectSubject hasCenterY(int center) {
    assertThat(actual().centerY())
        .named("Y center")
        .isEqualTo(center);
    return this;
  }

  public RectSubject hasExactCenterX(float center, float tolerance) {
    assertThat(actual().exactCenterX())
        .named("exact X center")
        .isWithin(tolerance)
        .of(center);
    return this;
  }

  public RectSubject hasExactCenterY(float center, float tolerance) {
    assertThat(actual().exactCenterY())
        .named("exact Y center")
        .isWithin(tolerance)
        .of(center);
    return this;
  }

  public RectSubject hasHeight(int height) {
    assertThat(actual().height())
        .named("height")
        .isEqualTo(height);
    return this;
  }

  public RectSubject isEmpty() {
    assertThat(actual().isEmpty())
        .named("is empty")
        .isTrue();
    return this;
  }

  public RectSubject isNotEmpty() {
    assertThat(actual().isEmpty())
        .named("is empty")
        .isFalse();
    return this;
  }

  public RectSubject hasWidth(int width) {
    assertThat(actual().width())
        .named("width")
        .isEqualTo(width);
    return this;
  }
}
