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
package com.pkware.truth.android.preferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.preference.Preference;
import android.preference.PreferenceManager;

import androidx.annotation.LayoutRes;
import androidx.annotation.StringRes;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class AbstractPreferenceSubject<T extends Preference> extends Subject {

  @Nullable
  private final T actual;

  protected AbstractPreferenceSubject(@Nonnull FailureMetadata failureMetadata, @Nullable T actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasContext(@Nullable Context context) {
    check("getContext()").that(actual.getContext()).isSameInstanceAs(context);
  }

  public void hasDependency(@Nullable String dependency) {
    check("getDependency()").that(actual.getDependency()).isEqualTo(dependency);
  }

  public void hasFragment(@Nullable String fragment) {
    check("getFragment()").that(actual.getFragment()).isEqualTo(fragment);
  }

  public void hasIcon(@Nullable Drawable icon) {
    check("getIcon()").that(actual.getIcon()).isSameInstanceAs(icon);
  }

  public void hasIntent(@Nullable Intent intent) {
    check("getIntent()").that(actual.getIntent()).isEqualTo(intent);
  }

  public void hasKey(@Nullable String key) {
    check("getKey()").that(actual.getKey()).isEqualTo(key);
  }

  public void hasLayoutResource(@LayoutRes int resource) {
    check("getLayoutResource()").that(actual.getLayoutResource()).isEqualTo(resource);
  }

  public void hasPreferenceChangeListener(@Nullable Preference.OnPreferenceChangeListener listener) {
    check("getOnPreferenceChangeListener()").that(actual.getOnPreferenceChangeListener()).isSameInstanceAs(listener);
  }

  public void hasPreferenceClickListener(@Nullable Preference.OnPreferenceClickListener listener) {
    check("getOnPreferenceClickListener()").that(actual.getOnPreferenceClickListener()).isSameInstanceAs(listener);
  }

  public void hasOrder(int order) {
    check("getOrder()").that(actual.getOrder()).isEqualTo(order);
  }

  public void hasPreferenceManager(@Nullable PreferenceManager manager) {
    check("getPreferenceManager()").that(actual.getPreferenceManager()).isSameInstanceAs(manager);
  }

  public void hasSharedPreferences(@Nullable SharedPreferences preferences) {
    check("getSharedPreferences()").that(actual.getSharedPreferences()).isSameInstanceAs(preferences);
  }

  public void hasSummary(@Nullable CharSequence summary) {
    check("getSummary()").that(actual.getSummary()).isEqualTo(summary);
  }

  public void hasSummary(@StringRes int resId) {
    hasSummary(actual.getContext().getString(resId));
  }

  public void hasTitle(@Nullable CharSequence title) {
    check("getTitle()").that(actual.getTitle()).isEqualTo(title);
  }

  public void hasTitle(@StringRes int resId) {
    hasTitle(actual.getContext().getString(resId));
  }

  public void hasTitleResource(@StringRes int resource) {
    check("getTitleRes()").that(actual.getTitleRes()).isEqualTo(resource);
  }

  public void hasWidgetLayoutResource(@LayoutRes int resource) {
    check("getWidgetLayoutResource()").that(actual.getWidgetLayoutResource()).isEqualTo(resource);
  }

  public void hasKey() {
    check("hasKey()").that(actual.hasKey()).isTrue();
  }

  public void isEnabled() {
    check("isEnabled()").that(actual.isEnabled()).isTrue();
  }

  public void isDisabled() {
    check("isEnabled()").that(actual.isEnabled()).isFalse();
  }

  public void isPersistent() {
    check("isPersistent()").that(actual.isPersistent()).isTrue();
  }

  public void isNotPersistent() {
    check("isPersistent()").that(actual.isPersistent()).isFalse();
  }

  public void isSelectable() {
    check("isSelectable()").that(actual.isSelectable()).isTrue();
  }

  public void isNotSelectable() {
    check("isSelectable()").that(actual.isSelectable()).isFalse();
  }
}
