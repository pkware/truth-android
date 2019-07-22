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
import android.widget.HeaderViewListAdapter;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link HeaderViewListAdapter} subjects.
 */
public class HeaderViewListAdapterSubject extends AbstractWrapperListAdapterSubject<HeaderViewListAdapterSubject, HeaderViewListAdapter> {
  protected HeaderViewListAdapterSubject(FailureMetadata failureMetadata, HeaderViewListAdapter subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<HeaderViewListAdapterSubject, HeaderViewListAdapter> type() {
    return HeaderViewListAdapterSubject::new;
  }

  public HeaderViewListAdapterSubject hasFootersCount(int count) {
    assertThat(actual().getFootersCount())
        .named("footers count")
        .isEqualTo(count);
    return this;
  }

  public HeaderViewListAdapterSubject hasHeadersCount(int count) {
    assertThat(actual().getHeadersCount())
        .named("headers count")
        .isEqualTo(count);
    return this;
  }

  public HeaderViewListAdapterSubject hasFilter(Filter filter) {
    assertThat(actual().getFilter())
        .named("filter")
        .isSameAs(filter);
    return this;
  }
}
