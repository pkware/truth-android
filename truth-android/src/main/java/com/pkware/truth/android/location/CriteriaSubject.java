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

import static android.location.Criteria.ACCURACY_COARSE;
import static android.location.Criteria.ACCURACY_FINE;
import static android.location.Criteria.ACCURACY_HIGH;
import static android.location.Criteria.ACCURACY_LOW;
import static android.location.Criteria.ACCURACY_MEDIUM;
import static android.location.Criteria.NO_REQUIREMENT;
import static android.location.Criteria.POWER_HIGH;
import static android.location.Criteria.POWER_LOW;
import static android.location.Criteria.POWER_MEDIUM;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assert_;
import static com.pkware.truth.android.internal.IntegerUtils.buildNamedValueString;

/**
 * Propositions for {@link Criteria} subjects.
 */
public class CriteriaSubject extends Subject<CriteriaSubject, Criteria> {
  protected CriteriaSubject(FailureMetadata failureMetadata, Criteria subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<CriteriaSubject, Criteria> type() {
    return new Subject.Factory<CriteriaSubject, Criteria>() {
      @Override
      public CriteriaSubject createSubject(FailureMetadata fm, Criteria that) {
        return new CriteriaSubject(fm, that);
      }
    };
  }

  public static String accuracyRequirementToString(@CriteriaAccuracyRequirement int accuracy) {
    return buildNamedValueString(accuracy)
        .value(ACCURACY_COARSE, "coarse")
        .value(ACCURACY_FINE, "fine")
        .get();
  }

  public static String accuracyToString(@CriteriaAccuracy int accuracy) {
    return buildNamedValueString(accuracy)
        .value(ACCURACY_HIGH, "high")
        .value(ACCURACY_MEDIUM, "medium")
        .value(ACCURACY_LOW, "low")
        .get();
  }

  public static String powerRequirementToString(@CriteriaPowerRequirement int requirement) {
    return buildNamedValueString(requirement)
        .value(NO_REQUIREMENT, "none")
        .value(POWER_LOW, "low")
        .value(POWER_MEDIUM, "medium")
        .value(POWER_HIGH, "high")
        .get();
  }

  public CriteriaSubject hasAccuracy(int accuracy) {
    int actualAccuracy = actual().getAccuracy();
    //noinspection ResourceType
    assert_()
        .withMessage("Expected accuracy <%s> but was <%s>.", accuracyRequirementToString(accuracy), accuracyRequirementToString(actualAccuracy))
        .that(actualAccuracy)
        .isEqualTo(accuracy);
    return this;
  }

  public CriteriaSubject hasBearingAccuracy(int accuracy) {
    int actualAccuracy = actual().getBearingAccuracy();
    //noinspection ResourceType
    assert_()
        .withMessage("Expected bearing accuracy <%s> but was <%s>.", accuracyToString(accuracy), accuracyToString(actualAccuracy))
        .that(actualAccuracy)
        .isEqualTo(accuracy);
    return this;
  }

  public CriteriaSubject hasHorizontalAccuracy(int accuracy) {
    int actualAccuracy = actual().getHorizontalAccuracy();
    //noinspection ResourceType
    assert_()
        .withMessage("Expected horizontal accuracy <%s> but was <%s>.", accuracyToString(accuracy), accuracyToString(actualAccuracy))
        .that(actualAccuracy)
        .isEqualTo(accuracy);
    return this;
  }

  public CriteriaSubject hasPowerRequirement(int requirement) {
    int actualRequirement = actual().getPowerRequirement();
    //noinspection ResourceType
    assert_()
        .withMessage("Expected power requirement <%s> but was <%s>.", powerRequirementToString(requirement), powerRequirementToString(actualRequirement))
        .that(actualRequirement)
        .isEqualTo(requirement);
    return this;
  }

  public CriteriaSubject hasSpeedAccuracy(int accuracy) {
    int actualAccuracy = actual().getSpeedAccuracy();
    //noinspection ResourceType
    assert_()
        .withMessage("Expected speed accuracy <%s> but was <%s>.", accuracyToString(accuracy), accuracyToString(actualAccuracy))
        .that(actualAccuracy)
        .isEqualTo(accuracy);
    return this;
  }

  public CriteriaSubject hasVerticalAccuracy(int accuracy) {
    int actualAccuracy = actual().getVerticalAccuracy();
    //noinspection ResourceType
    assert_()
        .withMessage("Expected vertical accuracy <%s> but was <%s>.", accuracyToString(accuracy), accuracyToString(actualAccuracy))
        .that(actualAccuracy)
        .isEqualTo(accuracy);
    return this;
  }

  public CriteriaSubject isAltitudeRequired() {
    assertThat(actual().isAltitudeRequired())
        .named("is altitude required")
        .isTrue();
    return this;
  }

  public CriteriaSubject isAltitudeNotRequired() {
    assertThat(actual().isAltitudeRequired())
        .named("is altitude required")
        .isFalse();
    return this;
  }

  public CriteriaSubject isBearingRequired() {
    assertThat(actual().isBearingRequired())
        .named("is bearing required")
        .isTrue();
    return this;
  }

  public CriteriaSubject isBearingNotRequired() {
    assertThat(actual().isBearingRequired())
        .named("is bearing required")
        .isFalse();
    return this;
  }

  public CriteriaSubject isCostAllowed() {
    assertThat(actual().isCostAllowed())
        .named("is cost allowed")
        .isTrue();
    return this;
  }

  public CriteriaSubject isCostNotAllowed() {
    assertThat(!actual().isCostAllowed())
        .named("cost is not allowed")
        .isTrue();
    return this;
  }

  public CriteriaSubject isSpeedRequired() {
    assertThat(actual().isSpeedRequired())
        .named("is speed required")
        .isTrue();
    return this;
  }

  public CriteriaSubject isSpeedNotRequired() {
    assertThat(!actual().isSpeedRequired())
        .named("speed is not required")
        .isTrue();
    return this;
  }
}
