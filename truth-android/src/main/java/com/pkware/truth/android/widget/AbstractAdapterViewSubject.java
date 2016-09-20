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

import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;

import com.google.common.truth.FailureStrategy;
import com.pkware.truth.android.view.AbstractViewGroupSubject;

import static com.google.common.truth.Truth.assertThat;

public abstract class AbstractAdapterViewSubject<S extends AbstractAdapterViewSubject<S, T>, T extends AdapterView>
    extends AbstractViewGroupSubject<S, T> {
  protected AbstractAdapterViewSubject(FailureStrategy failureStrategy, T subject) {
    super(failureStrategy, subject);
  }

  public S hasAdapter(Adapter adapter) {
    assertThat(actual().getAdapter())
        .named("adapter")
        .isSameAs(adapter);
    //noinspection unchecked
    return (S) this;
  }

  public S hasCount(int count) {
    assertThat(actual().getCount())
        .named("count")
        .isEqualTo(count);
    //noinspection unchecked
    return (S) this;
  }

  public S hasFirstVisiblePosition(int position) {
    assertThat(actual().getFirstVisiblePosition())
        .named("first visible position")
        .isEqualTo(position);
    //noinspection unchecked
    return (S) this;
  }

  public S hasItemAtPosition(int position, Object item) {
    assertThat(actual().getItemAtPosition(position))
        .named("item at positions " + position)
        .isEqualTo(item);
    //noinspection unchecked
    return (S) this;
  }

  public S hasItemIdAtPosition(int position, long id) {
    assertThat(actual().getItemIdAtPosition(position))
        .named("ID for item at position " + position)
        .isEqualTo(id);
    //noinspection unchecked
    return (S) this;
  }

  public S hasLastVisiblePosition(int position) {
    assertThat(actual().getLastVisiblePosition())
        .named("last visible position")
        .isEqualTo(position);
    //noinspection unchecked
    return (S) this;
  }

  public S hasPositionForView(View view, int position) {
    assertThat(actual().getPositionForView(view))
        .named("position for view")
        .isEqualTo(position);
    //noinspection unchecked
    return (S) this;
  }

  public S hasSelectedItem(Object item) {
    assertThat(actual().getSelectedItem())
        .named("selected item")
        .isEqualTo(item);
    //noinspection unchecked
    return (S) this;
  }

  public S hasSelectedItemId(long id) {
    assertThat(actual().getSelectedItemId())
        .named("selected item ID")
        .isEqualTo(id);
    //noinspection unchecked
    return (S) this;
  }

  public S hasSelectedItemPosition(int position) {
    assertThat(actual().getSelectedItemPosition())
        .named("selected item position")
        .isEqualTo(position);
    //noinspection unchecked
    return (S) this;
  }

  public S hasSelectedView(View view) {
    assertThat(actual().getSelectedView())
        .named("selected view")
        .isSameAs(view);
    //noinspection unchecked
    return (S) this;
  }
}
