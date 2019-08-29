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

import com.google.android.gms.maps.GoogleMap;
import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link GoogleMap} subjects.
 */
public class GoogleMapSubject extends Subject {

  @Nullable
  private final GoogleMap actual;

  public GoogleMapSubject(@Nonnull FailureMetadata failureMetadata, @Nullable GoogleMap actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasMapType(int mapType) {
    check("getMapType()").that(actual.getMapType()).isEqualTo(mapType);
  }

  public void hasMaxZoomLevel(float zoomLevel, float tolerance) {
    check("getMaxZoomLevel()").that(actual.getMaxZoomLevel()).isWithin(tolerance).of(zoomLevel);
  }

  public void hasMinZoomLevel(float zoomLevel, float tolerance) {
    check("getMinZoomLevel()").that(actual.getMinZoomLevel()).isWithin(tolerance).of(zoomLevel);
  }

  public void hasBuildingsEnabled() {
    check("isBuildingsEnabled()").that(actual.isBuildingsEnabled()).isTrue();
  }

  public void hasBuildingsDisabled() {
    check("isBuildingsEnabled()").that(actual.isBuildingsEnabled()).isFalse();
  }

  public void hasIndoorEnabled() {
    check("isIndoorEnabled()").that(actual.isIndoorEnabled()).isTrue();
  }

  public void hasIndoorDisabled() {
    check("isIndoorEnabled()").that(actual.isIndoorEnabled()).isFalse();
  }

  public void hasMyLocationEnabled() {
    check("isMyLocationEnabled()").that(actual.isMyLocationEnabled()).isTrue();
  }

  public void hasMyLocationDisabled() {
    check("isMyLocationEnabled()")
        .withMessage("has 'my location' disabled")
        .that(actual.isMyLocationEnabled()).isFalse();
  }

  public void hasTrafficEnabled() {
    check("isTrafficEnabled()").that(actual.isTrafficEnabled()).isTrue();
  }

  public void hasTrafficDisabled() {
    check("isTrafficEnabled()").that(actual.isTrafficEnabled()).isFalse();
  }
}
