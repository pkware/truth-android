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
package com.pkware.truth.android.appcompat.v7.widget;

import android.annotation.TargetApi;
import android.support.v7.widget.LinearLayoutCompat;

import com.google.common.truth.FailureStrategy;
import com.pkware.truth.android.view.AbstractViewGroupSubject;
import com.pkware.truth.android.widget.LinearLayoutOrientation;
import com.pkware.truth.android.widget.LinearLayoutShowDividers;

import static android.os.Build.VERSION_CODES.HONEYCOMB;
import static android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH;
import static android.widget.LinearLayout.HORIZONTAL;
import static android.widget.LinearLayout.SHOW_DIVIDER_BEGINNING;
import static android.widget.LinearLayout.SHOW_DIVIDER_END;
import static android.widget.LinearLayout.SHOW_DIVIDER_MIDDLE;
import static android.widget.LinearLayout.VERTICAL;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assert_;
import static com.pkware.truth.android.internal.IntegerUtils.buildBitMaskString;
import static com.pkware.truth.android.internal.IntegerUtils.buildNamedValueString;

public abstract class AbstractLinearLayoutCompatSubject<S extends AbstractLinearLayoutCompatSubject<S, T>, T extends LinearLayoutCompat>
    extends AbstractViewGroupSubject<S, T> {

  protected AbstractLinearLayoutCompatSubject(FailureStrategy failureStrategy, T subject) {
    super(failureStrategy, subject);
  }

  @TargetApi(HONEYCOMB)
  public static String showDividerToString(@LinearLayoutShowDividers int dividers) {
    return buildBitMaskString(dividers)
        .flag(SHOW_DIVIDER_BEGINNING, "beginning")
        .flag(SHOW_DIVIDER_MIDDLE, "middle")
        .flag(SHOW_DIVIDER_END, "end")
        .get();
  }

  public static String orientationToString(@LinearLayoutOrientation int orientation) {
    return buildNamedValueString(orientation).value(HORIZONTAL, "horizontal")
        .value(VERTICAL, "vertical")
        .get();
  }

  @TargetApi(ICE_CREAM_SANDWICH)
  public S hasDividerPadding(int padding) {
    assertThat(getSubject().getDividerPadding())
        .named("divider padding")
        .isEqualTo(padding);
    //noinspection unchecked
    return (S) this;
  }

  public S hasOrientation(@LinearLayoutOrientation int orientation) {
    int actualOrientation = getSubject().getOrientation();
    //noinspection ResourceType
    assert_()
        .withFailureMessage("Expected orientation <%s> but was <%s>.",
            orientationToString(orientation), orientationToString(actualOrientation))
        .that(actualOrientation)
        .isEqualTo(orientation);
    //noinspection unchecked
    return (S) this;
  }

  public S isVertical() {
    return hasOrientation(VERTICAL);
  }

  public S isHorizontal() {
    return hasOrientation(HORIZONTAL);
  }

  @TargetApi(HONEYCOMB)
  public S hasShowDividers(@LinearLayoutShowDividers int dividers) {
    int actualDividers = getSubject().getShowDividers();
    //noinspection ResourceType
    assert_()
        .withFailureMessage("Expected showing dividers <%s> but was <%s>.",
            showDividerToString(dividers), showDividerToString(actualDividers))
        .that(actualDividers)
        .isEqualTo(dividers);
    //noinspection unchecked
    return (S) this;
  }

  public S hasWeightSum(float sum, float tolerance) {
    assertThat(getSubject().getWeightSum())
        .named("weight sum")
        .isWithin(tolerance)
        .of(sum);
    //noinspection unchecked
    return (S) this;
  }

  public S isBaselineAligned() {
    assertThat(getSubject().isBaselineAligned())
        .named("is baseline aligned")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotBaselineAligned() {
    assertThat(getSubject().isBaselineAligned())
        .named("is baseline aligned")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(HONEYCOMB)
  public S isMeasuringWithLargestChild() {
    assertThat(getSubject().isMeasureWithLargestChildEnabled())
        .named("is measuring with largest child")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(HONEYCOMB)
  public S isNotMeasuringWithLargestChild() {
    assertThat(getSubject().isMeasureWithLargestChildEnabled())
        .named("is measuring with largest child")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }
}
