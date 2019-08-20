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
import android.graphics.drawable.Drawable;
import android.widget.AutoCompleteTextView;
import android.widget.ListAdapter;
import androidx.annotation.StringRes;

import com.google.common.truth.FailureMetadata;

import static android.os.Build.VERSION_CODES.JELLY_BEAN;
import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link AutoCompleteTextView} subjects.
 */
public class AutoCompleteTextViewSubject extends AbstractTextViewSubject<AutoCompleteTextViewSubject, AutoCompleteTextView> {
  public AutoCompleteTextViewSubject(FailureMetadata failureMetadata, AutoCompleteTextView subject) {
    super(failureMetadata, subject);
  }

  public AutoCompleteTextViewSubject hasEnoughToFilter() {
    assertThat(actual().enoughToFilter())
        .named("has enough to filter")
        .isTrue();
    return this;
  }

  public AutoCompleteTextViewSubject hasAdapter(ListAdapter adapter) {
    assertThat(actual().getAdapter())
        .named("adapter")
        .isSameAs(adapter);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public AutoCompleteTextViewSubject hasCompletionHint(String hint) {
    assertThat(actual().getCompletionHint().toString())
        .named("completion hint")
        .isEqualTo(hint);
    return this;
  }

  public AutoCompleteTextViewSubject hasCompletionHint(@StringRes int resId) {
    return hasCompletionHint(actual().getContext().getString(resId));
  }

  public AutoCompleteTextViewSubject hasDropDownAnchor(int id) {
    assertThat(actual().getDropDownAnchor())
        .named("drop-down anchor ID")
        .isEqualTo(id);
    return this;
  }

  public AutoCompleteTextViewSubject hasDropDownBackground(Drawable background) {
    assertThat(actual().getDropDownBackground())
        .named("drop-down background")
        .isSameAs(background);
    return this;
  }

  public AutoCompleteTextViewSubject hasDropDownHeight(int height) {
    assertThat(actual().getDropDownHeight())
        .named("drop-down height")
        .isEqualTo(height);
    return this;
  }

  public AutoCompleteTextViewSubject hasDropDownHorizontalOffset(int offset) {
    assertThat(actual().getDropDownHorizontalOffset())
        .named("drop-down horizontal offset")
        .isEqualTo(offset);
    return this;
  }

  public AutoCompleteTextViewSubject hasDropDownVerticalOffset(int offset) {
    assertThat(actual().getDropDownVerticalOffset())
        .named("drop-down vertical offset")
        .isEqualTo(offset);
    return this;
  }

  public AutoCompleteTextViewSubject hasDropDownWidth(int width) {
    assertThat(actual().getDropDownWidth())
        .named("drop-down width")
        .isEqualTo(width);
    return this;
  }

  public AutoCompleteTextViewSubject hasListSelection(int position) {
    assertThat(actual().getListSelection())
        .named("list selection position")
        .isEqualTo(position);
    return this;
  }

  public AutoCompleteTextViewSubject hasThreshold(int threshold) {
    assertThat(actual().getThreshold())
        .named("threshold")
        .isEqualTo(threshold);
    return this;
  }

  public AutoCompleteTextViewSubject isPerformingCompletion() {
    assertThat(actual().isPerformingCompletion())
        .named("is performing completion")
        .isTrue();
    return this;
  }

  public AutoCompleteTextViewSubject isNotPerformingCompletion() {
    assertThat(actual().isPerformingCompletion())
        .named("is performing completion")
        .isFalse();
    return this;
  }

  public AutoCompleteTextViewSubject isShowingPopup() {
    assertThat(actual().isPopupShowing())
        .named("is showing popup")
        .isTrue();
    return this;
  }

  public AutoCompleteTextViewSubject isNotShowingPopup() {
    assertThat(actual().isPopupShowing())
        .named("is showing popup")
        .isFalse();
    return this;
  }
}
