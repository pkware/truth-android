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

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;

import com.google.common.truth.FailureStrategy;
import com.pkware.truth.android.view.AbstractViewGroupSubject;

import static android.os.Build.VERSION_CODES.JELLY_BEAN;
import static com.google.common.truth.Truth.assertThat;

public abstract class AbstractFrameLayoutSubject<S extends AbstractFrameLayoutSubject<S, T>, T extends FrameLayout>
    extends AbstractViewGroupSubject<S, T> {
  protected AbstractFrameLayoutSubject(FailureStrategy failureStrategy, T subject) {
    super(failureStrategy, subject);
  }

  public S hasForeground(Drawable drawable) {
    assertThat(actual().getForeground())
        .named("foreground drawable")
        .isSameAs(drawable);
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(JELLY_BEAN)
  public S hasForegroundGravity(int gravity) {
    assertThat(actual().getForegroundGravity())
        .named("foreground gravity")
        .isEqualTo(gravity);
    //noinspection unchecked
    return (S) this;
  }

  public S isMeasuringAllChildren() {
    assertThat(actual().getMeasureAllChildren())
        .named("is measuring all children")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotMeasuringAllChildren() {
    assertThat(actual().getMeasureAllChildren())
        .named("is measuring all children")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S isDelayingChildPressedState() {
    assertThat(actual().shouldDelayChildPressedState())
        .named("is delaying child pressed state")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotDelayingChildPressedState() {
    assertThat(actual().shouldDelayChildPressedState())
        .named("is delaying child pressed state")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }
}
