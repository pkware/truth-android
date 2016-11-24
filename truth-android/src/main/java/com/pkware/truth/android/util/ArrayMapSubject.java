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

import android.annotation.TargetApi;
import android.util.ArrayMap;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.MapSubject;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.KITKAT;
import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link ArrayMap} subjects.
 */
@TargetApi(KITKAT)
public class ArrayMapSubject<K, V> extends Subject<ArrayMapSubject<K, V>, ArrayMap<K, V>> {
  protected ArrayMapSubject(FailureStrategy failureStrategy, ArrayMap<K, V> subject) {
    super(failureStrategy, subject);
  }

  public static <K, V> SubjectFactory<ArrayMapSubject<K, V>, ArrayMap<K, V>> type() {
    return new SubjectFactory<ArrayMapSubject<K, V>, ArrayMap<K, V>>() {
      @Override
      public ArrayMapSubject<K, V> getSubject(FailureStrategy fs, ArrayMap<K, V> that) {
        return new ArrayMapSubject<K, V>(fs, that);
      }
    };
  }

  public ArrayMapSubject<K, V> hasKeyAt(int index, K key) {
    assertThat(actual().keyAt(index))
        .named("key at index " + index)
        .isEqualTo(key);
    return this;
  }

  public ArrayMapSubject<K, V> hasValueAt(int index, V value) {
    assertThat(actual().valueAt(index))
        .named("value at index " + index)
        .isEqualTo(value);
    return this;
  }

  public MapSubject asMap() {
    return assertThat(actual());
  }
}
