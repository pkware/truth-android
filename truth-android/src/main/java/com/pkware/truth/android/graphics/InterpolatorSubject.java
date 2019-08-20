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

import android.graphics.Interpolator;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link Interpolator} subjects.
 */
public class InterpolatorSubject extends Subject<InterpolatorSubject, Interpolator> {
  public InterpolatorSubject(FailureMetadata failureMetadata, Interpolator subject) {
    super(failureMetadata, subject);
  }

  public InterpolatorSubject hasKeyFrameCount(int count) {
    assertThat(actual().getKeyFrameCount())
        .named("key frame count")
        .isEqualTo(count);
    return this;
  }

  public InterpolatorSubject hasValueCount(int count) {
    assertThat(actual().getValueCount())
        .named("value count")
        .isEqualTo(count);
    return this;
  }
}
