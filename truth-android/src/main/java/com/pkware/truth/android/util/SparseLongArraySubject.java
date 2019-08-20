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

import android.annotation.TargetApi;
import android.util.SparseLongArray;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR2;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assert_;

/**
 * Propositions for {@link SparseLongArray} subjects.
 */
@TargetApi(JELLY_BEAN_MR2)
public class SparseLongArraySubject extends Subject<SparseLongArraySubject, SparseLongArray> {
  public SparseLongArraySubject(FailureMetadata failureMetadata, SparseLongArray subject) {
    super(failureMetadata, subject);
  }

  public SparseLongArraySubject hasKey(int key) {
    assert_()
        .withMessage("Expected key <%s> to be present but was not.", key)
        .that(actual().indexOfKey(key))
        .isGreaterThan(-1);
    return this;
  }

  public SparseLongArraySubject doesNotHaveKey(int key) {
    assert_()
        .withMessage("Expected key <%s> to not be present but was.")
        .that(actual().indexOfKey(key))
        .isLessThan(0);
    return this;
  }

  public SparseLongArraySubject hasSize(int size) {
    assertThat(actual().size())
        .named("size")
        .isEqualTo(size);
    return this;
  }
}
