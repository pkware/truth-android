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
package com.pkware.truth.android.widget;

import android.annotation.TargetApi;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.widget.TextView;

import androidx.annotation.StringRes;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.StringSubject;
import com.pkware.truth.android.view.AbstractViewSubject;

import java.util.Locale;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.os.Build.VERSION_CODES.JELLY_BEAN;
import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR1;
import static android.view.Gravity.BOTTOM;
import static android.view.Gravity.CENTER;
import static android.view.Gravity.CENTER_HORIZONTAL;
import static android.view.Gravity.CENTER_VERTICAL;
import static android.view.Gravity.CLIP_HORIZONTAL;
import static android.view.Gravity.CLIP_VERTICAL;
import static android.view.Gravity.END;
import static android.view.Gravity.FILL;
import static android.view.Gravity.FILL_HORIZONTAL;
import static android.view.Gravity.FILL_VERTICAL;
import static android.view.Gravity.LEFT;
import static android.view.Gravity.NO_GRAVITY;
import static android.view.Gravity.RIGHT;
import static android.view.Gravity.START;
import static android.view.Gravity.TOP;
import static android.view.inputmethod.EditorInfo.IME_ACTION_DONE;
import static android.view.inputmethod.EditorInfo.IME_ACTION_GO;
import static android.view.inputmethod.EditorInfo.IME_ACTION_NEXT;
import static android.view.inputmethod.EditorInfo.IME_ACTION_NONE;
import static android.view.inputmethod.EditorInfo.IME_ACTION_PREVIOUS;
import static android.view.inputmethod.EditorInfo.IME_ACTION_SEARCH;
import static android.view.inputmethod.EditorInfo.IME_ACTION_SEND;
import static android.view.inputmethod.EditorInfo.IME_ACTION_UNSPECIFIED;
import static android.view.inputmethod.EditorInfo.IME_FLAG_FORCE_ASCII;
import static android.view.inputmethod.EditorInfo.IME_FLAG_NAVIGATE_NEXT;
import static android.view.inputmethod.EditorInfo.IME_FLAG_NAVIGATE_PREVIOUS;
import static android.view.inputmethod.EditorInfo.IME_FLAG_NO_ACCESSORY_ACTION;
import static android.view.inputmethod.EditorInfo.IME_FLAG_NO_ENTER_ACTION;
import static android.view.inputmethod.EditorInfo.IME_FLAG_NO_EXTRACT_UI;
import static android.view.inputmethod.EditorInfo.IME_FLAG_NO_FULLSCREEN;
import static android.view.inputmethod.EditorInfo.IME_NULL;
import static com.pkware.truth.android.internal.IntegerUtils.buildBitMaskString;

public abstract class AbstractTextViewSubject<T extends TextView>
    extends AbstractViewSubject<T> {

  @Nullable
  private final T actual;

  protected AbstractTextViewSubject(@Nonnull FailureMetadata failureMetadata, @Nullable T actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  @Nonnull
  public static String gravityToString(@TextViewGravity int gravity) {
    return buildBitMaskString(gravity)
        .flag(NO_GRAVITY, "no_gravity")
        .flag(TOP, "top")
        .flag(BOTTOM, "bottom")
        .flag(LEFT, "left")
        .flag(RIGHT, "right")
        .flag(CENTER_VERTICAL, "center_vertical")
        .flag(FILL_VERTICAL, "fill_vertical")
        .flag(CENTER_HORIZONTAL, "center_horizontal")
        .flag(FILL_HORIZONTAL, "fill_horizontal")
        .flag(CENTER, "center")
        .flag(FILL, "fill")
        .flag(CLIP_VERTICAL, "clip_vertical")
        .flag(CLIP_HORIZONTAL, "clip_horizontal")
        .flag(START, "start")
        .flag(END, "end")
        .get();
  }

  @Nonnull
  public static String imeOptionsToString(@TextViewImeOptions int options) {
    return buildBitMaskString(options)
        .flag(IME_ACTION_UNSPECIFIED, "action_unspecified")
        .flag(IME_ACTION_NONE, "action_none")
        .flag(IME_ACTION_GO, "action_go")
        .flag(IME_ACTION_SEARCH, "action_search")
        .flag(IME_ACTION_SEND, "action_send")
        .flag(IME_ACTION_NEXT, "action_next")
        .flag(IME_ACTION_DONE, "action_done")
        .flag(IME_ACTION_PREVIOUS, "action_previous")
        .flag(IME_FLAG_NO_FULLSCREEN, "flag_no_fullscreen")
        .flag(IME_FLAG_NAVIGATE_PREVIOUS, "flag_navigate_previous")
        .flag(IME_FLAG_NAVIGATE_NEXT, "flag_navigate_next")
        .flag(IME_FLAG_NO_EXTRACT_UI, "flag_no_extract_ui")
        .flag(IME_FLAG_NO_ACCESSORY_ACTION, "flag_no_accessory_action")
        .flag(IME_FLAG_NO_ENTER_ACTION, "flag_no_enter_action")
        .flag(IME_FLAG_FORCE_ASCII, "flag_force_ascii")
        .flag(IME_NULL, "null")
        .get();
  }

  public void hasAutoLinkMask(int mask) {
    check("getAutoLinkMask()").that(actual.getAutoLinkMask()).isEqualTo(mask);
  }

  public void hasCompoundDrawablePadding(int padding) {
    check("getCompoundDrawablePadding()").that(actual.getCompoundDrawablePadding()).isEqualTo(padding);
  }

  public void hasCompoundPaddingBottom(int padding) {
    check("getCompoundPaddingBottom()").that(actual.getCompoundPaddingBottom()).isEqualTo(padding);
  }

  @TargetApi(JELLY_BEAN_MR1)
  public void hasCompoundPaddingEnd(int padding) {
    check("getCompoundPaddingEnd()").that(actual.getCompoundPaddingEnd()).isEqualTo(padding);
  }

  public void hasCompoundPaddingLeft(int padding) {
    check("getCompoundPaddingLeft()").that(actual.getCompoundPaddingLeft()).isEqualTo(padding);
  }

  public void hasCompoundPaddingRight(int padding) {
    check("getCompoundPaddingRight()").that(actual.getCompoundPaddingRight()).isEqualTo(padding);
  }

  @TargetApi(JELLY_BEAN_MR1)
  public void hasCompoundPaddingStart(int padding) {
    check("getCompoundPaddingStart()").that(actual.getCompoundPaddingStart()).isEqualTo(padding);
  }

  public void hasCompoundPaddingTop(int padding) {
    check("getCompoundPaddingTop()").that(actual.getCompoundPaddingTop()).isEqualTo(padding);
  }

  public void hasCurrentHintTextColor(int color) {
    int actualColor = actual.getCurrentHintTextColor();
    check("getCurrentHintTextColor()")
        .withMessage("Expected current hint text color <%s> but was <%s>.",
            Integer.toHexString(color), Integer.toHexString(actualColor))
        .that(actualColor)
        .isEqualTo(color);
  }

  public void hasCurrentTextColor(int color) {
    int actualColor = actual.getCurrentTextColor();
    check("getCurrentTextColor()")
        .withMessage("Expected current text color <%s> but was <%s>.",
            Integer.toHexString(color), Integer.toHexString(actualColor))
        .that(actualColor)
        .isEqualTo(color);
  }

  public void hasEllipsize(@Nullable TextUtils.TruncateAt truncation) {
    TextUtils.TruncateAt actualTruncation = actual.getEllipsize();
    check("getEllipsize()").that(actual.getEllipsize()).isEqualTo(truncation);
  }

  public void hasError() {
    check("getError()").that(actual.getError()).isNotNull();
  }

  public void hasNoError() {
    check("getError()").that(actual.getError()).isNull();
  }

  public void hasError(@Nullable String error) {
    check("getError()").that(actual.getError().toString()).isEqualTo(error);
  }

  public void hasError(@StringRes int resId) {
    hasError(actual.getContext().getString(resId));
  }

  public void hasExtendedPaddingBottom(int padding) {
    check("getExtendedPaddingBottom()").that(actual.getExtendedPaddingBottom()).isEqualTo(padding);
  }

  public void hasExtendedPaddingTop(int padding) {
    int actualPadding = actual.getExtendedPaddingTop();
    check("getExtendedPaddingTop()").that(actual.getExtendedPaddingTop()).isEqualTo(padding);
  }

  public void hasFreezesText(boolean freezes) {
    check("getFreezesText()").that(actual.getFreezesText()).isEqualTo(freezes);
  }

  public void hasGravity(@TextViewGravity int gravity) {
    int actualGravity = actual.getGravity();
    //noinspection ResourceType
    check("getGravity()")
        .withMessage("Expected gravity <%s> but was <%s>.", gravityToString(gravity),
            gravityToString(actualGravity))
        .that(actualGravity)
        .isEqualTo(gravity);
  }

  @TargetApi(JELLY_BEAN)
  public void hasHighlightColor(int color) {
    int actualColor = actual.getHighlightColor();
    check("getHighlightColor()")
        .withMessage("Expected highlight color <%s> but was <%s>.",
            Integer.toHexString(color), Integer.toHexString(actualColor))
        .that(actualColor)
        .isEqualTo(color);
  }

  public void hasHint(@Nullable String hint) {
    check("getHint()").that(actual.getHint().toString()).isEqualTo(hint);
  }

  public void hasHint(@StringRes int resId) {
    hasHint(actual.getContext().getString(resId));
  }

  public void hasImeActionId(int id) {
    check("getImeActionId()").that(actual.getImeActionId()).isEqualTo(id);
  }

  public void hasImeActionLabel(@Nullable String label) {
    check("getImeActionLabel()").that(actual.getImeActionLabel().toString()).isEqualTo(label);
  }

  public void hasImeActionLabel(@StringRes int resId) {
    hasImeActionLabel(actual.getContext().getString(resId));
  }

  public void hasImeOptions(@TextViewImeOptions int options) {
    int actualOptions = actual.getImeOptions();
    //noinspection ResourceType
    check("getImeOptions()")
        .withMessage("Expected IME options <%s> but was <%s>.",
            imeOptionsToString(options), imeOptionsToString(actualOptions))
        .that(actualOptions)
        .isEqualTo(options);
  }

  @TargetApi(JELLY_BEAN)
  public void isIncludingFontPadding() {
    check("getIncludeFontPadding()").that(actual.getIncludeFontPadding()).isTrue();
  }

  @TargetApi(JELLY_BEAN)
  public void isNotIncludingFontPadding() {
    check("getIncludeFontPadding()").that(actual.getIncludeFontPadding()).isFalse();
  }

  public void hasInputType(int type) {
    check("getInputType()").that(actual.getInputType()).isEqualTo(type);
  }

  public void hasLineCount(int count) {
    check("getLineCount()").that(actual.getLineCount()).isEqualTo(count);
  }

  public void hasLineHeight(int height) {
    check("getLineHeight()").that(actual.getLineHeight()).isEqualTo(height);
  }

  @TargetApi(JELLY_BEAN)
  public void hasLineSpacingExtra(float extra, float tolerance) {
    check("getLineSpacingExtra()").that(actual.getLineSpacingExtra()).isWithin(tolerance).of(extra);
  }

  @TargetApi(JELLY_BEAN)
  public void hasLineSpacingMultiplier(float multiplier, float tolerance) {
    float actualMultiplier = actual.getLineSpacingMultiplier();
    check("getLineSpacingMultiplier()").that(actual.getLineSpacingMultiplier()).isWithin(tolerance)
        .of(multiplier);
  }

  @TargetApi(JELLY_BEAN)
  public void hasMarqueeRepeatLimit(int limit) {
    check("getMarqueeRepeatLimit()").that(actual.getMarqueeRepeatLimit()).isEqualTo(limit);
  }

  @TargetApi(JELLY_BEAN)
  public void hasMaxEms(int ems) {
    check("getMaxEms()").that(actual.getMaxEms()).isEqualTo(ems);
  }

  @TargetApi(JELLY_BEAN)
  public void hasMaxHeight(int height) {
    check("getMaxHeight()").that(actual.getMaxHeight()).isEqualTo(height);
  }

  @TargetApi(JELLY_BEAN)
  public void hasMaxLines(int lines) {
    check("getMaxLines()").that(actual.getMaxLines()).isEqualTo(lines);
  }

  @TargetApi(JELLY_BEAN)
  public void hasMaxWidth(int ems) {
    check("getMaxWidth()").that(actual.getMaxWidth()).isEqualTo(ems);
  }

  @TargetApi(JELLY_BEAN)
  public void hasMinEms(int ems) {
    check("getMinEms()").that(actual.getMinEms()).isEqualTo(ems);
  }

  @TargetApi(JELLY_BEAN)
  public void hasMinHeight(int height) {
    check("getMinHeight()").that(actual.getMinHeight()).isEqualTo(height);
  }

  @TargetApi(JELLY_BEAN)
  public void hasMinLines(int lines) {
    check("getMinLines()").that(actual.getMinLines()).isEqualTo(lines);
  }

  @TargetApi(JELLY_BEAN)
  public void hasMinWidth(int ems) {
    check("getMinWidth()").that(actual.getMinWidth()).isEqualTo(ems);
  }

  public void hasPaintFlags(int flags) {
    check("getPaintFlags()").that(actual.getPaintFlags()).isEqualTo(flags);
  }

  public void hasSelectionEnd(int position) {
    check("getSelectionEnd()").that(actual.getSelectionEnd()).isEqualTo(position);
  }

  public void hasSelectionStart(int position) {
    check("getSelectionStart()").that(actual.getSelectionStart()).isEqualTo(position);
  }

  @TargetApi(JELLY_BEAN)
  public void hasShadowColor(int color) {
    int actualColor = actual.getShadowColor();
    check("getShadowColor()")
        .withMessage("Expected shadow color <%s> but was <%s>.",
            Integer.toHexString(color), Integer.toHexString(actualColor))
        .that(actualColor)
        .isEqualTo(color);
  }

  @TargetApi(JELLY_BEAN)
  public void hasShadowDx(float dx, float tolerance) {
    check("getShadowDx()").that(actual.getShadowDx()).isWithin(tolerance).of(dx);
  }

  @TargetApi(JELLY_BEAN)
  public void hasShadowDy(float dy, float tolerance) {
    check("getShadowDx()").that(actual.getShadowDx()).isWithin(tolerance).of(dy);
  }

  @TargetApi(JELLY_BEAN)
  public void hasShadowRadius(float radius, float tolerance) {
    check("getShadowRadius()").that(actual.getShadowRadius()).isWithin(tolerance).of(radius);
  }

  @CheckReturnValue
  public StringSubject text() {
    return check("getText()").that(actual.getText().toString());
  }

  public void hasText(@StringRes int resId) {
    text().isEqualTo(actual.getContext().getString(resId));
  }

  public void containsText(@StringRes int resId) {
    text().contains(actual.getContext().getString(resId));
  }

  public void doesNotContainText(@StringRes int resId) {
    text().doesNotContain(actual.getContext().getString(resId));
  }

  public void startsWithText(@StringRes int resId) {
    text().startsWith(actual.getContext().getString(resId));
  }

  public void endsWithText(@StringRes int resId) {
    text().endsWith(actual.getContext().getString(resId));
  }

  @TargetApi(JELLY_BEAN_MR1)
  public void hasTextLocale(@Nullable Locale locale) {
    check("getTextLocale()").that(actual.getTextLocale()).isEqualTo(locale);
  }

  public void hasTextScaleX(float scale, float tolerance) {
    check("getTextScaleX()").that(actual.getTextScaleX()).isWithin(tolerance).of(scale);
  }

  public void hasTextSize(float size, float tolerance) {
    check("getTextSize()").that(actual.getTextSize()).isWithin(tolerance).of(size);
  }

  public void hasTotalPaddingBottom(int padding) {
    check("getTotalPaddingBottom()").that(actual.getTotalPaddingBottom()).isEqualTo(padding);
  }

  @TargetApi(JELLY_BEAN_MR1)
  public void hasTotalPaddingEnd(int padding) {
    check("getTotalPaddingEnd()").that(actual.getTotalPaddingEnd()).isEqualTo(padding);
  }

  public void hasTotalPaddingLeft(int padding) {
    check("getTotalPaddingLeft()").that(actual.getTotalPaddingLeft()).isEqualTo(padding);
  }

  public void hasTotalPaddingRight(int padding) {
    check("getTotalPaddingRight()").that(actual.getTotalPaddingRight()).isEqualTo(padding);
  }

  @TargetApi(JELLY_BEAN_MR1)
  public void hasTotalPaddingStart(int padding) {
    check("getTotalPaddingStart()").that(actual.getTotalPaddingStart()).isEqualTo(padding);
  }

  public void hasTotalPaddingTop(int padding) {
    check("getTotalPaddingTop()").that(actual.getTotalPaddingTop()).isEqualTo(padding);
  }

  public void hasTypeface(@Nullable Typeface typeface) {
    check("getTypeface()").that(actual.getTypeface()).isSameInstanceAs(typeface);
  }

  @TargetApi(JELLY_BEAN)
  public void isCursorVisible() {
    check("isCursorVisible()").that(actual.isCursorVisible()).isTrue();
  }

  @TargetApi(JELLY_BEAN)
  public void isCursorNotVisible() {
    check("isCursorVisible()").that(actual.isCursorVisible()).isFalse();
  }

  public void hasSelectableText() {
    check("isTextSelectable()").that(actual.isTextSelectable()).isTrue();
  }

  public void hasUnselectableText() {
    check("isTextSelectable()").that(actual.isTextSelectable()).isFalse();
  }

  public void hasLength(int length) {
    check("length()").that(actual.length()).isEqualTo(length);
  }

  public void isInputMethodTarget() {
    check("isInputMethodTarget()").that(actual.isInputMethodTarget()).isTrue();
  }

  public void isNotInputMethodTarget() {
    check("isInputMethodTarget()").that(actual.isInputMethodTarget()).isFalse();
  }
}
