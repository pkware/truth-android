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
import android.support.annotation.IdRes;
import android.view.MenuItem;
import android.view.View;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link MenuItem} subjects.
 */
public class MenuItemSubject extends Subject<MenuItemSubject, MenuItem> {
  protected MenuItemSubject(FailureMetadata failureMetadata, MenuItem subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<MenuItemSubject, MenuItem> type() {
    return MenuItemSubject::new;
  }

  public MenuItemSubject hasActionView(View view) {
    assertThat(actual().getActionView())
        .named("action view")
        .isSameAs(view);
    return this;
  }

  public MenuItemSubject hasAlphabeticShortcut(char shortcut) {
    assertThat(actual().getAlphabeticShortcut())
        .named("alphabetic shortcut")
        .isEqualTo(shortcut);
    return this;
  }

  public MenuItemSubject hasGroupId(int id) {
    assertThat(actual().getGroupId())
        .named("group ID")
        .isEqualTo(id);
    return this;
  }

  public MenuItemSubject hasIcon(Drawable icon) {
    assertThat(actual().getIcon())
        .named("icon")
        .isSameAs(icon);
    return this;
  }

  public MenuItemSubject hasIntent(Intent intent) {
    assertThat(actual().getIntent())
        .named("intent")
        .isEqualTo(intent);
    return this;
  }

  public MenuItemSubject hasItemId(@IdRes int id) {
    assertThat(actual().getItemId())
        .named("item ID")
        .isEqualTo(id);
    return this;
  }

  public MenuItemSubject hasNumericShortcut(char shortcut) {
    assertThat(actual().getNumericShortcut())
        .named("numeric shortcut")
        .isEqualTo(shortcut);
    return this;
  }

  public MenuItemSubject hasOrder(int order) {
    assertThat(actual().getOrder())
        .named("order")
        .isEqualTo(order);
    return this;
  }

  public MenuItemSubject hasTitle(String title) {
    assertThat(actual().getTitle().toString())
        .named("title")
        .isEqualTo(title);
    return this;
  }

  public MenuItemSubject hasCondensedTitle(String title) {
    assertThat(actual().getTitleCondensed().toString())
        .named("condensed title")
        .isEqualTo(title);
    return this;
  }

  public MenuItemSubject hasSubMenu() {
    assertThat(actual().hasSubMenu())
        .named("has sub-menu")
        .isTrue();
    return this;
  }

  public MenuItemSubject hasNoSubMenu() {
    assertThat(actual().hasSubMenu())
        .named("has sub-menu")
        .isFalse();
    return this;
  }

  public MenuItemSubject isActionViewExpanded() {
    assertThat(actual().isActionViewExpanded())
        .named("is action view expanded")
        .isTrue();
    return this;
  }

  public MenuItemSubject isActionViewCollapsed() {
    assertThat(actual().isActionViewExpanded())
        .named("is action view expanded")
        .isFalse();
    return this;
  }

  public MenuItemSubject isCheckable() {
    assertThat(actual().isCheckable())
        .named("is checkable")
        .isTrue();
    return this;
  }

  public MenuItemSubject isNotCheckable() {
    assertThat(actual().isCheckable())
        .named("is checkable")
        .isFalse();
    return this;
  }

  public MenuItemSubject isChecked() {
    assertThat(actual().isChecked())
        .named("is checked")
        .isTrue();
    return this;
  }

  public MenuItemSubject isNotChecked() {
    assertThat(actual().isChecked())
        .named("is checked")
        .isFalse();
    return this;
  }

  public MenuItemSubject isEnabled() {
    assertThat(actual().isEnabled())
        .named("is enabled")
        .isTrue();
    return this;
  }

  public MenuItemSubject isDisabled() {
    assertThat(!actual().isEnabled())
        .named("is disabled")
        .isTrue();
    return this;
  }

  public MenuItemSubject isVisible() {
    assertThat(actual().isVisible())
        .named("is visible")
        .isTrue();
    return this;
  }

  public MenuItemSubject isNotVisible() {
    assertThat(actual().isVisible())
        .named("is visible")
        .isFalse();
    return this;
  }
}
