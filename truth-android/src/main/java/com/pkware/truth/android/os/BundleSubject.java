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
import java.util.Locale;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assert_;

/**
 * Propositions for {@link Bundle} subjects.
 */
//TODO consider adding hasValue for array types
public class BundleSubject extends Subject<BundleSubject, Bundle> {
  protected BundleSubject(FailureMetadata failureMetadata, Bundle subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<BundleSubject, Bundle> type() {
    return BundleSubject::new;
  }

  public BundleSubject hasKey(String key) {
    assert_()
        .withMessage("Expected to contain key <%s> but did not.", key)
        .that(actual().containsKey(key))
        .isTrue();
    return this;
  }

  public BundleSubject hasValue(String key, boolean value) {
    hasKey(key);
    assertThat(actual().getBoolean(key))
        .named(String.format(Locale.ENGLISH, "value for key <%s>", key))
        .isEqualTo(value);
    return this;
  }

  public BundleSubject hasValue(String key, short value) {
    hasKey(key);
    assertThat(actual().getShort(key))
        .named(String.format(Locale.ENGLISH, "value for key <%s>", key))
        .isEqualTo(value);
    return this;
  }

  public BundleSubject hasValue(String key, int value) {
    hasKey(key);
    assertThat(actual().getInt(key))
        .named(String.format(Locale.ENGLISH, "value for key <%s>", key))
        .isEqualTo(value);
    return this;
  }

  public BundleSubject hasValue(String key, long value) {
    hasKey(key);
    assertThat(actual().getLong(key))
        .named(String.format(Locale.ENGLISH, "value for key <%s>", key))
        .isEqualTo(value);
    return this;
  }

  public BundleSubject hasValue(String key, char value) {
    hasKey(key);
    assertThat(actual().getChar(key))
        .named(String.format(Locale.ENGLISH, "value for key <%s>", key))
        .isEqualTo(value);
    return this;
  }

  public BundleSubject hasValue(String key, byte value) {
    hasKey(key);
    assertThat(actual().getByte(key))
        .named(String.format(Locale.ENGLISH, "value for key <%s>", key))
        .isEqualTo(value);
    return this;
  }

  public BundleSubject hasValue(String key, Parcelable value) {
    hasKey(key);
    assertThat((Parcelable) actual().getParcelable(key))
        .named(String.format(Locale.ENGLISH, "value for key <%s>", key))
        .isEqualTo(value);
    return this;
  }

  public BundleSubject hasValue(String key, Serializable value) {
    hasKey(key);
    assertThat(actual().getSerializable(key))
        .named(String.format(Locale.ENGLISH, "value for key <%s>", key))
        .isEqualTo(value);
    return this;
  }

  public BundleSubject hasValue(String key, Object value) {
    hasKey(key);
    assertThat(actual().get(key))
        .named(String.format(Locale.ENGLISH, "value for key <%s>", key))
        .isEqualTo(value);
    return this;
  }

  public BundleSubject isEmpty() {
    assertThat(actual().isEmpty())
        .named("is empty")
        .isTrue();
    return this;
  }

  public BundleSubject isNotEmpty() {
    assertThat(actual().isEmpty())
        .named("is empty")
        .isFalse();
    return this;
  }

  public BundleSubject hasSize(int size) {
    assertThat(actual().size())
        .named("size")
        .isEqualTo(size);
    return this;
  }
}
