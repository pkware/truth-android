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
package com.pkware.truth.android.support.v4.util;

import android.support.v4.util.LruCache;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link LruCache} subjects.
 */
public class LruCacheSubject<K, V> extends Subject<LruCacheSubject<K, V>, LruCache<K, V>> {
  protected LruCacheSubject(FailureStrategy failureStrategy, LruCache<K, V> subject) {
    super(failureStrategy, subject);
  }

  public static <K, V> SubjectFactory<LruCacheSubject<K, V>, LruCache<K, V>> type() {
    return new SubjectFactory<LruCacheSubject<K, V>, LruCache<K, V>>() {
      @Override
      public LruCacheSubject<K, V> getSubject(FailureStrategy fs, LruCache<K, V> that) {
        return new LruCacheSubject<K, V>(fs, that);
      }
    };
  }

  public LruCacheSubject<K, V> hasEntry(K key) {
    assertThat(getSubject().snapshot())
        .containsKey(key);
    return this;
  }

  public LruCacheSubject<K, V> hasCreateCount(int count) {
    assertThat(getSubject().createCount())
        .named("create count")
        .isEqualTo(count);
    return this;
  }

  public LruCacheSubject<K, V> hasEvictionCount(int count) {
    assertThat(getSubject().evictionCount())
        .named("eviction count")
        .isEqualTo(count);
    return this;
  }

  public LruCacheSubject<K, V> hasHitCount(int count) {
    assertThat(getSubject().hitCount())
        .named("hit count")
        .isEqualTo(count);
    return this;
  }

  public LruCacheSubject<K, V> hasMaxSize(int size) {
    assertThat(getSubject().maxSize())
        .named("max size")
        .isEqualTo(size);
    return this;
  }

  public LruCacheSubject<K, V> hasMissCount(int count) {
    assertThat(getSubject().missCount())
        .named("miss count")
        .isEqualTo(count);
    return this;
  }

  public LruCacheSubject<K, V> hasPutCount(int count) {
    assertThat(getSubject().putCount())
        .named("put count")
        .isEqualTo(count);
    return this;
  }

  public LruCacheSubject<K, V> hasSize(int size) {
    assertThat(getSubject().size())
        .named("size")
        .isEqualTo(size);
    return this;
  }
}
