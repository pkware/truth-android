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
package com.pkware.truth.androidx.collection;

import androidx.collection.CircularArray;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link CircularArray} subjects.
 */
public class CircularArraySubject<E> extends Subject {

  @Nullable
  private final CircularArray<E> actual;

  public CircularArraySubject(@Nonnull FailureMetadata failureMetadata, @Nullable CircularArray<E> actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasFirst(@Nullable E first) {
    check("getFirst()").that(actual.getFirst()).isEqualTo(first);
  }

  public void hasLast(@Nullable E last) {
    check("getLast()").that(actual.getLast()).isEqualTo(last);
  }

  public void isEmpty() {
    check("isEmpty()").that(actual.isEmpty()).isTrue();
  }

  public void isNotEmpty() {
    check("isEmpty()").that(actual.isEmpty()).isFalse();
  }

  public void hasSize(int size) {
    check("size()").that(actual.size()).isEqualTo(size);
  }
}
