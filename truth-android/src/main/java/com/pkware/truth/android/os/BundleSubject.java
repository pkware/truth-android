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

import android.os.Bundle;
import android.os.Parcelable;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import java.io.Serializable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link Bundle} subjects.
 */
public class BundleSubject extends Subject {

  @Nullable
  private final Bundle actual;

  public BundleSubject(@Nonnull FailureMetadata failureMetadata, @Nullable Bundle actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasKey(@Nonnull String key) {
    check("containsKey(key)")
        .withMessage("Expected to contain key <%s> but did not.", key)
        .that(actual.containsKey(key))
        .isTrue();
  }

  public void hasValue(@Nonnull String key, boolean value) {
    hasKey(key);
    check("getBoolean(key)")
        .withMessage("value for key <%s>", key)
        .that(actual.getBoolean(key))
        .isEqualTo(value);
  }

  public void hasValue(@Nonnull String key, short value) {
    hasKey(key);
    check("getShort(key)")
        .withMessage("value for key <%s>", key)
        .that(actual.getShort(key))
        .isEqualTo(value);
  }

  public void hasValue(@Nonnull String key, int value) {
    hasKey(key);
    check("getInt(key)")
        .withMessage("value for key <%s>", key)
        .that(actual.getInt(key))
        .isEqualTo(value);
  }

  public void hasValue(@Nonnull String key, long value) {
    hasKey(key);
    check("getLong(key)")
        .withMessage("value for key <%s>", key)
        .that(actual.getLong(key))
        .isEqualTo(value);
  }

  public void hasValue(@Nonnull String key, char value) {
    hasKey(key);
    check("getChar(key)")
        .withMessage("value for key <%s>", key)
        .that(actual.getChar(key))
        .isEqualTo(value);
  }

  public void hasValue(@Nonnull String key, byte value) {
    hasKey(key);
    check("getByte(key)")
        .withMessage("value for key <%s>", key)
        .that(actual.getByte(key))
        .isEqualTo(value);
  }

  public void hasValue(@Nonnull String key, @Nullable Parcelable value) {
    hasKey(key);
    check("getParcelable(key)")
        .withMessage("value for key <%s>", key)
        .that((Parcelable) actual.getParcelable(key))
        .isEqualTo(value);
  }

  public void hasValue(@Nonnull String key, @Nullable Serializable value) {
    hasKey(key);
    check("getSerializable(key)")
        .withMessage("value for key <%s>", key)
        .that(actual.getSerializable(key))
        .isEqualTo(value);
  }

  public void hasValue(@Nonnull String key, @Nullable Object value) {
    hasKey(key);
    check("get(key)")
        .withMessage("value for key <%s>", key)
        .that(actual.get(key))
        .isEqualTo(value);
  }

  public void isEmpty() {
    check("isEmpty()").that(actual.isEmpty()).isTrue();
  }

  public void isNotEmpty() {
    check("isEmpty()").that(actual.isEmpty()).isFalse();
  }

  public void hasSize(int size) {
    check("size()").that(actual.size()).isEqualTo(size);
  }
}
