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
package com.pkware.truth.android.animation;

import android.animation.PropertyValuesHolder;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link PropertyValuesHolder} subjects.
 */
public class PropertyValuesHolderSubject extends Subject<PropertyValuesHolderSubject, PropertyValuesHolder> {
  private PropertyValuesHolderSubject(FailureStrategy failureStrategy, PropertyValuesHolder subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<PropertyValuesHolderSubject, PropertyValuesHolder> type() {
    return new SubjectFactory<PropertyValuesHolderSubject, PropertyValuesHolder>() {
      @Override
      public PropertyValuesHolderSubject getSubject(FailureStrategy fs, PropertyValuesHolder that) {
        return new PropertyValuesHolderSubject(fs, that);
      }
    };
  }

  public PropertyValuesHolderSubject hasPropertyName(String name) {
    assertThat(getSubject().getPropertyName())
        .named("property name")
        .isEqualTo(name);
    return this;
  }
}
