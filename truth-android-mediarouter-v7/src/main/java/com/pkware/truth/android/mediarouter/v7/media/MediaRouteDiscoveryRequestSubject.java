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
package com.pkware.truth.android.mediarouter.v7.media;

import android.support.v7.media.MediaRouteDiscoveryRequest;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link MediaRouteDiscoveryRequest} subjects.
 */
public class MediaRouteDiscoveryRequestSubject
    extends Subject<MediaRouteDiscoveryRequestSubject, MediaRouteDiscoveryRequest> {
  protected MediaRouteDiscoveryRequestSubject(FailureStrategy failureStrategy, MediaRouteDiscoveryRequest subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<MediaRouteDiscoveryRequestSubject, MediaRouteDiscoveryRequest> type() {
    return new SubjectFactory<MediaRouteDiscoveryRequestSubject, MediaRouteDiscoveryRequest>() {
      @Override
      public MediaRouteDiscoveryRequestSubject getSubject(FailureStrategy fs, MediaRouteDiscoveryRequest that) {
        return new MediaRouteDiscoveryRequestSubject(fs, that);
      }
    };
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
