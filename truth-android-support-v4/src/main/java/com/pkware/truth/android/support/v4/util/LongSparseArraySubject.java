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

import android.support.v4.util.LongSparseArray;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assert_;

/**
 * Propositions for {@link LongSparseArray} subjects.
 */
public class LongSparseArraySubject extends Subject<LongSparseArraySubject, LongSparseArray> {
  protected LongSparseArraySubject(FailureStrategy failureStrategy, LongSparseArray subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<LongSparseArraySubject, LongSparseArray> type() {
    return new SubjectFactory<LongSparseArraySubject, LongSparseArray>() {
      @Override
      public LongSparseArraySubject getSubject(FailureStrategy fs, LongSparseArray that) {
        return new LongSparseArraySubject(fs, that);
      }
    };
  }

  public LongSparseArraySubject hasKey(int key) {
    assert_()
        .withFailureMessage("Expected key <%s> to be present but was not.", key)
        .that(actual().indexOfKey(key))
        .isGreaterThan(-1);
    return this;
  }

  public LongSparseArraySubject doesNotHaveKey(int key) {
    assert_()
        .withFailureMessage("Expected key <%s> to not be present but was.")
        .that(actual().indexOfKey(key))
        .isLessThan(0);
    return this;
  }

  public LongSparseArraySubject hasSize(int size) {
    assertThat(actual().size())
        .named("size")
        .isEqualTo(size);
    return this;
  }
}
