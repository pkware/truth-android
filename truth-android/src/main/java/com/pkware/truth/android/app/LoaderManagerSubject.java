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
package com.pkware.truth.android.app;

import android.app.LoaderManager;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link LoaderManager} subjects.
 */
public class LoaderManagerSubject extends Subject {

  @Nullable
  private final LoaderManager actual;

  public LoaderManagerSubject(@Nonnull FailureMetadata failureMetadata, @Nullable LoaderManager actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public LoaderManagerSubject hasLoader(int id) {
    check("getLoader(id)")
        .withMessage("Has loader with id <%s>", id)
        .that(actual.getLoader(id))
        .isNotNull();
    return this;
  }
}
