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

import android.widget.Filter;
import android.widget.SimpleAdapter;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link SimpleAdapter} subjects.
 */
public class SimpleAdapterSubject
    extends AbstractListAdapterSubject<SimpleAdapterSubject, SimpleAdapter> {
  protected SimpleAdapterSubject(FailureMetadata failureMetadata, SimpleAdapter subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<SimpleAdapterSubject, SimpleAdapter> type() {
    return new Subject.Factory<SimpleAdapterSubject, SimpleAdapter>() {
      @Override
      public SimpleAdapterSubject createSubject(FailureMetadata fm, SimpleAdapter that) {
        return new SimpleAdapterSubject(fm, that);
      }
    };
  }

  public SimpleAdapterSubject hasFilter(Filter filter) {
    assertThat(actual().getFilter())
        .named("filter")
        .isSameAs(filter);
    return this;
  }

  public SimpleAdapterSubject hasViewBinder(SimpleAdapter.ViewBinder binder) {
    assertThat(actual().getViewBinder())
        .named("view binder")
        .isSameAs(binder);
    return this;
  }
}
