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

import android.widget.TableLayout;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link TableLayout} subjects.
 */
public class TableLayoutSubject extends AbstractLinearLayoutSubject<TableLayoutSubject, TableLayout> {
  protected TableLayoutSubject(FailureStrategy failureStrategy, TableLayout subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<TableLayoutSubject, TableLayout> type() {
    return new SubjectFactory<TableLayoutSubject, TableLayout>() {
      @Override
      public TableLayoutSubject getSubject(FailureStrategy fs, TableLayout that) {
        return new TableLayoutSubject(fs, that);
      }
    };
  }

  public TableLayoutSubject isCollapsedColumn(int index) {
    assertThat(getSubject().isColumnCollapsed(index))
        .named("column " + index + " is collapsed")
        .isTrue();
    return this;
  }

  public TableLayoutSubject isNotCollapsedColumn(int index) {
    assertThat(getSubject().isColumnCollapsed(index))
        .named("column " + index + " is collapsed")
        .isFalse();
    return this;
  }

  public TableLayoutSubject isShrinkableColumn(int index) {
    assertThat(getSubject().isColumnShrinkable(index))
        .named("column " + index + " is shrinkable")
        .isTrue();
    return this;
  }

  public TableLayoutSubject isNotShrinkableColumn(int index) {
    assertThat(getSubject().isColumnShrinkable(index))
        .named("column " + index + " is shrinkable")
        .isFalse();
    return this;
  }

  public TableLayoutSubject isStretchableColumn(int index) {
    assertThat(getSubject().isColumnStretchable(index))
        .named("column " + index + " is stretchable")
        .isTrue();
    return this;
  }

  public TableLayoutSubject isNotStretchableColumn(int index) {
    assertThat(getSubject().isColumnStretchable(index))
        .named("column " + index + " is stretchable")
        .isFalse();
    return this;
  }
}
