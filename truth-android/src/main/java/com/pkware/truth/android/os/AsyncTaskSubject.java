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
package com.pkware.truth.android.os;

import android.os.AsyncTask;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link AsyncTask} subjects.
 */
public class AsyncTaskSubject extends Subject {

  @Nullable
  private final AsyncTask actual;

  public AsyncTaskSubject(@Nonnull FailureMetadata failureMetadata, @Nullable AsyncTask actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public AsyncTaskSubject hasStatus(@Nullable AsyncTask.Status status) {
    check("getStatus()").that(actual.getStatus()).isEqualTo(status);
    return this;
  }

  public AsyncTaskSubject isCancelled() {
    check("isCancelled()").that(actual.isCancelled()).isTrue();
    return this;
  }

  public AsyncTaskSubject isNotCancelled() {
    check("isCancelled()").that(actual.isCancelled()).isFalse();
    return this;
  }
}
