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
package com.pkware.truth.android.playservices.location;

import android.support.annotation.IntDef;

import com.google.android.gms.location.DetectedActivity;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;

@IntDef({
    DetectedActivity.IN_VEHICLE,
    DetectedActivity.ON_BICYCLE,
    DetectedActivity.ON_FOOT,
    DetectedActivity.RUNNING,
    DetectedActivity.STILL,
    DetectedActivity.TILTING,
    DetectedActivity.UNKNOWN,
    DetectedActivity.WALKING
})
@Retention(SOURCE)
@interface DetectedActivityType {
}
