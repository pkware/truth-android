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
package com.pkware.truth.android.location;

import android.location.Address;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import java.util.Locale;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class AddressSubject extends Subject {

  @Nullable
  private final Address actual;

  public AddressSubject(@Nonnull FailureMetadata failureMetadata, @Nullable Address actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasAddressLine(int index, @Nullable String line) {
    check("getAddressLine(index)")
        .withMessage("address line %s", index)
        .that(actual.getAddressLine(index))
        .isEqualTo(line);
  }

  public void hasAdminArea(@Nullable String area) {
    check("getAdminArea()").that(actual.getAdminArea()).isEqualTo(area);
  }

  public void hasCountryCode(@Nullable String code) {
    check("getCountryCode()").that(actual.getCountryCode()).isEqualTo(code);
  }

  public void hasCountryName(@Nullable String name) {
    check("getCountryName()").that(actual.getCountryName()).isEqualTo(name);
  }

  public void hasFeatureName(@Nullable String name) {
    check("getFeatureName()").that(actual.getFeatureName()).isEqualTo(name);
  }

  public void hasLatitude(double latitude, double tolerance) {
    check("getLatitude()").that(actual.getLatitude()).isWithin(tolerance).of(latitude);
  }

  public void hasLocale(@Nullable Locale locale) {
    check("getLocale()").that(actual.getLocale()).isEqualTo(locale);
  }

  public void hasLocality(@Nullable String locality) {
    check("getLocality()").that(actual.getLocality()).isEqualTo(locality);
  }

  public void hasLongitude(double longitude, double tolerance) {
    check("getLongitude()").that(actual.getLongitude()).isWithin(tolerance).of(longitude);
  }

  public void hasMaximumAddressLineIndex(int index) {
    check("getMaxAddressLineIndex()").that(actual.getMaxAddressLineIndex()).isEqualTo(index);
  }

  public void hasPhone(@Nullable String phone) {
    check("getPhone()").that(actual.getPhone()).isEqualTo(phone);
  }

  public void hasPostalCode(@Nullable String code) {
    check("getPostalCode()").that(actual.getPostalCode()).isEqualTo(code);
  }

  public void hasPremises(@Nullable String premises) {
    check("getPremises()").that(actual.getPremises()).isEqualTo(premises);
  }

  public void hasSubAdminArea(@Nullable String area) {
    check("getSubAdminArea()").that(actual.getSubAdminArea()).isEqualTo(area);
  }

  public void hasSubLocality(@Nullable String locality) {
    check("getSubLocality()").that(actual.getSubLocality()).isEqualTo(locality);
  }

  public void hasThoroughfare(@Nullable String thoroughfare) {
    check("getThoroughfare()").that(actual.getThoroughfare()).isEqualTo(thoroughfare);
  }

  public void hasUrl(@Nullable String url) {
    check("getUrl()").that(actual.getUrl()).isEqualTo(url);
  }

  public void hasLatitude() {
    check("hasLatitude()").that(actual.hasLatitude()).isTrue();
  }

  public void hasNoLatitude() {
    check("hasLatitude()").that(actual.hasLatitude()).isFalse();
  }

  public void hasLongitude() {
    check("hasLongitude()").that(actual.hasLongitude()).isTrue();
  }

  public void hasNoLongitude() {
    check("hasLongitude()").that(actual.hasLongitude()).isFalse();
  }
}
