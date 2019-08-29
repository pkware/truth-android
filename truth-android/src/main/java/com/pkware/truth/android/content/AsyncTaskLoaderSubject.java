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
package com.pkware.truth.android.content;

import android.annotation.TargetApi;
import android.content.AsyncTaskLoader;

import com.google.common.truth.FailureMetadata;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.os.Build.VERSION_CODES.JELLY_BEAN;

/**
 * Propositions for {@link AsyncTaskLoader} subjects.
 */
public class AsyncTaskLoaderSubject extends AbstractLoaderSubject<AsyncTaskLoader> {

  @Nullable
  private AsyncTaskLoader actual;

  public AsyncTaskLoaderSubject(@Nonnull FailureMetadata failureMetadata, @Nullable AsyncTaskLoader actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  @TargetApi(JELLY_BEAN)
  public void hasLoadInBackgroundCancelled() {
    check("isLoadInBackgroundCanceled()").that(actual.isLoadInBackgroundCanceled()).isTrue();
  }

  @TargetApi(JELLY_BEAN)
  public void hasLoadInBackgroundNotCancelled() {
    check("isLoadInBackgroundCanceled()").that(actual.isLoadInBackgroundCanceled()).isFalse();
  }
}
