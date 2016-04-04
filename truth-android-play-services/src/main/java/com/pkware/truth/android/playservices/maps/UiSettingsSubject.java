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

import com.google.android.gms.maps.UiSettings;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

/**
 * Propositions for {@link UiSettings} subjects.
 */
public class UiSettingsSubject extends Subject<UiSettingsSubject, UiSettings> {
  protected UiSettingsSubject(FailureStrategy failureStrategy, UiSettings subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<UiSettingsSubject, UiSettings> type() {
    return new SubjectFactory<UiSettingsSubject, UiSettings>() {
      @Override
      public UiSettingsSubject getSubject(FailureStrategy fs, UiSettings that) {
        return new UiSettingsSubject(fs, that);
      }
    };
  }

  public UiSettingsSubject hasCompassEnabled() {
    assertThat(getSubject().isCompassEnabled())
        .overridingErrorMessage("Expected compass to be enabled but was disabled.")
        .isTrue();
    return this;
  }

  public UiSettingsSubject hasCompassDisabled() {
    assertThat(getSubject().isCompassEnabled())
        .overridingErrorMessage("Expected compass to be disabled but was enabled.")
        .isFalse();
    return this;
  }

  public UiSettingsSubject hasIndoorLevelPickerEnabled() {
    assertThat(getSubject().isIndoorLevelPickerEnabled())
        .overridingErrorMessage("Expected indoor level picker to be enabled but was disabled.")
        .isTrue();
    return this;
  }

  public UiSettingsSubject hasIndoorLevelPickerDisabled() {
    assertThat(getSubject().isIndoorLevelPickerEnabled())
        .overridingErrorMessage("Expected indoor level picker to be disabled but was enabled.")
        .isFalse();
    return this;
  }

  public UiSettingsSubject hasMyLocationButtonEnabled() {
    assertThat(getSubject().isMyLocationButtonEnabled())
        .overridingErrorMessage("Expected my location button to be enabled but was disabled.")
        .isTrue();
    return this;
  }

  public UiSettingsSubject hasMyLocationButtonDisabled() {
    assertThat(getSubject().isMyLocationButtonEnabled())
        .overridingErrorMessage("Expected my location button to be disabled but was enabled.")
        .isFalse();
    return this;
  }

  public UiSettingsSubject hasRotateGesturesEnabled() {
    assertThat(getSubject().isRotateGesturesEnabled())
        .overridingErrorMessage("Expected rotate gestures to be enabled but was disabled.")
        .isTrue();
    return this;
  }

  public UiSettingsSubject hasRotateGesturesDisabled() {
    assertThat(getSubject().isRotateGesturesEnabled())
        .overridingErrorMessage("Expected rotate gestures to be disabled but was enabled.")
        .isFalse();
    return this;
  }

  public UiSettingsSubject hasScrollGesturesEnabled() {
    assertThat(getSubject().isScrollGesturesEnabled())
        .overridingErrorMessage("Expected scroll gestures to be enabled but was disabled.")
        .isTrue();
    return this;
  }

  public UiSettingsSubject hasScrollGesturesDisabled() {
    assertThat(getSubject().isScrollGesturesEnabled())
        .overridingErrorMessage("Expected scroll gestures to be disabled but was enabled.")
        .isFalse();
    return this;
  }

  public UiSettingsSubject hasTiltGesturesEnabled() {
    assertThat(getSubject().isTiltGesturesEnabled())
        .overridingErrorMessage("Expected tilt gestures to be enabled but was disabled.")
        .isTrue();
    return this;
  }

  public UiSettingsSubject hasTiltGesturesDisabled() {
    assertThat(getSubject().isTiltGesturesEnabled())
        .overridingErrorMessage("Expected tilt gestures to be disabled but was enabled.")
        .isFalse();
    return this;
  }

  public UiSettingsSubject hasZoomControlsEnabled() {
    assertThat(getSubject().isZoomControlsEnabled())
        .overridingErrorMessage("Expected zoom controls to be enabled but was disabled.")
        .isTrue();
    return this;
  }

  public UiSettingsSubject hasZoomControlsDisabled() {
    assertThat(getSubject().isZoomControlsEnabled())
        .overridingErrorMessage("Expected zoom controls to be disabled but was enabled.")
        .isFalse();
    return this;
  }

  public UiSettingsSubject hasZoomGesturesEnabled() {
    assertThat(getSubject().isZoomGesturesEnabled())
        .overridingErrorMessage("Expected zoom gestures to be enabled but was disabled.")
        .isTrue();
    return this;
  }

  public UiSettingsSubject hasZoomGesturesDisabled() {
    assertThat(getSubject().isZoomGesturesEnabled())
        .overridingErrorMessage("Expected zoom gestures to be disabled but was enabled.")
        .isFalse();
    return this;
  }
}
