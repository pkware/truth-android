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
package com.pkware.truth.android.app;

import android.app.FragmentTransaction;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link FragmentTransaction} subjects.
 */
public class FragmentTransactionSubject extends Subject<FragmentTransactionSubject, FragmentTransaction> {
  public FragmentTransactionSubject(FailureMetadata failureMetadata, FragmentTransaction subject) {
    super(failureMetadata, subject);
  }

  public FragmentTransactionSubject isAddToBackStackAllowed() {
    assertThat(actual().isAddToBackStackAllowed())
        .named("is add to back stack allowed")
        .isTrue();
    return this;
  }

  public FragmentTransactionSubject isAddToBackStackDisallowed() {
    assertThat(actual().isAddToBackStackAllowed())
        .named("is add to back stack allowed")
        .isFalse();
    return this;
  }

  public FragmentTransactionSubject isEmpty() {
    assertThat(actual().isEmpty())
        .named("is empty")
        .isTrue();
    return this;
  }

  public FragmentTransactionSubject isNotEmpty() {
    assertThat(actual().isEmpty())
        .named("is empty")
        .isFalse();
    return this;
  }
}
