/*
 * Copyright 2013 Square, Inc.
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

import android.graphics.Paint;
import androidx.annotation.IntDef;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;

@IntDef(
    flag = true,
    value = {
        Paint.ANTI_ALIAS_FLAG,
        Paint.DEV_KERN_TEXT_FLAG,
        Paint.DITHER_FLAG,
        Paint.FAKE_BOLD_TEXT_FLAG,
        Paint.FILTER_BITMAP_FLAG,
        Paint.LINEAR_TEXT_FLAG,
        Paint.STRIKE_THRU_TEXT_FLAG,
        Paint.SUBPIXEL_TEXT_FLAG,
        Paint.UNDERLINE_TEXT_FLAG
    })
@Retention(SOURCE)
@interface PaintFlags {
}
