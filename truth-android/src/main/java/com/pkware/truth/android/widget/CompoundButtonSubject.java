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
package com.pkware.truth.android.widget;

import android.widget.CompoundButton;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

/**
 * Propositions for {@link CompoundButton} subjects.
 * <p/>
 * This class is final. To extend use {@link AbstractCompoundButtonSubject}.
 */
public final class CompoundButtonSubject extends AbstractCompoundButtonSubject<CompoundButtonSubject, CompoundButton> {
  private CompoundButtonSubject(FailureStrategy failureStrategy, CompoundButton subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<CompoundButtonSubject, CompoundButton> type() {
    return new SubjectFactory<CompoundButtonSubject, CompoundButton>() {
      @Override
      public CompoundButtonSubject getSubject(FailureStrategy fs, CompoundButton that) {
        return new CompoundButtonSubject(fs, that);
      }
    };
  }
}
