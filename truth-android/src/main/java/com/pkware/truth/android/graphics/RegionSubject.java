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

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link Region} subjects.
 */
public class RegionSubject extends Subject<RegionSubject, Region> {
  public RegionSubject(FailureMetadata failureMetadata, Region subject) {
    super(failureMetadata, subject);
  }

  public RegionSubject hasBoundaryPath(Path path) {
    assertThat(actual().getBoundaryPath())
        .named("boundary path")
        .isEqualTo(path);
    return this;
  }

  public RegionSubject hasBounds(Rect bounds) {
    assertThat(actual().getBounds())
        .named("bounds")
        .isEqualTo(bounds);
    return this;
  }

  public RegionSubject isComplex() {
    assertThat(actual().isComplex())
        .named("is complex")
        .isTrue();
    return this;
  }

  public RegionSubject isNotComplex() {
    assertThat(actual().isComplex())
        .named("is complex")
        .isFalse();
    return this;
  }

  public RegionSubject isEmpty() {
    assertThat(actual().isEmpty())
        .named("is empty")
        .isTrue();
    return this;
  }

  public RegionSubject isNotEmpty() {
    assertThat(actual().isEmpty())
        .named("is empty")
        .isFalse();
    return this;
  }

  public RegionSubject isRect() {
    assertThat(actual().isRect())
        .named("is rectangle")
        .isTrue();
    return this;
  }

  public RegionSubject isNotRect() {
    assertThat(actual().isRect())
        .named("is rectangle")
        .isTrue();
    return this;
  }
}
