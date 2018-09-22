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

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link Marker} subjects.
 */
public class MarkerSubject extends Subject<MarkerSubject, Marker> {
  protected MarkerSubject(FailureMetadata failureMetadata, Marker subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<MarkerSubject, Marker> type() {
    return new Subject.Factory<MarkerSubject, Marker>() {
      @Override
      public MarkerSubject createSubject(FailureMetadata fm, Marker that) {
        return new MarkerSubject(fm, that);
      }
    };
  }

  public MarkerSubject hasAlpha(float alpha, float tolerance) {
    assertThat(actual().getAlpha())
        .named("alpha")
        .isWithin(tolerance)
        .of(alpha);
    return this;
  }

  public MarkerSubject hasId(String id) {
    assertThat(actual().getId())
        .named("ID")
        .isEqualTo(id);
    return this;
  }

  public MarkerSubject hasPosition(LatLng position) {
    assertThat(actual().getPosition())
        .named("position")
        .isEqualTo(position);
    return this;
  }

  public MarkerSubject hasRotation(float rotation, float tolerance) {
    assertThat(actual().getRotation())
        .named("rotation")
        .isWithin(tolerance)
        .of(rotation);
    return this;
  }

  public MarkerSubject hasSnippet(String snippet) {
    assertThat(actual().getSnippet())
        .named("snippet")
        .isEqualTo(snippet);
    return this;
  }

  public MarkerSubject hasTitle(String title) {
    assertThat(actual().getTitle())
        .named("title")
        .isEqualTo(title);
    return this;
  }

  public MarkerSubject isDraggable() {
    assertThat(actual().isDraggable())
        .named("is draggable")
        .isTrue();
    return this;
  }

  public MarkerSubject isNotDraggable() {
    assertThat(actual().isDraggable())
        .named("is draggable")
        .isFalse();
    return this;
  }

  public MarkerSubject isFlat() {
    assertThat(actual().isFlat())
        .named("is flat")
        .isTrue();
    return this;
  }

  public MarkerSubject isNotFlat() {
    assertThat(actual().isFlat())
        .named("is flat")
        .isFalse();
    return this;
  }

  public MarkerSubject hasInfoWindowShown() {
    assertThat(actual().isInfoWindowShown())
        .named("is info window shown")
        .isTrue();
    return this;
  }

  public MarkerSubject hasInfoWindowNotShown() {
    assertThat(actual().isInfoWindowShown())
        .named("is info window shown")
        .isFalse();
    return this;
  }

  public MarkerSubject isVisible() {
    assertThat(actual().isVisible())
        .named("is visible")
        .isTrue();
    return this;
  }

  public MarkerSubject isNotVisible() {
    assertThat(actual().isVisible())
        .named("is visible")
        .isFalse();
    return this;
  }
}
