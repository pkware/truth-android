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

import android.view.View;
import android.widget.TabHost;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link TabHost} subjects.
 */
public class TabHostSubject extends AbstractFrameLayoutSubject<TabHostSubject, TabHost> {
  protected TabHostSubject(FailureStrategy failureStrategy, TabHost subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<TabHostSubject, TabHost> type() {
    return new SubjectFactory<TabHostSubject, TabHost>() {
      @Override
      public TabHostSubject getSubject(FailureStrategy fs, TabHost that) {
        return new TabHostSubject(fs, that);
      }
    };
  }

  public TabHostSubject hasCurrentTab(int tab) {
    assertThat(actual().getCurrentTab())
        .named("current tab")
        .isEqualTo(tab);
    return this;
  }

  public TabHostSubject hasCurrentTabTag(String tag) {
    assertThat(actual().getCurrentTabTag())
        .named("current tab tag")
        .isEqualTo(tag);
    return this;
  }

  public TabHostSubject hasCurrentTabView(View view) {
    assertThat(actual().getCurrentTabView())
        .named("current tab view")
        .isSameAs(view);
    return this;
  }

  public TabHostSubject hasCurrentView(View view) {
    assertThat(actual().getCurrentView())
        .named("current view")
        .isSameAs(view);
    return this;
  }
}
