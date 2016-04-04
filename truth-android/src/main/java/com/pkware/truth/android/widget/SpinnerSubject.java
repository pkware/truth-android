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
import android.support.annotation.StringRes;
import android.widget.Spinner;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.JELLY_BEAN;
import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link Spinner} subjects.
 */
public class SpinnerSubject extends AbstractAbsSpinnerSubject<SpinnerSubject, Spinner> {
  protected SpinnerSubject(FailureStrategy failureStrategy, Spinner subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<SpinnerSubject, Spinner> type() {
    return new SubjectFactory<SpinnerSubject, Spinner>() {
      @Override
      public SpinnerSubject getSubject(FailureStrategy fs, Spinner that) {
        return new SpinnerSubject(fs, that);
      }
    };
  }

  @TargetApi(JELLY_BEAN)
  public SpinnerSubject hasDropDownHorizontalOffset(int offset) {
    assertThat(getSubject().getDropDownHorizontalOffset())
        .named("rop-down horizontal offset")
        .isEqualTo(offset);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public SpinnerSubject hasDropDownVerticalOffset(int offset) {
    assertThat(getSubject().getDropDownVerticalOffset())
        .named("drop-down vertical offset")
        .isEqualTo(offset);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public SpinnerSubject hasDropDownWidth(int width) {
    assertThat(getSubject().getDropDownWidth())
        .named("drop-down width")
        .isEqualTo(width);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public SpinnerSubject hasGravity(int gravity) {
    assertThat(getSubject().getGravity())
        .named("gravity")
        .isEqualTo(gravity);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public SpinnerSubject hasPopupBackground(Drawable background) {
    assertThat(getSubject().getPopupBackground())
        .named("popup background")
        .isSameAs(background);
    return this;
  }

  public SpinnerSubject hasPrompt(String text) {
    assertThat(getSubject().getPrompt().toString())
        .named("prompt")
        .isEqualTo(text);
    return this;
  }

  public SpinnerSubject hasPrompt(@StringRes int resId) {
    return hasPrompt(getSubject().getContext().getString(resId));
  }
}
