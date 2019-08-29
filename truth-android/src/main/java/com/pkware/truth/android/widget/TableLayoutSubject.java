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

import android.widget.TableLayout;

import com.google.common.truth.FailureMetadata;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link TableLayout} subjects.
 */
public class TableLayoutSubject extends AbstractLinearLayoutSubject<TableLayout> {

  @Nullable
  private final TableLayout actual;

  public TableLayoutSubject(@Nonnull FailureMetadata failureMetadata, @Nullable TableLayout actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void isCollapsedColumn(int index) {
    check("isColumnCollapsed(index)")
        .withMessage("column %s is collapsed", index)
        .that(actual.isColumnCollapsed(index))
        .isTrue();
  }

  public void isNotCollapsedColumn(int index) {
    check("isColumnCollapsed(index)")
        .withMessage("column %s is not collapsed", index)
        .that(actual.isColumnCollapsed(index))
        .isFalse();
  }

  public void isShrinkableColumn(int index) {
    check("isColumnShrinkable(index)")
        .withMessage("column %s is shrinkable", index)
        .that(actual.isColumnShrinkable(index))
        .isTrue();
  }

  public void isNotShrinkableColumn(int index) {
    check("isColumnShrinkable(index)")
        .withMessage("column %s is not shrinkable", index)
        .that(actual.isColumnShrinkable(index))
        .isFalse();
  }

  public void isStretchableColumn(int index) {
    check("isColumnStretchable(index)")
        .withMessage("column %s is stretchable", index)
        .that(actual.isColumnStretchable(index))
        .isTrue();
  }

  public void isNotStretchableColumn(int index) {
    check("isColumnStretchable(index)")
        .withMessage("column %s is not stretchable", index)
        .that(actual.isColumnStretchable(index))
        .isFalse();
  }
}
