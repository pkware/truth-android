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

import android.widget.AbsoluteLayout;

import com.google.common.truth.FailureStrategy;
import com.pkware.truth.android.view.AbstractViewGroupSubject;

import static com.google.common.truth.Truth.assertThat;

public abstract class AbstractAbsoluteLayoutSubject<S extends AbstractAbsoluteLayoutSubject<S, T>, T extends AbsoluteLayout>
    extends AbstractViewGroupSubject<S, T> {
  protected AbstractAbsoluteLayoutSubject(FailureStrategy failureStrategy, T subject) {
    super(failureStrategy, subject);
  }

  public S isDelayingChildPressedState() {
    assertThat(actual().shouldDelayChildPressedState())
        .named("is delaying child pressed state")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotDelayingChildPressedState() {
    assertThat(actual().shouldDelayChildPressedState())
        .named("is delaying child pressed state")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }
}
