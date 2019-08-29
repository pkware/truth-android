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

import com.google.common.truth.FailureMetadata;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.os.Build.VERSION_CODES.JELLY_BEAN;

/**
 * Propositions for {@link AccessibilityEvent} subjects.
 */
public class AccessibilityEventSubject
    extends AbstractAccessibilityRecordSubject<AccessibilityEvent> {

  @Nullable
  private AccessibilityEvent actual;

  public AccessibilityEventSubject(@Nonnull FailureMetadata failureMetadata, @Nullable AccessibilityEvent actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  @TargetApi(JELLY_BEAN)
  public void hasAction(int action) {
    check("getAction()").that(actual.getAction()).isEqualTo(action);
  }

  public void hasEventTime(long time) {
    check("getEventTime()").that(actual.getEventTime()).isEqualTo(time);
  }

  public void hasEventType(int type) {
    check("getEventType()").that(actual.getEventType()).isEqualTo(type);
  }

  @TargetApi(JELLY_BEAN)
  public void hasMovementGranularity(int granularity) {
    check("getMovementGranularity()").that(actual.getMovementGranularity()).isEqualTo(granularity);
  }

  public void hasPackageName(@Nullable CharSequence name) {
    check("getPackageName()").that(actual.getPackageName()).isEqualTo(name);
  }
}
