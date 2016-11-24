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
import android.widget.ViewSwitcher;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link ViewSwitcher} subjects.
 */
public class ViewSwitcherSubject
    extends AbstractViewAnimatorSubject<ViewSwitcherSubject, ViewSwitcher> {
  protected ViewSwitcherSubject(FailureStrategy failureStrategy, ViewSwitcher subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<ViewSwitcherSubject, ViewSwitcher> type() {
    return new SubjectFactory<ViewSwitcherSubject, ViewSwitcher>() {
      @Override
      public ViewSwitcherSubject getSubject(FailureStrategy fs, ViewSwitcher that) {
        return new ViewSwitcherSubject(fs, that);
      }
    };
  }

  public ViewSwitcherSubject hasNextView(View view) {
    View actualView = actual().getNextView();
    assertThat(actual().getNextView())
        .named("next view")
        .isSameAs(view);
    return this;
  }
}
