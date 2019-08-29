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

import android.widget.SimpleCursorAdapter;

import com.google.common.truth.FailureMetadata;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.widget.SimpleCursorAdapter.CursorToStringConverter;
import static android.widget.SimpleCursorAdapter.ViewBinder;

/**
 * Propositions for {@link SimpleCursorAdapter} subjects.
 */
public class SimpleCursorAdapterSubject
    extends AbstractCursorAdapterSubject<SimpleCursorAdapter> {

  @Nullable
  private final SimpleCursorAdapter actual;

  public SimpleCursorAdapterSubject(@Nonnull FailureMetadata failureMetadata, @Nullable SimpleCursorAdapter actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasCursorToStringConverter(@Nullable CursorToStringConverter converter) {
    check("getCursorToStringConverter()").that(actual.getCursorToStringConverter()).isSameInstanceAs(converter);
  }

  public void hasStringConversionColumn(int column) {
    check("getStringConversionColumn()").that(actual.getStringConversionColumn()).isEqualTo(column);
  }

  public void hasViewBinder(@Nullable ViewBinder binder) {
    check("getViewBinder()").that(actual.getViewBinder()).isSameInstanceAs(binder);
  }
}
