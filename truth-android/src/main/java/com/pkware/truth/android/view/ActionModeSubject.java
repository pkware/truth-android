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

  public void hasCustomView() {
    check("getCustomView()").that(actual.getCustomView()).isNotNull();
  }

  public void hasCustomView(@Nullable View view) {
    check("getCustomView()").that(actual.getCustomView()).isEqualTo(view);
  }

  public void hasSubtitle(@Nullable CharSequence subtitle) {
    check("getSubtitle()").that(actual.getSubtitle()).isEqualTo(subtitle);
  }

  public void hasTag(@Nullable Object tag) {
    check("getTag()").that(actual.getTag()).isEqualTo(tag);
  }

  public void hasTitle(@Nullable CharSequence title) {
    check("getTitle()").that(actual.getTitle()).isEqualTo(title);
  }

  @TargetApi(JELLY_BEAN)
  public void hasOptionalTitleHint() {
    check("getTitleOptionalHint()").that(actual.getTitleOptionalHint()).isTrue();
  }

  @TargetApi(JELLY_BEAN)
  public void hasNonOptionalTitleHint() {
    check("getTitleOptionalHint()").that(actual.getTitleOptionalHint()).isFalse();
  }

  @TargetApi(JELLY_BEAN)
  public void hasOptionalTitle() {
    check("isTitleOptional()").that(actual.isTitleOptional()).isTrue();
  }

  @TargetApi(JELLY_BEAN)
  public void hasNonOptionalTitle() {
    check("isTitleOptional()").that(actual.isTitleOptional()).isFalse();
  }
}
