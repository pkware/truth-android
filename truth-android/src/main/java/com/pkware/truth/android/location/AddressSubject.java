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
package com.pkware.truth.android.location;

import android.location.Address;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import java.util.Locale;

import static com.google.common.truth.Truth.assertThat;

public class AddressSubject extends Subject<AddressSubject, Address> {
  protected AddressSubject(FailureStrategy failureStrategy, Address subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<AddressSubject, Address> type() {
    return new SubjectFactory<AddressSubject, Address>() {
      @Override
      public AddressSubject getSubject(FailureStrategy fs, Address that) {
        return new AddressSubject(fs, that);
      }
    };
  }

  public AddressSubject hasAddressLine(int index, String line) {
    assertThat(getSubject().getAddressLine(index))
        .named(String.format(Locale.ENGLISH, "address line %d", index))
        .isEqualTo(line);
    return this;
  }

  public AddressSubject hasAdminArea(String area) {
    assertThat(getSubject().getAdminArea())
        .named("admin area")
        .isEqualTo(area);
    return this;
  }

  public AddressSubject hasCountryCode(String code) {
    assertThat(getSubject().getCountryCode())
        .named("country code")
        .isEqualTo(code);
    return this;
  }

  public AddressSubject hasCountryName(String name) {
    assertThat(getSubject().getCountryName())
        .named("country name")
        .isEqualTo(name);
    return this;
  }

  public AddressSubject hasFeatureName(String name) {
    assertThat(getSubject().getFeatureName())
        .named("feature name")
        .isEqualTo(name);
    return this;
  }

  public AddressSubject hasLatitude(double latitude, double tolerance) {
    assertThat(getSubject().getLatitude())
        .named("latitude")
        .isWithin(tolerance)
        .of(latitude);
    return this;
  }

  public AddressSubject hasLocale(Locale locale) {
    assertThat(getSubject().getLocale())
        .named("locale")
        .isEqualTo(locale);
    return this;
  }

  public AddressSubject hasLocality(String locality) {
    assertThat(getSubject().getLocality())
        .named("locality")
        .isEqualTo(locality);
    return this;
  }

  public AddressSubject hasLongitude(double longitude, double tolerance) {
    assertThat(getSubject().getLongitude())
        .named("longitude")
        .isWithin(tolerance)
        .of(longitude);
    return this;
  }

  public AddressSubject hasMaximumAddressLineIndex(int index) {
    assertThat(getSubject().getMaxAddressLineIndex())
        .named("maximum address line index")
        .isEqualTo(index);
    return this;
  }

  public AddressSubject hasPhone(String phone) {
    assertThat(getSubject().getPhone())
        .named("phone")
        .isEqualTo(phone);
    return this;
  }

  public AddressSubject hasPostalCode(String code) {
    assertThat(getSubject().getPostalCode())
        .named("postal code")
        .isEqualTo(code);
    return this;
  }

  public AddressSubject hasPremises(String premises) {
    assertThat(getSubject().getPremises())
        .named("premises")
        .isEqualTo(premises);
    return this;
  }

  public AddressSubject hasSubAdminArea(String area) {
    assertThat(getSubject().getSubAdminArea())
        .named("sub-admin area")
        .isEqualTo(area);
    return this;
  }

  public AddressSubject hasSubLocality(String locality) {
    assertThat(getSubject().getSubLocality())
        .named("sub-locality")
        .isEqualTo(locality);
    return this;
  }

  public AddressSubject hasThoroughfare(String thoroughfare) {
    assertThat(getSubject().getThoroughfare())
        .named("thoroughfare")
        .isEqualTo(thoroughfare);
    return this;
  }

  public AddressSubject hasUrl(String url) {
    assertThat(getSubject().getUrl())
        .named("url")
        .isEqualTo(url);
    return this;
  }

  public AddressSubject hasLatitude() {
    assertThat(getSubject().hasLatitude())
        .named("has latitude")
        .isTrue();
    return this;
  }

  public AddressSubject hasNoLatitude() {
    assertThat(getSubject().hasLatitude())
        .named("has latitude")
        .isFalse();
    return this;
  }

  public AddressSubject hasLongitude() {
    assertThat(getSubject().hasLongitude())
        .named("has longitude")
        .isTrue();
    return this;
  }

  public AddressSubject hasNoLongitude() {
    assertThat(getSubject().hasLongitude())
        .named("has longitude")
        .isFalse();
    return this;
  }
}
