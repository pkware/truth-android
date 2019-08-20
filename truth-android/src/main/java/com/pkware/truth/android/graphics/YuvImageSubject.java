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
package com.pkware.truth.android.graphics;

import android.graphics.YuvImage;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link YuvImage} subjects.
 */
public class YuvImageSubject extends Subject<YuvImageSubject, YuvImage> {
  public YuvImageSubject(FailureMetadata failureMetadata, YuvImage subject) {
    super(failureMetadata, subject);
  }

  public YuvImageSubject hasHeight(int height) {
    assertThat(actual().getHeight())
        .named("height")
        .isEqualTo(height);
    return this;
  }

  public YuvImageSubject hasWidth(int width) {
    assertThat(actual().getWidth())
        .named("width")
        .isEqualTo(width);
    return this;
  }

  public YuvImageSubject hasYuvFormat(int format) {
    assertThat(actual().getYuvFormat())
        .named("YUV format")
        .isEqualTo(format);
    return this;
  }
}
