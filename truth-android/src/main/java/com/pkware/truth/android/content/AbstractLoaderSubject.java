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

import android.content.Loader;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;

import static com.google.common.truth.Truth.assertThat;

public abstract class AbstractLoaderSubject<S extends AbstractLoaderSubject<S, T>, T extends Loader> extends Subject<S, T> {
  protected AbstractLoaderSubject(FailureStrategy failureStrategy, T subject) {
    super(failureStrategy, subject);
  }

  public S hasId(int id) {
    assertThat(getSubject().getId())
        .named("id")
        .isEqualTo(id);
    //noinspection unchecked
    return (S) this;
  }

  public S isAbandoned() {
    assertThat(getSubject().isAbandoned())
        .named("is abandoned")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotAbandoned() {
    assertThat(getSubject().isAbandoned())
        .named("is abandoned")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S isReset() {
    assertThat(getSubject().isReset())
        .named("is reset")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotReset() {
    assertThat(getSubject().isReset())
        .named("is reset")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S isStarted() {
    assertThat(getSubject().isStarted())
        .named("is started")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotStarted() {
    assertThat(getSubject().isStarted())
        .named("is started")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }
}
