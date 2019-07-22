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

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link DisplayMetrics} subjects.
 */
public class DisplayMetricsSubject extends Subject<DisplayMetricsSubject, DisplayMetrics> {
  protected DisplayMetricsSubject(FailureMetadata failureMetadata, DisplayMetrics subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<DisplayMetricsSubject, DisplayMetrics> type() {
    return DisplayMetricsSubject::new;
  }

  public DisplayMetricsSubject hasDensity(float density, float tolerance) {
    assertThat(actual().density)
        .named("density")
        .isWithin(tolerance)
        .of(density);
    return this;
  }

  public DisplayMetricsSubject hasDpi(int dpi) {
    assertThat(actual().densityDpi)
        .named("DPI")
        .isEqualTo(dpi);
    return this;
  }

  public DisplayMetricsSubject hasHeight(int height) {
    assertThat(actual().heightPixels)
        .named("height")
        .isEqualTo(height);
    return this;
  }

  public DisplayMetricsSubject hasScaledDensity(float scaledDensity, float tolerance) {
    assertThat(actual().scaledDensity)
        .named("scaled density")
        .isWithin(tolerance)
        .of(scaledDensity);
    return this;
  }

  public DisplayMetricsSubject hasWidth(int width) {
    assertThat(actual().widthPixels)
        .named("width")
        .isEqualTo(width);
    return this;
  }

  public DisplayMetricsSubject hasXDpi(float xDpi, float tolerance) {
    assertThat(actual().xdpi)
        .named("X DPI")
        .isWithin(tolerance)
        .of(xDpi);
    return this;
  }

  public DisplayMetricsSubject hasYDpi(float yDpi, float tolerance) {
    assertThat(actual().ydpi)
        .named("Y DPI")
        .isWithin(tolerance)
        .of(yDpi);
    return this;
  }
}
