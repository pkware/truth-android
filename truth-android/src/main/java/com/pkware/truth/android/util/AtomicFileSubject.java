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
package com.pkware.truth.android.util;

import android.annotation.TargetApi;
import android.util.AtomicFile;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import java.io.File;

import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR1;
import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link AtomicFile} subjects.
 */
@TargetApi(JELLY_BEAN_MR1)
public class AtomicFileSubject extends Subject<AtomicFileSubject, AtomicFile> {
  protected AtomicFileSubject(FailureMetadata failureMetadata, AtomicFile subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<AtomicFileSubject, AtomicFile> type() {
    return new Subject.Factory<AtomicFileSubject, AtomicFile>() {
      @Override
      public AtomicFileSubject createSubject(FailureMetadata fm, AtomicFile that) {
        return new AtomicFileSubject(fm, that);
      }
    };
  }

  public AtomicFileSubject hasBaseFile(File file) {
    assertThat(actual().getBaseFile())
        .named("base file")
        .isEqualTo(file);
    return this;
  }
}
