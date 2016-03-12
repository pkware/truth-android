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
package com.pkware.truth.android.app;

import android.app.Fragment;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;

import static com.google.common.truth.Truth.assertThat;

public abstract class AbstractFragmentSubject<S extends AbstractFragmentSubject<S, T>, T extends Fragment> extends Subject<S, T> {
  protected AbstractFragmentSubject(FailureStrategy failureStrategy, T subject) {
    super(failureStrategy, subject);
  }

  public S hasId(int id) {
    assertThat(getSubject().getId())
        .named("id")
        .isEqualTo(id);
    //noinspection unchecked
    return (S) this;
  }

  public S hasTag(String tag) {
    assertThat(getSubject().getTag())
        .named("tag")
        .isEqualTo(tag);
    //noinspection unchecked
    return (S) this;
  }

  public S isUserVisible() {
    assertThat(getSubject().getUserVisibleHint())
        .named("user visible hint")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotUserVisible() {
    assertThat(getSubject().getUserVisibleHint())
        .named("user visible hint")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S isAdded() {
    assertThat(getSubject().isAdded())
        .named("is added")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotAdded() {
    assertThat(getSubject().isAdded())
        .named("is added")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S isDetached() {
    assertThat(getSubject().isDetached())
        .named("is detached")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotDetached() {
    assertThat(getSubject().isDetached())
        .named("is detached")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S isHidden() {
    assertThat(getSubject().isHidden())
        .named("is hidden")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotHidden() {
    assertThat(getSubject().isHidden())
        .named("is hidden")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S isInLayout() {
    assertThat(getSubject().isInLayout())
        .named("is in layout")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotInLayout() {
    assertThat(getSubject().isInLayout())
        .named("is in layout")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S isRemoving() {
    assertThat(getSubject().isRemoving())
        .named("is removing")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotRemoving() {
    assertThat(getSubject().isRemoving())
        .named("is removing")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S isResumed() {
    assertThat(getSubject().isResumed())
        .named("is resumed")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotResumed() {
    assertThat(getSubject().isResumed())
        .named("is resumed")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S isVisible() {
    assertThat(getSubject().isVisible())
        .named("is visible")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotVisible() {
    assertThat(getSubject().isVisible())
        .named("is visible")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }
}
