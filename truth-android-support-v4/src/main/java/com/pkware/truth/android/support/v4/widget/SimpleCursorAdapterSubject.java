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

import android.support.v4.widget.SimpleCursorAdapter;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.support.v4.widget.SimpleCursorAdapter.CursorToStringConverter;
import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link SimpleCursorAdapter} subjects.
 */
public class SimpleCursorAdapterSubject
    extends AbstractCursorAdapterSubject<SimpleCursorAdapterSubject, SimpleCursorAdapter> {
  protected SimpleCursorAdapterSubject(FailureStrategy failureStrategy, SimpleCursorAdapter subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<SimpleCursorAdapterSubject, SimpleCursorAdapter> type() {
    return new SubjectFactory<SimpleCursorAdapterSubject, SimpleCursorAdapter>() {
      @Override
      public SimpleCursorAdapterSubject getSubject(FailureStrategy fs, SimpleCursorAdapter that) {
        return new SimpleCursorAdapterSubject(fs, that);
      }
    };
  }

  public SimpleCursorAdapterSubject hasCursorToStringConverter(CursorToStringConverter converter) {
    assertThat(actual().getCursorToStringConverter())
        .named("cursor 'toString' converter")
        .isSameAs(converter);
    return this;
  }

  public SimpleCursorAdapterSubject hasStringConversionColumn(int column) {
    int actualColumn = actual().getStringConversionColumn();
    assertThat(actual().getStringConversionColumn())
        .named("string conversion column")
        .isEqualTo(column);
    return this;
  }

  public SimpleCursorAdapterSubject hasViewBinder(SimpleCursorAdapter.ViewBinder binder) {
    assertThat(actual().getViewBinder())
        .named("view binder")
        .isSameAs(binder);
    return this;
  }
}
