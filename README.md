Truth Android
===============

A set of Truth assertions geared toward testing Android.

Writing tests is not the most glamorous part of developing an Android
application but it is an invaluable one. Using libraries like JUnit and Truth
provide a great starting point for writing tests.

This library is an extension of [Truth][1] which aims to make it even easier to test
Android.



Examples
--------

 *  Truth Android:

    ```java
    assertThat(view).isGone();
    ```

 *  Regular JUnit:

    ```java
    assertEquals(View.GONE, view.getVisibility());
    ```

 *  Regular Truth:

    ```java
    assertThat(view.getVisibility()).isEqualTo(View.GONE);
    ```

When failing, the _Truth Android_ assertion produces an output which allows you
to immediately recognize the problem:
`Expected visibility <gone> but was <invisible>`.

Compare that to the output of regular _Truth_ `Expected:<[8]> but was:<[4]>` and
regular _JUnit_ `Expected: <8> but was: <4>` and you should immediately see the
advantage.


Because _Truth Android_ offers assertions directly on objects rather than
properties they can be chained together.

 *  Truth Android:

    ```java
    assertThat(layout).isVisible()
        .isVertical()
        .hasChildCount(4)
        .hasShowDividers(SHOW_DIVIDERS_MIDDLE);
    ```

 *  Regular JUnit:

    ```java
    assertEquals(View.VISIBLE, layout.getVisibility());
    assertEquals(VERTICAL, layout.getOrientation());
    assertEquals(4, layout.getChildCount());
    assertEquals(SHOW_DIVIDERS_MIDDLE, layout.getShowDividers());
    ```

 *  Regular Truth:

    ```java
    assertThat(layout.getVisibility()).isEqualTo(View.VISIBLE);
    assertThat(layout.getOrientation()).isEqualTo(VERTICAL);
    assertThat(layout.getChildCount()).isEqualTo(4);
    assertThat(layout.getShowDividers()).isEqualTo(SHOW_DIVIDERS_MIDDLE);
    ```

Assertions exist for nearly every object that you would ever want to test, from
`LinearLayout` to `ActionBar` to `Fragment` to `MenuItem`. Everything in the
support library is included too.

To get started writing tests add the following import:

```java
import static com.pkware.truth.android.Assertions.assertThat;
```



Add-On Modules
--------------

Modules are also provided for the add-on Android libraries. Add the dependency
(listed below) and use the following imports:

 * support-v4: `import static com.pkware.truth.android.support.v4.Assertions.assertThat;`
 * play-services: `import static com.pkware.truth.android.playservices.Assertions.assertThat;`
 * appcompat-v7: `import static com.pkware.truth.android.appcompat.v7.Assertions.assertThat;`
 * mediarouter-v7: `import static com.pkware.truth.android.mediarouter.v7.Assertions.assertThat;`
 * gridlayout-v7: `import static com.pkware.truth.android.gridlayout.v7.Assertions.assertThat;`
 * cardview-v7: `import static com.pkware.truth.android.cardview.v7.Assertions.assertThat;`
 * recyclerview-v7: `import static com.pkware.truth.android.recyclerview.v7.Assertions.assertThat;`
 * palette-v7: `import static com.pkware.truth.android.palette.v7.Assertions.assertThat;`
 * design:  `import static com.pkware.truth.android.design.Assertions.assertThat;`


Extending
---------

The provided assertions have also been designed to be extended for any custom
controls you have developed.

```java
public class CustomLayout extends LinearLayout {
  public int getBehavior() {
    /* ... */
  }
}
```

Use the following pattern to set up your assertions.

```java
public final class CustomLayoutSubject extends AbstractLinearLayoutSubject<CustomLayoutSubject, CustomLayout> {
  private static final SubjectFactory<CustomLayoutSubject, CustomLayout> CUSTOM_LAYOUT_SUBJECT_FACTORY =
      new SubjectFactory<CustomLayoutSubject, CustomLayout>() {
        @Override
        public CustomLayoutSubject getSubject(FailureStrategy failureStrategy, @Nullable CustomLayout target) {
          return new CustomLayoutSubject(failureStrategy, target);
        }
      };

  public static CustomLayoutSubject assertThat(@Nullable CustomLayout actual) {
    return assertAbout(CUSTOM_LAYOUT_SUBJECT_FACTORY).that(actual);
  }

  private CustomLayoutSubject(FailureStrategy failureStrategy, CustomLayout subject) {
    super(failureStrategy, subject);
  }

  public CustomLayoutSubject hasSomeBehavior() {
    assertThat(actual().getBehavior())
        .withFailureMessage("Expected some behavior but was doing other behavior.")
        .isEqualTo(42)
    return this;
  }
}
```

Now static import `CustomLayoutSubject.assertThat` in your test classes.

For more information about writing custom assertions see the [official documentation][2].



Download
--------

Android module:
```groovy
androidTestCompile 'com.pkware.truth-android:truth-android:{latestVersion}'
```

support-v4 module:
```groovy
androidTestCompile 'com.pkware.truth-android:truth-android-support-v4:{latestVersion}'
```

Google Play Services module:
```groovy
androidTestCompile 'com.pkware.truth-android:truth-android-play-services:{latestVersion}'
```

appcompat-v7 module:
```groovy
androidTestCompile 'com.pkware.truth-android:truth-android-appcompat-v7:{latestVersion}'
```

Design library module:
```groovy
androidTestCompile 'com.pkware.truth-android:truth-android-design:{latestVersion}'
```

mediarouter-v7 module:
```groovy
androidTestCompile 'com.pkware.truth-android:truth-android-mediarouter-v7:{latestVersion}'
```

gridlayout-v7 module:
```groovy
androidTestCompile 'com.pkware.truth-android:truth-android-gridlayout-v7:{latestVersion}'
```

cardview-v7 module:
```groovy
androidTestCompile 'com.pkware.truth-android:truth-android-cardview-v7:{latestVersion}'
```

recyclerview-v7 module:
```groovy
androidTestCompile 'com.pkware.truth-android:truth-android-recyclerview-v7:{latestVersion}'
```

palette-v7 module:
```groovy
androidTestCompile 'com.pkware.truth-android:truth-android-palette-v7:{latestVersion}'
```

Snapshots of the development version are available in [Sonatype's `snapshots` repository][snap].



License
-------

    Copyright 2016 PKWARE, Inc.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.




 [1]: https://google.github.io/truth/
 [2]: https://google.github.io/truth/extension
 [snap]: https://oss.sonatype.org/content/repositories/snapshots/