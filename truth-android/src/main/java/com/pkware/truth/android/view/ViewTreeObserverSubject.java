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
package com.pkware.truth.android.view;

import android.view.ViewTreeObserver;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link ViewTreeObserver} subjects.
 */
public class ViewTreeObserverSubject extends Subject<ViewTreeObserverSubject, ViewTreeObserver> {

  protected ViewTreeObserverSubject(FailureStrategy failureStrategy, ViewTreeObserver subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<ViewTreeObserverSubject, ViewTreeObserver> type() {
    return new SubjectFactory<ViewTreeObserverSubject, ViewTreeObserver>() {
      @Override
      public ViewTreeObserverSubject getSubject(FailureStrategy fs, ViewTreeObserver that) {
        return new ViewTreeObserverSubject(fs, that);
      }
    };
  }

  public ViewTreeObserverSubject isAlive() {
    assertThat(getSubject().isAlive())
        .named("is alive")
        .isTrue();
    return this;
  }

  public ViewTreeObserverSubject isNotAlive() {
    assertThat(getSubject().isAlive())
        .named("is alive")
        .isFalse();
    return this;
  }
}
