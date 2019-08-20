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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link MediaController} subjects.
 */
public class MediaControllerSubject extends AbstractFrameLayoutSubject<MediaController> {

  @Nullable
  private final MediaController actual;

  public MediaControllerSubject(@Nonnull FailureMetadata failureMetadata, @Nullable MediaController actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public MediaControllerSubject isShowing() {
    check("isShowing()").that(actual.isShowing()).isTrue();
    return this;
  }

  public MediaControllerSubject isNotShowing() {
    check("isShowing()").that(actual.isShowing()).isFalse();
    return this;
  }
}
