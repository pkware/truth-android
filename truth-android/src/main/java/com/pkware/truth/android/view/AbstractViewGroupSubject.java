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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

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
import static com.pkware.truth.android.internal.IntegerUtils.buildNamedValueString;

public abstract class AbstractViewGroupSubject<T extends ViewGroup>
    extends AbstractViewSubject<T> {

  @Nullable
  private final T actual;

  protected AbstractViewGroupSubject(@Nonnull FailureMetadata failureMetadata, @Nullable T actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  @Nonnull
  public static String descendantFocusabilityToString(@ViewGroupDescendantFocusability int focusability) {
    return buildNamedValueString(focusability)
        .value(FOCUS_AFTER_DESCENDANTS, "afterDescendants")
        .value(FOCUS_BEFORE_DESCENDANTS, "beforeDescendants")
        .value(FOCUS_BLOCK_DESCENDANTS, "blockDescendants")
        .get();
  }

  @Nonnull
  public static String persistentDrawingCacheToString(@ViewGroupPersistentDrawingCache int cache) {
    return buildNamedValueString(cache)
        .value(PERSISTENT_ALL_CACHES, "all")
        .value(PERSISTENT_ANIMATION_CACHE, "animation")
        .value(PERSISTENT_NO_CACHE, "none")
        .value(PERSISTENT_SCROLLING_CACHE, "scrolling")
        .get();
  }

  @Nonnull
  public static String layoutModeToString(@ViewGroupLayoutMode int layoutMode) {
    return buildNamedValueString(layoutMode)
        .value(LAYOUT_MODE_CLIP_BOUNDS, "clip_bounds")
        .value(LAYOUT_MODE_OPTICAL_BOUNDS, "optical_bounds")
        .get();
  }

  public void isAddingStatesFromChildren() {
    check("addStatesFromChildren()").that(actual.addStatesFromChildren()).isTrue();
  }

  public void isNotAddingStatesFromChildren() {
    check("addStatesFromChildren()").that(actual.addStatesFromChildren()).isFalse();
  }

  public void hasChildCount(int count) {
    check("getChildCount()").that(actual.getChildCount()).isEqualTo(count);
  }

  public void hasDescendantFocusability(@ViewGroupDescendantFocusability int focusability) {
    int actualFocusability = actual.getDescendantFocusability();
    //noinspection ResourceType
    check("getDescendantFocusability()")
        .withMessage("Expected descendant focusability <%s> but was <%s>",
            descendantFocusabilityToString(focusability),
            descendantFocusabilityToString(actualFocusability))
        .that(actualFocusability)
        .isEqualTo(focusability);
  }

  public void hasFocusedChild(@Nullable View view) {
    check("getFocusedChild()").that(actual.getFocusedChild()).isSameInstanceAs(view);
  }

  @TargetApi(JELLY_BEAN_MR2)
  public void hasLayoutMode(@ViewGroupLayoutMode int layoutMode) {
    int actualLayoutMode = actual.getLayoutMode();
    //noinspection ResourceType
    check("getLayoutMode()")
        .withMessage("Expected layout mode <%s> but was <%s>.",
            layoutModeToString(layoutMode), layoutModeToString(actualLayoutMode))
        .that(actualLayoutMode)
        .isEqualTo(layoutMode);
  }

  public void hasPersistentDrawingCache(@ViewGroupPersistentDrawingCache int cache) {
    int actualCache = actual.getPersistentDrawingCache();
    //noinspection ResourceType
    check("getPersistentDrawingCache()")
        .withMessage("Expected persistent drawing cache <%s> but was <%s>",
            persistentDrawingCacheToString(cache), persistentDrawingCacheToString(actualCache))
        .that(actualCache)
        .isEqualTo(cache);
  }

  public void isAlwaysDrawnWithCache() {
    check("isAlwaysDrawnWithCacheEnabled()").that(actual.isAlwaysDrawnWithCacheEnabled()).isTrue();
  }

  public void isNotAlwaysDrawnWithCache() {
    check("isAlwaysDrawnWithCacheEnabled()").that(actual.isAlwaysDrawnWithCacheEnabled()).isFalse();
  }

  @TargetApi(JELLY_BEAN_MR2)
  public void isClippingChildren() {
    check("getClipChildren()").that(actual.getClipChildren()).isTrue();
  }

  @TargetApi(JELLY_BEAN_MR2)
  public void isNotClippingChildren() {
    check("getClipChildren()").that(actual.getClipChildren()).isFalse();
  }

  public void hasAnimationCacheEnabled() {
    check("isAnimationCacheEnabled()").that(actual.isAnimationCacheEnabled()).isTrue();
  }

  public void hasAnimationCacheDisabled() {
    check("isAnimationCacheEnabled()").that(actual.isAnimationCacheEnabled()).isFalse();
  }

  public void hasMotionEventSplittingEnabled() {
    check("isMotionEventSplittingEnabled()").that(actual.isMotionEventSplittingEnabled()).isTrue();
  }

  public void hasMotionEventSplittingDisabled() {
    check("isMotionEventSplittingEnabled()").that(actual.isMotionEventSplittingEnabled()).isFalse();
  }
}
