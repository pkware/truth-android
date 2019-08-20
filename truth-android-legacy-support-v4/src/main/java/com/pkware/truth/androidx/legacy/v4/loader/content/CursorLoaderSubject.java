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
package com.pkware.truth.androidx.legacy.v4.loader.content;

import android.net.Uri;
import androidx.loader.content.CursorLoader;
import com.google.common.truth.FailureMetadata;

import java.util.Arrays;

import static com.google.common.truth.Truth.assertThat;
import static com.pkware.truth.android.Assertions.assertThat;

/**
 * Propositions for {@link CursorLoader} subjects.
 */
public class CursorLoaderSubject extends AbstractLoaderSubject<CursorLoaderSubject, CursorLoader> {
  public CursorLoaderSubject(FailureMetadata failureMetadata, CursorLoader subject) {
    super(failureMetadata, subject);
  }

  public CursorLoaderSubject hasProjection(String... projection) {
    assertThat(actual().getProjection())
        .named("projection")
        .isEqualTo(projection);
    return this;
  }

  public CursorLoaderSubject doesNotHaveProjection() {
    String[] projection = actual().getProjection();
    if (projection == null) {
      projection = new String[0];
    }
    assertThat(projection)
        .named("projection")
        .isEmpty();
    return this;
  }

  public CursorLoaderSubject projectionContains(String... projection) {
    assertThat(actual().getProjection())
        .asList()
        .named("projection")
        .contains(projection);
    return this;
  }

  public CursorLoaderSubject hasSelection(String selection) {
    assertThat(actual().getSelection())
        .named("selection")
        .isEqualTo(selection);
    return this;
  }

  public CursorLoaderSubject doesNotHaveSelection() {
    String selection = actual().getSelection();
    if (selection == null) {
      selection = "";
    }
    assertThat(selection)
        .named("selection")
        .isEmpty();
    return this;
  }

  public CursorLoaderSubject hasSelectionArgs(String... selectionArgs) {
    assertThat(actual().getSelectionArgs())
        .asList()
        .named("selection args")
        .containsExactlyElementsIn(Arrays.asList(selectionArgs));
    return this;
  }

  public CursorLoaderSubject doesNotHaveSelectionArgs() {
    String[] selectionArgs = actual().getSelectionArgs();
    if (selectionArgs == null) {
      selectionArgs = new String[0];
    }
    assertThat(selectionArgs)
        .named("selection args")
        .isEmpty();
    return this;
  }

  public CursorLoaderSubject containsSelectionArgs(String... selectionArgs) {
    assertThat(actual().getSelectionArgs())
        .asList()
        .named("selection args")
        .contains(selectionArgs);
    return this;
  }

  public CursorLoaderSubject hasSortOrder(String sortOrder) {
    assertThat(actual().getSortOrder())
        .named("sort order")
        .isEqualTo(sortOrder);
    return this;
  }

  public CursorLoaderSubject doesNotHaveSortOrder() {
    String sortOrder = actual().getSortOrder();
    if (sortOrder == null) {
      sortOrder = "";
    }
    assertThat(sortOrder)
        .named("sort order")
        .isEmpty();
    return this;
  }

  public CursorLoaderSubject hasUri(Uri uri) {
    assertThat(actual().getUri())
        .named("uri")
        .isEqualTo(uri);
    return this;
  }
}
