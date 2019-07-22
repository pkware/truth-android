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
import com.google.common.truth.Subject;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link AnimationDrawable} subjects.
 */
public class AnimationDrawableSubject extends AbstractDrawableSubject<AnimationDrawableSubject, AnimationDrawable> {
  protected AnimationDrawableSubject(FailureMetadata failureMetadata, AnimationDrawable subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<AnimationDrawableSubject, AnimationDrawable> type() {
    return AnimationDrawableSubject::new;
  }

  public AnimationDrawableSubject hasFrameCount(int count) {
    assertThat(actual().getNumberOfFrames())
        .named("frame count")
        .isEqualTo(count);
    return this;
  }

  public AnimationDrawableSubject isOneShot() {
    assertThat(actual().isOneShot())
        .named("is one-shot")
        .isTrue();
    return this;
  }

  public AnimationDrawableSubject isNotOneShot() {
    assertThat(actual().isOneShot())
        .named("is one-shot")
        .isFalse();
    return this;
  }

  public AnimationDrawableSubject isRunning() {
    assertThat(actual().isRunning())
        .named("is running")
        .isTrue();
    return this;
  }

  public AnimationDrawableSubject isNotRunning() {
    assertThat(actual().isRunning())
        .named("is running")
        .isFalse();
    return this;
  }
}
