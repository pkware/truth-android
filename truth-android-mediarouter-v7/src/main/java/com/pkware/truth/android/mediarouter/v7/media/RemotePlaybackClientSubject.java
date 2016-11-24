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

import android.support.v7.media.RemotePlaybackClient;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link RemotePlaybackClient} subjects.
 */
public class RemotePlaybackClientSubject
    extends Subject<RemotePlaybackClientSubject, RemotePlaybackClient> {
  protected RemotePlaybackClientSubject(FailureStrategy failureStrategy, RemotePlaybackClient subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<RemotePlaybackClientSubject, RemotePlaybackClient> type() {
    return new SubjectFactory<RemotePlaybackClientSubject, RemotePlaybackClient>() {
      @Override
      public RemotePlaybackClientSubject getSubject(FailureStrategy fs, RemotePlaybackClient that) {
        return new RemotePlaybackClientSubject(fs, that);
      }
    };
  }

  public RemotePlaybackClientSubject hasSessionId(String sessionId) {
    assertThat(actual().getSessionId())
        .named("session ID")
        .isEqualTo(sessionId);
    return this;
  }

  public RemotePlaybackClientSubject hasSession() {
    assertThat(actual().hasSession())
        .named("has session")
        .isTrue();
    return this;
  }

  public RemotePlaybackClientSubject doesNotHaveSession() {
    assertThat(actual().hasSession())
        .named("has session")
        .isFalse();
    return this;
  }

  public RemotePlaybackClientSubject hasQueuingSupported() {
    assertThat(actual().isQueuingSupported())
        .named("supports queueing")
        .isTrue();
    return this;
  }

  public RemotePlaybackClientSubject doesNotHaveQueuingSupported() {
    assertThat(actual().isQueuingSupported())
        .named("supports queueing")
        .isFalse();
    return this;
  }

  public RemotePlaybackClientSubject hasRemotePlaybackSupported() {
    assertThat(actual().isRemotePlaybackSupported())
        .named("supports remote playback")
        .isTrue();
    return this;
  }

  public RemotePlaybackClientSubject doesNotHaveRemotePlaybackSupported() {
    assertThat(actual().isRemotePlaybackSupported())
        .named("supports remote playback")
        .isFalse();
    return this;
  }

  public RemotePlaybackClientSubject hasSessionManagementSupported() {
    assertThat(actual().isSessionManagementSupported())
        .named("supports session management")
        .isTrue();
    return this;
  }

  public RemotePlaybackClientSubject doesNotHaveSessionManagementSupported() {
    assertThat(actual().isSessionManagementSupported())
        .named("supports session management")
        .isFalse();
    return this;
  }
}
