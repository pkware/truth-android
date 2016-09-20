/*
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
package com.pkware.truth.android.playservices.maps;

import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link CameraPosition} subjects.
 */
public class CameraPositionSubject extends Subject<CameraPositionSubject, CameraPosition> {
  protected CameraPositionSubject(FailureStrategy failureStrategy, CameraPosition subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<CameraPositionSubject, CameraPosition> type() {
    return new SubjectFactory<CameraPositionSubject, CameraPosition>() {
      @Override
      public CameraPositionSubject getSubject(FailureStrategy fs, CameraPosition that) {
        return new CameraPositionSubject(fs, that);
      }
    };
  }

  public CameraPositionSubject hasBearing(float bearing, float tolerance) {
    assertThat(actual().bearing)
        .named("bearing")
        .isWithin(tolerance)
        .of(bearing);
    return this;
  }

  public CameraPositionSubject hasTarget(LatLng target) {
    LatLng actualTarget = actual().target;
    assertThat(actual().target)
        .named("target")
        .isEqualTo(target);
    return this;
  }

  public CameraPositionSubject hasTilt(float tilt, float tolerance) {
    assertThat(actual().tilt)
        .named("tilt")
        .isWithin(tolerance)
        .of(tilt);
    return this;
  }

  public CameraPositionSubject hasZoom(float zoom, float tolerance) {
    assertThat(actual().zoom)
        .named("zoom")
        .isWithin(tolerance)
        .of(zoom);
    return this;
  }
}
