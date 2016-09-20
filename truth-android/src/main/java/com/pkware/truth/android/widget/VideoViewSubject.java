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
package com.pkware.truth.android.widget;

import android.annotation.TargetApi;
import android.widget.VideoView;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;
import com.pkware.truth.android.view.AbstractViewSubject;

import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR2;
import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link VideoView} subjects.
 */
public class VideoViewSubject extends AbstractViewSubject<VideoViewSubject, VideoView> {
  protected VideoViewSubject(FailureStrategy failureStrategy, VideoView subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<VideoViewSubject, VideoView> type() {
    return new SubjectFactory<VideoViewSubject, VideoView>() {
      @Override
      public VideoViewSubject getSubject(FailureStrategy fs, VideoView that) {
        return new VideoViewSubject(fs, that);
      }
    };
  }

  public VideoViewSubject isPausable() {
    assertThat(actual().canPause())
        .named("is pausable")
        .isTrue();
    return this;
  }

  public VideoViewSubject isNotPausable() {
    assertThat(actual().canPause())
        .named("is pausable")
        .isFalse();
    return this;
  }

  public VideoViewSubject isSeekableBackward() {
    assertThat(actual().canSeekBackward())
        .named("is seekable backward")
        .isTrue();
    return this;
  }

  public VideoViewSubject isNotSeekableBackward() {
    assertThat(actual().canSeekBackward())
        .named("is seekable backward")
        .isFalse();
    return this;
  }

  public VideoViewSubject isSeekableForward() {
    assertThat(actual().canSeekForward())
        .named("is seekable forward")
        .isTrue();
    return this;
  }

  public VideoViewSubject isNotSeekableForward() {
    assertThat(actual().canSeekForward())
        .named("is seekable forward")
        .isFalse();
    return this;
  }

  @TargetApi(JELLY_BEAN_MR2)
  public VideoViewSubject hasAudioSessionId(int id) {
    assertThat(actual().getAudioSessionId())
        .named("audio session ID")
        .isEqualTo(id);
    return this;
  }

  public VideoViewSubject hasBufferPercentage(int percentage) {
    assertThat(actual().getBufferPercentage())
        .named("buffer percentage")
        .isEqualTo(percentage);
    return this;
  }

  public VideoViewSubject hasCurrentPosition(int position) {
    assertThat(actual().getCurrentPosition())
        .named("current positions")
        .isEqualTo(position);
    return this;
  }

  public VideoViewSubject hasDuration(int duration) {
    assertThat(actual().getDuration())
        .named("duration")
        .isEqualTo(duration);
    return this;
  }

  public VideoViewSubject isPlaying() {
    assertThat(actual().isPlaying())
        .named("is playing")
        .isTrue();
    return this;
  }

  public VideoViewSubject isNotPlaying() {
    assertThat(actual().isPlaying())
        .named("is playing")
        .isFalse();
    return this;
  }
}
