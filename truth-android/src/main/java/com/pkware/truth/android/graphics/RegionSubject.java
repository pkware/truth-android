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
import android.graphics.Rect;
import android.graphics.Region;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link Region} subjects.
 */
public class RegionSubject extends Subject {

  @Nullable
  private final Region actual;

  public RegionSubject(@Nonnull FailureMetadata failureMetadata, @Nullable Region actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasBoundaryPath(@Nullable Path path) {
    check("getBoundaryPath()").that(actual.getBoundaryPath()).isEqualTo(path);
  }

  public void hasBounds(@Nullable Rect bounds) {
    check("getBounds()").that(actual.getBounds()).isEqualTo(bounds);
  }

  public void isComplex() {
    check("isComplex()").that(actual.isComplex()).isTrue();
  }

  public void isNotComplex() {
    check("isComplex()").that(actual.isComplex()).isFalse();
  }

  public void isEmpty() {
    check("isEmpty()").that(actual.isEmpty()).isTrue();
  }

  public void isNotEmpty() {
    check("isEmpty()").that(actual.isEmpty()).isFalse();
  }

  public void isRect() {
    check("isRect()").that(actual.isRect()).isTrue();
  }

  public void isNotRect() {
    check("isRect()").that(actual.isRect()).isFalse();
  }
}
