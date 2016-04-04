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

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.widget.ListView;

import com.google.common.truth.FailureStrategy;

import static android.os.Build.VERSION_CODES.KITKAT;
import static com.google.common.truth.Truth.assertThat;

public abstract class AbstractListViewSubject<S extends AbstractListViewSubject<S, T>, T extends ListView>
    extends AbstractAbsListViewSubject<S, T> {
  protected AbstractListViewSubject(FailureStrategy failureStrategy, T subject) {
    super(failureStrategy, subject);
  }

  public S hasDivider(Drawable divider) {
    assertThat(getSubject().getDivider())
        .named("divider")
        .isSameAs(divider);
    //noinspection unchecked
    return (S) this;
  }

  public S hasDividerHeight(int height) {
    assertThat(getSubject().getDividerHeight())
        .named("divider height")
        .isEqualTo(height);
    //noinspection unchecked
    return (S) this;
  }

  public S hasFooterViewsCount(int count) {
    assertThat(getSubject().getFooterViewsCount())
        .named("footer views count")
        .isEqualTo(count);
    //noinspection unchecked
    return (S) this;
  }

  public S hasHeaderViewsCount(int count) {
    assertThat(getSubject().getHeaderViewsCount())
        .named("header views count")
        .isEqualTo(count);
    //noinspection unchecked
    return (S) this;
  }

  public S hasOverscrollFooter(Drawable footer) {
    assertThat(getSubject().getOverscrollFooter())
        .named("overscroll footer")
        .isSameAs(footer);
    //noinspection unchecked
    return (S) this;
  }

  public S hasOverscrollHeader(Drawable header) {
    assertThat(getSubject().getOverscrollHeader())
        .named("overscroll header")
        .isSameAs(header);
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(KITKAT)
  public S hasFooterDividersEnabled() {
    assertThat(getSubject().areFooterDividersEnabled())
        .named("footer dividers are enabled")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(KITKAT)
  public S hasFooterDividersDisabled() {
    assertThat(getSubject().areFooterDividersEnabled())
        .named("footer dividers are enabled")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(KITKAT)
  public S hasHeaderDividersEnabled() {
    assertThat(getSubject().areHeaderDividersEnabled())
        .named("header dividers are enabled")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(KITKAT)
  public S hasHeaderDividersDisabled() {
    assertThat(getSubject().areHeaderDividersEnabled())
        .named("header dividers are enabled")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }
}
