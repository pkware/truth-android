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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link Pair} subjects.
 */
public class PairSubject<F, S> extends Subject {

  @Nullable
  private final Pair<F, S> actual;

  public PairSubject(@Nonnull FailureMetadata failureMetadata, @Nullable Pair<F, S> actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasFirst(@Nullable F first) {
    check("first").that(actual.first).isEqualTo(first);
  }

  public void hasSecond(@Nullable S second) {
    check("second").that(actual.second).isEqualTo(second);
  }
}
