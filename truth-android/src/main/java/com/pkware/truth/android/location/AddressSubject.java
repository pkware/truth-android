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

  public AddressSubject hasAddressLine(int index, @Nullable String line) {
    check("getAddressLine(index)")
        .withMessage("address line %s", index)
        .that(actual.getAddressLine(index))
        .isEqualTo(line);
    return this;
  }

  public AddressSubject hasAdminArea(@Nullable String area) {
    check("getAdminArea()").that(actual.getAdminArea()).isEqualTo(area);
    return this;
  }

  public AddressSubject hasCountryCode(@Nullable String code) {
    check("getCountryCode()").that(actual.getCountryCode()).isEqualTo(code);
    return this;
  }

  public AddressSubject hasCountryName(@Nullable String name) {
    check("getCountryName()").that(actual.getCountryName()).isEqualTo(name);
    return this;
  }

  public AddressSubject hasFeatureName(@Nullable String name) {
    check("getFeatureName()").that(actual.getFeatureName()).isEqualTo(name);
    return this;
  }

  public AddressSubject hasLatitude(double latitude, double tolerance) {
    check("getLatitude()").that(actual.getLatitude()).isWithin(tolerance).of(latitude);
    return this;
  }

  public AddressSubject hasLocale(@Nullable Locale locale) {
    check("getLocale()").that(actual.getLocale()).isEqualTo(locale);
    return this;
  }

  public AddressSubject hasLocality(@Nullable String locality) {
    check("getLocality()").that(actual.getLocality()).isEqualTo(locality);
    return this;
  }

  public AddressSubject hasLongitude(double longitude, double tolerance) {
    check("getLongitude()").that(actual.getLongitude()).isWithin(tolerance).of(longitude);
    return this;
  }

  public AddressSubject hasMaximumAddressLineIndex(int index) {
    check("getMaxAddressLineIndex()").that(actual.getMaxAddressLineIndex()).isEqualTo(index);
    return this;
  }

  public AddressSubject hasPhone(@Nullable String phone) {
    check("getPhone()").that(actual.getPhone()).isEqualTo(phone);
    return this;
  }

  public AddressSubject hasPostalCode(@Nullable String code) {
    check("getPostalCode()").that(actual.getPostalCode()).isEqualTo(code);
    return this;
  }

  public AddressSubject hasPremises(@Nullable String premises) {
    check("getPremises()").that(actual.getPremises()).isEqualTo(premises);
    return this;
  }

  public AddressSubject hasSubAdminArea(@Nullable String area) {
    check("getSubAdminArea()").that(actual.getSubAdminArea()).isEqualTo(area);
    return this;
  }

  public AddressSubject hasSubLocality(@Nullable String locality) {
    check("getSubLocality()").that(actual.getSubLocality()).isEqualTo(locality);
    return this;
  }

  public AddressSubject hasThoroughfare(@Nullable String thoroughfare) {
    check("getThoroughfare()").that(actual.getThoroughfare()).isEqualTo(thoroughfare);
    return this;
  }

  public AddressSubject hasUrl(@Nullable String url) {
    check("getUrl()").that(actual.getUrl()).isEqualTo(url);
    return this;
  }

  public AddressSubject hasLatitude() {
    check("hasLatitude()").that(actual.hasLatitude()).isTrue();
    return this;
  }

  public AddressSubject hasNoLatitude() {
    check("hasLatitude()").that(actual.hasLatitude()).isFalse();
    return this;
  }

  public AddressSubject hasLongitude() {
    check("hasLongitude()").that(actual.hasLongitude()).isTrue();
    return this;
  }

  public AddressSubject hasNoLongitude() {
    check("hasLongitude()").that(actual.hasLongitude()).isFalse();
    return this;
  }
}
