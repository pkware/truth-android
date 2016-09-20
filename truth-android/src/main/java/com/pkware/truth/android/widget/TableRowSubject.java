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

import android.widget.TableRow;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link TableRow} subjects.
 */
public class TableRowSubject extends AbstractLinearLayoutSubject<TableRowSubject, TableRow> {
  protected TableRowSubject(FailureStrategy failureStrategy, TableRow subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<TableRowSubject, TableRow> type() {
    return new SubjectFactory<TableRowSubject, TableRow>() {
      @Override
      public TableRowSubject getSubject(FailureStrategy fs, TableRow that) {
        return new TableRowSubject(fs, that);
      }
    };
  }

  public TableRowSubject hasVirtualChildCount(int count) {
    int actualCount = actual().getVirtualChildCount();
    assertThat(actual().getVirtualChildCount())
        .named("virtual child count")
        .isEqualTo(count);
    return this;
  }
}
