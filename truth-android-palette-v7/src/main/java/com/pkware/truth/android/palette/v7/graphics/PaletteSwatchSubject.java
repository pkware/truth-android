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
package com.pkware.truth.android.palette.v7.graphics;

import android.support.v7.graphics.Palette;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link Palette.Swatch} subjects.
 */
public class PaletteSwatchSubject extends Subject<PaletteSwatchSubject, Palette.Swatch> {

  protected PaletteSwatchSubject(FailureStrategy failureStrategy, Palette.Swatch subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<PaletteSwatchSubject, Palette.Swatch> type() {
    return new SubjectFactory<PaletteSwatchSubject, Palette.Swatch>() {
      @Override
      public PaletteSwatchSubject getSubject(FailureStrategy fs, Palette.Swatch that) {
        return new PaletteSwatchSubject(fs, that);
      }
    };
  }

  public PaletteSwatchSubject hasRgb(int rgb) {
    assertThat(getSubject().getRgb())
        .named("RGB")
        .isEqualTo(rgb);
    return this;
  }
}
