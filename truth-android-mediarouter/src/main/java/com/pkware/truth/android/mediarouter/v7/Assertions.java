// Copyright 2019 PKWARE, Inc.
//
// This class is generated. Do not modify directly!
package com.pkware.truth.android.mediarouter.v7;

import static com.google.common.truth.Truth.assertAbout;

/** Assertions for testing Android classes. */
@SuppressWarnings("deprecation")
public final class Assertions {
  public static com.pkware.truth.android.mediarouter.v7.media.MediaItemStatusSubject assertThat(
      androidx.mediarouter.media.MediaItemStatus target) {
    return assertAbout(com.pkware.truth.android.mediarouter.v7.media.MediaItemStatusSubject::new).that(target);
  }

  public static com.pkware.truth.android.mediarouter.v7.media.MediaRouteDescriptorSubject assertThat(
      androidx.mediarouter.media.MediaRouteDescriptor target) {
    return assertAbout(com.pkware.truth.android.mediarouter.v7.media.MediaRouteDescriptorSubject::new).that(target);
  }

  public static com.pkware.truth.android.mediarouter.v7.media.MediaRouteDiscoveryRequestSubject assertThat(
      androidx.mediarouter.media.MediaRouteDiscoveryRequest target) {
    return assertAbout(com.pkware.truth.android.mediarouter.v7.media.MediaRouteDiscoveryRequestSubject::new).that(target);
  }

  public static com.pkware.truth.android.mediarouter.v7.media.MediaRouteProviderProviderMetadataSubject assertThat(
      androidx.mediarouter.media.MediaRouteProvider.ProviderMetadata target) {
    return assertAbout(com.pkware.truth.android.mediarouter.v7.media.MediaRouteProviderProviderMetadataSubject::new).that(target);
  }

  public static com.pkware.truth.android.mediarouter.v7.media.MediaRouterProviderInfoSubject assertThat(
      androidx.mediarouter.media.MediaRouter.ProviderInfo target) {
    return assertAbout(com.pkware.truth.android.mediarouter.v7.media.MediaRouterProviderInfoSubject::new).that(target);
  }

  public static com.pkware.truth.android.mediarouter.v7.media.MediaRouterRouteInfoSubject assertThat(
      androidx.mediarouter.media.MediaRouter.RouteInfo target) {
    return assertAbout(com.pkware.truth.android.mediarouter.v7.media.MediaRouterRouteInfoSubject::new).that(target);
  }

  public static com.pkware.truth.android.mediarouter.v7.media.MediaSessionStatusSubject assertThat(
      androidx.mediarouter.media.MediaSessionStatus target) {
    return assertAbout(com.pkware.truth.android.mediarouter.v7.media.MediaSessionStatusSubject::new).that(target);
  }

  public static com.pkware.truth.android.mediarouter.v7.media.RemotePlaybackClientSubject assertThat(
      androidx.mediarouter.media.RemotePlaybackClient target) {
    return assertAbout(com.pkware.truth.android.mediarouter.v7.media.RemotePlaybackClientSubject::new).that(target);
  }

  private Assertions() {
    throw new AssertionError("No instances.");
  }
}
