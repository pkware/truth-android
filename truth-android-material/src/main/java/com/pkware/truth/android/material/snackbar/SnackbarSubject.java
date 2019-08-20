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
package com.pkware.truth.android.material.snackbar;

import android.view.View;

import com.google.android.material.snackbar.Snackbar;
import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link Snackbar} subjects.
 */
public class SnackbarSubject extends Subject {

  @Nullable
  private final Snackbar actual;

  public SnackbarSubject(@Nonnull FailureMetadata failureMetadata, @Nullable Snackbar actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public SnackbarSubject hasDuration(int duration) {
    check("getDuration()").that(actual.getDuration()).isEqualTo(duration);
    return this;
  }

  public SnackbarSubject hasView(@Nullable View view) {
    check("getView()").that(actual.getView()).isSameInstanceAs(view);
    return this;
  }
}
