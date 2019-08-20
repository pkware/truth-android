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
package com.pkware.truth.android.database;

import android.database.Cursor;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class AbstractCursorSubject<T extends Cursor> extends Subject {

  @Nullable
  private final T actual;

  protected AbstractCursorSubject(@Nonnull FailureMetadata failureMetadata, @Nullable T actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasColumnCount(int count) {
    check("getColumnCount()").that(actual.getColumnCount()).isEqualTo(count);
  }

  public void hasColumn(@Nonnull String name) {
    check("getColumnNames()").that(actual.getColumnNames()).asList().contains(name);
  }

  public void hasColumns(@Nonnull String... names) {
    check("getColumnNames()").that(actual.getColumnNames()).asList().containsAtLeastElementsIn(names);
  }

  public void hasCount(int count) {
    check("getCount()").that(actual.getCount()).isEqualTo(count);
  }

  public void hasPosition(int position) {
    check("getPosition()").that(actual.getPosition()).isEqualTo(position);
  }

  public void isAfterLast() {
    check("isAfterLast()").that(actual.isAfterLast()).isTrue();
  }

  public void isNotAfterLast() {
    check("isAfterLast()").that(actual.isAfterLast()).isFalse();
  }

  public void isBeforeFirst() {
    check("isBeforeFirst()").that(actual.isBeforeFirst()).isTrue();
  }

  public void isNotBeforeFirst() {
    check("isBeforeFirst()").that(actual.isBeforeFirst()).isFalse();
  }

  public void isClosed() {
    check("isClosed()").that(actual.isClosed()).isTrue();
  }

  public void isNotClosed() {
    check("isClosed()").that(actual.isClosed()).isFalse();
  }

  public void isFirst() {
    check("isFirst()").that(actual.isFirst()).isTrue();
  }

  public void isNotFirst() {
    check("isFirst()").that(actual.isFirst()).isFalse();
  }

  public void isLast() {
    check("isLast()").that(actual.isLast()).isTrue();
  }

  public void isNotLast() {
    check("isLast()").that(actual.isLast()).isFalse();
  }
}
