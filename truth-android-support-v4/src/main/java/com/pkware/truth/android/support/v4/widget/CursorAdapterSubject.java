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
package com.pkware.truth.android.support.v4.widget;

import android.support.v4.widget.CursorAdapter;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

/**
 * Propositions for {@link CursorAdapter} subjects.
 * <p/>
 * This class is final. To extend use {@link AbstractCursorAdapterSubject}.
 */
public final class CursorAdapterSubject
    extends AbstractCursorAdapterSubject<CursorAdapterSubject, CursorAdapter> {
  protected CursorAdapterSubject(FailureMetadata failureMetadata, CursorAdapter subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<CursorAdapterSubject, CursorAdapter> type() {
    return new Subject.Factory<CursorAdapterSubject, CursorAdapter>() {
      @Override
      public CursorAdapterSubject createSubject(FailureMetadata fm, CursorAdapter that) {
        return new CursorAdapterSubject(fm, that);
      }
    };
  }
}
