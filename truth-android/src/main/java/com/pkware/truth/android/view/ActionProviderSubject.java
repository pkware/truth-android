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
package com.pkware.truth.android.view;

import android.annotation.TargetApi;
import android.view.ActionProvider;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.os.Build.VERSION_CODES.JELLY_BEAN;

/**
 * Propositions for {@link ActionProvider} subjects.
 */
public class ActionProviderSubject extends Subject {

  @Nullable
  private final ActionProvider actual;

  public ActionProviderSubject(@Nonnull FailureMetadata failureMetadata, @Nullable ActionProvider actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasSubMenu() {
    check("hasSubMenu()").that(actual.hasSubMenu()).isTrue();
  }

  public void hasNoSubMenu() {
    check("hasSubMenu()").that(actual.hasSubMenu()).isFalse();
  }

  @TargetApi(JELLY_BEAN)
  public void isVisible() {
    check("isVisible()").that(actual.isVisible()).isTrue();
  }

  @TargetApi(JELLY_BEAN)
  public void isNotVisible() {
    check("isVisible()").that(actual.isVisible()).isFalse();
  }
}
