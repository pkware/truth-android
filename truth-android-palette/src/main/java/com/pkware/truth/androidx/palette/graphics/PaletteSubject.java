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
package com.pkware.truth.androidx.palette.graphics;

import androidx.palette.graphics.Palette;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link Palette} subjects.
 */
public class PaletteSubject extends Subject {

  @Nullable
  private final Palette actual;

  public PaletteSubject(@Nonnull FailureMetadata failureMetadata, @Nullable Palette actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  private static int getAnotherColor(int color) {
    return 0xFFFFFFFF - color;
  }

  public PaletteSubject hasVibrantColor(int color) {
    check("vibrant color").that(actual.getVibrantColor(getAnotherColor(color))).isEqualTo(color);
    return this;
  }

  public PaletteSubject hasDarkVibrantColor(int color) {
    check("dark vibrant color").that(actual.getDarkVibrantColor(getAnotherColor(color))).isEqualTo(color);
    return this;
  }

  public PaletteSubject hasLightVibrantColor(int color) {
    check("light vibrant color").that(actual.getLightVibrantColor(getAnotherColor(color))).isEqualTo(color);
    return this;
  }

  public PaletteSubject hasMutedColor(int color) {
    check("muted color").that(actual.getMutedColor(getAnotherColor(color))).isEqualTo(color);
    return this;
  }

  public PaletteSubject hasDarkMutedColor(int color) {
    check("dark muted color").that(actual.getDarkMutedColor(getAnotherColor(color))).isEqualTo(color);
    return this;
  }

  public PaletteSubject hasLightMutedColor(int color) {
    check("light muted color").that(actual.getLightMutedColor(color)).isEqualTo(color);
    return this;
  }
}
