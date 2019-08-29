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

import android.gesture.OrientedBoundingBox;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link OrientedBoundingBox} subjects.
 */
public class OrientedBoundingBoxSubject extends Subject {

  @Nullable
  private final OrientedBoundingBox actual;

  public OrientedBoundingBoxSubject(@Nonnull FailureMetadata failureMetadata, @Nullable OrientedBoundingBox actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasCenterX(float centerX, float tolerance) {
    check("centerX").that(actual.centerX).isWithin(tolerance).of(centerX);
  }

  public void hasCenterY(float centerY, float tolerance) {
    check("centerY").that(actual.centerY).isWithin(tolerance).of(centerY);
  }

  public void hasHeight(float height, float tolerance) {
    check("height").that(actual.height).isWithin(tolerance).of(height);
  }

  public void hasOrientation(float orientation, float tolerance) {
    check("orientation").that(actual.orientation).isWithin(tolerance).of(orientation);
  }

  public void hasSquareness(float squareness, float tolerance) {
    check("squareness").that(actual.squareness).isWithin(tolerance).of(squareness);
  }

  public void hasWidth(float width, float tolerance) {
    check("width").that(actual.width).isWithin(tolerance).of(width);
  }
}
