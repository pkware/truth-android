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

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link AccessibilityManager} subjects.
 */
public class AccessibilityManagerSubject extends Subject<AccessibilityManagerSubject, AccessibilityManager> {
  protected AccessibilityManagerSubject(FailureMetadata failureMetadata, AccessibilityManager subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<AccessibilityManagerSubject, AccessibilityManager> type() {
    return AccessibilityManagerSubject::new;
  }

  public AccessibilityManagerSubject isEnabled() {
    assertThat(actual().isEnabled())
        .named("is enabled")
        .isTrue();
    return this;
  }

  public AccessibilityManagerSubject isDisabled() {
    assertThat(!actual().isEnabled())
        .named("is disabled")
        .isTrue();
    return this;
  }

  public AccessibilityManagerSubject isTouchExplorationEnabled() {
    assertThat(actual().isTouchExplorationEnabled())
        .named("is touch exploration enabled")
        .isTrue();
    return this;
  }

  public AccessibilityManagerSubject isTouchExplorationDisabled() {
    assertThat(actual().isTouchExplorationEnabled())
        .named("is touch exploration enabled")
        .isFalse();
    return this;
  }
}
