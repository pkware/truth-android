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
package com.pkware.truth.android.preferences;

import android.preference.MultiSelectListPreference;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

import java.util.Arrays;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link MultiSelectListPreference} subjects.
 */
public class MultiSelectListPreferenceSubject extends
    AbstractDialogPreferenceSubject<MultiSelectListPreferenceSubject, MultiSelectListPreference> {
  protected MultiSelectListPreferenceSubject(FailureStrategy failureStrategy, MultiSelectListPreference subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<MultiSelectListPreferenceSubject, MultiSelectListPreference> type() {
    return new SubjectFactory<MultiSelectListPreferenceSubject, MultiSelectListPreference>() {
      @Override
      public MultiSelectListPreferenceSubject getSubject(FailureStrategy fs, MultiSelectListPreference that) {
        return new MultiSelectListPreferenceSubject(fs, that);
      }
    };
  }

  public MultiSelectListPreferenceSubject hasEntries(String... entries) {

    // We convert to Strings b/c most of the time we are interested in the text content
    String[] actualEntries = FluentIterable.of(actual().getEntries())
        .transform(mapToString())
        .toArray(String.class);

    assertThat(actualEntries)
        .named("entries")
        .isEqualTo(entries);
    return this;
  }

  public MultiSelectListPreferenceSubject hasEntryValues(String... values) {

    // We convert to Strings b/c most of the time we are interested in the text content
    String[] actualValues = FluentIterable.of(actual().getEntryValues())
        .transform(mapToString())
        .toArray(String.class);

    assertThat(actualValues)
        .named("entry values")
        .isEqualTo(values);
    return this;
  }

  public MultiSelectListPreferenceSubject hasValues(String... values) {
    assertThat(actual().getValues())
        .named("values")
        .containsExactlyElementsIn(Arrays.asList(values));
    return this;
  }

  private Function<CharSequence, String> mapToString() {
    return new Function<CharSequence, String>() {
      @Override
      public String apply(CharSequence input) {
        return input.toString();
      }
    };
  }
}
