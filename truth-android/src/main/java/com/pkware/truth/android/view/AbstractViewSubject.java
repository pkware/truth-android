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
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.Animation;

import androidx.annotation.IdRes;
import androidx.annotation.StringRes;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.os.Build.VERSION_CODES.JELLY_BEAN;
import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR1;
import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR2;
import static android.os.Build.VERSION_CODES.KITKAT;
import static android.os.Build.VERSION_CODES.LOLLIPOP;
import static android.view.View.GONE;
import static android.view.View.INVISIBLE;
import static android.view.View.LAYER_TYPE_HARDWARE;
import static android.view.View.LAYER_TYPE_NONE;
import static android.view.View.LAYER_TYPE_SOFTWARE;
import static android.view.View.LAYOUT_DIRECTION_INHERIT;
import static android.view.View.LAYOUT_DIRECTION_LOCALE;
import static android.view.View.LAYOUT_DIRECTION_LTR;
import static android.view.View.LAYOUT_DIRECTION_RTL;
import static android.view.View.OVER_SCROLL_ALWAYS;
import static android.view.View.OVER_SCROLL_IF_CONTENT_SCROLLS;
import static android.view.View.OVER_SCROLL_NEVER;
import static android.view.View.SCROLLBARS_INSIDE_INSET;
import static android.view.View.SCROLLBARS_INSIDE_OVERLAY;
import static android.view.View.SCROLLBARS_OUTSIDE_INSET;
import static android.view.View.SCROLLBARS_OUTSIDE_OVERLAY;
import static android.view.View.SCROLLBAR_POSITION_DEFAULT;
import static android.view.View.SCROLLBAR_POSITION_LEFT;
import static android.view.View.SCROLLBAR_POSITION_RIGHT;
import static android.view.View.TEXT_ALIGNMENT_CENTER;
import static android.view.View.TEXT_ALIGNMENT_GRAVITY;
import static android.view.View.TEXT_ALIGNMENT_INHERIT;
import static android.view.View.TEXT_ALIGNMENT_TEXT_END;
import static android.view.View.TEXT_ALIGNMENT_TEXT_START;
import static android.view.View.TEXT_ALIGNMENT_VIEW_END;
import static android.view.View.TEXT_ALIGNMENT_VIEW_START;
import static android.view.View.TEXT_DIRECTION_ANY_RTL;
import static android.view.View.TEXT_DIRECTION_FIRST_STRONG;
import static android.view.View.TEXT_DIRECTION_INHERIT;
import static android.view.View.TEXT_DIRECTION_LOCALE;
import static android.view.View.TEXT_DIRECTION_LTR;
import static android.view.View.TEXT_DIRECTION_RTL;
import static android.view.View.VISIBLE;
import static com.pkware.truth.android.internal.IntegerUtils.buildNamedValueString;

public abstract class AbstractViewSubject<T extends View> extends Subject {

  @Nullable
  private final T actual;

  protected AbstractViewSubject(@Nonnull FailureMetadata failureMetadata, @Nullable T actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  @Nonnull
  public static String visibilityToString(@ViewVisibility int visibility) {
    return buildNamedValueString(visibility)
        .value(VISIBLE, "visible")
        .value(INVISIBLE, "invisible")
        .value(GONE, "gone")
        .get();
  }

  @Nonnull
  public static String layerTypeToString(@ViewLayerType int type) {
    return buildNamedValueString(type)
        .value(LAYER_TYPE_NONE, "none")
        .value(LAYER_TYPE_SOFTWARE, "software")
        .value(LAYER_TYPE_HARDWARE, "hardware")
        .get();
  }

  @Nonnull
  @TargetApi(JELLY_BEAN_MR1)
  public static String layoutDirectionToString(@ViewLayoutDirection int direction) {
    return buildNamedValueString(direction)
        .value(LAYOUT_DIRECTION_RTL, "right_to_left")
        .value(LAYOUT_DIRECTION_LTR, "left_to_right")
        .value(LAYOUT_DIRECTION_INHERIT, "inherit")
        .value(LAYOUT_DIRECTION_LOCALE, "locale")
        .get();
  }

  @Nonnull
  public static String overScrollModeToString(@ViewOverscrollMode int mode) {
    return buildNamedValueString(mode)
        .value(OVER_SCROLL_ALWAYS, "always")
        .value(OVER_SCROLL_IF_CONTENT_SCROLLS, "ifContentScrolls")
        .value(OVER_SCROLL_NEVER, "never")
        .get();
  }

  @Nonnull
  public static String scrollBarStyleToString(@ViewScrollBarStyle int style) {
    return buildNamedValueString(style)
        .value(SCROLLBARS_INSIDE_INSET, "insideInset")
        .value(SCROLLBARS_INSIDE_OVERLAY, "insideOverlay")
        .value(SCROLLBARS_OUTSIDE_INSET, "outsideInset")
        .value(SCROLLBARS_OUTSIDE_OVERLAY, "outsideOverlay")
        .get();
  }

  public static String verticalScrollBarPositionToString(@ViewScrollBarPosition int position) {
    return buildNamedValueString(position)
        .value(SCROLLBAR_POSITION_DEFAULT, "default")
        .value(SCROLLBAR_POSITION_LEFT, "left")
        .value(SCROLLBAR_POSITION_RIGHT, "right")
        .get();
  }

  @Nonnull
  public static String textAlignmentToString(@ViewTextAlignment int alignment) {
    return buildNamedValueString(alignment)
        .value(TEXT_ALIGNMENT_INHERIT, "inherit")
        .value(TEXT_ALIGNMENT_GRAVITY, "gravity")
        .value(TEXT_ALIGNMENT_TEXT_START, "text_start")
        .value(TEXT_ALIGNMENT_TEXT_END, "text_end")
        .value(TEXT_ALIGNMENT_CENTER, "center")
        .value(TEXT_ALIGNMENT_VIEW_START, "view_start")
        .value(TEXT_ALIGNMENT_VIEW_END, "view_end")
        .get();
  }

  @Nonnull
  public static String textDirectionToString(@ViewTextDirection int direction) {
    return buildNamedValueString(direction)
        .value(TEXT_DIRECTION_INHERIT, "inherit")
        .value(TEXT_DIRECTION_FIRST_STRONG, "first_strong")
        .value(TEXT_DIRECTION_ANY_RTL, "any_right_to_left")
        .value(TEXT_DIRECTION_LTR, "left_to_right")
        .value(TEXT_DIRECTION_RTL, "right_to_left")
        .value(TEXT_DIRECTION_LOCALE, "locale")
        .get();
  }

  public void hasAlpha(float alpha, float tolerance) {
    check("getAlpha()").that(actual.getAlpha()).isWithin(tolerance).of(alpha);
  }

  public void hasAnimation(@Nullable Animation animation) {
    check("getAnimation()").that(actual.getAnimation()).isSameInstanceAs(animation);
  }

  public void hasBackground(@Nullable Drawable background) {
    check("getBackground()").that(actual.getBackground()).isSameInstanceAs(background);
  }

  public void hasBaseline(int baseline) {
    check("getBaseline()").that(actual.getBaseline()).isEqualTo(baseline);
  }

  public void hasBottom(int bottom) {
    check("getBottom()").that(actual.getBottom()).isEqualTo(bottom);
  }

  public void hasContentDescription(@Nullable String contentDescription) {
    check("getContentDescription()")
        .that(actual.getContentDescription().toString())
        .isEqualTo(contentDescription);
  }

  public void hasContentDescription(@StringRes int resId) {
    hasContentDescription(actual.getContext().getString(resId));
  }

  public void hasDrawingCacheBackgroundColor(int color) {
    int actualColor = actual.getDrawingCacheBackgroundColor();
    check("getDrawingCacheBackgroundColor()")
        .withMessage("Expected drawing cache background color <%s> but was <%s>",
            Integer.toHexString(color), Integer.toHexString(actualColor))
        .that(actualColor)
        .isEqualTo(color);
  }

  public void hasDrawingCacheQuality(int quality) {
    check("getDrawingCacheQuality()").that(actual.getDrawingCacheQuality()).isEqualTo(quality);
  }

  @TargetApi(LOLLIPOP)
  public void hasElevation(float elevation, float tolerance) {
    check("getElevation()").that(actual.getElevation()).isWithin(tolerance).of(elevation);
  }

  public void hasHeight(int height) {
    check("getHeight()").that(actual.getHeight()).isEqualTo(height);
  }

  public void hasHorizontalFadingEdgeLength(int length) {
    check("getHorizontalFadingEdgeLength()").that(actual.getHorizontalFadingEdgeLength()).isEqualTo(length);
  }

  public void hasId(int id) {
    int actualId = actual.getId();
    check("getId()")
        .withMessage("Expected ID <%s> but was <%s>", Integer.toHexString(id),
            Integer.toHexString(actualId))
        .that(actualId)
        .isEqualTo(id);
  }

  @TargetApi(LOLLIPOP)
  public void isImportantForAccessibility() {
    check("isImportantForAccessibility()").that(actual.isImportantForAccessibility()).isTrue();
  }

  @TargetApi(LOLLIPOP)
  public void isNotImportantForAccessibility() {
    check("isImportantForAccessibility()").that(actual.isImportantForAccessibility()).isFalse();
  }

  public void isKeepingScreenOn() {
    check("getKeepScreenOn()").that(actual.getKeepScreenOn()).isTrue();
  }

  public void isNotKeepingScreenOn() {
    check("getKeepScreenOn()").that(actual.getKeepScreenOn()).isFalse();
  }

  @TargetApi(JELLY_BEAN_MR1)
  public void isLabelFor(@IdRes int id) {
    check("getLabelFor()").that(actual.getLabelFor()).isEqualTo(id);
  }

  public void hasLayerType(@ViewLayerType int type) {
    int actualType = actual.getLayerType();
    //noinspection ResourceType
    check("getLayerType()")
        .withMessage("Expected layer type <%s> but was <%s>", layerTypeToString(type),
            layerTypeToString(actualType))
        .that(actualType)
        .isEqualTo(type);
  }

  @TargetApi(JELLY_BEAN_MR1)
  public void hasLayoutDirection(int direction) {
    int actualDirection = actual.getLayoutDirection();
    check("getLayoutDirection()")
        .withMessage("Expected layout direction <%s> but was <%s>",
            layoutDirectionToString(direction), layoutDirectionToString(actualDirection))
        .that(actualDirection)
        .isEqualTo(direction);
  }

  public void hasLeft(int left) {
    check("getLeft()").that(actual.getLeft()).isEqualTo(left);
  }

  public void hasMeasuredHeight(int height) {
    check("getMeasuredHeight()").that(actual.getMeasuredHeight()).isEqualTo(height);
  }

  public void hasMeasuredHeightAndState(int heightAndState) {
    check("getMeasuredHeightAndState()").that(actual.getMeasuredHeightAndState()).isEqualTo(heightAndState);
  }

  public void hasMeasuredState(int state) {
    check("getMeasuredState()").that(actual.getMeasuredState()).isEqualTo(state);
  }

  public void hasMeasuredWidth(int width) {
    check("getMeasuredWidth()").that(actual.getMeasuredWidth()).isEqualTo(width);
  }

  public void hasMeasuredWidthAndState(int widthAndState) {
    check("getMeasuredWidthAndState()").that(actual.getMeasuredWidthAndState()).isEqualTo(widthAndState);
  }

  @TargetApi(JELLY_BEAN)
  public void hasMinimumHeight(int height) {
    check("getMinimumHeight()").that(actual.getMinimumHeight()).isEqualTo(height);
  }

  @TargetApi(JELLY_BEAN)
  public void hasMinimumWidth(int width) {
    check("getMinimumWidth()").that(actual.getMinimumWidth()).isEqualTo(width);
  }

  public void hasNextFocusDownId(@IdRes int id) {
    check("getNextFocusDownId()").that(actual.getNextFocusDownId()).isEqualTo(id);
  }

  public void hasNextFocusForwardId(@IdRes int id) {
    check("getNextFocusForwardId()").that(actual.getNextFocusForwardId()).isEqualTo(id);
  }

  public void hasNextFocusLeftId(@IdRes int id) {
    check("getNextFocusLeftId()").that(actual.getNextFocusLeftId()).isEqualTo(id);
  }

  public void hasNextFocusRightId(@IdRes int id) {
    check("getNextFocusRightId()").that(actual.getNextFocusRightId()).isEqualTo(id);
  }

  public void hasNextFocusUpId(@IdRes int id) {
    check("getNextFocusUpId()").that(actual.getNextFocusUpId()).isEqualTo(id);
  }

  public void hasOverScrollMode(@ViewOverscrollMode int mode) {
    int actualMode = actual.getOverScrollMode();
    //noinspection ResourceType
    check("getOverScrollMode()")
        .withMessage("Expected over scroll mode <%s> but was <%s>",
            overScrollModeToString(mode), overScrollModeToString(actualMode))
        .that(actualMode)
        .isEqualTo(mode);
  }

  public void hasPaddingBottom(int padding) {
    check("getPaddingBottom()").that(actual.getPaddingBottom()).isEqualTo(padding);
  }

  @TargetApi(JELLY_BEAN_MR1)
  public void hasPaddingEnd(int padding) {
    check("getPaddingEnd()").that(actual.getPaddingEnd()).isEqualTo(padding);
  }

  public void hasPaddingLeft(int padding) {
    check("getPaddingLeft()").that(actual.getPaddingLeft()).isEqualTo(padding);
  }

  public void hasPaddingRight(int padding) {
    check("getPaddingRight()").that(actual.getPaddingRight()).isEqualTo(padding);
  }

  @TargetApi(JELLY_BEAN_MR1)
  public void hasPaddingStart(int padding) {
    check("getPaddingStart()").that(actual.getPaddingStart()).isEqualTo(padding);
  }

  public void hasPaddingTop(int padding) {
    check("getPaddingTop()").that(actual.getPaddingTop()).isEqualTo(padding);
  }

  public void hasParent(@Nullable ViewParent parent) {
    check("getParent()").that(actual.getParent()).isSameInstanceAs(parent);
  }

  @TargetApi(JELLY_BEAN)
  public void hasParentForAccessibility(@Nullable ViewParent parent) {
    check("getParentForAccessibility()").that(actual.getParentForAccessibility()).isSameInstanceAs(parent);
  }

  public void hasPivotX(float pivotX, float tolerance) {
    check("getPivotX()").that(actual.getPivotX()).isWithin(tolerance).of(pivotX);
  }

  public void hasPivotY(float pivotY, float tolerance) {
    check("getPivotY()").that(actual.getPivotY()).isWithin(tolerance).of(pivotY);
  }

  public void hasRight(int right) {
    check("getRight()").that(actual.getRight()).isEqualTo(right);
  }

  public void hasRootView(@Nullable View view) {
    check("getRootView()").that(actual.getRootView()).isSameInstanceAs(view);
  }

  public void hasRotation(float rotation, float tolerance) {
    check("getRotation()").that(actual.getRotation()).isWithin(tolerance).of(rotation);
  }

  public void hasRotationX(float rotation, float tolerance) {
    check("getRotationX()").that(actual.getRotationX()).isWithin(tolerance).of(rotation);
  }

  public void hasRotationY(float rotation, float tolerance) {
    check("getRotationY()").that(actual.getRotationY()).isWithin(tolerance).of(rotation);
  }

  public void hasScaleX(float scale, float tolerance) {
    check("getScaleX()").that(actual.getScaleX()).isWithin(tolerance)
        .of(scale);
  }

  public void hasScaleY(float scale, float tolerance) {
    check("getScaleY()").that(actual.getScaleY()).isWithin(tolerance).of(scale);
  }

  @TargetApi(JELLY_BEAN)
  public void hasScrollBarDefaultDelayBeforeFade(int fade) {
    check("getScrollBarDefaultDelayBeforeFade()").that(actual.getScrollBarDefaultDelayBeforeFade()).isEqualTo(fade);
  }

  @TargetApi(JELLY_BEAN)
  public void hasScrollBarFadeDuration(int fade) {
    check("getScrollBarFadeDuration()").that(actual.getScrollBarFadeDuration()).isEqualTo(fade);
  }

  @TargetApi(JELLY_BEAN)
  public void hasScrollBarSize(int size) {
    check("getScrollBarSize()").that(actual.getScrollBarSize()).isEqualTo(size);
  }

  public void hasScrollBarStyle(@ViewScrollBarStyle int style) {
    int actualStyle = actual.getScrollBarStyle();
    //noinspection ResourceType
    check("getScrollBarStyle()")
        .withMessage("Expected scroll bar style <%s> but was <%s>",
            scrollBarStyleToString(style), scrollBarStyleToString(actualStyle))
        .that(actualStyle)
        .isEqualTo(style);
  }

  public void hasScrollX(int scroll) {
    check("getScrollX()").that(actual.getScrollX()).isEqualTo(scroll);
  }

  public void hasScrollY(int scroll) {
    check("getScrollY()").that(actual.getScrollY()).isEqualTo(scroll);
  }

  public void hasSolidColor(int color) {
    int actualColor = actual.getSolidColor();
    check("getSolidColor()")
        .withMessage("Expected solid color <%s> but was <%s>",
            Integer.toHexString(color), Integer.toHexString(actualColor))
        .that(actualColor)
        .isEqualTo(color);
  }

  public void hasSystemUiVisibility(int visibility) {
    check("getSystemUiVisibility()").that(actual.getSystemUiVisibility()).isEqualTo(visibility);
  }

  public void hasTag(int key, Object tag) {
    check("getTag(key)").that(actual.getTag(key)).isEqualTo(tag);
  }

  public void hasTag(@Nullable Object tag) {
    check("getTag()").that(actual.getTag()).isEqualTo(tag);
  }

  @TargetApi(JELLY_BEAN_MR1)
  public void hasTextAlignment(@ViewTextAlignment int alignment) {
    int actualAlignment = actual.getTextAlignment();
    check("getTextAlignment()")
        .withMessage("Expected text alignment <%s> but was <%s>",
            textAlignmentToString(alignment), textAlignmentToString(actualAlignment))
        .that(actualAlignment)
        .isEqualTo(alignment);
  }

  @TargetApi(JELLY_BEAN_MR1)
  public void hasTextDirection(@ViewTextDirection int direction) {
    int actualDirection = actual.getTextDirection();
    //noinspection ResourceType
    check("getTextDirection()")
        .withMessage("Expected text direction <%s> but was <%s>",
            textDirectionToString(direction), textDirectionToString(actualDirection))
        .that(actualDirection)
        .isEqualTo(direction);
  }

  public void hasTop(int top) {
    check("getTop()").that(actual.getTop()).isEqualTo(top);
  }

  public void hasTranslationX(float translation, float tolerance) {
    check("getTranslationX()").that(actual.getTranslationX()).isWithin(tolerance).of(translation);
  }

  public void hasTranslationY(float translation, float tolerance) {
    check("getTranslationY()").that(actual.getTranslationY()).isWithin(tolerance).of(translation);
  }

  @TargetApi(LOLLIPOP)
  public void hasTranslationZ(float translation, float tolerance) {
    check("getTranslationZ()").that(actual.getTranslationZ()).isWithin(tolerance).of(translation);
  }

  public void hasVerticalFadingEdgeLength(int length) {
    check("getVerticalFadingEdgeLength()").that(actual.getVerticalFadingEdgeLength()).isEqualTo(length);
  }

  public void hasVerticalScrollbarPosition(int position) {
    int actualPosition = actual.getVerticalScrollbarPosition();
    //noinspection ResourceType
    check("getVerticalScrollbarPosition()")
        .withMessage("Expected vertical scroll bar position <%s> but was <%s>",
            verticalScrollBarPositionToString(position),
            verticalScrollBarPositionToString(actualPosition))
        .that(actualPosition)
        .isEqualTo(position);
  }

  public void hasVerticalScrollbarWidth(int width) {
    check("getVerticalScrollbarWidth()").that(actual.getVerticalScrollbarWidth()).isEqualTo(width);
  }

  public void hasVisibility(@ViewVisibility int visibility) {
    int actualVisibility = actual.getVisibility();
    check("getVisibility()")
        .withMessage("Expected visibility <%s> but was <%s>.",
            visibilityToString(visibility), visibilityToString(actualVisibility))
        .that(actualVisibility)
        .isEqualTo(visibility);
  }

  public void isVisible() {
    int actualVisibility = actual.getVisibility();
    //noinspection ResourceType
    check("getVisibility()")
        .withMessage("Expected to be visible but was %s", visibilityToString(actualVisibility))
        .that(actualVisibility)
        .isEqualTo(VISIBLE);
  }

  public void isNotVisible() {
    int actualVisibility = actual.getVisibility();
    check("getVisibility()")
        .withMessage("Expected to be not visible but was visible")
        .that(actualVisibility)
        .isNotEqualTo(VISIBLE);
  }

  public void isInvisible() {
    int actualVisibility = actual.getVisibility();
    check("getVisibility()")
        .withMessage("Expected to be invisible but was %s",
            visibilityToString(actualVisibility))
        .that(actualVisibility)
        .isEqualTo(INVISIBLE);
  }

  public void isNotInvisible() {
    int actualVisibility = actual.getVisibility();
    check("getVisibility()")
        .withMessage("Expected to be not invisible but was invisible")
        .that(actualVisibility)
        .isNotEqualTo(INVISIBLE);
  }

  public void isGone() {
    int actualVisibility = actual.getVisibility();
    check("getVisibility()")
        .withMessage("Expected to be gone but was %s", visibilityToString(actualVisibility))
        .that(actualVisibility)
        .isEqualTo(GONE);
  }

  public void isNotGone() {
    int actualVisibility = actual.getVisibility();
    check("getVisibility()")
        .withMessage("Expected to be not gone but was gone")
        .that(actualVisibility)
        .isNotEqualTo(GONE);
  }

  public void hasWidth(int width) {
    check("getWidth()").that(actual.getWidth()).isEqualTo(width);
  }

  public void hasWindowVisibility(int visibility) {
    int actualVisibility = actual.getWindowVisibility();
    check("getWindowVisibility()")
        .withMessage("Expected window visibility <%s> but was <%s>",
            visibilityToString(visibility), visibilityToString(actualVisibility))
        .that(actualVisibility)
        .isEqualTo(visibility);
  }

  public void hasX(float x, float tolerance) {
    check("getX()").that(actual.getX()).isWithin(tolerance).of(x);
  }

  public void hasY(float y, float tolerance) {
    check("getY()").that(actual.getY()).isWithin(tolerance).of(y);
  }

  @TargetApi(LOLLIPOP)
  public void hasZ(float z, float tolerance) {
    check("getZ()").that(actual.getZ()).isWithin(tolerance).of(z);
  }

  public void hasFocus() {
    check("hasFocus()").that(actual.hasFocus()).isTrue();
  }

  public void hasNoFocus() {
    check("hasFocus()").that(actual.hasFocus()).isFalse();
  }

  public void hasFocusable() {
    check("hasFocusable()").that(actual.hasFocusable()).isTrue();
  }

  public void isInFocusedWindow() {
    check("hasWindowFocus()").that(actual.hasWindowFocus()).isTrue();
  }

  public void isNotInFocusedWindow() {
    check("hasWindowFocus()").that(actual.hasWindowFocus()).isFalse();
  }

  public void isActivated() {
    check("isActivated()").that(actual.isActivated()).isTrue();
  }

  public void isNotActivated() {
    check("isActivated()").that(actual.isActivated()).isFalse();
  }

  public void isClickable() {
    check("isClickable()").that(actual.isClickable()).isTrue();
  }

  public void isNotClickable() {
    check("isClickable()").that(actual.isClickable()).isFalse();
  }

  public void isDirty() {
    check("isDirty()").that(actual.isDirty()).isTrue();
  }

  public void isNotDirty() {
    check("isDirty()").that(actual.isDirty()).isFalse();
  }

  public void isUsingDrawingCache() {
    check("isDrawingCacheEnabled()").that(actual.isDrawingCacheEnabled()).isTrue();
  }

  public void isNotUsingDrawingCache() {
    check("isDrawingCacheEnabled()").that(actual.isDrawingCacheEnabled()).isFalse();
  }

  public void isDuplicatingParentState() {
    check("isDuplicateParentStateEnabled()").that(actual.isDuplicateParentStateEnabled()).isTrue();
  }

  public void isNotDuplicatingParentState() {
    check("isDuplicateParentStateEnabled()").that(actual.isDuplicateParentStateEnabled()).isFalse();
  }

  public void isEnabled() {
    check("isEnabled()").that(actual.isEnabled()).isTrue();
  }

  public void isDisabled() {
    check("isEnabled()").that(actual.isEnabled()).isFalse();
  }

  public void isFocusable() {
    check("isFocusable()").that(actual.isFocusable()).isTrue();
  }

  public void isNotFocusable() {
    check("isFocusable()").that(actual.isFocusable()).isFalse();
  }

  public void isFocusableInTouchMode() {
    check("isFocusableInTouchMode()").that(actual.isFocusableInTouchMode()).isTrue();
  }

  public void isNotFocusableInTouchMode() {
    check("isFocusableInTouchMode()").that(actual.isFocusableInTouchMode()).isFalse();
  }

  public void isFocused() {
    check("isFocused()").that(actual.isFocused()).isTrue();
  }

  public void isNotFocused() {
    check("isFocused()").that(actual.isFocused()).isFalse();
  }

  public void hasHapticFeedbackEnabled() {
    check("isHapticFeedbackEnabled()").that(actual.isHapticFeedbackEnabled()).isTrue();
  }

  public void hasHapticFeedbackDisabled() {
    check("isHapticFeedbackEnabled()").that(actual.isHapticFeedbackEnabled()).isFalse();
  }

  public void isHardwareAccelerated() {
    check("isHardwareAccelerated()").that(actual.isHardwareAccelerated()).isTrue();
  }

  public void isNotHardwareAccelerated() {
    check("isHardwareAccelerated()").that(actual.isHardwareAccelerated()).isFalse();
  }

  public void hasHorizontalFadingEdgesEnabled() {
    check("isHorizontalFadingEdgeEnabled()").that(actual.isHorizontalFadingEdgeEnabled()).isTrue();
  }

  public void hasHorizontalFadingEdgesDisabled() {
    check("isHorizontalFadingEdgeEnabled()").that(actual.isHorizontalFadingEdgeEnabled()).isFalse();
  }

  public void hasHorizontalScrollbarEnabled() {
    check("isHorizontalScrollBarEnabled()").that(actual.isHorizontalScrollBarEnabled()).isTrue();
  }

  public void hasHorizontalScrollbarDisabled() {
    check("isHorizontalScrollBarEnabled()").that(actual.isHorizontalScrollBarEnabled()).isFalse();
  }

  public void isHovered() {
    check("isHovered()").that(actual.isHovered()).isTrue();
  }

  public void isNotHovered() {
    check("isHovered()").that(actual.isHovered()).isFalse();
  }

  public void isInEditMode() {
    check("isInEditMode()").that(actual.isInEditMode()).isTrue();
  }

  public void isNotInEditMode() {
    check("isInEditMode()").that(actual.isInEditMode()).isFalse();
  }

  @TargetApi(JELLY_BEAN_MR2)
  public void isInLayout() {
    check("isInLayout()").that(actual.isInLayout()).isTrue();
  }

  @TargetApi(JELLY_BEAN_MR2)
  public void isNotInLayout() {
    check("isInLayout()").that(actual.isInLayout()).isFalse();
  }

  public void isInTouchMode() {
    check("isInTouchMode()").that(actual.isInTouchMode()).isTrue();
  }

  public void isNotInTouchMode() {
    check("isInTouchMode()").that(actual.isInTouchMode()).isFalse();
  }

  public void hasLayoutRequested() {
    check("isLayoutRequested()").that(actual.isLayoutRequested()).isTrue();
  }

  public void hasNoLayoutRequested() {
    check("isLayoutRequested()").that(actual.isLayoutRequested()).isFalse();
  }

  public void isLongClickable() {
    check("isLongClickable()").that(actual.isLongClickable()).isTrue();
  }

  public void isNotLongClickable() {
    check("isLongClickable()").that(actual.isLongClickable()).isFalse();
  }

  public void isOpaque() {
    check("isOpaque()").that(actual.isOpaque()).isTrue();
  }

  public void isNotOpaque() {
    check("isOpaque()").that(actual.isOpaque()).isFalse();
  }

  public void isPressed() {
    check("isPressed()").that(actual.isPressed()).isTrue();
  }

  public void isNotPressed() {
    check("isPressed()").that(actual.isPressed()).isFalse();
  }

  public void hasSaveEnabled() {
    check("isSaveEnabled()").that(actual.isSaveEnabled()).isTrue();
  }

  public void hasSaveDisabled() {
    check("isSaveEnabled()").that(actual.isSaveEnabled()).isFalse();
  }

  public void hasSaveFromParentEnabled() {
    check("isSaveFromParentEnabled()").that(actual.isSaveFromParentEnabled()).isTrue();
  }

  public void hasSaveFromParentDisabled() {
    check("isSaveFromParentEnabled()").that(actual.isSaveFromParentEnabled()).isFalse();
  }

  @TargetApi(JELLY_BEAN)
  public void isScrollContainer() {
    check("isScrollContainer()").that(actual.isScrollContainer()).isTrue();
  }

  @TargetApi(JELLY_BEAN)
  public void isNotScrollContainer() {
    check("isScrollContainer()").that(actual.isScrollContainer()).isFalse();
  }

  public void hasScrollbarFadingEnabled() {
    check("isScrollbarFadingEnabled()").that(actual.isScrollbarFadingEnabled()).isTrue();
  }

  public void hasScrollbarFadingDisabled() {
    check("isScrollbarFadingEnabled()").that(actual.isScrollbarFadingEnabled()).isFalse();
  }

  public void isSelected() {
    check("isSelected()").that(actual.isSelected()).isTrue();
  }

  public void isNotSelected() {
    check("isSelected()").that(actual.isSelected()).isFalse();
  }

  public void isShown() {
    check("isShown()").that(actual.isShown()).isTrue();
  }

  public void isNotShown() {
    check("isShown()").that(actual.isShown()).isFalse();
  }

  public void hasSoundEffectsEnabled() {
    check("isSoundEffectsEnabled()").that(actual.isSoundEffectsEnabled()).isTrue();
  }

  public void hasSoundEffectsDisabled() {
    check("isSoundEffectsEnabled()").that(actual.isSoundEffectsEnabled()).isFalse();
  }

  public void hasVerticalFadingEdgeEnabled() {
    check("isVerticalFadingEdgeEnabled()").that(actual.isVerticalFadingEdgeEnabled()).isTrue();
  }

  public void hasVerticalFadingEdgeDisabled() {
    check("isVerticalFadingEdgeEnabled()").that(actual.isVerticalFadingEdgeEnabled()).isFalse();
  }

  public void hasVerticalScrollBarEnabled() {
    check("isVerticalScrollBarEnabled()").that(actual.isVerticalScrollBarEnabled()).isTrue();
  }

  public void hasVerticalScrollBarDisabled() {
    check("isVerticalScrollBarEnabled()").that(actual.isVerticalScrollBarEnabled()).isFalse();
  }

  @TargetApi(KITKAT)
  public void canResolveLayoutDirection() {
    check("canResolveLayoutDirection()").that(actual.canResolveLayoutDirection()).isTrue();
  }

  @TargetApi(KITKAT)
  public void canNotResolveLayoutDirection() {
    check("canResolveLayoutDirection()").that(actual.canResolveLayoutDirection()).isFalse();
  }

  @TargetApi(KITKAT)
  public void canResolveTextAlignment() {
    check("canResolveTextAlignment()").that(actual.canResolveTextAlignment()).isTrue();
  }

  @TargetApi(KITKAT)
  public void canNotResolveTextAlignment() {
    check("canResolveTextAlignment()").that(actual.canResolveTextAlignment()).isFalse();
  }

  @TargetApi(KITKAT)
  public void canResolveTextDirection() {
    check("canResolveTextDirection()").that(actual.canResolveTextDirection()).isTrue();
  }

  @TargetApi(KITKAT)
  public void canNotResolveTextDirection() {
    check("canResolveTextDirection()").that(actual.canResolveTextDirection()).isFalse();
  }

  @TargetApi(KITKAT)
  public void isAttachedToWindow() {
    check("isAttachedToWindow()").that(actual.isAttachedToWindow()).isTrue();
  }

  @TargetApi(KITKAT)
  public void isNotAttachedToWindow() {
    check("isAttachedToWindow()").that(actual.isAttachedToWindow()).isFalse();
  }

  @TargetApi(KITKAT)
  public void isLaidOut() {
    check("isLaidOut()").that(actual.isLaidOut()).isTrue();
  }

  @TargetApi(KITKAT)
  public void isNotLaidOut() {
    check("isLaidOut()").that(actual.isLaidOut()).isFalse();
  }

  @TargetApi(KITKAT)
  public void hasResolvedLayoutDirection() {
    check("isLayoutDirectionResolved()").that(actual.isLayoutDirectionResolved()).isTrue();
  }

  @TargetApi(KITKAT)
  public void hasNotResolvedLayoutDirection() {
    check("isLayoutDirectionResolved()").that(actual.isLayoutDirectionResolved()).isFalse();
  }

  @TargetApi(KITKAT)
  public void hasResolvedTextAlignment() {
    check("isTextAlignmentResolved()").that(actual.isTextAlignmentResolved()).isTrue();
  }

  @TargetApi(KITKAT)
  public void hasNotResolvedTextAlignment() {
    check("isTextAlignmentResolved()").that(actual.isTextAlignmentResolved()).isFalse();
  }

  @TargetApi(KITKAT)
  public void hasResolvedTextDirection() {
    check("isTextDirectionResolved()").that(actual.isTextDirectionResolved()).isTrue();
  }

  @TargetApi(KITKAT)
  public void hasNotResolvedTextDirection() {
    check("isTextDirectionResolved()").that(actual.isTextDirectionResolved()).isFalse();
  }
}
