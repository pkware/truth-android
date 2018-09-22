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

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link AsyncTask} subjects.
 */
public class AsyncTaskSubject extends Subject<AsyncTaskSubject, AsyncTask> {
  protected AsyncTaskSubject(FailureMetadata failureMetadata, AsyncTask subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<AsyncTaskSubject, AsyncTask> type() {
    return new Subject.Factory<AsyncTaskSubject, AsyncTask>() {
      @Override
      public AsyncTaskSubject createSubject(FailureMetadata fm, AsyncTask that) {
        return new AsyncTaskSubject(fm, that);
      }
    };
  }

  public AsyncTaskSubject hasStatus(AsyncTask.Status status) {
    assertThat(actual().getStatus())
        .named("status")
        .isEqualTo(status);
    return this;
  }

  public AsyncTaskSubject isCancelled() {
    assertThat(actual().isCancelled())
        .named("is cancelled")
        .isTrue();
    return this;
  }

  public AsyncTaskSubject isNotCancelled() {
    assertThat(actual().isCancelled())
        .named("is not cancelled")
        .isFalse();
    return this;
  }
}
