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

import android.content.SharedPreferences;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;

import java.util.Set;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assert_;

public abstract class AbstractSharedPreferencesSubject<S extends AbstractSharedPreferencesSubject<S, T>, T extends SharedPreferences> extends Subject<S, T> {
  protected AbstractSharedPreferencesSubject(FailureStrategy failureStrategy, T subject) {
    super(failureStrategy, subject);
  }

  public S hasKey(String key) {
    assert_()
        .withFailureMessage("Expected key <%s> to be present but it was not.", key)
        .that(getSubject().contains(key))
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S doesNotHaveKey(String key) {
    assert_()
        .withFailureMessage("Expected key <%s> not to be present but it was.", key)
        .that(getSubject().contains(key))
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S contains(String key, String value) {
    assertThat(getSubject().getAll())
        .containsEntry(key, value);
    //noinspection unchecked
    return (S) this;
  }

  public S doesNotContain(String key, String value) {
    assertThat(getSubject().getAll())
        .doesNotContainEntry(key, value);
    //noinspection unchecked
    return (S) this;
  }

  public S contains(String key, int value) {
    assertThat(getSubject().getAll())
        .containsEntry(key, value);
    //noinspection unchecked
    return (S) this;
  }

  public S doesNotContain(String key, int value) {
    assertThat(getSubject().getAll())
        .doesNotContainEntry(key, value);
    //noinspection unchecked
    return (S) this;
  }

  public S contains(String key, boolean value) {
    assertThat(getSubject().getAll())
        .containsEntry(key, value);
    //noinspection unchecked
    return (S) this;
  }

  public S doesNotContain(String key, boolean value) {
    assertThat(getSubject().getAll())
        .doesNotContainEntry(key, value);
    //noinspection unchecked
    return (S) this;
  }

  public S contains(String key, float value) {
    assertThat(getSubject().getAll())
        .containsEntry(key, value);
    //noinspection unchecked
    return (S) this;
  }

  public S doesNotContain(String key, float value) {
    assertThat(getSubject().getAll())
        .doesNotContainEntry(key, value);
    //noinspection unchecked
    return (S) this;
  }

  public S contains(String key, long value) {
    assertThat(getSubject().getAll())
        .containsEntry(key, value);
    //noinspection unchecked
    return (S) this;
  }

  public S doesNotContain(String key, long value) {
    assertThat(getSubject().getAll())
        .doesNotContainEntry(key, value);
    //noinspection unchecked
    return (S) this;
  }

  public S contains(String key, Set<String> value) {
    assertThat(getSubject().getAll())
        .containsEntry(key, value);
    //noinspection unchecked
    return (S) this;
  }

  public S doesNotContain(String key, Set<String> value) {
    assertThat(getSubject().getAll())
        .doesNotContainEntry(key, value);
    //noinspection unchecked
    return (S) this;
  }
}
