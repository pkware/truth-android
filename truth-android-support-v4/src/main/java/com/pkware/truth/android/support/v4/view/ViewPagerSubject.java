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
package com.pkware.truth.android.support.v4.view;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;
import com.pkware.truth.android.view.AbstractViewGroupSubject;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link ViewPager} subjects.
 */
public class ViewPagerSubject extends AbstractViewGroupSubject<ViewPagerSubject, ViewPager> {
  protected ViewPagerSubject(FailureMetadata failureMetadata, ViewPager subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<ViewPagerSubject, ViewPager> type() {
    return new Subject.Factory<ViewPagerSubject, ViewPager>() {
      @Override
      public ViewPagerSubject createSubject(FailureMetadata fm, ViewPager that) {
        return new ViewPagerSubject(fm, that);
      }
    };
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
