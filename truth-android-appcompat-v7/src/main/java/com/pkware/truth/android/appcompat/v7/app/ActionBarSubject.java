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
package com.pkware.truth.android.appcompat.v7.app;

import android.support.annotation.StringRes;
import android.support.v7.app.ActionBar;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static android.support.v7.app.ActionBar.DISPLAY_HOME_AS_UP;
import static android.support.v7.app.ActionBar.DISPLAY_SHOW_CUSTOM;
import static android.support.v7.app.ActionBar.DISPLAY_SHOW_HOME;
import static android.support.v7.app.ActionBar.DISPLAY_SHOW_TITLE;
import static android.support.v7.app.ActionBar.DISPLAY_USE_LOGO;
import static android.support.v7.app.ActionBar.NAVIGATION_MODE_LIST;
import static android.support.v7.app.ActionBar.NAVIGATION_MODE_STANDARD;
import static android.support.v7.app.ActionBar.NAVIGATION_MODE_TABS;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assert_;
import static com.pkware.truth.android.internal.IntegerUtils.buildBitMaskString;
import static com.pkware.truth.android.internal.IntegerUtils.buildNamedValueString;

/**
 * Propositions for {@link ActionBar} subjects.
 */
public class ActionBarSubject extends Subject<ActionBarSubject, ActionBar> {
  protected ActionBarSubject(FailureStrategy failureStrategy, ActionBar subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<ActionBarSubject, ActionBar> type() {
    return new SubjectFactory<ActionBarSubject, ActionBar>() {
      @Override
      public ActionBarSubject getSubject(FailureStrategy fs, ActionBar that) {
        return new ActionBarSubject(fs, that);
      }
    };
  }

  public static String navigationModeToString(@ActionBarNavigationMode int mode) {
    return buildNamedValueString(mode)
        .value(NAVIGATION_MODE_LIST, "list")
        .value(NAVIGATION_MODE_STANDARD, "standard")
        .value(NAVIGATION_MODE_TABS, "tabs")
        .get();
  }

  public static String displayOptionsToString(@ActionBarDisplayOptions int options) {
    return buildBitMaskString(options)
        .flag(DISPLAY_HOME_AS_UP, "homeAsUp")
        .flag(DISPLAY_SHOW_CUSTOM, "showCustom")
        .flag(DISPLAY_SHOW_HOME, "showHome")
        .flag(DISPLAY_SHOW_TITLE, "showTitle")
        .flag(DISPLAY_USE_LOGO, "useLogo")
        .get();
  }

  public ActionBarSubject hasCustomView() {
    assertThat(getSubject().getCustomView())
        .named("custom view")
        .isNotNull();
    return this;
  }

  public ActionBarSubject hasDisplayOptions(@ActionBarDisplayOptions int options) {
    final int actualOptions = getSubject().getDisplayOptions();
    //noinspection ResourceType
    assert_()
        .withFailureMessage("Expected display options <%s> but was <%s>.",
            displayOptionsToString(options), displayOptionsToString(actualOptions))
        .that(actualOptions)
        .isEqualTo(options);
    return this;
  }

  public ActionBarSubject hasHeight(int height) {
    assertThat(getSubject().getHeight())
        .named("height")
        .isEqualTo(height);
    return this;
  }

  public ActionBarSubject hasNavigationItemCount(int count) {
    assertThat(getSubject().getNavigationItemCount())
        .named("navigation item count")
        .isEqualTo(count);
    return this;
  }

  public ActionBarSubject hasNavigationMode(int mode) {
    int actualMode = getSubject().getNavigationMode();
    //noinspection ResourceType
    assert_()
        .withFailureMessage("Expected mode <%s> but was <%s>.", navigationModeToString(mode),
            navigationModeToString(actualMode))
        .that(actualMode)
        .isEqualTo(mode);
    return this;
  }

  public ActionBarSubject hasSelectedNavigationIndex(int index) {
    assertThat(getSubject().getSelectedNavigationIndex())
        .named("selected navigation item index")
        .isEqualTo(index);
    return this;
  }

  public ActionBarSubject hasSubtitle(String subtitle) {
    assertThat(getSubject().getSubtitle().toString())
        .named("subtitle")
        .isEqualTo(subtitle);
    return this;
  }

  public ActionBarSubject hasSubtitle(@StringRes int resId) {
    return hasSubtitle(getSubject().getThemedContext().getString(resId));
  }

  public ActionBarSubject hasTabCount(int count) {
    assertThat(getSubject().getTabCount())
        .named("tab count")
        .isEqualTo(count);
    return this;
  }

  public ActionBarSubject hasTitle(String title) {
    assertThat(getSubject().getTitle().toString())
        .named("title")
        .isEqualTo(title);
    return this;
  }

  public ActionBarSubject hasTitle(@StringRes int resId) {
    return hasTitle(getSubject().getThemedContext().getString(resId));
  }

  public ActionBarSubject isShowing() {
    assertThat(getSubject().isShowing())
        .named("is showing")
        .isTrue();
    return this;
  }

  public ActionBarSubject isNotShowing() {
    assertThat(getSubject().isShowing())
        .named("is showing")
        .isFalse();
    return this;
  }
}
