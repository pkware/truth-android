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
package com.pkware.truth.android.widget;

import android.widget.RadioGroup;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link RadioGroup} subjects.
 */
public class RadioGroupSubject extends AbstractLinearLayoutSubject<RadioGroupSubject, RadioGroup> {
  protected RadioGroupSubject(FailureStrategy failureStrategy, RadioGroup subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<RadioGroupSubject, RadioGroup> type() {
    return new SubjectFactory<RadioGroupSubject, RadioGroup>() {
      @Override
      public RadioGroupSubject getSubject(FailureStrategy fs, RadioGroup that) {
        return new RadioGroupSubject(fs, that);
      }
    };
  }

  public RadioGroupSubject hasCheckedRadioButtonId(int id) {
    assertThat(actual().getCheckedRadioButtonId())
        .named("checked radio button ID")
        .isEqualTo(id);
    return this;
  }
}
