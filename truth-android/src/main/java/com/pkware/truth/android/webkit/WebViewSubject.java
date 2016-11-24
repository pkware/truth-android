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

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link WebView} subjects.
 */
public class WebViewSubject extends Subject<WebViewSubject, WebView> {
  protected WebViewSubject(FailureStrategy failureStrategy, WebView subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<WebViewSubject, WebView> type() {
    return new SubjectFactory<WebViewSubject, WebView>() {
      @Override
      public WebViewSubject getSubject(FailureStrategy fs, WebView that) {
        return new WebViewSubject(fs, that);
      }
    };
  }

  public WebViewSubject canGoBack() {
    assertThat(actual().canGoBack())
        .named("can go back")
        .isTrue();
    return this;
  }

  public WebViewSubject canNotGoBack() {
    assertThat(actual().canGoBack())
        .named("can go back")
        .isFalse();
    return this;
  }

  public WebViewSubject canGoForward() {
    assertThat(actual().canGoForward())
        .named("can go forward")
        .isTrue();
    return this;
  }

  public WebViewSubject canNotGoForward() {
    assertThat(actual().canGoForward())
        .named("can go forward")
        .isFalse();
    return this;
  }

  public WebViewSubject hasCertificate(SslCertificate certificate) {
    assertThat(actual().getCertificate())
        .named("certificate")
        .isSameAs(certificate);
    return this;
  }

  public WebViewSubject hasContentHeight(int height) {
    assertThat(actual().getContentHeight())
        .named("content height")
        .isEqualTo(height);
    return this;
  }

  public WebViewSubject hasOriginalUrl(String url) {
    assertThat(actual().getOriginalUrl())
        .named("original URL")
        .isEqualTo(url);
    return this;
  }

  public WebViewSubject hasProgress(int progress) {
    assertThat(actual().getProgress())
        .named("progress")
        .isEqualTo(progress);
    return this;
  }

  public WebViewSubject hasTitle(String title) {
    assertThat(actual().getTitle())
        .named("title")
        .isEqualTo(title);
    return this;
  }

  public WebViewSubject hasUrl(String url) {
    assertThat(actual().getUrl())
        .named("URL")
        .isEqualTo(url);
    return this;
  }

  public WebViewSubject isPrivateBrowsingEnabled() {
    assertThat(actual().isPrivateBrowsingEnabled())
        .named("private browsing enabled")
        .isTrue();
    return this;
  }

  public WebViewSubject isPrivateBrowsingDisabled() {
    assertThat(!actual().isPrivateBrowsingEnabled())
        .named("private browsing disabled")
        .isTrue();
    return this;
  }
}
