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
package com.pkware.truth.android.recyclerview.v7.widget;

import android.support.v7.widget.RecyclerView;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link RecyclerView.LayoutParams} subjects.
 */
public class RecyclerViewLayoutParamsSubject
    extends Subject<RecyclerViewLayoutParamsSubject, RecyclerView.LayoutParams> {

  protected RecyclerViewLayoutParamsSubject(FailureStrategy failureStrategy, RecyclerView.LayoutParams subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<RecyclerViewLayoutParamsSubject, RecyclerView.LayoutParams> type() {
    return new SubjectFactory<RecyclerViewLayoutParamsSubject, RecyclerView.LayoutParams>() {
      @Override
      public RecyclerViewLayoutParamsSubject getSubject(FailureStrategy fs, RecyclerView.LayoutParams that) {
        return new RecyclerViewLayoutParamsSubject(fs, that);
      }
    };
  }

  public RecyclerViewLayoutParamsSubject viewNeedsUpdate() {
    assertThat(getSubject().viewNeedsUpdate())
        .named("view needs update")
        .isTrue();
    return this;
  }

  public RecyclerViewLayoutParamsSubject viewDoesNotNeedUpdate() {
    assertThat(getSubject().viewNeedsUpdate())
        .named("view needs update")
        .isFalse();
    return this;
  }

  public RecyclerViewLayoutParamsSubject isViewInvalid() {
    assertThat(getSubject().isViewInvalid())
        .named("is view invalid")
        .isTrue();
    return this;
  }

  public RecyclerViewLayoutParamsSubject isViewValid() {
    assertThat(getSubject().isViewInvalid())
        .named("is view invalid")
        .isFalse();
    return this;
  }

  public RecyclerViewLayoutParamsSubject isItemRemoved() {
    assertThat(getSubject().isItemRemoved())
        .named("is item removed")
        .isTrue();
    return this;
  }

  public RecyclerViewLayoutParamsSubject isItemNotRemoved() {
    assertThat(getSubject().isItemRemoved())
        .named("is item removed")
        .isFalse();
    return this;
  }

  public RecyclerViewLayoutParamsSubject hasViewPosition(int position) {
    assertThat(getSubject().getViewPosition())
        .named("view position")
        .isEqualTo(position);
    return this;
  }
}
