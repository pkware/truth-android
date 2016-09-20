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

import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link ExpandableListView} subjects.
 */
public class ExpandableListViewSubject extends AbstractListViewSubject<ExpandableListViewSubject, ExpandableListView> {
  protected ExpandableListViewSubject(FailureStrategy failureStrategy, ExpandableListView subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<ExpandableListViewSubject, ExpandableListView> type() {
    return new SubjectFactory<ExpandableListViewSubject, ExpandableListView>() {
      @Override
      public ExpandableListViewSubject getSubject(FailureStrategy fs, ExpandableListView that) {
        return new ExpandableListViewSubject(fs, that);
      }
    };
  }

  public ExpandableListViewSubject hasExpandableListAdapter(ExpandableListAdapter adapter) {
    assertThat(actual().getExpandableListAdapter())
        .named("expandable list adapter")
        .isSameAs(adapter);
    return this;
  }

  public ExpandableListViewSubject hasSelectedId(long id) {
    assertThat(actual().getSelectedId())
        .named("selected ID")
        .isEqualTo(id);
    return this;
  }

  public ExpandableListViewSubject hasSelectedPosition(long position) {
    assertThat(actual().getSelectedPosition())
        .named("selected position")
        .isEqualTo(position);
    return this;
  }
}
