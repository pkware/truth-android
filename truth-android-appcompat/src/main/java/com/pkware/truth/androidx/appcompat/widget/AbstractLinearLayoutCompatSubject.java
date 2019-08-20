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
package com.pkware.truth.androidx.appcompat.widget;

import android.annotation.TargetApi;

import androidx.appcompat.widget.LinearLayoutCompat;

import com.google.common.truth.FailureMetadata;
import com.pkware.truth.android.view.AbstractViewGroupSubject;
import com.pkware.truth.android.widget.LinearLayoutOrientation;
import com.pkware.truth.android.widget.LinearLayoutShowDividers;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.os.Build.VERSION_CODES.HONEYCOMB;
import static android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH;
import static android.widget.LinearLayout.HORIZONTAL;
import static android.widget.LinearLayout.SHOW_DIVIDER_BEGINNING;
import static android.widget.LinearLayout.SHOW_DIVIDER_END;
import static android.widget.LinearLayout.SHOW_DIVIDER_MIDDLE;
import static android.widget.LinearLayout.VERTICAL;
import static com.pkware.truth.android.internal.IntegerUtils.buildBitMaskString;
import static com.pkware.truth.android.internal.IntegerUtils.buildNamedValueString;

public abstract class AbstractLinearLayoutCompatSubject<T extends LinearLayoutCompat>
    extends AbstractViewGroupSubject<T> {

  @Nullable
  private final T actual;

  protected AbstractLinearLayoutCompatSubject(@Nonnull FailureMetadata failureMetadata, @Nullable T actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  @Nonnull
  @TargetApi(HONEYCOMB)
  public static String showDividerToString(@LinearLayoutShowDividers int dividers) {
    return buildBitMaskString(dividers)
        .flag(SHOW_DIVIDER_BEGINNING, "beginning")
        .flag(SHOW_DIVIDER_MIDDLE, "middle")
        .flag(SHOW_DIVIDER_END, "end")
        .get();
  }

  @Nonnull
  public static String orientationToString(@LinearLayoutOrientation int orientation) {
    return buildNamedValueString(orientation).value(HORIZONTAL, "horizontal")
        .value(VERTICAL, "vertical")
        .get();
  }

  @TargetApi(ICE_CREAM_SANDWICH)
  public void hasDividerPadding(int padding) {
    check("getDividerPadding()").that(actual.getDividerPadding()).isEqualTo(padding);
  }

  public void hasOrientation(@LinearLayoutOrientation int orientation) {
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

  @TargetApi(HONEYCOMB)
  public void hasShowDividers(@LinearLayoutShowDividers int dividers) {
    int actualDividers = actual.getShowDividers();
    //noinspection ResourceType
    check("getShowDividers()")
        .withMessage("Expected showing dividers <%s> but was <%s>.",
            showDividerToString(dividers), showDividerToString(actualDividers))
        .that(actualDividers)
        .isEqualTo(dividers);
  }

  public void hasWeightSum(float sum, float tolerance) {
    check("getWeightSum()").that(actual.getWeightSum()).isWithin(tolerance).of(sum);
  }

  public void isBaselineAligned() {
    check("isBaselineAligned()").that(actual.isBaselineAligned()).isTrue();
  }

  public void isNotBaselineAligned() {
    check("isBaselineAligned()").that(actual.isBaselineAligned()).isFalse();
  }

  @TargetApi(HONEYCOMB)
  public void isMeasuringWithLargestChild() {
    check("isMeasureWithLargestChildEnabled()").that(actual.isMeasureWithLargestChildEnabled()).isTrue();
  }

  @TargetApi(HONEYCOMB)
  public void isNotMeasuringWithLargestChild() {
    check("isMeasureWithLargestChildEnabled()").that(actual.isMeasureWithLargestChildEnabled()).isFalse();
  }
}
