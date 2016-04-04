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
    float actualAlpha = getSubject().getAlpha();
    assertThat(actualAlpha)
        .overridingErrorMessage("Expected alpha <%s> but was <%s>.", alpha, actualAlpha)
        .isEqualTo(alpha);
    return this;
  }

  public MarkerSubject hasId(String id) {
    String actualId = getSubject().getId();
    assertThat(actualId)
        .overridingErrorMessage("Expected id <%s> but was <%s>.", id, actualId)
        .isEqualTo(id);
    return this;
  }

  public MarkerSubject hasPosition(LatLng position) {
    LatLng actualLatLng = getSubject().getPosition();
    assertThat(actualLatLng)
        .overridingErrorMessage("Expected position <%s> but was <%s>.", position, actualLatLng)
        .isEqualTo(position);
    return this;
  }

  public MarkerSubject hasRotation(float rotation, float tolerance) {
    float actualRotation = getSubject().getRotation();
    assertThat(actualRotation)
        .overridingErrorMessage("Expected rotation <%s> but was <%s>.", rotation, actualRotation)
        .isEqualTo(rotation);
    return this;
  }

  public MarkerSubject hasSnippet(String snippet) {
    String actualSnippet = getSubject().getSnippet();
    assertThat(actualSnippet)
        .overridingErrorMessage("Expected snippet <%s> but was <%s>.", snippet, actualSnippet)
        .isEqualTo(snippet);
    return this;
  }

  public MarkerSubject hasTitle(String title) {
    String actualTitle = getSubject().getTitle();
    assertThat(actualTitle)
        .overridingErrorMessage("Expected title <%s> but was <%s>.", title, actualTitle)
        .isEqualTo(title);
    return this;
  }

  public MarkerSubject isDraggable() {
    assertThat(getSubject().isDraggable())
        .overridingErrorMessage("Expected to be draggable but was not.")
        .isTrue();
    return this;
  }

  public MarkerSubject isNotDraggable() {
    assertThat(getSubject().isDraggable())
        .overridingErrorMessage("Expected to not be draggable but was.")
        .isFalse();
    return this;
  }

  public MarkerSubject isFlat() {
    assertThat(getSubject().isFlat())
        .overridingErrorMessage("Expected to be flat but was not.")
        .isTrue();
    return this;
  }

  public MarkerSubject isNotFlat() {
    assertThat(getSubject().isFlat())
        .overridingErrorMessage("Expected to not be flat but was.")
        .isFalse();
    return this;
  }

  public MarkerSubject hasInfoWindowShown() {
    assertThat(getSubject().isInfoWindowShown())
        .overridingErrorMessage("Expected info window to be shown but was not.")
        .isTrue();
    return this;
  }

  public MarkerSubject hasInfoWindowNotShown() {
    assertThat(getSubject().isInfoWindowShown())
        .overridingErrorMessage("Expected info window to not be shown but was.")
        .isFalse();
    return this;
  }

  public MarkerSubject isVisible() {
    assertThat(getSubject().isVisible())
        .overridingErrorMessage("Expected to be visible but was not.")
        .isTrue();
    return this;
  }

  public MarkerSubject isNotVisible() {
    assertThat(getSubject().isVisible())
        .overridingErrorMessage("Expected to not be visible but was.")
        .isFalse();
    return this;
  }
}
