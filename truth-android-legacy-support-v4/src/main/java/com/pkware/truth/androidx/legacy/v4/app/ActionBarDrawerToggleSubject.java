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
package com.pkware.truth.androidx.legacy.v4.app;

import androidx.legacy.app.ActionBarDrawerToggle;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link ActionBarDrawerToggle} subjects.
 */
@SuppressWarnings("deprecation")
public class ActionBarDrawerToggleSubject extends Subject<ActionBarDrawerToggleSubject, ActionBarDrawerToggle> {
  public ActionBarDrawerToggleSubject(FailureMetadata failureMetadata, ActionBarDrawerToggle subject) {
    super(failureMetadata, subject);
  }

  public ActionBarDrawerToggleSubject hasDrawerIndicatorEnabled() {
    assertThat(actual().isDrawerIndicatorEnabled())
        .named("drawer indicator is enabled")
        .isTrue();
    return this;
  }

  public ActionBarDrawerToggleSubject doesNotHaveDrawerIndicatorEnabled() {
    assertThat(!actual().isDrawerIndicatorEnabled())
        .named("drawer indicator is disabled")
        .isTrue();
    return this;
  }
}
