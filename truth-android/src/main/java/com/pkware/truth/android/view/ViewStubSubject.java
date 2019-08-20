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

import android.view.ViewStub;
import androidx.annotation.LayoutRes;

import com.google.common.truth.FailureMetadata;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link ViewStub} subjects.
 */
public class ViewStubSubject extends AbstractViewSubject<ViewStubSubject, ViewStub> {
  public ViewStubSubject(FailureMetadata failureMetadata, ViewStub subject) {
    super(failureMetadata, subject);
  }

  public ViewStubSubject hasInflatedId(int id) {
    assertThat(actual().getInflatedId())
        .named("view stub inflated ID")
        .isEqualTo(id);
    return this;
  }

  public ViewStubSubject hasLayoutResource(@LayoutRes int resId) {
    assertThat(actual().getLayoutResource())
        .named("view stub layout resource")
        .isEqualTo(resId);
    return this;
  }
}
