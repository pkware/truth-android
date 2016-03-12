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

import android.app.LocalActivityManager;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import java.util.Locale;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link LocalActivityManager} subjects.
 */
public class LocalActivityManagerSubject extends Subject<LocalActivityManagerSubject, LocalActivityManager> {
  protected LocalActivityManagerSubject(FailureStrategy failureStrategy, LocalActivityManager subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<LocalActivityManagerSubject, LocalActivityManager> type() {
    return new SubjectFactory<LocalActivityManagerSubject, LocalActivityManager>() {
      @Override
      public LocalActivityManagerSubject getSubject(FailureStrategy fs, LocalActivityManager that) {
        return new LocalActivityManagerSubject(fs, that);
      }
    };
  }

  public LocalActivityManagerSubject hasActivity(String id) {
    assertThat(getSubject().getActivity(id))
        .named(String.format(Locale.ENGLISH, "has activity with id <%s>", id))
        .isNotNull();
    return this;
  }
}
