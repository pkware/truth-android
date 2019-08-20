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

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import com.google.common.truth.FailureMetadata;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link ArrayAdapter} subjects.
 */
public class ArrayAdapterSubject extends AbstractListAdapterSubject<ArrayAdapterSubject, ArrayAdapter> {
  public ArrayAdapterSubject(FailureMetadata failureMetadata, ArrayAdapter subject) {
    super(failureMetadata, subject);
  }

  public ArrayAdapterSubject hasContext(Context context) {
    assertThat(actual().getContext())
        .named("context")
        .isSameAs(context);
    return this;
  }

  public ArrayAdapterSubject hasFilter(Filter filter) {
    assertThat(actual().getFilter())
        .named("filter")
        .isSameAs(filter);
    return this;
  }
}
