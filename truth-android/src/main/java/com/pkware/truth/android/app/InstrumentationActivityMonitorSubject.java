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

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link Instrumentation.ActivityMonitor} subjects.
 */
public class InstrumentationActivityMonitorSubject extends Subject<InstrumentationActivityMonitorSubject, Instrumentation.ActivityMonitor> {
  protected InstrumentationActivityMonitorSubject(FailureStrategy failureStrategy, Instrumentation.ActivityMonitor subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<InstrumentationActivityMonitorSubject, Instrumentation.ActivityMonitor> type() {
    return new SubjectFactory<InstrumentationActivityMonitorSubject, Instrumentation.ActivityMonitor>() {
      @Override
      public InstrumentationActivityMonitorSubject getSubject(FailureStrategy fs, Instrumentation.ActivityMonitor that) {
        return new InstrumentationActivityMonitorSubject(fs, that);
      }
    };
  }

  public InstrumentationActivityMonitorSubject hasHits(int hits) {
    assertThat(actual().getHits())
        .named("hits")
        .isEqualTo(hits);
    return this;
  }

  public InstrumentationActivityMonitorSubject hasLastActivity(Activity activity) {
    assertThat(actual().getLastActivity())
        .named("last activity")
        .isSameAs(activity);
    return this;
  }
}
