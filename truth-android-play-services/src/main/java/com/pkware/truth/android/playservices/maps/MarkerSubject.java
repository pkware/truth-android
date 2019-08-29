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
package com.pkware.truth.android.playservices.maps;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link Marker} subjects.
 */
public class MarkerSubject extends Subject {

  @Nullable
  private final Marker actual;

  public MarkerSubject(@Nonnull FailureMetadata failureMetadata, @Nullable Marker actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasAlpha(float alpha, float tolerance) {
    check("getAlpha()").that(actual.getAlpha()).isWithin(tolerance).of(alpha);
  }

  public void hasId(@Nullable String id) {
    check("getId()").that(actual.getId()).isEqualTo(id);
  }

  public void hasPosition(@Nullable LatLng position) {
    check("getPosition()").that(actual.getPosition()).isEqualTo(position);
  }

  public void hasRotation(float rotation, float tolerance) {
    check("getRotation()").that(actual.getRotation()).isWithin(tolerance).of(rotation);
  }

  public void hasSnippet(@Nullable String snippet) {
    check("getSnippet()").that(actual.getSnippet()).isEqualTo(snippet);
  }

  public void hasTitle(@Nullable String title) {
    check("getTitle()").that(actual.getTitle()).isEqualTo(title);
  }

  public void isDraggable() {
    check("isDraggable()").that(actual.isDraggable()).isTrue();
  }

  public void isNotDraggable() {
    check("isDraggable()").that(actual.isDraggable()).isFalse();
  }

  public void isFlat() {
    check("isFlat()").that(actual.isFlat()).isTrue();
  }

  public void isNotFlat() {
    check("isFlat()").that(actual.isFlat()).isFalse();
  }

  public void hasInfoWindowShown() {
    check("isInfoWindowShown()").that(actual.isInfoWindowShown()).isTrue();
  }

  public void hasInfoWindowNotShown() {
    check("isInfoWindowShown()").that(actual.isInfoWindowShown()).isFalse();
  }

  public void isVisible() {
    check("isVisible()").that(actual.isVisible()).isTrue();
  }

  public void isNotVisible() {
    check("isVisible()").that(actual.isVisible()).isFalse();
  }
}
