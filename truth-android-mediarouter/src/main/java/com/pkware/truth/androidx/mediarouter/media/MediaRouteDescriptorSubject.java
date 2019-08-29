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
package com.pkware.truth.androidx.mediarouter.media;

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

  public void hasDescription(String description) {
    check("getDescription()").that(actual.getDescription()).isEqualTo(description);
  }

  public void hasId(@Nullable String id) {
    check("getId()").that(actual.getId()).isEqualTo(id);
  }

  public void hasName(@Nullable String name) {
    check("getName()").that(actual.getName()).isEqualTo(name);
  }

  public void hasPlaybackStream(int playbackStream) {
    check("getPlaybackStream()").that(actual.getPlaybackStream()).isEqualTo(playbackStream);
  }

  public void hasPlaybackType(int playbackType) {
    check("getPlaybackType()").that(actual.getPlaybackType()).isEqualTo(playbackType);
  }

  public void hasPresentationDisplayId(int displayId) {
    check("getPresentationDisplayId()").that(actual.getPresentationDisplayId()).isEqualTo(displayId);
  }

  public void hasVolume(int volume) {
    check("getVolume()").that(actual.getVolume()).isEqualTo(volume);
  }

  public void hasVolumeHandling(@MediaSessionStatusState int volumeHandling) {
    int actualHandling = actual.getVolumeHandling();
    //noinspection WrongConstant
    check("getVolumeHandling()")
        .withMessage("Expected volume handling <%s> but was <%s>.",
            volumeHandling(volumeHandling), volumeHandling(actualHandling))
        .that(actualHandling)
        .isEqualTo(volumeHandling);
  }

  public void hasVolumeMax(int volumeMax) {
    check("getVolumeMax()").that(actual.getVolumeMax()).isEqualTo(volumeMax);
  }

  @SuppressWarnings("deprecation")
  public void isConnecting() {
    check("isConnecting()").that(actual.isConnecting()).isTrue();
  }

  @SuppressWarnings("deprecation")
  public void isNotConnecting() {
    check("isConnecting()").that(actual.isConnecting()).isFalse();
  }

  public void isEnabled() {
    check("isEnabled()").that(actual.isEnabled()).isTrue();
  }

  public void isDisabled() {
    check("isEnabled()").that(actual.isEnabled()).isFalse();
  }

  public void isValid() {
    check("isValid()").that(actual.isValid()).isTrue();
  }

  public void isNotValid() {
    check("isValid()").that(actual.isValid()).isFalse();
  }
}
