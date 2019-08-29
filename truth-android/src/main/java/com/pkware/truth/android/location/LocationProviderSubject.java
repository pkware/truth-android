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
package com.pkware.truth.android.location;

import android.location.LocationProvider;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static com.pkware.truth.android.location.CriteriaSubject.accuracyRequirementToString;
import static com.pkware.truth.android.location.CriteriaSubject.powerRequirementToString;

/**
 * Propositions for {@link LocationProvider} subjects.
 */
public class LocationProviderSubject extends Subject {

  @Nullable
  private final LocationProvider actual;

  public LocationProviderSubject(@Nonnull FailureMetadata failureMetadata, @Nullable LocationProvider actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasAccuracy(int accuracy) {
    int actualAccuracy = actual.getAccuracy();
    check("getAccuracy()")
        .withMessage("Expected accuracy <%s> but was <%s>.", accuracyRequirementToString(accuracy), accuracyRequirementToString(actualAccuracy))
        .that(actualAccuracy)
        .isEqualTo(accuracy);
  }

  public void hasName(@Nullable String name) {
    check("getName()").that(actual.getName()).isEqualTo(name);
  }

  public void hasPowerRequirement(int requirement) {
    int actualRequirement = actual.getPowerRequirement();
    check("getPowerRequirement()")
        .withMessage("Expected power requirement <%s> but was <%s>.", powerRequirementToString(requirement), powerRequirementToString(actualRequirement))
        .that(actualRequirement)
        .isEqualTo(requirement);
  }

  public void hasMonetaryCost() {
    check("hasMonetaryCost()").that(actual.hasMonetaryCost()).isTrue();
  }

  public void hasNoMonetaryCost() {
    check("hasMonetaryCost()").that(actual.hasMonetaryCost()).isFalse();
  }

  public void hasCellRequirement() {
    check("requiresCell()").that(actual.requiresCell()).isTrue();
  }

  public void hasNoCellRequirement() {
    check("requiresCell()").that(actual.requiresCell()).isFalse();
  }

  public void hasNetworkRequirement() {
    check("requiresNetwork()").that(actual.requiresNetwork()).isTrue();
  }

  public void hasNoNetworkRequirement() {
    check("requiresNetwork()").that(actual.requiresNetwork()).isFalse();
  }

  public void hasSatelliteRequirement() {
    check("requiresSatellite()").that(actual.requiresSatellite()).isTrue();
  }

  public void hasNoSatelliteRequirement() {
    check("requiresSatellite()").that(actual.requiresSatellite()).isFalse();
  }

  public void hasAltitudeSupport() {
    check("supportsAltitude()").that(actual.supportsAltitude()).isTrue();
  }

  public void hasNoAltitudeSupport() {
    check("supportsAltitude()").that(actual.supportsAltitude()).isFalse();
  }

  public void hasBearingSupport() {
    check("supportsBearing()").that(actual.supportsBearing()).isTrue();
  }

  public void hasNoBearingSupport() {
    check("supportsBearing()").that(actual.supportsBearing()).isFalse();
  }

  public void hasSpeedSupport() {
    check("supportsSpeed()").that(actual.supportsSpeed()).isTrue();
  }

  public void hasNoSpeedSupport() {
    check("supportsSpeed()").that(actual.supportsSpeed()).isFalse();
  }
}
