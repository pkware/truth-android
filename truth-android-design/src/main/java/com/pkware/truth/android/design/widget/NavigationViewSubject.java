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
package com.pkware.truth.android.design.widget;

import android.graphics.drawable.Drawable;
import android.support.design.widget.NavigationView;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;
import com.pkware.truth.android.widget.AbstractFrameLayoutSubject;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link NavigationView} subjects.
 */
public class NavigationViewSubject
    extends AbstractFrameLayoutSubject<NavigationViewSubject, NavigationView> {
  protected NavigationViewSubject(FailureMetadata failureMetadata, NavigationView subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<NavigationViewSubject, NavigationView> type() {
    return NavigationViewSubject::new;
  }

  public NavigationViewSubject hasItemBackground(Drawable itemBackground) {
    assertThat(actual().getItemBackground())
        .named("item background")
        .isEqualTo(itemBackground);
    return this;
  }
}
