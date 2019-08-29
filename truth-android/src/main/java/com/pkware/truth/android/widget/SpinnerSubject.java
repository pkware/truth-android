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
import android.widget.Spinner;

import androidx.annotation.StringRes;

import com.google.common.truth.FailureMetadata;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.os.Build.VERSION_CODES.JELLY_BEAN;

/**
 * Propositions for {@link Spinner} subjects.
 */
public class SpinnerSubject extends AbstractAbsSpinnerSubject<Spinner> {

  @Nullable
  private final Spinner actual;

  public SpinnerSubject(@Nonnull FailureMetadata failureMetadata, @Nullable Spinner actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  @TargetApi(JELLY_BEAN)
  public void hasDropDownHorizontalOffset(int offset) {
    check("getDropDownHorizontalOffset()").that(actual.getDropDownHorizontalOffset()).isEqualTo(offset);
  }

  @TargetApi(JELLY_BEAN)
  public void hasDropDownVerticalOffset(int offset) {
    check("getDropDownVerticalOffset()").that(actual.getDropDownVerticalOffset()).isEqualTo(offset);
  }

  @TargetApi(JELLY_BEAN)
  public void hasDropDownWidth(int width) {
    check("getDropDownWidth()").that(actual.getDropDownWidth()).isEqualTo(width);
  }

  @TargetApi(JELLY_BEAN)
  public void hasGravity(int gravity) {
    check("getGravity()").that(actual.getGravity()).isEqualTo(gravity);
  }

  @TargetApi(JELLY_BEAN)
  public void hasPopupBackground(@Nullable Drawable background) {
    check("getPopupBackground()").that(actual.getPopupBackground()).isSameInstanceAs(background);
  }

  public void hasPrompt(@Nullable String text) {
    check("getPrompt()").that(actual.getPrompt().toString()).isEqualTo(text);
  }

  public void hasPrompt(@StringRes int resId) {
    hasPrompt(actual.getContext().getString(resId));
  }
}
