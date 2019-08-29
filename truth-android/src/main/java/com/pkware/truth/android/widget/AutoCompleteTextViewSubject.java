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

  public void hasEnoughToFilter() {
    check("enoughToFilter()").that(actual.enoughToFilter()).isTrue();
  }

  public void hasAdapter(@Nullable ListAdapter adapter) {
    check("getAdapter()").that(actual.getAdapter()).isSameInstanceAs(adapter);
  }

  @TargetApi(JELLY_BEAN)
  public void hasCompletionHint(@Nullable String hint) {
    check("getCompletionHint()").that(actual.getCompletionHint().toString()).isEqualTo(hint);
  }

  public void hasCompletionHint(@StringRes int resId) {
    hasCompletionHint(actual.getContext().getString(resId));
  }

  public void hasDropDownAnchor(int id) {
    check("getDropDownAnchor()").that(actual.getDropDownAnchor()).isEqualTo(id);
  }

  public void hasDropDownBackground(@Nullable Drawable background) {
    check("getDropDownBackground()").that(actual.getDropDownBackground()).isSameInstanceAs(background);
  }

  public void hasDropDownHeight(int height) {
    check("getDropDownHeight()").that(actual.getDropDownHeight()).isEqualTo(height);
  }

  public void hasDropDownHorizontalOffset(int offset) {
    check("getDropDownHorizontalOffset()").that(actual.getDropDownHorizontalOffset()).isEqualTo(offset);
  }

  public void hasDropDownVerticalOffset(int offset) {
    check("getDropDownVerticalOffset()").that(actual.getDropDownVerticalOffset()).isEqualTo(offset);
  }

  public void hasDropDownWidth(int width) {
    check("getDropDownWidth()").that(actual.getDropDownWidth()).isEqualTo(width);
  }

  public void hasListSelection(int position) {
    check("getListSelection()").that(actual.getListSelection()).isEqualTo(position);
  }

  public void hasThreshold(int threshold) {
    check("getThreshold()").that(actual.getThreshold()).isEqualTo(threshold);
  }

  public void isPerformingCompletion() {
    check("isPerformingCompletion()").that(actual.isPerformingCompletion()).isTrue();
  }

  public void isNotPerformingCompletion() {
    check("isPerformingCompletion()").that(actual.isPerformingCompletion()).isFalse();
  }

  public void isShowingPopup() {
    check("isPopupShowing()").that(actual.isPopupShowing()).isTrue();
  }

  public void isNotShowingPopup() {
    check("isPopupShowing()").that(actual.isPopupShowing()).isFalse();
  }
}
