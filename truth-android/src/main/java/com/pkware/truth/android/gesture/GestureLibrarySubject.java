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
package com.pkware.truth.android.gesture;

import android.gesture.GestureLibrary;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link GestureLibrary} subjects.
 */
public class GestureLibrarySubject extends Subject<GestureLibrarySubject, GestureLibrary> {
  protected GestureLibrarySubject(FailureStrategy failureStrategy, GestureLibrary subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<GestureLibrarySubject, GestureLibrary> type() {
    return new SubjectFactory<GestureLibrarySubject, GestureLibrary>() {
      @Override
      public GestureLibrarySubject getSubject(FailureStrategy fs, GestureLibrary that) {
        return new GestureLibrarySubject(fs, that);
      }
    };
  }

  public GestureLibrarySubject hasOrientationStyle(int style) {
    assertThat(getSubject().getOrientationStyle())
        .named("orientation style")
        .isEqualTo(style);
    return this;
  }

  public GestureLibrarySubject hasSequenceType(int type) {
    assertThat(getSubject().getSequenceType())
        .named("sequence type")
        .isEqualTo(type);
    return this;
  }

  public GestureLibrarySubject isReadOnly() {
    assertThat(getSubject().isReadOnly())
        .named("is read only")
        .isTrue();
    return this;
  }

  public GestureLibrarySubject isNotReadOnly() {
    assertThat(getSubject().isReadOnly())
        .named("is read only")
        .isFalse();
    return this;
  }
}
