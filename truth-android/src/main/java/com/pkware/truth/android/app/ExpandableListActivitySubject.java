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

import android.app.ExpandableListActivity;
import com.google.common.truth.FailureMetadata;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link ExpandableListActivity} subjects.
 */
public class ExpandableListActivitySubject extends AbstractActivitySubject<ExpandableListActivitySubject, ExpandableListActivity> {
  public ExpandableListActivitySubject(FailureMetadata failureMetadata, ExpandableListActivity subject) {
    super(failureMetadata, subject);
  }

  public ExpandableListActivitySubject hasSelectedId(long id) {
    assertThat(actual().getSelectedId())
        .named("selected id")
        .isEqualTo(id);
    return this;
  }

  public ExpandableListActivitySubject hasSelectedPosition(long position) {
    assertThat(actual().getSelectedPosition())
        .named("selected position")
        .isEqualTo(position);
    return this;
  }
}
