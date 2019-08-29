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

import android.content.ContentValues;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.MapSubject;
import com.google.common.truth.Subject;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link ContentValues} subjects.
 */
public class ContentValuesSubject extends Subject {

  @Nullable
  private final ContentValues actual;

  public ContentValuesSubject(@Nonnull FailureMetadata failureMetadata, @Nullable ContentValues actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void containsValue(@Nullable Object expectedValue) {
    Set<Map.Entry<String, Object>> entries = actual.valueSet();
    List<Object> values = new ArrayList<>(entries.size());
    for (Map.Entry<String, Object> entry : entries) {
      values.add(entry.getValue());
    }
    check("valueSet()").that(values).contains(expectedValue);
  }

  public MapSubject asMap() {
    Map<String, Object> actual = new LinkedHashMap<>();
    for (Map.Entry<String, Object> entry : this.actual.valueSet()) {
      actual.put(entry.getKey(), entry.getValue());
    }

    return check("asMap()").that(actual);
  }

  public void hasSize(int expected) {
    check("size()").that(actual.size()).isEqualTo(expected);
  }
}
