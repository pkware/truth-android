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

import android.view.ViewGroup;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;

import static com.google.common.truth.Truth.assertThat;

public abstract class AbstractViewGroupLayoutParamsSubject<S extends AbstractViewGroupLayoutParamsSubject<S, T>, T extends ViewGroup.LayoutParams>
    extends Subject<S, T> {
  protected AbstractViewGroupLayoutParamsSubject(FailureStrategy failureStrategy, T subject) {
    super(failureStrategy, subject);
  }

  public S hasHeight(int height) {
    assertThat(actual().height)
        .named("height")
        .isEqualTo(height);
    //noinspection unchecked
    return (S) this;
  }

  public S hasWidth(int width) {
    assertThat(actual().width)
        .named("width")
        .isEqualTo(width);
    //noinspection unchecked
    return (S) this;
  }
}
