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

import android.view.Display;
import androidx.annotation.IntDef;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;

@IntDef(
    flag = true,
    value = {
        Display.FLAG_PRESENTATION,
        Display.FLAG_PRIVATE,
        Display.FLAG_SECURE,
        Display.FLAG_SUPPORTS_PROTECTED_BUFFERS
    }
)
@Retention(SOURCE)
@interface DisplayFlags {
}
