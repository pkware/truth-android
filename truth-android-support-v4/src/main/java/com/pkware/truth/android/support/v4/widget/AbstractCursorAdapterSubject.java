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
package com.pkware.truth.android.support.v4.widget;

import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.widget.Filter;

import com.google.common.truth.FailureStrategy;
import com.pkware.truth.android.widget.AbstractListAdapterSubject;

import static com.google.common.truth.Truth.assertThat;

public abstract class AbstractCursorAdapterSubject<S extends AbstractCursorAdapterSubject<S, T>, T extends CursorAdapter>
    extends AbstractListAdapterSubject<S, T> {

  protected AbstractCursorAdapterSubject(FailureStrategy failureStrategy, T subject) {
    super(failureStrategy, subject);
  }

  public S hasCursor(Cursor cursor) {
    assertThat(actual().getCursor())
        .named("cursor")
        .isSameAs(cursor);
    //noinspection unchecked
    return (S) this;
  }

  public S hasFilter(Filter filter) {
    assertThat(actual().getFilter())
        .named("filter")
        .isSameAs(filter);
    //noinspection unchecked
    return (S) this;
  }
}
