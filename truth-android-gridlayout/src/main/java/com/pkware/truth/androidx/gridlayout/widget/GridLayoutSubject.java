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
package com.pkware.truth.androidx.gridlayout.widget;

import androidx.gridlayout.widget.GridLayout;

import com.google.common.truth.FailureMetadata;
import com.pkware.truth.android.view.AbstractViewGroupSubject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static androidx.gridlayout.widget.GridLayout.ALIGN_BOUNDS;
import static androidx.gridlayout.widget.GridLayout.ALIGN_MARGINS;
import static androidx.gridlayout.widget.GridLayout.HORIZONTAL;
import static androidx.gridlayout.widget.GridLayout.VERTICAL;
import static com.pkware.truth.android.internal.IntegerUtils.buildNamedValueString;

/**
 * Propositions for {@link GridLayout} subjects.
 */
public class GridLayoutSubject extends AbstractViewGroupSubject<GridLayout> {

  @Nullable
  private final GridLayout actual;

  public GridLayoutSubject(@Nonnull FailureMetadata failureMetadata, @Nullable GridLayout actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  @Nonnull
  public static String alignmentModeToString(@GridLayoutAlignmentMode int mode) {
    return buildNamedValueString(mode)
        .value(ALIGN_BOUNDS, "alignBounds")
        .value(ALIGN_MARGINS, "alignMargins")
        .get();
  }

  @Nonnull
  public static String orientationToString(@GridLayoutOrientation int orientation) {
    return buildNamedValueString(orientation)
        .value(HORIZONTAL, "horizontal")
        .value(VERTICAL, "vertical")
        .get();
  }

  public void hasAlignmentMode(@GridLayoutAlignmentMode int mode) {
    int actualMode = actual.getAlignmentMode();
    //noinspection ResourceType
    check("getAlignmentMode()")
        .withMessage("Expected alignment mode <%s> but was <%s>.",
            alignmentModeToString(mode), alignmentModeToString(actualMode))
        .that(actualMode)
        .isEqualTo(mode);
  }

  public void hasColumnCount(int count) {
    check("getColumnCount()").that(actual.getColumnCount()).isEqualTo(count);
  }

  public void hasOrientation(@GridLayoutOrientation int orientation) {
    int actualOrientation = actual.getOrientation();
    //noinspection ResourceType
    check("getOrientation()")
        .withMessage("Expected orientation <%s> but was <%s>.",
            orientationToString(orientation), orientationToString(actualOrientation))
        .that(actualOrientation)
        .isEqualTo(orientation);
  }

  public void isVertical() {
    hasOrientation(VERTICAL);
  }

  public void isHorizontal() {
    hasOrientation(HORIZONTAL);
  }

  public void hasRowCount(int count) {
    check("getRowCount()").that(actual.getRowCount()).isEqualTo(count);
  }

  public void isUsingDefaultMargins() {
    check("getUseDefaultMargins()").that(actual.getUseDefaultMargins()).isTrue();
  }

  public void isNotUsingDefaultMargins() {
    check("getUseDefaultMargins()").that(actual.getUseDefaultMargins()).isFalse();
  }

  public void isPreservingColumnOrder() {
    check("isColumnOrderPreserved()").that(actual.isColumnOrderPreserved()).isTrue();
  }

  public void isNotPreservingColumnOrder() {
    check("isColumnOrderPreserved()").that(actual.isColumnOrderPreserved()).isFalse();
  }

  public void isPreservingRowOrder() {
    check("isRowOrderPreserved()").that(actual.isRowOrderPreserved()).isTrue();
  }

  public void isNotPreservingRowOrder() {
    check("isRowOrderPreserved()").that(actual.isRowOrderPreserved()).isFalse();
  }
}
