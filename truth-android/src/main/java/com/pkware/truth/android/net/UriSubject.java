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
package com.pkware.truth.android.net;

import android.net.Uri;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link Uri} subjects.
 */
public class UriSubject extends Subject {

  @Nullable
  private final Uri actual;

  public UriSubject(@Nonnull FailureMetadata failureMetadata, @Nullable Uri actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasPath(@Nullable String path) {
    check("getPath()").that(actual.getPath()).isEqualTo(path);
  }

  public void doesNotHavePath() {
    check("getPath()").that(actual.getPath()).isNull();
  }

  public void hasPort(int port) {
    check("getPort()").that(actual.getPort()).isEqualTo(port);
  }

  public void hasHost(@Nullable String host) {
    check("getHost()").that(actual.getHost()).isEqualTo(host);
  }

  public void hasFragment(@Nullable String fragment) {
    check("getFragment()").that(actual.getFragment()).isEqualTo(fragment);
  }

  public void doesNotHaveFragment() {
    check("getFragment()").that(actual.getFragment()).isNull();
  }

  public void hasQuery(@Nullable String query) {
    check("getQuery()").that(actual.getQuery()).isEqualTo(query);
  }

  public void doesNotHaveQuery() {
    check("getQuery()").that(actual.getQuery()).isNull();
  }

  public void hasScheme(@Nullable String scheme) {
    check("getScheme()").that(actual.getScheme()).isEqualTo(scheme);
  }

  public void hasUserInfo(@Nullable String userInfo) {
    check("getUserInfo()").that(actual.getUserInfo()).isEqualTo(userInfo);
  }

  public void doesNotHaveUserInfo() {
    check("getUserInfo()").that(actual.getUserInfo()).isNull();
  }
}
