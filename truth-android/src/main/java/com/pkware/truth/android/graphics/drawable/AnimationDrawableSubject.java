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

import android.graphics.drawable.AnimationDrawable;

import com.google.common.truth.FailureMetadata;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link AnimationDrawable} subjects.
 */
public class AnimationDrawableSubject extends AbstractDrawableSubject<AnimationDrawable> {

  @Nullable
  private AnimationDrawable actual;

  public AnimationDrawableSubject(@Nonnull FailureMetadata failureMetadata, @Nullable AnimationDrawable actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public AnimationDrawableSubject hasFrameCount(int count) {
    check("getNumberOfFrames()").that(actual.getNumberOfFrames()).isEqualTo(count);
    return this;
  }

  public AnimationDrawableSubject isOneShot() {
    check("isOneShot()").that(actual.isOneShot()).isTrue();
    return this;
  }

  public AnimationDrawableSubject isNotOneShot() {
    check("isOneShot()").that(actual.isOneShot()).isFalse();
    return this;
  }

  public AnimationDrawableSubject isRunning() {
    check("isRunning()").that(actual.isRunning()).isTrue();
    return this;
  }

  public AnimationDrawableSubject isNotRunning() {
    check("isRunning()").that(actual.isRunning()).isFalse();
    return this;
  }
}
