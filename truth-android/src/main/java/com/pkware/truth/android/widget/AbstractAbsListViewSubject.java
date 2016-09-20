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
package com.pkware.truth.android.widget;

import android.annotation.TargetApi;
import android.widget.AbsListView;

import com.google.common.truth.FailureStrategy;
import com.pkware.truth.android.util.SparseBooleanArraySubject;

import static android.os.Build.VERSION_CODES.KITKAT;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assert_;

public abstract class AbstractAbsListViewSubject<S extends AbstractAbsListViewSubject<S, T>, T extends AbsListView>
    extends AbstractAdapterViewSubject<S, T> {
  protected AbstractAbsListViewSubject(FailureStrategy failureStrategy, T subject) {
    super(failureStrategy, subject);
  }

  static String scrollDirectionToString(int direction) {
    if (direction == 0) {
      throw new IllegalArgumentException("direction must be positive or negative");
    } else if (direction < 0) {
      return "up";
    } else {
      return "down";
    }
  }

  public S hasCheckedItemsCount(int count) {
    assertThat(actual().getCheckedItemCount())
        .named("checked item count")
        .isEqualTo(count);
    //noinspection unchecked
    return (S) this;
  }

  public S containsItemIds(long... itemIds) {
    assertThat(actual().getCheckedItemIds())
        .asList()
        .contains(itemIds);
    //noinspection unchecked
    return (S) this;
  }

  public S hasCheckedItemPosition(int position) {
    assertThat(actual().getCheckedItemPosition()).isEqualTo(position);
    //noinspection unchecked
    return (S) this;
  }

  public S containsCheckedItemPositions(int... positions) {
    for (int position : positions) {
      assert_()
          .about(SparseBooleanArraySubject.type())
          .that(actual().getCheckedItemPositions())
          .keyIsTrue(position);
    }
    //noinspection unchecked
    return (S) this;
  }

  @TargetApi(KITKAT)
  public S canScrollList(int direction) {
    assert_()
        .withFailureMessage("Expected to be able to scroll <%s> but cannot.",
            scrollDirectionToString(direction))
        .that(actual().canScrollList(direction))
        .isTrue();
    //noinspection unchecked
    return (S) this;
  }
}
