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
package com.pkware.truth.android.widget;

import android.widget.ListAdapter;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

/**
 * Proposition for {@link ListAdapter} subjects.
 * <p/>
 * This class is final. To extend use {@link AbstractListAdapterSubject}.
 */
public class ListAdapterSubject extends AbstractListAdapterSubject<ListAdapterSubject, ListAdapter> {
  private ListAdapterSubject(FailureMetadata failureMetadata, ListAdapter subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<ListAdapterSubject, ListAdapter> type() {
    return new Subject.Factory<ListAdapterSubject, ListAdapter>() {
      @Override
      public ListAdapterSubject createSubject(FailureMetadata fm, ListAdapter that) {
        return new ListAdapterSubject(fm, that);
      }
    };
  }
}
