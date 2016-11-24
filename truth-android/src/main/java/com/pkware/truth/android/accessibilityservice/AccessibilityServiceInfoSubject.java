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
package com.pkware.truth.android.accessibilityservice;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.annotation.TargetApi;
import android.content.pm.PackageManager;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static android.accessibilityservice.AccessibilityServiceInfo.CAPABILITY_CAN_REQUEST_ENHANCED_WEB_ACCESSIBILITY;
import static android.accessibilityservice.AccessibilityServiceInfo.CAPABILITY_CAN_REQUEST_FILTER_KEY_EVENTS;
import static android.accessibilityservice.AccessibilityServiceInfo.CAPABILITY_CAN_REQUEST_TOUCH_EXPLORATION;
import static android.accessibilityservice.AccessibilityServiceInfo.CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT;
import static android.os.Build.VERSION_CODES.JELLY_BEAN;
import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR2;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assert_;
import static com.pkware.truth.android.internal.IntegerUtils.buildBitMaskString;

/**
 * Propositions for {@link AccessibilityServiceInfo} subjects.
 */
public class AccessibilityServiceInfoSubject extends Subject<AccessibilityServiceInfoSubject, AccessibilityServiceInfo> {
  private AccessibilityServiceInfoSubject(FailureStrategy failureStrategy, AccessibilityServiceInfo subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<AccessibilityServiceInfoSubject, AccessibilityServiceInfo> type() {
    return new SubjectFactory<AccessibilityServiceInfoSubject, AccessibilityServiceInfo>() {
      @Override
      public AccessibilityServiceInfoSubject getSubject(FailureStrategy fs, AccessibilityServiceInfo that) {
        return new AccessibilityServiceInfoSubject(fs, that);
      }
    };
  }

  public static String capabilitiesToString(@AccessibilityServiceInfoCapabilities int capabilities) {
    return buildBitMaskString(capabilities)
        .flag(CAPABILITY_CAN_REQUEST_ENHANCED_WEB_ACCESSIBILITY, "request_enhanced_web_accessibility")
        .flag(CAPABILITY_CAN_REQUEST_FILTER_KEY_EVENTS, "request_filter_key_events")
        .flag(CAPABILITY_CAN_REQUEST_TOUCH_EXPLORATION, "request_touch_exploration")
        .flag(CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT, "retrieve_window_content")
        .get();
  }

  @TargetApi(JELLY_BEAN_MR2)
  public AccessibilityServiceInfoSubject hasCapabilities(@AccessibilityServiceInfoCapabilities int capabilities) {
    int actualCapabilities = actual().getCapabilities();
    //noinspection ResourceType
    assert_()
        .withFailureMessage("Expected capabilities <%s> but was <%s>.", capabilitiesToString(capabilities), capabilitiesToString(actualCapabilities))
        .that(actualCapabilities)
        .isEqualTo(capabilities);
    return this;
  }

  /**
   * @deprecated {@link AccessibilityServiceInfo#getDescription()} is deprecated
   */
  @Deprecated
  public AccessibilityServiceInfoSubject hasDescription(String description) {
    assertThat(actual().getDescription())
        .named("description")
        .isEqualTo(description);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public AccessibilityServiceInfoSubject hasDescription(String description, PackageManager packageManager) {
    assertThat(actual().loadDescription(packageManager))
        .named("description")
        .isEqualTo(description);
    return this;
  }

  public AccessibilityServiceInfoSubject hasId(String id) {
    assertThat(actual().getId())
        .named("id")
        .isEqualTo(id);
    return this;
  }

  public AccessibilityServiceInfoSubject hasSettingsActivityName(String name) {
    assertThat(actual().getSettingsActivityName())
        .named("settings activity name")
        .isEqualTo(name);
    return this;
  }
}
