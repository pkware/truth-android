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
import com.google.common.truth.Subject;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link ProgressDialog} subjects.
 */
public class ProgressDialogSubject extends AbstractDialogSubject<ProgressDialogSubject, ProgressDialog> {
  protected ProgressDialogSubject(FailureMetadata failureMetadata, ProgressDialog subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<ProgressDialogSubject, ProgressDialog> type() {
    return new Subject.Factory<ProgressDialogSubject, ProgressDialog>() {
      @Override
      public ProgressDialogSubject createSubject(FailureMetadata fm, ProgressDialog that) {
        return new ProgressDialogSubject(fm, that);
      }
    };
  }

  public ProgressDialogSubject hasMax(int max) {
    assertThat(actual().getMax())
        .named("max")
        .isEqualTo(max);
    return this;
  }

  public ProgressDialogSubject hasProgress(int progress) {
    assertThat(actual().getProgress())
        .named("progress")
        .isEqualTo(progress);
    return this;
  }

  public ProgressDialogSubject hasSecondaryProgress(int progress) {
    assertThat(actual().getSecondaryProgress())
        .named("secondary progress")
        .isEqualTo(progress);
    return this;
  }

  public ProgressDialogSubject isIndeterminate() {
    assertThat(actual().isIndeterminate())
        .named("is indeterminate")
        .isTrue();
    return this;
  }

  public ProgressDialogSubject isDeterminate() {
    assertThat(actual().isIndeterminate())
        .named("is indeterminate")
        .isFalse();
    return this;
  }
}
