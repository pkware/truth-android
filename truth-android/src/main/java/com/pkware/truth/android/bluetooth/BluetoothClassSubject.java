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
package com.pkware.truth.android.bluetooth;

import android.bluetooth.BluetoothClass;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import java.util.Locale;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assert_;
import static com.pkware.truth.android.internal.IntegerUtils.buildNamedValueString;

/**
 * Propositions for {@link BluetoothClass} subjects.
 */
public class BluetoothClassSubject extends Subject<BluetoothClassSubject, BluetoothClass> {
  public BluetoothClassSubject(FailureMetadata failureMetadata, BluetoothClass subject) {
    super(failureMetadata, subject);
  }

  public static String deviceClassToString(int deviceClass) {
    return buildNamedValueString(deviceClass)
        .value(BluetoothClass.Device.AUDIO_VIDEO_CAMCORDER, "AUDIO_VIDEO_CAMCORDER")
        .value(BluetoothClass.Device.AUDIO_VIDEO_CAR_AUDIO, "AUDIO_VIDEO_CAR_AUDIO")
        .value(BluetoothClass.Device.AUDIO_VIDEO_HANDSFREE, "AUDIO_VIDEO_HANDSFREE")
        .value(BluetoothClass.Device.AUDIO_VIDEO_HEADPHONES, "AUDIO_VIDEO_HEADPHONES")
        .value(BluetoothClass.Device.AUDIO_VIDEO_HIFI_AUDIO, "AUDIO_VIDEO_HIFI_AUDIO")
        .value(BluetoothClass.Device.AUDIO_VIDEO_LOUDSPEAKER, "AUDIO_VIDEO_LOUDSPEAKER")
        .value(BluetoothClass.Device.AUDIO_VIDEO_MICROPHONE, "AUDIO_VIDEO_MICROPHONE")
        .value(BluetoothClass.Device.AUDIO_VIDEO_PORTABLE_AUDIO, "AUDIO_VIDEO_PORTABLE_AUDIO")
        .value(BluetoothClass.Device.AUDIO_VIDEO_SET_TOP_BOX, "AUDIO_VIDEO_SET_TOP_BOX")
        .value(BluetoothClass.Device.AUDIO_VIDEO_UNCATEGORIZED, "AUDIO_VIDEO_UNCATEGORIZED")
        .value(BluetoothClass.Device.AUDIO_VIDEO_VCR, "AUDIO_VIDEO_VCR")
        .value(BluetoothClass.Device.AUDIO_VIDEO_VIDEO_CAMERA, "AUDIO_VIDEO_VIDEO_CAMERA")
        .value(BluetoothClass.Device.AUDIO_VIDEO_VIDEO_CONFERENCING,
            "AUDIO_VIDEO_VIDEO_CONFERENCING")
        .value(BluetoothClass.Device.AUDIO_VIDEO_VIDEO_DISPLAY_AND_LOUDSPEAKER,
            "AUDIO_VIDEO_VIDEO_DISPLAY_AND_LOUDSPEAKER")
        .value(BluetoothClass.Device.AUDIO_VIDEO_VIDEO_GAMING_TOY, "AUDIO_VIDEO_VIDEO_GAMING_TOY")
        .value(BluetoothClass.Device.AUDIO_VIDEO_VIDEO_MONITOR, "AUDIO_VIDEO_VIDEO_MONITOR")
        .value(BluetoothClass.Device.AUDIO_VIDEO_WEARABLE_HEADSET, "AUDIO_VIDEO_WEARABLE_HEADSET")
        .value(BluetoothClass.Device.COMPUTER_DESKTOP, "COMPUTER_DESKTOP")
        .value(BluetoothClass.Device.COMPUTER_HANDHELD_PC_PDA, "COMPUTER_HANDHELD_PC_PDA")
        .value(BluetoothClass.Device.COMPUTER_LAPTOP, "COMPUTER_LAPTOP")
        .value(BluetoothClass.Device.COMPUTER_PALM_SIZE_PC_PDA, "COMPUTER_PALM_SIZE_PC_PDA")
        .value(BluetoothClass.Device.COMPUTER_SERVER, "COMPUTER_SERVER")
        .value(BluetoothClass.Device.COMPUTER_UNCATEGORIZED, "COMPUTER_UNCATEGORIZED")
        .value(BluetoothClass.Device.COMPUTER_WEARABLE, "COMPUTER_WEARABLE")
        .value(BluetoothClass.Device.HEALTH_BLOOD_PRESSURE, "HEALTH_BLOOD_PRESSURE")
        .value(BluetoothClass.Device.HEALTH_DATA_DISPLAY, "HEALTH_DATA_DISPLAY")
        .value(BluetoothClass.Device.HEALTH_GLUCOSE, "HEALTH_GLUCOSE")
        .value(BluetoothClass.Device.HEALTH_PULSE_OXIMETER, "HEALTH_PULSE_OXIMETER")
        .value(BluetoothClass.Device.HEALTH_PULSE_RATE, "HEALTH_PULSE_RATE")
        .value(BluetoothClass.Device.HEALTH_THERMOMETER, "HEALTH_THERMOMETER")
        .value(BluetoothClass.Device.HEALTH_UNCATEGORIZED, "HEALTH_UNCATEGORIZED")
        .value(BluetoothClass.Device.HEALTH_WEIGHING, "HEALTH_WEIGHING")
        .value(BluetoothClass.Device.PHONE_CELLULAR, "PHONE_CELLULAR")
        .value(BluetoothClass.Device.PHONE_CORDLESS, "PHONE_CORDLESS")
        .value(BluetoothClass.Device.PHONE_ISDN, "PHONE_ISDN")
        .value(BluetoothClass.Device.PHONE_MODEM_OR_GATEWAY, "PHONE_MODEM_OR_GATEWAY")
        .value(BluetoothClass.Device.PHONE_SMART, "PHONE_SMART")
        .value(BluetoothClass.Device.PHONE_UNCATEGORIZED, "PHONE_UNCATEGORIZED")
        .value(BluetoothClass.Device.TOY_CONTROLLER, "TOY_CONTROLLER")
        .value(BluetoothClass.Device.TOY_DOLL_ACTION_FIGURE, "TOY_DOLL_ACTION_FIGURE")
        .value(BluetoothClass.Device.TOY_GAME, "TOY_GAME")
        .value(BluetoothClass.Device.TOY_ROBOT, "TOY_ROBOT")
        .value(BluetoothClass.Device.TOY_UNCATEGORIZED, "TOY_UNCATEGORIZED")
        .value(BluetoothClass.Device.TOY_VEHICLE, "TOY_VEHICLE")
        .value(BluetoothClass.Device.WEARABLE_GLASSES, "WEARABLE_GLASSES")
        .value(BluetoothClass.Device.WEARABLE_HELMET, "WEARABLE_HELMET")
        .value(BluetoothClass.Device.WEARABLE_JACKET, "WEARABLE_JACKET")
        .value(BluetoothClass.Device.WEARABLE_PAGER, "WEARABLE_PAGER")
        .value(BluetoothClass.Device.WEARABLE_UNCATEGORIZED, "WEARABLE_UNCATEGORIZED")
        .value(BluetoothClass.Device.WEARABLE_WRIST_WATCH, "WEARABLE_WRIST_WATCH")
        .get();
  }

  public static String majorDeviceClassToString(int majorDeviceClass) {
    return buildNamedValueString(majorDeviceClass)
        .value(BluetoothClass.Device.Major.AUDIO_VIDEO, "audio_video")
        .value(BluetoothClass.Device.Major.COMPUTER, "computer")
        .value(BluetoothClass.Device.Major.HEALTH, "health")
        .value(BluetoothClass.Device.Major.IMAGING, "imaging")
        .value(BluetoothClass.Device.Major.MISC, "misc")
        .value(BluetoothClass.Device.Major.NETWORKING, "networking")
        .value(BluetoothClass.Device.Major.PERIPHERAL, "peripheral")
        .value(BluetoothClass.Device.Major.PHONE, "phone")
        .value(BluetoothClass.Device.Major.TOY, "toy")
        .value(BluetoothClass.Device.Major.UNCATEGORIZED, "uncategorized")
        .value(BluetoothClass.Device.Major.WEARABLE, "wearable")
        .get();
  }

  public static String serviceToString(int service) {
    return buildNamedValueString(service)
        .value(BluetoothClass.Service.AUDIO, "audio")
        .value(BluetoothClass.Service.CAPTURE, "capture")
        .value(BluetoothClass.Service.INFORMATION, "information")
        .value(BluetoothClass.Service.LIMITED_DISCOVERABILITY, "limited_discoverability")
        .value(BluetoothClass.Service.NETWORKING, "networking")
        .value(BluetoothClass.Service.OBJECT_TRANSFER, "object_transfer")
        .value(BluetoothClass.Service.POSITIONING, "positioning")
        .value(BluetoothClass.Service.RENDER, "render")
        .value(BluetoothClass.Service.TELEPHONY, "telephony")
        .get();
  }

  public BluetoothClassSubject hasDeviceClass(int deviceClass) {
    int actualClass = actual().getDeviceClass();
    assert_()
        .withMessage("Expected device class <%s> but was <%s>.",
            deviceClassToString(deviceClass),
            deviceClassToString(actualClass))
        .that(actualClass)
        .isEqualTo(actualClass);
    return this;
  }

  public BluetoothClassSubject hasMajorDeviceClass(int majorDeviceClass) {
    int actualMajorDeviceClass = actual().getMajorDeviceClass();
    assert_()
        .withMessage("Expected major device class <%s> but was <%s>.",
            majorDeviceClassToString(majorDeviceClass),
            majorDeviceClassToString(actualMajorDeviceClass))
        .that(actualMajorDeviceClass)
        .isEqualTo(majorDeviceClass);
    return this;
  }

  public BluetoothClassSubject hasService(int service) {
    assertThat(actual().hasService(service))
        .named(String.format(Locale.ENGLISH, "has service <%s>", serviceToString(service)))
        .isTrue();
    return this;
  }

  public BluetoothClassSubject doesNotHaveService(int service) {
    assertThat(actual().hasService(service))
        .named(String.format(Locale.ENGLISH, "has service <%s>", serviceToString(service)))
        .isFalse();
    return this;
  }
}
