# Change Log

## Version 2.0.0-rc1 *(2019-10-10)*
This release marks a major milestone in that it moves to Truth stable, and migrates to AndroidX.

### Migrating
**Assertion chaining**
It used to be possible to write code like

```java
assertThat(layout).isVisible()
  .hasChildCount(4);
```

Now, this code must be written as

```java
assertThat(layout).isVisible();
assertThat(layout).hasChildCount(4);
```

Android Studio's [Structured Search/Replace](https://www.jetbrains.com/help/idea/structural-search-and-replace.html)
can be used effectively to migrate your code.

**Truth 1.0**
Truth 1.0 introduced significant API changes. See their [changelog](https://github.com/google/truth/releases)
for migration information.

**AndroidX**
AndroidX is the replacement for the Android Support Library. See their [migration guide](https://developer.android.com/jetpack/androidx/migrate)
for details on migrating your application.

### Changes
- Update Truth to version 1.0. This has breaking API changes.
- Migrate from Android Support Library to AndroidX. This has breaking API changes.
- Add nullability annotations. All `public` methods should be properly annotated for optimized
  interop with Kotlin.
- `Subject` methods no longer return a reference to the `Subject`. This means assertion chaining is
  no longer possible. This is more in line with how Truth itself works, rather than how AssertJ
  works.
- Multiple bug fixes in assertions.

## Version 1.1.0 *(2018-10-19)*
- Update Truth to version 0.42. This has breaking API changes
- Update Support Library. This has breaking API changes

## Version 1.0.0 *(2016-11-27)*
Feature parity with AssertJ Android