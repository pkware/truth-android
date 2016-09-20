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
package com.pkware.truth.android.support.v4.app;

import android.support.v4.app.DialogFragment;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link DialogFragment} subjects.
 */
public class DialogFragmentSubject
    extends AbstractFragmentSubject<DialogFragmentSubject, DialogFragment> {
  protected DialogFragmentSubject(FailureStrategy failureStrategy, DialogFragment subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<DialogFragmentSubject, DialogFragment> type() {
    return new SubjectFactory<DialogFragmentSubject, DialogFragment>() {
      @Override
      public DialogFragmentSubject getSubject(FailureStrategy fs, DialogFragment that) {
        return new DialogFragmentSubject(fs, that);
      }
    };
  }

  public DialogFragmentSubject isCancelable() {
    assertThat(actual().isCancelable())
        .named("is cancelable")
        .isTrue();
    return this;
  }

  public DialogFragmentSubject isNotCancelable() {
    assertThat(actual().isCancelable())
        .isFalse();
    return this;
  }
}
