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
package com.pkware.truth.android.view.accessbility;

import android.annotation.TargetApi;
import android.view.accessibility.AccessibilityEvent;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.JELLY_BEAN;
import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link AccessibilityEvent} subjects.
 */
public class AccessibilityEventSubject
    extends AbstractAccessibilityRecordSubject<AccessibilityEventSubject, AccessibilityEvent> {
  protected AccessibilityEventSubject(FailureStrategy failureStrategy, AccessibilityEvent subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<AccessibilityEventSubject, AccessibilityEvent> type() {
    return new SubjectFactory<AccessibilityEventSubject, AccessibilityEvent>() {
      @Override
      public AccessibilityEventSubject getSubject(FailureStrategy fs, AccessibilityEvent that) {
        return new AccessibilityEventSubject(fs, that);
      }
    };
  }

  @TargetApi(JELLY_BEAN)
  public AccessibilityEventSubject hasAction(int action) {
    assertThat(actual().getAction())
        .named("action")
        .isEqualTo(action);
    return this;
  }

  public AccessibilityEventSubject hasEventTime(long time) {
    assertThat(actual().getEventTime())
        .named("event time")
        .isEqualTo(time);
    return this;
  }

  public AccessibilityEventSubject hasEventType(int type) {
    assertThat(actual().getEventType())
        .named("event type")
        .isEqualTo(type);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public AccessibilityEventSubject hasMovementGranularity(int granularity) {
    assertThat(actual().getMovementGranularity())
        .named("movement granularity")
        .isEqualTo(granularity);
    return this;
  }

  public AccessibilityEventSubject hasPackageName(CharSequence name) {
    assertThat(actual().getPackageName())
        .named("package name")
        .isEqualTo(name);
    return this;
  }
}
