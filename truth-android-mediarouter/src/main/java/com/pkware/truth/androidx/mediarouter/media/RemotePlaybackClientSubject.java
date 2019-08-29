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
package com.pkware.truth.androidx.mediarouter.media;

import androidx.mediarouter.media.RemotePlaybackClient;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link RemotePlaybackClient} subjects.
 */
public class RemotePlaybackClientSubject extends Subject {

  @Nullable
  private final RemotePlaybackClient actual;

  public RemotePlaybackClientSubject(@Nonnull FailureMetadata failureMetadata, @Nullable RemotePlaybackClient actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasSessionId(@Nullable String sessionId) {
    check("getSessionId()").that(actual.getSessionId()).isEqualTo(sessionId);
  }

  public void hasSession() {
    check("hasSession()").that(actual.hasSession()).isTrue();
  }

  public void doesNotHaveSession() {
    check("hasSession()").that(actual.hasSession()).isFalse();
  }

  public void hasQueuingSupported() {
    check("isQueuingSupported()").that(actual.isQueuingSupported()).isTrue();
  }

  public void doesNotHaveQueuingSupported() {
    check("isQueuingSupported()").that(actual.isQueuingSupported()).isFalse();
  }

  public void hasRemotePlaybackSupported() {
    check("isRemotePlaybackSupported()").that(actual.isRemotePlaybackSupported()).isTrue();
  }

  public void doesNotHaveRemotePlaybackSupported() {
    check("isRemotePlaybackSupported()").that(actual.isRemotePlaybackSupported()).isFalse();
  }

  public void hasSessionManagementSupported() {
    check("isSessionManagementSupported()").that(actual.isSessionManagementSupported()).isTrue();
  }

  public void doesNotHaveSessionManagementSupported() {
    check("isSessionManagementSupported()").that(actual.isSessionManagementSupported()).isFalse();
  }
}
