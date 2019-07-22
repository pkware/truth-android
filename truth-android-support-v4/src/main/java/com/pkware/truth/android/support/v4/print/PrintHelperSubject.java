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
package com.pkware.truth.android.support.v4.print;

import android.support.v4.print.PrintHelper;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import static android.support.v4.print.PrintHelper.COLOR_MODE_COLOR;
import static android.support.v4.print.PrintHelper.COLOR_MODE_MONOCHROME;
import static android.support.v4.print.PrintHelper.ORIENTATION_LANDSCAPE;
import static android.support.v4.print.PrintHelper.ORIENTATION_PORTRAIT;
import static android.support.v4.print.PrintHelper.SCALE_MODE_FILL;
import static android.support.v4.print.PrintHelper.SCALE_MODE_FIT;
import static com.google.common.truth.Truth.assert_;
import static com.pkware.truth.android.internal.IntegerUtils.buildNamedValueString;

/**
 * Propositions for {@link PrintHelper} subjects.
 */
public class PrintHelperSubject extends Subject<PrintHelperSubject, PrintHelper> {
  protected PrintHelperSubject(FailureMetadata failureMetadata, PrintHelper subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<PrintHelperSubject, PrintHelper> type() {
    return PrintHelperSubject::new;
  }

  public static String colorModeToString(@PrintHelperColorMode int colorMode) {
    return buildNamedValueString(colorMode)
        .value(COLOR_MODE_COLOR, "color")
        .value(COLOR_MODE_MONOCHROME, "monochrome")
        .get();
  }

  public static String orientationToString(@PrintHelperOrientation int orientation) {
    return buildNamedValueString(orientation)
        .value(ORIENTATION_LANDSCAPE, "landscape")
        .value(ORIENTATION_PORTRAIT, "portrait")
        .get();
  }

  public static String scaleModeToString(@PrintHelperScaleMode int scaleMode) {
    return buildNamedValueString(scaleMode)
        .value(SCALE_MODE_FILL, "fill")
        .value(SCALE_MODE_FIT, "fit")
        .get();
  }

  public PrintHelperSubject hasColorMode(@PrintHelperColorMode int colorMode) {
    int actualColorMode = actual().getColorMode();
    //noinspection ResourceType
    assert_()
        .withMessage("Expected color mode <%s> but was <%s>.",
            colorModeToString(colorMode), colorModeToString(actualColorMode))
        .that(actualColorMode)
        .isEqualTo(colorMode);
    return this;
  }

  public PrintHelperSubject hasOrientation(@PrintHelperOrientation int orientation) {
    int actualOrientation = actual().getOrientation();
    //noinspection ResourceType
    assert_()
        .withMessage("Expected orientation <%s> but was <%s>.",
            orientationToString(orientation), orientationToString(actualOrientation))
        .that(actualOrientation)
        .isEqualTo(orientation);
    return this;
  }

  public PrintHelperSubject hasScaleMode(@PrintHelperScaleMode int scaleMode) {
    int actualScaleMode = actual().getScaleMode();
    //noinspection ResourceType
    assert_()
        .withMessage("Expected scale mode <%s> but was <%s>.",
            scaleModeToString(scaleMode), scaleModeToString(actualScaleMode))
        .that(actualScaleMode)
        .isEqualTo(scaleMode);
    return this;
  }
}
