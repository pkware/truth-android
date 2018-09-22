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

import android.widget.WrapperListAdapter;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

/**
 * Propositions for {@link WrapperListAdapter} subjects.
 * <p/>
 * This class is final. To extend use {@link AbstractWrapperListAdapterSubject}.
 */
public final class WrapperListAdapterSubject
    extends AbstractWrapperListAdapterSubject<WrapperListAdapterSubject, WrapperListAdapter> {
  protected WrapperListAdapterSubject(FailureMetadata failureMetadata, WrapperListAdapter subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<WrapperListAdapterSubject, WrapperListAdapter> type() {
    return new Subject.Factory<WrapperListAdapterSubject, WrapperListAdapter>() {
      @Override
      public WrapperListAdapterSubject createSubject(FailureMetadata fm, WrapperListAdapter that) {
        return new WrapperListAdapterSubject(fm, that);
      }
    };
  }
}
