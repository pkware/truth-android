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
package com.pkware.truth.android.gesture;

import android.gesture.GestureLibrary;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link GestureLibrary} subjects.
 */
public class GestureLibrarySubject extends Subject {

  @Nullable
  private final GestureLibrary actual;

  public GestureLibrarySubject(@Nonnull FailureMetadata failureMetadata, @Nullable GestureLibrary actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasOrientationStyle(int style) {
    check("getOrientationStyle()").that(actual.getOrientationStyle()).isEqualTo(style);
  }

  public void hasSequenceType(int type) {
    check("getSequenceType()").that(actual.getSequenceType()).isEqualTo(type);
  }

  public void isReadOnly() {
    check("isReadOnly()").that(actual.isReadOnly()).isTrue();
  }

  public void isNotReadOnly() {
    check("isReadOnly()").that(actual.isReadOnly()).isFalse();
  }
}
