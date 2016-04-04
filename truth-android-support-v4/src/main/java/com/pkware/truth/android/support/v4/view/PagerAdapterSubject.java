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
package com.pkware.truth.android.support.v4.view;

import android.support.v4.view.PagerAdapter;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link PagerAdapter} subjects.
 */
public class PagerAdapterSubject extends Subject<PagerAdapterSubject, PagerAdapter> {
  protected PagerAdapterSubject(FailureStrategy failureStrategy, PagerAdapter subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<PagerAdapterSubject, PagerAdapter> type() {
    return new SubjectFactory<PagerAdapterSubject, PagerAdapter>() {
      @Override
      public PagerAdapterSubject getSubject(FailureStrategy fs, PagerAdapter that) {
        return new PagerAdapterSubject(fs, that);
      }
    };
  }

  public PagerAdapterSubject hasCount(int count) {
    assertThat(getSubject().getCount())
        .named("count")
        .isEqualTo(count);
    return this;
  }
}
