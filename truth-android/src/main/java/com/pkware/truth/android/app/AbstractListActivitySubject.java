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

import static com.google.common.truth.Truth.assertThat;

public abstract class AbstractListActivitySubject<S extends AbstractListActivitySubject<S, T>, T extends ListActivity> extends AbstractActivitySubject<S, T> {
  protected AbstractListActivitySubject(FailureMetadata failureMetadata, T subject) {
    super(failureMetadata, subject);
  }

  public S hasListAdapter(ListAdapter adapter) {
    assertThat(actual().getListAdapter())
        .named("list adapter")
        .isSameAs(adapter);
    //noinspection unchecked
    return (S) this;
  }

  public S hasListView(ListView listView) {
    assertThat(actual().getListView())
        .named("list view")
        .isSameAs(listView);
    //noinspection unchecked
    return (S) this;
  }

  public S hasSelectedItemId(long id) {
    assertThat(actual().getSelectedItemId())
        .named("selected item id")
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
}
