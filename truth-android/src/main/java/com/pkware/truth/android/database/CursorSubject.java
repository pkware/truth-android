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

import android.database.Cursor;
import com.google.common.truth.FailureMetadata;

/**
 * Propositions for {@link Cursor} subjects.
 * <p/>
 * This class is final. To extend use {@link AbstractCursorSubject}.
 */
public final class CursorSubject extends AbstractCursorSubject<CursorSubject, Cursor> {
  public CursorSubject(FailureMetadata failureMetadata, Cursor subject) {
    super(failureMetadata, subject);
  }
}
