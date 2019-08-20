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
package com.pkware.truth.android.content.res;

import android.annotation.TargetApi;
import android.content.res.Configuration;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;
import com.pkware.truth.android.view.ViewLayoutDirection;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.content.res.Configuration.UI_MODE_TYPE_APPLIANCE;
import static android.content.res.Configuration.UI_MODE_TYPE_CAR;
import static android.content.res.Configuration.UI_MODE_TYPE_DESK;
import static android.content.res.Configuration.UI_MODE_TYPE_NORMAL;
import static android.content.res.Configuration.UI_MODE_TYPE_TELEVISION;
import static android.content.res.Configuration.UI_MODE_TYPE_UNDEFINED;
import static android.content.res.Configuration.UI_MODE_TYPE_WATCH;
import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR1;
import static android.os.Build.VERSION_CODES.KITKAT;
import static com.pkware.truth.android.internal.IntegerUtils.buildNamedValueString;
import static com.pkware.truth.android.view.AbstractViewSubject.layoutDirectionToString;

/**
 * Propositions for {@link Configuration} subjects.
 */
public class ConfigurationSubject extends Subject {

  @Nullable
  private final Configuration actual;

  public ConfigurationSubject(@Nonnull FailureMetadata failureMetadata, @Nullable Configuration actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  @Nonnull
  public static String uiModeTypeToString(@ConfigurationUiModeType int mode) {
    return buildNamedValueString(mode)
        .value(UI_MODE_TYPE_NORMAL, "normal")
        .value(UI_MODE_TYPE_APPLIANCE, "appliance")
        .value(UI_MODE_TYPE_CAR, "car")
        .value(UI_MODE_TYPE_DESK, "desk")
        .value(UI_MODE_TYPE_TELEVISION, "television")
        .value(UI_MODE_TYPE_UNDEFINED, "undefined")
        .value(UI_MODE_TYPE_WATCH, "watch")
        .get();
  }

  @TargetApi(JELLY_BEAN_MR1)
  public ConfigurationSubject hasLayoutDirection(@ViewLayoutDirection int layoutDirection) {
    int actualLayoutDirection = actual.getLayoutDirection();
    //noinspection ResourceType
    check("getLayoutDirection()")
        .withMessage("Expected layout direction to be <%s> but was <%s>.", layoutDirectionToString(layoutDirection), layoutDirectionToString(actualLayoutDirection))
        .that(actualLayoutDirection)
        .isEqualTo(layoutDirection);
    return this;
  }

  @TargetApi(KITKAT)
  public ConfigurationSubject hasMnc(int mnc) {
    check("mnc").that(actual.mnc).isEqualTo(mnc);
    return this;
  }
}
