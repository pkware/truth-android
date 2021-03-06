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
package com.pkware.truth.android.app;

import android.app.ListActivity;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.common.truth.FailureMetadata;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class AbstractListActivitySubject<T extends ListActivity> extends AbstractActivitySubject<T> {

  @Nullable
  private final T actual;

  protected AbstractListActivitySubject(@Nonnull FailureMetadata failureMetadata, @Nullable T actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasListAdapter(@Nullable ListAdapter adapter) {
    check("getListAdapter()").that(actual.getListAdapter()).isSameInstanceAs(adapter);
  }

  public void hasListView(@Nullable ListView listView) {
    check("getListView()").that(actual.getListView()).isSameInstanceAs(listView);
  }

  public void hasSelectedItemId(long id) {
    check("getSelectedItemId()").that(actual.getSelectedItemId()).isEqualTo(id);
  }

  public void hasSelectedItemPosition(int position) {
    check("getSelectedItemPosition()").that(actual.getSelectedItemPosition()).isEqualTo(position);
  }
}
