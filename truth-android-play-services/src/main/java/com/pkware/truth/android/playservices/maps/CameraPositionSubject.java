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
package com.pkware.truth.android.playservices.maps;

import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link CameraPosition} subjects.
 */
public class CameraPositionSubject extends Subject {

  @Nullable
  private final CameraPosition actual;

  public CameraPositionSubject(@Nonnull FailureMetadata failureMetadata, @Nullable CameraPosition actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public CameraPositionSubject hasBearing(float bearing, float tolerance) {
    check("bearing").that(actual.bearing).isWithin(tolerance).of(bearing);
    return this;
  }

  public CameraPositionSubject hasTarget(LatLng target) {
    check("target").that(actual.target).isEqualTo(target);
    return this;
  }

  public CameraPositionSubject hasTilt(float tilt, float tolerance) {
    check("tilt").that(actual.tilt).isWithin(tolerance).of(tilt);
    return this;
  }

  public CameraPositionSubject hasZoom(float zoom, float tolerance) {
    check("zoom").that(actual.zoom).isWithin(tolerance).of(zoom);
    return this;
  }
}
