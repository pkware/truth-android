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
package com.pkware.truth.android.content;

import android.content.CursorLoader;
import android.net.Uri;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.SubjectFactory;
import com.pkware.truth.android.net.UriSubject;

import java.util.Arrays;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assert_;

/**
 * Propositions for {@link CursorLoader} subjects.
 */
public class CursorLoaderSubject extends AbstractLoaderSubject<CursorLoaderSubject, CursorLoader> {
  protected CursorLoaderSubject(FailureStrategy failureStrategy, CursorLoader subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<CursorLoaderSubject, CursorLoader> type() {
    return new SubjectFactory<CursorLoaderSubject, CursorLoader>() {
      @Override
      public CursorLoaderSubject getSubject(FailureStrategy fs, CursorLoader that) {
        return new CursorLoaderSubject(fs, that);
      }
    };
  }

  public CursorLoaderSubject hasProjection(String... projection) {
    assertThat(getSubject().getProjection())
        .asList()
        .named("projection")
        .containsExactlyElementsIn(Arrays.asList(projection));
    return this;
  }

  public CursorLoaderSubject doesNotHaveProjection() {
    String[] projection = getSubject().getProjection();
    if (projection == null) {
      projection = new String[0];
    }
    assertThat(projection)
        .named("projection")
        .isEmpty();
    return this;
  }

  public CursorLoaderSubject projectionContains(String... projection) {
    assertThat(getSubject().getProjection())
        .asList()
        .named("projection")
        .contains(projection);
    return this;
  }

  public CursorLoaderSubject hasSelection(String selection) {
    assertThat(getSubject().getSelection())
        .named("selection")
        .isEqualTo(selection);
    return this;
  }

  public CursorLoaderSubject doesNotHaveSelection() {
    String selection = getSubject().getSelection();
    if (selection == null) {
      selection = "";
    }
    assertThat(selection)
        .named("selection")
        .isEmpty();
    return this;
  }

  public CursorLoaderSubject hasSelectionArgs(String... selectionArgs) {
    assertThat(getSubject().getSelectionArgs())
        .asList()
        .named("selection args")
        .containsExactlyElementsIn(Arrays.asList(selectionArgs));
    return this;
  }

  public CursorLoaderSubject doesNotHaveSelectionArgs() {
    String[] selectionArgs = getSubject().getSelectionArgs();
    if (selectionArgs == null) {
      selectionArgs = new String[0];
    }
    assertThat(selectionArgs)
        .named("selection args")
        .isEmpty();
    return this;
  }

  public CursorLoaderSubject containsSelectionArgs(String... selectionArgs) {
    assertThat(getSubject().getSelectionArgs())
        .asList()
        .named("selection args")
        .contains(selectionArgs);
    return this;
  }

  public CursorLoaderSubject hasSortOrder(String sortOrder) {
    assertThat(getSubject().getSortOrder())
        .named("sort order")
        .isEqualTo(sortOrder);
    return this;
  }

  public CursorLoaderSubject doesNotHaveSortOrder() {
    String sortOrder = getSubject().getSortOrder();
    if (sortOrder == null) {
      sortOrder = "";
    }
    assertThat(sortOrder)
        .named("sort order")
        .isEmpty();
    return this;
  }

  public CursorLoaderSubject hasUri(Uri uri) {
    assert_().about(UriSubject.type())
        .that(getSubject().getUri())
        .named("uri")
        .isEqualTo(uri);
    return this;
  }
}
