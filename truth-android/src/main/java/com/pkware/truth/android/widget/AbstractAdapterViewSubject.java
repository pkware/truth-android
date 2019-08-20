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

import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;

import com.google.common.truth.FailureMetadata;
import com.pkware.truth.android.view.AbstractViewGroupSubject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class AbstractAdapterViewSubject<T extends AdapterView>
    extends AbstractViewGroupSubject<T> {

  @Nullable
  private final T actual;

  protected AbstractAdapterViewSubject(@Nonnull FailureMetadata failureMetadata, @Nullable T actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasAdapter(@Nullable Adapter adapter) {
    check("getAdapter()").that(actual.getAdapter()).isSameInstanceAs(adapter);
  }

  public void hasCount(int count) {
    check("getCount()").that(actual.getCount()).isEqualTo(count);
  }

  public void hasFirstVisiblePosition(int position) {
    check("getFirstVisiblePosition()").that(actual.getFirstVisiblePosition()).isEqualTo(position);
  }

  public void hasItemAtPosition(int position, @Nullable Object item) {
    check("getItemAtPosition(position)")
        .withMessage("item at positions %s", position)
        .that(actual.getItemAtPosition(position))
        .isEqualTo(item);
  }

  public void hasItemIdAtPosition(int position, long id) {
    check("getItemIdAtPosition(position)")
        .withMessage("ID for item at position %s", position)
        .that(actual.getItemIdAtPosition(position))
        .isEqualTo(id);
  }

  public void hasLastVisiblePosition(int position) {
    check("getLastVisiblePosition()").that(actual.getLastVisiblePosition()).isEqualTo(position);
  }

  public void hasPositionForView(@Nullable View view, int position) {
    check("getPositionForView(view)")
        .withMessage("position for view")
        .that(actual.getPositionForView(view))
        .isEqualTo(position);
  }

  public void hasSelectedItem(@Nullable Object item) {
    check("getSelectedItem()").that(actual.getSelectedItem()).isEqualTo(item);
  }

  public void hasSelectedItemId(long id) {
    check("getSelectedItemId()").that(actual.getSelectedItemId()).isEqualTo(id);
  }

  public void hasSelectedItemPosition(int position) {
    check("getSelectedItemPosition()").that(actual.getSelectedItemPosition()).isEqualTo(position);
  }

  public void hasSelectedView(@Nullable View view) {
    check("getSelectedView()").that(actual.getSelectedView()).isSameInstanceAs(view);
  }
}
