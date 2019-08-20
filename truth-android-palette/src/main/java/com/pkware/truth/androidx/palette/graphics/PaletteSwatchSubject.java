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
 * Propositions for {@link Palette.Swatch} subjects.
 */
public class PaletteSwatchSubject extends Subject {

  @Nullable
  private final Palette.Swatch actual;

  public PaletteSwatchSubject(@Nonnull FailureMetadata failureMetadata, @Nullable Palette.Swatch actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public PaletteSwatchSubject hasRgb(int rgb) {
    check("getRgb()").that(actual.getRgb()).isEqualTo(rgb);
    return this;
  }
}
