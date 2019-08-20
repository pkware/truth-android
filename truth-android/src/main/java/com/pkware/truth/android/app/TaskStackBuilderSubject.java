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

import static android.os.Build.VERSION_CODES.JELLY_BEAN;
import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link TaskStackBuilder} subjects.
 */
@TargetApi(JELLY_BEAN)
public class TaskStackBuilderSubject extends Subject<TaskStackBuilderSubject, TaskStackBuilder> {
  public TaskStackBuilderSubject(FailureMetadata failureMetadata, TaskStackBuilder subject) {
    super(failureMetadata, subject);
  }

  public TaskStackBuilderSubject hasIntentCount(int count) {
    assertThat(actual().getIntentCount())
        .named("intent count")
        .isEqualTo(count);
    return this;
  }

  public TaskStackBuilderSubject containsIntents(Intent... intents) {
    assertThat(actual().getIntents())
        .asList()
        .contains(intents);
    return this;
  }
}
