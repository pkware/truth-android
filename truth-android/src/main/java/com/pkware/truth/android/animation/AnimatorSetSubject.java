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
package com.pkware.truth.android.animation;

import android.animation.AnimatorSet;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link AnimatorSet} subjects.
 */
public class AnimatorSetSubject extends AbstractAnimatorSubject<AnimatorSetSubject, AnimatorSet> {
  private AnimatorSetSubject(FailureMetadata failureMetadata, AnimatorSet subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<AnimatorSetSubject, AnimatorSet> type() {
    return new Subject.Factory<AnimatorSetSubject, AnimatorSet>() {
      @Override
      public AnimatorSetSubject createSubject(FailureMetadata fm, AnimatorSet that) {
        return new AnimatorSetSubject(fm, that);
      }
    };
  }

  public AnimatorSetSubject hasAnimatorCount(int count) {
    assertThat(actual().getChildAnimations().size())
        .named("animator count")
        .isEqualTo(count);
    return this;
  }
}
