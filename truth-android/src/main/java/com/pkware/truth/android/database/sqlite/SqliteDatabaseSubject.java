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
package com.pkware.truth.android.database.sqlite;

import android.annotation.TargetApi;
import android.database.sqlite.SQLiteDatabase;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import static android.os.Build.VERSION_CODES.JELLY_BEAN;
import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link SQLiteDatabase} subjects.
 */
public class SqliteDatabaseSubject extends Subject<SqliteDatabaseSubject, SQLiteDatabase> {
  protected SqliteDatabaseSubject(FailureMetadata failureMetadata, SQLiteDatabase subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<SqliteDatabaseSubject, SQLiteDatabase> type() {
    return new Subject.Factory<SqliteDatabaseSubject, SQLiteDatabase>() {
      @Override
      public SqliteDatabaseSubject createSubject(FailureMetadata fm, SQLiteDatabase that) {
        return new SqliteDatabaseSubject(fm, that);
      }
    };
  }

  public SqliteDatabaseSubject hasMaximumSize(long size) {
    assertThat(actual().getMaximumSize())
        .named("maximum size")
        .isEqualTo(size);
    return this;
  }

  public SqliteDatabaseSubject hasPageSize(long size) {
    assertThat(actual().getPageSize())
        .named("page size")
        .isEqualTo(size);
    return this;
  }

  public SqliteDatabaseSubject hasPath(String path) {
    assertThat(actual().getPath())
        .named("path")
        .isEqualTo(path);
    return this;
  }

  public SqliteDatabaseSubject hasVersion(int version) {
    assertThat(actual().getVersion())
        .named("version")
        .isEqualTo(version);
    return this;
  }

  public SqliteDatabaseSubject isInTransaction() {
    assertThat(actual().inTransaction())
        .named("is in transaction")
        .isTrue();
    return this;
  }

  public SqliteDatabaseSubject isNotInTransaction() {
    assertThat(actual().inTransaction())
        .named("is in transaction")
        .isFalse();
    return this;
  }

  public SqliteDatabaseSubject isDatabaseIntegrityOk() {
    assertThat(actual().isDatabaseIntegrityOk())
        .named("is database integrity ok")
        .isTrue();
    return this;
  }

  public SqliteDatabaseSubject isDatabaseIntegrityNotOk() {
    assertThat(actual().isDatabaseIntegrityOk())
        .named("is database integrity ok")
        .isFalse();
    return this;
  }

  public SqliteDatabaseSubject isLockedByCurrentThread() {
    assertThat(actual().isDbLockedByCurrentThread())
        .named("is locked by current thread")
        .isTrue();
    return this;
  }

  public SqliteDatabaseSubject isNotLockedByCurrentThread() {
    assertThat(actual().isDbLockedByCurrentThread())
        .named("is locked by current thread")
        .isFalse();
    return this;
  }

  public SqliteDatabaseSubject isOpen() {
    assertThat(actual().isOpen())
        .named("is open")
        .isTrue();
    return this;
  }

  public SqliteDatabaseSubject isNotOpen() {
    assertThat(actual().isOpen())
        .named("is open")
        .isFalse();
    return this;
  }

  public SqliteDatabaseSubject isReadOnly() {
    assertThat(actual().isReadOnly())
        .named("is read only")
        .isTrue();
    return this;
  }

  public SqliteDatabaseSubject isNotReadOnly() {
    assertThat(actual().isReadOnly())
        .named("is read only")
        .isFalse();
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public SqliteDatabaseSubject isWriteAheadLoggingEnabled() {
    assertThat(actual().isWriteAheadLoggingEnabled())
        .named("write-ahead logging is enabled")
        .isTrue();
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public SqliteDatabaseSubject isWriteAheadLoggingDisabled() {
    assertThat(!actual().isWriteAheadLoggingEnabled())
        .named("write-ahead logging is disabled")
        .isTrue();
    return this;
  }
}
