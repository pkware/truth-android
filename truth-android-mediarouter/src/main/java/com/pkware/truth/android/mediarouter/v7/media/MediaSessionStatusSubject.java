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

import androidx.mediarouter.media.MediaSessionStatus;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static androidx.mediarouter.media.MediaSessionStatus.SESSION_STATE_ACTIVE;
import static androidx.mediarouter.media.MediaSessionStatus.SESSION_STATE_ENDED;
import static androidx.mediarouter.media.MediaSessionStatus.SESSION_STATE_INVALIDATED;
import static com.pkware.truth.android.internal.IntegerUtils.buildNamedValueString;

/**
 * Propositions for {@link MediaSessionStatus} subjects.
 */
public class MediaSessionStatusSubject extends Subject {

  @Nullable
  private final MediaSessionStatus actual;

  public MediaSessionStatusSubject(@Nonnull FailureMetadata failureMetadata, @Nullable MediaSessionStatus actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  @Nonnull
  public static String sessionStateToString(@MediaSessionStatusState int state) {
    return buildNamedValueString(state)
        .value(SESSION_STATE_ACTIVE, "active")
        .value(SESSION_STATE_ENDED, "ended")
        .value(SESSION_STATE_INVALIDATED, "invalidated")
        .get();
  }

  public MediaSessionStatusSubject hasSessionState(@MediaSessionStatusState int state) {
    int actualState = actual.getSessionState();
    //noinspection ResourceType
    check("getSessionState()")
        .withMessage("Expected session state <%s> but was <%s>.",
            sessionStateToString(state), sessionStateToString(actualState))
        .that(actualState)
        .isEqualTo(state);
    return this;
  }

  public MediaSessionStatusSubject hasTimestamp(long timestamp) {
    check("getTimestamp()").that(actual.getTimestamp()).isEqualTo(timestamp);
    return this;
  }

  public MediaSessionStatusSubject hasQueuePaused() {
    check("isQueuePaused()").that(actual.isQueuePaused()).isTrue();
    return this;
  }

  public MediaSessionStatusSubject doesNotHaveQueuePaused() {
    check("isQueuePaused()").that(actual.isQueuePaused()).isFalse();
    return this;
  }
}
