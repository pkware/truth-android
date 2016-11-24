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

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

/**
 * Proposition for {@link ListAdapter} subjects.
 * <p/>
 * This class is final. To extend use {@link AbstractListAdapterSubject}.
 */
public class ListAdapterSubject extends AbstractListAdapterSubject<ListAdapterSubject, ListAdapter> {
  private ListAdapterSubject(FailureStrategy failureStrategy, ListAdapter subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<ListAdapterSubject, ListAdapter> type() {
    return new SubjectFactory<ListAdapterSubject, ListAdapter>() {
      @Override
      public ListAdapterSubject getSubject(FailureStrategy fs, ListAdapter that) {
        return new ListAdapterSubject(fs, that);
      }
    };
  }
}
