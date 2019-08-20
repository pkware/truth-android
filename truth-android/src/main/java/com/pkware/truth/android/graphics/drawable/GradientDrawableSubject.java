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
package com.pkware.truth.android.graphics.drawable;

import android.annotation.TargetApi;
import android.graphics.drawable.GradientDrawable;

import com.google.common.truth.FailureMetadata;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.os.Build.VERSION_CODES.JELLY_BEAN;

/**
 * Propositions for {@link GradientDrawable} subjects.
 */
public class GradientDrawableSubject extends AbstractDrawableSubject<GradientDrawable> {

  @Nullable
  private GradientDrawable actual;

  public GradientDrawableSubject(@Nonnull FailureMetadata failureMetadata, @Nullable GradientDrawable actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  @TargetApi(JELLY_BEAN)
  public GradientDrawableSubject hasOrientation(@Nullable GradientDrawable.Orientation orientation) {
    check("getOrientation()").that(actual.getOrientation()).isEqualTo(orientation);
    return this;
  }
}
