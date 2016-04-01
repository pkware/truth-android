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
package com.pkware.truth.android.view.animation;

import android.view.animation.LayoutAnimationController;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

/**
 * Propositions for {@link LayoutAnimationController} subjects.
 * <p/>
 * This class is final. To extend use {@link LayoutAnimationController}.
 */
public final class LayoutAnimationControllerSubject extends
    AbstractLayoutAnimationControllerSubject<LayoutAnimationControllerSubject, LayoutAnimationController> {
  private LayoutAnimationControllerSubject(FailureStrategy failureStrategy, LayoutAnimationController subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<LayoutAnimationControllerSubject, LayoutAnimationController> type() {
    return new SubjectFactory<LayoutAnimationControllerSubject, LayoutAnimationController>() {
      @Override
      public LayoutAnimationControllerSubject getSubject(FailureStrategy fs, LayoutAnimationController that) {
        return new LayoutAnimationControllerSubject(fs, that);
      }
    };
  }
}
