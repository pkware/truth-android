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
import android.widget.SlidingDrawer;

import com.google.common.truth.FailureMetadata;
import com.pkware.truth.android.view.AbstractViewGroupSubject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link SlidingDrawer} subjects.
 */
public class SlidingDrawerSubject
    extends AbstractViewGroupSubject<SlidingDrawer> {

  @Nullable
  private final SlidingDrawer actual;

  public SlidingDrawerSubject(@Nonnull FailureMetadata failureMetadata, @Nullable SlidingDrawer actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public SlidingDrawerSubject hasContent(@Nullable View view) {
    check("getContent()").that(actual.getContent()).isSameInstanceAs(view);
    return this;
  }

  public SlidingDrawerSubject hasHandle(@Nullable View view) {
    check("getHandle()").that(actual.getHandle()).isSameInstanceAs(view);
    return this;
  }

  public SlidingDrawerSubject isMoving() {
    check("isMoving()").that(actual.isMoving()).isTrue();
    return this;
  }

  public SlidingDrawerSubject isNotMoving() {
    check("isMoving()").that(actual.isMoving()).isFalse();
    return this;
  }

  public SlidingDrawerSubject isOpened() {
    check("isMoving()").that(actual.isMoving()).isTrue();
    return this;
  }

  public SlidingDrawerSubject isClosed() {
    check("isMoving()").that(actual.isMoving()).isFalse();
    return this;
  }
}
