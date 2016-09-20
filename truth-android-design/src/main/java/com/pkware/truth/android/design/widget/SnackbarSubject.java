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
package com.pkware.truth.android.design.widget;

import android.support.design.widget.Snackbar;
import android.view.View;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link Snackbar} subjects.
 */
public class SnackbarSubject extends Subject<SnackbarSubject, Snackbar> {
  protected SnackbarSubject(FailureStrategy failureStrategy, Snackbar subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<SnackbarSubject, Snackbar> type() {
    return new SubjectFactory<SnackbarSubject, Snackbar>() {
      @Override
      public SnackbarSubject getSubject(FailureStrategy fs, Snackbar that) {
        return new SnackbarSubject(fs, that);
      }
    };
  }

  public SnackbarSubject hasDuration(int duration) {
    assertThat(actual().getDuration())
        .named("duration")
        .isEqualTo(duration);
    return this;
  }

  public SnackbarSubject hasView(View view) {
    assertThat(actual().getView())
        .named("view")
        .isSameAs(view);
    return this;
  }
}
