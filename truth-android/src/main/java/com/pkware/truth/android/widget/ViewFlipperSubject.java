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

import android.widget.ViewFlipper;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link ViewFlipper} subjects.
 */
public class ViewFlipperSubject extends AbstractViewAnimatorSubject<ViewFlipperSubject, ViewFlipper> {
  protected ViewFlipperSubject(FailureMetadata failureMetadata, ViewFlipper subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<ViewFlipperSubject, ViewFlipper> type() {
    return new Subject.Factory<ViewFlipperSubject, ViewFlipper>() {
      @Override
      public ViewFlipperSubject createSubject(FailureMetadata fm, ViewFlipper that) {
        return new ViewFlipperSubject(fm, that);
      }
    };
  }

  public ViewFlipperSubject isAutoStarting() {
    assertThat(actual().isAutoStart())
        .named("is auto-starting")
        .isTrue();
    return this;
  }

  public ViewFlipperSubject isNotAutoStarting() {
    assertThat(actual().isAutoStart())
        .named("is auto-starting")
        .isTrue();
    return this;
  }

  public ViewFlipperSubject isFlipping() {
    assertThat(actual().isFlipping())
        .named("is flipping")
        .isTrue();
    return this;
  }

  public ViewFlipperSubject isNotFlipping() {
    assertThat(actual().isFlipping())
        .named("is flipping")
        .isFalse();
    return this;
  }
}
