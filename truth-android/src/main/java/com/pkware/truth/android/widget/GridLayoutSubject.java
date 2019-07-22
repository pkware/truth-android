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

import android.widget.GridLayout;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;
import com.pkware.truth.android.view.AbstractViewGroupSubject;

import static android.widget.GridLayout.ALIGN_BOUNDS;
import static android.widget.GridLayout.ALIGN_MARGINS;
import static android.widget.GridLayout.HORIZONTAL;
import static android.widget.GridLayout.VERTICAL;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assert_;
import static com.pkware.truth.android.internal.IntegerUtils.buildNamedValueString;

/**
 * Propositions for {@link GridLayout} subjects.
 */
public class GridLayoutSubject extends AbstractViewGroupSubject<GridLayoutSubject, GridLayout> {
  protected GridLayoutSubject(FailureMetadata failureMetadata, GridLayout subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<GridLayoutSubject, GridLayout> type() {
    return GridLayoutSubject::new;
  }

  public static String alignmentModeToString(@GridLayoutAlignmentMode int mode) {
    return buildNamedValueString(mode)
        .value(ALIGN_BOUNDS, "alignBounds")
        .value(ALIGN_MARGINS, "alignMargins")
        .get();
  }

  public static String orientationToString(@GridLayoutOrientation int orientation) {
    return buildNamedValueString(orientation)
        .value(HORIZONTAL, "horizontal")
        .value(VERTICAL, "vertical")
        .get();
  }

  public GridLayoutSubject hasAlignmentMode(@GridLayoutAlignmentMode int mode) {
    int actualMode = actual().getAlignmentMode();
    //noinspection ResourceType
    assert_()
        .withMessage("Expected alignment mode <%s> but was <%s>.",
            alignmentModeToString(mode), alignmentModeToString(actualMode))
        .that(actualMode)
        .isEqualTo(mode);
    return this;
  }

  public GridLayoutSubject hasColumnCount(int count) {
    assertThat(actual().getColumnCount())
        .named("column count")
        .isEqualTo(count);
    return this;
  }

  public GridLayoutSubject hasOrientation(@GridLayoutOrientation int orientation) {
    int actualOrientation = actual().getOrientation();
    //noinspection ResourceType
    assert_()
        .withMessage("Expected orientation <%s> but was <%s>.",
            orientationToString(orientation), orientationToString(actualOrientation))
        .that(actualOrientation)
        .isEqualTo(orientation);
    return this;
  }

  public GridLayoutSubject isVertical() {
    return hasOrientation(VERTICAL);
  }

  public GridLayoutSubject isHorizontal() {
    return hasOrientation(HORIZONTAL);
  }

  public GridLayoutSubject hasRowCount(int count) {
    assertThat(actual().getRowCount())
        .named("row count")
        .isEqualTo(count);
    return this;
  }

  public GridLayoutSubject isUsingDefaultMargins() {
    assertThat(actual().getUseDefaultMargins())
        .named("is using default margins")
        .isTrue();
    return this;
  }

  public GridLayoutSubject isNotUsingDefaultMargins() {
    assertThat(actual().getUseDefaultMargins())
        .named("is using default margins")
        .isFalse();
    return this;
  }

  public GridLayoutSubject isPreservingColumnOrder() {
    assertThat(actual().isColumnOrderPreserved())
        .named("is preserving column order")
        .isTrue();
    return this;
  }

  public GridLayoutSubject isNotPreservingColumnOrder() {
    assertThat(actual().isColumnOrderPreserved())
        .named("is preserving column order")
        .isFalse();
    return this;
  }

  public GridLayoutSubject isPreservingRowOrder() {
    assertThat(actual().isRowOrderPreserved())
        .named("is preserving row order")
        .isTrue();
    return this;
  }

  public GridLayoutSubject isNotPreservingRowOrder() {
    assertThat(actual().isRowOrderPreserved())
        .named("is preserving row order")
        .isFalse();
    return this;
  }
}
