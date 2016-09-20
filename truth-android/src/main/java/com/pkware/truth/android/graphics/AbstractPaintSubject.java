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
package com.pkware.truth.android.graphics;

import android.annotation.TargetApi;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.graphics.PathEffect;
import android.graphics.Rasterizer;
import android.graphics.Shader;
import android.graphics.Typeface;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;

import java.util.Locale;

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
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assert_;
import static com.pkware.truth.android.internal.IntegerUtils.buildBitMaskString;

public class AbstractPaintSubject<S extends AbstractPaintSubject<S, T>, T extends Paint> extends Subject<S, T> {
  protected AbstractPaintSubject(FailureStrategy failureStrategy, T subject) {
    super(failureStrategy, subject);
  }

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

  public S hasAscent(float ascent, float tolerance) {
    assertThat(actual().ascent())
        .named("ascent")
        .isWithin(tolerance)
        .of(ascent);
    //noinspection unchecked
    return (S) this;
  }

  public S hasDescent(float descent, float tolerance) {
    assertThat(actual().descent())
        .named("descent")
        .isWithin(tolerance)
        .of(descent);
    //noinspection unchecked
    return (S) this;
  }

  public S hasAlpha(int alpha) {
    assertThat(actual().getAlpha())
        .named("alpha")
        .isEqualTo(alpha);
    //noinspection unchecked
    return (S) this;
  }

  public S hasColor(int color) {
    int actualColor = actual().getColor();
    assert_()
        .withFailureMessage("Expected color <%s> but was <%s>.", Integer.toHexString(color), Integer.toHexString(actualColor))
        .that(actualColor)
        .isEqualTo(color);
    //noinspection unchecked
    return (S) this;
  }

  public S hasFlags(@PaintFlags int flags) {
    int actualFlags = actual().getFlags();
    //noinspection ResourceType
    assert_()
        .withFailureMessage("Expected flags <%s> but was <%s>.", flagsToString(flags), flagsToString(actualFlags))
        .that(actualFlags)
        .isEqualTo(flags);
    //noinspection unchecked
    return (S) this;
  }

  public S hasFontSpacing(float spacing, float tolerance) {
    assertThat(actual().getFontSpacing())
        .named("font spacing")
        .isWithin(tolerance)
        .of(spacing);
    //noinspection unchecked
    return (S) this;
  }

  public S hasHinting(int hinting) {
    assertThat(actual().getHinting())
        .named("hinting")
        .isEqualTo(hinting);
    //noinspection unchecked
    return (S) this;
  }

  public S hasMaskFilter(MaskFilter filter) {
    assertThat(actual().getMaskFilter())
        .named("mask filter")
        .isSameAs(filter);
    //noinspection unchecked
    return (S) this;
  }

  public S hasPathEffect(PathEffect effect) {
    assertThat(actual().getPathEffect())
        .named("path effect")
        .isSameAs(effect);
    //noinspection unchecked
    return (S) this;
  }

  public S hasRasterizer(Rasterizer rasterizer) {
    assertThat(actual().getRasterizer())
        .named("rasterizer")
        .isSameAs(rasterizer);
    //noinspection unchecked
    return (S) this;
  }

  public S hasShader(Shader shader) {
    assertThat(actual().getShader())
        .named("shader")
        .isSameAs(shader);
    //noinspection unchecked
    return (S) this;
  }

  public S hasStrokeCap(Paint.Cap cap) {
    assertThat(actual().getStrokeCap())
        .named("stroke cap")
        .isEqualTo(cap);
    //noinspection unchecked
    return (S) this;
  }

  public S hasStrokeJoin(Paint.Join join) {
    assertThat(actual().getStrokeJoin())
        .named("stroke join")
        .isEqualTo(join);
    //noinspection unchecked
    return (S) this;
  }

  public S hasStrokeMiter(float miter, float tolerance) {
    assertThat(actual().getStrokeMiter())
        .named("stroke miter")
        .isWithin(tolerance)
        .of(miter);
    //noinspection unchecked
    return (S) this;
  }

  public S hasStrokeWidth(float width, float tolerance) {
    assertThat(actual().getStrokeWidth())
        .named("stroke width")
        .isWithin(tolerance)
        .of(width);
    //noinspection unchecked
    return (S) this;
  }

  public S hasStyle(Paint.Style style) {
    assertThat(actual().getStyle())
        .named("style")
        .isEqualTo(style);
    //noinspection unchecked
    return (S) this;
  }

  public S hasTextAlign(Paint.Align align) {
    assertThat(actual().getTextAlign())
        .named("text align")
        .isEqualTo(align);
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(JELLY_BEAN_MR1)
  public S hasTextLocale(Locale locale) {
    assertThat(actual().getTextLocale())
        .named("text locale")
        .isEqualTo(locale);
    //noinspection unchecked
    return (S) this;
  }

  public S hasTextScaleX(float scale, float tolerance) {
    assertThat(actual().getTextScaleX())
        .named("text X scale")
        .isWithin(tolerance)
        .of(scale);
    //noinspection unchecked
    return (S) this;
  }

  public S hasTextSize(float size, float tolerance) {
    assertThat(actual().getTextSize())
        .named("text size")
        .isWithin(tolerance)
        .of(size);
    //noinspection unchecked
    return (S) this;
  }

  public S hasTextSkewX(float skew, float tolerance) {
    assertThat(actual().getTextSkewX())
        .named("text X skew")
        .isWithin(tolerance)
        .of(skew);
    //noinspection unchecked
    return (S) this;
  }

  public S hasTypeface(Typeface typeface) {
    assertThat(actual().getTypeface())
        .named("typeface")
        .isSameAs(typeface);
    //noinspection unchecked
    return (S) this;
  }

  public S isAntiAliased() {
    assertThat(actual().isAntiAlias())
        .named("is anti-aliased")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotAntiAliased() {
    assertThat(actual().isAntiAlias())
        .named("is anti-aliased")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S isDithering() {
    assertThat(actual().isDither())
        .named("is dithering")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotDithering() {
    assertThat(actual().isDither())
        .named("is dithering")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S isFakingBoldText() {
    assertThat(actual().isFakeBoldText())
        .named("is faking bold text")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotFakingBoldText() {
    assertThat(actual().isFakeBoldText())
        .named("is faking bold text")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S isStrikingThroughText() {
    assertThat(actual().isStrikeThruText())
        .named("is striking through text")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotStrikingThroughText() {
    assertThat(actual().isStrikeThruText())
        .named("is striking through text")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S isSubpixelText() {
    assertThat(actual().isSubpixelText())
        .named("has subpixel text")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotSubpixelText() {
    assertThat(actual().isSubpixelText())
        .named("has subpixel text")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }

  public S isUnderliningText() {
    assertThat(actual().isUnderlineText())
        .named("is underlining text")
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }

  public S isNotUnderliningText() {
    assertThat(actual().isUnderlineText())
        .named("is underlining text")
        .isFalse();
    //noinspection unchecked
    return (S) this;
  }
}
