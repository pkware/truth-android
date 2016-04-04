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

import com.google.android.gms.maps.GoogleMap;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link GoogleMap} subjects.
 */
public class GoogleMapSubject extends Subject<GoogleMapSubject, GoogleMap> {
  protected GoogleMapSubject(FailureStrategy failureStrategy, GoogleMap subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<GoogleMapSubject, GoogleMap> type() {
    return new SubjectFactory<GoogleMapSubject, GoogleMap>() {
      @Override
      public GoogleMapSubject getSubject(FailureStrategy fs, GoogleMap that) {
        return new GoogleMapSubject(fs, that);
      }
    };
  }

  public GoogleMapSubject hasMapType(int mapType) {
    assertThat(getSubject().getMapType())
        .named("map type")
        .isEqualTo(mapType);
    return this;
  }

  public GoogleMapSubject hasMaxZoomLevel(float zoomLevel, float tolerance) {
    assertThat(getSubject().getMaxZoomLevel())
        .named("maximum zoom level")
        .isWithin(tolerance)
        .of(zoomLevel);
    return this;
  }

  public GoogleMapSubject hasMinZoomLevel(float zoomLevel, float tolerance) {
    assertThat(getSubject().getMinZoomLevel())
        .named("minimum zoom level")
        .isWithin(tolerance)
        .of(zoomLevel);
    return this;
  }

  public GoogleMapSubject hasBuildingsEnabled() {
    assertThat(getSubject().isBuildingsEnabled())
        .named("has buildings enabled")
        .isTrue();
    return this;
  }

  public GoogleMapSubject hasBuildingsDisabled() {
    assertThat(!getSubject().isBuildingsEnabled())
        .named("has buildings disabled")
        .isTrue();
    return this;
  }

  public GoogleMapSubject hasIndoorEnabled() {
    assertThat(getSubject().isIndoorEnabled())
        .named("has indoor enabled")
        .isTrue();
    return this;
  }

  public GoogleMapSubject hasIndoorDisabled() {
    assertThat(!getSubject().isIndoorEnabled())
        .named("has indoor disabled")
        .isTrue();
    return this;
  }

  public GoogleMapSubject hasMyLocationEnabled() {
    assertThat(getSubject().isMyLocationEnabled())
        .named("has 'my location' enabled")
        .isTrue();
    return this;
  }

  public GoogleMapSubject hasMyLocationDisabled() {
    assertThat(!getSubject().isMyLocationEnabled())
        .named("has 'my location' disabled")
        .isTrue();
    return this;
  }

  public GoogleMapSubject hasTrafficEnabled() {
    assertThat(getSubject().isTrafficEnabled())
        .named("has traffic enabled")
        .isTrue();
    return this;
  }

  public GoogleMapSubject hasTrafficDisabled() {
    assertThat(!getSubject().isTrafficEnabled())
        .named("has traffic disabled")
        .isTrue();
    return this;
  }
}
