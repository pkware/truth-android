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

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;

import com.google.common.truth.FailureMetadata;
import com.pkware.truth.android.view.AbstractViewGroupSubject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.os.Build.VERSION_CODES.JELLY_BEAN;

public abstract class AbstractFrameLayoutSubject<T extends FrameLayout>
    extends AbstractViewGroupSubject<T> {

  @Nullable
  private final T actual;

  protected AbstractFrameLayoutSubject(@Nonnull FailureMetadata failureMetadata, @Nullable T actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasForeground(@Nullable Drawable drawable) {
    check("getForeground()").that(actual.getForeground()).isSameInstanceAs(drawable);
  }

  @TargetApi(JELLY_BEAN)
  public void hasForegroundGravity(int gravity) {
    check("getForegroundGravity()").that(actual.getForegroundGravity()).isEqualTo(gravity);
  }

  public void isMeasuringAllChildren() {
    check("getMeasureAllChildren()").that(actual.getMeasureAllChildren()).isTrue();
  }

  public void isNotMeasuringAllChildren() {
    check("getMeasureAllChildren()").that(actual.getMeasureAllChildren()).isFalse();
  }

  public void isDelayingChildPressedState() {
    check("shouldDelayChildPressedState()").that(actual.shouldDelayChildPressedState()).isTrue();
  }

  public void isNotDelayingChildPressedState() {
    check("shouldDelayChildPressedState()").that(actual.shouldDelayChildPressedState()).isFalse();
  }
}
