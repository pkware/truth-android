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
package com.pkware.truth.android.webkit;

import android.net.http.SslCertificate;
import android.webkit.WebView;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link WebView} subjects.
 */
public class WebViewSubject extends Subject {

  @Nullable
  private final WebView actual;

  public WebViewSubject(@Nonnull FailureMetadata failureMetadata, @Nullable WebView actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void canGoBack() {
    check("canGoBack()").that(actual.canGoBack()).isTrue();
  }

  public void canNotGoBack() {
    check("canGoBack()").that(actual.canGoBack()).isFalse();
  }

  public void canGoForward() {
    check("canGoForward()").that(actual.canGoForward()).isTrue();
  }

  public void canNotGoForward() {
    check("canGoForward()").that(actual.canGoForward()).isFalse();
  }

  public void hasCertificate(@Nullable SslCertificate certificate) {
    check("getCertificate()").that(actual.getCertificate()).isSameInstanceAs(certificate);
  }

  public void hasContentHeight(int height) {
    check("getContentHeight()").that(actual.getContentHeight()).isEqualTo(height);
  }

  public void hasOriginalUrl(@Nullable String url) {
    check("getOriginalUrl()").that(actual.getOriginalUrl()).isEqualTo(url);
  }

  public void hasProgress(int progress) {
    check("getProgress()").that(actual.getProgress()).isEqualTo(progress);
  }

  public void hasTitle(@Nullable String title) {
    check("getTitle()").that(actual.getTitle()).isEqualTo(title);
  }

  public void hasUrl(@Nullable String url) {
    check("getUrl()").that(actual.getUrl()).isEqualTo(url);
  }

  public void isPrivateBrowsingEnabled() {
    check("isPrivateBrowsingEnabled()").that(actual.isPrivateBrowsingEnabled()).isTrue();
  }

  public void isPrivateBrowsingDisabled() {
    check("isPrivateBrowsingEnabled()").that(actual.isPrivateBrowsingEnabled()).isFalse();
  }
}
