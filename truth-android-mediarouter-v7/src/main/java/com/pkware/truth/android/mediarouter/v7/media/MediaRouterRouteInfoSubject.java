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

import android.support.v7.media.MediaRouter;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assert_;
import static com.pkware.truth.android.mediarouter.v7.media.MediaRouteDescriptorSubject.volumeHandling;

/**
 * Propositions for {@link MediaRouter.RouteInfo} subjects.
 */
public class MediaRouterRouteInfoSubject
    extends Subject<MediaRouterRouteInfoSubject, MediaRouter.RouteInfo> {

  protected MediaRouterRouteInfoSubject(FailureMetadata failureMetadata, MediaRouter.RouteInfo subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<MediaRouterRouteInfoSubject, MediaRouter.RouteInfo> type() {
    return new Subject.Factory<MediaRouterRouteInfoSubject, MediaRouter.RouteInfo>() {
      @Override
      public MediaRouterRouteInfoSubject createSubject(FailureMetadata fm, MediaRouter.RouteInfo that) {
        return new MediaRouterRouteInfoSubject(fm, that);
      }
    };
  }

  public MediaRouterRouteInfoSubject hasDescription(String description) {
    assertThat(actual().getDescription())
        .named("description")
        .isEqualTo(description);
    return this;
  }

  public MediaRouterRouteInfoSubject hasId(String id) {
    assertThat(actual().getId())
        .named("ID")
        .isEqualTo(id);
    return this;
  }

  public MediaRouterRouteInfoSubject hasName(String name) {
    assertThat(actual().getName())
        .named("name")
        .isEqualTo(name);
    return this;
  }

  public MediaRouterRouteInfoSubject hasPlaybackStream(int playbackStream) {
    assertThat(actual().getPlaybackStream())
        .named("playback stream")
        .isEqualTo(playbackStream);
    return this;
  }

  public MediaRouterRouteInfoSubject hasPlaybackType(int playbackType) {
    int actualPlaybackType = actual().getPlaybackType();
    assertThat(actual().getPlaybackType())
        .named("playback type")
        .isEqualTo(playbackType);
    return this;
  }

  public MediaRouterRouteInfoSubject hasVolume(int volume) {
    int actualVolume = actual().getVolume();
    assertThat(actual().getVolume())
        .named("volume")
        .isEqualTo(volume);
    return this;
  }

  public MediaRouterRouteInfoSubject hasVolumeHandling(@MediaRouteVolumeHandling int volumeHandling) {
    int actualHandling = actual().getVolumeHandling();
    //noinspection WrongConstant
    assert_()
        .withMessage("Expected volume handling <%s> but was <%s>.",
            volumeHandling(volumeHandling), volumeHandling(actualHandling))
        .that(actualHandling)
        .isEqualTo(volumeHandling);
    return this;
  }

  public MediaRouterRouteInfoSubject hasVolumeMax(int volumeMax) {
    int actualVolumeMax = actual().getVolumeMax();
    assertThat(actual().getVolumeMax())
        .named("maximum volume")
        .isEqualTo(volumeMax);
    return this;
  }

  public MediaRouterRouteInfoSubject isConnecting() {
    assertThat(actual().isConnecting())
        .named("is connecting")
        .isTrue();
    return this;
  }

  public MediaRouterRouteInfoSubject isNotConnecting() {
    assertThat(actual().isConnecting())
        .named("is connecting")
        .isFalse();
    return this;
  }

  public MediaRouterRouteInfoSubject isEnabled() {
    assertThat(actual().isEnabled())
        .named("is enabled")
        .isTrue();
    return this;
  }

  public MediaRouterRouteInfoSubject isDisabled() {
    assertThat(!actual().isEnabled())
        .named("is disabled")
        .isTrue();
    return this;
  }

  public MediaRouterRouteInfoSubject isSelected() {
    assertThat(actual().isSelected())
        .named("is selected")
        .isTrue();
    return this;
  }

  public MediaRouterRouteInfoSubject isNotSelected() {
    assertThat(actual().isSelected())
        .named("is selected")
        .isFalse();
    return this;
  }
}
