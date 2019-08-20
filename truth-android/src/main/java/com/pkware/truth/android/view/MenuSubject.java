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

import android.view.Menu;

import androidx.annotation.IdRes;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link Menu} subjects.
 */
public class MenuSubject extends Subject {

  @Nullable
  private final Menu actual;

  public MenuSubject(@Nonnull FailureMetadata failureMetadata, @Nullable Menu actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public MenuSubject hasItem(@IdRes int id) {
    check("findItem(id)")
        .withMessage("menu item with ID %s", id)
        .that(actual.findItem(id))
        .isNotNull();
    return this;
  }

  public MenuSubject hasItemAt(int index) {
    check("getItem(index)")
        .withMessage("menu item at index %s", index)
        .that(actual.getItem(index))
        .isNotNull();
    return this;
  }

  public MenuSubject hasVisibleItems() {
    check("hasVisibleItems()").that(actual.hasVisibleItems()).isTrue();
    return this;
  }

  public MenuSubject hasNoVisibleItems() {
    check("hasVisibleItems()").that(actual.hasVisibleItems()).isFalse();
    return this;
  }

  public MenuSubject hasSize(int size) {
    check("size()").that(actual.size()).isEqualTo(size);
    return this;
  }
}
