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
package com.pkware.truth.androidx.core.util;

import androidx.core.util.AtomicFile;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import java.io.File;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link AtomicFile} subjects.
 */
public class AtomicFileSubject extends Subject {

  @Nullable
  private final AtomicFile actual;

  public AtomicFileSubject(@Nonnull FailureMetadata failureMetadata, @Nullable AtomicFile actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasBaseFile(@Nullable File file) {
    check("getBaseFile()").that(actual.getBaseFile()).isEqualTo(file);
  }
}
