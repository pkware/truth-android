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
package com.pkware.truth.android.location;

import android.location.LocationProvider;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assert_;
import static com.pkware.truth.android.location.CriteriaSubject.accuracyRequirementToString;
import static com.pkware.truth.android.location.CriteriaSubject.powerRequirementToString;

/**
 * Propositions for {@link LocationProvider} subjects.
 */
public class LocationProviderSubject extends Subject<LocationProviderSubject, LocationProvider> {
  protected LocationProviderSubject(FailureStrategy failureStrategy, LocationProvider subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<LocationProviderSubject, LocationProvider> type() {
    return new SubjectFactory<LocationProviderSubject, LocationProvider>() {
      @Override
      public LocationProviderSubject getSubject(FailureStrategy fs, LocationProvider that) {
        return new LocationProviderSubject(fs, that);
      }
    };
  }

  public LocationProviderSubject hasAccuracy(int accuracy) {
    int actualAccuracy = getSubject().getAccuracy();
    assert_()
        .withFailureMessage("Expected accuracy <%s> but was <%s>.", accuracyRequirementToString(accuracy), accuracyRequirementToString(actualAccuracy))
        .that(actualAccuracy)
        .isEqualTo(accuracy);
    return this;
  }

  public LocationProviderSubject hasName(String name) {
    assertThat(getSubject().getName())
        .named("name")
        .isEqualTo(name);
    return this;
  }

  public LocationProviderSubject hasPowerRequirement(int requirement) {
    int actualRequirement = getSubject().getPowerRequirement();
    assert_()
        .withFailureMessage("Expected power requirement <%s> but was <%s>.", powerRequirementToString(requirement), powerRequirementToString(actualRequirement))
        .that(actualRequirement)
        .isEqualTo(requirement);
    return this;
  }

  public LocationProviderSubject hasMonetaryCost() {
    assertThat(getSubject().hasMonetaryCost())
        .named("has monetary cost")
        .isTrue();
    return this;
  }

  public LocationProviderSubject hasNoMonetaryCost() {
    assertThat(getSubject().hasMonetaryCost())
        .named("has monetary cost")
        .isFalse();
    return this;
  }

  public LocationProviderSubject hasCellRequirement() {
    assertThat(getSubject().requiresCell())
        .named("requires cell network")
        .isTrue();
    return this;
  }

  public LocationProviderSubject hasNoCellRequirement() {
    assertThat(getSubject().requiresCell())
        .named("requires cell network")
        .isFalse();
    return this;
  }

  public LocationProviderSubject hasNetworkRequirement() {
    assertThat(getSubject().requiresNetwork())
        .named("requires network")
        .isTrue();
    return this;
  }

  public LocationProviderSubject hasNoNetworkRequirement() {
    assertThat(getSubject().requiresNetwork())
        .named("requires network")
        .isFalse();
    return this;
  }

  public LocationProviderSubject hasSatelliteRequirement() {
    assertThat(getSubject().requiresSatellite())
        .named("requires satellite")
        .isTrue();
    return this;
  }

  public LocationProviderSubject hasNoSatelliteRequirement() {
    assertThat(getSubject().requiresSatellite())
        .named("requires satellite")
        .isFalse();
    return this;
  }

  public LocationProviderSubject hasAltitudeSupport() {
    assertThat(getSubject().supportsAltitude())
        .named("supports altitude")
        .isTrue();
    return this;
  }

  public LocationProviderSubject hasNoAltitudeSupport() {
    assertThat(getSubject().supportsAltitude())
        .named("supports altitude")
        .isFalse();
    return this;
  }

  public LocationProviderSubject hasBearingSupport() {
    assertThat(getSubject().supportsBearing())
        .named("supports bearing")
        .isTrue();
    return this;
  }

  public LocationProviderSubject hasNoBearingSupport() {
    assertThat(getSubject().supportsBearing())
        .named("supports bearing")
        .isFalse();
    return this;
  }

  public LocationProviderSubject hasSpeedSupport() {
    assertThat(getSubject().supportsSpeed())
        .named("supports speed")
        .isTrue();
    return this;
  }

  public LocationProviderSubject hasNoSpeedSupport() {
    assertThat(getSubject().supportsSpeed())
        .named("supports speed")
        .isFalse();
    return this;
  }
}
