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
package com.pkware.truth.android.graphics;

import android.annotation.TargetApi;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.graphics.PathEffect;
import android.graphics.Shader;
import android.graphics.Typeface;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import java.util.Locale;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.graphics.Paint.ANTI_ALIAS_FLAG;
import static android.graphics.Paint.DEV_KERN_TEXT_FLAG;
import static android.graphics.Paint.DITHER_FLAG;
import static android.graphics.Paint.EMBEDDED_BITMAP_TEXT_FLAG;
import static android.graphics.Paint.FAKE_BOLD_TEXT_FLAG;
import static android.graphics.Paint.FILTER_BITMAP_FLAG;
import static android.graphics.Paint.LINEAR_TEXT_FLAG;
import static android.graphics.Paint.STRIKE_THRU_TEXT_FLAG;
import static android.graphics.Paint.SUBPIXEL_TEXT_FLAG;
import static android.graphics.Paint.UNDERLINE_TEXT_FLAG;
import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR1;
import static com.pkware.truth.android.internal.IntegerUtils.buildBitMaskString;

public abstract class AbstractPaintSubject<T extends Paint> extends Subject {

  @Nullable
  private final T actual;

  protected AbstractPaintSubject(@Nonnull FailureMetadata failureMetadata, @Nullable T actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  @Nonnull
  private static String flagsToString(@PaintFlags int flags) {
    return buildBitMaskString(flags)
        .flag(ANTI_ALIAS_FLAG, "antiAlias")
        .flag(DEV_KERN_TEXT_FLAG, "devKern")
        .flag(DITHER_FLAG, "dither")
        .flag(FAKE_BOLD_TEXT_FLAG, "fakeBold")
        .flag(FILTER_BITMAP_FLAG, "filterBitmap")
        .flag(LINEAR_TEXT_FLAG, "linearText")
        .flag(STRIKE_THRU_TEXT_FLAG, "strikeThrough")
        .flag(SUBPIXEL_TEXT_FLAG, "subpixelText")
        .flag(UNDERLINE_TEXT_FLAG, "underline")
        .flag(EMBEDDED_BITMAP_TEXT_FLAG, "embedded_bitmap")
        .get();
  }

  public void hasAscent(float ascent, float tolerance) {
    check("ascent()").that(actual.ascent()).isWithin(tolerance).of(ascent);
  }

  public void hasDescent(float descent, float tolerance) {
    check("descent()").that(actual.descent()).isWithin(tolerance).of(descent);
  }

  public void hasAlpha(int alpha) {
    check("getAlpha()").that(actual.getAlpha()).isEqualTo(alpha);
  }

  public void hasColor(int color) {
    int actualColor = actual.getColor();
    check("getColor()")
        .withMessage("Expected color <%s> but was <%s>.", Integer.toHexString(color), Integer.toHexString(actualColor))
        .that(actualColor)
        .isEqualTo(color);
  }

  public void hasFlags(@PaintFlags int flags) {
    int actualFlags = actual.getFlags();
    //noinspection ResourceType
    check("getFlags()")
        .withMessage("Expected flags <%s> but was <%s>.", flagsToString(flags), flagsToString(actualFlags))
        .that(actualFlags)
        .isEqualTo(flags);
  }

  public void hasFontSpacing(float spacing, float tolerance) {
    check("getFontSpacing()").that(actual.getFontSpacing()).isWithin(tolerance).of(spacing);
  }

  public void hasHinting(int hinting) {
    check("getHinting()").that(actual.getHinting()).isEqualTo(hinting);
  }

  public void hasMaskFilter(@Nullable MaskFilter filter) {
    check("getMaskFilter()").that(actual.getMaskFilter()).isSameInstanceAs(filter);
  }

  public void hasPathEffect(@Nullable PathEffect effect) {
    check("getPathEffect()").that(actual.getPathEffect()).isSameInstanceAs(effect);
  }

  public void hasShader(@Nullable Shader shader) {
    check("getShader()").that(actual.getShader()).isSameInstanceAs(shader);
  }

  public void hasStrokeCap(@Nullable Paint.Cap cap) {
    check("getStrokeCap()").that(actual.getStrokeCap()).isEqualTo(cap);
  }

  public void hasStrokeJoin(@Nullable Paint.Join join) {
    check("getStrokeJoin()").that(actual.getStrokeJoin()).isEqualTo(join);
  }

  public void hasStrokeMiter(float miter, float tolerance) {
    check("getStrokeMiter()").that(actual.getStrokeMiter()).isWithin(tolerance).of(miter);
  }

  public void hasStrokeWidth(float width, float tolerance) {
    check("getStrokeWidth()").that(actual.getStrokeWidth()).isWithin(tolerance).of(width);
  }

  public void hasStyle(@Nullable Paint.Style style) {
    check("getStyle()").that(actual.getStyle()).isEqualTo(style);
  }

  public void hasTextAlign(@Nullable Paint.Align align) {
    check("getTextAlign()").that(actual.getTextAlign()).isEqualTo(align);
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

  public void hasTextSkewX(float skew, float tolerance) {
    check("getTextSkewX()").that(actual.getTextSkewX()).isWithin(tolerance).of(skew);
  }

  public void hasTypeface(@Nullable Typeface typeface) {
    check("getTypeface()").that(actual.getTypeface()).isSameInstanceAs(typeface);
  }

  public void isAntiAliased() {
    check("isAntiAlias()").that(actual.isAntiAlias()).isTrue();
  }

  public void isNotAntiAliased() {
    check("isAntiAlias()").that(actual.isAntiAlias()).isFalse();
  }

  public void isDithering() {
    check("isDither()").that(actual.isDither()).isTrue();
  }

  public void isNotDithering() {
    check("isDither()").that(actual.isDither()).isFalse();
  }

  public void isFakingBoldText() {
    check("isFakeBoldText()").that(actual.isFakeBoldText()).isTrue();
  }

  public void isNotFakingBoldText() {
    check("isFakeBoldText()").that(actual.isFakeBoldText()).isFalse();
  }

  public void isStrikingThroughText() {
    check("isStrikeThruText()").that(actual.isStrikeThruText()).isTrue();
  }

  public void isNotStrikingThroughText() {
    check("isStrikeThruText()").that(actual.isStrikeThruText()).isFalse();
  }

  public void isSubpixelText() {
    check("isSubpixelText()").that(actual.isSubpixelText()).isTrue();
  }

  public void isNotSubpixelText() {
    check("isSubpixelText()").that(actual.isSubpixelText()).isFalse();
  }

  public void isUnderliningText() {
    check("isUnderlineText()").that(actual.isUnderlineText()).isTrue();
  }

  public void isNotUnderliningText() {
    check("isUnderlineText()").that(actual.isUnderlineText()).isFalse();
  }
}
