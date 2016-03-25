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
package com.pkware.truth.android.graphics;

import android.graphics.Picture;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link Picture} subjects.
 */
public class PictureSubject extends Subject<PictureSubject, Picture> {
  protected PictureSubject(FailureStrategy failureStrategy, Picture subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<PictureSubject, Picture> type() {
    return new SubjectFactory<PictureSubject, Picture>() {
      @Override
      public PictureSubject getSubject(FailureStrategy fs, Picture that) {
        return new PictureSubject(fs, that);
      }
    };
  }

  public PictureSubject hasHeight(int height) {
    assertThat(getSubject().getHeight())
        .named("height")
        .isEqualTo(height);
    return this;
  }

  public PictureSubject hasWidth(int width) {
    assertThat(getSubject().getWidth())
        .named("width")
        .isEqualTo(width);
    return this;
  }
}
