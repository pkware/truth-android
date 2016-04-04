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
package com.pkware.truth.android.support.v4.util;

import android.support.v4.util.CircularArray;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link CircularArray} subjects.
 */
public class CircularArraySubject<E>
    extends Subject<CircularArraySubject<E>, CircularArray<E>> {
  protected CircularArraySubject(FailureStrategy failureStrategy, CircularArray<E> subject) {
    super(failureStrategy, subject);
  }

  public static <E> SubjectFactory<CircularArraySubject<E>, CircularArray<E>> type() {
    return new SubjectFactory<CircularArraySubject<E>, CircularArray<E>>() {
      @Override
      public CircularArraySubject<E> getSubject(FailureStrategy fs, CircularArray<E> that) {
        return new CircularArraySubject<E>(fs, that);
      }
    };
  }

  public CircularArraySubject<E> hasFirst(E first) {
    assertThat(getSubject().getFirst())
        .named("first element")
        .isEqualTo(first);
    return this;
  }

  public CircularArraySubject<E> hasLast(E last) {
    assertThat(getSubject().getLast())
        .named("last element")
        .isEqualTo(last);
    return this;
  }

  public CircularArraySubject<E> isEmpty() {
    assertThat(getSubject().isEmpty())
        .named("is empty")
        .isTrue();
    return this;
  }

  public CircularArraySubject<E> isNotEmpty() {
    assertThat(getSubject().isEmpty())
        .named("is empty")
        .isFalse();
    return this;
  }

  public CircularArraySubject<E> hasSize(int size) {
    assertThat(getSubject().size())
        .named("size")
        .isEqualTo(size);
    return this;
  }
}
