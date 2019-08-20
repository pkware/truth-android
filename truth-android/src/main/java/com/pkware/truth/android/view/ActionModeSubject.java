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
import android.view.ActionMode;
import android.view.View;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.os.Build.VERSION_CODES.JELLY_BEAN;

/**
 * Propositions for {@link ActionMode} subjects.
 */
public class ActionModeSubject extends Subject {

  @Nullable
  private final ActionMode actual;

  public ActionModeSubject(@Nonnull FailureMetadata failureMetadata, @Nullable ActionMode actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public ActionModeSubject hasCustomView() {
    check("getCustomView()").that(actual.getCustomView()).isNotNull();
    return this;
  }

  public ActionModeSubject hasCustomView(@Nullable View view) {
    check("getCustomView()").that(actual.getCustomView()).isEqualTo(view);
    return this;
  }

  public ActionModeSubject hasSubtitle(@Nullable CharSequence subtitle) {
    check("getSubtitle()").that(actual.getSubtitle()).isEqualTo(subtitle);
    return this;
  }

  public ActionModeSubject hasTag(@Nullable Object tag) {
    check("getTag()").that(actual.getTag()).isEqualTo(tag);
    return this;
  }

  public ActionModeSubject hasTitle(@Nullable CharSequence title) {
    check("getTitle()").that(actual.getTitle()).isEqualTo(title);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public ActionModeSubject hasOptionalTitleHint() {
    check("getTitleOptionalHint()").that(actual.getTitleOptionalHint()).isTrue();
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public ActionModeSubject hasNonOptionalTitleHint() {
    check("getTitleOptionalHint()").that(actual.getTitleOptionalHint()).isFalse();
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public ActionModeSubject hasOptionalTitle() {
    check("isTitleOptional()").that(actual.isTitleOptional()).isTrue();
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public ActionModeSubject hasNonOptionalTitle() {
    check("isTitleOptional()").that(actual.isTitleOptional()).isFalse();
    return this;
  }
}
