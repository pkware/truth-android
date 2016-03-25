/*
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

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

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
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assert_;
import static com.pkware.truth.android.internal.IntegerUtils.buildNamedValueString;

/**
 * Propositions for {@link Sensor} subjects.
 */
public class SensorSubject extends Subject<SensorSubject, Sensor> {
  protected SensorSubject(FailureStrategy failureStrategy, Sensor subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<SensorSubject, Sensor> type() {
    return new SubjectFactory<SensorSubject, Sensor>() {
      @Override
      public SensorSubject getSubject(FailureStrategy fs, Sensor that) {
        return new SensorSubject(fs, that);
      }
    };
  }

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

  public SensorSubject hasMaximumRange(float range, float tolerance) {
    assertThat(getSubject().getMaximumRange())
        .named("maximum range")
        .isWithin(tolerance)
        .of(range);
    return this;
  }

  public SensorSubject hasMinDelay(int delay) {
    assertThat(getSubject().getMinDelay())
        .named("minimum delay")
        .isEqualTo(delay);
    return this;
  }

  public SensorSubject hasName(String name) {
    assertThat(getSubject().getName())
        .named("name")
        .isEqualTo(name);
    return this;
  }

  public SensorSubject hasPower(float power, float tolerance) {
    assertThat(getSubject().getPower())
        .named("power")
        .isWithin(tolerance)
        .of(power);
    return this;
  }

  public SensorSubject hasResolution(float resolution, float tolerance) {
    assertThat(getSubject().getResolution())
        .named("resolution")
        .isWithin(tolerance)
        .of(resolution);
    return this;
  }

  public SensorSubject hasType(@SensorType int type) {
    int actualType = getSubject().getType();
    //noinspection ResourceType
    assert_()
        .withFailureMessage("Expected type <%s> but was <%s>.", typeToString(type), typeToString(actualType))
        .that(actualType)
        .isEqualTo(type);
    return this;
  }

  public SensorSubject hasVendor(String vendor) {
    assertThat(getSubject().getVendor())
        .named("vendor")
        .isEqualTo(vendor);
    return this;
  }

  public SensorSubject hasVersion(int version) {
    assertThat(getSubject().getVersion())
        .named("version")
        .isEqualTo(version);
    return this;
  }

  @TargetApi(KITKAT)
  public SensorSubject hasFifoMaxEventCount(int count) {
    assertThat(getSubject().getFifoMaxEventCount())
        .named("max event count")
        .isEqualTo(count);
    return this;
  }

  @TargetApi(KITKAT)
  public SensorSubject hasFifoReservedEventCount(int count) {
    assertThat(getSubject().getFifoReservedEventCount())
        .named("reserved event count")
        .isEqualTo(count);
    return this;
  }
}
