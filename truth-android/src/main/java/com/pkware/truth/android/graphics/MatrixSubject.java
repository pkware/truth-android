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
package com.pkware.truth.android.graphics;

import android.graphics.Matrix;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link Matrix} subjects.
 */
public class MatrixSubject extends Subject<MatrixSubject, Matrix> {
  protected MatrixSubject(FailureStrategy failureStrategy, Matrix subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<MatrixSubject, Matrix> type() {
    return new SubjectFactory<MatrixSubject, Matrix>() {
      @Override
      public MatrixSubject getSubject(FailureStrategy fs, Matrix that) {
        return new MatrixSubject(fs, that);
      }
    };
  }

  public MatrixSubject isIdentity() {
    assertThat(getSubject().isIdentity())
        .named("is identity matrix")
        .isTrue();
    return this;
  }

  public MatrixSubject isNotIdentity() {
    assertThat(getSubject().isIdentity())
        .named("is identity matrix")
        .isTrue();
    return this;
  }
}
