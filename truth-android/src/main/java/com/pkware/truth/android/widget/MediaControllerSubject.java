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

import android.widget.MediaController;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link MediaController} subjects.
 */
public class MediaControllerSubject extends AbstractFrameLayoutSubject<MediaControllerSubject, MediaController> {
  protected MediaControllerSubject(FailureMetadata failureMetadata, MediaController subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<MediaControllerSubject, MediaController> type() {
    return MediaControllerSubject::new;
  }

  public MediaControllerSubject isShowing() {
    assertThat(actual().isShowing())
        .named("is showing")
        .isTrue();
    return this;
  }

  public MediaControllerSubject isNotShowing() {
    assertThat(actual().isShowing())
        .named("is showing")
        .isFalse();
    return this;
  }
}
