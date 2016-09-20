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

import android.content.ComponentName;
import android.support.v7.media.MediaRouteProvider;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link MediaRouteProvider.ProviderMetadata} subjects.
 */
public class MediaRouteProviderProviderMetadataSubject extends
    Subject<MediaRouteProviderProviderMetadataSubject, MediaRouteProvider.ProviderMetadata> {

  protected MediaRouteProviderProviderMetadataSubject(FailureStrategy failureStrategy, MediaRouteProvider.ProviderMetadata subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<MediaRouteProviderProviderMetadataSubject, MediaRouteProvider.ProviderMetadata> type() {
    return new SubjectFactory<MediaRouteProviderProviderMetadataSubject, MediaRouteProvider.ProviderMetadata>() {
      @Override
      public MediaRouteProviderProviderMetadataSubject getSubject(FailureStrategy fs, MediaRouteProvider.ProviderMetadata that) {
        return new MediaRouteProviderProviderMetadataSubject(fs, that);
      }
    };
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
