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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link HeaderViewListAdapter} subjects.
 */
public class HeaderViewListAdapterSubject extends AbstractWrapperListAdapterSubject<HeaderViewListAdapter> {

  @Nullable
  private final HeaderViewListAdapter actual;

  public HeaderViewListAdapterSubject(@Nonnull FailureMetadata failureMetadata, @Nullable HeaderViewListAdapter actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public HeaderViewListAdapterSubject hasFootersCount(int count) {
    check("getFootersCount()").that(actual.getFootersCount()).isEqualTo(count);
    return this;
  }

  public HeaderViewListAdapterSubject hasHeadersCount(int count) {
    check("getHeadersCount()").that(actual.getHeadersCount()).isEqualTo(count);
    return this;
  }

  public HeaderViewListAdapterSubject hasFilter(@Nullable Filter filter) {
    check("getFilter()").that(actual.getFilter()).isSameInstanceAs(filter);
    return this;
  }
}
