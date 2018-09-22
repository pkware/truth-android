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

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assert_;
import static com.pkware.truth.android.location.CriteriaSubject.accuracyRequirementToString;
import static com.pkware.truth.android.location.CriteriaSubject.powerRequirementToString;

/**
 * Propositions for {@link LocationProvider} subjects.
 */
public class LocationProviderSubject extends Subject<LocationProviderSubject, LocationProvider> {
  protected LocationProviderSubject(FailureMetadata failureMetadata, LocationProvider subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<LocationProviderSubject, LocationProvider> type() {
    return new Subject.Factory<LocationProviderSubject, LocationProvider>() {
      @Override
      public LocationProviderSubject createSubject(FailureMetadata fm, LocationProvider that) {
        return new LocationProviderSubject(fm, that);
      }
    };
  }

  public LocationProviderSubject hasAccuracy(int accuracy) {
    int actualAccuracy = actual().getAccuracy();
    assert_()
        .withMessage("Expected accuracy <%s> but was <%s>.", accuracyRequirementToString(accuracy), accuracyRequirementToString(actualAccuracy))
        .that(actualAccuracy)
        .isEqualTo(accuracy);
    return this;
  }

  public LocationProviderSubject hasName(String name) {
    assertThat(actual().getName())
        .named("name")
        .isEqualTo(name);
    return this;
  }

  public LocationProviderSubject hasPowerRequirement(int requirement) {
    int actualRequirement = actual().getPowerRequirement();
    assert_()
        .withMessage("Expected power requirement <%s> but was <%s>.", powerRequirementToString(requirement), powerRequirementToString(actualRequirement))
        .that(actualRequirement)
        .isEqualTo(requirement);
    return this;
  }

  public LocationProviderSubject hasMonetaryCost() {
    assertThat(actual().hasMonetaryCost())
        .named("has monetary cost")
        .isTrue();
    return this;
  }

  public LocationProviderSubject hasNoMonetaryCost() {
    assertThat(actual().hasMonetaryCost())
        .named("has monetary cost")
        .isFalse();
    return this;
  }

  public LocationProviderSubject hasCellRequirement() {
    assertThat(actual().requiresCell())
        .named("requires cell network")
        .isTrue();
    return this;
  }

  public LocationProviderSubject hasNoCellRequirement() {
    assertThat(actual().requiresCell())
        .named("requires cell network")
        .isFalse();
    return this;
  }

  public LocationProviderSubject hasNetworkRequirement() {
    assertThat(actual().requiresNetwork())
        .named("requires network")
        .isTrue();
    return this;
  }

  public LocationProviderSubject hasNoNetworkRequirement() {
    assertThat(actual().requiresNetwork())
        .named("requires network")
        .isFalse();
    return this;
  }

  public LocationProviderSubject hasSatelliteRequirement() {
    assertThat(actual().requiresSatellite())
        .named("requires satellite")
        .isTrue();
    return this;
  }

  public LocationProviderSubject hasNoSatelliteRequirement() {
    assertThat(actual().requiresSatellite())
        .named("requires satellite")
        .isFalse();
    return this;
  }

  public LocationProviderSubject hasAltitudeSupport() {
    assertThat(actual().supportsAltitude())
        .named("supports altitude")
        .isTrue();
    return this;
  }

  public LocationProviderSubject hasNoAltitudeSupport() {
    assertThat(actual().supportsAltitude())
        .named("supports altitude")
        .isFalse();
    return this;
  }

  public LocationProviderSubject hasBearingSupport() {
    assertThat(actual().supportsBearing())
        .named("supports bearing")
        .isTrue();
    return this;
  }

  public LocationProviderSubject hasNoBearingSupport() {
    assertThat(actual().supportsBearing())
        .named("supports bearing")
        .isFalse();
    return this;
  }

  public LocationProviderSubject hasSpeedSupport() {
    assertThat(actual().supportsSpeed())
        .named("supports speed")
        .isTrue();
    return this;
  }

  public LocationProviderSubject hasNoSpeedSupport() {
    assertThat(actual().supportsSpeed())
        .named("supports speed")
        .isFalse();
    return this;
  }
}
