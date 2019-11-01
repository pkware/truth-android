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
package com.pkware.truth.androidx.fragment.app;

import androidx.fragment.app.FragmentManager;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link FragmentManager} subjects.
 */
public class FragmentManagerSubject extends Subject {

  @Nullable
  private final FragmentManager actual;

  public FragmentManagerSubject(@Nonnull FailureMetadata failureMetadata, @Nullable FragmentManager actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasFragmentWithId(int id) {
    check("findFragmentById(id)")
        .withMessage("fragment with ID %s", id)
        .that(actual.findFragmentById(id))
        .isNotNull();
  }

  public void hasFragmentWithTag(@Nullable String tag) {
    check("findFragmentByTag(tag)")
        .withMessage("fragment with tag %s", tag)
        .that(actual.findFragmentByTag(tag))
        .isNotNull();
  }

  public void hasBackStackEntryCount(int count) {
    check("getBackStackEntryCount()").that(actual.getBackStackEntryCount()).isEqualTo(count);
  }

  public void doesNotHaveFragmentWithId(int id) {
    check("findFragmentById(id)")
        .withMessage("fragment with ID %s", id)
        .that(actual.findFragmentById(id))
        .isNull();
  }

  public void doesNotHaveFragmentWithTag(@Nullable String tag) {
    check("findFragmentByTag(tag)")
        .withMessage("fragment with tag %s", tag)
        .that(actual.findFragmentByTag(tag))
        .isNull();
  }
}
