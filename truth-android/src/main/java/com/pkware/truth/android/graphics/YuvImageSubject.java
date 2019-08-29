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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link YuvImage} subjects.
 */
public class YuvImageSubject extends Subject {

  @Nullable
  private final YuvImage actual;

  public YuvImageSubject(@Nonnull FailureMetadata failureMetadata, @Nullable YuvImage actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasHeight(int height) {
    check("getHeight()").that(actual.getHeight()).isEqualTo(height);
  }

  public void hasWidth(int width) {
    check("getWidth()").that(actual.getWidth()).isEqualTo(width);
  }

  public void hasYuvFormat(int format) {
    check("getYuvFormat()").that(actual.getYuvFormat()).isEqualTo(format);
  }
}
