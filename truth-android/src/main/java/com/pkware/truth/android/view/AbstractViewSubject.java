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
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assert_;
import static com.pkware.truth.android.internal.IntegerUtils.buildNamedValueString;

public abstract class AbstractViewSubject<S extends AbstractViewSubject<S, T>, T extends View> extends Subject<S, T> {
  protected AbstractViewSubject(FailureMetadata failureMetadata, T subject) {
    super(failureMetadata, subject);
  }

  public static String visibilityToString(@ViewVisibility int visibility) {
    return buildNamedValueString(visibility)
        .value(VISIBLE, "visible")
        .value(INVISIBLE, "invisible")
        .value(GONE, "gone")
        .get();
  }

  public static String layerTypeToString(@ViewLayerType int type) {
    return buildNamedValueString(type)
        .value(LAYER_TYPE_NONE, "none")
        .value(LAYER_TYPE_SOFTWARE, "software")
        .value(LAYER_TYPE_HARDWARE, "hardware")
        .get();
  }

  @TargetApi(JELLY_BEAN_MR1)
  public static String layoutDirectionToString(@ViewLayoutDirection int direction) {
    return buildNamedValueString(direction)
        .value(LAYOUT_DIRECTION_RTL, "right_to_left")
        .value(LAYOUT_DIRECTION_LTR, "left_to_right")
        .value(LAYOUT_DIRECTION_INHERIT, "inherit")
        .value(LAYOUT_DIRECTION_LOCALE, "locale")
        .get();
  }

  public static String overScrollModeToString(@ViewOverscrollMode int mode) {
    return buildNamedValueString(mode)
        .value(OVER_SCROLL_ALWAYS, "always")
        .value(OVER_SCROLL_IF_CONTENT_SCROLLS, "ifContentScrolls")
        .value(OVER_SCROLL_NEVER, "never")
        .get();
  }

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

  public S hasAlpha(float alpha, float tolerance) {
    assertThat(actual().getAlpha())
        .named("alpha")
        .isWithin(tolerance)
        .of(alpha);
    //noinspection unchecked
    return (S) this;
  }

  public S hasAnimation(Animation animation) {
    assertThat(actual().getAnimation())
        .named("animation")
        .isSameAs(animation);
    //noinspection unchecked
    return (S) this;
  }

  public S hasBackground(Drawable background) {
    assertThat(actual().getBackground())
        .named("background")
        .isSameAs(background);
    //noinspection unchecked
    return (S) this;
  }

  public S hasBaseline(int baseline) {
    assertThat(actual().getBaseline())
        .named("baseline")
        .isEqualTo(baseline);
    //noinspection unchecked
    return (S) this;
  }

  public S hasBottom(int bottom) {
    assertThat(actual().getBottom())
        .named("bottom")
        .isEqualTo(bottom);
    //noinspection unchecked
    return (S) this;
  }

  public S hasContentDescription(String contentDescription) {
    assertThat(actual().getContentDescription().toString())
        .named("content description")
        .isEqualTo(contentDescription);
    //noinspection unchecked
    return (S) this;
  }

  public S hasContentDescription(@StringRes int resId) {
    return hasContentDescription(actual().getContext().getString(resId));
  }

  public S hasDrawingCacheBackgroundColor(int color) {
    int actualColor = actual().getDrawingCacheBackgroundColor();
    assert_()
        .withMessage("Expected drawing cache background color <%s> but was <%s>",
            Integer.toHexString(color), Integer.toHexString(actualColor))
        .that(actualColor)
        .isEqualTo(color);
    //noinspection unchecked
    return (S) this;
  }

  public S hasDrawingCacheQuality(int quality) {
    assertThat(actual().getDrawingCacheQuality())
        .named("drawing cache quality")
        .isEqualTo(quality);
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(LOLLIPOP)
  public S hasElevation(float elevation, float tolerance) {
    assertThat(actual().getElevation())
        .named("elevation")
        .isWithin(tolerance)
        .of(elevation);
    //noinspection unchecked
    return (S) this;
  }

  public S hasHeight(int height) {
    assertThat(actual().getHeight())
        .named("height")
        .isEqualTo(height);
    //noinspection unchecked
    return (S) this;
  }

  public S hasHorizontalFadingEdgeLength(int length) {
    assertThat(actual().getHorizontalFadingEdgeLength())
        .named("horizontal fading edge length")
        .isEqualTo(length);
    //noinspection unchecked
    return (S) this;
  }

  public S hasId(int id) {
    int actualId = actual().getId();
    assert_()
        .withMessage("Expected ID <%s> but was <%s>", Integer.toHexString(id),
            Integer.toHexString(actualId))
        .that(actualId)
        .isEqualTo(id);
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(LOLLIPOP)
  public S isImportantForAccessibility() {
    assertThat(actual().isImportantForAccessibility())
        .named("is important for accessibility")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(LOLLIPOP)
  public S isNotImportantForAccessibility() {
    assertThat(actual().isImportantForAccessibility())
        .named("is important for accessibility")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S isKeepingScreenOn() {
    assertThat(actual().getKeepScreenOn())
        .named("is keeping screen on")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotKeepingScreenOn() {
    assertThat(actual().getKeepScreenOn())
        .named("is keeping screen on")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(JELLY_BEAN_MR1)
  public S isLabelFor(@IdRes int id) {
    assertThat(actual().getLabelFor())
        .named("is label for view")
        .isEqualTo(id);
    //noinspection unchecked
    return (S) this;
  }

  public S hasLayerType(@ViewLayerType int type) {
    int actualType = actual().getLayerType();
    //noinspection ResourceType
    assert_()
        .withMessage("Expected layer type <%s> but was <%s>", layerTypeToString(type),
            layerTypeToString(actualType))
        .that(actualType)
        .isEqualTo(type);
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(JELLY_BEAN_MR1)
  public S hasLayoutDirection(int direction) {
    int actualDirection = actual().getLayoutDirection();
    assert_()
        .withMessage("Expected layout direction <%s> but was <%s>",
            layoutDirectionToString(direction), layoutDirectionToString(actualDirection))
        .that(actualDirection)
        .isEqualTo(direction);
    //noinspection unchecked
    return (S) this;
  }

  public S hasLeft(int left) {
    assertThat(actual().getLeft())
        .named("left")
        .isEqualTo(left);
    //noinspection unchecked
    return (S) this;
  }

  public S hasMeasuredHeight(int height) {
    assertThat(actual().getMeasuredHeight())
        .named("measured height")
        .isEqualTo(height);
    //noinspection unchecked
    return (S) this;
  }

  public S hasMeasuredHeightAndState(int heightAndState) {
    assertThat(actual().getMeasuredHeightAndState())
        .named("measured height and state")
        .isEqualTo(heightAndState);
    //noinspection unchecked
    return (S) this;
  }

  public S hasMeasuredState(int state) {
    assertThat(actual().getMeasuredState())
        .named("measured state")
        .isEqualTo(state);
    //noinspection unchecked
    return (S) this;
  }

  public S hasMeasuredWidth(int width) {
    assertThat(actual().getMeasuredWidth())
        .named("measured width")
        .isEqualTo(width);
    //noinspection unchecked
    return (S) this;
  }

  public S hasMeasuredWidthAndState(int widthAndState) {
    assertThat(actual().getMeasuredWidthAndState())
        .named("measured width and state")
        .isEqualTo(widthAndState);
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(JELLY_BEAN)
  public S hasMinimumHeight(int height) {
    assertThat(actual().getMinimumHeight())
        .named("minimum height")
        .isEqualTo(height);
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(JELLY_BEAN)
  public S hasMinimumWidth(int width) {
    assertThat(actual().getMinimumWidth())
        .named("minimum width")
        .isEqualTo(width);
    //noinspection unchecked
    return (S) this;
  }

  public S hasNextFocusDownId(@IdRes int id) {
    assertThat(actual().getNextFocusDownId())
        .named("next focus down ID")
        .isEqualTo(id);
    //noinspection unchecked
    return (S) this;
  }

  public S hasNextFocusForwardId(@IdRes int id) {
    assertThat(actual().getNextFocusForwardId())
        .named("next focus forward ID")
        .isEqualTo(id);
    //noinspection unchecked
    return (S) this;
  }

  public S hasNextFocusLeftId(@IdRes int id) {
    assertThat(actual().getNextFocusLeftId())
        .named("next focus left ID")
        .isEqualTo(id);
    //noinspection unchecked
    return (S) this;
  }

  public S hasNextFocusRightId(@IdRes int id) {
    assertThat(actual().getNextFocusRightId())
        .named("next focus right ID")
        .isEqualTo(id);
    //noinspection unchecked
    return (S) this;
  }

  public S hasNextFocusUpId(@IdRes int id) {
    assertThat(actual().getNextFocusUpId())
        .named("next focus up ID")
        .isEqualTo(id);
    //noinspection unchecked
    return (S) this;
  }

  public S hasOverScrollMode(@ViewOverscrollMode int mode) {
    int actualMode = actual().getOverScrollMode();
    //noinspection ResourceType
    assert_()
        .withMessage("Expected over scroll mode <%s> but was <%s>",
            overScrollModeToString(mode), overScrollModeToString(actualMode))
        .that(actualMode)
        .isEqualTo(mode);
    //noinspection unchecked
    return (S) this;
  }

  public S hasPaddingBottom(int padding) {
    assertThat(actual().getPaddingBottom())
        .named("padding bottom")
        .isEqualTo(padding);
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(JELLY_BEAN_MR1)
  public S hasPaddingEnd(int padding) {
    assertThat(actual().getPaddingEnd())
        .named("padding end")
        .isEqualTo(padding);
    //noinspection unchecked
    return (S) this;
  }

  public S hasPaddingLeft(int padding) {
    assertThat(actual().getPaddingLeft())
        .named("padding left")
        .isEqualTo(padding);
    //noinspection unchecked
    return (S) this;
  }

  public S hasPaddingRight(int padding) {
    assertThat(actual().getPaddingRight())
        .named("padding right")
        .isEqualTo(padding);
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(JELLY_BEAN_MR1)
  public S hasPaddingStart(int padding) {
    assertThat(actual().getPaddingStart())
        .named("padding start")
        .isEqualTo(padding);
    //noinspection unchecked
    return (S) this;
  }

  public S hasPaddingTop(int padding) {
    assertThat(actual().getPaddingTop())
        .named("padding top")
        .isEqualTo(padding);
    //noinspection unchecked
    return (S) this;
  }

  public S hasParent(ViewParent parent) {
    assertThat(actual().getParent())
        .named("parent")
        .isSameAs(parent);
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(JELLY_BEAN)
  public S hasParentForAccessibility(ViewParent parent) {
    assertThat(actual().getParentForAccessibility())
        .named("parent for accessibility")
        .isSameAs(parent);
    //noinspection unchecked
    return (S) this;
  }

  public S hasPivotX(float pivotX, float tolerance) {
    assertThat(actual().getPivotX())
        .named("X pivot")
        .isWithin(tolerance)
        .of(pivotX);
    //noinspection unchecked
    return (S) this;
  }

  public S hasPivotY(float pivotY, float tolerance) {
    assertThat(actual().getPivotY())
        .named("Y pivot")
        .isWithin(tolerance)
        .of(pivotY);
    //noinspection unchecked
    return (S) this;
  }

  public S hasRight(int right) {
    assertThat(actual().getRight())
        .named("right")
        .isEqualTo(right);
    //noinspection unchecked
    return (S) this;
  }

  public S hasRootView(View view) {
    assertThat(actual().getRootView())
        .named("root view")
        .isSameAs(view);
    //noinspection unchecked
    return (S) this;
  }

  public S hasRotation(float rotation, float tolerance) {
    assertThat(actual().getRotation())
        .named("rotation")
        .isWithin(tolerance)
        .of(rotation);
    //noinspection unchecked
    return (S) this;
  }

  public S hasRotationX(float rotation, float tolerance) {
    assertThat(actual().getRotationX())
        .named("X rotation")
        .isWithin(tolerance)
        .of(rotation);
    //noinspection unchecked
    return (S) this;
  }

  public S hasRotationY(float rotation, float tolerance) {
    assertThat(actual().getRotationY())
        .named("Y rotation")
        .isWithin(tolerance)
        .of(rotation);
    //noinspection unchecked
    return (S) this;
  }

  public S hasScaleX(float scale, float tolerance) {
    assertThat(actual().getScaleX())
        .named("X scale")
        .isWithin(tolerance)
        .of(scale);
    //noinspection unchecked
    return (S) this;
  }

  public S hasScaleY(float scale, float tolerance) {
    assertThat(actual().getScaleY())
        .named("Y scale")
        .isWithin(tolerance)
        .of(scale);
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(JELLY_BEAN)
  public S hasScrollBarDefaultDelayBeforeFade(int fade) {
    assertThat(actual().getScrollBarDefaultDelayBeforeFade())
        .named("scroll bar default delay before fade")
        .isEqualTo(fade);
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(JELLY_BEAN)
  public S hasScrollBarFadeDuration(int fade) {
    assertThat(actual().getScrollBarFadeDuration())
        .named("scroll bar fade duration")
        .isEqualTo(fade);
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(JELLY_BEAN)
  public S hasScrollBarSize(int size) {
    assertThat(actual().getScrollBarSize())
        .named("scroll bar size")
        .isEqualTo(size);
    //noinspection unchecked
    return (S) this;
  }

  public S hasScrollBarStyle(@ViewScrollBarStyle int style) {
    int actualStyle = actual().getScrollBarStyle();
    //noinspection ResourceType
    assert_()
        .withMessage("Expected scroll bar style <%s> but was <%s>",
            scrollBarStyleToString(style), scrollBarStyleToString(actualStyle))
        .that(actualStyle)
        .isEqualTo(style);
    //noinspection unchecked
    return (S) this;
  }

  public S hasScrollX(int scroll) {
    assertThat(actual().getScrollX())
        .named("X scroll")
        .isEqualTo(scroll);
    //noinspection unchecked
    return (S) this;
  }

  public S hasScrollY(int scroll) {
    assertThat(actual().getScrollY())
        .named("Y scroll")
        .isEqualTo(scroll);
    //noinspection unchecked
    return (S) this;
  }

  public S hasSolidColor(int color) {
    int actualColor = actual().getSolidColor();
    assert_()
        .withMessage("Expected solid color <%s> but was <%s>",
            Integer.toHexString(color), Integer.toHexString(actualColor))
        .that(actualColor)
        .isEqualTo(color);
    //noinspection unchecked
    return (S) this;
  }

  public S hasSystemUiVisibility(int visibility) {
    assertThat(actual().getSystemUiVisibility())
        .named("system UI visibility")
        .isEqualTo(visibility);
    //noinspection unchecked
    return (S) this;
  }

  public S hasTag(int key, Object tag) {
    assertThat(actual().getTag(key))
        .named("tag")
        .isEqualTo(tag);
    //noinspection unchecked
    return (S) this;
  }

  public S hasTag(Object tag) {
    assertThat(actual().getTag())
        .named("tag")
        .isEqualTo(tag);
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(JELLY_BEAN_MR1)
  public S hasTextAlignment(@ViewTextAlignment int alignment) {
    int actualAlignment = actual().getTextAlignment();
    assert_()
        .withMessage("Expected text alignment <%s> but was <%s>",
            textAlignmentToString(alignment), textAlignmentToString(actualAlignment))
        .that(actualAlignment)
        .isEqualTo(alignment);
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(JELLY_BEAN_MR1)
  public S hasTextDirection(@ViewTextDirection int direction) {
    int actualDirection = actual().getTextDirection();
    //noinspection ResourceType
    assert_()
        .withMessage("Expected text direction <%s> but was <%s>",
            textDirectionToString(direction), textDirectionToString(actualDirection))
        .that(actualDirection)
        .isEqualTo(direction);
    //noinspection unchecked
    return (S) this;
  }

  public S hasTop(int top) {
    assertThat(actual().getTop())
        .named("top")
        .isEqualTo(top);
    //noinspection unchecked
    return (S) this;
  }

  public S hasTranslationX(float translation, float tolerance) {
    assertThat(actual().getTranslationX())
        .named("X translation")
        .isWithin(tolerance)
        .of(translation);
    //noinspection unchecked
    return (S) this;
  }

  public S hasTranslationY(float translation, float tolerance) {
    assertThat(actual().getTranslationY())
        .named("Y translation")
        .isWithin(tolerance)
        .of(translation);
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(LOLLIPOP)
  public S hasTranslationZ(float translation, float tolerance) {
    assertThat(actual().getTranslationZ())
        .named("Z translation")
        .isWithin(tolerance)
        .of(translation);
    //noinspection unchecked
    return (S) this;
  }

  public S hasVerticalFadingEdgeLength(int length) {
    assertThat(actual().getVerticalFadingEdgeLength())
        .named("vertical fading edge length")
        .isEqualTo(length);
    //noinspection unchecked
    return (S) this;
  }

  public S hasVerticalScrollbarPosition(int position) {
    int actualPosition = actual().getVerticalScrollbarPosition();
    //noinspection ResourceType
    assert_()
        .withMessage("Expected vertical scroll bar position <%s> but was <%s>",
            verticalScrollBarPositionToString(position),
            verticalScrollBarPositionToString(actualPosition))
        .that(actualPosition)
        .isEqualTo(position);
    //noinspection unchecked
    return (S) this;
  }

  public S hasVerticalScrollbarWidth(int width) {
    assertThat(actual().getVerticalScrollbarWidth())
        .named("vertical scroll bar width")
        .isEqualTo(width);
    //noinspection unchecked
    return (S) this;
  }

  public S hasVisibility(@ViewVisibility int visibility) {
    int actualVisibility = actual().getVisibility();
    assert_()
        .withMessage("Expected visibility <%s> but was <%s>.",
            visibilityToString(visibility), visibilityToString(actualVisibility))
        .that(actualVisibility)
        .isEqualTo(visibility);
    //noinspection unchecked
    return (S) this;
  }

  public S isVisible() {
    int actualVisibility = actual().getVisibility();
    //noinspection ResourceType
    assert_()
        .withMessage("Expected to be visible but was %s", visibilityToString(actualVisibility))
        .that(actualVisibility)
        .isEqualTo(VISIBLE);
    //noinspection unchecked
    return (S) this;
  }

  public S isNotVisible() {
    int actualVisibility = actual().getVisibility();
    assert_()
        .withMessage("Expected to be not visible but was visible")
        .that(actualVisibility)
        .isNotEqualTo(VISIBLE);
    //noinspection unchecked
    return (S) this;
  }

  public S isInvisible() {
    int actualVisibility = actual().getVisibility();
    assert_()
        .withMessage("Expected to be invisible but was %s",
            visibilityToString(actualVisibility))
        .that(actualVisibility)
        .isEqualTo(INVISIBLE);
    //noinspection unchecked
    return (S) this;
  }

  public S isNotInvisible() {
    int actualVisibility = actual().getVisibility();
    assert_()
        .withMessage("Expected to be not invisible but was invisible")
        .that(actualVisibility)
        .isNotEqualTo(INVISIBLE);
    //noinspection unchecked
    return (S) this;
  }

  public S isGone() {
    int actualVisibility = actual().getVisibility();
    assert_()
        .withMessage("Expected to be gone but was %s", visibilityToString(actualVisibility))
        .that(actualVisibility)
        .isEqualTo(GONE);
    //noinspection unchecked
    return (S) this;
  }

  public S isNotGone() {
    int actualVisibility = actual().getVisibility();
    assert_()
        .withMessage("Expected to be not gone but was gone")
        .that(actualVisibility)
        .isNotEqualTo(GONE);
    //noinspection unchecked
    return (S) this;
  }

  public S hasWidth(int width) {
    assertThat(actual().getWidth())
        .named("width")
        .isEqualTo(width);
    //noinspection unchecked
    return (S) this;
  }

  public S hasWindowVisibility(int visibility) {
    int actualVisibility = actual().getWindowVisibility();
    assert_()
        .withMessage("Expected window visibility <%s> but was <%s>",
            visibilityToString(visibility), visibilityToString(actualVisibility))
        .that(actualVisibility)
        .isEqualTo(visibility);
    //noinspection unchecked
    return (S) this;
  }

  public S hasX(float x, float tolerance) {
    assertThat(actual().getX())
        .named("X")
        .isWithin(tolerance)
        .of(x);
    //noinspection unchecked
    return (S) this;
  }

  public S hasY(float y, float tolerance) {
    assertThat(actual().getY())
        .named("Y")
        .isWithin(tolerance)
        .of(y);
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(LOLLIPOP)
  public S hasZ(float z, float tolerance) {
    assertThat(actual().getZ())
        .named("Z")
        .isWithin(tolerance)
        .of(z);
    //noinspection unchecked
    return (S) this;
  }

  public S hasFocus() {
    assertThat(actual().hasFocus())
        .named("has focus")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S hasNoFocus() {
    assertThat(actual().hasFocus())
        .named("has focus")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S hasFocusable() {
    assertThat(actual().hasFocusable())
        .named("has focusable")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isInFocusedWindow() {
    assertThat(actual().hasWindowFocus())
        .named("is in focused window")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotInFocusedWindow() {
    assertThat(actual().hasWindowFocus())
        .named("is in focused window")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S isActivated() {
    assertThat(actual().isActivated())
        .named("is activated")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotActivated() {
    assertThat(actual().isActivated())
        .named("is activated")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S isClickable() {
    assertThat(actual().isClickable())
        .named("is clickable")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotClickable() {
    assertThat(actual().isClickable())
        .named("is clickable")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S isDirty() {
    assertThat(actual().isDirty())
        .named("is dirty")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotDirty() {
    assertThat(actual().isDirty())
        .named("is dirty")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S isUsingDrawingCache() {
    assertThat(actual().isDrawingCacheEnabled())
        .named("is using drawing cache")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotUsingDrawingCache() {
    assertThat(actual().isDrawingCacheEnabled())
        .named("is using drawing cache")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S isDuplicatingParentState() {
    assertThat(actual().isDuplicateParentStateEnabled())
        .named("is duplicating parent state")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotDuplicatingParentState() {
    assertThat(actual().isDuplicateParentStateEnabled())
        .named("is duplicating parent state")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S isEnabled() {
    assertThat(actual().isEnabled())
        .named("is enabled")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isDisabled() {
    assertThat(!actual().isEnabled())
        .named("is disabled")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isFocusable() {
    assertThat(actual().isFocusable())
        .named("is focusable")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotFocusable() {
    assertThat(actual().isFocusable())
        .named("is focusable")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S isFocusableInTouchMode() {
    assertThat(actual().isFocusableInTouchMode())
        .named("is focusable in touch mode")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotFocusableInTouchMode() {
    assertThat(actual().isFocusableInTouchMode())
        .named("is focusable in touch mode")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S isFocused() {
    assertThat(actual().isFocused())
        .named("is focused")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotFocused() {
    assertThat(actual().isFocused())
        .named("is focused")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S hasHapticFeedbackEnabled() {
    assertThat(actual().isHapticFeedbackEnabled())
        .named("is haptic feedback enabled")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S hasHapticFeedbackDisabled() {
    assertThat(!actual().isHapticFeedbackEnabled())
        .named("is haptic feedback disabled")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isHardwareAccelerated() {
    assertThat(actual().isHardwareAccelerated())
        .named("is hardware accelerated")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotHardwareAccelerated() {
    assertThat(actual().isHardwareAccelerated())
        .named("is hardware accelerated")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S hasHorizontalFadingEdgesEnabled() {
    assertThat(actual().isHorizontalFadingEdgeEnabled())
        .named("is fading horizontal edges")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S hasHorizontalFadingEdgesDisabled() {
    assertThat(!actual().isHorizontalFadingEdgeEnabled())
        .named("is not fading horizontal edges")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S hasHorizontalScrollbarEnabled() {
    assertThat(actual().isHorizontalScrollBarEnabled())
        .named("is horizontal scroll bar enabled")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S hasHorizontalScrollbarDisabled() {
    assertThat(actual().isHorizontalScrollBarEnabled())
        .named("is horizontal scroll bar enabled")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S isHovered() {
    assertThat(actual().isHovered())
        .named("is hovered")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotHovered() {
    assertThat(actual().isHovered())
        .named("is hovered")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S isInEditMode() {
    assertThat(actual().isInEditMode())
        .named("is in edit mode")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotInEditMode() {
    assertThat(actual().isInEditMode())
        .named("is in edit mode")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(JELLY_BEAN_MR2)
  public S isInLayout() {
    assertThat(actual().isInLayout())
        .named("is in layout")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(JELLY_BEAN_MR2)
  public S isNotInLayout() {
    assertThat(actual().isInLayout())
        .named("is in layout")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S isInTouchMode() {
    assertThat(actual().isInTouchMode())
        .named("is in touch mode")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotInTouchMode() {
    assertThat(actual().isInTouchMode())
        .named("is in touch mode")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S hasLayoutRequested() {
    assertThat(actual().isLayoutRequested())
        .named("is layout requested")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S hasNoLayoutRequested() {
    assertThat(actual().isLayoutRequested())
        .named("is layout requested")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S isLongClickable() {
    assertThat(actual().isLongClickable())
        .named("is long-clickable")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotLongClickable() {
    assertThat(actual().isLongClickable())
        .named("is long-clickable")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S isOpaque() {
    assertThat(actual().isOpaque())
        .named("is opaque")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotOpaque() {
    assertThat(actual().isOpaque())
        .named("is opaque")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S isPressed() {
    assertThat(actual().isPressed())
        .named("is pressed")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotPressed() {
    assertThat(actual().isPressed())
        .named("is pressed")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S hasSaveEnabled() {
    assertThat(actual().isSaveEnabled())
        .named("is save enabled")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S hasSaveDisabled() {
    assertThat(actual().isSaveEnabled())
        .named("is save enabled")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S hasSaveFromParentEnabled() {
    assertThat(actual().isSaveFromParentEnabled())
        .named("is save from parent enabled")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S hasSaveFromParentDisabled() {
    assertThat(actual().isSaveFromParentEnabled())
        .named("is save from parent enabled")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(JELLY_BEAN)
  public S isScrollContainer() {
    assertThat(actual().isScrollContainer())
        .named("is a scroll container")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(JELLY_BEAN)
  public S isNotScrollContainer() {
    assertThat(actual().isScrollContainer())
        .named("is a scroll container")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S hasScrollbarFadingEnabled() {
    assertThat(actual().isScrollbarFadingEnabled())
        .named("is scroll bar fading enabled")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S hasScrollbarFadingDisabled() {
    assertThat(actual().isScrollbarFadingEnabled())
        .named("is scroll bar fading enabled")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S isSelected() {
    assertThat(actual().isSelected())
        .named("is selected")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotSelected() {
    assertThat(actual().isSelected())
        .named("is selected")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S isShown() {
    assertThat(actual().isShown())
        .named("is shown")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotShown() {
    assertThat(actual().isShown())
        .named("is shown")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S hasSoundEffectsEnabled() {
    assertThat(actual().isSoundEffectsEnabled())
        .named("are sound effects enabled")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S hasSoundEffectsDisabled() {
    assertThat(actual().isSoundEffectsEnabled())
        .named("are sound effects enabled")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S hasVerticalFadingEdgeEnabled() {
    assertThat(actual().isVerticalFadingEdgeEnabled())
        .named("is vertical fading edge enabled")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S hasVerticalFadingEdgeDisabled() {
    assertThat(actual().isVerticalFadingEdgeEnabled())
        .named("is vertical fading edge enabled")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S hasVerticalScrollBarEnabled() {
    assertThat(actual().isVerticalScrollBarEnabled())
        .named("is vertical scroll bar enabled")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S hasVerticalScrollBarDisabled() {
    assertThat(actual().isVerticalScrollBarEnabled())
        .named("is vertical scroll bar enabled")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(KITKAT)
  public S canResolveLayoutDirection() {
    assertThat(actual().canResolveLayoutDirection())
        .named("can resolve layout direction")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(KITKAT)
  public S canNotResolveLayoutDirection() {
    assertThat(actual().canResolveLayoutDirection())
        .named("can resolve layout direction")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(KITKAT)
  public S canResolveTextAlignment() {
    assertThat(actual().canResolveTextAlignment())
        .named("can resolve text alignment")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(KITKAT)
  public S canNotResolveTextAlignment() {
    assertThat(actual().canResolveTextAlignment())
        .named("can resolve text alignment")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(KITKAT)
  public S canResolveTextDirection() {
    assertThat(actual().canResolveTextDirection())
        .named("can resolve text direction")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(KITKAT)
  public S canNotResolveTextDirection() {
    assertThat(actual().canResolveTextDirection())
        .named("can resolve text direction")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(KITKAT)
  public S isAttachedToWindow() {
    assertThat(actual().isAttachedToWindow())
        .named("is attached to window")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(KITKAT)
  public S isNotAttachedToWindow() {
    assertThat(actual().isAttachedToWindow())
        .named("is attached to window")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(KITKAT)
  public S isLaidOut() {
    assertThat(actual().isLaidOut())
        .named("is laid out")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(KITKAT)
  public S isNotLaidOut() {
    assertThat(actual().isLaidOut())
        .named("is laid out")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(KITKAT)
  public S hasResolvedLayoutDirection() {
    assertThat(actual().isLayoutDirectionResolved())
        .named("is layout direction resolved")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(KITKAT)
  public S hasNotResolvedLayoutDirection() {
    assertThat(actual().isLayoutDirectionResolved())
        .named("is layout direction resolved")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(KITKAT)
  public S hasResolvedTextAlignment() {
    assertThat(actual().isTextAlignmentResolved())
        .named("is text alignment resolved")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(KITKAT)
  public S hasNotResolvedTextAlignment() {
    assertThat(actual().isTextAlignmentResolved())
        .named("is text alignment resolved")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(KITKAT)
  public S hasResolvedTextDirection() {
    assertThat(actual().isTextDirectionResolved())
        .named("is text direction resolved")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(KITKAT)
  public S hasNotResolvedTextDirection() {
    assertThat(actual().isTextDirectionResolved())
        .named("is text direction resolved")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }
}
