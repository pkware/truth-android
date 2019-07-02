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
package com.pkware.truth.androidx.legacy.v4.collection;

import androidx.collection.LruCache;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link LruCache} subjects.
 */
public class LruCacheSubject<K, V> extends Subject<LruCacheSubject<K, V>, LruCache<K, V>> {
  protected LruCacheSubject(FailureMetadata failureMetadata, LruCache<K, V> subject) {
    super(failureMetadata, subject);
  }

  public static <K, V> Subject.Factory<LruCacheSubject<K, V>, LruCache<K, V>> type() {
    return LruCacheSubject::new;
  }

  public LruCacheSubject<K, V> hasEntry(K key) {
    assertThat(actual().snapshot())
        .containsKey(key);
    return this;
  }

  public LruCacheSubject<K, V> hasCreateCount(int count) {
    assertThat(actual().createCount())
        .named("create count")
        .isEqualTo(count);
    return this;
  }

  public LruCacheSubject<K, V> hasEvictionCount(int count) {
    assertThat(actual().evictionCount())
        .named("eviction count")
        .isEqualTo(count);
    return this;
  }

  public LruCacheSubject<K, V> hasHitCount(int count) {
    assertThat(actual().hitCount())
        .named("hit count")
        .isEqualTo(count);
    return this;
  }

  public LruCacheSubject<K, V> hasMaxSize(int size) {
    assertThat(actual().maxSize())
        .named("max size")
        .isEqualTo(size);
    return this;
  }

  public LruCacheSubject<K, V> hasMissCount(int count) {
    assertThat(actual().missCount())
        .named("miss count")
        .isEqualTo(count);
    return this;
  }

  public LruCacheSubject<K, V> hasPutCount(int count) {
    assertThat(actual().putCount())
        .named("put count")
        .isEqualTo(count);
    return this;
  }

  public LruCacheSubject<K, V> hasSize(int size) {
    assertThat(actual().size())
        .named("size")
        .isEqualTo(size);
    return this;
  }
}
