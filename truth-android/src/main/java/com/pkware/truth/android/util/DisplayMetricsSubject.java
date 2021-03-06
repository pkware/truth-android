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
package com.pkware.truth.android.util;

import android.util.DisplayMetrics;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link DisplayMetrics} subjects.
 */
public class DisplayMetricsSubject extends Subject {

  @Nullable
  private final DisplayMetrics actual;

  public DisplayMetricsSubject(@Nonnull FailureMetadata failureMetadata, @Nullable DisplayMetrics actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasDensity(float density, float tolerance) {
    check("density").that(actual.density).isWithin(tolerance).of(density);
  }

  public void hasDpi(int dpi) {
    check("densityDpi").that(actual.densityDpi).isEqualTo(dpi);
  }

  public void hasHeight(int height) {
    check("heightPixels").that(actual.heightPixels).isEqualTo(height);
  }

  public void hasScaledDensity(float scaledDensity, float tolerance) {
    check("scaledDensity").that(actual.scaledDensity).isWithin(tolerance).of(scaledDensity);
  }

  public void hasWidth(int width) {
    check("widthPixels").that(actual.widthPixels).isEqualTo(width);
  }

  public void hasXDpi(float xDpi, float tolerance) {
    check("xdpi").that(actual.xdpi).isWithin(tolerance).of(xDpi);
  }

  public void hasYDpi(float yDpi, float tolerance) {
    check("ydpi").that(actual.ydpi).isWithin(tolerance).of(yDpi);
  }
}
