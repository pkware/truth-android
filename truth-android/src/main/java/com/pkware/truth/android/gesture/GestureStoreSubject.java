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

import android.gesture.GestureStore;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link GestureStore} subjects.
 */
public class GestureStoreSubject extends Subject {

  @Nullable
  private final GestureStore actual;

  public GestureStoreSubject(@Nonnull FailureMetadata failureMetadata, @Nullable GestureStore actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public GestureStoreSubject hasOrientationStyle(int style) {
    check("getOrientationStyle()").that(actual.getOrientationStyle()).isEqualTo(style);
    return this;
  }

  public GestureStoreSubject hasSequenceType(int type) {
    check("getSequenceType()").that(actual.getSequenceType()).isEqualTo(type);
    return this;
  }

  public GestureStoreSubject hasChanged() {
    check("hasChanged()").that(actual.hasChanged()).isTrue();
    return this;
  }

  public GestureStoreSubject hasNotChanged() {
    check("hasChanged()").that(actual.hasChanged()).isFalse();
    return this;
  }
}
