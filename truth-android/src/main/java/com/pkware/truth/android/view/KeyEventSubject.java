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

  public void hasAction(int action) {
    check("getAction()").that(actual.getAction()).isEqualTo(action);
  }

  public void hasDisplayLabel(char label) {
    check("getDisplayLabel()").that(actual.getDisplayLabel()).isEqualTo(label);
  }

  public void hasDownTime(long time) {
    check("getDownTime()").that(actual.getDownTime()).isEqualTo(time);
  }

  public void hasKeyCode(int keyCode) {
    check("getKeyCode()").that(actual.getKeyCode()).isEqualTo(keyCode);
  }

  public void hasRepeatCount(int count) {
    check("getRepeatCount()").that(actual.getRepeatCount()).isEqualTo(count);
  }

  public void hasSource(int source) {
    check("getSource()").that(actual.getSource()).isEqualTo(source);
  }

  public void hasModifiers(int modifiers) {
    check("hasModifiers(modifiers)").that(actual.hasModifiers(modifiers)).isTrue();
  }

  public void hasNoModifiers() {
    check("hasNoModifiers()").that(actual.hasNoModifiers()).isTrue();
  }
}
