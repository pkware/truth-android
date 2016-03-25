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
package com.pkware.truth.android.gesture;

import android.gesture.Prediction;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link Prediction} subjects.
 */
public class PredictionSubject extends Subject<PredictionSubject, Prediction> {
  protected PredictionSubject(FailureStrategy failureStrategy, Prediction subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<PredictionSubject, Prediction> type() {
    return new SubjectFactory<PredictionSubject, Prediction>() {
      @Override
      public PredictionSubject getSubject(FailureStrategy fs, Prediction that) {
        return new PredictionSubject(fs, that);
      }
    };
  }

  public PredictionSubject hasName(String name) {
    assertThat(getSubject().name)
        .named("name")
        .isEqualTo(name);
    return this;
  }

  public PredictionSubject hasScore(double score, double tolerance) {
    assertThat(getSubject().score)
        .named("score")
        .isWithin(tolerance)
        .of(score);
    return this;
  }
}
