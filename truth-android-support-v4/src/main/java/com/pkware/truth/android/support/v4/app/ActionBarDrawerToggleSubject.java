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
package com.pkware.truth.android.support.v4.app;

import android.support.v4.app.ActionBarDrawerToggle;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link ActionBarDrawerToggle} subjects.
 */
public class ActionBarDrawerToggleSubject extends Subject<ActionBarDrawerToggleSubject, ActionBarDrawerToggle> {
  protected ActionBarDrawerToggleSubject(FailureStrategy failureStrategy, ActionBarDrawerToggle subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<ActionBarDrawerToggleSubject, ActionBarDrawerToggle> type() {
    return new SubjectFactory<ActionBarDrawerToggleSubject, ActionBarDrawerToggle>() {
      @Override
      public ActionBarDrawerToggleSubject getSubject(FailureStrategy fs, ActionBarDrawerToggle that) {
        return new ActionBarDrawerToggleSubject(fs, that);
      }
    };
  }

  public ActionBarDrawerToggleSubject hasDrawerIndicatorEnabled() {
    assertThat(getSubject().isDrawerIndicatorEnabled())
        .named("drawer indicator is enabled")
        .isTrue();
    return this;
  }

  public ActionBarDrawerToggleSubject doesNotHaveDrawerIndicatorEnabled() {
    assertThat(!getSubject().isDrawerIndicatorEnabled())
        .named("drawer indicator is disabled")
        .isTrue();
    return this;
  }
}
