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
package com.pkware.truth.android.preferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;

import static com.google.common.truth.Truth.assertThat;

public abstract class AbstractPreferenceSubject<S extends AbstractPreferenceSubject<S, T>, T extends Preference>
    extends Subject<S, T> {
  protected AbstractPreferenceSubject(FailureStrategy failureStrategy, T subject) {
    super(failureStrategy, subject);
  }

  public S hasContext(Context context) {
    assertThat(actual().getContext())
        .named("context")
        .isSameAs(context);
    //noinspection unchecked
    return (S) this;
  }

  public S hasDependency(String dependency) {
    assertThat(actual().getDependency())
        .named("dependency")
        .isEqualTo(dependency);
    //noinspection unchecked
    return (S) this;
  }

  public S hasFragment(String fragment) {
    assertThat(actual().getFragment())
        .named("fragment")
        .isEqualTo(fragment);
    //noinspection unchecked
    return (S) this;
  }

  public S hasIcon(Drawable icon) {
    assertThat(actual().getIcon())
        .named("icon")
        .isSameAs(icon);
    //noinspection unchecked
    return (S) this;
  }

  public S hasIntent(Intent intent) {
    assertThat(actual().getIntent())
        .named("intent")
        .isEqualTo(intent);
    //noinspection unchecked
    return (S) this;
  }

  public S hasKey(String key) {
    assertThat(actual().getKey())
        .named("key")
        .isEqualTo(key);
    //noinspection unchecked
    return (S) this;
  }

  public S hasLayoutResource(@LayoutRes int resource) {
    assertThat(actual().getLayoutResource())
        .named("layout resource id")
        .isEqualTo(resource);
    //noinspection unchecked
    return (S) this;
  }

  public S hasPreferenceChangeListener(Preference.OnPreferenceChangeListener listener) {
    assertThat(actual().getOnPreferenceChangeListener())
        .named("preference change listener")
        .isSameAs(listener);
    //noinspection unchecked
    return (S) this;
  }

  public S hasPreferenceClickListener(Preference.OnPreferenceClickListener listener) {
    assertThat(actual().getOnPreferenceClickListener())
        .named("preference click listener")
        .isSameAs(listener);
    //noinspection unchecked
    return (S) this;
  }

  public S hasOrder(int order) {
    assertThat(actual().getOrder())
        .named("order")
        .isEqualTo(order);
    //noinspection unchecked
    return (S) this;
  }

  public S hasPreferenceManager(PreferenceManager manager) {
    assertThat(actual().getPreferenceManager())
        .named("preference manager")
        .isSameAs(manager);
    //noinspection unchecked
    return (S) this;
  }

  public S hasSharedPreferences(SharedPreferences preferences) {
    assertThat(actual().getSharedPreferences())
        .named("shared preferences")
        .isSameAs(preferences);
    //noinspection unchecked
    return (S) this;
  }

  public S hasSummary(CharSequence summary) {
    assertThat(actual().getSummary())
        .named("summary")
        .isEqualTo(summary);
    //noinspection unchecked
    return (S) this;
  }

  public S hasSummary(@StringRes int resId) {
    return hasSummary(actual().getContext().getString(resId));
  }

  public S hasTitle(CharSequence title) {
    assertThat(actual().getTitle())
        .named("title")
        .isEqualTo(title);
    //noinspection unchecked
    return (S) this;
  }

  public S hasTitle(@StringRes int resId) {
    return hasTitle(actual().getContext().getString(resId));
  }

  public S hasTitleResource(@StringRes int resource) {
    assertThat(actual().getTitleRes())
        .named("title resource")
        .isEqualTo(resource);
    //noinspection unchecked
    return (S) this;
  }

  public S hasWidgetLayoutResource(@LayoutRes int resource) {
    assertThat(actual().getWidgetLayoutResource())
        .named("widget layout resource")
        .isEqualTo(resource);
    //noinspection unchecked
    return (S) this;
  }

  public S hasKey() {
    assertThat(actual().hasKey())
        .named("has key")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isEnabled() {
    assertThat(actual().isEnabled())
        .named("is enabled")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isDisabled() {
    assertThat(!actual().isEnabled())
        .named("is disabled")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isPersistent() {
    assertThat(actual().isPersistent())
        .named("is persistent")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotPersistent() {
    assertThat(actual().isPersistent())
        .named("is persistent")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S isSelectable() {
    assertThat(actual().isSelectable())
        .named("is selectable")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotSelectable() {
    assertThat(actual().isSelectable())
        .named("is selectable")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }
}
