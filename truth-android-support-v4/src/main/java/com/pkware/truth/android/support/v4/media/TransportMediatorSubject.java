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
package com.pkware.truth.android.support.v4.media;

import android.support.v4.media.TransportMediator;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assert_;
import static com.pkware.truth.android.internal.IntegerUtils.buildBitMaskString;

/**
 * Propositions for {@link TransportMediator} subjects.
 */
public class TransportMediatorSubject extends Subject<TransportMediatorSubject, TransportMediator> {
  protected TransportMediatorSubject(FailureStrategy failureStrategy, TransportMediator subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<TransportMediatorSubject, TransportMediator> type() {
    return new SubjectFactory<TransportMediatorSubject, TransportMediator>() {
      @Override
      public TransportMediatorSubject getSubject(FailureStrategy fs, TransportMediator that) {
        return new TransportMediatorSubject(fs, that);
      }
    };
  }

  public static String controlFlagsToString(@TransportMediatorControlFlags int flags) {
    return buildBitMaskString(flags)
        .flag(TransportMediator.FLAG_KEY_MEDIA_FAST_FORWARD, "fast_forward")
        .flag(TransportMediator.FLAG_KEY_MEDIA_NEXT, "next")
        .flag(TransportMediator.FLAG_KEY_MEDIA_PAUSE, "pause")
        .flag(TransportMediator.FLAG_KEY_MEDIA_PLAY, "play")
        .flag(TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE, "play_pause")
        .flag(TransportMediator.FLAG_KEY_MEDIA_PREVIOUS, "previous")
        .flag(TransportMediator.FLAG_KEY_MEDIA_REWIND, "rewind")
        .flag(TransportMediator.FLAG_KEY_MEDIA_STOP, "stop")
        .get();
  }

  public TransportMediatorSubject hasBufferPercentage(int percentage) {
    assertThat(actual().getBufferPercentage())
        .named("buffer percentage")
        .isEqualTo(percentage);
    return this;
  }

  public TransportMediatorSubject hasCurrentPosition(long position) {
    assertThat(actual().getCurrentPosition())
        .named("current position")
        .isEqualTo(position);
    return this;
  }

  public TransportMediatorSubject hasDuration(long duration) {
    assertThat(actual().getDuration())
        .named("duration")
        .isEqualTo(duration);
    return this;
  }

  public TransportMediatorSubject hasTransportControlFlags(@TransportMediatorControlFlags int flags) {
    int actualFlags = actual().getTransportControlFlags();
    //noinspection ResourceType
    assert_()
        .withFailureMessage("Expected control flags <%s> but was <%s>.",
            controlFlagsToString(flags), controlFlagsToString(actualFlags))
        .that(actualFlags)
        .isEqualTo(flags);
    return this;
  }

  public TransportMediatorSubject isPlaying() {
    assertThat(actual().isPlaying())
        .named("is playing")
        .isTrue();
    return this;
  }

  public TransportMediatorSubject isNotPlaying() {
    assertThat(actual().isPlaying())
        .named("is playing")
        .isFalse();
    return this;
  }
}
