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
package com.pkware.truth.android.appcompat.v7.view;

import android.view.View;
import androidx.appcompat.view.ActionMode;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link ActionMode} subjects.
 */
public class ActionModeSubject extends Subject<ActionModeSubject, ActionMode> {
  protected ActionModeSubject(FailureMetadata failureMetadata, ActionMode subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<ActionModeSubject, ActionMode> type() {
    return ActionModeSubject::new;
  }

  public ActionModeSubject hasCustomView() {
    assertThat(actual().getCustomView())
        .named("custom view")
        .isNotNull();
    return this;
  }

  public ActionModeSubject hasCustomView(View view) {
    View actualView = actual().getCustomView();
    assertThat(actual().getCustomView())
        .named("custom view")
        .isEqualTo(view);
    return this;
  }

  public ActionModeSubject hasSubtitle(String subtitle) {
    assertThat(actual().getSubtitle().toString())
        .named("subtitle")
        .isEqualTo(subtitle);
    return this;
  }

  public ActionModeSubject hasTag(Object tag) {
    assertThat(actual().getTag())
        .named("tag")
        .isEqualTo(tag);
    return this;
  }

  public ActionModeSubject hasTitle(String title) {
    assertThat(actual().getTitle().toString())
        .named("title")
        .isEqualTo(title);
    return this;
  }

  public ActionModeSubject hasOptionalTitleHint() {
    assertThat(actual().getTitleOptionalHint())
        .named("has optional title hint")
        .isTrue();
    return this;
  }

  public ActionModeSubject hasNonOptionalTitleHint() {
    assertThat(actual().getTitleOptionalHint())
        .named("has optional title hint")
        .isFalse();
    return this;
  }

  public ActionModeSubject hasOptionalTitle() {
    assertThat(actual().isTitleOptional())
        .named("has optional title")
        .isTrue();
    return this;
  }

  public ActionModeSubject hasNonOptionalTitle() {
    assertThat(actual().isTitleOptional())
        .named("has optional title")
        .isFalse();
    return this;
  }
}
