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

import android.annotation.TargetApi;
import android.view.InputEvent;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.os.Build.VERSION_CODES.JELLY_BEAN;

public abstract class AbstractInputEventSubject<T extends InputEvent> extends Subject {

  @Nullable
  private final T actual;

  protected AbstractInputEventSubject(@Nonnull FailureMetadata failureMetadata, @Nullable T actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasDeviceId(int id) {
    check("getDeviceId()").that(actual.getDeviceId()).isEqualTo(id);
  }

  @TargetApi(JELLY_BEAN)
  public void hasEventTime(long time) {
    check("getEventTime()").that(actual.getEventTime()).isEqualTo(time);
  }

  public void hasSource(int source) {
    check("getSource()").that(actual.getSource()).isEqualTo(source);
  }
}
