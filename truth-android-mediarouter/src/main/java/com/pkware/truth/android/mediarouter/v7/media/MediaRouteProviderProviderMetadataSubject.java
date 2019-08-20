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

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link MediaRouteProvider.ProviderMetadata} subjects.
 */
public class MediaRouteProviderProviderMetadataSubject extends
    Subject<MediaRouteProviderProviderMetadataSubject, MediaRouteProvider.ProviderMetadata> {

  public MediaRouteProviderProviderMetadataSubject(FailureMetadata failureMetadata, MediaRouteProvider.ProviderMetadata subject) {
    super(failureMetadata, subject);
  }

  public MediaRouteProviderProviderMetadataSubject hasComponentName(ComponentName componentName) {
    assertThat(actual().getComponentName())
        .named("component name")
        .isEqualTo(componentName);
    return this;
  }

  public MediaRouteProviderProviderMetadataSubject hasPackageName(String packageName) {
    assertThat(actual().getPackageName())
        .named("package name")
        .isEqualTo(packageName);
    return this;
  }
}
