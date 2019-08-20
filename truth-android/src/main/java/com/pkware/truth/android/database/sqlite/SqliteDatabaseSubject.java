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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.os.Build.VERSION_CODES.JELLY_BEAN;

/**
 * Propositions for {@link SQLiteDatabase} subjects.
 */
public class SqliteDatabaseSubject extends Subject {

  @Nullable
  private final SQLiteDatabase actual;

  public SqliteDatabaseSubject(@Nonnull FailureMetadata failureMetadata, @Nullable SQLiteDatabase actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public SqliteDatabaseSubject hasMaximumSize(long size) {
    check("getMaximumSize()").that(actual.getMaximumSize()).isEqualTo(size);
    return this;
  }

  public SqliteDatabaseSubject hasPageSize(long size) {
    check("getPageSize()").that(actual.getPageSize()).isEqualTo(size);
    return this;
  }

  public SqliteDatabaseSubject hasPath(@Nullable String path) {
    check("getPath()").that(actual.getPath()).isEqualTo(path);
    return this;
  }

  public SqliteDatabaseSubject hasVersion(int version) {
    check("getVersion()").that(actual.getVersion()).isEqualTo(version);
    return this;
  }

  public SqliteDatabaseSubject isInTransaction() {
    check("inTransaction()").that(actual.inTransaction()).isTrue();
    return this;
  }

  public SqliteDatabaseSubject isNotInTransaction() {
    check("inTransaction()").that(actual.inTransaction()).isFalse();
    return this;
  }

  public SqliteDatabaseSubject isDatabaseIntegrityOk() {
    check("isDatabaseIntegrityOk()").that(actual.isDatabaseIntegrityOk()).isTrue();
    return this;
  }

  public SqliteDatabaseSubject isDatabaseIntegrityNotOk() {
    check("isDatabaseIntegrityOk()").that(actual.isDatabaseIntegrityOk()).isFalse();
    return this;
  }

  public SqliteDatabaseSubject isLockedByCurrentThread() {
    check("isDbLockedByCurrentThread()").that(actual.isDbLockedByCurrentThread()).isTrue();
    return this;
  }

  public SqliteDatabaseSubject isNotLockedByCurrentThread() {
    check("isDbLockedByCurrentThread()").that(actual.isDbLockedByCurrentThread()).isFalse();
    return this;
  }

  public SqliteDatabaseSubject isOpen() {
    check("isOpen()").that(actual.isOpen()).isTrue();
    return this;
  }

  public SqliteDatabaseSubject isNotOpen() {
    check("isOpen()").that(actual.isOpen()).isFalse();
    return this;
  }

  public SqliteDatabaseSubject isReadOnly() {
    check("isReadOnly()").that(actual.isReadOnly()).isTrue();
    return this;
  }

  public SqliteDatabaseSubject isNotReadOnly() {
    check("isReadOnly()").that(actual.isReadOnly()).isFalse();
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public SqliteDatabaseSubject isWriteAheadLoggingEnabled() {
    check("isWriteAheadLoggingEnabled()").that(actual.isWriteAheadLoggingEnabled()).isTrue();
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public SqliteDatabaseSubject isWriteAheadLoggingDisabled() {
    check("isWriteAheadLoggingEnabled()")
        .that(actual.isWriteAheadLoggingEnabled())
        .isFalse();
    return this;
  }
}
