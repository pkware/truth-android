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
package com.pkware.truth.android.widget;

import android.annotation.SuppressLint;
import android.support.annotation.IntDef;
import android.view.inputmethod.EditorInfo;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;

// Suppressing lint because IME_NULL and IME_ACTION_UNSPECIFIED are the same value
@SuppressLint("UniqueConstants")
@IntDef({
    EditorInfo.IME_ACTION_UNSPECIFIED,
    EditorInfo.IME_ACTION_NONE,
    EditorInfo.IME_ACTION_GO,
    EditorInfo.IME_ACTION_SEARCH,
    EditorInfo.IME_ACTION_SEND,
    EditorInfo.IME_ACTION_NEXT,
    EditorInfo.IME_ACTION_DONE,
    EditorInfo.IME_ACTION_PREVIOUS,
    EditorInfo.IME_FLAG_NO_FULLSCREEN,
    EditorInfo.IME_FLAG_NAVIGATE_PREVIOUS,
    EditorInfo.IME_FLAG_NAVIGATE_NEXT,
    EditorInfo.IME_FLAG_NO_EXTRACT_UI,
    EditorInfo.IME_FLAG_NO_ACCESSORY_ACTION,
    EditorInfo.IME_FLAG_NO_ENTER_ACTION,
    EditorInfo.IME_FLAG_FORCE_ASCII,
    EditorInfo.IME_NULL
})
@Retention(SOURCE)
@interface TextViewImeOptions {
}
