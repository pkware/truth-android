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
package com.pkware.truth.android.mediarouter.v7.media;

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

  public RemotePlaybackClientSubject hasSessionId(@Nullable String sessionId) {
    check("getSessionId()").that(actual.getSessionId()).isEqualTo(sessionId);
    return this;
  }

  public RemotePlaybackClientSubject hasSession() {
    check("hasSession()").that(actual.hasSession()).isTrue();
    return this;
  }

  public RemotePlaybackClientSubject doesNotHaveSession() {
    check("hasSession()").that(actual.hasSession()).isFalse();
    return this;
  }

  public RemotePlaybackClientSubject hasQueuingSupported() {
    check("isQueuingSupported()").that(actual.isQueuingSupported()).isTrue();
    return this;
  }

  public RemotePlaybackClientSubject doesNotHaveQueuingSupported() {
    check("isQueuingSupported()").that(actual.isQueuingSupported()).isFalse();
    return this;
  }

  public RemotePlaybackClientSubject hasRemotePlaybackSupported() {
    check("isRemotePlaybackSupported()").that(actual.isRemotePlaybackSupported()).isTrue();
    return this;
  }

  public RemotePlaybackClientSubject doesNotHaveRemotePlaybackSupported() {
    check("isRemotePlaybackSupported()").that(actual.isRemotePlaybackSupported()).isFalse();
    return this;
  }

  public RemotePlaybackClientSubject hasSessionManagementSupported() {
    check("isSessionManagementSupported()").that(actual.isSessionManagementSupported()).isTrue();
    return this;
  }

  public RemotePlaybackClientSubject doesNotHaveSessionManagementSupported() {
    check("isSessionManagementSupported()").that(actual.isSessionManagementSupported()).isFalse();
    return this;
  }
}
