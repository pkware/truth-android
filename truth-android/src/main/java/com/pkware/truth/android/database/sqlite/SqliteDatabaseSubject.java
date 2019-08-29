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

  public void hasMaximumSize(long size) {
    check("getMaximumSize()").that(actual.getMaximumSize()).isEqualTo(size);
  }

  public void hasPageSize(long size) {
    check("getPageSize()").that(actual.getPageSize()).isEqualTo(size);
  }

  public void hasPath(@Nullable String path) {
    check("getPath()").that(actual.getPath()).isEqualTo(path);
  }

  public void hasVersion(int version) {
    check("getVersion()").that(actual.getVersion()).isEqualTo(version);
  }

  public void isInTransaction() {
    check("inTransaction()").that(actual.inTransaction()).isTrue();
  }

  public void isNotInTransaction() {
    check("inTransaction()").that(actual.inTransaction()).isFalse();
  }

  public void isDatabaseIntegrityOk() {
    check("isDatabaseIntegrityOk()").that(actual.isDatabaseIntegrityOk()).isTrue();
  }

  public void isDatabaseIntegrityNotOk() {
    check("isDatabaseIntegrityOk()").that(actual.isDatabaseIntegrityOk()).isFalse();
  }

  public void isLockedByCurrentThread() {
    check("isDbLockedByCurrentThread()").that(actual.isDbLockedByCurrentThread()).isTrue();
  }

  public void isNotLockedByCurrentThread() {
    check("isDbLockedByCurrentThread()").that(actual.isDbLockedByCurrentThread()).isFalse();
  }

  public void isOpen() {
    check("isOpen()").that(actual.isOpen()).isTrue();
  }

  public void isNotOpen() {
    check("isOpen()").that(actual.isOpen()).isFalse();
  }

  public void isReadOnly() {
    check("isReadOnly()").that(actual.isReadOnly()).isTrue();
  }

  public void isNotReadOnly() {
    check("isReadOnly()").that(actual.isReadOnly()).isFalse();
  }

  @TargetApi(JELLY_BEAN)
  public void isWriteAheadLoggingEnabled() {
    check("isWriteAheadLoggingEnabled()").that(actual.isWriteAheadLoggingEnabled()).isTrue();
  }

  @TargetApi(JELLY_BEAN)
  public void isWriteAheadLoggingDisabled() {
    check("isWriteAheadLoggingEnabled()")
        .that(actual.isWriteAheadLoggingEnabled())
        .isFalse();
  }
}
