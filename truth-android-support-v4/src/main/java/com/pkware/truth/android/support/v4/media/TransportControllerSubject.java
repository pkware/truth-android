/*
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

import android.support.v4.media.TransportController;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assert_;
import static com.pkware.truth.android.support.v4.media.TransportMediatorSubject.controlFlagsToString;

/**
 * Propositions for {@link TransportController} subjects.
 */
public class TransportControllerSubject
    extends Subject<TransportControllerSubject, TransportController> {
  protected TransportControllerSubject(FailureStrategy failureStrategy, TransportController subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<TransportControllerSubject, TransportController> type() {
    return new SubjectFactory<TransportControllerSubject, TransportController>() {
      @Override
      public TransportControllerSubject getSubject(FailureStrategy fs, TransportController that) {
        return new TransportControllerSubject(fs, that);
      }
    };
  }

  public TransportControllerSubject hasBufferPercentage(int percentage) {
    assertThat(actual().getBufferPercentage())
        .named("buffer percentage")
        .isEqualTo(percentage);
    return this;
  }

  public TransportControllerSubject hasCurrentPosition(long position) {
    assertThat(actual().getCurrentPosition())
        .named("current position")
        .isEqualTo(position);
    return this;
  }

  public TransportControllerSubject hasDuration(long duration) {
    assertThat(actual().getDuration())
        .named("duration")
        .isEqualTo(duration);
    return this;
  }

  public TransportControllerSubject hasTransportControlFlags(@TransportMediatorControlFlags int flags) {
    int actualFlags = actual().getTransportControlFlags();
    //noinspection WrongConstant
    assert_()
        .withFailureMessage("Expected control flags <%s> but was <%s>.",
            controlFlagsToString(flags), controlFlagsToString(actualFlags))
        .that(actualFlags)
        .isEqualTo(flags);
    return this;
  }

  public TransportControllerSubject isPlaying() {
    assertThat(actual().isPlaying())
        .named("is playing")
        .isTrue();
    return this;
  }

  public TransportControllerSubject isNotPlaying() {
    assertThat(actual().isPlaying())
        .named("is playing")
        .isFalse();
    return this;
  }
}
