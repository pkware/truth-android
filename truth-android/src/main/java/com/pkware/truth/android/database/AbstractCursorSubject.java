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
package com.pkware.truth.android.database;

import android.database.Cursor;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;

import java.util.Arrays;

import static com.google.common.truth.Truth.assertThat;

public abstract class AbstractCursorSubject<S extends AbstractCursorSubject<S, T>, T extends Cursor> extends Subject<S, T> {
  protected AbstractCursorSubject(FailureStrategy failureStrategy, T subject) {
    super(failureStrategy, subject);
  }

  public S hasColumnCount(int count) {
    assertThat(getSubject().getColumnCount())
        .named("column count")
        .isEqualTo(count);
    //noinspection unchecked
    return (S) this;
  }

  public S hasColumn(String name) {
    assertThat(getSubject().getColumnNames())
        .asList()
        .named("columns")
        .contains(name);
    //noinspection unchecked
    return (S) this;
  }

  public S hasColumns(String... names) {
    assertThat(getSubject().getColumnNames())
        .asList()
        .named("columns")
        .containsAllIn(Arrays.asList(names));
    //noinspection unchecked
    return (S) this;
  }

  public S hasCount(int count) {
    assertThat(getSubject().getCount())
        .named("count")
        .isEqualTo(count);
    //noinspection unchecked
    return (S) this;
  }

  public S hasPosition(int position) {
    assertThat(getSubject().getPosition())
        .named("position")
        .isEqualTo(position);
    //noinspection unchecked
    return (S) this;
  }

  public S isAfterLast() {
    assertThat(getSubject().isAfterLast())
        .named("is after last")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotAfterLast() {
    assertThat(getSubject().isAfterLast())
        .named("is after last")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S isBeforeFirst() {
    assertThat(getSubject().isBeforeFirst())
        .named("is before first")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotBeforeFirst() {
    assertThat(getSubject().isBeforeFirst())
        .named("is before first")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S isClosed() {
    assertThat(getSubject().isClosed())
        .named("is closed")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotClosed() {
    assertThat(getSubject().isClosed())
        .named("is closed")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S isFirst() {
    assertThat(getSubject().isFirst())
        .named("is first")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotFirst() {
    assertThat(getSubject().isFirst())
        .named("is first")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S isLast() {
    assertThat(getSubject().isLast())
        .named("is last")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotLast() {
    assertThat(getSubject().isLast())
        .named("is last")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }
}
