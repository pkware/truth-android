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

import android.app.Activity;
import android.app.Instrumentation;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link Instrumentation.ActivityMonitor} subjects.
 */
public class InstrumentationActivityMonitorSubject extends Subject {

  @Nullable
  private final Instrumentation.ActivityMonitor actual;

  public InstrumentationActivityMonitorSubject(@Nonnull FailureMetadata failureMetadata, @Nullable Instrumentation.ActivityMonitor actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public InstrumentationActivityMonitorSubject hasHits(int hits) {
    check("getHits()").that(actual.getHits()).isEqualTo(hits);
    return this;
  }

  public InstrumentationActivityMonitorSubject hasLastActivity(@Nullable Activity activity) {
    check("getLastActivity()").that(actual.getLastActivity()).isSameInstanceAs(activity);
    return this;
  }
}
