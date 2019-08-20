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
package com.pkware.truth.android.util;

import android.util.Property;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link Property} subjects.
 */
public class PropertySubject<T, V> extends Subject<PropertySubject<T, V>, Property<T, V>> {
  public PropertySubject(FailureMetadata failureMetadata, Property<T, V> subject) {
    super(failureMetadata, subject);
  }

  public PropertySubject<T, V> hasName(String name) {
    assertThat(actual().getName())
        .named("name")
        .isEqualTo(name);
    return this;
  }

  public PropertySubject<T, V> hasType(Class<?> type) {
    assertThat(actual().getType())
        .named("type")
        .isEqualTo(type);
    return this;
  }

  public PropertySubject<T, V> isReadOnly() {
    assertThat(actual().isReadOnly())
        .named("is read only")
        .isTrue();
    return this;
  }

  public PropertySubject<T, V> isNotReadOnly() {
    assertThat(actual().isReadOnly())
        .named("is read only")
        .isFalse();
    return this;
  }
}
