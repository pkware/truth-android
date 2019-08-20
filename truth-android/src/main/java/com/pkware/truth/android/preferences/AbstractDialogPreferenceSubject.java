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

import androidx.annotation.LayoutRes;
import androidx.annotation.StringRes;

import com.google.common.truth.FailureMetadata;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class AbstractDialogPreferenceSubject<T extends DialogPreference>
    extends AbstractPreferenceSubject<T> {

  @Nullable
  private final T actual;

  protected AbstractDialogPreferenceSubject(@Nonnull FailureMetadata failureMetadata, @Nullable T actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasDialog(@Nullable Dialog dialog) {
    check("getDialog()").that(actual.getDialog()).isSameInstanceAs(dialog);
  }

  public void hasDialogIcon(@Nullable Drawable icon) {
    check("getIcon()").that(actual.getIcon()).isSameInstanceAs(icon);
  }

  public void hasDialogLayoutResource(@LayoutRes int resource) {
    check("getDialogLayoutResource()").that(actual.getDialogLayoutResource()).isEqualTo(resource);
  }

  public void hasDialogMessage(@Nullable CharSequence message) {
    check("getDialogMessage()").that(actual.getDialogMessage()).isEqualTo(message);
  }

  public void hasDialogMessage(@StringRes int resId) {
    hasDialogMessage(actual.getContext().getString(resId));
  }

  public void hasDialogTitle(@Nullable CharSequence title) {
    check("getDialogTitle()").that(actual.getDialogTitle()).isEqualTo(title);
  }

  public void hasDialogTitle(@StringRes int resId) {
    hasDialogTitle(actual.getContext().getString(resId));
  }

  public void hasNegativeButtonText(@Nullable CharSequence text) {
    check("getNegativeButtonText()").that(actual.getNegativeButtonText()).isEqualTo(text);
  }

  public void hasNegativeButtonText(@StringRes int resId) {
    hasNegativeButtonText(actual.getContext().getString(resId));
  }

  public void hasPositiveButtonText(@Nullable CharSequence text) {
    check("getPositiveButtonText()").that(actual.getPositiveButtonText()).isEqualTo(text);
  }

  public void hasPositiveButtonText(@StringRes int resId) {
    hasPositiveButtonText(actual.getContext().getString(resId));
  }
}
