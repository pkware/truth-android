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
package com.pkware.truth.android.widget;

import android.annotation.TargetApi;
import android.graphics.Typeface;
import android.support.annotation.StringRes;
import android.text.TextUtils;
import android.widget.TextView;

import com.google.common.truth.FailureStrategy;
import com.pkware.truth.android.view.AbstractViewSubject;

import java.util.Locale;
import java.util.regex.Pattern;

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
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assert_;
import static com.pkware.truth.android.internal.IntegerUtils.buildBitMaskString;

public abstract class AbstractTextViewSubject<S extends AbstractTextViewSubject<S, T>, T extends TextView>
    extends AbstractViewSubject<S, T> {
  protected AbstractTextViewSubject(FailureStrategy failureStrategy, T subject) {
    super(failureStrategy, subject);
  }

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

  public S hasAutoLinkMask(int mask) {
    assertThat(getSubject().getAutoLinkMask())
        .named("auto-link mask")
        .isEqualTo(mask);
    //noinspection unchecked
    return (S) this;
  }

  public S hasCompoundDrawablePadding(int padding) {
    assertThat(getSubject().getCompoundDrawablePadding())
        .named("compound drawable padding")
        .isEqualTo(padding);
    //noinspection unchecked
    return (S) this;
  }

  public S hasCompoundPaddingBottom(int padding) {
    assertThat(getSubject().getCompoundPaddingBottom())
        .named("compound drawable bottom padding")
        .isEqualTo(padding);
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(JELLY_BEAN_MR1)
  public S hasCompoundPaddingEnd(int padding) {
    assertThat(getSubject().getCompoundPaddingEnd())
        .named("compound drawable end padding")
        .isEqualTo(padding);
    //noinspection unchecked
    return (S) this;
  }

  public S hasCompoundPaddingLeft(int padding) {
    assertThat(getSubject().getCompoundPaddingLeft())
        .named("compound drawable left padding")
        .isEqualTo(padding);
    //noinspection unchecked
    return (S) this;
  }

  public S hasCompoundPaddingRight(int padding) {
    assertThat(getSubject().getCompoundPaddingRight())
        .named("compound drawable right padding")
        .isEqualTo(padding);
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(JELLY_BEAN_MR1)
  public S hasCompoundPaddingStart(int padding) {
    assertThat(getSubject().getCompoundPaddingStart())
        .named("compound drawable start padding")
        .isEqualTo(padding);
    //noinspection unchecked
    return (S) this;
  }

  public S hasCompoundPaddingTop(int padding) {
    assertThat(getSubject().getCompoundPaddingTop())
        .named("compound drawable top padding")
        .isEqualTo(padding);
    //noinspection unchecked
    return (S) this;
  }

  public S hasCurrentHintTextColor(int color) {
    int actualColor = getSubject().getCurrentHintTextColor();
    assert_()
        .withFailureMessage("Expected current hint text color <%s> but was <%s>.",
            Integer.toHexString(color), Integer.toHexString(actualColor))
        .that(actualColor)
        .isEqualTo(color);
    //noinspection unchecked
    return (S) this;
  }

  public S hasCurrentTextColor(int color) {
    int actualColor = getSubject().getCurrentTextColor();
    assert_()
        .withFailureMessage("Expected current text color <%s> but was <%s>.",
            Integer.toHexString(color), Integer.toHexString(actualColor))
        .that(actualColor)
        .isEqualTo(color);
    //noinspection unchecked
    return (S) this;
  }

  public S hasEllipsize(TextUtils.TruncateAt truncation) {
    TextUtils.TruncateAt actualTruncation = getSubject().getEllipsize();
    assertThat(getSubject().getEllipsize())
        .named("ellipsize")
        .isEqualTo(truncation);
    //noinspection unchecked
    return (S) this;
  }

  public S hasError() {
    assertThat(getSubject().getError())
        .named("error")
        .isNotNull();
    //noinspection unchecked
    return (S) this;
  }

  public S hasNoError() {
    assertThat(getSubject().getError())
        .named("error")
        .isNull();
    //noinspection unchecked
    return (S) this;
  }

  public S hasError(String error) {
    assertThat(getSubject().getError().toString())
        .named("error")
        .isEqualTo(error);
    //noinspection unchecked
    return (S) this;
  }

  public S hasError(@StringRes int resId) {
    return hasError(getSubject().getContext().getString(resId));
  }

  public S hasExtendedPaddingBottom(int padding) {
    assertThat(getSubject().getExtendedPaddingBottom())
        .named("extended bottom padding")
        .isEqualTo(padding);
    //noinspection unchecked
    return (S) this;
  }

  public S hasExtendedPaddingTop(int padding) {
    int actualPadding = getSubject().getExtendedPaddingTop();
    assertThat(getSubject().getExtendedPaddingTop())
        .named("extended top padding")
        .isEqualTo(padding);
    //noinspection unchecked
    return (S) this;
  }

  public S hasFreezesText(boolean freezes) {
    assertThat(getSubject().getFreezesText())
        .named("freezes text")
        .isEqualTo(freezes);
    //noinspection unchecked
    return (S) this;
  }

  public S hasGravity(@TextViewGravity int gravity) {
    int actualGravity = getSubject().getGravity();
    //noinspection ResourceType
    assert_()
        .withFailureMessage("Expected gravity <%s> but was <%s>.", gravityToString(gravity),
            gravityToString(actualGravity))
        .that(actualGravity)
        .isEqualTo(gravity);
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(JELLY_BEAN)
  public S hasHighlightColor(int color) {
    int actualColor = getSubject().getHighlightColor();
    assert_()
        .withFailureMessage("Expected highlight color <%s> but was <%s>.",
            Integer.toHexString(color), Integer.toHexString(actualColor))
        .that(actualColor)
        .isEqualTo(color);
    //noinspection unchecked
    return (S) this;
  }

  public S hasHint(String hint) {
    assertThat(getSubject().getHint().toString())
        .named("hint")
        .isEqualTo(hint);
    //noinspection unchecked
    return (S) this;
  }

  public S hasHint(@StringRes int resId) {
    return hasHint(getSubject().getContext().getString(resId));
  }

  public S hasImeActionId(int id) {
    assertThat(getSubject().getImeActionId())
        .named("IME action ID")
        .isEqualTo(id);
    //noinspection unchecked
    return (S) this;
  }

  public S hasImeActionLabel(String label) {
    assertThat(getSubject().getImeActionLabel().toString())
        .named("IME action label")
        .isEqualTo(label);
    //noinspection unchecked
    return (S) this;
  }

  public S hasImeActionLabel(@StringRes int resId) {
    return hasImeActionLabel(getSubject().getContext().getString(resId));
  }

  public S hasImeOptions(@TextViewImeOptions int options) {
    int actualOptions = getSubject().getImeOptions();
    //noinspection ResourceType
    assert_()
        .withFailureMessage("Expected IME options <%s> but was <%s>.",
            imeOptionsToString(options), imeOptionsToString(actualOptions))
        .that(actualOptions)
        .isEqualTo(options);
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(JELLY_BEAN)
  public S isIncludingFontPadding() {
    assertThat(getSubject().getIncludeFontPadding())
        .named("is including font padding")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(JELLY_BEAN)
  public S isNotIncludingFontPadding() {
    assertThat(getSubject().getIncludeFontPadding())
        .named("is including font padding")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S hasInputType(int type) {
    int actualType = getSubject().getInputType();
    assertThat(actualType)
        .named("input type")
        .isEqualTo(type);
    //noinspection unchecked
    return (S) this;
  }

  public S hasLineCount(int count) {
    assertThat(getSubject().getLineCount())
        .named("line count")
        .isEqualTo(count);
    //noinspection unchecked
    return (S) this;
  }

  public S hasLineHeight(int height) {
    assertThat(getSubject().getLineHeight())
        .named("line height")
        .isEqualTo(height);
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(JELLY_BEAN)
  public S hasLineSpacingExtra(float extra, float tolerance) {
    assertThat(getSubject().getLineSpacingExtra())
        .named("line spacing extra")
        .isWithin(tolerance)
        .of(extra);
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(JELLY_BEAN)
  public S hasLineSpacingMultiplier(float multiplier, float tolerance) {
    float actualMultiplier = getSubject().getLineSpacingMultiplier();
    assertThat(getSubject().getLineSpacingMultiplier())
        .named("line spacing multiplier")
        .isWithin(tolerance)
        .of(multiplier);
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(JELLY_BEAN)
  public S hasMarqueeRepeatLimit(int limit) {
    assertThat(getSubject().getMarqueeRepeatLimit())
        .named("marquee repeat limit")
        .isEqualTo(limit);
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(JELLY_BEAN)
  public S hasMaxEms(int ems) {
    assertThat(getSubject().getMaxEms())
        .named("maximum EMs")
        .isEqualTo(ems);
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(JELLY_BEAN)
  public S hasMaxHeight(int height) {
    assertThat(getSubject().getMaxHeight())
        .named("maximum height")
        .isEqualTo(height);
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(JELLY_BEAN)
  public S hasMaxLines(int lines) {
    assertThat(getSubject().getMaxLines())
        .named("maximum lines")
        .isEqualTo(lines);
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(JELLY_BEAN)
  public S hasMaxWidth(int ems) {
    assertThat(getSubject().getMaxWidth())
        .named("maximum width")
        .isEqualTo(ems);
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(JELLY_BEAN)
  public S hasMinEms(int ems) {
    assertThat(getSubject().getMinEms())
        .named("minimum EMs")
        .isEqualTo(ems);
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(JELLY_BEAN)
  public S hasMinHeight(int height) {
    assertThat(getSubject().getMinHeight())
        .named("minimum height")
        .isEqualTo(height);
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(JELLY_BEAN)
  public S hasMinLines(int lines) {
    assertThat(getSubject().getMinLines())
        .named("minimum lines")
        .isEqualTo(lines);
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(JELLY_BEAN)
  public S hasMinWidth(int ems) {
    assertThat(getSubject().getMinWidth())
        .named("minimum width")
        .isEqualTo(ems);
    //noinspection unchecked
    return (S) this;
  }

  public S hasPaintFlags(int flags) {
    assertThat(getSubject().getPaintFlags())
        .named("paint flags")
        .isEqualTo(flags);
    //noinspection unchecked
    return (S) this;
  }

  public S hasSelectionEnd(int position) {
    assertThat(getSubject().getSelectionEnd())
        .named("selection end")
        .isEqualTo(position);
    //noinspection unchecked
    return (S) this;
  }

  public S hasSelectionStart(int position) {
    assertThat(getSubject().getSelectionStart())
        .named("selection start")
        .isEqualTo(position);
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(JELLY_BEAN)
  public S hasShadowColor(int color) {
    int actualColor = getSubject().getShadowColor();
    assert_()
        .withFailureMessage("Expected shadow color <%s> but was <%s>.",
            Integer.toHexString(color), Integer.toHexString(actualColor))
        .that(actualColor)
        .isEqualTo(color);
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(JELLY_BEAN)
  public S hasShadowDx(float dx, float tolerance) {
    assertThat(getSubject().getShadowDx())
        .named("shadow DX")
        .isWithin(tolerance)
        .of(dx);
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(JELLY_BEAN)
  public S hasShadowDy(float dy, float tolerance) {
    assertThat(getSubject().getShadowDx())
        .named("shadow DY")
        .isWithin(tolerance)
        .of(dy);
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(JELLY_BEAN)
  public S hasShadowRadius(float radius, float tolerance) {
    assertThat(getSubject().getShadowRadius())
        .named("shadow radius")
        .isWithin(tolerance)
        .of(radius);
    //noinspection unchecked
    return (S) this;
  }

  public S hasText(String text) {
    assertThat(getSubject().getText().toString())
        .named("text")
        .isEqualTo(text);
    //noinspection unchecked
    return (S) this;
  }

  public S hasText(@StringRes int resId) {
    return hasText(getSubject().getContext().getString(resId));
  }

  public S isEmpty() {
    return hasText("");
  }

  public S isNotEmpty() {
    assertThat(getSubject().getText().toString())
        .named("is not empty")
        .isNotEqualTo("");
    //noinspection unchecked
    return (S) this;
  }

  public S matches(Pattern pattern) {
    String text = getSubject().getText().toString();
    assert_()
        .withFailureMessage("Expected text <%s> to match <%s>, but did not.", text, pattern.pattern())
        .that(pattern.matcher(text).matches())
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S doesNotMatch(Pattern pattern) {
    String text = getSubject().getText().toString();
    assert_()
        .withFailureMessage("Expected text <%s> to not match <%s>, but did.", text, pattern.pattern())
        .that(pattern.matcher(text).matches())
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S containsText(String sequence) {
    assertThat(getSubject().getText().toString()).contains(sequence);
    //noinspection unchecked
    return (S) this;
  }

  public S containsText(@StringRes int resId) {
    return containsText(getSubject().getContext().getString(resId));
  }

  public S doesNotContainText(String sequence) {
    assertThat(getSubject().getText().toString()).doesNotContain(sequence);
    //noinspection unchecked
    return (S) this;
  }

  public S doesNotContainText(@StringRes int resId) {
    return doesNotContainText(getSubject().getContext().getString(resId));
  }

  public S startsWithText(String sequence) {
    assertThat(getSubject().getText().toString())
        .named("text")
        .startsWith(sequence);
    //noinspection unchecked
    return (S) this;
  }

  public S startsWithText(@StringRes int resId) {
    return startsWithText(getSubject().getContext().getString(resId));
  }

  public S endsWithText(String sequence) {
    assertThat(getSubject().getText().toString())
        .named("text")
        .endsWith(sequence);
    //noinspection unchecked
    return (S) this;
  }

  public S endsWithText(@StringRes int resId) {
    return endsWithText(getSubject().getContext().getString(resId));
  }

  @TargetApi(JELLY_BEAN_MR1)
  public S hasTextLocale(Locale locale) {
    assertThat(getSubject().getTextLocale())
        .named("text locale")
        .isEqualTo(locale);
    //noinspection unchecked
    return (S) this;
  }

  public S hasTextScaleX(float scale, float tolerance) {
    assertThat(getSubject().getTextScaleX())
        .named("text X scale")
        .isWithin(tolerance)
        .of(scale);
    //noinspection unchecked
    return (S) this;
  }

  public S hasTextSize(float size, float tolerance) {
    assertThat(getSubject().getTextSize())
        .named("text size")
        .isWithin(tolerance)
        .of(size);
    //noinspection unchecked
    return (S) this;
  }

  public S hasTotalPaddingBottom(int padding) {
    assertThat(getSubject().getTotalPaddingBottom())
        .named("total bottom padding")
        .isEqualTo(padding);
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(JELLY_BEAN_MR1)
  public S hasTotalPaddingEnd(int padding) {
    assertThat(getSubject().getTotalPaddingEnd())
        .named("total end padding")
        .isEqualTo(padding);
    //noinspection unchecked
    return (S) this;
  }

  public S hasTotalPaddingLeft(int padding) {
    assertThat(getSubject().getTotalPaddingLeft())
        .named("total left padding")
        .isEqualTo(padding);
    //noinspection unchecked
    return (S) this;
  }

  public S hasTotalPaddingRight(int padding) {
    assertThat(getSubject().getTotalPaddingRight())
        .named("total right padding")
        .isEqualTo(padding);
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(JELLY_BEAN_MR1)
  public S hasTotalPaddingStart(int padding) {
    assertThat(getSubject().getTotalPaddingStart())
        .named("total start padding")
        .isEqualTo(padding);
    //noinspection unchecked
    return (S) this;
  }

  public S hasTotalPaddingTop(int padding) {
    assertThat(getSubject().getTotalPaddingTop())
        .named("total top padding")
        .isEqualTo(padding);
    //noinspection unchecked
    return (S) this;
  }

  public S hasTypeface(Typeface typeface) {
    assertThat(getSubject().getTypeface())
        .named("typeface")
        .isSameAs(typeface);
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(JELLY_BEAN)
  public S isCursorVisible() {
    assertThat(getSubject().isCursorVisible())
        .named("is cursor visible")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(JELLY_BEAN)
  public S isCursorNotVisible() {
    assertThat(getSubject().isCursorVisible())
        .named("is cursor visible")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S hasSelectableText() {
    assertThat(getSubject().isTextSelectable())
        .named("is text selectable")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S hasUnselectableText() {
    assertThat(getSubject().isTextSelectable())
        .named("is text selectable")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S hasLength(int length) {
    assertThat(getSubject().length())
        .named("length")
        .isEqualTo(length);
    //noinspection unchecked
    return (S) this;
  }

  public S isInputMethodTarget() {
    assertThat(getSubject().isInputMethodTarget())
        .named("is input method target")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotInputMethodTarget() {
    assertThat(getSubject().isInputMethodTarget())
        .named("is input method target")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }
}
