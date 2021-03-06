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
  public void hasImeOptions(int options) {
    check("getImeOptions()").that(actual.getImeOptions()).isEqualTo(options);
  }

  @TargetApi(JELLY_BEAN)
  public void hasInputType(int type) {
    check("getInputType()").that(actual.getInputType()).isEqualTo(type);
  }

  @TargetApi(JELLY_BEAN)
  public void hasMaximumWidth(int width) {
    check("getMaxWidth()").that(actual.getMaxWidth()).isEqualTo(width);
  }

  public void hasQuery(@Nullable String query) {
    check("getQuery()").that(actual.getQuery().toString()).isEqualTo(query);
  }

  @TargetApi(JELLY_BEAN)
  public void hasQueryHint(@Nullable String hint) {
    CharSequence actualHint = actual.getQueryHint();
    String actualHintString;
    if (actualHint == null) {
      actualHintString = null;
    } else {
      actualHintString = actualHint.toString();
    }
    check("getQueryHint()").that(actualHintString).isEqualTo(hint);
  }

  public void hasQueryHint(@StringRes int resId) {
    hasQueryHint(actual.getContext().getString(resId));
  }

  public void hasSuggestionsAdapter(@Nullable CursorAdapter adapter) {
    check("getSuggestionsAdapter()").that(actual.getSuggestionsAdapter()).isSameInstanceAs(adapter);
  }

  public void isIconifiedByDefault() {
    check("isIconfiedByDefault()").that(actual.isIconfiedByDefault()).isTrue();
  }

  public void isNotIconifiedByDefault() {
    check("isIconfiedByDefault()").that(actual.isIconfiedByDefault()).isFalse();
  }

  public void isIconified() {
    check("isIconified()").that(actual.isIconified()).isTrue();
  }

  public void isNotIconified() {
    check("isIconified()").that(actual.isIconified()).isFalse();
  }

  public void isQueryRefinementEnabled() {
    check("isQueryRefinementEnabled()").that(actual.isQueryRefinementEnabled()).isTrue();
  }

  public void isQueryRefinementDisabled() {
    check("isQueryRefinementEnabled()").that(actual.isQueryRefinementEnabled()).isFalse();
  }

  public void isSubmitButtonEnabled() {
    check("isSubmitButtonEnabled()").that(actual.isSubmitButtonEnabled()).isTrue();
  }

  public void isSubmitButtonDisabled() {
    check("isSubmitButtonEnabled()").that(actual.isSubmitButtonEnabled()).isFalse();
  }
}
