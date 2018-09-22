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

import android.support.v7.media.MediaRouteDescriptor;
import android.support.v7.media.MediaRouter;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assert_;
import static com.pkware.truth.android.internal.IntegerUtils.buildNamedValueString;

/**
 * Propositions for {@link MediaRouteDescriptor} subjects.
 */
public class MediaRouteDescriptorSubject
    extends Subject<MediaRouteDescriptorSubject, MediaRouteDescriptor> {
  protected MediaRouteDescriptorSubject(FailureMetadata failureMetadata, MediaRouteDescriptor subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<MediaRouteDescriptorSubject, MediaRouteDescriptor> type() {
    return new Subject.Factory<MediaRouteDescriptorSubject, MediaRouteDescriptor>() {
      @Override
      public MediaRouteDescriptorSubject createSubject(FailureMetadata fm, MediaRouteDescriptor that) {
        return new MediaRouteDescriptorSubject(fm, that);
      }
    };
  }

  public static String volumeHandling(@MediaRouteVolumeHandling int handling) {
    return buildNamedValueString(handling)
        .value(MediaRouter.RouteInfo.PLAYBACK_VOLUME_FIXED, "fixed")
        .value(MediaRouter.RouteInfo.PLAYBACK_VOLUME_VARIABLE, "variable")
        .get();
  }

  public MediaRouteDescriptorSubject hasDescription(String description) {
    assertThat(actual().getDescription())
        .named("description")
        .isEqualTo(description);
    return this;
  }

  public MediaRouteDescriptorSubject hasId(String id) {
    assertThat(actual().getId())
        .named("ID")
        .isEqualTo(id);
    return this;
  }

  public MediaRouteDescriptorSubject hasName(String name) {
    assertThat(actual().getName())
        .named("name")
        .isEqualTo(name);
    return this;
  }

  public MediaRouteDescriptorSubject hasPlaybackStream(int playbackStream) {
    assertThat(actual().getPlaybackStream())
        .named("playback stream")
        .isEqualTo(playbackStream);
    return this;
  }

  public MediaRouteDescriptorSubject hasPlaybackType(int playbackType) {
    assertThat(actual().getPlaybackType())
        .named("playback type")
        .isEqualTo(playbackType);
    return this;
  }

  public MediaRouteDescriptorSubject hasPresentationDisplayId(int displayId) {
    assertThat(actual().getPresentationDisplayId())
        .named("presentation display ID")
        .isEqualTo(displayId);
    return this;
  }

  public MediaRouteDescriptorSubject hasVolume(int volume) {
    assertThat(actual().getVolume())
        .named("volume")
        .isEqualTo(volume);
    return this;
  }

  public MediaRouteDescriptorSubject hasVolumeHandling(@MediaSessionStatusState int volumeHandling) {
    int actualHandling = actual().getVolumeHandling();
    //noinspection WrongConstant
    assert_()
        .withMessage("Expected volume handling <%s> but was <%s>.",
            volumeHandling(volumeHandling), volumeHandling(actualHandling))
        .that(actualHandling)
        .isEqualTo(volumeHandling);
    return this;
  }

  public MediaRouteDescriptorSubject hasVolumeMax(int volumeMax) {
    assertThat(actual().getVolumeMax())
        .named("maximum volume")
        .isEqualTo(volumeMax);
    return this;
  }

  public MediaRouteDescriptorSubject isConnecting() {
    assertThat(actual().isConnecting())
        .named("is connecting")
        .isTrue();
    return this;
  }

  public MediaRouteDescriptorSubject isNotConnecting() {
    assertThat(actual().isConnecting())
        .named("is connecting")
        .isFalse();
    return this;
  }

  public MediaRouteDescriptorSubject isEnabled() {
    assertThat(actual().isEnabled())
        .named("is enabled")
        .isTrue();
    return this;
  }

  public MediaRouteDescriptorSubject isDisabled() {
    assertThat(!actual().isEnabled())
        .named("is disabled")
        .isTrue();
    return this;
  }

  public MediaRouteDescriptorSubject isValid() {
    assertThat(actual().isValid())
        .named("is valid")
        .isTrue();
    return this;
  }

  public MediaRouteDescriptorSubject isNotValid() {
    assertThat(actual().isValid())
        .named("is valid")
        .isFalse();
    return this;
  }
}
