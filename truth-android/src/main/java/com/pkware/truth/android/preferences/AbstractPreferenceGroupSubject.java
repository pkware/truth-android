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
package com.pkware.truth.android.preferences;

import android.preference.PreferenceGroup;

import com.google.common.truth.FailureStrategy;

import static com.google.common.truth.Truth.assertThat;

public abstract class AbstractPreferenceGroupSubject<S extends AbstractPreferenceGroupSubject<S, T>, T extends PreferenceGroup>
    extends AbstractPreferenceSubject<S, T> {
  protected AbstractPreferenceGroupSubject(FailureStrategy failureStrategy, T subject) {
    super(failureStrategy, subject);
  }

  public S hasPreferenceCount(int count) {
    assertThat(getSubject().getPreferenceCount())
        .named("preference count")
        .isEqualTo(count);
    //noinspection unchecked
    return (S) this;
  }

  public S isOrderingAsAdded() {
    assertThat(getSubject().isOrderingAsAdded())
        .named("is ordering as added")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotOrderingAsAdded() {
    assertThat(getSubject().isOrderingAsAdded())
        .named("is ordering as added")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }
}
