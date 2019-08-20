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

import androidx.mediarouter.media.MediaRouter;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static com.pkware.truth.android.mediarouter.v7.media.MediaRouteDescriptorSubject.volumeHandling;

/**
 * Propositions for {@link MediaRouter.RouteInfo} subjects.
 */
public class MediaRouterRouteInfoSubject extends Subject {

  @Nullable
  private final MediaRouter.RouteInfo actual;

  public MediaRouterRouteInfoSubject(@Nonnull FailureMetadata failureMetadata, @Nullable MediaRouter.RouteInfo actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public MediaRouterRouteInfoSubject hasDescription(@Nullable String description) {
    check("getDescription()").that(actual.getDescription()).isEqualTo(description);
    return this;
  }

  public MediaRouterRouteInfoSubject hasId(@Nullable String id) {
    check("getId()").that(actual.getId()).isEqualTo(id);
    return this;
  }

  public MediaRouterRouteInfoSubject hasName(@Nullable String name) {
    check("getName()").that(actual.getName()).isEqualTo(name);
    return this;
  }

  public MediaRouterRouteInfoSubject hasPlaybackStream(int playbackStream) {
    check("getPlaybackStream()").that(actual.getPlaybackStream()).isEqualTo(playbackStream);
    return this;
  }

  public MediaRouterRouteInfoSubject hasPlaybackType(int playbackType) {
    check("getPlaybackType()").that(actual.getPlaybackType()).isEqualTo(playbackType);
    return this;
  }

  public MediaRouterRouteInfoSubject hasVolume(int volume) {
    check("getVolume()").that(actual.getVolume()).isEqualTo(volume);
    return this;
  }

  public MediaRouterRouteInfoSubject hasVolumeHandling(@MediaRouteVolumeHandling int volumeHandling) {
    int actualHandling = actual.getVolumeHandling();
    //noinspection WrongConstant
    check("hasVolumeHandling()")
        .withMessage("Expected volume handling <%s> but was <%s>.",
            volumeHandling(volumeHandling), volumeHandling(actualHandling))
        .that(actualHandling)
        .isEqualTo(volumeHandling);
    return this;
  }

  public MediaRouterRouteInfoSubject hasVolumeMax(int volumeMax) {
    check("getVolumeMax()").that(actual.getVolumeMax()).isEqualTo(volumeMax);
    return this;
  }

  public MediaRouterRouteInfoSubject isConnecting() {
    check("isConnecting()").that(actual.isConnecting()).isTrue();
    return this;
  }

  public MediaRouterRouteInfoSubject isNotConnecting() {
    check("isConnecting()").that(actual.isConnecting()).isFalse();
    return this;
  }

  public MediaRouterRouteInfoSubject isEnabled() {
    check("isEnabled()").that(actual.isEnabled()).isTrue();
    return this;
  }

  public MediaRouterRouteInfoSubject isDisabled() {
    check("isEnabled()").that(actual.isEnabled()).isFalse();
    return this;
  }

  public MediaRouterRouteInfoSubject isSelected() {
    check("isSelected()").that(actual.isSelected()).isTrue();
    return this;
  }

  public MediaRouterRouteInfoSubject isNotSelected() {
    check("isSelected()").that(actual.isSelected()).isFalse();
    return this;
  }
}
