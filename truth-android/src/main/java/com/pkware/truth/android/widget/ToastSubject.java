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
package com.pkware.truth.android.widget;

import android.view.View;
import android.widget.Toast;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link Toast} subjects.
 */
public class ToastSubject extends Subject<ToastSubject, Toast> {
  protected ToastSubject(FailureStrategy failureStrategy, Toast subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<ToastSubject, Toast> type() {
    return new SubjectFactory<ToastSubject, Toast>() {
      @Override
      public ToastSubject getSubject(FailureStrategy fs, Toast that) {
        return new ToastSubject(fs, that);
      }
    };
  }

  public ToastSubject hasDuration(int duration) {
    assertThat(getSubject().getDuration())
        .named("duration")
        .isEqualTo(duration);
    return this;
  }

  public ToastSubject hasGravity(int gravity) {
    assertThat(getSubject().getGravity())
        .named("gravity")
        .isEqualTo(gravity);
    return this;
  }

  public ToastSubject hasHorizontalMargin(float margin, float tolerance) {
    assertThat(getSubject().getHorizontalMargin())
        .named("horizontal margin")
        .isWithin(tolerance)
        .of(margin);
    return this;
  }

  public ToastSubject hasVerticalMargin(float margin, float tolerance) {
    assertThat(getSubject().getVerticalMargin())
        .named("vertical margin")
        .isWithin(tolerance)
        .of(margin);
    return this;
  }

  public ToastSubject hasView(View view) {
    assertThat(getSubject().getView())
        .named("view")
        .isSameAs(view);
    return this;
  }

  public ToastSubject hasXOffset(int offset) {
    assertThat(getSubject().getXOffset())
        .named("X offset")
        .isEqualTo(offset);
    return this;
  }

  public ToastSubject hasYOffset(int offset) {
    assertThat(getSubject().getYOffset())
        .named("Y offset")
        .isEqualTo(offset);
    return this;
  }
}
