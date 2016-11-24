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

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link Uri} subjects.
 */
public class UriSubject extends Subject<UriSubject, Uri> {

  protected UriSubject(FailureStrategy failureStrategy, Uri subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<UriSubject, Uri> type() {
    return new SubjectFactory<UriSubject, Uri>() {
      @Override
      public UriSubject getSubject(FailureStrategy fs, Uri that) {
        return new UriSubject(fs, that);
      }
    };
  }

  public UriSubject hasPath(String path) {
    assertThat(actual().getPath())
        .named("path")
        .isEqualTo(path);
    return this;
  }

  public UriSubject doesNotHavePath() {
    assertThat(actual().getPath())
        .named("path")
        .isNull();
    return this;
  }

  public UriSubject hasPort(int port) {
    assertThat(actual().getPort())
        .named("port")
        .isEqualTo(port);
    return this;
  }

  public UriSubject hasHost(String host) {
    assertThat(actual().getHost())
        .named("host")
        .isEqualTo(host);
    return this;
  }

  public UriSubject hasFragment(String fragment) {
    assertThat(actual().getFragment())
        .named("fragment")
        .isEqualTo(fragment);
    return this;
  }

  public UriSubject doesNotHaveFragment() {
    assertThat(actual().getFragment())
        .named("fragment")
        .isNull();
    return this;
  }

  public UriSubject hasQuery(String query) {
    assertThat(actual().getQuery())
        .named("query")
        .isEqualTo(query);
    return this;
  }

  public UriSubject doesNotHaveQuery() {
    assertThat(actual().getQuery())
        .named("query")
        .isNull();
    return this;
  }

  public UriSubject hasScheme(String scheme) {
    assertThat(actual().getScheme())
        .named("scheme")
        .isEqualTo(scheme);
    return this;
  }

  public UriSubject hasUserInfo(String userInfo) {
    assertThat(actual().getUserInfo())
        .named("user info")
        .isEqualTo(userInfo);
    return this;
  }

  public UriSubject doesNotHaveUserInfo() {
    assertThat(actual().getUserInfo())
        .named("user info")
        .isNull();
    return this;
  }

  public UriSubject isEqualTo(Uri uri) {
    assertThat(actual().toString())
        .isEqualTo(uri.toString());
    return this;
  }
}
