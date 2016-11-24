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
package com.pkware.truth.android.util;

import android.util.AttributeSet;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link AttributeSet} subjects.
 */
public class AttributeSetSubject extends Subject<AttributeSetSubject, AttributeSet> {
  protected AttributeSetSubject(FailureStrategy failureStrategy, AttributeSet subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<AttributeSetSubject, AttributeSet> type() {
    return new SubjectFactory<AttributeSetSubject, AttributeSet>() {
      @Override
      public AttributeSetSubject getSubject(FailureStrategy fs, AttributeSet that) {
        return new AttributeSetSubject(fs, that);
      }
    };
  }

  public AttributeSetSubject hasAttributeCount(int count) {
    assertThat(actual().getAttributeCount())
        .named("attribute count")
        .isEqualTo(count);
    return this;
  }

  public AttributeSetSubject hasClassAttribute(String value) {
    assertThat(actual().getClassAttribute())
        .named("class attribute")
        .isEqualTo(value);
    return this;
  }

  public AttributeSetSubject hasIdAttribute(String value) {
    assertThat(actual().getIdAttribute())
        .named("ID attribute")
        .isEqualTo(value);
    return this;
  }

  public AttributeSetSubject hasPositionDescription(String position) {
    assertThat(actual().getPositionDescription())
        .named("position description")
        .isEqualTo(position);
    return this;
  }

  public AttributeSetSubject hasStyleAttribute(int value) {
    assertThat(actual().getStyleAttribute())
        .named("style attribute")
        .isEqualTo(value);
    return this;
  }
}
