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
package com.pkware.truth.android.design.widget;

import android.support.design.widget.TextInputLayout;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;
import com.pkware.truth.android.widget.AbstractLinearLayoutSubject;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link TextInputLayout} subjects.
 */
public class TextInputLayoutSubject extends AbstractLinearLayoutSubject<TextInputLayoutSubject, TextInputLayout> {
  protected TextInputLayoutSubject(FailureStrategy failureStrategy, TextInputLayout subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<TextInputLayoutSubject, TextInputLayout> type() {
    return new SubjectFactory<TextInputLayoutSubject, TextInputLayout>() {
      @Override
      public TextInputLayoutSubject getSubject(FailureStrategy fs, TextInputLayout that) {
        return new TextInputLayoutSubject(fs, that);
      }
    };
  }

  public TextInputLayoutSubject hasError(String error) {
    CharSequence actualError = actual().getError();
    String actualErrorString;
    if (actualError == null) {
      actualErrorString = null;
    } else {
      actualErrorString = actualError.toString();
    }
    assertThat(actualErrorString)
        .named("error")
        .isEqualTo(error);
    return this;
  }
}
