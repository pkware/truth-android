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
import android.widget.ImageView;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;
import com.pkware.truth.android.view.AbstractViewSubject;

import static android.os.Build.VERSION_CODES.JELLY_BEAN;
import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link ImageView} subjects.
 */
public class ImageViewSubject extends AbstractViewSubject<ImageViewSubject, ImageView> {
  protected ImageViewSubject(FailureMetadata failureMetadata, ImageView subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<ImageViewSubject, ImageView> type() {
    return ImageViewSubject::new;
  }

  public ImageViewSubject isAligningBaselineToBottom() {
    assertThat(actual().getBaselineAlignBottom())
        .named("is aligning baseline to bottom")
        .isTrue();
    return this;
  }

  public ImageViewSubject isNotAligningBaselineToBottom() {
    assertThat(actual().getBaselineAlignBottom())
        .named("is aligning baseline to bottom")
        .isFalse();
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public ImageViewSubject isCroppingToPadding() {
    assertThat(actual().getCropToPadding())
        .named("is cropping to padding")
        .isTrue();
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public ImageViewSubject isNotCroppingToPadding() {
    assertThat(actual().getCropToPadding())
        .named("is cropping to padding")
        .isFalse();
    return this;
  }

  public ImageViewSubject hasDrawable(Drawable drawable) {
    assertThat(actual().getDrawable())
        .named("drawable")
        .isSameAs(drawable);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public ImageViewSubject hasImageAlpha(int alpha) {
    assertThat(actual().getImageAlpha())
        .named("image alpha")
        .isEqualTo(alpha);
    return this;
  }

  public ImageViewSubject hasScaleType(ImageView.ScaleType type) {
    assertThat(actual().getScaleType())
        .named("scale type")
        .isEqualTo(type);
    return this;
  }
}
