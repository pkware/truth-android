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
package com.pkware.truth.androidx.appcompat.app;

import androidx.annotation.StringRes;
import androidx.appcompat.app.ActionBar;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static androidx.appcompat.app.ActionBar.DISPLAY_HOME_AS_UP;
import static androidx.appcompat.app.ActionBar.DISPLAY_SHOW_CUSTOM;
import static androidx.appcompat.app.ActionBar.DISPLAY_SHOW_HOME;
import static androidx.appcompat.app.ActionBar.DISPLAY_SHOW_TITLE;
import static androidx.appcompat.app.ActionBar.DISPLAY_USE_LOGO;
import static androidx.appcompat.app.ActionBar.NAVIGATION_MODE_LIST;
import static androidx.appcompat.app.ActionBar.NAVIGATION_MODE_STANDARD;
import static androidx.appcompat.app.ActionBar.NAVIGATION_MODE_TABS;
import static com.pkware.truth.android.internal.IntegerUtils.buildBitMaskString;
import static com.pkware.truth.android.internal.IntegerUtils.buildNamedValueString;

/**
 * Propositions for {@link ActionBar} subjects.
 */
public class ActionBarSubject extends Subject {

  @Nullable
  private final ActionBar actual;

  public ActionBarSubject(@Nonnull FailureMetadata failureMetadata, @Nullable ActionBar actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  @Nonnull
  public static String navigationModeToString(@ActionBarNavigationMode int mode) {
    return buildNamedValueString(mode)
        .value(NAVIGATION_MODE_LIST, "list")
        .value(NAVIGATION_MODE_STANDARD, "standard")
        .value(NAVIGATION_MODE_TABS, "tabs")
        .get();
  }

  @Nonnull
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
    check("getCustomView()").that(actual.getCustomView()).isNotNull();
    return this;
  }

  public ActionBarSubject hasDisplayOptions(@ActionBarDisplayOptions int options) {
    final int actualOptions = actual.getDisplayOptions();
    //noinspection ResourceType
    check("getDisplayOptions()")
        .withMessage("Expected display options <%s> but was <%s>.",
            displayOptionsToString(options), displayOptionsToString(actualOptions))
        .that(actualOptions)
        .isEqualTo(options);
    return this;
  }

  public ActionBarSubject hasHeight(int height) {
    check("getHeight()").that(actual.getHeight()).isEqualTo(height);
    return this;
  }

  public ActionBarSubject hasNavigationItemCount(int count) {
    check("getNavigationItemCount()").that(actual.getNavigationItemCount()).isEqualTo(count);
    return this;
  }

  public ActionBarSubject hasNavigationMode(int mode) {
    int actualMode = actual.getNavigationMode();
    //noinspection ResourceType
    check("getNavigationMode()")
        .withMessage("Expected mode <%s> but was <%s>.", navigationModeToString(mode),
            navigationModeToString(actualMode))
        .that(actualMode)
        .isEqualTo(mode);
    return this;
  }

  public ActionBarSubject hasSelectedNavigationIndex(int index) {
    check("getSelectedNavigationIndex()").that(actual.getSelectedNavigationIndex()).isEqualTo(index);
    return this;
  }

  public ActionBarSubject hasSubtitle(@Nullable String subtitle) {
    check("getSubtitle()").that(actual.getSubtitle().toString()).isEqualTo(subtitle);
    return this;
  }

  public ActionBarSubject hasSubtitle(@StringRes int resId) {
    return hasSubtitle(actual.getThemedContext().getString(resId));
  }

  public ActionBarSubject hasTabCount(int count) {
    check("getTabCount()").that(actual.getTabCount()).isEqualTo(count);
    return this;
  }

  public ActionBarSubject hasTitle(@Nullable String title) {
    check("getTitle()").that(actual.getTitle().toString()).isEqualTo(title);
    return this;
  }

  public ActionBarSubject hasTitle(@StringRes int resId) {
    return hasTitle(actual.getThemedContext().getString(resId));
  }

  public ActionBarSubject isShowing() {
    check("isShowing()").that(actual.isShowing()).isTrue();
    return this;
  }

  public ActionBarSubject isNotShowing() {
    check("isShowing()").that(actual.isShowing()).isFalse();
    return this;
  }
}
