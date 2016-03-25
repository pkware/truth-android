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

import android.graphics.Rect;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link Rect} subjects.
 */
public class RectSubject extends Subject<RectSubject, Rect> {
  protected RectSubject(FailureStrategy failureStrategy, Rect subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<RectSubject, Rect> type() {
    return new SubjectFactory<RectSubject, Rect>() {
      @Override
      public RectSubject getSubject(FailureStrategy fs, Rect that) {
        return new RectSubject(fs, that);
      }
    };
  }

  public RectSubject hasBottom(int bottom) {
    assertThat(getSubject().bottom)
        .named("bottom")
        .isEqualTo(bottom);
    return this;
  }

  public RectSubject hasLeft(int left) {
    assertThat(getSubject().left)
        .named("left")
        .isEqualTo(left);
    return this;
  }

  public RectSubject hasRight(int right) {
    assertThat(getSubject().right)
        .named("right")
        .isEqualTo(right);
    return this;
  }

  public RectSubject hasTop(int top) {
    assertThat(getSubject().top)
        .named("top")
        .isEqualTo(top);
    return this;
  }

  public RectSubject hasCenterX(int center) {
    assertThat(getSubject().centerX())
        .named("X center")
        .isEqualTo(center);
    return this;
  }

  public RectSubject hasCenterY(int center) {
    assertThat(getSubject().centerY())
        .named("Y center")
        .isEqualTo(center);
    return this;
  }

  public RectSubject hasExactCenterX(float center, float tolerance) {
    assertThat(getSubject().exactCenterX())
        .named("exact X center")
        .isWithin(tolerance)
        .of(center);
    return this;
  }

  public RectSubject hasExactCenterY(float center, float tolerance) {
    assertThat(getSubject().exactCenterY())
        .named("exact Y center")
        .isWithin(tolerance)
        .of(center);
    return this;
  }

  public RectSubject hasHeight(int height) {
    assertThat(getSubject().height())
        .named("height")
        .isEqualTo(height);
    return this;
  }

  public RectSubject isEmpty() {
    assertThat(getSubject().isEmpty())
        .named("is empty")
        .isTrue();
    return this;
  }

  public RectSubject isNotEmpty() {
    assertThat(getSubject().isEmpty())
        .named("is empty")
        .isFalse();
    return this;
  }

  public RectSubject hasWidth(int width) {
    assertThat(getSubject().width())
        .named("width")
        .isEqualTo(width);
    return this;
  }
}
