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
package com.pkware.truth.android.view;

import android.view.ViewGroup;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

/**
 * Propositions for {@link android.view.ViewGroup.MarginLayoutParams} subjects.
 * <p/>
 * This class is final. To extend use {@link AbstractViewGroupMarginLayoutParamsSubject}.
 */
public final class ViewGroupMarginLayoutParamsSubject extends AbstractViewGroupMarginLayoutParamsSubject<ViewGroupMarginLayoutParamsSubject, ViewGroup.MarginLayoutParams> {
  private ViewGroupMarginLayoutParamsSubject(FailureStrategy failureStrategy, ViewGroup.MarginLayoutParams subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<ViewGroupMarginLayoutParamsSubject, ViewGroup.MarginLayoutParams> type() {
    return new SubjectFactory<ViewGroupMarginLayoutParamsSubject, ViewGroup.MarginLayoutParams>() {
      @Override
      public ViewGroupMarginLayoutParamsSubject getSubject(FailureStrategy fs, ViewGroup.MarginLayoutParams that) {
        return new ViewGroupMarginLayoutParamsSubject(fs, that);
      }
    };
  }
}
