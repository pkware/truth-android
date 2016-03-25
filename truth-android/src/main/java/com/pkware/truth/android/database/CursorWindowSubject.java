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
package com.pkware.truth.android.database;

import android.database.CursorWindow;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link CursorWindow} subjects.
 */
public class CursorWindowSubject extends Subject<CursorWindowSubject, CursorWindow> {
  protected CursorWindowSubject(FailureStrategy failureStrategy, CursorWindow subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<CursorWindowSubject, CursorWindow> type() {
    return new SubjectFactory<CursorWindowSubject, CursorWindow>() {
      @Override
      public CursorWindowSubject getSubject(FailureStrategy fs, CursorWindow that) {
        return new CursorWindowSubject(fs, that);
      }
    };
  }

  public CursorWindowSubject hasRowCount(int count) {
    assertThat(getSubject().getNumRows())
        .named("number of rows")
        .isEqualTo(count);
    return this;
  }

  public CursorWindowSubject hasStartPosition(int position) {
    assertThat(getSubject().getStartPosition())
        .named("start position")
        .isEqualTo(position);
    return this;
  }
}
