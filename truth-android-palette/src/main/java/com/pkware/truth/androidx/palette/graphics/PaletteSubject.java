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

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link Palette} subjects.
 */
public class PaletteSubject extends Subject<PaletteSubject, Palette> {
  public PaletteSubject(FailureMetadata failureMetadata, Palette subject) {
    super(failureMetadata, subject);
  }

  private static int getAnotherColor(int color) {
    return 0xFFFFFFFF - color;
  }

  public PaletteSubject hasVibrantColor(int color) {
    assertThat(actual().getVibrantColor(getAnotherColor(color)))
        .named("vibrant color")
        .isEqualTo(color);
    return this;
  }

  public PaletteSubject hasDarkVibrantColor(int color) {
    assertThat(actual().getDarkVibrantColor(getAnotherColor(color)))
        .named("dark vibrant color")
        .isEqualTo(color);
    return this;
  }

  public PaletteSubject hasLightVibrantColor(int color) {
    assertThat(actual().getLightVibrantColor(getAnotherColor(color)))
        .named("light vibrant color")
        .isEqualTo(color);
    return this;
  }

  public PaletteSubject hasMutedColor(int color) {
    assertThat(actual().getMutedColor(getAnotherColor(color)))
        .named("muted color")
        .isEqualTo(color);
    return this;
  }

  public PaletteSubject hasDarkMutedColor(int color) {
    assertThat(actual().getDarkMutedColor(getAnotherColor(color)))
        .named("dark muted color")
        .isEqualTo(color);
    return this;
  }

  public PaletteSubject hasLightMutedColor(int color) {
    assertThat(actual().getLightMutedColor(color))
        .named("light muted color")
        .isEqualTo(color);
    return this;
  }
}
