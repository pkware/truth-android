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

import android.view.ViewGroup;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class AbstractViewGroupMarginLayoutParamsSubject<T extends ViewGroup.MarginLayoutParams> extends Subject {

  @Nullable
  private final T actual;

  protected AbstractViewGroupMarginLayoutParamsSubject(@Nonnull FailureMetadata failureMetadata, @Nullable T actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasBottomMargin(int margin) {
    check("bottomMargin").that(actual.bottomMargin).isEqualTo(margin);
  }

  public void hasLeftMargin(int margin) {
    check("leftMargin").that(actual.leftMargin).isEqualTo(margin);
  }

  public void hasRightMargin(int margin) {
    check("rightMargin").that(actual.rightMargin).isEqualTo(margin);
  }

  public void hasTopMargin(int margin) {
    check("topMargin").that(actual.topMargin).isEqualTo(margin);
  }
}
