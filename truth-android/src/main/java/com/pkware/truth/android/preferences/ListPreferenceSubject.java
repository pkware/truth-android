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
package com.pkware.truth.android.preferences;

import android.preference.ListPreference;

import androidx.annotation.StringRes;

import com.google.common.collect.FluentIterable;
import com.google.common.truth.FailureMetadata;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link ListPreference} subjects.
 */
public class ListPreferenceSubject extends AbstractDialogPreferenceSubject<ListPreference> {

  @Nullable
  private ListPreference actual;

  public ListPreferenceSubject(@Nonnull FailureMetadata failureMetadata, @Nullable ListPreference actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasEntries(@Nonnull String... entries) {
    // We convert to Strings b/c most of the time we are interested in the text content
    FluentIterable<String> actualValues = FluentIterable.from(actual.getEntries())
        .transform(CharSequence::toString);

    check("getEntries()")
        .withMessage("Entries as strings")
        .that(actualValues)
        .containsExactlyElementsIn(entries)
        .inOrder();
  }

  public void hasEntry(@Nullable CharSequence entry) {
    check("getEntry()").that(actual.getEntry()).isEqualTo(entry);
  }

  public void hasEntry(@StringRes int resId) {
    hasEntry(actual.getContext().getString(resId));
  }

  public void hasEntryValues(@Nonnull String... values) {
    // We convert to Strings b/c most of the time we are interested in the text content
    FluentIterable<String> actualValues = FluentIterable.from(actual.getEntryValues())
        .transform(CharSequence::toString);

    check("getEntryValues()")
        .withMessage("Entry values as strings")
        .that(actualValues)
        .containsExactlyElementsIn(values)
        .inOrder();
  }

  public void hasValue(@Nullable String value) {
    check("getValue()").that(actual.getValue()).isEqualTo(value);
  }
}
