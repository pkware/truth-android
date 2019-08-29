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

import android.view.View;
import android.widget.TabHost;

import com.google.common.truth.FailureMetadata;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link TabHost} subjects.
 */
public class TabHostSubject extends AbstractFrameLayoutSubject<TabHost> {

  @Nullable
  private final TabHost actual;

  public TabHostSubject(@Nonnull FailureMetadata failureMetadata, @Nullable TabHost actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasCurrentTab(int tab) {
    check("getCurrentTab()").that(actual.getCurrentTab()).isEqualTo(tab);
  }

  public void hasCurrentTabTag(String tag) {
    check("getCurrentTabTag()").that(actual.getCurrentTabTag()).isEqualTo(tag);
  }

  public void hasCurrentTabView(@Nullable View view) {
    check("getCurrentTabView()").that(actual.getCurrentTabView()).isSameInstanceAs(view);
  }

  public void hasCurrentView(@Nullable View view) {
    check("getCurrentView()").that(actual.getCurrentView()).isSameInstanceAs(view);
  }
}
