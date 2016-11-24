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

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link RectF} subjects.
 */
public class RectFSubject extends Subject<RectFSubject, RectF> {
  protected RectFSubject(FailureStrategy failureStrategy, RectF subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<RectFSubject, RectF> type() {
    return new SubjectFactory<RectFSubject, RectF>() {
      @Override
      public RectFSubject getSubject(FailureStrategy fs, RectF that) {
        return new RectFSubject(fs, that);
      }
    };
  }

  public RectFSubject hasBottom(float bottom, float tolerance) {
    assertThat(actual().bottom)
        .named("bottom")
        .isWithin(tolerance)
        .of(bottom);
    return this;
  }

  public RectFSubject hasLeft(float left, float tolerance) {
    assertThat(actual().left)
        .named("left")
        .isWithin(tolerance)
        .of(left);
    return this;
  }

  public RectFSubject hasRight(float right, float tolerance) {
    assertThat(actual().right)
        .named("right")
        .isWithin(tolerance)
        .of(right);
    return this;
  }

  public RectFSubject hasTop(float top, float tolerance) {
    assertThat(actual().top)
        .named("top")
        .isWithin(tolerance)
        .of(top);
    return this;
  }

  public RectFSubject hasCenterX(float center, float tolerance) {
    assertThat(actual().centerX())
        .named("X center")
        .isWithin(tolerance)
        .of(center);
    return this;
  }

  public RectFSubject hasCenterY(float center, float tolerance) {
    assertThat(actual().centerY())
        .named("Y center")
        .isWithin(tolerance)
        .of(center);
    return this;
  }

  public RectFSubject hasHeight(float height, float tolerance) {
    assertThat(actual().height())
        .named("height")
        .isWithin(tolerance)
        .of(height);
    return this;
  }

  public RectFSubject isEmpty() {
    assertThat(actual().isEmpty())
        .named("is empty")
        .isTrue();
    return this;
  }

  public RectFSubject isNotEmpty() {
    assertThat(actual().isEmpty())
        .named("is empty")
        .isFalse();
    return this;
  }

  public RectFSubject hasWidth(float width, float tolerance) {
    assertThat(actual().width())
        .named("width")
        .isWithin(tolerance)
        .of(width);
    return this;
  }
}
