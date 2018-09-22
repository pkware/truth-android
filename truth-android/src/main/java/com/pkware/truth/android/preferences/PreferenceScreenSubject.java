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

import android.app.Dialog;
import android.preference.PreferenceScreen;
import android.widget.ListAdapter;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link PreferenceScreen} subjects.
 */
public class PreferenceScreenSubject extends AbstractPreferenceGroupSubject<PreferenceScreenSubject, PreferenceScreen> {
  protected PreferenceScreenSubject(FailureMetadata failureMetadata, PreferenceScreen subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<PreferenceScreenSubject, PreferenceScreen> type() {
    return new Subject.Factory<PreferenceScreenSubject, PreferenceScreen>() {
      @Override
      public PreferenceScreenSubject createSubject(FailureMetadata fm, PreferenceScreen that) {
        return new PreferenceScreenSubject(fm, that);
      }
    };
  }

  public PreferenceScreenSubject hasDialog(Dialog dialog) {
    assertThat(actual().getDialog())
        .named("dialog")
        .isSameAs(dialog);
    return this;
  }

  public PreferenceScreenSubject hasRootAdapter(ListAdapter adapter) {
    assertThat(actual().getRootAdapter())
        .named("root adapter")
        .isSameAs(adapter);
    return this;
  }
}
