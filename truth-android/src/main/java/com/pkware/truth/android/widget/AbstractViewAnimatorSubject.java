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
import com.google.common.truth.Truth;
import com.pkware.truth.android.view.AbstractViewGroupSubject;

import static com.google.common.truth.Truth.assertThat;
import static com.pkware.truth.android.Assertions.assertThat;

public abstract class AbstractViewAnimatorSubject<S extends AbstractViewAnimatorSubject<S, T>, T extends ViewAnimator>
    extends AbstractViewGroupSubject<S, T> {
  protected AbstractViewAnimatorSubject(FailureMetadata failureMetadata, T subject) {
    super(failureMetadata, subject);
  }

  public S hasDisplayedChild(View view) {
    Truth.assertThat(getDisplayedView())
        .named("displayed child")
        .isSameAs(view);
    //noinspection unchecked
    return (S) this;
  }

  public S hasDisplayedChildId(int id) {
    assertThat(getDisplayedView()).hasId(id);
    //noinspection unchecked
    return (S) this;
  }

  public S hasDisplayedChild(int index) {
    assertThat(actual().getDisplayedChild())
        .named("displayed child index")
        .isEqualTo(index);
    //noinspection unchecked
    return (S) this;
  }

  private View getDisplayedView() {
    return actual().getChildAt(actual().getDisplayedChild());
  }
}
