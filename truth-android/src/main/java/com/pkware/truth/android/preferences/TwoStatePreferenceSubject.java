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

import android.preference.TwoStatePreference;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

/**
 * Propositions for {@link android.preference.TwoStatePreference} subjects.
 * <p/>
 * This class is final. To extend use {@link AbstractTwoStatePreferenceSubject}.
 */
public final class TwoStatePreferenceSubject
    extends AbstractTwoStatePreferenceSubject<TwoStatePreferenceSubject, TwoStatePreference> {
  private TwoStatePreferenceSubject(FailureMetadata failureMetadata, TwoStatePreference subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<TwoStatePreferenceSubject, TwoStatePreference> type() {
    return new Subject.Factory<TwoStatePreferenceSubject, TwoStatePreference>() {
      @Override
      public TwoStatePreferenceSubject createSubject(FailureMetadata fm, TwoStatePreference that) {
        return new TwoStatePreferenceSubject(fm, that);
      }
    };
  }
}
