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

import android.graphics.Typeface;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link Typeface} subjects.
 */
public class TypefaceSubject extends Subject {

  @Nullable
  private final Typeface actual;

  public TypefaceSubject(@Nonnull FailureMetadata failureMetadata, @Nullable Typeface actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public TypefaceSubject hasStyle(int style) {
    check("getStyle()").that(actual.getStyle()).isEqualTo(style);
    return this;
  }

  public TypefaceSubject isBold() {
    check("isBold()").that(actual.isBold()).isTrue();
    return this;
  }

  public TypefaceSubject isNotBold() {
    check("isBold()").that(actual.isBold()).isFalse();
    return this;
  }

  public TypefaceSubject isItalic() {
    check("isItalic()").that(actual.isItalic()).isTrue();
    return this;
  }

  public TypefaceSubject isNotItalic() {
    check("isItalic()").that(actual.isItalic()).isFalse();
    return this;
  }
}
