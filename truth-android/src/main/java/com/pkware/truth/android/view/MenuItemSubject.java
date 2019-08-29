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
package com.pkware.truth.android.view;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.IdRes;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link MenuItem} subjects.
 */
public class MenuItemSubject extends Subject {

  @Nullable
  private final MenuItem actual;

  public MenuItemSubject(@Nonnull FailureMetadata failureMetadata, @Nullable MenuItem actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasActionView(@Nullable View view) {
    check("getActionView()").that(actual.getActionView()).isSameInstanceAs(view);
  }

  public void hasAlphabeticShortcut(char shortcut) {
    check("getAlphabeticShortcut()").that(actual.getAlphabeticShortcut()).isEqualTo(shortcut);
  }

  public void hasGroupId(int id) {
    check("getGroupId()").that(actual.getGroupId()).isEqualTo(id);
  }

  public void hasIcon(@Nullable Drawable icon) {
    check("getIcon()").that(actual.getIcon()).isSameInstanceAs(icon);
  }

  public void hasIntent(@Nullable Intent intent) {
    check("getIntent()").that(actual.getIntent()).isEqualTo(intent);
  }

  public void hasItemId(@IdRes int id) {
    check("getItemId()").that(actual.getItemId()).isEqualTo(id);
  }

  public void hasNumericShortcut(char shortcut) {
    check("getNumericShortcut()").that(actual.getNumericShortcut()).isEqualTo(shortcut);
  }

  public void hasOrder(int order) {
    check("getOrder()").that(actual.getOrder()).isEqualTo(order);
  }

  public void hasTitle(@Nullable String title) {
    check("getTitle()").that(actual.getTitle().toString()).isEqualTo(title);
  }

  public void hasCondensedTitle(@Nullable String title) {
    check("getTitleCondensed()").that(actual.getTitleCondensed().toString()).isEqualTo(title);
  }

  public void hasSubMenu() {
    check("hasSubMenu()").that(actual.hasSubMenu()).isTrue();
  }

  public void hasNoSubMenu() {
    check("hasSubMenu()").that(actual.hasSubMenu()).isFalse();
  }

  public void isActionViewExpanded() {
    check("isActionViewExpanded()").that(actual.isActionViewExpanded()).isTrue();
  }

  public void isActionViewCollapsed() {
    check("isActionViewExpanded()").that(actual.isActionViewExpanded()).isFalse();
  }

  public void isCheckable() {
    check("isCheckable()").that(actual.isCheckable()).isTrue();
  }

  public void isNotCheckable() {
    check("isCheckable()").that(actual.isCheckable()).isFalse();
  }

  public void isChecked() {
    check("isChecked()").that(actual.isChecked()).isTrue();
  }

  public void isNotChecked() {
    check("isChecked()").that(actual.isChecked()).isFalse();
  }

  public void isEnabled() {
    check("isEnabled()").that(actual.isEnabled()).isTrue();
  }

  public void isDisabled() {
    check("isEnabled()").that(actual.isEnabled()).isFalse();
  }

  public void isVisible() {
    check("isVisible()").that(actual.isVisible()).isTrue();
  }

  public void isNotVisible() {
    check("isVisible()").that(actual.isVisible()).isFalse();
  }
}
