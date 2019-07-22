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
package com.pkware.truth.android.app;

import android.app.ListFragment;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link ListFragment} subjects.
 */
public class ListFragmentSubject extends AbstractFragmentSubject<ListFragmentSubject, ListFragment> {
  protected ListFragmentSubject(FailureMetadata failureMetadata, ListFragment subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<ListFragmentSubject, ListFragment> type() {
    return ListFragmentSubject::new;
  }

  public ListFragmentSubject hasSelectedItemId(long id) {
    assertThat(actual().getSelectedItemId())
        .named("selected item id")
        .isEqualTo(id);
    return this;
  }

  public ListFragmentSubject hasSelectedItemPosition(int position) {
    assertThat(actual().getSelectedItemPosition())
        .named("selected item position")
        .isEqualTo(position);
    return this;
  }
}
