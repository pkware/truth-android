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
package com.pkware.truth.android.material.textfield;

import com.google.android.material.textfield.TextInputLayout;
import com.google.common.truth.FailureMetadata;
import com.pkware.truth.android.widget.AbstractLinearLayoutSubject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link TextInputLayout} subjects.
 */
public class TextInputLayoutSubject extends AbstractLinearLayoutSubject<TextInputLayout> {

  @Nullable
  private final TextInputLayout actual;

  public TextInputLayoutSubject(@Nonnull FailureMetadata failureMetadata, @Nullable TextInputLayout actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasError(@Nullable String error) {
    CharSequence actualError = actual.getError();
    String actualErrorString;
    if (actualError == null) {
      actualErrorString = null;
    } else {
      actualErrorString = actualError.toString();
    }
    check("getError()").that(actualErrorString).isEqualTo(error);
  }
}
