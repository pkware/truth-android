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
package com.pkware.truth.android.design.widget;

import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link TabLayout.Tab} subjects.
 */
public class TabLayoutTabSubject extends Subject<TabLayoutTabSubject, TabLayout.Tab> {
  protected TabLayoutTabSubject(FailureStrategy failureStrategy, TabLayout.Tab subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<TabLayoutTabSubject, TabLayout.Tab> type() {
    return new SubjectFactory<TabLayoutTabSubject, TabLayout.Tab>() {
      @Override
      public TabLayoutTabSubject getSubject(FailureStrategy fs, TabLayout.Tab that) {
        return new TabLayoutTabSubject(fs, that);
      }
    };
  }

  public TabLayoutTabSubject hasContentDescription(String contentDescription) {
    CharSequence actualContentDescription = actual().getContentDescription();
    String contentDescriptionString;
    if (actualContentDescription == null) {
      contentDescriptionString = null;
    } else {
      contentDescriptionString = actualContentDescription.toString();
    }
    assertThat(contentDescriptionString)
        .named("content description")
        .isEqualTo(contentDescription);
    return this;
  }

  public TabLayoutTabSubject hasIcon(Drawable icon) {
    assertThat(actual().getIcon())
        .named("icon")
        .isSameAs(icon);
    return this;
  }

  public TabLayoutTabSubject hasPosition(int position) {
    assertThat(actual().getPosition())
        .named("position")
        .isEqualTo(position);
    //noinspection unchecked
    return this;
  }

  public TabLayoutTabSubject hasText(String text) {
    CharSequence actualText = actual().getText();
    String actualTextString;
    if (actualText == null) {
      actualTextString = null;
    } else {
      actualTextString = actualText.toString();
    }
    assertThat(actualTextString)
        .named("text")
        .isEqualTo(text);
    //noinspection unchecked
    return this;
  }
}
