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
import android.util.SparseIntArray;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR2;

/**
 * Propositions for {@link SparseIntArray} subjects.
 */
@TargetApi(JELLY_BEAN_MR2)
public class SparseIntArraySubject extends Subject {

  @Nullable
  private final SparseIntArray actual;

  public SparseIntArraySubject(@Nonnull FailureMetadata failureMetadata, @Nullable SparseIntArray actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public SparseIntArraySubject hasKey(int key) {
    check("indexOfKey(key)")
        .withMessage("Expected key <%s> to be present but was not.", key)
        .that(actual.indexOfKey(key))
        .isGreaterThan(-1);
    return this;
  }

  public SparseIntArraySubject doesNotHaveKey(int key) {
    check("indexOfKey(key)")
        .withMessage("Expected key <%s> to not be present but was.", key)
        .that(actual.indexOfKey(key))
        .isLessThan(0);
    return this;
  }

  public SparseIntArraySubject hasSize(int size) {
    check("size()").that(actual.size()).isEqualTo(size);
    return this;
  }
}
