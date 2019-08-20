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

import com.google.android.material.tabs.TabLayout;
import com.google.common.truth.FailureMetadata;
import com.pkware.truth.android.widget.AbstractHorizontalScrollViewSubject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static com.pkware.truth.android.internal.IntegerUtils.buildNamedValueString;

/**
 * Propositions for {@link TabLayout} subjects.
 */
public class TabLayoutSubject extends AbstractHorizontalScrollViewSubject<TabLayout> {

  @Nullable
  private final TabLayout actual;

  public TabLayoutSubject(@Nonnull FailureMetadata failureMetadata, @Nullable TabLayout actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  @Nonnull
  public static String gravityToString(@TabGravity int gravity) {
    return buildNamedValueString(gravity)
        .value(TabLayout.GRAVITY_CENTER, "center")
        .value(TabLayout.GRAVITY_FILL, "fill")
        .get();
  }

  @Nonnull
  public static String modeToString(@TabMode int mode) {
    return buildNamedValueString(mode)
        .value(TabLayout.MODE_FIXED, "fixed")
        .value(TabLayout.MODE_SCROLLABLE, "scrollable")
        .get();
  }

  public TabLayoutSubject hasTabCount(int count) {
    check("getTabCount()").that(actual.getTabCount()).isEqualTo(count);
    return this;
  }

  public TabLayoutSubject hasTabGravity(@TabGravity int gravity) {
    int actualGravity = actual.getTabGravity();
    //noinspection ResourceType
    check("getTabGravity()")
        .withMessage("Expected tab gravity of <%s> but was <%s>.",
            gravityToString(gravity), gravityToString(actualGravity))
        .that(actualGravity)
        .isEqualTo(gravity);
    return this;
  }

  public TabLayoutSubject hasTabMode(@TabMode int mode) {
    int actualMode = actual.getTabMode();
    //noinspection ResourceType
    check("getTabMode()")
        .withMessage("Expected tab mode of <%s> but was <%s>.", modeToString(mode),
            modeToString(actualMode))
        .that(actualMode)
        .isEqualTo(mode);
    return this;
  }

  public TabLayoutSubject hasFixedTabs() {
    return hasTabMode(TabLayout.MODE_FIXED);
  }

  public TabLayoutSubject hasScrollingTabs() {
    return hasTabMode(TabLayout.MODE_SCROLLABLE);
  }
}
