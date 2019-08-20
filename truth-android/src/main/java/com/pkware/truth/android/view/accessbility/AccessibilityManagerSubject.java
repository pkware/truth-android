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
package com.pkware.truth.android.view.accessbility;

import android.view.accessibility.AccessibilityManager;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link AccessibilityManager} subjects.
 */
public class AccessibilityManagerSubject extends Subject {

  @Nullable
  private final AccessibilityManager actual;

  public AccessibilityManagerSubject(@Nonnull FailureMetadata failureMetadata, @Nullable AccessibilityManager actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public AccessibilityManagerSubject isEnabled() {
    check("isEnabled()").that(actual.isEnabled()).isTrue();
    return this;
  }

  public AccessibilityManagerSubject isDisabled() {
    check("isEnabled()").that(actual.isEnabled()).isFalse();
    return this;
  }

  public AccessibilityManagerSubject isTouchExplorationEnabled() {
    check("isTouchExplorationEnabled()").that(actual.isTouchExplorationEnabled()).isTrue();
    return this;
  }

  public AccessibilityManagerSubject isTouchExplorationDisabled() {
    check("isTouchExplorationEnabled()").that(actual.isTouchExplorationEnabled()).isFalse();
    return this;
  }
}
