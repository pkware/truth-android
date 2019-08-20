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
import android.widget.AbsSeekBar;

import com.google.common.truth.FailureMetadata;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.os.Build.VERSION_CODES.JELLY_BEAN;

public abstract class AbstractAbsSeekBarSubject<T extends AbsSeekBar>
    extends AbstractProgressBarSubject<T> {

  @Nullable
  private final T actual;

  protected AbstractAbsSeekBarSubject(@Nonnull FailureMetadata failureMetadata, @Nullable T actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasKeyProgressIncrement(int increment) {
    check("getKeyProgressIncrement()").that(actual.getKeyProgressIncrement()).isEqualTo(increment);
  }

  @TargetApi(JELLY_BEAN)
  public void hasThumb(@Nullable Drawable drawable) {
    check("getThumb()").that(actual.getThumb()).isSameInstanceAs(drawable);
  }

  public void hasThumbOffset(int offset) {
    check("getThumbOffset()").that(actual.getThumbOffset()).isEqualTo(offset);
  }
}
