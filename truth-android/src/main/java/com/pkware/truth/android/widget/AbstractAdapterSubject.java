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
package com.pkware.truth.android.widget;

import android.widget.Adapter;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assert_;

public abstract class AbstractAdapterSubject<S extends AbstractAdapterSubject<S, T>, T extends Adapter>
    extends Subject<S, T> {

  protected AbstractAdapterSubject(FailureStrategy failureStrategy, T subject) {
    super(failureStrategy, subject);
  }

  public S hasCount(int count) {
    assertThat(getSubject().getCount())
        .named("count")
        .isEqualTo(count);
    //noinspection unchecked
    return (S) this;
  }

  public S hasViewTypeCount(int count) {
    assertThat(getSubject().getViewTypeCount())
        .named("view type count")
        .isEqualTo(count);
    //noinspection unchecked
    return (S) this;
  }

  public S hasStableIds() {
    assertThat(getSubject().hasStableIds())
        .named("has stable IDs")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S hasUnstableIds() {
    assertThat(getSubject().hasStableIds())
        .named("has stable IDs")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S isEmpty() {
    assertThat(getSubject().isEmpty())
        .named("is empty")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotEmpty() {
    assertThat(getSubject().isEmpty())
        .named("is empty")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S hasItem(Object expected, int index) {
    int count = getSubject().getCount();
    assert_()
        .withFailureMessage("Index %s is out of bounds. The adapter holds %s items.", index, count)
        .that(count)
        .isGreaterThan(index);

    Object actualItem = getSubject().getItem(index);
    assertThat(actualItem)
        .named("item at index " + index)
        .isEqualTo(expected);

    //noinspection unchecked
    return (S) this;
  }

  public S doesNotHaveItem(Object notExpected, int index) {
    int count = getSubject().getCount();
    assert_()
        .withFailureMessage("Index %s is out of bounds. The adapter holds %s items.", index, count)
        .that(count)
        .isGreaterThan(index);

    Object actualItem = getSubject().getItem(index);
    assertThat(actualItem)
        .named("item at index " + index)
        .isNotEqualTo(notExpected);

    //noinspection unchecked
    return (S) this;
  }
}
