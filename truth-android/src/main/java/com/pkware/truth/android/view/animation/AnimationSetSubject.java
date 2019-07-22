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
package com.pkware.truth.android.view.animation;

import android.view.animation.AnimationSet;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link AnimationSet} subjects.
 */
public class AnimationSetSubject extends AbstractAnimationSubject<AnimationSetSubject, AnimationSet> {
  protected AnimationSetSubject(FailureMetadata failureMetadata, AnimationSet subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<AnimationSetSubject, AnimationSet> type() {
    return AnimationSetSubject::new;
  }

  public AnimationSetSubject hasDurationHint(long duration) {
    assertThat(actual().computeDurationHint())
        .named("duration hint")
        .isEqualTo(duration);
    return this;
  }

  public AnimationSetSubject hasAnimationCount(int count) {
    assertThat(actual().getAnimations().size())
        .named("animation count")
        .isEqualTo(count);
    return this;
  }
}
