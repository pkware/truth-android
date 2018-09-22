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
package com.pkware.truth.android.util;

import android.util.Pair;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link Pair} subjects.
 */
public class PairSubject<F, S> extends Subject<PairSubject<F, S>, Pair<F, S>> {
  protected PairSubject(FailureMetadata failureMetadata, Pair<F, S> subject) {
    super(failureMetadata, subject);
  }

  public static <F, S> Subject.Factory<PairSubject<F, S>, Pair<F, S>> type() {
    return new Subject.Factory<PairSubject<F, S>, Pair<F, S>>() {
      @Override
      public PairSubject<F, S> createSubject(FailureMetadata fm, Pair<F, S> that) {
        return new PairSubject<F, S>(fm, that);
      }
    };
  }

  public PairSubject<F, S> hasFirst(F first) {
    assertThat(actual().first)
        .named("first value")
        .isEqualTo(first);
    return this;
  }

  public PairSubject<F, S> hasSecond(S second) {
    assertThat(actual().second)
        .named("second value")
        .isEqualTo(second);
    return this;
  }
}
