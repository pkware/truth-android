/*
 * Copyright 2013 Square, Inc.
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

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public final class ContentValuesEntry {
  private final String key;
  private final Object value;

  private ContentValuesEntry(String key, Object value) {
    this.key = key;
    this.value = value;
  }

  public static ContentValuesEntry entry(String key, Object value) {
    return new ContentValuesEntry(key, value);
  }

  public String getKey() {
    return key;
  }

  public Object getValue() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    ContentValuesEntry that = (ContentValuesEntry) o;

    return Objects.equal(key, that.key) && Objects.equal(value, that.value);

  }

  @Override
  public int hashCode() {
    return Objects.hashCode(key, value);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(ContentValuesEntry.class)
        .add("key", key)
        .add("value", value)
        .toString();
  }
}
