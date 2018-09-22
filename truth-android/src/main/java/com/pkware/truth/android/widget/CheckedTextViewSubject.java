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
package com.pkware.truth.android.widget;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.widget.CheckedTextView;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import static android.os.Build.VERSION_CODES.JELLY_BEAN;
import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link CheckedTextView} subjects.
 */
public class CheckedTextViewSubject extends AbstractTextViewSubject<CheckedTextViewSubject, CheckedTextView> {
  protected CheckedTextViewSubject(FailureMetadata failureMetadata, CheckedTextView subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<CheckedTextViewSubject, CheckedTextView> type() {
    return new Subject.Factory<CheckedTextViewSubject, CheckedTextView>() {
      @Override
      public CheckedTextViewSubject createSubject(FailureMetadata fm, CheckedTextView that) {
        return new CheckedTextViewSubject(fm, that);
      }
    };
  }

  @TargetApi(JELLY_BEAN)
  public CheckedTextViewSubject hasCheckMarkDrawable(Drawable drawable) {
    assertThat(actual().getCheckMarkDrawable())
        .named("check mark drawable")
        .isSameAs(drawable);
    return this;
  }

  public CheckedTextViewSubject isChecked() {
    assertThat(actual().isChecked())
        .named("is checked")
        .isTrue();
    return this;
  }

  public CheckedTextViewSubject isNotChecked() {
    assertThat(actual().isChecked())
        .named("is checked")
        .isFalse();
    return this;
  }
}
