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

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link KeyEvent} subjects.
 */
public class KeyEventSubject extends Subject<KeyEventSubject, KeyEvent> {
  protected KeyEventSubject(FailureStrategy failureStrategy, KeyEvent subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<KeyEventSubject, KeyEvent> type() {
    return new SubjectFactory<KeyEventSubject, KeyEvent>() {
      @Override
      public KeyEventSubject getSubject(FailureStrategy fs, KeyEvent that) {
        return new KeyEventSubject(fs, that);
      }
    };
  }

  public KeyEventSubject hasAction(int action) {
    assertThat(actual().getAction())
        .named("action")
        .isEqualTo(action);
    return this;
  }

  public KeyEventSubject hasDisplayLabel(char label) {
    assertThat(actual().getDisplayLabel())
        .named("label")
        .isEqualTo(label);
    return this;
  }

  public KeyEventSubject hasDownTime(long time) {
    assertThat(actual().getDownTime())
        .named("time")
        .isEqualTo(time);
    return this;
  }

  public KeyEventSubject hasKeyCode(int keyCode) {
    assertThat(actual().getKeyCode())
        .named("key code")
        .isEqualTo(keyCode);
    return this;
  }

  public KeyEventSubject hasRepeatCount(int count) {
    assertThat(actual().getRepeatCount())
        .named("repeat count")
        .isEqualTo(count);
    return this;
  }

  public KeyEventSubject hasSource(int source) {
    assertThat(actual().getSource())
        .named("source")
        .isEqualTo(source);
    return this;
  }

  public KeyEventSubject hasModifiers(int modifiers) {
    assertThat(actual().hasModifiers(modifiers))
        .named("modifiers")
        .isTrue();
    return this;
  }

  public KeyEventSubject hasNoModifiers() {
    assertThat(actual().hasNoModifiers())
        .named("has no modifiers")
        .isTrue();
    return this;
  }

  // TODO all the 'is' methods
}
