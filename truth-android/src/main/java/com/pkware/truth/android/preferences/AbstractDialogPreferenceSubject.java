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

import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.preference.DialogPreference;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;

import com.google.common.truth.FailureMetadata;

import static com.google.common.truth.Truth.assertThat;

public abstract class AbstractDialogPreferenceSubject<S extends AbstractDialogPreferenceSubject<S, T>, T extends DialogPreference>
    extends AbstractPreferenceSubject<S, T> {
  protected AbstractDialogPreferenceSubject(FailureMetadata failureMetadata, T subject) {
    super(failureMetadata, subject);
  }

  public S hasDialog(Dialog dialog) {
    assertThat(actual().getDialog())
        .named("dialog")
        .isSameAs(dialog);
    //noinspection unchecked
    return (S) this;
  }

  public S hasDialogIcon(Drawable icon) {
    assertThat(actual().getIcon())
        .named("dialog icon")
        .isSameAs(icon);
    //noinspection unchecked
    return (S) this;
  }

  public S hasDialogLayoutResource(@LayoutRes int resource) {
    assertThat(actual().getDialogLayoutResource())
        .named("dialog layout resource")
        .isEqualTo(resource);
    //noinspection unchecked
    return (S) this;
  }

  public S hasDialogMessage(CharSequence message) {
    assertThat(actual().getDialogMessage())
        .named("dialog message")
        .isEqualTo(message);
    //noinspection unchecked
    return (S) this;
  }

  public S hasDialogMessage(@StringRes int resId) {
    return hasDialogMessage(actual().getContext().getString(resId));
  }

  public S hasDialogTitle(CharSequence title) {
    assertThat(actual().getDialogTitle())
        .named("dialog title")
        .isEqualTo(title);
    //noinspection unchecked
    return (S) this;
  }

  public S hasDialogTitle(@StringRes int resId) {
    return hasDialogTitle(actual().getContext().getString(resId));
  }

  public S hasNegativeButtonText(CharSequence text) {
    assertThat(actual().getNegativeButtonText())
        .named("negative button text")
        .isEqualTo(text);
    //noinspection unchecked
    return (S) this;
  }

  public S hasNegativeButtonText(@StringRes int resId) {
    return hasNegativeButtonText(actual().getContext().getString(resId));
  }

  public S hasPositiveButtonText(CharSequence text) {
    assertThat(actual().getPositiveButtonText())
        .named("positive button text")
        .isEqualTo(text);
    //noinspection unchecked
    return (S) this;
  }

  public S hasPositiveButtonText(@StringRes int resId) {
    return hasPositiveButtonText(actual().getContext().getString(resId));
  }
}
