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

import android.location.Criteria;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.location.Criteria.ACCURACY_COARSE;
import static android.location.Criteria.ACCURACY_FINE;
import static android.location.Criteria.ACCURACY_HIGH;
import static android.location.Criteria.ACCURACY_LOW;
import static android.location.Criteria.ACCURACY_MEDIUM;
import static android.location.Criteria.NO_REQUIREMENT;
import static android.location.Criteria.POWER_HIGH;
import static android.location.Criteria.POWER_LOW;
import static android.location.Criteria.POWER_MEDIUM;
import static com.pkware.truth.android.internal.IntegerUtils.buildNamedValueString;

/**
 * Propositions for {@link Criteria} subjects.
 */
public class CriteriaSubject extends Subject {

  @Nullable
  private final Criteria actual;

  public CriteriaSubject(@Nonnull FailureMetadata failureMetadata, @Nullable Criteria actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  @Nonnull
  public static String accuracyRequirementToString(@CriteriaAccuracyRequirement int accuracy) {
    return buildNamedValueString(accuracy)
        .value(ACCURACY_COARSE, "coarse")
        .value(ACCURACY_FINE, "fine")
        .get();
  }

  @Nonnull
  public static String accuracyToString(@CriteriaAccuracy int accuracy) {
    return buildNamedValueString(accuracy)
        .value(ACCURACY_HIGH, "high")
        .value(ACCURACY_MEDIUM, "medium")
        .value(ACCURACY_LOW, "low")
        .get();
  }

  @Nonnull
  public static String powerRequirementToString(@CriteriaPowerRequirement int requirement) {
    return buildNamedValueString(requirement)
        .value(NO_REQUIREMENT, "none")
        .value(POWER_LOW, "low")
        .value(POWER_MEDIUM, "medium")
        .value(POWER_HIGH, "high")
        .get();
  }

  public void hasAccuracy(int accuracy) {
    int actualAccuracy = actual.getAccuracy();
    //noinspection ResourceType
    check("getAccuracy()")
        .withMessage("Expected accuracy <%s> but was <%s>.", accuracyRequirementToString(accuracy), accuracyRequirementToString(actualAccuracy))
        .that(actualAccuracy)
        .isEqualTo(accuracy);
  }

  public void hasBearingAccuracy(int accuracy) {
    int actualAccuracy = actual.getBearingAccuracy();
    //noinspection ResourceType
    check("getBearingAccuracy()")
        .withMessage("Expected bearing accuracy <%s> but was <%s>.", accuracyToString(accuracy), accuracyToString(actualAccuracy))
        .that(actualAccuracy)
        .isEqualTo(accuracy);
  }

  public void hasHorizontalAccuracy(int accuracy) {
    int actualAccuracy = actual.getHorizontalAccuracy();
    //noinspection ResourceType
    check("getHorizontalAccuracy()")
        .withMessage("Expected horizontal accuracy <%s> but was <%s>.", accuracyToString(accuracy), accuracyToString(actualAccuracy))
        .that(actualAccuracy)
        .isEqualTo(accuracy);
  }

  public void hasPowerRequirement(int requirement) {
    int actualRequirement = actual.getPowerRequirement();
    //noinspection ResourceType
    check("getPowerRequirement()")
        .withMessage("Expected power requirement <%s> but was <%s>.", powerRequirementToString(requirement), powerRequirementToString(actualRequirement))
        .that(actualRequirement)
        .isEqualTo(requirement);
  }

  public void hasSpeedAccuracy(int accuracy) {
    int actualAccuracy = actual.getSpeedAccuracy();
    //noinspection ResourceType
    check("getSpeedAccuracy()")
        .withMessage("Expected speed accuracy <%s> but was <%s>.", accuracyToString(accuracy), accuracyToString(actualAccuracy))
        .that(actualAccuracy)
        .isEqualTo(accuracy);
  }

  public void hasVerticalAccuracy(int accuracy) {
    int actualAccuracy = actual.getVerticalAccuracy();
    //noinspection ResourceType
    check("getVerticalAccuracy()")
        .withMessage("Expected vertical accuracy <%s> but was <%s>.", accuracyToString(accuracy), accuracyToString(actualAccuracy))
        .that(actualAccuracy)
        .isEqualTo(accuracy);
  }

  public void isAltitudeRequired() {
    check("isAltitudeRequired()").that(actual.isAltitudeRequired()).isTrue();
  }

  public void isAltitudeNotRequired() {
    check("isAltitudeRequired()").that(actual.isAltitudeRequired()).isFalse();
  }

  public void isBearingRequired() {
    check("isBearingRequired()").that(actual.isBearingRequired()).isTrue();
  }

  public void isBearingNotRequired() {
    check("isBearingRequired()").that(actual.isBearingRequired()).isFalse();
  }

  public void isCostAllowed() {
    check("isCostAllowed()").that(actual.isCostAllowed()).isTrue();
  }

  public void isCostNotAllowed() {
    check("isCostAllowed()").that(actual.isCostAllowed()).isFalse();
  }

  public void isSpeedRequired() {
    check("isSpeedRequired()").that(actual.isSpeedRequired()).isTrue();
  }

  public void isSpeedNotRequired() {
    check("isSpeedRequired()").that(actual.isSpeedRequired()).isFalse();
  }
}
