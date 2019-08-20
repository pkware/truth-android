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
package com.pkware.truth.android.widget;

import android.annotation.TargetApi;
import android.widget.AbsListView;

import com.google.common.primitives.Longs;
import com.google.common.truth.FailureMetadata;
import com.pkware.truth.android.util.SparseBooleanArraySubject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static android.os.Build.VERSION_CODES.KITKAT;

public abstract class AbstractAbsListViewSubject<T extends AbsListView>
    extends AbstractAdapterViewSubject<T> {

  @Nullable
  private final T actual;

  protected AbstractAbsListViewSubject(@Nonnull FailureMetadata failureMetadata, T actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  @Nonnull
  static String scrollDirectionToString(int direction) {
    if (direction == 0) {
      throw new IllegalArgumentException("direction must be positive or negative");
    } else if (direction < 0) {
      return "up";
    } else {
      return "down";
    }
  }

  public void hasCheckedItemsCount(int count) {
    check("getCheckedItemCount()").that(actual.getCheckedItemCount()).isEqualTo(count);
  }

  public void containsItemIds(@Nonnull long... itemIds) {
    check("getCheckedItemIds()").that(actual.getCheckedItemIds()).asList().containsAtLeastElementsIn(Longs.asList(itemIds));
  }

  public void hasCheckedItemPosition(int position) {
    check("getCheckedItemPosition()").that(actual.getCheckedItemPosition()).isEqualTo(position);
  }

  public void containsCheckedItemPositions(int... positions) {
    for (int position : positions) {
      check("getCheckedItemPositions()").about(SparseBooleanArraySubject::new).that(actual.getCheckedItemPositions()).keyIsTrue(position);
    }
  }

  @TargetApi(KITKAT)
  public void canScrollList(int direction) {
    check("canScrollList(direction)")
        .withMessage("Expected to be able to scroll <%s> but cannot.",
            scrollDirectionToString(direction))
        .that(actual.canScrollList(direction))
        .isTrue();
  }
}
