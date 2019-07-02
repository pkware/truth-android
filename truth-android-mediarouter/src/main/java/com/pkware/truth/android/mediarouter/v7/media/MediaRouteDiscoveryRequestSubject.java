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
package com.pkware.truth.android.mediarouter.v7.media;

import androidx.mediarouter.media.MediaRouteDiscoveryRequest;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link MediaRouteDiscoveryRequest} subjects.
 */
public class MediaRouteDiscoveryRequestSubject
    extends Subject<MediaRouteDiscoveryRequestSubject, MediaRouteDiscoveryRequest> {
  protected MediaRouteDiscoveryRequestSubject(FailureMetadata failureMetadata, MediaRouteDiscoveryRequest subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<MediaRouteDiscoveryRequestSubject, MediaRouteDiscoveryRequest> type() {
    return MediaRouteDiscoveryRequestSubject::new;
  }

  public MediaRouteDiscoveryRequestSubject isActiveScan() {
    assertThat(actual().isActiveScan())
        .named("is performing active scanning")
        .isTrue();
    return this;
  }

  public MediaRouteDiscoveryRequestSubject isNotActiveScan() {
    assertThat(actual().isActiveScan())
        .named("is not performing active scanning")
        .isFalse();
    return this;
  }

  public MediaRouteDiscoveryRequestSubject isValid() {
    assertThat(actual().isValid())
        .named("is valid")
        .isTrue();
    return this;
  }

  public MediaRouteDiscoveryRequestSubject isNotValid() {
    assertThat(actual().isValid())
        .named("is valid")
        .isFalse();
    return this;
  }
}
