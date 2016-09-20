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
package com.pkware.truth.android.widget;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ListPopupWindow;
import android.widget.ListView;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static android.widget.ListPopupWindow.INPUT_METHOD_FROM_FOCUSABLE;
import static android.widget.ListPopupWindow.INPUT_METHOD_NEEDED;
import static android.widget.ListPopupWindow.INPUT_METHOD_NOT_NEEDED;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assert_;
import static com.pkware.truth.android.internal.IntegerUtils.buildNamedValueString;

/**
 * Propositions for {@link ListPopupWindow} subjects.
 */
public class ListPopupWindowSubject extends Subject<ListPopupWindowSubject, ListPopupWindow> {
  protected ListPopupWindowSubject(FailureStrategy failureStrategy, ListPopupWindow subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<ListPopupWindowSubject, ListPopupWindow> type() {
    return new SubjectFactory<ListPopupWindowSubject, ListPopupWindow>() {
      @Override
      public ListPopupWindowSubject getSubject(FailureStrategy fs, ListPopupWindow that) {
        return new ListPopupWindowSubject(fs, that);
      }
    };
  }

  public static String inputMethodModeToString(@ListPopupWindowInputMethodMode int mode) {
    return buildNamedValueString(mode)
        .value(INPUT_METHOD_FROM_FOCUSABLE, "fromFocusable")
        .value(INPUT_METHOD_NEEDED, "needed")
        .value(INPUT_METHOD_NOT_NEEDED, "notNeeded")
        .get();
  }

  public ListPopupWindowSubject hasAnchorView(View view) {
    assertThat(actual().getAnchorView())
        .named("anchor view")
        .isSameAs(view);
    return this;
  }

  public ListPopupWindowSubject hasAnimationStyle(int style) {
    assertThat(actual().getAnimationStyle())
        .named("animation style")
        .isEqualTo(style);
    return this;
  }

  public ListPopupWindowSubject hasBackground(Drawable background) {
    assertThat(actual().getBackground())
        .named("background")
        .isSameAs(background);
    return this;
  }

  public ListPopupWindowSubject hasHeight(int height) {
    assertThat(actual().getHeight())
        .named("height")
        .isEqualTo(height);
    return this;
  }

  public ListPopupWindowSubject hasHorizontalOffset(int offset) {
    assertThat(actual().getHorizontalOffset())
        .named("horizontal offset")
        .isEqualTo(offset);
    return this;
  }

  public ListPopupWindowSubject hasInputMethodMode(@ListPopupWindowInputMethodMode int mode) {
    int actualMode = actual().getInputMethodMode();
    //noinspection ResourceType
    assert_()
        .withFailureMessage("Expected input method mode <%s> but was <%s>.",
            inputMethodModeToString(mode), inputMethodModeToString(actualMode))
        .that(actualMode)
        .isEqualTo(mode);
    return this;
  }

  public ListPopupWindowSubject hasListView(ListView view) {
    assertThat(actual().getListView())
        .named("ListView")
        .isSameAs(view);
    return this;
  }

  public ListPopupWindowSubject hasPromptPosition(int position) {
    assertThat(actual().getPromptPosition())
        .named("prompt position")
        .isEqualTo(position);
    return this;
  }

  public ListPopupWindowSubject hasSelectedItem(Object item) {
    assertThat(actual().getSelectedItem())
        .named("selected item")
        .isEqualTo(item);
    return this;
  }

  public ListPopupWindowSubject hasSelectedItemId(long id) {
    assertThat(actual().getSelectedItemId())
        .named("selected item ID")
        .isEqualTo(id);
    return this;
  }

  public ListPopupWindowSubject hasSelectedItemPosition(int position) {
    assertThat(actual().getSelectedItemPosition())
        .named("selected item position")
        .isEqualTo(position);
    return this;
  }

  public ListPopupWindowSubject hasSelectedItemView(View view) {
    assertThat(actual().getSelectedView())
        .named("selected item view")
        .isSameAs(view);
    return this;
  }

  public ListPopupWindowSubject hasSoftInputMode(int mode) {
    assertThat(actual().getSoftInputMode())
        .named("soft input mode")
        .isEqualTo(mode);
    return this;
  }

  public ListPopupWindowSubject hasVerticalOffset(int offset) {
    assertThat(actual().getVerticalOffset())
        .named("vertical offset")
        .isEqualTo(offset);
    return this;
  }

  public ListPopupWindowSubject hasWidth(int width) {
    assertThat(actual().getWidth())
        .named("width")
        .isEqualTo(width);
    return this;
  }

  public ListPopupWindowSubject isModal() {
    assertThat(actual().isModal())
        .named("is modal")
        .isTrue();
    return this;
  }

  public ListPopupWindowSubject isNotModal() {
    assertThat(actual().isModal())
        .named("is modal")
        .isFalse();
    return this;
  }

  public ListPopupWindowSubject isShowing() {
    assertThat(actual().isShowing())
        .named("is showing")
        .isTrue();
    return this;
  }

  public ListPopupWindowSubject isNotShowing() {
    assertThat(actual().isShowing())
        .named("is showing")
        .isFalse();
    return this;
  }
}
