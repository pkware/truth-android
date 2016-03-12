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
package com.pkware.truth.android.view;

import android.annotation.TargetApi;
import android.view.View;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;

import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR1;
import static android.view.View.GONE;
import static android.view.View.INVISIBLE;
import static android.view.View.LAYER_TYPE_HARDWARE;
import static android.view.View.LAYER_TYPE_NONE;
import static android.view.View.LAYER_TYPE_SOFTWARE;
import static android.view.View.LAYOUT_DIRECTION_INHERIT;
import static android.view.View.LAYOUT_DIRECTION_LOCALE;
import static android.view.View.LAYOUT_DIRECTION_LTR;
import static android.view.View.LAYOUT_DIRECTION_RTL;
import static android.view.View.OVER_SCROLL_ALWAYS;
import static android.view.View.OVER_SCROLL_IF_CONTENT_SCROLLS;
import static android.view.View.OVER_SCROLL_NEVER;
import static android.view.View.SCROLLBARS_INSIDE_INSET;
import static android.view.View.SCROLLBARS_INSIDE_OVERLAY;
import static android.view.View.SCROLLBARS_OUTSIDE_INSET;
import static android.view.View.SCROLLBARS_OUTSIDE_OVERLAY;
import static android.view.View.SCROLLBAR_POSITION_DEFAULT;
import static android.view.View.SCROLLBAR_POSITION_LEFT;
import static android.view.View.SCROLLBAR_POSITION_RIGHT;
import static android.view.View.TEXT_ALIGNMENT_CENTER;
import static android.view.View.TEXT_ALIGNMENT_GRAVITY;
import static android.view.View.TEXT_ALIGNMENT_INHERIT;
import static android.view.View.TEXT_ALIGNMENT_TEXT_END;
import static android.view.View.TEXT_ALIGNMENT_TEXT_START;
import static android.view.View.TEXT_ALIGNMENT_VIEW_END;
import static android.view.View.TEXT_ALIGNMENT_VIEW_START;
import static android.view.View.TEXT_DIRECTION_ANY_RTL;
import static android.view.View.TEXT_DIRECTION_FIRST_STRONG;
import static android.view.View.TEXT_DIRECTION_INHERIT;
import static android.view.View.TEXT_DIRECTION_LOCALE;
import static android.view.View.TEXT_DIRECTION_LTR;
import static android.view.View.TEXT_DIRECTION_RTL;
import static android.view.View.VISIBLE;
import static com.pkware.truth.android.internal.IntegerUtils.buildNamedValueString;

public abstract class AbstractViewSubject<S extends AbstractViewSubject<S, T>, T extends View> extends Subject<S, T> {
  protected AbstractViewSubject(FailureStrategy failureStrategy, T subject) {
    super(failureStrategy, subject);
  }

  public static String visibilityToString(@ViewVisibility int visibility) {
    return buildNamedValueString(visibility)
        .value(VISIBLE, "visible")
        .value(INVISIBLE, "invisible")
        .value(GONE, "gone")
        .get();
  }

  public static String layerTypeToString(@ViewLayerType int type) {
    return buildNamedValueString(type)
        .value(LAYER_TYPE_NONE, "none")
        .value(LAYER_TYPE_SOFTWARE, "software")
        .value(LAYER_TYPE_HARDWARE, "hardware")
        .get();
  }

  @TargetApi(JELLY_BEAN_MR1)
  public static String layoutDirectionToString(@ViewLayoutDirection int direction) {
    return buildNamedValueString(direction)
        .value(LAYOUT_DIRECTION_RTL, "right_to_left")
        .value(LAYOUT_DIRECTION_LTR, "left_to_right")
        .value(LAYOUT_DIRECTION_INHERIT, "inherit")
        .value(LAYOUT_DIRECTION_LOCALE, "locale")
        .get();
  }

  public static String overScrollModeToString(@ViewOverscrollMode int mode) {
    return buildNamedValueString(mode)
        .value(OVER_SCROLL_ALWAYS, "always")
        .value(OVER_SCROLL_IF_CONTENT_SCROLLS, "ifContentScrolls")
        .value(OVER_SCROLL_NEVER, "never")
        .get();
  }

  public static String scrollBarStyleToString(@ViewScrollBarStyle int style) {
    return buildNamedValueString(style)
        .value(SCROLLBARS_INSIDE_INSET, "insideInset")
        .value(SCROLLBARS_INSIDE_OVERLAY, "insideOverlay")
        .value(SCROLLBARS_OUTSIDE_INSET, "outsideInset")
        .value(SCROLLBARS_OUTSIDE_OVERLAY, "outsideOverlay")
        .get();
  }

  public static String verticalScrollBarPositionToString(@ViewScrollBarPosition int position) {
    return buildNamedValueString(position)
        .value(SCROLLBAR_POSITION_DEFAULT, "default")
        .value(SCROLLBAR_POSITION_LEFT, "left")
        .value(SCROLLBAR_POSITION_RIGHT, "right")
        .get();
  }

  public static String textAlignmentToString(@ViewTextAlignment int alignment) {
    return buildNamedValueString(alignment)
        .value(TEXT_ALIGNMENT_INHERIT, "inherit")
        .value(TEXT_ALIGNMENT_GRAVITY, "gravity")
        .value(TEXT_ALIGNMENT_TEXT_START, "text_start")
        .value(TEXT_ALIGNMENT_TEXT_END, "text_end")
        .value(TEXT_ALIGNMENT_CENTER, "center")
        .value(TEXT_ALIGNMENT_VIEW_START, "view_start")
        .value(TEXT_ALIGNMENT_VIEW_END, "view_end")
        .get();
  }

  public static String textDirectionToString(@ViewTextDirection int direction) {
    return buildNamedValueString(direction)
        .value(TEXT_DIRECTION_INHERIT, "inherit")
        .value(TEXT_DIRECTION_FIRST_STRONG, "first_strong")
        .value(TEXT_DIRECTION_ANY_RTL, "any_right_to_left")
        .value(TEXT_DIRECTION_LTR, "left_to_right")
        .value(TEXT_DIRECTION_RTL, "right_to_left")
        .value(TEXT_DIRECTION_LOCALE, "locale")
        .get();
  }
}
