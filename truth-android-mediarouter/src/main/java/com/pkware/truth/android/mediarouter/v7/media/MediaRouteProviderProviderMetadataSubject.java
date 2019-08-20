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

import android.content.ComponentName;

import androidx.mediarouter.media.MediaRouteProvider;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link MediaRouteProvider.ProviderMetadata} subjects.
 */
public class MediaRouteProviderProviderMetadataSubject extends Subject {

  @Nullable
  private final MediaRouteProvider.ProviderMetadata actual;

  public MediaRouteProviderProviderMetadataSubject(@Nonnull FailureMetadata failureMetadata, @Nullable MediaRouteProvider.ProviderMetadata actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public MediaRouteProviderProviderMetadataSubject hasComponentName(@Nullable ComponentName componentName) {
    check("getComponentName()").that(actual.getComponentName()).isEqualTo(componentName);
    return this;
  }

  public MediaRouteProviderProviderMetadataSubject hasPackageName(@Nullable String packageName) {
    check("getPackageName()").that(actual.getPackageName()).isEqualTo(packageName);
    return this;
  }
}
