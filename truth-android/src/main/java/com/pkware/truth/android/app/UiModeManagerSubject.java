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
package com.pkware.truth.android.app;

import android.app.UiModeManager;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;
import com.pkware.truth.android.content.res.ConfigurationUiModeType;

import static android.app.UiModeManager.MODE_NIGHT_NO;
import static com.google.common.truth.Truth.assert_;
import static com.pkware.truth.android.content.res.ConfigurationSubject.uiModeTypeToString;

/**
 * Propositions for {@link UiModeManager} subjects.
 */
public class UiModeManagerSubject extends Subject<UiModeManagerSubject, UiModeManager> {
  protected UiModeManagerSubject(FailureStrategy failureStrategy, UiModeManager subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<UiModeManagerSubject, UiModeManager> type() {
    return new SubjectFactory<UiModeManagerSubject, UiModeManager>() {
      @Override
      public UiModeManagerSubject getSubject(FailureStrategy fs, UiModeManager that) {
        return new UiModeManagerSubject(fs, that);
      }
    };
  }

  public UiModeManagerSubject isNightMode() {
    assert_()
        .withFailureMessage("Expected to be in night mode but was not in night mode.")
        .that(getSubject().getNightMode())
        .isNotEqualTo(MODE_NIGHT_NO);
    return this;
  }

  public UiModeManagerSubject isNotNightMode() {
    assert_()
        .withFailureMessage("Expected not to be in night mode but was in night mode.")
        .that(getSubject().getNightMode())
        .isEqualTo(MODE_NIGHT_NO);
    return this;
  }

  public UiModeManagerSubject isInUiModeType(@ConfigurationUiModeType int mode) {
    int actualMode = getSubject().getCurrentModeType();
    //noinspection ResourceType
    assert_()
        .withFailureMessage("Expected mode <%s> but was <%s>.", uiModeTypeToString(mode), uiModeTypeToString(actualMode))
        .that(actualMode)
        .isEqualTo(mode);
    return this;
  }

  public UiModeManagerSubject isNotInUiModeType(@ConfigurationUiModeType int mode) {
    int actualMode = getSubject().getCurrentModeType();
    //noinspection ResourceType
    assert_()
        .withFailureMessage("Expected not mode <%s> but was <%s>.", uiModeTypeToString(mode), uiModeTypeToString(actualMode))
        .that(actualMode)
        .isNotEqualTo(mode);
    return this;
  }
}
