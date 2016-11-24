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
package com.pkware.truth.android.view;

import android.view.OrientationEventListener;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link OrientationEventListener} subjects.
 */
public class OrientationEventListenerSubject extends Subject<OrientationEventListenerSubject, OrientationEventListener> {
  protected OrientationEventListenerSubject(FailureStrategy failureStrategy, OrientationEventListener subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<OrientationEventListenerSubject, OrientationEventListener> type() {
    return new SubjectFactory<OrientationEventListenerSubject, OrientationEventListener>() {
      @Override
      public OrientationEventListenerSubject getSubject(FailureStrategy fs, OrientationEventListener that) {
        return new OrientationEventListenerSubject(fs, that);
      }
    };
  }

  public OrientationEventListenerSubject isDetectingOrientation() {
    assertThat(actual().canDetectOrientation())
        .named("is able to detect orientation")
        .isTrue();
    return this;
  }

  public OrientationEventListenerSubject isNotDetectingOrientation() {
    assertThat(actual().canDetectOrientation())
        .named("is able to detect orientation")
        .isFalse();
    return this;
  }
}
