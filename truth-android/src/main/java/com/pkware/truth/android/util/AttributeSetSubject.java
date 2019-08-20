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

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link AttributeSet} subjects.
 */
public class AttributeSetSubject extends Subject {

  @Nullable
  private final AttributeSet actual;

  public AttributeSetSubject(@Nonnull FailureMetadata failureMetadata, @Nullable AttributeSet actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public AttributeSetSubject hasAttributeCount(int count) {
    check("getAttributeCount()").that(actual.getAttributeCount()).isEqualTo(count);
    return this;
  }

  public AttributeSetSubject hasClassAttribute(@Nullable String value) {
    check("getClassAttribute()").that(actual.getClassAttribute()).isEqualTo(value);
    return this;
  }

  public AttributeSetSubject hasIdAttribute(@Nullable String value) {
    check("getIdAttribute()").that(actual.getIdAttribute()).isEqualTo(value);
    return this;
  }

  public AttributeSetSubject hasPositionDescription(@Nullable String position) {
    check("getPositionDescription()").that(actual.getPositionDescription()).isEqualTo(position);
    return this;
  }

  public AttributeSetSubject hasStyleAttribute(int value) {
    check("getStyleAttribute()").that(actual.getStyleAttribute()).isEqualTo(value);
    return this;
  }
}
