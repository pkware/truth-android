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
package com.pkware.truth.android.mediarouter.v7.media;

import android.support.annotation.IntDef;
import android.support.v7.media.MediaSessionStatus;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;

@IntDef({
    MediaSessionStatus.SESSION_STATE_ACTIVE,
    MediaSessionStatus.SESSION_STATE_ENDED,
    MediaSessionStatus.SESSION_STATE_INVALIDATED
})
@Retention(SOURCE)
@interface MediaSessionStatusState {
}
