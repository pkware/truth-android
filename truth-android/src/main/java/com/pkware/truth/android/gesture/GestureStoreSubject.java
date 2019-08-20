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

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link GestureStore} subjects.
 */
public class GestureStoreSubject extends Subject<GestureStoreSubject, GestureStore> {
  public GestureStoreSubject(FailureMetadata failureMetadata, GestureStore subject) {
    super(failureMetadata, subject);
  }

  public GestureStoreSubject hasOrientationStyle(int style) {
    assertThat(actual().getOrientationStyle())
        .named("orientation style")
        .isEqualTo(style);
    return this;
  }

  public GestureStoreSubject hasSequenceType(int type) {
    assertThat(actual().getSequenceType())
        .named("sequence type")
        .isEqualTo(type);
    return this;
  }

  public GestureStoreSubject hasChanged() {
    assertThat(actual().hasChanged())
        .named("has changed")
        .isTrue();
    return this;
  }

  public GestureStoreSubject hasNotChanged() {
    assertThat(actual().hasChanged())
        .named("has changed")
        .isFalse();
    return this;
  }
}
