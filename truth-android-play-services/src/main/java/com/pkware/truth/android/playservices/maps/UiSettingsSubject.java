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

  public UiSettingsSubject hasCompassEnabled() {
    check("isCompassEnabled()").that(actual.isCompassEnabled()).isTrue();
    return this;
  }

  public UiSettingsSubject hasCompassDisabled() {
    check("isCompassEnabled()").that(actual.isCompassEnabled()).isFalse();
    return this;
  }

  public UiSettingsSubject hasIndoorLevelPickerEnabled() {
    check("isIndoorLevelPickerEnabled()").that(actual.isIndoorLevelPickerEnabled()).isTrue();
    return this;
  }

  public UiSettingsSubject hasIndoorLevelPickerDisabled() {
    check("isIndoorLevelPickerEnabled()").that(actual.isIndoorLevelPickerEnabled()).isFalse();
    return this;
  }

  public UiSettingsSubject hasMyLocationButtonEnabled() {
    check("isMyLocationButtonEnabled()").that(actual.isMyLocationButtonEnabled()).isTrue();
    return this;
  }

  public UiSettingsSubject hasMyLocationButtonDisabled() {
    check("isMyLocationButtonEnabled()").that(actual.isMyLocationButtonEnabled()).isFalse();
    return this;
  }

  public UiSettingsSubject hasRotateGesturesEnabled() {
    check("isRotateGesturesEnabled()").that(actual.isRotateGesturesEnabled()).isTrue();
    return this;
  }

  public UiSettingsSubject hasRotateGesturesDisabled() {
    check("isRotateGesturesEnabled()").that(actual.isRotateGesturesEnabled()).isFalse();
    return this;
  }

  public UiSettingsSubject hasScrollGesturesEnabled() {
    check("isScrollGesturesEnabled()").that(actual.isScrollGesturesEnabled()).isTrue();
    return this;
  }

  public UiSettingsSubject hasScrollGesturesDisabled() {
    check("isScrollGesturesEnabled()").that(actual.isScrollGesturesEnabled()).isFalse();
    return this;
  }

  public UiSettingsSubject hasTiltGesturesEnabled() {
    check("isTiltGesturesEnabled()").that(actual.isTiltGesturesEnabled()).isTrue();
    return this;
  }

  public UiSettingsSubject hasTiltGesturesDisabled() {
    check("isTiltGesturesEnabled()").that(actual.isTiltGesturesEnabled()).isFalse();
    return this;
  }

  public UiSettingsSubject hasZoomControlsEnabled() {
    check("isZoomControlsEnabled()").that(actual.isZoomControlsEnabled()).isTrue();
    return this;
  }

  public UiSettingsSubject hasZoomControlsDisabled() {
    check("isZoomControlsEnabled()").that(actual.isZoomControlsEnabled()).isFalse();
    return this;
  }

  public UiSettingsSubject hasZoomGesturesEnabled() {
    check("isZoomGesturesEnabled()").that(actual.isZoomGesturesEnabled()).isTrue();
    return this;
  }

  public UiSettingsSubject hasZoomGesturesDisabled() {
    check("isZoomGesturesEnabled()").that(actual.isZoomGesturesEnabled()).isFalse();
    return this;
  }
}
