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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link RatingBar} subjects.
 */
public class RatingBarSubject extends AbstractAbsSeekBarSubject<RatingBar> {

  @Nullable
  private final RatingBar actual;

  public RatingBarSubject(@Nonnull FailureMetadata failureMetadata, @Nullable RatingBar actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public RatingBarSubject hasStarCount(int count) {
    check("getNumStars()").that(actual.getNumStars()).isEqualTo(count);
    return this;
  }

  public RatingBarSubject hasRating(float rating, float tolerance) {
    check("getRating()").that(actual.getRating()).isWithin(tolerance).of(rating);
    return this;
  }

  public RatingBarSubject hasStepSize(float size, float tolerance) {
    check("getStepSize()").that(actual.getStepSize()).isWithin(tolerance).of(size);
    return this;
  }

  public RatingBarSubject isIndicator() {
    check("isIndicator()").that(actual.isIndicator()).isTrue();
    return this;
  }

  public RatingBarSubject isNotIndicator() {
    check("isIndicator()").that(actual.isIndicator()).isFalse();
    return this;
  }
}
