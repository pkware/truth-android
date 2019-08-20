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
package com.pkware.truth.android.app;

import android.app.UiModeManager;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;
import com.pkware.truth.android.content.res.ConfigurationUiModeType;

import static android.app.UiModeManager.MODE_NIGHT_NO;
import static com.google.common.truth.Truth.assert_;
import static com.pkware.truth.android.content.res.ConfigurationSubject.uiModeTypeToString;

/**
 * Propositions for {@link UiModeManager} subjects.
 */
public class UiModeManagerSubject extends Subject<UiModeManagerSubject, UiModeManager> {
  public UiModeManagerSubject(FailureMetadata failureMetadata, UiModeManager subject) {
    super(failureMetadata, subject);
  }

  public UiModeManagerSubject isNightMode() {
    assert_()
        .withMessage("Expected to be in night mode but was not in night mode.")
        .that(actual().getNightMode())
        .isNotEqualTo(MODE_NIGHT_NO);
    return this;
  }

  public UiModeManagerSubject isNotNightMode() {
    assert_()
        .withMessage("Expected not to be in night mode but was in night mode.")
        .that(actual().getNightMode())
        .isEqualTo(MODE_NIGHT_NO);
    return this;
  }

  public UiModeManagerSubject isInUiModeType(@ConfigurationUiModeType int mode) {
    int actualMode = actual().getCurrentModeType();
    //noinspection ResourceType
    assert_()
        .withMessage("Expected mode <%s> but was <%s>.", uiModeTypeToString(mode), uiModeTypeToString(actualMode))
        .that(actualMode)
        .isEqualTo(mode);
    return this;
  }

  public UiModeManagerSubject isNotInUiModeType(@ConfigurationUiModeType int mode) {
    int actualMode = actual().getCurrentModeType();
    //noinspection ResourceType
    assert_()
        .withMessage("Expected not mode <%s> but was <%s>.", uiModeTypeToString(mode), uiModeTypeToString(actualMode))
        .that(actualMode)
        .isNotEqualTo(mode);
    return this;
  }
}
