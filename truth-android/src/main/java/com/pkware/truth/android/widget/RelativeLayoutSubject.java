/*
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

import android.widget.RelativeLayout;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

/**
 * Propositions for {@link RelativeLayout} subjects.
 * <p/>
 * This class is final. To extend use {@link AbstractRelativeLayoutSubject}.
 */
public final class RelativeLayoutSubject extends AbstractRelativeLayoutSubject<RelativeLayoutSubject, RelativeLayout> {
  private RelativeLayoutSubject(FailureStrategy failureStrategy, RelativeLayout subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<RelativeLayoutSubject, RelativeLayout> type() {
    return new SubjectFactory<RelativeLayoutSubject, RelativeLayout>() {
      @Override
      public RelativeLayoutSubject getSubject(FailureStrategy fs, RelativeLayout that) {
        return new RelativeLayoutSubject(fs, that);
      }
    };
  }
}
