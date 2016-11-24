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

import android.view.DragEvent;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static android.view.DragEvent.ACTION_DRAG_ENDED;
import static android.view.DragEvent.ACTION_DRAG_ENTERED;
import static android.view.DragEvent.ACTION_DRAG_EXITED;
import static android.view.DragEvent.ACTION_DRAG_LOCATION;
import static android.view.DragEvent.ACTION_DRAG_STARTED;
import static android.view.DragEvent.ACTION_DROP;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assert_;
import static com.pkware.truth.android.internal.IntegerUtils.buildNamedValueString;

/**
 * Propositions for {@link DragEvent} subjects.
 */
public class DragEventSubject extends Subject<DragEventSubject, DragEvent> {
  protected DragEventSubject(FailureStrategy failureStrategy, DragEvent subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<DragEventSubject, DragEvent> type() {
    return new SubjectFactory<DragEventSubject, DragEvent>() {
      @Override
      public DragEventSubject getSubject(FailureStrategy fs, DragEvent that) {
        return new DragEventSubject(fs, that);
      }
    };
  }

  public static String dragEventActionToString(@DragEventAction int action) {
    return buildNamedValueString(action)
        .value(ACTION_DRAG_ENDED, "drag ended")
        .value(ACTION_DRAG_ENTERED, "drag entered")
        .value(ACTION_DRAG_EXITED, "drag exited")
        .value(ACTION_DRAG_LOCATION, "drag location")
        .value(ACTION_DRAG_STARTED, "drag started")
        .value(ACTION_DROP, "drop")
        .get();
  }

  public DragEventSubject hasAction(@DragEventAction int action) {
    int actualAction = actual().getAction();
    //noinspection ResourceType
    assert_()
        .withFailureMessage("Expected action <%s> but was <%s>",
            dragEventActionToString(action), dragEventActionToString(actualAction))
        .that(actualAction)
        .isEqualTo(action);
    return this;
  }

  public DragEventSubject hasLocalState(Object localState) {
    assertThat(actual().getLocalState())
        .named("local state")
        .isEqualTo(localState);
    return this;
  }

  public DragEventSubject hasSuccessfulResult() {
    assertThat(actual().getResult())
        .named("has successful result")
        .isTrue();
    return this;
  }

  public DragEventSubject hasUnsuccessfulResult() {
    assertThat(actual().getResult())
        .named("has successful result")
        .isFalse();
    return this;
  }

  public DragEventSubject hasX(float x, float tolerance) {
    assertThat(actual().getX())
        .named("X")
        .isWithin(tolerance)
        .of(x);
    return this;
  }

  public DragEventSubject hasY(float y, float tolerance) {
    assertThat(actual().getY())
        .named("Y")
        .isWithin(tolerance)
        .of(y);
    return this;
  }
}
