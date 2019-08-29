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
package com.pkware.truth.android.app;

import android.app.ProgressDialog;

import com.google.common.truth.FailureMetadata;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link ProgressDialog} subjects.
 */
public class ProgressDialogSubject extends AbstractDialogSubject<ProgressDialog> {

  @Nullable
  private ProgressDialog actual;

  public ProgressDialogSubject(@Nonnull FailureMetadata failureMetadata, @Nullable ProgressDialog actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasMax(int max) {
    check("getMax()").that(actual.getMax()).isEqualTo(max);
  }

  public void hasProgress(int progress) {
    check("getProgress()").that(actual.getProgress()).isEqualTo(progress);
  }

  public void hasSecondaryProgress(int progress) {
    check("getSecondaryProgress()").that(actual.getSecondaryProgress()).isEqualTo(progress);
  }

  public void isIndeterminate() {
    check("isIndeterminate()").that(actual.isIndeterminate()).isTrue();
  }

  public void isDeterminate() {
    check("isIndeterminate()").that(actual.isIndeterminate()).isFalse();
  }
}
