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

import android.graphics.RectF;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link RectF} subjects.
 */
public class RectFSubject extends Subject {

  @Nullable
  private final RectF actual;

  public RectFSubject(@Nonnull FailureMetadata failureMetadata, @Nullable RectF actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public RectFSubject hasBottom(float bottom, float tolerance) {
    check("bottom").that(actual.bottom).isWithin(tolerance).of(bottom);
    return this;
  }

  public RectFSubject hasLeft(float left, float tolerance) {
    check("left").that(actual.left).isWithin(tolerance).of(left);
    return this;
  }

  public RectFSubject hasRight(float right, float tolerance) {
    check("right").that(actual.right).isWithin(tolerance).of(right);
    return this;
  }

  public RectFSubject hasTop(float top, float tolerance) {
    check("top").that(actual.top).isWithin(tolerance).of(top);
    return this;
  }

  public RectFSubject hasCenterX(float center, float tolerance) {
    check("centerX()").that(actual.centerX()).isWithin(tolerance).of(center);
    return this;
  }

  public RectFSubject hasCenterY(float center, float tolerance) {
    check("centerY()").that(actual.centerY()).isWithin(tolerance).of(center);
    return this;
  }

  public RectFSubject hasHeight(float height, float tolerance) {
    check("height()").that(actual.height()).isWithin(tolerance).of(height);
    return this;
  }

  public RectFSubject isEmpty() {
    check("isEmpty()").that(actual.isEmpty()).isTrue();
    return this;
  }

  public RectFSubject isNotEmpty() {
    check("isEmpty()").that(actual.isEmpty()).isFalse();
    return this;
  }

  public RectFSubject hasWidth(float width, float tolerance) {
    check("width()").that(actual.width()).isWithin(tolerance).of(width);
    return this;
  }
}
