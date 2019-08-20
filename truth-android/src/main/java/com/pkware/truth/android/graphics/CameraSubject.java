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

import android.annotation.TargetApi;
import android.graphics.Camera;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.os.Build.VERSION_CODES.JELLY_BEAN;

/**
 * Propositions for {@link Camera} subjects.
 */
public class CameraSubject extends Subject {

  @Nullable
  private final Camera actual;

  public CameraSubject(@Nonnull FailureMetadata failureMetadata, @Nullable Camera actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  @TargetApi(JELLY_BEAN)
  public CameraSubject hasLocationX(float location, float tolerance) {
    check("getLocationX()").that(actual.getLocationX()).isWithin(tolerance).of(location);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public CameraSubject hasLocationY(float location, float tolerance) {
    check("getLocationY()").that(actual.getLocationY()).isWithin(tolerance).of(location);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public CameraSubject hasLocationZ(float location, float tolerance) {
    check("getLocationZ()").that(actual.getLocationZ()).isWithin(tolerance).of(location);
    return this;
  }
}
