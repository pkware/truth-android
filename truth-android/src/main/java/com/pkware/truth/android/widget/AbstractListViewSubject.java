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
import android.graphics.drawable.Drawable;
import android.widget.ListView;

import com.google.common.truth.FailureMetadata;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.os.Build.VERSION_CODES.KITKAT;

public abstract class AbstractListViewSubject<T extends ListView>
    extends AbstractAbsListViewSubject<T> {

  @Nullable
  private final T actual;

  protected AbstractListViewSubject(@Nonnull FailureMetadata failureMetadata, @Nullable T actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasDivider(@Nullable Drawable divider) {
    check("getDivider()").that(actual.getDivider()).isSameInstanceAs(divider);
  }

  public void hasDividerHeight(int height) {
    check("getDividerHeight()").that(actual.getDividerHeight()).isEqualTo(height);
  }

  public void hasFooterViewsCount(int count) {
    check("getFooterViewsCount()").that(actual.getFooterViewsCount()).isEqualTo(count);
  }

  public void hasHeaderViewsCount(int count) {
    check("getHeaderViewsCount()").that(actual.getHeaderViewsCount()).isEqualTo(count);
  }

  public void hasOverscrollFooter(@Nullable Drawable footer) {
    check("getOverscrollFooter()").that(actual.getOverscrollFooter()).isSameInstanceAs(footer);
  }

  public void hasOverscrollHeader(@Nullable Drawable header) {
    check("getOverscrollHeader()").that(actual.getOverscrollHeader()).isSameInstanceAs(header);
  }

  @TargetApi(KITKAT)
  public void hasFooterDividersEnabled() {
    check("areFooterDividersEnabled()").that(actual.areFooterDividersEnabled()).isTrue();
  }

  @TargetApi(KITKAT)
  public void hasFooterDividersDisabled() {
    check("areFooterDividersEnabled()").that(actual.areFooterDividersEnabled()).isFalse();
  }

  @TargetApi(KITKAT)
  public void hasHeaderDividersEnabled() {
    check("areHeaderDividersEnabled()").that(actual.areHeaderDividersEnabled()).isTrue();
  }

  @TargetApi(KITKAT)
  public void hasHeaderDividersDisabled() {
    check("areHeaderDividersEnabled()").that(actual.areHeaderDividersEnabled()).isFalse();
  }
}
