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

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link OrientedBoundingBox} subjects.
 */
public class OrientedBoundingBoxSubject extends Subject<OrientedBoundingBoxSubject, OrientedBoundingBox> {
  protected OrientedBoundingBoxSubject(FailureStrategy failureStrategy, OrientedBoundingBox subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<OrientedBoundingBoxSubject, OrientedBoundingBox> type() {
    return new SubjectFactory<OrientedBoundingBoxSubject, OrientedBoundingBox>() {
      @Override
      public OrientedBoundingBoxSubject getSubject(FailureStrategy fs, OrientedBoundingBox that) {
        return new OrientedBoundingBoxSubject(fs, that);
      }
    };
  }

  public OrientedBoundingBoxSubject hasCenterX(float centerX, float tolerance) {
    assertThat(actual().centerX)
        .named("X center")
        .isWithin(tolerance)
        .of(centerX);
    return this;
  }

  public OrientedBoundingBoxSubject hasCenterY(float centerY, float tolerance) {
    assertThat(actual().centerY)
        .named("Y center")
        .isWithin(tolerance)
        .of(centerY);
    return this;
  }

  public OrientedBoundingBoxSubject hasHeight(float height, float tolerance) {
    assertThat(actual().height)
        .named("height")
        .isWithin(tolerance)
        .of(height);
    return this;
  }

  public OrientedBoundingBoxSubject hasOrientation(float orientation, float tolerance) {
    assertThat(actual().orientation)
        .named("orientation")
        .isWithin(tolerance)
        .of(orientation);
    return this;
  }

  public OrientedBoundingBoxSubject hasSquareness(float squareness, float tolerance) {
    assertThat(actual().squareness)
        .named("squareness")
        .isWithin(tolerance)
        .of(squareness);
    return this;
  }

  public OrientedBoundingBoxSubject hasWidth(float width, float tolerance) {
    assertThat(actual().width)
        .named("width")
        .isWithin(tolerance)
        .of(width);
    return this;
  }
}
