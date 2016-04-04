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
package com.pkware.truth.android.util;

import android.annotation.TargetApi;
import android.util.SparseIntArray;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR2;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assert_;

/**
 * Propositions for {@link SparseIntArray} subjects.
 */
@TargetApi(JELLY_BEAN_MR2)
public class SparseIntArraySubject extends Subject<SparseIntArraySubject, SparseIntArray> {
  protected SparseIntArraySubject(FailureStrategy failureStrategy, SparseIntArray subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<SparseIntArraySubject, SparseIntArray> type() {
    return new SubjectFactory<SparseIntArraySubject, SparseIntArray>() {
      @Override
      public SparseIntArraySubject getSubject(FailureStrategy fs, SparseIntArray that) {
        return new SparseIntArraySubject(fs, that);
      }
    };
  }

  public SparseIntArraySubject hasKey(int key) {
    assert_()
        .withFailureMessage("Expected key <%s> to be present but was not.", key)
        .that(getSubject().indexOfKey(key))
        .isGreaterThan(-1);
    return this;
  }

  public SparseIntArraySubject doesNotHaveKey(int key) {
    assert_()
        .withFailureMessage("Expected key <%s> to not be present but was.")
        .that(getSubject().indexOfKey(key))
        .isLessThan(0);
    return this;
  }

  public SparseIntArraySubject hasSize(int size) {
    assertThat(getSubject().size())
        .named("size")
        .isEqualTo(size);
    return this;
  }
}