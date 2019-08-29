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
package com.pkware.truth.android.material.tabs;

import android.graphics.drawable.Drawable;

import com.google.android.material.tabs.TabLayout;
import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link TabLayout.Tab} subjects.
 */
public class TabLayoutTabSubject extends Subject {

  @Nullable
  private final TabLayout.Tab actual;

  public TabLayoutTabSubject(@Nonnull FailureMetadata failureMetadata, @Nullable TabLayout.Tab actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasContentDescription(String contentDescription) {
    CharSequence actualContentDescription = actual.getContentDescription();
    String contentDescriptionString;
    if (actualContentDescription == null) {
      contentDescriptionString = null;
    } else {
      contentDescriptionString = actualContentDescription.toString();
    }
    check("getContentDescription()").that(contentDescriptionString).isEqualTo(contentDescription);
  }

  public void hasIcon(@Nullable Drawable icon) {
    check("getIcon()").that(actual.getIcon()).isSameInstanceAs(icon);
  }

  public void hasPosition(int position) {
    check("getPosition()").that(actual.getPosition()).isEqualTo(position);
    //noinspection unchecked

  }

  public void hasText(@Nullable String text) {
    CharSequence actualText = actual.getText();
    String actualTextString;
    if (actualText == null) {
      actualTextString = null;
    } else {
      actualTextString = actualText.toString();
    }
    check("getText()").that(actualTextString).isEqualTo(text);
  }
}
