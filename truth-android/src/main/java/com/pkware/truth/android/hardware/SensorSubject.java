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
package com.pkware.truth.android.hardware;

import android.annotation.TargetApi;
import android.hardware.Sensor;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.hardware.Sensor.TYPE_ACCELEROMETER;
import static android.hardware.Sensor.TYPE_ALL;
import static android.hardware.Sensor.TYPE_AMBIENT_TEMPERATURE;
import static android.hardware.Sensor.TYPE_GAME_ROTATION_VECTOR;
import static android.hardware.Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR;
import static android.hardware.Sensor.TYPE_GRAVITY;
import static android.hardware.Sensor.TYPE_GYROSCOPE;
import static android.hardware.Sensor.TYPE_GYROSCOPE_UNCALIBRATED;
import static android.hardware.Sensor.TYPE_HEART_RATE;
import static android.hardware.Sensor.TYPE_LIGHT;
import static android.hardware.Sensor.TYPE_LINEAR_ACCELERATION;
import static android.hardware.Sensor.TYPE_MAGNETIC_FIELD;
import static android.hardware.Sensor.TYPE_MAGNETIC_FIELD_UNCALIBRATED;
import static android.hardware.Sensor.TYPE_ORIENTATION;
import static android.hardware.Sensor.TYPE_PRESSURE;
import static android.hardware.Sensor.TYPE_PROXIMITY;
import static android.hardware.Sensor.TYPE_RELATIVE_HUMIDITY;
import static android.hardware.Sensor.TYPE_ROTATION_VECTOR;
import static android.hardware.Sensor.TYPE_SIGNIFICANT_MOTION;
import static android.hardware.Sensor.TYPE_STEP_COUNTER;
import static android.hardware.Sensor.TYPE_STEP_DETECTOR;
import static android.hardware.Sensor.TYPE_TEMPERATURE;
import static android.os.Build.VERSION_CODES.KITKAT;
import static com.pkware.truth.android.internal.IntegerUtils.buildNamedValueString;

/**
 * Propositions for {@link Sensor} subjects.
 */
public class SensorSubject extends Subject {

  @Nullable
  private final Sensor actual;

  public SensorSubject(@Nonnull FailureMetadata failureMetadata, @Nullable Sensor actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  @Nonnull
  public static String typeToString(@SensorType int type) {
    return buildNamedValueString(type)
        .value(TYPE_ACCELEROMETER, "accelerometer")
        .value(TYPE_ALL, "all")
        .value(TYPE_AMBIENT_TEMPERATURE, "ambient_temperature")
        .value(TYPE_GAME_ROTATION_VECTOR, "game_rotation_vector")
        .value(TYPE_GEOMAGNETIC_ROTATION_VECTOR, "geomagnetic_rotation_vector")
        .value(TYPE_GRAVITY, "gravity")
        .value(TYPE_GYROSCOPE, "gyroscope")
        .value(TYPE_GYROSCOPE_UNCALIBRATED, "gyroscope_uncalibrated")
        .value(TYPE_HEART_RATE, "heart_rate")
        .value(TYPE_LIGHT, "light")
        .value(TYPE_LINEAR_ACCELERATION, "linear_acceleration")
        .value(TYPE_MAGNETIC_FIELD, "magnetic_field")
        .value(TYPE_MAGNETIC_FIELD_UNCALIBRATED, "magnetic_field_uncalibrated")
        .value(TYPE_ORIENTATION, "orientation")
        .value(TYPE_PRESSURE, "pressure")
        .value(TYPE_PROXIMITY, "proximity")
        .value(TYPE_RELATIVE_HUMIDITY, "relative_humidity")
        .value(TYPE_ROTATION_VECTOR, "rotation_vector")
        .value(TYPE_SIGNIFICANT_MOTION, "significant_motion")
        .value(TYPE_STEP_COUNTER, "step_counter")
        .value(TYPE_STEP_DETECTOR, "step_detector")
        .value(TYPE_TEMPERATURE, "temperature")
        .get();
  }

  public void hasMaximumRange(float range, float tolerance) {
    check("getMaximumRange()").that(actual.getMaximumRange()).isWithin(tolerance).of(range);
  }

  public void hasMinDelay(int delay) {
    check("getMinDelay()").that(actual.getMinDelay()).isEqualTo(delay);
  }

  public void hasName(@Nullable String name) {
    check("getName()").that(actual.getName()).isEqualTo(name);
  }

  public void hasPower(float power, float tolerance) {
    check("getPower()").that(actual.getPower()).isWithin(tolerance).of(power);
  }

  public void hasResolution(float resolution, float tolerance) {
    check("getResolution()").that(actual.getResolution()).isWithin(tolerance).of(resolution);
  }

  public void hasType(@SensorType int type) {
    int actualType = actual.getType();
    //noinspection ResourceType
    check("getType()")
        .withMessage("Expected type <%s> but was <%s>.", typeToString(type), typeToString(actualType))
        .that(actualType)
        .isEqualTo(type);
  }

  public void hasVendor(@Nullable String vendor) {
    check("getVendor()").that(actual.getVendor()).isEqualTo(vendor);
  }

  public void hasVersion(int version) {
    check("getVersion()").that(actual.getVersion()).isEqualTo(version);
  }

  @TargetApi(KITKAT)
  public void hasFifoMaxEventCount(int count) {
    check("getFifoMaxEventCount()").that(actual.getFifoMaxEventCount()).isEqualTo(count);
  }

  @TargetApi(KITKAT)
  public void hasFifoReservedEventCount(int count) {
    check("getFifoReservedEventCount()").that(actual.getFifoReservedEventCount()).isEqualTo(count);
  }
}
