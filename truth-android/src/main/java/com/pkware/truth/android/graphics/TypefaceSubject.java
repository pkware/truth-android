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

import android.graphics.Typeface;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link Typeface} subjects.
 */
public class TypefaceSubject extends Subject<TypefaceSubject, Typeface> {
  protected TypefaceSubject(FailureStrategy failureStrategy, Typeface subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<TypefaceSubject, Typeface> type() {
    return new SubjectFactory<TypefaceSubject, Typeface>() {
      @Override
      public TypefaceSubject getSubject(FailureStrategy fs, Typeface that) {
        return new TypefaceSubject(fs, that);
      }
    };
  }

  public TypefaceSubject hasStyle(int style) {
    assertThat(getSubject().getStyle())
        .named("style")
        .isEqualTo(style);
    return this;
  }

  public TypefaceSubject isBold() {
    assertThat(getSubject().isBold())
        .named("is bold")
        .isTrue();
    return this;
  }

  public TypefaceSubject isNotBold() {
    assertThat(getSubject().isBold())
        .named("is bold")
        .isFalse();
    return this;
  }

  public TypefaceSubject isItalic() {
    assertThat(getSubject().isItalic())
        .named("is italic")
        .isTrue();
    return this;
  }

  public TypefaceSubject isNotItalic() {
    assertThat(getSubject().isItalic())
        .named("is italic")
        .isFalse();
    return this;
  }
}
