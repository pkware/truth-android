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
package com.pkware.truth.androidx.legacy.v4.app;

import androidx.fragment.app.Fragment;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class AbstractFragmentSubject<T extends Fragment> extends Subject {

  @Nullable
  private final T actual;

  protected AbstractFragmentSubject(@Nonnull FailureMetadata failureMetadata, @Nullable T actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasId(int id) {
    check("getId()").that(actual.getId()).isEqualTo(id);
  }

  public void hasTag(@Nullable String tag) {
    check("getTag()").that(actual.getTag()).isEqualTo(tag);
  }

  public void isUserVisible() {
    check("getUserVisibleHint()").that(actual.getUserVisibleHint()).isTrue();
  }

  public void isNotUserVisible() {
    check("getUserVisibleHint()").that(actual.getUserVisibleHint()).isFalse();
  }

  public void isAdded() {
    check("isAdded()").that(actual.isAdded()).isTrue();
  }

  public void isNotAdded() {
    check("isAdded()").that(actual.isAdded()).isFalse();
  }

  public void isDetached() {
    check("isDetached()").that(actual.isDetached()).isTrue();
  }

  public void isNotDetached() {
    check("isDetached()").that(actual.isDetached()).isFalse();
  }

  public void isHidden() {
    check("isHidden()").that(actual.isHidden()).isTrue();
  }

  public void isNotHidden() {
    check("isHidden()").that(actual.isHidden()).isFalse();
  }

  public void isInLayout() {
    check("isInLayout()").that(actual.isInLayout()).isTrue();
  }

  public void isNotInLayout() {
    check("isInLayout()").that(actual.isInLayout()).isFalse();
  }

  public void isRemoving() {
    check("isRemoving()").that(actual.isRemoving()).isTrue();
  }

  public void isNotRemoving() {
    check("isRemoving()").that(actual.isRemoving()).isFalse();
  }

  public void isResumed() {
    check("isResumed()").that(actual.isResumed()).isTrue();
  }

  public void isNotResumed() {
    check("isResumed()").that(actual.isResumed()).isFalse();
  }

  public void isVisible() {
    check("isVisible()").that(actual.isVisible()).isTrue();
  }

  public void isNotVisible() {
    check("isVisible()").that(actual.isVisible()).isFalse();
  }
}
