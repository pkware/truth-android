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

import android.widget.RatingBar;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link RatingBar} subjects.
 */
public class RatingBarSubject extends AbstractAbsSeekBarSubject<RatingBarSubject, RatingBar> {
  protected RatingBarSubject(FailureMetadata failureMetadata, RatingBar subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<RatingBarSubject, RatingBar> type() {
    return RatingBarSubject::new;
  }

  public RatingBarSubject hasStarCount(int count) {
    assertThat(actual().getNumStars())
        .named("star count")
        .isEqualTo(count);
    return this;
  }

  public RatingBarSubject hasRating(float rating, float tolerance) {
    assertThat(actual().getRating())
        .named("rating")
        .isWithin(tolerance)
        .of(rating);
    return this;
  }

  public RatingBarSubject hasStepSize(float size, float tolerance) {
    assertThat(actual().getStepSize())
        .named("step size")
        .isWithin(tolerance)
        .of(size);
    return this;
  }

  public RatingBarSubject isIndicator() {
    assertThat(actual().isIndicator())
        .named("is indicator")
        .isTrue();
    return this;
  }

  public RatingBarSubject isNotIndicator() {
    assertThat(actual().isIndicator())
        .named("is indicator")
        .isFalse();
    return this;
  }
}
