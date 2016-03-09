/*
Copyright 2013 Square, Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */
package com.pkware.truth.android.internal;

import android.util.SparseArray;

import com.google.common.base.Joiner;

import java.util.LinkedHashMap;
import java.util.Map;

public final class IntegerUtils {
  private IntegerUtils() {
    throw new AssertionError("No instances.");
  }

  /**
   * Convenience builder for printing out a human-readable list of all of the individual values
   * in a bitmask.
   */
  public static BitMaskStringBuilder buildBitMaskString(int value) {
    return new BitMaskStringBuilder(value);
  }

  /**
   * Convenience builder for printing out a human-readable string of an integer.
   */
  public static NamedValueStringBuilder buildNamedValueString(int value) {
    return new NamedValueStringBuilder(value);
  }

  public static final class BitMaskStringBuilder {
    private final int value;
    private final Map<Integer, String> parts = new LinkedHashMap<>();

    private BitMaskStringBuilder(int value) {
      this.value = value;
    }

    public BitMaskStringBuilder flag(int flag, String flagName) {
      if ((value & flag) != 0) {
        if (parts.containsKey(flag)) {
          parts.put(flag, parts.get(flag) + "|" + flagName);
        } else {
          parts.put(flag, flagName);
        }
      }
      return this;
    }

    public String get() {
      if (value == 0) {
        return "none";
      }
      return Joiner.on(", ").join(parts.values());
    }
  }

  public static final class NamedValueStringBuilder {
    private final int value;
    private final SparseArray<String> valueNames = new SparseArray<>();

    private NamedValueStringBuilder(int value) {
      this.value = value;
    }

    public NamedValueStringBuilder value(int value, String name) {
      String dupe = valueNames.get(value);
      if (dupe != null) {
        throw new IllegalStateException(
            "Duplicate value " + value + " with name " + dupe + " and " + name);
      }
      valueNames.put(value, name);
      return this;
    }

    public String getOrValue() {
      return valueNames.get(value, String.valueOf(value));
    }

    public String get() {
      String name = valueNames.get(value);
      if (name == null) {
        throw new IllegalStateException("Unknown value: " + value);
      }
      return name;
    }
  }
}
