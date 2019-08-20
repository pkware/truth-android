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

  public LocationProviderSubject hasAccuracy(int accuracy) {
    int actualAccuracy = actual.getAccuracy();
    check("getAccuracy()")
        .withMessage("Expected accuracy <%s> but was <%s>.", accuracyRequirementToString(accuracy), accuracyRequirementToString(actualAccuracy))
        .that(actualAccuracy)
        .isEqualTo(accuracy);
    return this;
  }

  public LocationProviderSubject hasName(@Nullable String name) {
    check("getName()").that(actual.getName()).isEqualTo(name);
    return this;
  }

  public LocationProviderSubject hasPowerRequirement(int requirement) {
    int actualRequirement = actual.getPowerRequirement();
    check("getPowerRequirement()")
        .withMessage("Expected power requirement <%s> but was <%s>.", powerRequirementToString(requirement), powerRequirementToString(actualRequirement))
        .that(actualRequirement)
        .isEqualTo(requirement);
    return this;
  }

  public LocationProviderSubject hasMonetaryCost() {
    check("hasMonetaryCost()").that(actual.hasMonetaryCost()).isTrue();
    return this;
  }

  public LocationProviderSubject hasNoMonetaryCost() {
    check("hasMonetaryCost()").that(actual.hasMonetaryCost()).isFalse();
    return this;
  }

  public LocationProviderSubject hasCellRequirement() {
    check("requiresCell()").that(actual.requiresCell()).isTrue();
    return this;
  }

  public LocationProviderSubject hasNoCellRequirement() {
    check("requiresCell()").that(actual.requiresCell()).isFalse();
    return this;
  }

  public LocationProviderSubject hasNetworkRequirement() {
    check("requiresNetwork()").that(actual.requiresNetwork()).isTrue();
    return this;
  }

  public LocationProviderSubject hasNoNetworkRequirement() {
    check("requiresNetwork()").that(actual.requiresNetwork()).isFalse();
    return this;
  }

  public LocationProviderSubject hasSatelliteRequirement() {
    check("requiresSatellite()").that(actual.requiresSatellite()).isTrue();
    return this;
  }

  public LocationProviderSubject hasNoSatelliteRequirement() {
    check("requiresSatellite()").that(actual.requiresSatellite()).isFalse();
    return this;
  }

  public LocationProviderSubject hasAltitudeSupport() {
    check("supportsAltitude()").that(actual.supportsAltitude()).isTrue();
    return this;
  }

  public LocationProviderSubject hasNoAltitudeSupport() {
    check("supportsAltitude()").that(actual.supportsAltitude()).isFalse();
    return this;
  }

  public LocationProviderSubject hasBearingSupport() {
    check("supportsBearing()").that(actual.supportsBearing()).isTrue();
    return this;
  }

  public LocationProviderSubject hasNoBearingSupport() {
    check("supportsBearing()").that(actual.supportsBearing()).isFalse();
    return this;
  }

  public LocationProviderSubject hasSpeedSupport() {
    check("supportsSpeed()").that(actual.supportsSpeed()).isTrue();
    return this;
  }

  public LocationProviderSubject hasNoSpeedSupport() {
    check("supportsSpeed()").that(actual.supportsSpeed()).isFalse();
    return this;
  }
}
