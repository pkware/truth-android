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
package com.pkware.truth.android.cardview.v7.widget;

import android.support.v7.widget.CardView;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;
import com.pkware.truth.android.view.AbstractViewGroupSubject;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link CardView} subjects.
 */
public class CardViewSubject extends AbstractViewGroupSubject<CardViewSubject, CardView> {
  protected CardViewSubject(FailureStrategy failureStrategy, CardView subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<CardViewSubject, CardView> type() {
    return new SubjectFactory<CardViewSubject, CardView>() {
      @Override
      public CardViewSubject getSubject(FailureStrategy fs, CardView that) {
        return new CardViewSubject(fs, that);
      }
    };
  }

  public CardViewSubject hasRadius(int radius) {
    assertThat(actual().getRadius())
        .named("radius")
        .isEqualTo(radius);
    return this;
  }
}
