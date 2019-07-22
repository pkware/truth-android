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
package com.pkware.truth.android.graphics;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.NinePatch;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import static android.os.Build.VERSION_CODES.KITKAT;
import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link NinePatch} subjects.
 */
public class NinePatchSubject extends Subject<NinePatchSubject, NinePatch> {
  protected NinePatchSubject(FailureMetadata failureMetadata, NinePatch subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<NinePatchSubject, NinePatch> type() {
    return NinePatchSubject::new;
  }

  public NinePatchSubject hasDensity(int density) {
    assertThat(actual().getDensity())
        .named("density")
        .isEqualTo(density);
    return this;
  }

  public NinePatchSubject hasHeight(int height) {
    assertThat(actual().getHeight())
        .named("height")
        .isEqualTo(height);
    return this;
  }

  public NinePatchSubject hasWidth(int width) {
    assertThat(actual().getWidth())
        .named("width")
        .isEqualTo(width);
    return this;
  }

  public NinePatchSubject hasAlpha() {
    assertThat(actual().hasAlpha())
        .named("has alpha")
        .isTrue();
    return this;
  }

  public NinePatchSubject hasNoAlpha() {
    assertThat(actual().hasAlpha())
        .named("has alpha")
        .isFalse();
    return this;
  }

  @TargetApi(KITKAT)
  public NinePatchSubject hasName(String name) {
    assertThat(actual().getName())
        .named("name")
        .isEqualTo(name);
    return this;
  }

  @TargetApi(KITKAT)
  public NinePatchSubject hasBitmap(Bitmap bitmap) {
    assertThat(actual().getBitmap())
        .named("bitmap")
        .isEqualTo(bitmap);
    return this;
  }
}
