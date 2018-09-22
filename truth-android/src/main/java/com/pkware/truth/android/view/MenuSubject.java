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

import android.support.annotation.IdRes;
import android.view.Menu;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link Menu} subjects.
 */
public class MenuSubject extends Subject<MenuSubject, Menu> {
  protected MenuSubject(FailureMetadata failureMetadata, Menu subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<MenuSubject, Menu> type() {
    return new Subject.Factory<MenuSubject, Menu>() {
      @Override
      public MenuSubject createSubject(FailureMetadata fm, Menu that) {
        return new MenuSubject(fm, that);
      }
    };
  }

  public MenuSubject hasItem(@IdRes int id) {
    assertThat(actual().findItem(id))
        .named("menu item with ID " + id)
        .isNotNull();
    return this;
  }

  public MenuSubject hasItemAt(int index) {
    assertThat(actual().getItem(index))
        .named("menu item at index " + index)
        .isNotNull();
    return this;
  }

  public MenuSubject hasVisibleItems() {
    assertThat(actual().hasVisibleItems())
        .named("has visible items")
        .isTrue();
    return this;
  }

  public MenuSubject hasNoVisibleItems() {
    assertThat(actual().hasVisibleItems())
        .named("has visible items")
        .isFalse();
    return this;
  }

  public MenuSubject hasSize(int size) {
    assertThat(actual().size())
        .named("size")
        .isEqualTo(size);
    return this;
  }
}
