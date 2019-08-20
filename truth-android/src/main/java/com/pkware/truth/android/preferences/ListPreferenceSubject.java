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

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;
import com.google.common.truth.FailureMetadata;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link ListPreference} subjects.
 */
public class ListPreferenceSubject extends AbstractDialogPreferenceSubject<ListPreferenceSubject, ListPreference> {
  public ListPreferenceSubject(FailureMetadata failureMetadata, ListPreference subject) {
    super(failureMetadata, subject);
  }

  public ListPreferenceSubject hasEntries(String... entries) {

    // We convert to Strings b/c most of the time we are interested in the text content
    String[] actualEntries = FluentIterable.from(actual().getEntries())
        .transform(mapToString())
        .toArray(String.class);

    assertThat(actualEntries)
        .named("entries")
        .isEqualTo(entries);
    return this;
  }

  public ListPreferenceSubject hasEntry(CharSequence entry) {
    assertThat(actual().getEntry())
        .named("entry")
        .isEqualTo(entry);
    return this;
  }

  public ListPreferenceSubject hasEntry(@StringRes int resId) {
    return hasEntry(actual().getContext().getString(resId));
  }

  public ListPreferenceSubject hasEntryValues(String... values) {

    // We convert to Strings b/c most of the time we are interested in the text content
    String[] actualValues = FluentIterable.from(actual().getEntryValues())
        .transform(mapToString())
        .toArray(String.class);

    assertThat(actualValues)
        .named("entry values")
        .isEqualTo(values);
    return this;
  }

  public ListPreferenceSubject hasValue(String value) {
    assertThat(actual().getValue())
        .named("value")
        .isEqualTo(value);
    return this;
  }

  private Function<CharSequence, String> mapToString() {
    return CharSequence::toString;
  }
}
