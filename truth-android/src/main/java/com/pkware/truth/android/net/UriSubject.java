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

  public UriSubject hasPath(@Nullable String path) {
    check("getPath()").that(actual.getPath()).isEqualTo(path);
    return this;
  }

  public UriSubject doesNotHavePath() {
    check("getPath()").that(actual.getPath()).isNull();
    return this;
  }

  public UriSubject hasPort(int port) {
    check("getPort()").that(actual.getPort()).isEqualTo(port);
    return this;
  }

  public UriSubject hasHost(@Nullable String host) {
    check("getHost()").that(actual.getHost()).isEqualTo(host);
    return this;
  }

  public UriSubject hasFragment(@Nullable String fragment) {
    check("getFragment()").that(actual.getFragment()).isEqualTo(fragment);
    return this;
  }

  public UriSubject doesNotHaveFragment() {
    check("getFragment()").that(actual.getFragment()).isNull();
    return this;
  }

  public UriSubject hasQuery(@Nullable String query) {
    check("getQuery()").that(actual.getQuery()).isEqualTo(query);
    return this;
  }

  public UriSubject doesNotHaveQuery() {
    check("getQuery()").that(actual.getQuery()).isNull();
    return this;
  }

  public UriSubject hasScheme(@Nullable String scheme) {
    check("getScheme()").that(actual.getScheme()).isEqualTo(scheme);
    return this;
  }

  public UriSubject hasUserInfo(@Nullable String userInfo) {
    check("getUserInfo()").that(actual.getUserInfo()).isEqualTo(userInfo);
    return this;
  }

  public UriSubject doesNotHaveUserInfo() {
    check("getUserInfo()").that(actual.getUserInfo()).isNull();
    return this;
  }
}
