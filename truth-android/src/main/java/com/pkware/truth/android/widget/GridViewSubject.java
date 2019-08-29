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

import android.annotation.TargetApi;
import android.widget.GridView;

import com.google.common.truth.FailureMetadata;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.os.Build.VERSION_CODES.JELLY_BEAN;
import static android.widget.GridView.NO_STRETCH;
import static android.widget.GridView.STRETCH_COLUMN_WIDTH;
import static android.widget.GridView.STRETCH_SPACING;
import static android.widget.GridView.STRETCH_SPACING_UNIFORM;
import static com.pkware.truth.android.internal.IntegerUtils.buildNamedValueString;

/**
 * Propositions for {@link GridView} subjects.
 */
public class GridViewSubject extends AbstractAbsListViewSubject<GridView> {

  @Nullable
  private final GridView actual;

  public GridViewSubject(@Nonnull FailureMetadata failureMetadata, @Nullable GridView actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  @Nonnull
  public static String stretchModeToString(@GridViewStretchMode int mode) {
    return buildNamedValueString(mode)
        .value(NO_STRETCH, "noStretch")
        .value(STRETCH_SPACING, "stretchSpacing")
        .value(STRETCH_SPACING_UNIFORM, "stretchSpacingUniform")
        .value(STRETCH_COLUMN_WIDTH, "stretchColumnWidth")
        .get();
  }

  @TargetApi(JELLY_BEAN)
  public void hasColumnWidth(int width) {
    check("getColumnWidth()").that(actual.getColumnWidth()).isEqualTo(width);
  }

  @TargetApi(JELLY_BEAN)
  public void hasGravity(int gravity) {
    check("getGravity()").that(actual.getGravity()).isEqualTo(gravity);
  }

  @TargetApi(JELLY_BEAN)
  public void hasHorizontalSpacing(int spacing) {
    check("getHorizontalSpacing()").that(actual.getHorizontalSpacing()).isEqualTo(spacing);
  }

  public void hasColumnCount(int count) {
    check("getNumColumns()").that(actual.getNumColumns()).isEqualTo(count);
  }

  @TargetApi(JELLY_BEAN)
  public void hasRequestedColumnWidth(int width) {
    check("getRequestedColumnWidth()").that(actual.getRequestedColumnWidth()).isEqualTo(width);
  }

  @TargetApi(JELLY_BEAN)
  public void hasRequestedHorizontalSpacing(int spacing) {
    check("getRequestedHorizontalSpacing()").that(actual.getRequestedHorizontalSpacing()).isEqualTo(spacing);
  }

  public void hasStretchMode(@GridViewStretchMode int mode) {
    int actualMode = actual.getStretchMode();
    //noinspection ResourceType
    check("getStretchMode()")
        .withMessage("Expected stretch mode <%s> but was <%s>.",
            stretchModeToString(mode), stretchModeToString(actualMode))
        .that(actualMode)
        .isEqualTo(mode);
  }

  @TargetApi(JELLY_BEAN)
  public void hasVerticalSpacing(int spacing) {
    check("getVerticalSpacing()").that(actual.getVerticalSpacing()).isEqualTo(spacing);
  }
}
