// Copyright 2019 PKWARE, Inc.
//
// This class is generated. Do not modify directly!
package com.pkware.truth.androidx.collection;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static com.google.common.truth.Truth.assertAbout;

/** Assertions for testing Android classes. */
@SuppressWarnings("deprecation")
public final class Assertions {
  @Nonnull
  public static <E> com.pkware.truth.androidx.collection.CircularArraySubject<E> assertThat(
      @Nullable androidx.collection.CircularArray<E> target) {
    return assertAbout(com.pkware.truth.androidx.collection.CircularArraySubject<E>::new).that(target);
  }

  @Nonnull
  public static com.pkware.truth.androidx.collection.LongSparseArraySubject assertThat(
      @Nullable androidx.collection.LongSparseArray target) {
    return assertAbout(com.pkware.truth.androidx.collection.LongSparseArraySubject::new).that(target);
  }

  @Nonnull
  public static <K, V> com.pkware.truth.androidx.collection.LruCacheSubject<K, V> assertThat(
      @Nullable androidx.collection.LruCache<K, V> target) {
    return assertAbout(com.pkware.truth.androidx.collection.LruCacheSubject<K, V>::new).that(target);
  }

  @Nonnull
  public static <E> com.pkware.truth.androidx.collection.SparseArrayCompatSubject<E> assertThat(
      @Nullable androidx.collection.SparseArrayCompat<E> target) {
    return assertAbout(com.pkware.truth.androidx.collection.SparseArrayCompatSubject<E>::new).that(target);
  }

  private Assertions() {
    throw new AssertionError("No instances.");
  }
}
