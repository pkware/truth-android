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
import com.google.common.truth.MapSubject;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link LruCache} subjects.
 */
public class LruCacheSubject<K, V> extends Subject {

  @Nullable
  private final LruCache<K, V> actual;

  public LruCacheSubject(@Nonnull FailureMetadata failureMetadata, @Nullable LruCache<K, V> actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public MapSubject asMap() {
    return check("snapshot()").that(actual.snapshot());
  }

  public LruCacheSubject<K, V> hasCreateCount(int count) {
    check("createCount()").that(actual.createCount()).isEqualTo(count);
    return this;
  }

  public LruCacheSubject<K, V> hasEvictionCount(int count) {
    check("evictionCount()").that(actual.evictionCount()).isEqualTo(count);
    return this;
  }

  public LruCacheSubject<K, V> hasHitCount(int count) {
    check("hitCount()").that(actual.hitCount()).isEqualTo(count);
    return this;
  }

  public LruCacheSubject<K, V> hasMaxSize(int size) {
    check("maxSize()").that(actual.maxSize()).isEqualTo(size);
    return this;
  }

  public LruCacheSubject<K, V> hasMissCount(int count) {
    check("missCount()").that(actual.missCount()).isEqualTo(count);
    return this;
  }

  public LruCacheSubject<K, V> hasPutCount(int count) {
    check("putCount()").that(actual.putCount()).isEqualTo(count);
    return this;
  }

  public LruCacheSubject<K, V> hasSize(int size) {
    check("size()").that(actual.size()).isEqualTo(size);
    return this;
  }
}
