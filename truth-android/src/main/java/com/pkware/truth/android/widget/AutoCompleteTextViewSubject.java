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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.os.Build.VERSION_CODES.JELLY_BEAN;

/**
 * Propositions for {@link AutoCompleteTextView} subjects.
 */
public class AutoCompleteTextViewSubject extends AbstractTextViewSubject<AutoCompleteTextView> {

  @Nullable
  private final AutoCompleteTextView actual;

  public AutoCompleteTextViewSubject(@Nonnull FailureMetadata failureMetadata, @Nullable AutoCompleteTextView actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public AutoCompleteTextViewSubject hasEnoughToFilter() {
    check("enoughToFilter()").that(actual.enoughToFilter()).isTrue();
    return this;
  }

  public AutoCompleteTextViewSubject hasAdapter(@Nullable ListAdapter adapter) {
    check("getAdapter()").that(actual.getAdapter()).isSameInstanceAs(adapter);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public AutoCompleteTextViewSubject hasCompletionHint(@Nullable String hint) {
    check("getCompletionHint()").that(actual.getCompletionHint().toString()).isEqualTo(hint);
    return this;
  }

  public AutoCompleteTextViewSubject hasCompletionHint(@StringRes int resId) {
    return hasCompletionHint(actual.getContext().getString(resId));
  }

  public AutoCompleteTextViewSubject hasDropDownAnchor(int id) {
    check("getDropDownAnchor()").that(actual.getDropDownAnchor()).isEqualTo(id);
    return this;
  }

  public AutoCompleteTextViewSubject hasDropDownBackground(@Nullable Drawable background) {
    check("getDropDownBackground()").that(actual.getDropDownBackground()).isSameInstanceAs(background);
    return this;
  }

  public AutoCompleteTextViewSubject hasDropDownHeight(int height) {
    check("getDropDownHeight()").that(actual.getDropDownHeight()).isEqualTo(height);
    return this;
  }

  public AutoCompleteTextViewSubject hasDropDownHorizontalOffset(int offset) {
    check("getDropDownHorizontalOffset()").that(actual.getDropDownHorizontalOffset()).isEqualTo(offset);
    return this;
  }

  public AutoCompleteTextViewSubject hasDropDownVerticalOffset(int offset) {
    check("getDropDownVerticalOffset()").that(actual.getDropDownVerticalOffset()).isEqualTo(offset);
    return this;
  }

  public AutoCompleteTextViewSubject hasDropDownWidth(int width) {
    check("getDropDownWidth()").that(actual.getDropDownWidth()).isEqualTo(width);
    return this;
  }

  public AutoCompleteTextViewSubject hasListSelection(int position) {
    check("getListSelection()").that(actual.getListSelection()).isEqualTo(position);
    return this;
  }

  public AutoCompleteTextViewSubject hasThreshold(int threshold) {
    check("getThreshold()").that(actual.getThreshold()).isEqualTo(threshold);
    return this;
  }

  public AutoCompleteTextViewSubject isPerformingCompletion() {
    check("isPerformingCompletion()").that(actual.isPerformingCompletion()).isTrue();
    return this;
  }

  public AutoCompleteTextViewSubject isNotPerformingCompletion() {
    check("isPerformingCompletion()").that(actual.isPerformingCompletion()).isFalse();
    return this;
  }

  public AutoCompleteTextViewSubject isShowingPopup() {
    check("isPopupShowing()").that(actual.isPopupShowing()).isTrue();
    return this;
  }

  public AutoCompleteTextViewSubject isNotShowingPopup() {
    check("isPopupShowing()").that(actual.isPopupShowing()).isFalse();
    return this;
  }
}
