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
import android.widget.Switch;

import androidx.annotation.StringRes;

import com.google.common.truth.FailureMetadata;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH;
import static android.os.Build.VERSION_CODES.JELLY_BEAN;

/**
 * Propositions for {@link Switch} subjects.
 */
@TargetApi(ICE_CREAM_SANDWICH)
public class SwitchSubject extends AbstractCompoundButtonSubject<Switch> {

  @Nullable
  private final Switch actual;

  public SwitchSubject(@Nonnull FailureMetadata failureMetadata, @Nullable Switch actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  @TargetApi(JELLY_BEAN)
  public void hasSwitchMinWidth(int width) {
    check("getSwitchMinWidth()").that(actual.getSwitchMinWidth()).isEqualTo(width);
  }

  @TargetApi(JELLY_BEAN)
  public void hasSwitchPadding(int padding) {
    check("getSwitchPadding()").that(actual.getSwitchPadding()).isEqualTo(padding);
  }

  public void hasOnText(@Nullable String text) {
    check("getTextOn()").that(actual.getTextOn().toString()).isEqualTo(text);
  }

  public void hasOnText(@StringRes int resId) {
    hasOnText(actual.getContext().getString(resId));
  }

  public void hasOffText(@Nullable String text) {
    check("getTextOff()").that(actual.getTextOff().toString()).isEqualTo(text);
  }

  public void hasOffText(@StringRes int resId) {
    hasOffText(actual.getContext().getString(resId));
  }

  @TargetApi(JELLY_BEAN)
  public void hasThumbDrawable(@Nullable Drawable drawable) {
    check("getThumbDrawable()").that(actual.getThumbDrawable()).isSameInstanceAs(drawable);
  }

  @TargetApi(JELLY_BEAN)
  public void hasThumbTextPadding(int padding) {
    check("getThumbTextPadding()").that(actual.getThumbTextPadding()).isEqualTo(padding);
  }

  @TargetApi(JELLY_BEAN)
  public void hasTrackDrawable(@Nullable Drawable drawable) {
    check("getTrackDrawable()").that(actual.getTrackDrawable()).isSameInstanceAs(drawable);
  }
}
