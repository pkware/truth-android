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
package com.pkware.truth.android.view.animation;

import android.graphics.Matrix;
import android.view.animation.Transformation;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static android.view.animation.Transformation.TYPE_ALPHA;
import static android.view.animation.Transformation.TYPE_BOTH;
import static android.view.animation.Transformation.TYPE_IDENTITY;
import static android.view.animation.Transformation.TYPE_MATRIX;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assert_;
import static com.pkware.truth.android.internal.IntegerUtils.buildNamedValueString;

/**
 * Propositions for {@link Transformation} subjects.
 */
public class TransformationSubject extends Subject<TransformationSubject, Transformation> {
  protected TransformationSubject(FailureStrategy failureStrategy, Transformation subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<TransformationSubject, Transformation> type() {
    return new SubjectFactory<TransformationSubject, Transformation>() {
      @Override
      public TransformationSubject getSubject(FailureStrategy fs, Transformation that) {
        return new TransformationSubject(fs, that);
      }
    };
  }

  public static String transformationTypeToString(@TransformationType int type) {
    return buildNamedValueString(type)
        .value(TYPE_ALPHA, "alpha")
        .value(TYPE_BOTH, "both")
        .value(TYPE_IDENTITY, "identity")
        .value(TYPE_MATRIX, "matrix")
        .get();
  }

  public TransformationSubject hasAlpha(float alpha, float tolerance) {
    assertThat(actual().getAlpha())
        .named("alpha")
        .isWithin(tolerance)
        .of(alpha);
    return this;
  }

  public TransformationSubject hasMatrix(Matrix matrix) {
    assertThat(actual().getMatrix())
        .named("matrix")
        .isEqualTo(matrix);
    return this;
  }

  public TransformationSubject hasTransformationType(@TransformationType int type) {
    int actualType = actual().getTransformationType();
    //noinspection ResourceType
    assert_()
        .withFailureMessage("Expected transformation type <%s> but was <%s>.",
            transformationTypeToString(type), transformationTypeToString(actualType))
        .that(actualType)
        .isEqualTo(type);
    return this;
  }
}
