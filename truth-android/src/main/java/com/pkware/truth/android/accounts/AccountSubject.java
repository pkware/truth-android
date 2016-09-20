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
package com.pkware.truth.android.accounts;

import android.accounts.Account;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link Account} subjects.
 */
public class AccountSubject extends Subject<AccountSubject, Account> {
  private AccountSubject(FailureStrategy failureStrategy, Account subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<AccountSubject, Account> type() {
    return new SubjectFactory<AccountSubject, Account>() {
      @Override
      public AccountSubject getSubject(FailureStrategy fs, Account that) {
        return new AccountSubject(fs, that);
      }
    };
  }

  public AccountSubject hasName(String name) {
    assertThat(actual().name)
        .named("name")
        .isEqualTo(name);
    return this;
  }

  public AccountSubject hasType(String type) {
    assertThat(actual().type)
        .named("type")
        .isEqualTo(type);
    return this;
  }
}
