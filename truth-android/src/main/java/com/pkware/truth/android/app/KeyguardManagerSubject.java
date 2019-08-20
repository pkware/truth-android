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
import android.app.KeyguardManager;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.os.Build.VERSION_CODES.JELLY_BEAN;

/**
 * Propositions for {@link KeyguardManager} subjects.
 */
public class KeyguardManagerSubject extends Subject {

  @Nullable
  private final KeyguardManager actual;

  public KeyguardManagerSubject(@Nonnull FailureMetadata failureMetadata, @Nullable KeyguardManager actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public KeyguardManagerSubject hasRestrictedInputMode() {
    check("inKeyguardRestrictedInputMode()").that(actual.inKeyguardRestrictedInputMode()).isTrue();
    return this;
  }

  public KeyguardManagerSubject hasUnrestrictedInputMode() {
    check("inKeyguardRestrictedInputMode()").that(actual.inKeyguardRestrictedInputMode()).isFalse();
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public KeyguardManagerSubject hasLockedKeyguard() {
    check("isKeyguardLocked()").that(actual.isKeyguardLocked()).isTrue();
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public KeyguardManagerSubject hasUnlockedKeyguard() {
    check("isKeyguardLocked()").that(actual.isKeyguardLocked()).isFalse();
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public KeyguardManagerSubject hasSecureKeyguard() {
    check("isKeyguardSecure()").that(actual.isKeyguardSecure()).isTrue();
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public KeyguardManagerSubject hasInsecureKeyguard() {
    check("isKeyguardSecure()").that(actual.isKeyguardSecure()).isFalse();
    return this;
  }
}
