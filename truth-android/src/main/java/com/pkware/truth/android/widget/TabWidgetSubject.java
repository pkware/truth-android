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

import android.widget.TabWidget;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link TabWidget} subjects.
 */
public class TabWidgetSubject extends AbstractLinearLayoutSubject<TabWidgetSubject, TabWidget> {
  protected TabWidgetSubject(FailureStrategy failureStrategy, TabWidget subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<TabWidgetSubject, TabWidget> type() {
    return new SubjectFactory<TabWidgetSubject, TabWidget>() {
      @Override
      public TabWidgetSubject getSubject(FailureStrategy fs, TabWidget that) {
        return new TabWidgetSubject(fs, that);
      }
    };
  }

  public TabWidgetSubject hasTabCount(int count) {
    assertThat(getSubject().getTabCount())
        .named("tab count")
        .isEqualTo(count);
    return this;
  }

  public TabWidgetSubject isStripEnabled() {
    assertThat(getSubject().isStripEnabled())
        .named("is strip enabled")
        .isTrue();
    return this;
  }

  public TabWidgetSubject isStripDisabled() {
    assertThat(!getSubject().isStripEnabled())
        .named("is strip disabled")
        .isTrue();
    return this;
  }
}
