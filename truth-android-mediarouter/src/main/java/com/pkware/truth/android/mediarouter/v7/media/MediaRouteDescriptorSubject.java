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

import androidx.mediarouter.media.MediaRouteDescriptor;
import androidx.mediarouter.media.MediaRouter;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static com.pkware.truth.android.internal.IntegerUtils.buildNamedValueString;

/**
 * Propositions for {@link MediaRouteDescriptor} subjects.
 */
public class MediaRouteDescriptorSubject extends Subject {

  @Nullable
  private final MediaRouteDescriptor actual;

  public MediaRouteDescriptorSubject(@Nonnull FailureMetadata failureMetadata, @Nullable MediaRouteDescriptor actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  @Nonnull
  public static String volumeHandling(@MediaRouteVolumeHandling int handling) {
    return buildNamedValueString(handling)
        .value(MediaRouter.RouteInfo.PLAYBACK_VOLUME_FIXED, "fixed")
        .value(MediaRouter.RouteInfo.PLAYBACK_VOLUME_VARIABLE, "variable")
        .get();
  }

  public MediaRouteDescriptorSubject hasDescription(String description) {
    check("getDescription()").that(actual.getDescription()).isEqualTo(description);
    return this;
  }

  public MediaRouteDescriptorSubject hasId(@Nullable String id) {
    check("getId()").that(actual.getId()).isEqualTo(id);
    return this;
  }

  public MediaRouteDescriptorSubject hasName(@Nullable String name) {
    check("getName()").that(actual.getName()).isEqualTo(name);
    return this;
  }

  public MediaRouteDescriptorSubject hasPlaybackStream(int playbackStream) {
    check("getPlaybackStream()").that(actual.getPlaybackStream()).isEqualTo(playbackStream);
    return this;
  }

  public MediaRouteDescriptorSubject hasPlaybackType(int playbackType) {
    check("getPlaybackType()").that(actual.getPlaybackType()).isEqualTo(playbackType);
    return this;
  }

  public MediaRouteDescriptorSubject hasPresentationDisplayId(int displayId) {
    check("getPresentationDisplayId()").that(actual.getPresentationDisplayId()).isEqualTo(displayId);
    return this;
  }

  public MediaRouteDescriptorSubject hasVolume(int volume) {
    check("getVolume()").that(actual.getVolume()).isEqualTo(volume);
    return this;
  }

  public MediaRouteDescriptorSubject hasVolumeHandling(@MediaSessionStatusState int volumeHandling) {
    int actualHandling = actual.getVolumeHandling();
    //noinspection WrongConstant
    check("getVolumeHandling()")
        .withMessage("Expected volume handling <%s> but was <%s>.",
            volumeHandling(volumeHandling), volumeHandling(actualHandling))
        .that(actualHandling)
        .isEqualTo(volumeHandling);
    return this;
  }

  public MediaRouteDescriptorSubject hasVolumeMax(int volumeMax) {
    check("getVolumeMax()").that(actual.getVolumeMax()).isEqualTo(volumeMax);
    return this;
  }

  @SuppressWarnings("deprecation")
  public MediaRouteDescriptorSubject isConnecting() {
    check("isConnecting()").that(actual.isConnecting()).isTrue();
    return this;
  }

  @SuppressWarnings("deprecation")
  public MediaRouteDescriptorSubject isNotConnecting() {
    check("isConnecting()").that(actual.isConnecting()).isFalse();
    return this;
  }

  public MediaRouteDescriptorSubject isEnabled() {
    check("isEnabled()").that(actual.isEnabled()).isTrue();
    return this;
  }

  public MediaRouteDescriptorSubject isDisabled() {
    check("isEnabled()").that(actual.isEnabled()).isFalse();
    return this;
  }

  public MediaRouteDescriptorSubject isValid() {
    check("isValid()").that(actual.isValid()).isTrue();
    return this;
  }

  public MediaRouteDescriptorSubject isNotValid() {
    check("isValid()").that(actual.isValid()).isFalse();
    return this;
  }
}
