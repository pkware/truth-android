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
package com.pkware.truth.android.widget;

import android.annotation.TargetApi;
import android.widget.VideoView;

import com.google.common.truth.FailureMetadata;
import com.pkware.truth.android.view.AbstractViewSubject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR2;

/**
 * Propositions for {@link VideoView} subjects.
 */
public class VideoViewSubject extends AbstractViewSubject<VideoView> {

  @Nullable
  private final VideoView actual;

  public VideoViewSubject(@Nonnull FailureMetadata failureMetadata, @Nullable VideoView actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void isPausable() {
    check("canPause()").that(actual.canPause()).isTrue();
  }

  public void isNotPausable() {
    check("canPause()").that(actual.canPause()).isFalse();
  }

  public void isSeekableBackward() {
    check("canSeekBackward()").that(actual.canSeekBackward()).isTrue();
  }

  public void isNotSeekableBackward() {
    check("canSeekBackward()").that(actual.canSeekBackward()).isFalse();
  }

  public void isSeekableForward() {
    check("canSeekForward()").that(actual.canSeekForward()).isTrue();
  }

  public void isNotSeekableForward() {
    check("canSeekForward()").that(actual.canSeekForward()).isFalse();
  }

  @TargetApi(JELLY_BEAN_MR2)
  public void hasAudioSessionId(int id) {
    check("getAudioSessionId()").that(actual.getAudioSessionId()).isEqualTo(id);
  }

  public void hasBufferPercentage(int percentage) {
    check("getBufferPercentage()").that(actual.getBufferPercentage()).isEqualTo(percentage);
  }

  public void hasCurrentPosition(int position) {
    check("getCurrentPosition()").that(actual.getCurrentPosition()).isEqualTo(position);
  }

  public void hasDuration(int duration) {
    check("getDuration()").that(actual.getDuration()).isEqualTo(duration);
  }

  public void isPlaying() {
    check("isPlaying()").that(actual.isPlaying()).isTrue();
  }

  public void isNotPlaying() {
    check("isPlaying()").that(actual.isPlaying()).isFalse();
  }
}
