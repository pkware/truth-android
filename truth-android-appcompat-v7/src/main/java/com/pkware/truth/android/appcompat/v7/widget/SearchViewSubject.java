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
package com.pkware.truth.android.appcompat.v7.widget;

import android.support.annotation.StringRes;
import android.support.v4.widget.CursorAdapter;
import android.support.v7.widget.SearchView;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link SearchView} subjects.
 */
public class SearchViewSubject extends AbstractLinearLayoutCompatSubject<SearchViewSubject, SearchView> {
  protected SearchViewSubject(FailureStrategy failureStrategy, SearchView subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<SearchViewSubject, SearchView> type() {
    return new SubjectFactory<SearchViewSubject, SearchView>() {
      @Override
      public SearchViewSubject getSubject(FailureStrategy fs, SearchView that) {
        return new SearchViewSubject(fs, that);
      }
    };
  }

  public SearchViewSubject hasImeOptions(int options) {
    assertThat(getSubject().getImeOptions())
        .named("IME options")
        .isEqualTo(options);
    return this;
  }

  public SearchViewSubject hasInputType(int type) {
    assertThat(getSubject().getInputType())
        .named("input type")
        .isEqualTo(type);
    return this;
  }

  public SearchViewSubject hasMaximumWidth(int width) {
    assertThat(getSubject().getMaxWidth())
        .named("maximum width")
        .isEqualTo(width);
    return this;
  }

  public SearchViewSubject hasQuery(String query) {
    assertThat(getSubject().getQuery().toString())
        .named("query")
        .isEqualTo(query);
    return this;
  }

  public SearchViewSubject hasQueryHint(String hint) {
    assertThat(getSubject().getQueryHint().toString())
        .named("query hint")
        .isEqualTo(hint);
    return this;
  }

  public SearchViewSubject hasQueryHint(@StringRes int resId) {
    return hasQueryHint(getSubject().getContext().getString(resId));
  }

  public SearchViewSubject hasSuggestionsAdapter(CursorAdapter adapter) {
    assertThat(getSubject().getSuggestionsAdapter())
        .named("suggestions adapter")
        .isSameAs(adapter);
    return this;
  }

  public SearchViewSubject isIconifiedByDefault() {
    assertThat(getSubject().isIconfiedByDefault())
        .named("is iconified by default")
        .isTrue();
    return this;
  }

  public SearchViewSubject isNotIconifiedByDefault() {
    assertThat(getSubject().isIconfiedByDefault())
        .named("is iconified by default")
        .isFalse();
    return this;
  }

  public SearchViewSubject isIconified() {
    assertThat(getSubject().isIconified())
        .named("is iconified")
        .isTrue();
    return this;
  }

  public SearchViewSubject isNotIconified() {
    assertThat(getSubject().isIconified())
        .named("is iconified")
        .isFalse();
    return this;
  }

  public SearchViewSubject isQueryRefinementEnabled() {
    assertThat(getSubject().isQueryRefinementEnabled())
        .named("query refinement is enabled")
        .isTrue();
    return this;
  }

  public SearchViewSubject isQueryRefinementDisabled() {
    assertThat(!getSubject().isQueryRefinementEnabled())
        .named("query refinement is disabled")
        .isTrue();
    return this;
  }

  public SearchViewSubject isSubmitButtonEnabled() {
    assertThat(getSubject().isSubmitButtonEnabled())
        .named("submit button is enabled")
        .isTrue();
    return this;
  }

  public SearchViewSubject isSubmitButtonDisabled() {
    assertThat(!getSubject().isSubmitButtonEnabled())
        .named("submit button is disabled")
        .isTrue();
    return this;
  }
}
