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
package com.pkware.truth.android.text;

import android.annotation.TargetApi;
import android.text.BidiFormatter;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR2;
import static com.google.common.truth.Truth.assertThat;

@TargetApi(JELLY_BEAN_MR2)
public class BidiFormatterSubject extends Subject<BidiFormatterSubject, BidiFormatter> {
  protected BidiFormatterSubject(FailureStrategy failureStrategy, BidiFormatter subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<BidiFormatterSubject, BidiFormatter> type() {
    return new SubjectFactory<BidiFormatterSubject, BidiFormatter>() {
      @Override
      public BidiFormatterSubject getSubject(FailureStrategy fs, BidiFormatter that) {
        return new BidiFormatterSubject(fs, that);
      }
    };
  }

  public BidiFormatterSubject hasRtlContext() {
    assertThat(getSubject().isRtlContext())
        .named("is RTL context")
        .isTrue();
    return this;
  }

  public BidiFormatterSubject doesNotHaveRtlContext() {
    assertThat(getSubject().isRtlContext())
        .named("is RTL context")
        .isFalse();
    return this;
  }
}
