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

import static android.os.Build.VERSION_CODES.JELLY_BEAN;
import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link Camera} subjects.
 */
public class CameraSubject extends Subject<CameraSubject, Camera> {
  public CameraSubject(FailureMetadata failureMetadata, Camera subject) {
    super(failureMetadata, subject);
  }

  @TargetApi(JELLY_BEAN)
  public CameraSubject hasLocationX(float location, float tolerance) {
    assertThat(actual().getLocationX())
        .named("X location")
        .isWithin(tolerance)
        .of(location);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public CameraSubject hasLocationY(float location, float tolerance) {
    assertThat(actual().getLocationY())
        .named("Y location")
        .isWithin(tolerance)
        .of(location);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public CameraSubject hasLocationZ(float location, float tolerance) {
    assertThat(actual().getLocationZ())
        .named("Z location")
        .isWithin(tolerance)
        .of(location);
    return this;
  }
}
