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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR2;

@TargetApi(JELLY_BEAN_MR2)
public class BidiFormatterSubject extends Subject {

  @Nullable
  private final BidiFormatter actual;

  public BidiFormatterSubject(@Nonnull FailureMetadata failureMetadata, @Nullable BidiFormatter actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasRtlContext() {
    check("isRtlContext()").that(actual.isRtlContext()).isTrue();
  }

  public void doesNotHaveRtlContext() {
    check("isRtlContext()").that(actual.isRtlContext()).isFalse();
  }
}
