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
package com.pkware.truth.android.view;

import android.view.KeyCharacterMap;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.view.KeyCharacterMap.ALPHA;
import static android.view.KeyCharacterMap.FULL;
import static android.view.KeyCharacterMap.NUMERIC;
import static android.view.KeyCharacterMap.PREDICTIVE;
import static android.view.KeyCharacterMap.SPECIAL_FUNCTION;
import static com.pkware.truth.android.internal.IntegerUtils.buildNamedValueString;

/**
 * Propositions for {@link KeyCharacterMap} subjects.
 */
public class KeyCharacterMapSubject extends Subject {

  @Nullable
  private final KeyCharacterMap actual;

  public KeyCharacterMapSubject(@Nonnull FailureMetadata failureMetadata, @Nullable KeyCharacterMap actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  @Nonnull
  public static String keyboardTypeToString(@KeyCharacterMapKeyboardType int type) {
    return buildNamedValueString(type)
        .value(NUMERIC, "numeric")
        .value(PREDICTIVE, "predictive")
        .value(ALPHA, "alpha")
        .value(FULL, "full")
        .value(SPECIAL_FUNCTION, "specialFunction")
        .get();
  }

  public void hasKeyboardType(@KeyCharacterMapKeyboardType int type) {
    int actualType = actual.getKeyboardType();
    //noinspection ResourceType
    check("getKeyboardType()")
        .withMessage("Expected keyboard type <%s> but was <%s>.",
            keyboardTypeToString(type), keyboardTypeToString(actualType))
        .that(actualType)
        .isEqualTo(type);
  }

  public void hasModifierBehavior(int value) {
    check("getModifierBehavior()").that(actual.getModifierBehavior()).isEqualTo(value);
  }
}
