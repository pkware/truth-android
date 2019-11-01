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
package com.pkware.truth.androidx.viewpager.widget;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.common.truth.FailureMetadata;
import com.pkware.truth.android.view.AbstractViewGroupSubject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link ViewPager} subjects.
 */
public class ViewPagerSubject extends AbstractViewGroupSubject<ViewPager> {

  @Nullable
  private final ViewPager actual;

  public ViewPagerSubject(@Nonnull FailureMetadata failureMetadata, @Nullable ViewPager actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasAdapter(@Nullable PagerAdapter adapter) {
    check("getAdapter()").that(actual.getAdapter()).isSameInstanceAs(adapter);
  }

  public void hasCurrentItem(int index) {
    check("getCurrentItem()").that(actual.getCurrentItem()).isEqualTo(index);
  }

  public void hasOffscreenPageLimit(int limit) {
    check("getOffscreenPageLimit()").that(actual.getOffscreenPageLimit()).isEqualTo(limit);
  }

  public void hasPageMargin(int margin) {
    check("getPageMargin()").that(actual.getPageMargin()).isEqualTo(margin);
  }

  public void isFakeDragging() {
    check("isFakeDragging()").that(actual.isFakeDragging()).isTrue();
  }

  public void isNotFakeDragging() {
    check("isFakeDragging()").that(actual.isFakeDragging()).isFalse();
  }
}
