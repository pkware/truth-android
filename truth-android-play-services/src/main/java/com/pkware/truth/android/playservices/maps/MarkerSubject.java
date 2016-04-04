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
package com.pkware.truth.android.playservices.maps;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link Marker} subjects.
 */
public class MarkerSubject extends Subject<MarkerSubject, Marker> {
  protected MarkerSubject(FailureStrategy failureStrategy, Marker subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<MarkerSubject, Marker> type() {
    return new SubjectFactory<MarkerSubject, Marker>() {
      @Override
      public MarkerSubject getSubject(FailureStrategy fs, Marker that) {
        return new MarkerSubject(fs, that);
      }
    };
  }

  public MarkerSubject hasAlpha(float alpha, float tolerance) {
    assertThat(getSubject().getAlpha())
        .named("alpha")
        .isWithin(tolerance)
        .of(alpha);
    return this;
  }

  public MarkerSubject hasId(String id) {
    assertThat(getSubject().getId())
        .named("ID")
        .isEqualTo(id);
    return this;
  }

  public MarkerSubject hasPosition(LatLng position) {
    assertThat(getSubject().getPosition())
        .named("position")
        .isEqualTo(position);
    return this;
  }

  public MarkerSubject hasRotation(float rotation, float tolerance) {
    assertThat(getSubject().getRotation())
        .named("rotation")
        .isWithin(tolerance)
        .of(rotation);
    return this;
  }

  public MarkerSubject hasSnippet(String snippet) {
    assertThat(getSubject().getSnippet())
        .named("snippet")
        .isEqualTo(snippet);
    return this;
  }

  public MarkerSubject hasTitle(String title) {
    assertThat(getSubject().getTitle())
        .named("title")
        .isEqualTo(title);
    return this;
  }

  public MarkerSubject isDraggable() {
    assertThat(getSubject().isDraggable())
        .named("is draggable")
        .isTrue();
    return this;
  }

  public MarkerSubject isNotDraggable() {
    assertThat(getSubject().isDraggable())
        .named("is draggable")
        .isFalse();
    return this;
  }

  public MarkerSubject isFlat() {
    assertThat(getSubject().isFlat())
        .named("is flat")
        .isTrue();
    return this;
  }

  public MarkerSubject isNotFlat() {
    assertThat(getSubject().isFlat())
        .named("is flat")
        .isFalse();
    return this;
  }

  public MarkerSubject hasInfoWindowShown() {
    assertThat(getSubject().isInfoWindowShown())
        .named("is info window shown")
        .isTrue();
    return this;
  }

  public MarkerSubject hasInfoWindowNotShown() {
    assertThat(getSubject().isInfoWindowShown())
        .named("is info window shown")
        .isFalse();
    return this;
  }

  public MarkerSubject isVisible() {
    assertThat(getSubject().isVisible())
        .named("is visible")
        .isTrue();
    return this;
  }

  public MarkerSubject isNotVisible() {
    assertThat(getSubject().isVisible())
        .named("is visible")
        .isFalse();
    return this;
  }
}
