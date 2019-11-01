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
package com.pkware.truth.androidx.print;

import androidx.print.PrintHelper;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static androidx.print.PrintHelper.COLOR_MODE_COLOR;
import static androidx.print.PrintHelper.COLOR_MODE_MONOCHROME;
import static androidx.print.PrintHelper.ORIENTATION_LANDSCAPE;
import static androidx.print.PrintHelper.ORIENTATION_PORTRAIT;
import static androidx.print.PrintHelper.SCALE_MODE_FILL;
import static androidx.print.PrintHelper.SCALE_MODE_FIT;
import static com.pkware.truth.android.internal.IntegerUtils.buildNamedValueString;

/**
 * Propositions for {@link PrintHelper} subjects.
 */
public class PrintHelperSubject extends Subject {

  @Nullable
  private final PrintHelper actual;

  public PrintHelperSubject(@Nonnull FailureMetadata failureMetadata, @Nullable PrintHelper actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  @Nonnull
  public static String colorModeToString(@PrintHelperColorMode int colorMode) {
    return buildNamedValueString(colorMode)
        .value(COLOR_MODE_COLOR, "color")
        .value(COLOR_MODE_MONOCHROME, "monochrome")
        .get();
  }

  @Nonnull
  public static String orientationToString(@PrintHelperOrientation int orientation) {
    return buildNamedValueString(orientation)
        .value(ORIENTATION_LANDSCAPE, "landscape")
        .value(ORIENTATION_PORTRAIT, "portrait")
        .get();
  }

  @Nonnull
  public static String scaleModeToString(@PrintHelperScaleMode int scaleMode) {
    return buildNamedValueString(scaleMode)
        .value(SCALE_MODE_FILL, "fill")
        .value(SCALE_MODE_FIT, "fit")
        .get();
  }

  public void hasColorMode(@PrintHelperColorMode int colorMode) {
    int actualColorMode = actual.getColorMode();
    //noinspection ResourceType
    check("getColorMode()")
        .withMessage("Expected color mode <%s> but was <%s>.",
            colorModeToString(colorMode), colorModeToString(actualColorMode))
        .that(actualColorMode)
        .isEqualTo(colorMode);
  }

  public void hasOrientation(@PrintHelperOrientation int orientation) {
    int actualOrientation = actual.getOrientation();
    //noinspection ResourceType
    check("getOrientation()")
        .withMessage("Expected orientation <%s> but was <%s>.",
            orientationToString(orientation), orientationToString(actualOrientation))
        .that(actualOrientation)
        .isEqualTo(orientation);
  }

  public void hasScaleMode(@PrintHelperScaleMode int scaleMode) {
    int actualScaleMode = actual.getScaleMode();
    //noinspection ResourceType
    check("getScaleMode()")
        .withMessage("Expected scale mode <%s> but was <%s>.",
            scaleModeToString(scaleMode), scaleModeToString(actualScaleMode))
        .that(actualScaleMode)
        .isEqualTo(scaleMode);
  }
}
