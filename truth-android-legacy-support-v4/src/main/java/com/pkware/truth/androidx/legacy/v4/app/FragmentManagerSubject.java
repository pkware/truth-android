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

import androidx.fragment.app.FragmentManager;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link FragmentManager} subjects.
 */
public class FragmentManagerSubject extends Subject<FragmentManagerSubject, FragmentManager> {
  public FragmentManagerSubject(FailureMetadata failureMetadata, FragmentManager subject) {
    super(failureMetadata, subject);
  }

  public FragmentManagerSubject hasFragmentWithId(int id) {
    assertThat(actual().findFragmentById(id))
        .named("fragment with ID " + id)
        .isNotNull();
    return this;
  }

  public FragmentManagerSubject hasFragmentWithTag(String tag) {
    assertThat(actual().findFragmentByTag(tag))
        .named("fragment with tag " + tag)
        .isNotNull();
    return this;
  }

  public FragmentManagerSubject hasBackStackEntryCount(int count) {
    assertThat(actual().getBackStackEntryCount())
        .named("back stack entry count")
        .isEqualTo(count);
    return this;
  }

  public FragmentManagerSubject doesNotHaveFragmentWithId(int id) {
    assertThat(actual().findFragmentById(id))
        .named("fragment with ID " + id)
        .isNull();
    return this;
  }

  public FragmentManagerSubject doesNotHaveFragmentWithTag(String tag) {
    assertThat(actual().findFragmentByTag(tag))
        .named("fragment with tag " + tag)
        .isNull();
    return this;
  }
}
