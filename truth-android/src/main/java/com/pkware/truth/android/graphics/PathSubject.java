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
package com.pkware.truth.android.graphics;

import android.graphics.Path;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link Path} subjects.
 */
public class PathSubject extends Subject<PathSubject, Path> {
  protected PathSubject(FailureStrategy failureStrategy, Path subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<PathSubject, Path> type() {
    return new SubjectFactory<PathSubject, Path>() {
      @Override
      public PathSubject getSubject(FailureStrategy fs, Path that) {
        return new PathSubject(fs, that);
      }
    };
  }

  public PathSubject hasFillType(Path.FillType type) {
    assertThat(actual().getFillType())
        .named("fill type")
        .isEqualTo(type);
    return this;
  }

  public PathSubject isEmpty() {
    assertThat(actual().isEmpty())
        .named("is empty")
        .isTrue();
    return this;
  }

  public PathSubject isNotEmpty() {
    assertThat(actual().isEmpty())
        .named("is empty")
        .isFalse();
    return this;
  }
}
