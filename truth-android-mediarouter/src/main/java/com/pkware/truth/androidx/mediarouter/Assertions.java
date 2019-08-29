// Copyright 2019 PKWARE, Inc.
//
// This class is generated. Do not modify directly!
package com.pkware.truth.androidx.mediarouter;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static com.google.common.truth.Truth.assertAbout;

/** Assertions for testing Android classes. */
@SuppressWarnings("deprecation")
public final class Assertions {
  @Nonnull
  public static com.pkware.truth.androidx.mediarouter.media.MediaItemStatusSubject assertThat(
      @Nullable androidx.mediarouter.media.MediaItemStatus target) {
    return assertAbout(com.pkware.truth.androidx.mediarouter.media.MediaItemStatusSubject::new).that(target);
  }

  @Nonnull
  public static com.pkware.truth.androidx.mediarouter.media.MediaRouteDescriptorSubject assertThat(
      @Nullable androidx.mediarouter.media.MediaRouteDescriptor target) {
    return assertAbout(com.pkware.truth.androidx.mediarouter.media.MediaRouteDescriptorSubject::new).that(target);
  }

  @Nonnull
  public static com.pkware.truth.androidx.mediarouter.media.MediaRouteDiscoveryRequestSubject assertThat(
      @Nullable androidx.mediarouter.media.MediaRouteDiscoveryRequest target) {
    return assertAbout(com.pkware.truth.androidx.mediarouter.media.MediaRouteDiscoveryRequestSubject::new).that(target);
  }

  @Nonnull
  public static com.pkware.truth.androidx.mediarouter.media.MediaRouteProviderProviderMetadataSubject assertThat(
      @Nullable androidx.mediarouter.media.MediaRouteProvider.ProviderMetadata target) {
    return assertAbout(com.pkware.truth.androidx.mediarouter.media.MediaRouteProviderProviderMetadataSubject::new).that(target);
  }

  @Nonnull
  public static com.pkware.truth.androidx.mediarouter.media.MediaRouterProviderInfoSubject assertThat(
      @Nullable androidx.mediarouter.media.MediaRouter.ProviderInfo target) {
    return assertAbout(com.pkware.truth.androidx.mediarouter.media.MediaRouterProviderInfoSubject::new).that(target);
  }

  @Nonnull
  public static com.pkware.truth.androidx.mediarouter.media.MediaRouterRouteInfoSubject assertThat(
      @Nullable androidx.mediarouter.media.MediaRouter.RouteInfo target) {
    return assertAbout(com.pkware.truth.androidx.mediarouter.media.MediaRouterRouteInfoSubject::new).that(target);
  }

  @Nonnull
  public static com.pkware.truth.androidx.mediarouter.media.MediaSessionStatusSubject assertThat(
      @Nullable androidx.mediarouter.media.MediaSessionStatus target) {
    return assertAbout(com.pkware.truth.androidx.mediarouter.media.MediaSessionStatusSubject::new).that(target);
  }

  @Nonnull
  public static com.pkware.truth.androidx.mediarouter.media.RemotePlaybackClientSubject assertThat(
      @Nullable androidx.mediarouter.media.RemotePlaybackClient target) {
    return assertAbout(com.pkware.truth.androidx.mediarouter.media.RemotePlaybackClientSubject::new).that(target);
  }

  private Assertions() {
    throw new AssertionError("No instances.");
  }
}
