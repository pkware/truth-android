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
package com.pkware.truth.androidx.cursoradapter.widget;

import android.database.Cursor;
import android.widget.Filter;

import androidx.cursoradapter.widget.CursorAdapter;

import com.google.common.truth.FailureMetadata;
import com.pkware.truth.android.widget.AbstractListAdapterSubject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class AbstractCursorAdapterSubject<T extends CursorAdapter>
    extends AbstractListAdapterSubject<T> {

  @Nullable
  private final T actual;

  protected AbstractCursorAdapterSubject(@Nonnull FailureMetadata failureMetadata, @Nullable T actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasCursor(@Nullable Cursor cursor) {
    check("getCursor()").that(actual.getCursor()).isSameInstanceAs(cursor);
  }

  public void hasFilter(@Nullable Filter filter) {
    check("getFilter()").that(actual.getFilter()).isSameInstanceAs(filter);
  }
}
