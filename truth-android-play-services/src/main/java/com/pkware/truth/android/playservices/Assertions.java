// Copyright 2019 PKWARE, Inc.
//
// This class is generated. Do not modify directly!
package com.pkware.truth.android.playservices;

import static com.google.common.truth.Truth.assertAbout;

/** Assertions for testing Android classes. */
@SuppressWarnings("deprecation")
public final class Assertions {
  public static com.pkware.truth.android.playservices.location.ActivityRecognitionResultSubject assertThat(
      com.google.android.gms.location.ActivityRecognitionResult target) {
    return assertAbout(com.pkware.truth.android.playservices.location.ActivityRecognitionResultSubject::new).that(target);
  }

  public static com.pkware.truth.android.playservices.location.DetectedActivitySubject assertThat(
      com.google.android.gms.location.DetectedActivity target) {
    return assertAbout(com.pkware.truth.android.playservices.location.DetectedActivitySubject::new).that(target);
  }

  public static com.pkware.truth.android.playservices.location.LocationRequestSubject assertThat(
      com.google.android.gms.location.LocationRequest target) {
    return assertAbout(com.pkware.truth.android.playservices.location.LocationRequestSubject::new).that(target);
  }

  public static com.pkware.truth.android.playservices.maps.CameraPositionSubject assertThat(
      com.google.android.gms.maps.model.CameraPosition target) {
    return assertAbout(com.pkware.truth.android.playservices.maps.CameraPositionSubject::new).that(target);
  }

  public static com.pkware.truth.android.playservices.maps.GoogleMapSubject assertThat(
      com.google.android.gms.maps.GoogleMap target) {
    return assertAbout(com.pkware.truth.android.playservices.maps.GoogleMapSubject::new).that(target);
  }

  public static com.pkware.truth.android.playservices.maps.MarkerSubject assertThat(
      com.google.android.gms.maps.model.Marker target) {
    return assertAbout(com.pkware.truth.android.playservices.maps.MarkerSubject::new).that(target);
  }

  public static com.pkware.truth.android.playservices.maps.UiSettingsSubject assertThat(
      com.google.android.gms.maps.UiSettings target) {
    return assertAbout(com.pkware.truth.android.playservices.maps.UiSettingsSubject::new).that(target);
  }

  private Assertions() {
    throw new AssertionError("No instances.");
  }
}
