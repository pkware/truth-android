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
package com.pkware.truth.androidx.fragment.app;

import androidx.fragment.app.FragmentTransaction;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link FragmentTransaction} subjects.
 */
public class FragmentTransactionSubject extends Subject {

  @Nullable
  private final FragmentTransaction actual;

  public FragmentTransactionSubject(@Nonnull FailureMetadata failureMetadata, @Nullable FragmentTransaction actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void isAddToBackStackAllowed() {
    check("isAddToBackStackAllowed()").that(actual.isAddToBackStackAllowed()).isTrue();
  }

  public void isAddToBackStackDisallowed() {
    check("isAddToBackStackAllowed()").that(actual.isAddToBackStackAllowed()).isFalse();
  }

  public void isEmpty() {
    check("isEmpty()").that(actual.isEmpty()).isTrue();
  }

  public void isNotEmpty() {
    check("isEmpty()").that(actual.isEmpty()).isFalse();
  }
}
