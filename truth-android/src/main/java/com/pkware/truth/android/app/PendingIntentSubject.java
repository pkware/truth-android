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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR1;


/**
 * Propositions for {@link PendingIntent} subjects.
 */
public class PendingIntentSubject extends Subject {

  @Nullable
  private final PendingIntent actual;

  public PendingIntentSubject(@Nonnull FailureMetadata failureMetadata, @Nullable PendingIntent actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  @TargetApi(JELLY_BEAN_MR1)
  public void hasCreatorPackage(@Nullable String packageName) {
    check("getCreatorPackage()").that(actual.getCreatorPackage()).isEqualTo(packageName);
  }

  @TargetApi(JELLY_BEAN_MR1)
  public void hasCreatorUid(int uid) {
    check("getCreatorUid()").that(actual.getCreatorUid()).isEqualTo(uid);
  }

  public void hasTargetPackage(@Nullable String targetPackage) {
    check("getTargetPackage()").that(actual.getTargetPackage()).isEqualTo(targetPackage);
  }
}
