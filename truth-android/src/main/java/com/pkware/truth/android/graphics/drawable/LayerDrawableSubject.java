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

import android.graphics.drawable.LayerDrawable;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link LayerDrawable} subjects.
 */
public class LayerDrawableSubject extends AbstractDrawableSubject<LayerDrawableSubject, LayerDrawable> {
  protected LayerDrawableSubject(FailureStrategy failureStrategy, LayerDrawable subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<LayerDrawableSubject, LayerDrawable> type() {
    return new SubjectFactory<LayerDrawableSubject, LayerDrawable>() {
      @Override
      public LayerDrawableSubject getSubject(FailureStrategy fs, LayerDrawable that) {
        return new LayerDrawableSubject(fs, that);
      }
    };
  }

  public LayerDrawableSubject hasLayerCount(int count) {
    assertThat(actual().getNumberOfLayers())
        .named("layer count")
        .isEqualTo(count);
    return this;
  }
}
