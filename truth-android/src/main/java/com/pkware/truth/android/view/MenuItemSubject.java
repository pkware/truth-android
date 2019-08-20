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

  public MenuItemSubject hasActionView(@Nullable View view) {
    check("getActionView()").that(actual.getActionView()).isSameInstanceAs(view);
    return this;
  }

  public MenuItemSubject hasAlphabeticShortcut(char shortcut) {
    check("getAlphabeticShortcut()").that(actual.getAlphabeticShortcut()).isEqualTo(shortcut);
    return this;
  }

  public MenuItemSubject hasGroupId(int id) {
    check("getGroupId()").that(actual.getGroupId()).isEqualTo(id);
    return this;
  }

  public MenuItemSubject hasIcon(@Nullable Drawable icon) {
    check("getIcon()").that(actual.getIcon()).isSameInstanceAs(icon);
    return this;
  }

  public MenuItemSubject hasIntent(@Nullable Intent intent) {
    check("getIntent()").that(actual.getIntent()).isEqualTo(intent);
    return this;
  }

  public MenuItemSubject hasItemId(@IdRes int id) {
    check("getItemId()").that(actual.getItemId()).isEqualTo(id);
    return this;
  }

  public MenuItemSubject hasNumericShortcut(char shortcut) {
    check("getNumericShortcut()").that(actual.getNumericShortcut()).isEqualTo(shortcut);
    return this;
  }

  public MenuItemSubject hasOrder(int order) {
    check("getOrder()").that(actual.getOrder()).isEqualTo(order);
    return this;
  }

  public MenuItemSubject hasTitle(@Nullable String title) {
    check("getTitle()").that(actual.getTitle().toString()).isEqualTo(title);
    return this;
  }

  public MenuItemSubject hasCondensedTitle(@Nullable String title) {
    check("getTitleCondensed()").that(actual.getTitleCondensed().toString()).isEqualTo(title);
    return this;
  }

  public MenuItemSubject hasSubMenu() {
    check("hasSubMenu()").that(actual.hasSubMenu()).isTrue();
    return this;
  }

  public MenuItemSubject hasNoSubMenu() {
    check("hasSubMenu()").that(actual.hasSubMenu()).isFalse();
    return this;
  }

  public MenuItemSubject isActionViewExpanded() {
    check("isActionViewExpanded()").that(actual.isActionViewExpanded()).isTrue();
    return this;
  }

  public MenuItemSubject isActionViewCollapsed() {
    check("isActionViewExpanded()").that(actual.isActionViewExpanded()).isFalse();
    return this;
  }

  public MenuItemSubject isCheckable() {
    check("isCheckable()").that(actual.isCheckable()).isTrue();
    return this;
  }

  public MenuItemSubject isNotCheckable() {
    check("isCheckable()").that(actual.isCheckable()).isFalse();
    return this;
  }

  public MenuItemSubject isChecked() {
    check("isChecked()").that(actual.isChecked()).isTrue();
    return this;
  }

  public MenuItemSubject isNotChecked() {
    check("isChecked()").that(actual.isChecked()).isFalse();
    return this;
  }

  public MenuItemSubject isEnabled() {
    check("isEnabled()").that(actual.isEnabled()).isTrue();
    return this;
  }

  public MenuItemSubject isDisabled() {
    check("isEnabled()").that(actual.isEnabled()).isFalse();
    return this;
  }

  public MenuItemSubject isVisible() {
    check("isVisible()").that(actual.isVisible()).isTrue();
    return this;
  }

  public MenuItemSubject isNotVisible() {
    check("isVisible()").that(actual.isVisible()).isFalse();
    return this;
  }
}
