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
import android.support.v7.media.MediaRouter;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link MediaRouter.ProviderInfo} subjects.
 */
public class MediaRouterProviderInfoSubject
    extends Subject<MediaRouterProviderInfoSubject, MediaRouter.ProviderInfo> {

  protected MediaRouterProviderInfoSubject(FailureStrategy failureStrategy, MediaRouter.ProviderInfo subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<MediaRouterProviderInfoSubject, MediaRouter.ProviderInfo> type() {
    return new SubjectFactory<MediaRouterProviderInfoSubject, MediaRouter.ProviderInfo>() {
      @Override
      public MediaRouterProviderInfoSubject getSubject(FailureStrategy fs, MediaRouter.ProviderInfo that) {
        return new MediaRouterProviderInfoSubject(fs, that);
      }
    };
  }

  public MediaRouterProviderInfoSubject hasComponentName(ComponentName componentName) {
    assertThat(getSubject().getComponentName())
        .named("component name")
        .isEqualTo(componentName);
    return this;
  }

  public MediaRouterProviderInfoSubject hasPackageName(String packageName) {
    assertThat(getSubject().getPackageName())
        .named("package name")
        .isEqualTo(packageName);
    return this;
  }
}
