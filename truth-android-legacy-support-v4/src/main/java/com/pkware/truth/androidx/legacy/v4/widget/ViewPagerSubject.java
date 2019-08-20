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
package com.pkware.truth.androidx.legacy.v4.widget;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.common.truth.FailureMetadata;
import com.pkware.truth.android.view.AbstractViewGroupSubject;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link ViewPager} subjects.
 */
public class ViewPagerSubject extends AbstractViewGroupSubject<ViewPagerSubject, ViewPager> {
  public ViewPagerSubject(FailureMetadata failureMetadata, ViewPager subject) {
    super(failureMetadata, subject);
  }

  public ViewPagerSubject hasAdapter(PagerAdapter adapter) {
    assertThat(actual().getAdapter())
        .named("adapter")
        .isSameAs(adapter);
    return this;
  }

  public ViewPagerSubject hasCurrentItem(int index) {
    assertThat(actual().getCurrentItem())
        .named("current item")
        .isEqualTo(index);
    return this;
  }

  public ViewPagerSubject hasOffscreenPageLimit(int limit) {
    assertThat(actual().getOffscreenPageLimit())
        .named("offscreen page limit")
        .isEqualTo(limit);
    return this;
  }

  public ViewPagerSubject hasPageMargin(int margin) {
    assertThat(actual().getPageMargin())
        .named("page margin")
        .isEqualTo(margin);
    return this;
  }

  public ViewPagerSubject isFakeDragging() {
    assertThat(actual().isFakeDragging())
        .named("is fake dragging")
        .isTrue();
    return this;
  }

  public ViewPagerSubject isNotFakeDragging() {
    assertThat(actual().isFakeDragging())
        .named("is fake dragging")
        .isFalse();
    return this;
  }
}
