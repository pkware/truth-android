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

import android.view.VelocityTracker;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link VelocityTracker} subjects.
 */
public class VelocityTrackerSubject extends Subject {

  @Nullable
  private final VelocityTracker actual;

  public VelocityTrackerSubject(@Nonnull FailureMetadata failureMetadata, @Nullable VelocityTracker actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasXVelocity(float velocity, float tolerance) {
    check("getXVelocity()").that(actual.getXVelocity()).isWithin(tolerance).of(velocity);
  }

  public void hasXVelocity(int id, float velocity, float tolerance) {
    check("getItem(index)")
        .withMessage("X velocity for ID %s", id)
        .that(actual.getXVelocity(id))
        .isWithin(tolerance)
        .of(velocity);
  }

  public void hasYVelocity(float velocity, float tolerance) {
    check("getYVelocity()").that(actual.getYVelocity()).isWithin(tolerance).of(velocity);
  }

  public void hasYVelocity(int id, float velocity, float tolerance) {
    check("getYVelocity(id)")
        .withMessage("Y velocity for ID %s", id)
        .that(actual.getYVelocity(id))
        .isWithin(tolerance)
        .of(velocity);
  }
}
