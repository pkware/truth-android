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

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ListPopupWindow;
import android.widget.ListView;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.widget.ListPopupWindow.INPUT_METHOD_FROM_FOCUSABLE;
import static android.widget.ListPopupWindow.INPUT_METHOD_NEEDED;
import static android.widget.ListPopupWindow.INPUT_METHOD_NOT_NEEDED;
import static com.pkware.truth.android.internal.IntegerUtils.buildNamedValueString;

/**
 * Propositions for {@link ListPopupWindow} subjects.
 */
public class ListPopupWindowSubject extends Subject {

  @Nullable
  private final ListPopupWindow actual;

  public ListPopupWindowSubject(@Nonnull FailureMetadata failureMetadata, @Nullable ListPopupWindow actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  @Nonnull
  public static String inputMethodModeToString(@ListPopupWindowInputMethodMode int mode) {
    return buildNamedValueString(mode)
        .value(INPUT_METHOD_FROM_FOCUSABLE, "fromFocusable")
        .value(INPUT_METHOD_NEEDED, "needed")
        .value(INPUT_METHOD_NOT_NEEDED, "notNeeded")
        .get();
  }

  public void hasAnchorView(@Nullable View view) {
    check("getAnchorView()").that(actual.getAnchorView()).isSameInstanceAs(view);
  }

  public void hasAnimationStyle(int style) {
    check("getAnimationStyle()").that(actual.getAnimationStyle()).isEqualTo(style);
  }

  public void hasBackground(@Nullable Drawable background) {
    check("getBackground()").that(actual.getBackground()).isSameInstanceAs(background);
  }

  public void hasHeight(int height) {
    check("getHeight()").that(actual.getHeight()).isEqualTo(height);
  }

  public void hasHorizontalOffset(int offset) {
    check("getHorizontalOffset()").that(actual.getHorizontalOffset()).isEqualTo(offset);
  }

  public void hasInputMethodMode(@ListPopupWindowInputMethodMode int mode) {
    int actualMode = actual.getInputMethodMode();
    //noinspection ResourceType
    check("getInputMethodMode()")
        .withMessage("Expected input method mode <%s> but was <%s>.",
            inputMethodModeToString(mode), inputMethodModeToString(actualMode))
        .that(actualMode)
        .isEqualTo(mode);
  }

  public void hasListView(@Nullable ListView view) {
    check("getListView()").that(actual.getListView()).isSameInstanceAs(view);
  }

  public void hasPromptPosition(int position) {
    check("getPromptPosition()").that(actual.getPromptPosition()).isEqualTo(position);
  }

  public void hasSelectedItem(@Nullable Object item) {
    check("getSelectedItem()").that(actual.getSelectedItem()).isEqualTo(item);
  }

  public void hasSelectedItemId(long id) {
    check("getSelectedItemId()").that(actual.getSelectedItemId()).isEqualTo(id);
  }

  public void hasSelectedItemPosition(int position) {
    check("getSelectedItemPosition()").that(actual.getSelectedItemPosition()).isEqualTo(position);
  }

  public void hasSelectedItemView(@Nullable View view) {
    check("getSelectedView()").that(actual.getSelectedView()).isSameInstanceAs(view);
  }

  public void hasSoftInputMode(int mode) {
    check("getSoftInputMode()").that(actual.getSoftInputMode()).isEqualTo(mode);
  }

  public void hasVerticalOffset(int offset) {
    check("getVerticalOffset()").that(actual.getVerticalOffset()).isEqualTo(offset);
  }

  public void hasWidth(int width) {
    check("getWidth()").that(actual.getWidth()).isEqualTo(width);
  }

  public void isModal() {
    check("isModal()").that(actual.isModal()).isTrue();
  }

  public void isNotModal() {
    check("isModal()").that(actual.isModal()).isFalse();
  }

  public void isShowing() {
    check("isShowing()").that(actual.isShowing()).isTrue();
  }

  public void isNotShowing() {
    check("isShowing()").that(actual.isShowing()).isFalse();
  }
}
