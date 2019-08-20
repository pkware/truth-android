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
package com.pkware.truth.android.view.animation;

import android.view.animation.GridLayoutAnimationController;

import com.google.common.collect.Iterables;
import com.google.common.truth.FailureMetadata;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.view.animation.GridLayoutAnimationController.DIRECTION_BOTTOM_TO_TOP;
import static android.view.animation.GridLayoutAnimationController.DIRECTION_HORIZONTAL_MASK;
import static android.view.animation.GridLayoutAnimationController.DIRECTION_RIGHT_TO_LEFT;
import static android.view.animation.GridLayoutAnimationController.DIRECTION_VERTICAL_MASK;
import static android.view.animation.GridLayoutAnimationController.PRIORITY_COLUMN;
import static android.view.animation.GridLayoutAnimationController.PRIORITY_NONE;
import static android.view.animation.GridLayoutAnimationController.PRIORITY_ROW;
import static com.pkware.truth.android.internal.IntegerUtils.buildNamedValueString;

/**
 * Propositions for {@link GridLayoutAnimationController} subjects.
 */
public class GridLayoutAnimationControllerSubject extends
    AbstractLayoutAnimationControllerSubject<GridLayoutAnimationController> {

  @Nullable
  private final GridLayoutAnimationController actual;

  public GridLayoutAnimationControllerSubject(@Nonnull FailureMetadata failureMetadata, @Nullable GridLayoutAnimationController actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  @Nonnull
  private static String directionToString(@GridLayoutAnimationControllerDirection int direction) {
    List<String> parts = new ArrayList<>();
    int horizontal = direction & DIRECTION_HORIZONTAL_MASK;
    int vertical = direction & DIRECTION_VERTICAL_MASK;
    if ((horizontal & DIRECTION_RIGHT_TO_LEFT) != 0) {
      parts.add("rightToLeft");
    } else {
      parts.add("leftToRight");
    }
    if ((vertical & DIRECTION_BOTTOM_TO_TOP) != 0) {
      parts.add("bottomToTop");
    } else {
      parts.add("topToBottom");
    }
    return Iterables.toString(parts);
  }

  @Nonnull
  public static String directionPriorityToString(@GridLayoutAnimationControllerDirectionPriority int priority) {
    return buildNamedValueString(priority)
        .value(PRIORITY_NONE, "none")
        .value(PRIORITY_COLUMN, "column")
        .value(PRIORITY_ROW, "row")
        .get();
  }

  public GridLayoutAnimationControllerSubject hasColumnDelay(float delay, float tolerance) {
    check("getColumnDelay()").that(actual.getColumnDelay()).isWithin(tolerance).of(delay);
    return this;
  }

  public GridLayoutAnimationControllerSubject hasDirection(@GridLayoutAnimationControllerDirection int direction) {
    int actualDirection = actual.getDirection();
    //noinspection ResourceType
    check("getDirection()")
        .withMessage("Expected direction <%s> but was <%s>.",
            directionToString(direction), directionToString(actualDirection))
        .that(actualDirection)
        .isEqualTo(direction);
    return this;
  }

  public GridLayoutAnimationControllerSubject hasDirectionPriority(@GridLayoutAnimationControllerDirectionPriority int priority) {
    int actualPriority = actual.getDirectionPriority();
    //noinspection ResourceType
    check("getDirectionPriority()")
        .withMessage("Expected direction priority <%s> but was <%s>.",
            directionPriorityToString(priority), directionPriorityToString(actualPriority))
        .that(actualPriority)
        .isEqualTo(priority);
    return this;
  }

  public GridLayoutAnimationControllerSubject hasRowDelay(float delay, float tolerance) {
    check("getRowDelay()").that(actual.getRowDelay()).isWithin(tolerance).of(delay);
    return this;
  }
}
