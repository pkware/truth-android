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

import static android.os.Build.VERSION_CODES.JELLY_BEAN;
import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link KeyguardManager} subjects.
 */
public class KeyguardManagerSubject extends Subject<KeyguardManagerSubject, KeyguardManager> {
  protected KeyguardManagerSubject(FailureMetadata failureMetadata, KeyguardManager subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<KeyguardManagerSubject, KeyguardManager> type() {
    return KeyguardManagerSubject::new;
  }

  public KeyguardManagerSubject hasRestrictedInputMode() {
    assertThat(actual().inKeyguardRestrictedInputMode())
        .named("has restricted input mode")
        .isTrue();
    return this;
  }

  public KeyguardManagerSubject hasUnrestrictedInputMode() {
    assertThat(actual().inKeyguardRestrictedInputMode())
        .named("has restricted input mode")
        .isFalse();
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public KeyguardManagerSubject hasLockedKeyguard() {
    assertThat(actual().isKeyguardLocked())
        .named("has locked keyguard")
        .isTrue();
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public KeyguardManagerSubject hasUnlockedKeyguard() {
    assertThat(actual().isKeyguardLocked())
        .named("has locked keyguard")
        .isFalse();
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public KeyguardManagerSubject hasSecureKeyguard() {
    assertThat(actual().isKeyguardSecure())
        .named("has secure keyguard")
        .isTrue();
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public KeyguardManagerSubject hasInsecureKeyguard() {
    assertThat(actual().isKeyguardSecure())
        .named("has secure keyguard")
        .isFalse();
    return this;
  }
}
