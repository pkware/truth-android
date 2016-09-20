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
package com.pkware.truth.android.view;

import android.annotation.TargetApi;
import android.view.ActionProvider;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.JELLY_BEAN;
import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link ActionProvider} subjects.
 */
public class ActionProviderSubject extends Subject<ActionProviderSubject, ActionProvider> {
  protected ActionProviderSubject(FailureStrategy failureStrategy, ActionProvider subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<ActionProviderSubject, ActionProvider> type() {
    return new SubjectFactory<ActionProviderSubject, ActionProvider>() {
      @Override
      public ActionProviderSubject getSubject(FailureStrategy fs, ActionProvider that) {
        return new ActionProviderSubject(fs, that);
      }
    };
  }

  public ActionProviderSubject hasSubMenu() {
    assertThat(actual().hasSubMenu())
        .named("has sub-menu")
        .isTrue();
    return this;
  }

  public ActionProviderSubject hasNoSubMenu() {
    assertThat(actual().hasSubMenu())
        .named("has sub-menu")
        .isFalse();
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public ActionProviderSubject isVisible() {
    assertThat(actual().isVisible())
        .named("is visible")
        .isTrue();
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public ActionProviderSubject isNotVisible() {
    assertThat(actual().isVisible())
        .named("is visible")
        .isFalse();
    return this;
  }
}
