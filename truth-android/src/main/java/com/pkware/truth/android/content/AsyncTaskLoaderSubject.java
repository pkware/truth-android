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
package com.pkware.truth.android.content;

import android.annotation.TargetApi;
import android.content.AsyncTaskLoader;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.JELLY_BEAN;
import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link AsyncTaskLoader} subjects.
 */
public class AsyncTaskLoaderSubject extends AbstractLoaderSubject<AsyncTaskLoaderSubject, AsyncTaskLoader> {

  protected AsyncTaskLoaderSubject(FailureStrategy failureStrategy, AsyncTaskLoader subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<AsyncTaskLoaderSubject, AsyncTaskLoader> type() {
    return new SubjectFactory<AsyncTaskLoaderSubject, AsyncTaskLoader>() {
      @Override
      public AsyncTaskLoaderSubject getSubject(FailureStrategy fs, AsyncTaskLoader that) {
        return new AsyncTaskLoaderSubject(fs, that);
      }
    };
  }

  @TargetApi(JELLY_BEAN)
  public AsyncTaskLoaderSubject hasLoadInBackgroundCancelled() {
    assertThat(actual().isLoadInBackgroundCanceled())
        .named("has load in background cancelled")
        .isTrue();
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public AsyncTaskLoaderSubject hasLoadInBackgroundNotCancelled() {
    assertThat(actual().isLoadInBackgroundCanceled())
        .named("has load in background not cancelled")
        .isFalse();
    return this;
  }
}
