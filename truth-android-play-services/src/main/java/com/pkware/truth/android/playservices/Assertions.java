// Copyright 2019 PKWARE, Inc.
//
// This class is generated. Do not modify directly!
package com.pkware.truth.android.playservices;

import com.google.common.truth.Subject;

import static com.google.common.truth.Truth.assertAbout;

/** Assertions for testing Android classes. */
@SuppressWarnings("deprecation")
public final class Assertions {
  public static com.pkware.truth.android.playservices.location.ActivityRecognitionResultSubject assertThat(
      com.google.android.gms.location.ActivityRecognitionResult target) {
    Subject.Factory<com.pkware.truth.android.playservices.location.ActivityRecognitionResultSubject, com.google.android.gms.location.ActivityRecognitionResult> type = com.pkware.truth.android.playservices.location.ActivityRecognitionResultSubject.type();
    return assertAbout(type).that(target);
  }

  public static com.pkware.truth.android.playservices.location.DetectedActivitySubject assertThat(
      com.google.android.gms.location.DetectedActivity target) {
    Subject.Factory<com.pkware.truth.android.playservices.location.DetectedActivitySubject, com.google.android.gms.location.DetectedActivity> type = com.pkware.truth.android.playservices.location.DetectedActivitySubject.type();
    return assertAbout(type).that(target);
  }

  public static com.pkware.truth.android.playservices.location.LocationRequestSubject assertThat(
      com.google.android.gms.location.LocationRequest target) {
    Subject.Factory<com.pkware.truth.android.playservices.location.LocationRequestSubject, com.google.android.gms.location.LocationRequest> type = com.pkware.truth.android.playservices.location.LocationRequestSubject.type();
    return assertAbout(type).that(target);
  }

  public static com.pkware.truth.android.playservices.maps.CameraPositionSubject assertThat(
      com.google.android.gms.maps.model.CameraPosition target) {
    Subject.Factory<com.pkware.truth.android.playservices.maps.CameraPositionSubject, com.google.android.gms.maps.model.CameraPosition> type = com.pkware.truth.android.playservices.maps.CameraPositionSubject.type();
    return assertAbout(type).that(target);
  }

  public static com.pkware.truth.android.playservices.maps.GoogleMapSubject assertThat(
      com.google.android.gms.maps.GoogleMap target) {
    Subject.Factory<com.pkware.truth.android.playservices.maps.GoogleMapSubject, com.google.android.gms.maps.GoogleMap> type = com.pkware.truth.android.playservices.maps.GoogleMapSubject.type();
    return assertAbout(type).that(target);
  }

  public static com.pkware.truth.android.playservices.maps.MarkerSubject assertThat(
      com.google.android.gms.maps.model.Marker target) {
    Subject.Factory<com.pkware.truth.android.playservices.maps.MarkerSubject, com.google.android.gms.maps.model.Marker> type = com.pkware.truth.android.playservices.maps.MarkerSubject.type();
    return assertAbout(type).that(target);
  }

  public static com.pkware.truth.android.playservices.maps.UiSettingsSubject assertThat(
      com.google.android.gms.maps.UiSettings target) {
    Subject.Factory<com.pkware.truth.android.playservices.maps.UiSettingsSubject, com.google.android.gms.maps.UiSettings> type = com.pkware.truth.android.playservices.maps.UiSettingsSubject.type();
    return assertAbout(type).that(target);
  }

  private Assertions() {
    throw new AssertionError("No instances.");
  }
}
