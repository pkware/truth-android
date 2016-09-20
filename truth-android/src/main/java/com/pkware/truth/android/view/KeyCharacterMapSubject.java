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
package com.pkware.truth.android.view;

import android.view.KeyCharacterMap;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static android.view.KeyCharacterMap.ALPHA;
import static android.view.KeyCharacterMap.FULL;
import static android.view.KeyCharacterMap.NUMERIC;
import static android.view.KeyCharacterMap.PREDICTIVE;
import static android.view.KeyCharacterMap.SPECIAL_FUNCTION;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assert_;
import static com.pkware.truth.android.internal.IntegerUtils.buildNamedValueString;

/**
 * Propositions for {@link KeyCharacterMap} subjects.
 */
public class KeyCharacterMapSubject extends Subject<KeyCharacterMapSubject, KeyCharacterMap> {
  protected KeyCharacterMapSubject(FailureStrategy failureStrategy, KeyCharacterMap subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<KeyCharacterMapSubject, KeyCharacterMap> type() {
    return new SubjectFactory<KeyCharacterMapSubject, KeyCharacterMap>() {
      @Override
      public KeyCharacterMapSubject getSubject(FailureStrategy fs, KeyCharacterMap that) {
        return new KeyCharacterMapSubject(fs, that);
      }
    };
  }

  public static String keyboardTypeToString(@KeyCharacterMapKeyboardType int type) {
    return buildNamedValueString(type)
        .value(NUMERIC, "numeric")
        .value(PREDICTIVE, "predictive")
        .value(ALPHA, "alpha")
        .value(FULL, "full")
        .value(SPECIAL_FUNCTION, "specialFunction")
        .get();
  }

  public KeyCharacterMapSubject hasKeyboardType(@KeyCharacterMapKeyboardType int type) {
    int actualType = actual().getKeyboardType();
    //noinspection ResourceType
    assert_()
        .withFailureMessage("Expected keyboard type <%s> but was <%s>.",
            keyboardTypeToString(type), keyboardTypeToString(actualType))
        .that(actualType)
        .isEqualTo(type);
    return this;
  }

  public KeyCharacterMapSubject hasModifierBehavior(int value) {
    assertThat(actual().getModifierBehavior())
        .named("modifier behavior")
        .isEqualTo(value);
    return this;
  }
}
