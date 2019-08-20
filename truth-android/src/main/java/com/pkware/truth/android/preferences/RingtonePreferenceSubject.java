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
package com.pkware.truth.android.preferences;

import android.preference.RingtonePreference;

import com.google.common.truth.FailureMetadata;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.media.RingtoneManager.TYPE_ALARM;
import static android.media.RingtoneManager.TYPE_NOTIFICATION;
import static android.media.RingtoneManager.TYPE_RINGTONE;
import static com.pkware.truth.android.internal.IntegerUtils.buildBitMaskString;

/**
 * Propositions for {@link RingtonePreference} subjects.
 */
public class RingtonePreferenceSubject extends AbstractPreferenceSubject<RingtonePreference> {

  @Nullable
  private RingtonePreference actual;

  public RingtonePreferenceSubject(@Nonnull FailureMetadata failureMetadata, @Nullable RingtonePreference actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  @Nonnull
  private static String ringtoneTypeToString(@RingtoneType int type) {
    return buildBitMaskString(type)
        .flag(TYPE_ALARM, "alarm")
        .flag(TYPE_NOTIFICATION, "notification")
        .flag(TYPE_RINGTONE, "ringtone")
        .get();
  }

  public RingtonePreferenceSubject hasRingtoneType(@RingtoneType int type) {
    int actualType = actual.getRingtoneType();
    //noinspection ResourceType
    check("getRingtoneType()")
        .withMessage("Expected ringtone type <%s> but was <%s>.",
            ringtoneTypeToString(type), ringtoneTypeToString(actualType))
        .that(actualType)
        .isEqualTo(type);
    return this;
  }

  public RingtonePreferenceSubject isShowingDefault() {
    check("getShowDefault()").that(actual.getShowDefault()).isTrue();
    return this;
  }

  public RingtonePreferenceSubject isNotShowingDefault() {
    check("getShowDefault()").that(actual.getShowDefault()).isFalse();
    return this;
  }

  public RingtonePreferenceSubject isShowingSilent() {
    check("getShowSilent()").that(actual.getShowSilent()).isTrue();
    return this;
  }

  public RingtonePreferenceSubject isNotShowingSilent() {
    check("getShowSilent()").that(actual.getShowSilent()).isFalse();
    return this;
  }
}
