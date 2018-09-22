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
import com.google.common.truth.Subject;

import static android.os.Build.VERSION_CODES.JELLY_BEAN;
import static android.widget.GridView.NO_STRETCH;
import static android.widget.GridView.STRETCH_COLUMN_WIDTH;
import static android.widget.GridView.STRETCH_SPACING;
import static android.widget.GridView.STRETCH_SPACING_UNIFORM;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assert_;
import static com.pkware.truth.android.internal.IntegerUtils.buildNamedValueString;

/**
 * Propositions for {@link GridView} subjects.
 */
public class GridViewSubject extends AbstractAbsListViewSubject<GridViewSubject, GridView> {
  protected GridViewSubject(FailureMetadata failureMetadata, GridView subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<GridViewSubject, GridView> type() {
    return new Subject.Factory<GridViewSubject, GridView>() {
      @Override
      public GridViewSubject createSubject(FailureMetadata fm, GridView that) {
        return new GridViewSubject(fm, that);
      }
    };
  }

  public static String stretchModeToString(@GridViewStretchMode int mode) {
    return buildNamedValueString(mode)
        .value(NO_STRETCH, "noStretch")
        .value(STRETCH_SPACING, "stretchSpacing")
        .value(STRETCH_SPACING_UNIFORM, "stretchSpacingUniform")
        .value(STRETCH_COLUMN_WIDTH, "stretchColumnWidth")
        .get();
  }

  @TargetApi(JELLY_BEAN)
  public GridViewSubject hasColumnWidth(int width) {
    assertThat(actual().getColumnWidth())
        .named("column width")
        .isEqualTo(width);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public GridViewSubject hasGravity(int gravity) {
    assertThat(actual().getGravity())
        .named("gravity")
        .isEqualTo(gravity);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public GridViewSubject hasHorizontalSpacing(int spacing) {
    assertThat(actual().getHorizontalSpacing())
        .named("horizontal spacing")
        .isEqualTo(spacing);
    return this;
  }

  public GridViewSubject hasColumnCount(int count) {
    assertThat(actual().getNumColumns())
        .named("column count")
        .isEqualTo(count);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public GridViewSubject hasRequestedColumnWidth(int width) {
    assertThat(actual().getRequestedColumnWidth())
        .named("requested column width")
        .isEqualTo(width);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public GridViewSubject hasRequestedHorizontalSpacing(int spacing) {
    assertThat(actual().getRequestedHorizontalSpacing())
        .named("requested horizontal spacing")
        .isEqualTo(spacing);
    return this;
  }

  public GridViewSubject hasStretchMode(@GridViewStretchMode int mode) {
    int actualMode = actual().getStretchMode();
    //noinspection ResourceType
    assert_()
        .withMessage("Expected stretch mode <%s> but was <%s>.",
            stretchModeToString(mode), stretchModeToString(actualMode))
        .that(actualMode)
        .isEqualTo(mode);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public GridViewSubject hasVerticalSpacing(int spacing) {
    assertThat(actual().getVerticalSpacing())
        .named("vertical spacing")
        .isEqualTo(spacing);
    return this;
  }
}
