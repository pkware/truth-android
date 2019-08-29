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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link Rect} subjects.
 */
public class RectSubject extends Subject {

  @Nullable
  private final Rect actual;

  public RectSubject(@Nonnull FailureMetadata failureMetadata, @Nullable Rect actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasBottom(int bottom) {
    check("bottom").that(actual.bottom).isEqualTo(bottom);
  }

  public void hasLeft(int left) {
    check("left").that(actual.left).isEqualTo(left);
  }

  public void hasRight(int right) {
    check("right").that(actual.right).isEqualTo(right);
  }

  public void hasTop(int top) {
    check("top").that(actual.top).isEqualTo(top);
  }

  public void hasCenterX(int center) {
    check("centerX()").that(actual.centerX()).isEqualTo(center);
  }

  public void hasCenterY(int center) {
    check("centerY()").that(actual.centerY()).isEqualTo(center);
  }

  public void hasExactCenterX(float center, float tolerance) {
    check("exactCenterX()").that(actual.exactCenterX()).isWithin(tolerance)
        .of(center);
  }

  public void hasExactCenterY(float center, float tolerance) {
    check("exactCenterY()").that(actual.exactCenterY()).isWithin(tolerance)
        .of(center);
  }

  public void hasHeight(int height) {
    check("height()").that(actual.height()).isEqualTo(height);
  }

  public void isEmpty() {
    check("isEmpty()").that(actual.isEmpty()).isTrue();
  }

  public void isNotEmpty() {
    check("isEmpty()").that(actual.isEmpty()).isFalse();
  }

  public void hasWidth(int width) {
    check("width()").that(actual.width()).isEqualTo(width);
  }
}
