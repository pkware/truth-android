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
package com.pkware.truth.android.graphics;

import android.graphics.Paint;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;

/**
 * Propositions for {@link Paint} instances.
 * <p/>
 * This class is final. To extend use {@link AbstractPaintSubject}.
 */
public final class PaintSubject extends AbstractPaintSubject<PaintSubject, Paint> {
  protected PaintSubject(FailureStrategy failureStrategy, Paint subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<PaintSubject, Paint> type() {
    return new SubjectFactory<PaintSubject, Paint>() {
      @Override
      public PaintSubject getSubject(FailureStrategy fs, Paint that) {
        return new PaintSubject(fs, that);
      }
    };
  }
}
