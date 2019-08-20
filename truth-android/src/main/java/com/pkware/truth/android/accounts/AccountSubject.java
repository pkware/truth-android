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
package com.pkware.truth.android.accounts;

import android.accounts.Account;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link Account} subjects.
 */
public final class AccountSubject extends Subject {

  @Nullable
  private final Account actual;

  public AccountSubject(@Nonnull FailureMetadata failureMetadata, @Nullable Account actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public AccountSubject hasName(@Nullable String name) {
    check("name").that(actual.name).isEqualTo(name);
    return this;
  }

  public AccountSubject hasType(@Nullable String type) {
    check("type").that(actual.type).isEqualTo(type);
    return this;
  }
}
