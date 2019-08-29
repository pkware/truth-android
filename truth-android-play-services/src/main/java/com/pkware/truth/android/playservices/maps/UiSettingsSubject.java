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

import com.google.android.gms.maps.UiSettings;
import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link UiSettings} subjects.
 */
public class UiSettingsSubject extends Subject {

  @Nullable
  private final UiSettings actual;

  public UiSettingsSubject(@Nonnull FailureMetadata failureMetadata, @Nullable UiSettings actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasCompassEnabled() {
    check("isCompassEnabled()").that(actual.isCompassEnabled()).isTrue();
  }

  public void hasCompassDisabled() {
    check("isCompassEnabled()").that(actual.isCompassEnabled()).isFalse();
  }

  public void hasIndoorLevelPickerEnabled() {
    check("isIndoorLevelPickerEnabled()").that(actual.isIndoorLevelPickerEnabled()).isTrue();
  }

  public void hasIndoorLevelPickerDisabled() {
    check("isIndoorLevelPickerEnabled()").that(actual.isIndoorLevelPickerEnabled()).isFalse();
  }

  public void hasMyLocationButtonEnabled() {
    check("isMyLocationButtonEnabled()").that(actual.isMyLocationButtonEnabled()).isTrue();
  }

  public void hasMyLocationButtonDisabled() {
    check("isMyLocationButtonEnabled()").that(actual.isMyLocationButtonEnabled()).isFalse();
  }

  public void hasRotateGesturesEnabled() {
    check("isRotateGesturesEnabled()").that(actual.isRotateGesturesEnabled()).isTrue();
  }

  public void hasRotateGesturesDisabled() {
    check("isRotateGesturesEnabled()").that(actual.isRotateGesturesEnabled()).isFalse();
  }

  public void hasScrollGesturesEnabled() {
    check("isScrollGesturesEnabled()").that(actual.isScrollGesturesEnabled()).isTrue();
  }

  public void hasScrollGesturesDisabled() {
    check("isScrollGesturesEnabled()").that(actual.isScrollGesturesEnabled()).isFalse();
  }

  public void hasTiltGesturesEnabled() {
    check("isTiltGesturesEnabled()").that(actual.isTiltGesturesEnabled()).isTrue();
  }

  public void hasTiltGesturesDisabled() {
    check("isTiltGesturesEnabled()").that(actual.isTiltGesturesEnabled()).isFalse();
  }

  public void hasZoomControlsEnabled() {
    check("isZoomControlsEnabled()").that(actual.isZoomControlsEnabled()).isTrue();
  }

  public void hasZoomControlsDisabled() {
    check("isZoomControlsEnabled()").that(actual.isZoomControlsEnabled()).isFalse();
  }

  public void hasZoomGesturesEnabled() {
    check("isZoomGesturesEnabled()").that(actual.isZoomGesturesEnabled()).isTrue();
  }

  public void hasZoomGesturesDisabled() {
    check("isZoomGesturesEnabled()").that(actual.isZoomGesturesEnabled()).isFalse();
  }
}
