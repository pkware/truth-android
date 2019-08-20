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

import android.content.Loader;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class AbstractLoaderSubject<T extends Loader> extends Subject {

  @Nullable
  private final T actual;

  protected AbstractLoaderSubject(@Nonnull FailureMetadata failureMetadata, @Nullable T actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasId(int id) {
    check("getId()").that(actual.getId()).isEqualTo(id);
  }

  public void isAbandoned() {
    check("isAbandoned()").that(actual.isAbandoned()).isTrue();
  }

  public void isNotAbandoned() {
    check("isAbandoned()").that(actual.isAbandoned()).isFalse();
  }

  public void isReset() {
    check("isReset()").that(actual.isReset()).isTrue();
  }

  public void isNotReset() {
    check("isReset()").that(actual.isReset()).isFalse();
  }

  public void isStarted() {
    check("isStarted()").that(actual.isStarted()).isTrue();
  }

  public void isNotStarted() {
    check("isStarted()").that(actual.isStarted()).isFalse();
  }
}
