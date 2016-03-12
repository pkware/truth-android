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
package com.pkware.truth.android.app;

import android.content.pm.ActivityInfo;
import android.support.annotation.IntDef;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;

@IntDef({
    ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED,
    ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE,
    ActivityInfo.SCREEN_ORIENTATION_PORTRAIT,
    ActivityInfo.SCREEN_ORIENTATION_USER,
    ActivityInfo.SCREEN_ORIENTATION_BEHIND,
    ActivityInfo.SCREEN_ORIENTATION_SENSOR,
    ActivityInfo.SCREEN_ORIENTATION_NOSENSOR,
    ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE,
    ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT,
    ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE,
    ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT,
    ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR,
    ActivityInfo.SCREEN_ORIENTATION_USER_LANDSCAPE,
    ActivityInfo.SCREEN_ORIENTATION_USER_PORTRAIT,
    ActivityInfo.SCREEN_ORIENTATION_FULL_USER,
    ActivityInfo.SCREEN_ORIENTATION_LOCKED
})
@Retention(SOURCE)
@interface ActivityScreenOrientation {
}
