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
package com.pkware.truth.android.text;

import android.annotation.TargetApi;
import android.text.BidiFormatter;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR2;
import static com.google.common.truth.Truth.assertThat;

@TargetApi(JELLY_BEAN_MR2)
public class BidiFormatterSubject extends Subject<BidiFormatterSubject, BidiFormatter> {
  protected BidiFormatterSubject(FailureMetadata failureMetadata, BidiFormatter subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<BidiFormatterSubject, BidiFormatter> type() {
    return new Subject.Factory<BidiFormatterSubject, BidiFormatter>() {
      @Override
      public BidiFormatterSubject createSubject(FailureMetadata fm, BidiFormatter that) {
        return new BidiFormatterSubject(fm, that);
      }
    };
  }

  public BidiFormatterSubject hasRtlContext() {
    assertThat(actual().isRtlContext())
        .named("is RTL context")
        .isTrue();
    return this;
  }

  public BidiFormatterSubject doesNotHaveRtlContext() {
    assertThat(actual().isRtlContext())
        .named("is RTL context")
        .isFalse();
    return this;
  }
}
