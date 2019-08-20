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

import android.view.KeyEvent;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link KeyEvent} subjects.
 */
public class KeyEventSubject extends Subject {

  @Nullable
  private final KeyEvent actual;

  public KeyEventSubject(@Nonnull FailureMetadata failureMetadata, @Nullable KeyEvent actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public KeyEventSubject hasAction(int action) {
    check("getAction()").that(actual.getAction()).isEqualTo(action);
    return this;
  }

  public KeyEventSubject hasDisplayLabel(char label) {
    check("getDisplayLabel()").that(actual.getDisplayLabel()).isEqualTo(label);
    return this;
  }

  public KeyEventSubject hasDownTime(long time) {
    check("getDownTime()").that(actual.getDownTime()).isEqualTo(time);
    return this;
  }

  public KeyEventSubject hasKeyCode(int keyCode) {
    check("getKeyCode()").that(actual.getKeyCode()).isEqualTo(keyCode);
    return this;
  }

  public KeyEventSubject hasRepeatCount(int count) {
    check("getRepeatCount()").that(actual.getRepeatCount()).isEqualTo(count);
    return this;
  }

  public KeyEventSubject hasSource(int source) {
    check("getSource()").that(actual.getSource()).isEqualTo(source);
    return this;
  }

  public KeyEventSubject hasModifiers(int modifiers) {
    check("hasModifiers(modifiers)").that(actual.hasModifiers(modifiers)).isTrue();
    return this;
  }

  public KeyEventSubject hasNoModifiers() {
    check("hasNoModifiers()").that(actual.hasNoModifiers()).isTrue();
    return this;
  }
}
