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
package com.pkware.truth.android.view;

import android.view.Surface;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link Surface} subjects.
 */
public class SurfaceSubject extends Subject {

  @Nullable
  private final Surface actual;

  public SurfaceSubject(@Nonnull FailureMetadata failureMetadata, @Nullable Surface actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void isValid() {
    check("isValid()").that(actual.isValid()).isTrue();
  }

  public void isNotValid() {
    check("isValid()").that(actual.isValid()).isFalse();
  }
}
