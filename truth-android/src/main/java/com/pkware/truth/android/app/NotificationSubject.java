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
package com.pkware.truth.android.app;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.graphics.Bitmap;

import androidx.annotation.DrawableRes;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.app.Notification.FLAG_AUTO_CANCEL;
import static android.app.Notification.FLAG_FOREGROUND_SERVICE;
import static android.app.Notification.FLAG_HIGH_PRIORITY;
import static android.app.Notification.FLAG_INSISTENT;
import static android.app.Notification.FLAG_NO_CLEAR;
import static android.app.Notification.FLAG_ONGOING_EVENT;
import static android.app.Notification.FLAG_ONLY_ALERT_ONCE;
import static android.app.Notification.FLAG_SHOW_LIGHTS;
import static android.app.Notification.PRIORITY_DEFAULT;
import static android.app.Notification.PRIORITY_HIGH;
import static android.app.Notification.PRIORITY_LOW;
import static android.app.Notification.PRIORITY_MAX;
import static android.app.Notification.PRIORITY_MIN;
import static android.os.Build.VERSION_CODES.JELLY_BEAN;
import static android.os.Build.VERSION_CODES.KITKAT_WATCH;
import static com.pkware.truth.android.internal.IntegerUtils.buildBitMaskString;
import static com.pkware.truth.android.internal.IntegerUtils.buildNamedValueString;

/**
 * Propositions for {@link Notification} subjects.
 */
public class NotificationSubject extends Subject {

  @Nullable
  private final Notification actual;

  public NotificationSubject(@Nonnull FailureMetadata failureMetadata, @Nullable Notification actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public static String flagsToString(@NotificationFlags int flags) {
    return buildBitMaskString(flags)
        .flag(FLAG_AUTO_CANCEL, "autoCancel")
        .flag(FLAG_FOREGROUND_SERVICE, "foregroundService")
        .flag(FLAG_INSISTENT, "insistent")
        .flag(FLAG_NO_CLEAR, "noClear")
        .flag(FLAG_ONGOING_EVENT, "ongoingEvent")
        .flag(FLAG_ONLY_ALERT_ONCE, "onlyAlertOnce")
        .flag(FLAG_SHOW_LIGHTS, "showLights")
        .flag(FLAG_HIGH_PRIORITY, "highPriority")
        .get();
  }

  public static String priorityToString(@NotificationPriority int priority) {
    return buildNamedValueString(priority)
        .value(PRIORITY_MIN, "min")
        .value(PRIORITY_LOW, "low")
        .value(PRIORITY_DEFAULT, "default")
        .value(PRIORITY_HIGH, "high")
        .value(PRIORITY_MAX, "max")
        .get();
  }

  public NotificationSubject hasContentIntent(@Nullable PendingIntent intent) {
    check("contentIntent").that(actual.contentIntent).isEqualTo(intent);
    return this;
  }

  public NotificationSubject hasDefaults(int defaults) {
    check("defaults").that(actual.defaults).isEqualTo(defaults);
    return this;
  }

  public NotificationSubject hasDeleteIntent(@Nullable PendingIntent intent) {
    check("deleteIntent").that(actual.deleteIntent).isEqualTo(intent);
    return this;
  }

  public NotificationSubject hasFlags(@NotificationFlags int flags) {
    int actualFlags = actual.flags;
    //noinspection ResourceType
    check("flags")
        .withMessage("Expected flags <%s> but was <%s>.", flagsToString(flags), flagsToString(actualFlags & flags))
        .that(actualFlags & flags)
        .isEqualTo(flags);
    return this;
  }

  public NotificationSubject hasOnlyFlags(@NotificationFlags int flags) {
    int actualFlags = actual.flags;
    //noinspection ResourceType
    check("flags")
        .withMessage("Expected flags <%s> but was <%s>.", flagsToString(flags), flagsToString(actualFlags))
        .that(actualFlags)
        .isEqualTo(flags);
    return this;
  }

  public NotificationSubject hasFullScreenIntent(@Nullable PendingIntent intent) {
    check("fullScreenIntent").that(actual.fullScreenIntent).isEqualTo(intent);
    return this;
  }

  @TargetApi(KITKAT_WATCH)
  public NotificationSubject hasGroup(@Nullable String group) {
    check("getGroup()").that(actual.getGroup()).isEqualTo(group);
    return this;
  }

  public NotificationSubject hasIcon(@DrawableRes int resId) {
    check("icon").that(actual.icon).isEqualTo(resId);
    return this;
  }

  public NotificationSubject hasIconLevel(int level) {
    check("iconLevel").that(actual.iconLevel).isEqualTo(level);
    return this;
  }

  public NotificationSubject hasLargeIcon(@Nullable Bitmap bitmap) {
    check("largeIcon").that(actual.largeIcon).isEqualTo(bitmap);
    return this;
  }

  public NotificationSubject hasLedColor(int color) {
    int actualColor = actual.ledARGB;
    check("ledARGB")
        .withMessage("Expected LED color <%s> but was <%s>.", Integer.toHexString(color), Integer.toHexString(actualColor))
        .that(actualColor)
        .isEqualTo(color);
    return this;
  }

  public NotificationSubject hasLedOffMs(int length) {
    check("ledOffMS").withMessage("LED off time (ms)").that(actual.ledOffMS).isEqualTo(length);
    return this;
  }

  public NotificationSubject hasLedOnMs(int length) {
    check("ledOnMS").withMessage("LED on time (ms)").that(actual.ledOnMS).isEqualTo(length);
    return this;
  }

  public NotificationSubject hasNumber(int number) {
    check("number").that(actual.number).isEqualTo(number);
    return this;
  }

  @TargetApi(JELLY_BEAN)
  public NotificationSubject hasPriority(@NotificationPriority int priority) {
    int actualPriority = actual.priority;
    //noinspection ResourceType
    check("priority")
        .withMessage("Expected priority <%s> but was <%s>.", priorityToString(priority), priorityToString(actualPriority))
        .that(actualPriority)
        .isEqualTo(priority);
    return this;
  }

  @TargetApi(KITKAT_WATCH)
  public NotificationSubject hasSortKey(@Nullable String sortKey) {
    check("getSortKey()").that(actual.getSortKey()).isEqualTo(sortKey);
    return this;
  }

  public NotificationSubject hasTickerText(@Nullable CharSequence text) {
    check("tickerText").that(actual.tickerText).isEqualTo(text);
    return this;
  }

  public NotificationSubject hasVibration(long[] vibration) {
    List<Object> vibrations = new ArrayList<>(vibration.length);
    Collections.addAll(vibrations, vibration);
    check("vibrate").that(actual.vibrate).asList().containsExactlyElementsIn(vibrations).inOrder();
    return this;
  }

  public NotificationSubject hasWhen(long when) {
    check("when").that(actual.when).isEqualTo(when);
    return this;
  }
}
