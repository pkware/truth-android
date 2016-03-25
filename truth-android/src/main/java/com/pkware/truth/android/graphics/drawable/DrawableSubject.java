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
package com.pkware.truth.android.graphics.drawable;

import android.graphics.drawable.Drawable;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

/**
 * Propositions for {@link Drawable} subjects.
 * <p/>
 * This class is final. To extend use {@link AbstractDrawableSubject}.
 */
public final class DrawableSubject extends AbstractDrawableSubject<DrawableSubject, Drawable> {
  protected DrawableSubject(FailureStrategy failureStrategy, Drawable subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<DrawableSubject, Drawable> type() {
    return new SubjectFactory<DrawableSubject, Drawable>() {
      @Override
      public DrawableSubject getSubject(FailureStrategy fs, Drawable that) {
        return new DrawableSubject(fs, that);
      }
    };
  }
}
