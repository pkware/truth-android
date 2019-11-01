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
package com.pkware.truth.androidx.loader.content;

import android.net.Uri;

import androidx.loader.content.CursorLoader;

import com.google.common.truth.FailureMetadata;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link CursorLoader} subjects.
 */
public class CursorLoaderSubject extends AbstractLoaderSubject<CursorLoader> {

  @Nullable
  private final CursorLoader actual;

  public CursorLoaderSubject(@Nonnull FailureMetadata failureMetadata, @Nullable CursorLoader actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasProjection(@Nonnull String... projection) {
    check("getProjection()").that(actual.getProjection()).asList().containsExactlyElementsIn(projection).inOrder();
  }

  public void doesNotHaveProjection() {
    String[] projection = actual.getProjection();
    if (projection == null) {
      projection = new String[0];
    }
    check("getProjection()").that(projection).isEmpty();
  }

  public void projectionContains(@Nonnull String... projection) {
    check("getProjection()").that(actual.getProjection()).asList().containsAtLeastElementsIn(projection);
  }

  public void hasSelection(@Nullable String selection) {
    check("getSelection()").that(actual.getSelection()).isEqualTo(selection);
  }

  public void doesNotHaveSelection() {
    String selection = actual.getSelection();
    if (selection == null) {
      selection = "";
    }
    check("getSelection()").that(selection).isEmpty();
  }

  public void hasSelectionArgs(@Nonnull String... selectionArgs) {
    check("getSelectionArgs()").that(actual.getSelectionArgs()).asList().containsExactlyElementsIn(selectionArgs);
  }

  public void doesNotHaveSelectionArgs() {
    String[] selectionArgs = actual.getSelectionArgs();
    if (selectionArgs == null) {
      selectionArgs = new String[0];
    }
    check("getSelectionArgs()").that(selectionArgs).isEmpty();
  }

  public void containsSelectionArgs(@Nonnull String... selectionArgs) {
    check("getSelectionArgs()")
        .that(actual.getSelectionArgs())
        .asList()
        .containsAtLeastElementsIn(selectionArgs);
  }

  public void hasSortOrder(@Nullable String sortOrder) {
    check("getSortOrder()").that(actual.getSortOrder()).isEqualTo(sortOrder);
  }

  public void doesNotHaveSortOrder() {
    String sortOrder = actual.getSortOrder();
    if (sortOrder == null) {
      sortOrder = "";
    }
    check("getSortOrder()").that(sortOrder).isEmpty();
  }

  public void hasUri(@Nullable Uri uri) {
    check("getUri()").that(actual.getUri()).isEqualTo(uri);
  }
}
