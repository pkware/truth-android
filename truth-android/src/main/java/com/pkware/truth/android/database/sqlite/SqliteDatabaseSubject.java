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
package com.pkware.truth.android.database.sqlite;

import android.annotation.TargetApi;
import android.database.sqlite.SQLiteDatabase;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.JELLY_BEAN;
import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link SQLiteDatabase} subjects.
 */
public class SqliteDatabaseSubject extends Subject<SqliteDatabaseSubject, SQLiteDatabase> {
  protected SqliteDatabaseSubject(FailureStrategy failureStrategy, SQLiteDatabase subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<SqliteDatabaseSubject, SQLiteDatabase> type() {
    return new SubjectFactory<SqliteDatabaseSubject, SQLiteDatabase>() {
      @Override
      public SqliteDatabaseSubject getSubject(FailureStrategy fs, SQLiteDatabase that) {
        return new SqliteDatabaseSubject(fs, that);
      }
    };
  }

  public SqliteDatabaseSubject hasMaximumSize(long size) {
    assertThat(getSubject().getMaximumSize())
        .named("maximum size")
        .isEqualTo(size);
    return this;
  }

  public SqliteDatabaseSubject hasPageSize(long size) {
    assertThat(getSubject().getPageSize())
        .named("page size")
        .isEqualTo(size);
    return this;
  }

  public SqliteDatabaseSubject hasPath(String path) {
    assertThat(getSubject().getPath())
        .named("path")
        .isEqualTo(path);
    return this;
  }

  public SqliteDatabaseSubject hasVersion(int version) {
    assertThat(getSubject().getVersion())
        .named("version")
        .isEqualTo(version);
    return this;
  }

  public SqliteDatabaseSubject isInTransaction() {
    assertThat(getSubject().inTransaction())
        .named("is in transaction")
        .isTrue();
    return this;
  }

  public SqliteDatabaseSubject isNotInTransaction() {
    assertThat(getSubject().inTransaction())
        .named("is in transaction")
        .isFalse();
    return this;
  }

  public SqliteDatabaseSubject isDatabaseIntegrityOk() {
    assertThat(getSubject().isDatabaseIntegrityOk())
        .named("is database integrity ok")
        .isTrue();
    return this;
  }

  public SqliteDatabaseSubject isDatabaseIntegrityNotOk() {
    isNotNull();
    assertThat(getSubject().isDatabaseIntegrityOk())
        .named("is database integrity ok")
        .isFalse();
    return this;
  }

  public SqliteDatabaseSubject isLockedByCurrentThread() {
    assertThat(getSubject().isDbLockedByCurrentThread())
        .named("is locked by current thread")
        .isTrue();
    return this;
  }

  public SqliteDatabaseSubject isNotLockedByCurrentThread() {
    assertThat(getSubject().isDbLockedByCurrentThread())
        .named("is locked by current thread")
        .isFalse();
    return this;
  }

  public SqliteDatabaseSubject isOpen() {
    assertThat(getSubject().isOpen())
        .named("is open")
        .isTrue();
    return this;
  }

  public SqliteDatabaseSubject isNotOpen() {
    assertThat(getSubject().isOpen())
        .named("is open")
        .isFalse();
    return this;
  }

  public SqliteDatabaseSubject isReadOnly() {
    assertThat(getSubject().isReadOnly())
        .named("is read only")
        .isTrue();
    return this;
  }

  public SqliteDatabaseSubject isNotReadOnly() {
    assertThat(getSubject().isReadOnly())
        .named("is read only")
        .isFalse();
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public SqliteDatabaseSubject isWriteAheadLoggingEnabled() {
    assertThat(getSubject().isWriteAheadLoggingEnabled())
        .named("write-ahead logging is enabled")
        .isTrue();
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public SqliteDatabaseSubject isWriteAheadLoggingDisabled() {
    assertThat(!getSubject().isWriteAheadLoggingEnabled())
        .named("write-ahead logging is disabled")
        .isTrue();
    return this;
  }
}
