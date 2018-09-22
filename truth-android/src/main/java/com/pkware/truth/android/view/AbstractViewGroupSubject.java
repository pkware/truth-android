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
package com.pkware.truth.android.view;

import android.annotation.TargetApi;
import android.view.View;
import android.view.ViewGroup;

import com.google.common.truth.FailureMetadata;

import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR2;
import static android.view.ViewGroup.FOCUS_AFTER_DESCENDANTS;
import static android.view.ViewGroup.FOCUS_BEFORE_DESCENDANTS;
import static android.view.ViewGroup.FOCUS_BLOCK_DESCENDANTS;
import static android.view.ViewGroup.LAYOUT_MODE_CLIP_BOUNDS;
import static android.view.ViewGroup.LAYOUT_MODE_OPTICAL_BOUNDS;
import static android.view.ViewGroup.PERSISTENT_ALL_CACHES;
import static android.view.ViewGroup.PERSISTENT_ANIMATION_CACHE;
import static android.view.ViewGroup.PERSISTENT_NO_CACHE;
import static android.view.ViewGroup.PERSISTENT_SCROLLING_CACHE;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assert_;
import static com.pkware.truth.android.internal.IntegerUtils.buildNamedValueString;

public abstract class AbstractViewGroupSubject<S extends AbstractViewGroupSubject<S, T>, T extends ViewGroup>
    extends AbstractViewSubject<S, T> {
  protected AbstractViewGroupSubject(FailureMetadata failureMetadata, T subject) {
    super(failureMetadata, subject);
  }

  public static String descendantFocusabilityToString(@ViewGroupDescendantFocusability int focusability) {
    return buildNamedValueString(focusability)
        .value(FOCUS_AFTER_DESCENDANTS, "afterDescendants")
        .value(FOCUS_BEFORE_DESCENDANTS, "beforeDescendants")
        .value(FOCUS_BLOCK_DESCENDANTS, "blockDescendants")
        .get();
  }

  public static String persistentDrawingCacheToString(@ViewGroupPersistentDrawingCache int cache) {
    return buildNamedValueString(cache)
        .value(PERSISTENT_ALL_CACHES, "all")
        .value(PERSISTENT_ANIMATION_CACHE, "animation")
        .value(PERSISTENT_NO_CACHE, "none")
        .value(PERSISTENT_SCROLLING_CACHE, "scrolling")
        .get();
  }

  public static String layoutModeToString(@ViewGroupLayoutMode int layoutMode) {
    return buildNamedValueString(layoutMode)
        .value(LAYOUT_MODE_CLIP_BOUNDS, "clip_bounds")
        .value(LAYOUT_MODE_OPTICAL_BOUNDS, "optical_bounds")
        .get();
  }

  public S isAddingStatesFromChildren() {
    assertThat(actual().addStatesFromChildren())
        .named("is adding states from children")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotAddingStatesFromChildren() {
    assertThat(actual().addStatesFromChildren())
        .named("is adding states from children")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S hasChildCount(int count) {
    assertThat(actual().getChildCount())
        .named("child count")
        .isEqualTo(count);
    //noinspection unchecked
    return (S) this;
  }

  public S hasDescendantFocusability(@ViewGroupDescendantFocusability int focusability) {
    int actualFocusability = actual().getDescendantFocusability();
    //noinspection ResourceType
    assert_()
        .withMessage("Expected descendant focusability <%s> but was <%s>",
            descendantFocusabilityToString(focusability),
            descendantFocusabilityToString(actualFocusability))
        .that(actualFocusability)
        .isEqualTo(focusability);
    //noinspection unchecked
    return (S) this;
  }

  public S hasFocusedChild(View view) {
    assertThat(actual().getFocusedChild())
        .named("focused child")
        .isSameAs(view);
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(JELLY_BEAN_MR2)
  public S hasLayoutMode(@ViewGroupLayoutMode int layoutMode) {
    int actualLayoutMode = actual().getLayoutMode();
    //noinspection ResourceType
    assert_()
        .withMessage("Expected layout mode <%s> but was <%s>.",
            layoutModeToString(layoutMode), layoutModeToString(actualLayoutMode))
        .that(actualLayoutMode)
        .isEqualTo(layoutMode);
    //noinspection unchecked
    return (S) this;
  }

  public S hasPersistentDrawingCache(@ViewGroupPersistentDrawingCache int cache) {
    int actualCache = actual().getPersistentDrawingCache();
    //noinspection ResourceType
    assert_()
        .withMessage("Expected persistent drawing cache <%s> but was <%s>",
            persistentDrawingCacheToString(cache), persistentDrawingCacheToString(actualCache))
        .that(actualCache)
        .isEqualTo(cache);
    //noinspection unchecked
    return (S) this;
  }

  public S isAlwaysDrawnWithCache() {
    assertThat(actual().isAlwaysDrawnWithCacheEnabled())
        .named("is always drawn with cache enabled")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotAlwaysDrawnWithCache() {
    assertThat(actual().isAlwaysDrawnWithCacheEnabled())
        .named("is always drawn with cache enabled")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(JELLY_BEAN_MR2)
  public S isClippingChildren() {
    assertThat(actual().getClipChildren())
        .named("is clipping children")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(JELLY_BEAN_MR2)
  public S isNotClippingChildren() {
    assertThat(actual().getClipChildren())
        .named("is clipping children")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S hasAnimationCacheEnabled() {
    assertThat(actual().isAnimationCacheEnabled())
        .named("is animation cache enabled")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S hasAnimationCacheDisabled() {
    assertThat(actual().isAnimationCacheEnabled())
        .named("is animation cache enabled")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S hasMotionEventSplittingEnabled() {
    assertThat(actual().isMotionEventSplittingEnabled())
        .named("is motion event splitting enabled")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S hasMotionEventSplittingDisabled() {
    assertThat(actual().isMotionEventSplittingEnabled())
        .named("is motion event splitting enabled")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }
}
