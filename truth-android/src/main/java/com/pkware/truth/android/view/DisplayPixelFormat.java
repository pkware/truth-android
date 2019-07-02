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
package com.pkware.truth.android.view;

import android.graphics.PixelFormat;
import androidx.annotation.IntDef;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;

@IntDef({
    PixelFormat.UNKNOWN,
    PixelFormat.TRANSLUCENT,
    PixelFormat.TRANSPARENT,
    PixelFormat.OPAQUE,
    PixelFormat.RGBA_8888,
    PixelFormat.RGBX_8888,
    PixelFormat.RGB_888,
    PixelFormat.RGB_565,
    PixelFormat.RGBA_5551,
    PixelFormat.RGBA_4444,
    PixelFormat.A_8,
    PixelFormat.L_8,
    PixelFormat.LA_88,
    PixelFormat.RGB_332,
    PixelFormat.YCbCr_422_SP,
    PixelFormat.YCbCr_420_SP,
    PixelFormat.YCbCr_422_I,
    PixelFormat.JPEG
})
@Retention(SOURCE)
@interface DisplayPixelFormat {
}
