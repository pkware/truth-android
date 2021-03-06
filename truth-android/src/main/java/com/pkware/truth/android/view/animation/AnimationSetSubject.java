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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link AnimationSet} subjects.
 */
public class AnimationSetSubject extends AbstractAnimationSubject<AnimationSet> {

  @Nullable
  private AnimationSet actual;

  public AnimationSetSubject(@Nonnull FailureMetadata failureMetadata, @Nullable AnimationSet actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasDurationHint(long duration) {
    check("computeDurationHint()").that(actual.computeDurationHint()).isEqualTo(duration);
  }

  public void hasAnimationCount(int count) {
    check("getAnimations()").that(actual.getAnimations()).hasSize(count);
  }
}
