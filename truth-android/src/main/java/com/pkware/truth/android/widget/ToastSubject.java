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
package com.pkware.truth.android.widget;

import android.view.View;
import android.widget.Toast;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link Toast} subjects.
 */
public class ToastSubject extends Subject {

  @Nullable
  private final Toast actual;

  public ToastSubject(@Nonnull FailureMetadata failureMetadata, @Nullable Toast actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasDuration(int duration) {
    check("getDuration()").that(actual.getDuration()).isEqualTo(duration);
  }

  public void hasGravity(int gravity) {
    check("getGravity()").that(actual.getGravity()).isEqualTo(gravity);
  }

  public void hasHorizontalMargin(float margin, float tolerance) {
    check("getHorizontalMargin()").that(actual.getHorizontalMargin()).isWithin(tolerance).of(margin);
  }

  public void hasVerticalMargin(float margin, float tolerance) {
    check("getVerticalMargin()").that(actual.getVerticalMargin()).isWithin(tolerance).of(margin);
  }

  public void hasView(@Nullable View view) {
    check("getView()").that(actual.getView()).isSameInstanceAs(view);
  }

  public void hasXOffset(int offset) {
    check("getXOffset()").that(actual.getXOffset()).isEqualTo(offset);
  }

  public void hasYOffset(int offset) {
    check("getYOffset()").that(actual.getYOffset()).isEqualTo(offset);
  }
}
