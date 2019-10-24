// Copyright 2019 PKWARE, Inc.
//
// This class is generated. Do not modify directly!
package com.pkware.truth.androidx.viewpager;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static com.google.common.truth.Truth.assertAbout;

/** Assertions for testing Android classes. */
@SuppressWarnings("deprecation")
public final class Assertions {
  @Nonnull
  public static com.pkware.truth.androidx.viewpager.widget.PagerAdapterSubject assertThat(
      @Nullable androidx.viewpager.widget.PagerAdapter target) {
    return assertAbout(com.pkware.truth.androidx.viewpager.widget.PagerAdapterSubject::new).that(target);
  }

  @Nonnull
  public static com.pkware.truth.androidx.viewpager.widget.ViewPagerSubject assertThat(
      @Nullable androidx.viewpager.widget.ViewPager target) {
    return assertAbout(com.pkware.truth.androidx.viewpager.widget.ViewPagerSubject::new).that(target);
  }

  private Assertions() {
    throw new AssertionError("No instances.");
  }
}
