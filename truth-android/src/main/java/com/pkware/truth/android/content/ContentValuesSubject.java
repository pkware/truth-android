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

import android.content.ContentValues;
import android.support.annotation.NonNull;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link ContentValues} subjects.
 */
public class ContentValuesSubject extends Subject<ContentValuesSubject, ContentValues> {
  protected ContentValuesSubject(FailureStrategy failureStrategy, ContentValues subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<ContentValuesSubject, ContentValues> type() {
    return new SubjectFactory<ContentValuesSubject, ContentValues>() {
      @Override
      public ContentValuesSubject getSubject(FailureStrategy fs, ContentValues that) {
        return new ContentValuesSubject(fs, that);
      }
    };
  }

  public ContentValuesSubject isEmpty() {
    assertThat(actual().size())
        .named("is empty")
        .isEqualTo(0);
    return this;
  }

  public ContentValuesSubject isNotEmpty() {
    assertThat(actual().size())
        .named("is not empty")
        .isGreaterThan(0);
    return this;
  }

  public ContentValuesSubject containsKey(String key) {
    assertThat(actual().containsKey(key))
        .named(String.format(Locale.ENGLISH, "contains key <%s>", key))
        .isTrue();
    return this;
  }

  public ContentValuesSubject containsValue(Object expectedValue) {
    Set<Map.Entry<String, Object>> entries = actual().valueSet();
    List<Object> values = new ArrayList<>(entries.size());
    for (Map.Entry<String, Object> entry : entries) {
      values.add(entry.getValue());
    }
    assertThat(values).contains(expectedValue);
    return this;
  }

  public ContentValuesSubject contains(@NonNull ContentValuesEntry... entries) {
    isNotEmptyOrNull(entries);
    Map<String, Object> actual = new LinkedHashMap<>();
    for (Map.Entry<String, Object> entry : actual().valueSet()) {
      actual.put(entry.getKey(), entry.getValue());
    }

    for (ContentValuesEntry entry : entries) {
      assertThat(actual).containsEntry(entry.getKey(), entry.getValue());
    }
    return this;
  }

  public ContentValuesSubject hasSize(int expected) {
    assertThat(actual().size())
        .named("size")
        .isEqualTo(expected);
    return this;
  }

  private void isNotEmptyOrNull(ContentValuesEntry[] entries) {
    if (entries == null) {
      throw new NullPointerException("The array of entries to look for should not be null");
    }
    if (entries.length == 0) {
      throw new IllegalArgumentException("The array of entries to look for should not be empty");
    }
  }
}
