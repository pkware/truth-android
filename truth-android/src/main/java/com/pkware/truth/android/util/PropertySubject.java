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
package com.pkware.truth.android.util;

import android.util.Property;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link Property} subjects.
 */
public class PropertySubject<T, V> extends Subject<PropertySubject<T, V>, Property<T, V>> {
  protected PropertySubject(FailureStrategy failureStrategy, Property<T, V> subject) {
    super(failureStrategy, subject);
  }

  public static <T, V> SubjectFactory<PropertySubject<T, V>, Property<T, V>> type() {
    return new SubjectFactory<PropertySubject<T, V>, Property<T, V>>() {
      @Override
      public PropertySubject<T, V> getSubject(FailureStrategy fs, Property<T, V> that) {
        return new PropertySubject<T, V>(fs, that);
      }
    };
  }

  public PropertySubject<T, V> hasName(String name) {
    assertThat(getSubject().getName())
        .named("name")
        .isEqualTo(name);
    return this;
  }

  public PropertySubject<T, V> hasType(Class<?> type) {
    assertThat(getSubject().getType())
        .named("type")
        .isEqualTo(type);
    return this;
  }

  public PropertySubject<T, V> isReadOnly() {
    assertThat(getSubject().isReadOnly())
        .named("is read only")
        .isTrue();
    return this;
  }

  public PropertySubject<T, V> isNotReadOnly() {
    assertThat(getSubject().isReadOnly())
        .named("is read only")
        .isFalse();
    return this;
  }
}
