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
import android.app.PendingIntent;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR1;
import static com.google.common.truth.Truth.assertThat;


/**
 * Propositions for {@link PendingIntent} subjects.
 */
public class PendingIntentSubject extends Subject<PendingIntentSubject, PendingIntent> {
  public PendingIntentSubject(FailureMetadata failureMetadata, PendingIntent subject) {
    super(failureMetadata, subject);
  }

  @TargetApi(JELLY_BEAN_MR1)
  public PendingIntentSubject hasCreatorPackage(String packageName) {
    assertThat(actual().getCreatorPackage())
        .named("creator package")
        .isEqualTo(packageName);
    return this;
  }

  @TargetApi(JELLY_BEAN_MR1)
  public PendingIntentSubject hasCreatorUid(int uid) {
    assertThat(actual().getCreatorUid())
        .named("creator UID")
        .isEqualTo(uid);
    return this;
  }

  public PendingIntentSubject hasTargetPackage(String targetPackage) {
    assertThat(actual().getTargetPackage())
        .named("target package")
        .isEqualTo(targetPackage);
    return this;
  }
}
