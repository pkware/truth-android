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

import android.annotation.TargetApi;
import android.app.TaskStackBuilder;
import android.content.Intent;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.os.Build.VERSION_CODES.JELLY_BEAN;

/**
 * Propositions for {@link TaskStackBuilder} subjects.
 */
@TargetApi(JELLY_BEAN)
public class TaskStackBuilderSubject extends Subject {

  @Nullable
  private final TaskStackBuilder actual;

  public TaskStackBuilderSubject(@Nonnull FailureMetadata failureMetadata, @Nullable TaskStackBuilder actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasIntentCount(int count) {
    check("getIntentCount()").that(actual.getIntentCount()).isEqualTo(count);
  }

  public void containsIntents(@Nonnull Intent... intents) {
    check("getIntents()")
        .that(actual.getIntents())
        .asList()
        .containsExactlyElementsIn(intents)
        .inOrder();
  }
}
