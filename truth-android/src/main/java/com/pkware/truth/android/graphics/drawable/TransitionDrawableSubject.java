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
package com.pkware.truth.android.graphics.drawable;

import android.graphics.drawable.TransitionDrawable;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link TransitionDrawable} subjects.
 */
public class TransitionDrawableSubject extends AbstractDrawableSubject<TransitionDrawableSubject, TransitionDrawable> {
  protected TransitionDrawableSubject(FailureStrategy failureStrategy, TransitionDrawable subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<TransitionDrawableSubject, TransitionDrawable> type() {
    return new SubjectFactory<TransitionDrawableSubject, TransitionDrawable>() {
      @Override
      public TransitionDrawableSubject getSubject(FailureStrategy fs, TransitionDrawable that) {
        return new TransitionDrawableSubject(fs, that);
      }
    };
  }

  public TransitionDrawableSubject isCrossFadeEnabled() {
    assertThat(getSubject().isCrossFadeEnabled())
        .named("cross-fade is enabled")
        .isTrue();
    return this;
  }

  public TransitionDrawableSubject isCrossFadeDisabled() {
    assertThat(!getSubject().isCrossFadeEnabled())
        .named("cross-fade is disabled")
        .isTrue();
    return this;
  }
}
