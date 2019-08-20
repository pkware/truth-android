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
package com.pkware.truth.android.widget;

import android.widget.Adapter;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class AbstractAdapterSubject<T extends Adapter> extends Subject {

  @Nullable
  private final T actual;

  protected AbstractAdapterSubject(@Nonnull FailureMetadata failureMetadata, @Nullable T actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasCount(int count) {
    check("getCount()").that(actual.getCount()).isEqualTo(count);
  }

  public void hasViewTypeCount(int count) {
    check("getViewTypeCount()").that(actual.getViewTypeCount()).isEqualTo(count);
  }

  public void hasStableIds() {
    check("hasStableIds()").that(actual.hasStableIds()).isTrue();
  }

  public void hasUnstableIds() {
    check("hasStableIds()").that(actual.hasStableIds()).isFalse();
  }

  public void isEmpty() {
    check("isEmpty()").that(actual.isEmpty()).isTrue();
  }

  public void isNotEmpty() {
    check("isEmpty()").that(actual.isEmpty()).isFalse();
  }

  public void hasItem(@Nullable Object expected, int index) {
    int count = actual.getCount();
    check("getCount()")
        .withMessage("Index %s is out of bounds. The adapter holds %s items.", index, count)
        .that(count)
        .isGreaterThan(index);

    Object actualItem = actual.getItem(index);
    check("getItem(index)")
        .withMessage("item at index %s", index)
        .that(actualItem)
        .isEqualTo(expected);
  }

  public void doesNotHaveItem(Object notExpected, int index) {
    int count = actual.getCount();
    check("getCount()")
        .withMessage("Index %s is out of bounds. The adapter holds %s items.", index, count)
        .that(count)
        .isGreaterThan(index);

    Object actualItem = actual.getItem(index);
    check("getItem(index)")
        .withMessage("item at index %s", index)
        .that(actualItem)
        .isNotEqualTo(notExpected);
  }
}
