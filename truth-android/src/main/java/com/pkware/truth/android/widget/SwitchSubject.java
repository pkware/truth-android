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
import android.support.annotation.StringRes;
import android.widget.Switch;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH;
import static android.os.Build.VERSION_CODES.JELLY_BEAN;
import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link Switch} subjects.
 */
@TargetApi(ICE_CREAM_SANDWICH)
public class SwitchSubject extends AbstractCompoundButtonSubject<SwitchSubject, Switch> {
  protected SwitchSubject(FailureStrategy failureStrategy, Switch subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<SwitchSubject, Switch> type() {
    return new SubjectFactory<SwitchSubject, Switch>() {
      @Override
      public SwitchSubject getSubject(FailureStrategy fs, Switch that) {
        return new SwitchSubject(fs, that);
      }
    };
  }

  @TargetApi(JELLY_BEAN)
  public SwitchSubject hasSwitchMinWidth(int width) {
    assertThat(actual().getSwitchMinWidth())
        .named("switch minimum width")
        .isEqualTo(width);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public SwitchSubject hasSwitchPadding(int padding) {
    assertThat(actual().getSwitchPadding())
        .named("switch padding")
        .isEqualTo(padding);
    return this;
  }

  public SwitchSubject hasOnText(String text) {
    assertThat(actual().getTextOn().toString())
        .named("'on' text")
        .isEqualTo(text);
    return this;
  }

  public SwitchSubject hasOnText(@StringRes int resId) {
    return hasOnText(actual().getContext().getString(resId));
  }

  public SwitchSubject hasOffText(String text) {
    assertThat(actual().getTextOff().toString())
        .named("'off' text")
        .isEqualTo(text);
    return this;
  }

  public SwitchSubject hasOffText(@StringRes int resId) {
    return hasOffText(actual().getContext().getString(resId));
  }

  @TargetApi(JELLY_BEAN)
  public SwitchSubject hasThumbDrawable(Drawable drawable) {
    assertThat(actual().getThumbDrawable())
        .named("thumb drawable")
        .isSameAs(drawable);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public SwitchSubject hasThumbTextPadding(int padding) {
    assertThat(actual().getThumbTextPadding())
        .named("thumb text padding")
        .isEqualTo(padding);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public SwitchSubject hasTrackDrawable(Drawable drawable) {
    assertThat(actual().getTrackDrawable())
        .named("track drawable")
        .isSameAs(drawable);
    return this;
  }
}
