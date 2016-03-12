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

import android.app.Notification;
import android.support.annotation.IntDef;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;

@IntDef(
    flag = true,
    value = {
        Notification.FLAG_AUTO_CANCEL,
        Notification.FLAG_FOREGROUND_SERVICE,
        Notification.FLAG_INSISTENT,
        Notification.FLAG_NO_CLEAR,
        Notification.FLAG_ONGOING_EVENT,
        Notification.FLAG_ONLY_ALERT_ONCE,
        Notification.FLAG_SHOW_LIGHTS,
        Notification.FLAG_HIGH_PRIORITY
    }
)
@Retention(SOURCE)
@interface NotificationFlags {
}
