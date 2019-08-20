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

import android.annotation.TargetApi;
import android.widget.CursorAdapter;
import android.widget.SearchView;

import androidx.annotation.StringRes;

import com.google.common.truth.FailureMetadata;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.os.Build.VERSION_CODES.HONEYCOMB;
import static android.os.Build.VERSION_CODES.JELLY_BEAN;

/**
 * Propositions for {@link SearchView} subjects.
 */
@TargetApi(HONEYCOMB)
public class SearchViewSubject extends AbstractLinearLayoutSubject<SearchView> {

  @Nullable
  private final SearchView actual;

  public SearchViewSubject(@Nonnull FailureMetadata failureMetadata, @Nullable SearchView actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  @TargetApi(JELLY_BEAN)
  public SearchViewSubject hasImeOptions(int options) {
    check("getImeOptions()").that(actual.getImeOptions()).isEqualTo(options);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public SearchViewSubject hasInputType(int type) {
    check("getInputType()").that(actual.getInputType()).isEqualTo(type);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public SearchViewSubject hasMaximumWidth(int width) {
    check("getMaxWidth()").that(actual.getMaxWidth()).isEqualTo(width);
    return this;
  }

  public SearchViewSubject hasQuery(@Nullable String query) {
    check("getQuery()").that(actual.getQuery().toString()).isEqualTo(query);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public SearchViewSubject hasQueryHint(@Nullable String hint) {
    CharSequence actualHint = actual.getQueryHint();
    String actualHintString;
    if (actualHint == null) {
      actualHintString = null;
    } else {
      actualHintString = actualHint.toString();
    }
    check("getQueryHint()").that(actualHintString).isEqualTo(hint);
    return this;
  }

  public SearchViewSubject hasQueryHint(@StringRes int resId) {
    return hasQueryHint(actual.getContext().getString(resId));
  }

  public SearchViewSubject hasSuggestionsAdapter(@Nullable CursorAdapter adapter) {
    check("getSuggestionsAdapter()").that(actual.getSuggestionsAdapter()).isSameInstanceAs(adapter);
    return this;
  }

  public SearchViewSubject isIconifiedByDefault() {
    check("isIconfiedByDefault()").that(actual.isIconfiedByDefault()).isTrue();
    return this;
  }

  public SearchViewSubject isNotIconifiedByDefault() {
    check("isIconfiedByDefault()").that(actual.isIconfiedByDefault()).isFalse();
    return this;
  }

  public SearchViewSubject isIconified() {
    check("isIconified()").that(actual.isIconified()).isTrue();
    return this;
  }

  public SearchViewSubject isNotIconified() {
    check("isIconified()").that(actual.isIconified()).isFalse();
    return this;
  }

  public SearchViewSubject isQueryRefinementEnabled() {
    check("isQueryRefinementEnabled()").that(actual.isQueryRefinementEnabled()).isTrue();
    return this;
  }

  public SearchViewSubject isQueryRefinementDisabled() {
    check("isQueryRefinementEnabled()").that(actual.isQueryRefinementEnabled()).isFalse();
    return this;
  }

  public SearchViewSubject isSubmitButtonEnabled() {
    check("isSubmitButtonEnabled()").that(actual.isSubmitButtonEnabled()).isTrue();
    return this;
  }

  public SearchViewSubject isSubmitButtonDisabled() {
    check("isSubmitButtonEnabled()").that(actual.isSubmitButtonEnabled()).isFalse();
    return this;
  }
}
