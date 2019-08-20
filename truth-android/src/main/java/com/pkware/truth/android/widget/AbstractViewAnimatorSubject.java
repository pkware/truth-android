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

import android.view.View;
import android.widget.ViewAnimator;

import com.google.common.truth.FailureMetadata;
import com.pkware.truth.android.view.AbstractViewGroupSubject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static com.pkware.truth.android.Assertions.assertThat;

public abstract class AbstractViewAnimatorSubject<T extends ViewAnimator>
    extends AbstractViewGroupSubject<T> {

  @Nullable
  private final T actual;

  protected AbstractViewAnimatorSubject(@Nonnull FailureMetadata failureMetadata, @Nullable T actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasDisplayedChild(@Nullable View view) {
    check("getChildAt(actual.getDisplayedChild()")
        .withMessage("displayed child")
        .that(getDisplayedView())
        .isSameInstanceAs(view);
  }

  public void hasDisplayedChildId(int id) {
    assertThat(getDisplayedView()).hasId(id);
  }

  public void hasDisplayedChild(int index) {
    check("getDisplayedChild()").that(actual.getDisplayedChild()).isEqualTo(index);
  }

  private View getDisplayedView() {
    return actual.getChildAt(actual.getDisplayedChild());
  }
}
