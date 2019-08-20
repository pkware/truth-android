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
package com.pkware.truth.android.database;

import android.database.AbstractCursor;
import android.net.Uri;
import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import static com.pkware.truth.android.Assertions.assertThat;

public abstract class AbstractAbstractCursorSubject<S extends AbstractAbstractCursorSubject<S, T>, T extends AbstractCursor> extends Subject<S, T> {
  protected AbstractAbstractCursorSubject(FailureMetadata failureMetadata, T subject) {
    super(failureMetadata, subject);
  }

  public S hasNotificationUri(Uri uri) {
    assertThat(uri)
        .named("notification uri")
        .isEqualTo(uri);
    //noinspection unchecked
    return (S) this;
  }
}
