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
package com.pkware.truth.androidx.appcompat.widget;

import androidx.annotation.StringRes;
import androidx.appcompat.widget.SearchView;
import androidx.cursoradapter.widget.CursorAdapter;
import com.google.common.truth.FailureMetadata;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link SearchView} subjects.
 */
public class SearchViewSubject extends AbstractLinearLayoutCompatSubject<SearchViewSubject, SearchView> {
  public SearchViewSubject(FailureMetadata failureMetadata, SearchView subject) {
    super(failureMetadata, subject);
  }

  public SearchViewSubject hasImeOptions(int options) {
    assertThat(actual().getImeOptions())
        .named("IME options")
        .isEqualTo(options);
    return this;
  }

  public SearchViewSubject hasInputType(int type) {
    assertThat(actual().getInputType())
        .named("input type")
        .isEqualTo(type);
    return this;
  }

  public SearchViewSubject hasMaximumWidth(int width) {
    assertThat(actual().getMaxWidth())
        .named("maximum width")
        .isEqualTo(width);
    return this;
  }

  public SearchViewSubject hasQuery(String query) {
    assertThat(actual().getQuery().toString())
        .named("query")
        .isEqualTo(query);
    return this;
  }

  public SearchViewSubject hasQueryHint(String hint) {
    CharSequence actualHint = actual().getQueryHint();
    String actualHintString;
    if (actualHint == null) {
      actualHintString = null;
    } else {
      actualHintString = actualHint.toString();
    }
    assertThat(actualHintString)
        .named("query hint")
        .isEqualTo(hint);
    return this;
  }

  public SearchViewSubject hasQueryHint(@StringRes int resId) {
    return hasQueryHint(actual().getContext().getString(resId));
  }

  public SearchViewSubject hasSuggestionsAdapter(CursorAdapter adapter) {
    assertThat(actual().getSuggestionsAdapter())
        .named("suggestions adapter")
        .isSameAs(adapter);
    return this;
  }

  public SearchViewSubject isIconifiedByDefault() {
    assertThat(actual().isIconfiedByDefault())
        .named("is iconified by default")
        .isTrue();
    return this;
  }

  public SearchViewSubject isNotIconifiedByDefault() {
    assertThat(actual().isIconfiedByDefault())
        .named("is iconified by default")
        .isFalse();
    return this;
  }

  public SearchViewSubject isIconified() {
    assertThat(actual().isIconified())
        .named("is iconified")
        .isTrue();
    return this;
  }

  public SearchViewSubject isNotIconified() {
    assertThat(actual().isIconified())
        .named("is iconified")
        .isFalse();
    return this;
  }

  public SearchViewSubject isQueryRefinementEnabled() {
    assertThat(actual().isQueryRefinementEnabled())
        .named("query refinement is enabled")
        .isTrue();
    return this;
  }

  public SearchViewSubject isQueryRefinementDisabled() {
    assertThat(!actual().isQueryRefinementEnabled())
        .named("query refinement is disabled")
        .isTrue();
    return this;
  }

  public SearchViewSubject isSubmitButtonEnabled() {
    assertThat(actual().isSubmitButtonEnabled())
        .named("submit button is enabled")
        .isTrue();
    return this;
  }

  public SearchViewSubject isSubmitButtonDisabled() {
    assertThat(!actual().isSubmitButtonEnabled())
        .named("submit button is disabled")
        .isTrue();
    return this;
  }
}
