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
package com.pkware.truth.android.support.v4.view;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;
import com.pkware.truth.android.view.AbstractViewGroupSubject;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link ViewPager} subjects.
 */
public class ViewPagerSubject extends AbstractViewGroupSubject<ViewPagerSubject, ViewPager> {
  protected ViewPagerSubject(FailureStrategy failureStrategy, ViewPager subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<ViewPagerSubject, ViewPager> type() {
    return new SubjectFactory<ViewPagerSubject, ViewPager>() {
      @Override
      public ViewPagerSubject getSubject(FailureStrategy fs, ViewPager that) {
        return new ViewPagerSubject(fs, that);
      }
    };
  }

  public ViewPagerSubject hasAdapter(PagerAdapter adapter) {
    assertThat(getSubject().getAdapter())
        .named("adapter")
        .isSameAs(adapter);
    return this;
  }

  public ViewPagerSubject hasCurrentItem(int index) {
    assertThat(getSubject().getCurrentItem())
        .named("current item")
        .isEqualTo(index);
    return this;
  }

  public ViewPagerSubject hasOffscreenPageLimit(int limit) {
    assertThat(getSubject().getOffscreenPageLimit())
        .named("offscreen page limit")
        .isEqualTo(limit);
    return this;
  }

  public ViewPagerSubject hasPageMargin(int margin) {
    assertThat(getSubject().getPageMargin())
        .named("page margin")
        .isEqualTo(margin);
    return this;
  }

  public ViewPagerSubject isFakeDragging() {
    assertThat(getSubject().isFakeDragging())
        .named("is fake dragging")
        .isTrue();
    return this;
  }

  public ViewPagerSubject isNotFakeDragging() {
    assertThat(getSubject().isFakeDragging())
        .named("is fake dragging")
        .isFalse();
    return this;
  }
}
